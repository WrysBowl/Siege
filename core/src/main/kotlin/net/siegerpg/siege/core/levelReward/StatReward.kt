package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.miscellaneous.Levels
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Bukkit
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable

interface StatReward : LevelReward {

	val stats : HashMap<StatTypes, Int>

	/**
	 * Get all stats rewarded to the player
	 */
	fun getStatsRewarded(level : Int) : HashMap<StatTypes, Int> {
		//get all previous stat rewards
		val rewards : ArrayList<LevelReward> = Levels.levelRewards.subList(0, level - 2) as ArrayList<LevelReward>

		val statMap : HashMap<StatTypes, Int> = hashMapOf()
		val statRewards : ArrayList<LevelReward> = arrayListOf()

		if (Levels.levelRewards.size + 2 < level) return statMap//ensure that the level reward is set in the array list

		//make a list of all rewards that are stat rewards
		for (reward in rewards) {
			if (reward !is StatReward) continue
			statRewards.add(reward)
		}
		if (statRewards.size < 1) return statMap //check if the stat rewards has anything in it

		for (stat in statRewards) {
			val combinedMap : HashMap<StatTypes, Int> = statMap
			combinedMap.putAll((stat as StatReward).stats)

			statMap.putAll(combinedMap)
		}
		return statMap

	}

}