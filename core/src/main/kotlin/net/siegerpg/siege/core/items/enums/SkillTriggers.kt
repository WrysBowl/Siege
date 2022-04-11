package net.siegerpg.siege.core.items.enums

import org.bukkit.event.block.Action

enum class SkillTriggers(val display : String, val actions : List<List<Action>>) {
	FIRST(
			"R + L + L", listOf(
			listOf(Action.RIGHT_CLICK_AIR, Action.RIGHT_CLICK_BLOCK),
			listOf(Action.LEFT_CLICK_AIR, Action.LEFT_CLICK_BLOCK),
			listOf(Action.LEFT_CLICK_AIR, Action.LEFT_CLICK_BLOCK)
			                   )
	     ),
	SECOND(
			"R + R + L", listOf(
			listOf(Action.RIGHT_CLICK_AIR, Action.RIGHT_CLICK_BLOCK),
			listOf(Action.RIGHT_CLICK_AIR, Action.RIGHT_CLICK_BLOCK),
			listOf(Action.LEFT_CLICK_AIR, Action.LEFT_CLICK_BLOCK)
			                   )
	      ),
	THIRD(
			"R + R + R", listOf(
			listOf(Action.RIGHT_CLICK_AIR, Action.RIGHT_CLICK_BLOCK),
			listOf(Action.RIGHT_CLICK_AIR, Action.RIGHT_CLICK_BLOCK),
			listOf(Action.RIGHT_CLICK_AIR, Action.RIGHT_CLICK_BLOCK)
			                   )
	     ),
	FOURTH(
			"L + L + R", listOf(
			listOf(Action.LEFT_CLICK_AIR, Action.LEFT_CLICK_BLOCK),
			listOf(Action.LEFT_CLICK_AIR, Action.LEFT_CLICK_BLOCK),
			listOf(Action.RIGHT_CLICK_AIR, Action.RIGHT_CLICK_BLOCK)
			                   )
	      ),
	FIFTH(
			"L + R + R", listOf(
			listOf(Action.LEFT_CLICK_AIR, Action.LEFT_CLICK_BLOCK),
			listOf(Action.RIGHT_CLICK_AIR, Action.RIGHT_CLICK_BLOCK),
			listOf(Action.RIGHT_CLICK_AIR, Action.RIGHT_CLICK_BLOCK)
			                   )
	     );

	companion object {

		fun getFromInt(int : Int) : SkillTriggers {
			return when (int) {
				1    -> FIRST
				2    -> SECOND
				3    -> THIRD
				4    -> FOURTH
				5    -> FIFTH
				else -> FIRST
			}
		}
	}
}