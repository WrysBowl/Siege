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
import org.bukkit.event.entity.EntityShootBowEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerToggleSneakEvent
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta


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
		if (statGem == null) {
			meta.lore(" ")
			meta.lore("<dark_gray>\u25C7 <italic>Gem Slot")
		}

		if (this is CustomWeapon) {
			item.itemMeta = displaySkillText(meta)
		}

		if (baseStats.size != 0) {
			item.itemMeta = statFormat(meta, hideRarity)
		}
		val length =
				if (name.length > 16) name.length
				else 16
		meta.lore(" ")
		Utils.getTextArray(description, length).forEach {
			meta.lore("<r><dark_gray>$it")
		}
		meta.lore(" ")
		meta.lore(
				"<r><gray>Level <color:#BC74EE>$levelRequirement   <r><color:#E2DE5D>${
					String.format(
							"%,d",
							getSellValue()
					             )
				} \u26C1"
		         )

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

	fun statFormat(meta : ItemMeta, hideRarity : Boolean) : ItemMeta {
		meta.lore(" ")
		val realStats =
				CustomItemUtils.getStats(this, addGem = false, addRarity = true)
		val stats : HashMap<StatTypes, Double> = Utils.sortByValue(baseStats)
		stats.keys.forEach {
			if (realStats[it]!! < 0.0) {
				if (hideRarity || quality < 0)
					meta.lore(
							"<r><red>${stats[it]?.times(0.5)}. . . ${
								stats[it]?.times(
										1.5
								                )
							} <gray>${it.stylizedName}"
					         )
				else {
					meta.lore("<r><red>${realStats[it]} <gray>${it.stylizedName}")
				}
			} else {
				if (hideRarity || quality < 0) {
					meta.lore(
							"<r><green>+${stats[it]?.times(0.5)}. . .${
								stats[it]?.times(
										1.5
								                )
							} <gray>${it.stylizedName}"
					         )
				} else {
					meta.lore("<r><green>+${realStats[it]} <gray>${it.stylizedName}")
				}

			}
		}
		return meta
	}

	override fun serialize() {
		super.serialize()
		item = item.setNbtTags(
				"equipmentStatGem" to if (statGem != null) statGem.toString() else null
		                      )
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

	fun onSneak(e : PlayerToggleSneakEvent) {
		// placeholder for optional event
	}

	override fun getSellValue() : Int {
		return ((levelRequirement ?: 1) * quality) / 5
	}

	override fun deserialize() {
		super.deserialize()
		try {
			item.getNbtTag<String>("equipmentStatGem")?.let {
				statGem = StatGem.fromString(it)
			}
		} catch (e : Exception) {
		}

	}
}