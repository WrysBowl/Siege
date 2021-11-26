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
import net.siegerpg.siege.core.miscellaneous.lore
import net.siegerpg.siege.core.miscellaneous.name
import org.bukkit.Bukkit
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack


interface CustomEquipment : CustomItem {

	var statGem : StatGem?
	val baseStats : HashMap<StatTypes, Double>
	var upgradeStats : HashMap<StatTypes, Double>?

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

	fun addUpgradeStats(upgrades : HashMap<StatTypes, Double>) {
		for (baseStat in baseStats) {
			//only allow upgraded stats to add if base stat for it exists
			if (!upgrades.containsKey(baseStat.key)) continue
			val upgradeValue : Double = upgrades[baseStat.key] ?: 0.0
			val originalValue : Double = this.upgradeStats?.get(baseStat.key) ?: 0.0
			if (upgradeStats == null) upgradeStats = CustomItemUtils.statMap()
			this.upgradeStats!![baseStat.key] = upgradeValue + originalValue
		}
		this.serialize()
	}

	fun checkIfExistingStat(upgrades : HashMap<StatTypes, Double>) : Boolean {
		for (baseStat in baseStats) {
			//check if upgrades contains the base stats of the item
			if (upgrades.containsKey(baseStat.key)) return true
		}
		return false
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
					CustomItemUtils.getStats(this, addGem = false, addRarity = true, false)
			val upgradeStats = CustomItemUtils.getUpgradedStats(this)
			baseStats.keys.forEach {
				if (realStats[it]!! < 0.0) {
					if (hideRarity || quality < 0)
						meta.lore(
								"<r><red>-${baseStats[it]?.times(0.5)}. . . -${
									baseStats[it]?.times(
											1.5
									                    )
								} <gray>${it.stylizedName}"
						         )
					else {
						if (upgradeStats[it] == 0.0 || upgradeStats[it] == null) meta.lore("<r><red>-${realStats[it]} <gray>${it.stylizedName}")
						else meta.lore("<r><red>-${realStats[it]} <yellow>(+${upgradeStats[it]}) <gray>${it.stylizedName}")
					}
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
						if (upgradeStats[it] == 0.0 || upgradeStats[it] == null) meta.lore("<r><green>+${realStats[it]} <gray>${it.stylizedName}")
						else meta.lore("<r><green>+${realStats[it]} <yellow>(+${upgradeStats[it]}) <gray>${it.stylizedName}")
					}

				}
			}
		}
		meta.lore(" ")
		description.forEach {
			meta.lore("<r><dark_gray>$it")
		}
		meta.lore(" ")
		meta.lore("<r><gray>Level: $levelRequirement")

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
				"equipmentStatGem" to if (statGem != null) statGem.toString() else null,
				"upgrades" to if (this.upgradeStats != null) upgradeStats.toString() else null
		                      )
	}

	fun onHit(e : EntityDamageByEntityEvent) {
		// placeholder for optional event
	}

	override fun deserialize() {
		super.deserialize()
		try {
			item.getNbtTag<String>("equipmentStatGem")?.let {
				statGem = StatGem.fromString(it)
			}
			item.getNbtTag<String>("upgrades")?.let { it ->
				if (it.isNotEmpty()) {
					val map : Map<StatTypes, Double> = it.split(",").associate {
						//This is ugly as heck
						val (left, right) = it.replace("{", "").replace("}", "").split("=")
						StatTypes.getFromId(left)!! to right.toDouble()
					}
					upgradeStats = HashMap(map)
				}
			}
		} catch (e : Exception) { }

	}
}