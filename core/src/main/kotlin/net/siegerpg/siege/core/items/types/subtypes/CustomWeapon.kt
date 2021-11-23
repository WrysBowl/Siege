package net.siegerpg.siege.core.items.types.subtypes

import de.tr7zw.nbtapi.NBTItem
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.getNbtTag
import net.siegerpg.siege.core.items.setNbtTags
import net.siegerpg.siege.core.items.statgems.StatGem
import org.bukkit.Bukkit
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDamageEvent

interface CustomWeapon : CustomEquipment {

	fun onHit(e : EntityDamageEvent) {

	}

	override fun serialize() {
		super.serialize()
		item = item.setNbtTags(
				"upgrades" to if (this.upgradeStats != null) upgradeStats.toString() else null
		                      )
		Bukkit.getLogger().info(upgradeStats.toString())
		val nbt = NBTItem.convertItemtoNBT(this.item)
		Bukkit.getLogger().info(nbt.toString())
	}

	override fun deserialize() {
		super.deserialize()
		try {
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