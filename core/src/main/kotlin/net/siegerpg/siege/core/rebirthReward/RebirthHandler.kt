package net.siegerpg.siege.core.rebirthReward

import org.bukkit.entity.Player

class RebirthHandler {

	val rebirthTiers : HashMap<Int, RebirthTier> = hashMapOf()

	companion object {

		/**
		 * Resets the player's gold and EXP to be reborn
		 */
		fun resetPlayer(player : Player) {
			//TODO Reset gold and EXP of player
		}

		/**
		 * Calculates the amount of levels required to rebirth
		 */
		fun calculateRequiredLVL(tier : Int) : Int {
			return 1
		}
	}
}