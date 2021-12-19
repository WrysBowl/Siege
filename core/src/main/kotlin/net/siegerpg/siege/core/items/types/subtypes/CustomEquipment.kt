package net.siegerpg.siege.core.items.types.subtypes

import de.tr7zw.nbtapi.NBTItem
import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.getNbtTag
import net.siegerpg.siege.core.items.setNbtTags
import net.siegerpg.siege.core.items.statgems.StatGem
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.items.types.misc.Cosmetic
import net.siegerpg.siege.core.listeners.NPC.Herbert
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.core.miscellaneous.lore
import net.siegerpg.siege.core.miscellaneous.name
import org.bukkit.Bukkit
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack


interface CustomEquipment : CustomItem {

	var statGem : StatGem?
	val baseStats : HashMap<StatTypes, Double>

	fun addStatGem(newStatGem : StatGem) {
		this.statGem = newStatGem
		this.serialize()
	}

	fun removeStatGem() {
		this.statGem = null
		this.serialize()
	}

	fun hasGem() : Boolean {
		if (this.statGem == null) {
			return false
		}
		return true
	}

	override fun updateMeta(hideRarity : Boolean) : ItemStack {
		if (this is CustomHelmet) {
			val cosmetic : CustomItem? = CustomItemUtils.getCustomItem(this.storedItem)
			if (cosmetic is Cosmetic) {
				this.material = cosmetic.material
				this.customModelData = cosmetic.customModelData
				this.leatherColor = cosmetic.leatherColor
			}
		}
		val meta = item.itemMeta

		val shownRarity = if (hideRarity) Rarity.UNCOMMON else rarity

		meta.name(if (shownRarity == Rarity.SPECIAL) "<r><rainbow><b>$name</b></rainbow>" else "<r>${shownRarity.color}$name")

		if (meta.hasLore()) meta.lore(mutableListOf())

		if (hideRarity || quality < 0) {
			meta.lore("<r><yellow>Rarity <gray>1-100%")
		} else {
			meta.lore(if (shownRarity == Rarity.SPECIAL) "<r><rainbow><b>${shownRarity.id}</b></rainbow> <gray>${quality}%" else "<r>${shownRarity.color}${shownRarity.id} <gray>${quality}%")
		}

		statGem?.let {
			meta.lore(" ")
			meta.lore("<r><color:#F67DF6>+${it.amount} <light_purple>${it.type.stylizedName}")
		}
		if (baseStats.size != 0) {
			meta.lore(" ")
			val realStats =
					CustomItemUtils.getStats(this, addGem = false, addRarity = true)
			baseStats.keys.forEach {
				if (realStats[it]!! < 0.0) {
					if (hideRarity || quality < 0)
						meta.lore(
								"<r><red>${baseStats[it]?.times(0.5)}. . . -${
									baseStats[it]?.times(
											1.5
									                    )
								} <gray>${it.stylizedName}"
						         )
					else {
						meta.lore("<r><red>${realStats[it]} <gray>${it.stylizedName}")					}
				} else {
					if (hideRarity || quality < 0) {
						meta.lore(
								"<r><green>+${baseStats[it]?.times(0.5)}. . .${
									baseStats[it]?.times(
											1.5
									                    )
								} <gray>${it.stylizedName}"
						         )
					} else {
						meta.lore("<r><green>+${realStats[it]} <gray>${it.stylizedName}")					}

				}
			}
		}
		meta.lore("<underlined><dark_gray>                    ")
		meta.lore(" ")
		Utils.getTextArray(description, 16).forEach {
			meta.lore("<r><dark_gray>$it")
		}
		meta.lore("<underlined><dark_gray>                    ")
		meta.lore(" ")
		meta.lore("<r><gray>Level <color:#BC74EE>$levelRequirement     <r><color:#E2DE5D>${Herbert.getSellValue(item)} \u26C1")

		meta.isUnbreakable = true
		meta.addItemFlags(
				ItemFlag.HIDE_ATTRIBUTES,
				ItemFlag.HIDE_UNBREAKABLE,
				ItemFlag.HIDE_ENCHANTS,
				ItemFlag.HIDE_DYE
		                 )
		item.itemMeta = meta
		return item
	}

	override fun serialize() {
		super.serialize()
		item = item.setNbtTags(
				"equipmentStatGem" to if (statGem != null) statGem.toString() else null)
	}

	fun onHit(e : EntityDamageByEntityEvent) {
		// placeholder for optional event
	}

	fun onHit(e : EntityDamageEvent) {
		// placeholder for optional event
	}

	fun onInteract(e : PlayerInteractEvent) {
		// placeholder for optional event
	}

	override fun deserialize() {
		super.deserialize()
		try {
			item.getNbtTag<String>("equipmentStatGem")?.let {
				statGem = StatGem.fromString(it)
			}
		} catch (e : Exception) { }

	}
}