package net.siegerpg.siege.core.items.types.subtypes

import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.getNbtTag
import net.siegerpg.siege.core.items.setNbtTags
import net.siegerpg.siege.core.items.sets.GearSet
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.items.types.misc.Cosmetic
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.core.miscellaneous.lore
import net.siegerpg.siege.core.miscellaneous.name
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import kotlin.random.Random

interface CustomGear : CustomEquipment {

	var addedStats : HashMap<StatTypes, Double>?
	val gearSetInfo : List<List<String>>?

	override fun updateMeta(hideRarity : Boolean) : ItemStack {
		super.updateMeta(hideRarity)
		setStats() //sets random stat if able to
		addedStats?.forEach { (k, v) ->
			baseStats.merge(k, v) { a : Double, b : Double -> a }
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
		if (baseStats.size != 0) {
			item.itemMeta = statFormat(meta, hideRarity)
		}
		val length =
				if (name.length > 16) name.length
				else 16
		meta.lore(" ")
		gearSetInfo?.forEach{
			meta.lore("<r><color:#87d4a0>Set Bonus")
			Utils.getTextArray(it, length).forEach {
				meta.lore("<r><color:#82a18c>$it")
			}
			meta.lore(" ")
		}
		Utils.getTextArray(description, length).forEach {
			meta.lore("<r><dark_gray>$it")
		}
		meta.lore(" ")
		meta.lore("<r><gray>Level <color:#BC74EE>$levelRequirement   <r><color:#E2DE5D>${String.format("%,d",getSellValue())} \u26C1")

		item.itemMeta = meta
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

}