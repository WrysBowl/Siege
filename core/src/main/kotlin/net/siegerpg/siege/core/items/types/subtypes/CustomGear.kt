package net.siegerpg.siege.core.items.types.subtypes

import de.tr7zw.nbtapi.NBTItem
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.getNbtTag
import net.siegerpg.siege.core.items.setNbtTags
import net.siegerpg.siege.core.items.statgems.StatGem
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.core.miscellaneous.lore
import org.bukkit.Bukkit
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.EntityShootBowEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import kotlin.random.Random

interface CustomGear : CustomEquipment {

	var addedStats : HashMap<StatTypes, Double>?

	override fun updateMeta(hideRarity : Boolean) : ItemStack {
		super.updateMeta(hideRarity)
		setStats() //sets random stat if able to
		addedStats?.forEach { (k, v) ->
			baseStats.merge(k, v) { a : Double, b : Double -> a }
		}
		return this.item
	}

	/**
	 * Amount of stat rolls this particular item can have
	 */
	fun getRollAmount() : Int {
		return when (rarity) {
			Rarity.COMMON    -> 0

			Rarity.UNCOMMON  -> {
				if (Utils.randTest(30.0)) 1
				else 0
			}

			Rarity.RARE      -> 1
			Rarity.EPIC      -> {
				if (quality < 100 && Utils.randTest(25.0)) 2
				else 1
			}

			Rarity.LEGENDARY -> {
				if (quality < 100 && Utils.randTest(75.0)) 2
				else 1
			}

			Rarity.SPECIAL   -> 3
			else             -> 0
		}
	}

	//method can be overrided to limit the amount of stats that can be randomly added
	fun getStatPool() : List<StatTypes> {
		return listOf(
				StatTypes.REGENERATION,
				StatTypes.DEFENSE,
				StatTypes.HEALTH,
				StatTypes.LUCK,
				StatTypes.MANA,
				StatTypes.MANA_REGEN,
				StatTypes.STRENGTH
		             )
	}

	/**
	 * Calculate the random stats that the item could have
	 */
	fun getRandomStats() : HashMap<StatTypes, Double>? {
		val rolls : Int = getRollAmount()
		var chosenStats : HashMap<StatTypes, Double> = hashMapOf()

		//get sum of all stats added
		var statSum = 0.0
		for (stat in baseStats) {
			if (stat.value < 0) statSum += stat.value / 2
			else statSum += stat.value
		}

		repeat(rolls) {
			val randIndex : Int = Random.nextInt(0, getStatPool().size - 1)
			val chosenStat : StatTypes = getStatPool()[randIndex]

			//if there are duplicates, add to previous value
			val currentValue : Double = chosenStats[chosenStat] ?: 0.0
			chosenStats[chosenStat] = currentValue + statSum / 5
		}
		return chosenStats
	}

	/**
	 * To be called each time the item gets updated
	 */
	fun setStats() {
		if (checkStatus()) return //if item has been checked for random stats, returns false
		item = item.setNbtTags("addedStatus" to true) //item has had its stats rolled
		addedStats = getRandomStats()
		this.serialize()
	}

	/**
	 * Checks if item has had a chance to roll its stats already
	 */
	fun checkStatus() : Boolean {
		try {
			item.getNbtTag<Boolean>("addedStatus")?.let { it ->
				return it
			}
		} catch (e : Exception) {
			return false
		}
		return false
	}

	override fun serialize() {
		super.serialize()
		item = item.setNbtTags(
				"addedStats" to if (this.addedStats != null) addedStats.toString() else null
		                      )
	}

	override fun deserialize() {
		super.deserialize()
		try {
			item.getNbtTag<String>("addedStats")?.let { it ->

				//TODO Use NBTTag Compounds in place of this atrocity
				if (it.isNotEmpty()) {
					val map : Map<StatTypes, Double> = it.split(",").associate {
						//This is ugly as heck
						val (left, right) = it.replace("{", "")
								.replace("}", "")
								.split("=")
						StatTypes.getFromId(left)!! to right.toDouble()
					}
					addedStats = HashMap(map)
				}
			}
		} catch (e : Exception) {
		}
	}

	override fun statFormat(meta : ItemMeta, hideRarity : Boolean) : ItemMeta {
		meta.lore(" ")
		val realStats =
				CustomItemUtils.getStats(this, addGem = false, addRarity = true)
		//TODO Check what stat has been added, and make the value a different color
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
					if (addedStats?.containsKey(it) == true) {
						meta.lore("<r><red>${realStats[it]} <gray>${it.stylizedName} <color:#de7464>\u269D")
					} else {
						meta.lore("<r><red>${realStats[it]} <gray>${it.stylizedName}")
					}
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
					if (addedStats?.containsKey(it) == true) {
						meta.lore("<r><green>+${realStats[it]} <gray>${it.stylizedName} <color:#52d1a0>\u269D")
					} else {
						meta.lore("<r><green>+${realStats[it]} <gray>${it.stylizedName}")
					}
				}

			}
		}
		return meta
	}

}