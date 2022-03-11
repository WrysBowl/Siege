package net.siegerpg.siege.core.miscellaneous

import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.levelReward.LevelReward

class StatRewards {

	/**
	 * Get all stats rewarded to the player
	 */
	fun getLevelRewards(level : Int) : HashMap<StatTypes, Int> {
		//get all previous stat rewards
		val rewards : ArrayList<LevelReward> = Levels.levelRewards.subList(0, level - 2) as ArrayList<LevelReward>

		val statMap : HashMap<StatTypes, Int> = hashMapOf()
		val statRewards : ArrayList<LevelReward> = arrayListOf()

		if (Levels.levelRewards.size + 2 < level) return statMap//ensure that the level reward is set in the array list

		//make a list of all rewards that are stat rewards
		for (reward in rewards) {
			if (reward.stats.isEmpty()) continue
			statRewards.add(reward)
		}
		if (statRewards.size < 1) return statMap //check if the stat rewards has anything in it

		for (stat in statRewards) {
			val combinedMap : HashMap<StatTypes, Int> = statMap
			combinedMap.putAll(stat.stats)

			statMap.putAll(combinedMap)
		}
		return statMap

	}


}