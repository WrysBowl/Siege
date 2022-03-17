package net.siegerpg.siege.core.miscellaneous

import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.levelReward.LevelReward
import net.siegerpg.siege.core.miscellaneous.Levels.blockingGetExpLevel
import org.bukkit.entity.Player

class StatRewards {

	companion object {
		fun getRewardedStats(player : Player) : HashMap<StatTypes, Int> {

			val statMap : HashMap<StatTypes, Int> = hashMapOf()

			var expLevel : Pair<Short, Int>? = blockingGetExpLevel(player)
			if (expLevel == null) expLevel = Pair(1.toShort(), 0)
			val level = expLevel.first.toInt()

			getLevelRewards(level).forEach { k, v ->
				statMap.merge(k, v) { a : Int, b : Int ->
					Integer.sum(
							a,
							b
					           )
				}
			}

			//TODO Implement getRebirthRewards

			return statMap


		}

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
				stat.stats.forEach { k, v ->
					statMap.merge(k, v) { a : Int, b : Int ->
						Integer.sum(
								a,
								b
						           )
					}
				}
			}
			return statMap

		}

		/**
		 * Get all stats rewarded to the player
		 */
		fun getRebirthRewards(tier : Int) : HashMap<StatTypes, Int> {
			//get all previous stat rewards
			val rewards : ArrayList<LevelReward> = Levels.levelRewards.subList(0, tier - 2) as ArrayList<LevelReward>

			val statMap : HashMap<StatTypes, Int> = hashMapOf()
			val statRewards : ArrayList<LevelReward> = arrayListOf()

			if (Levels.levelRewards.size + 2 < tier) return statMap//ensure that the level reward is set in the array list

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
}