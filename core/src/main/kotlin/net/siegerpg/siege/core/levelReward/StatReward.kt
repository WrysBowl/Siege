package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.enums.StatTypes

interface StatReward : LevelReward {

	val stats : HashMap<StatTypes, Int>

}