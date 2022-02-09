package net.siegerpg.siege.core.miscellaneous

enum class LevelColor(val lvl : Int, val color : String) {
	PEASANT(0, "<white>"),
	NOVICE(10, "<gray>"),
	SQUIRE(20, "<color:#da68de>"),
	ADVENTURER(30, "<color:#a76be3>"),
	GUARDIAN(40, "<color:#2381a1>"),
	FIGHTER(50, "<color:#d13d49>"),
	BRAWLER(60, "<color:#d4715f>"),
	BATTLER(70, "<color:#85bf0f>"),
	SLAYER(80, "<color:#7ae683>"),
	HUNTSMAN(90, "<color:#25e8a1>"),
	SWORDSMAN(100, "<color:#56b814>");

	companion object {

		fun getFromId(id : Int?) : LevelColor {
			for (rank in values()) {
				if (rank.lvl == id) return rank
			}
			return PEASANT
		}

		fun getFromInt(int : Int) : LevelColor {
			return when (int) {
				in 0..9     -> PEASANT
				in 10..19   -> NOVICE
				in 20..29   -> SQUIRE
				in 30..39   -> ADVENTURER
				in 40..49   -> GUARDIAN
				in 50..59   -> FIGHTER
				in 60..69   -> BRAWLER
				in 70..79   -> BATTLER
				in 80..89   -> SLAYER
				in 90..99   -> HUNTSMAN
				in 100..109 -> SWORDSMAN

				else        -> PEASANT
			}
		}
	}
}
