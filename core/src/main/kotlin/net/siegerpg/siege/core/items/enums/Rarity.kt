package net.siegerpg.siege.core.items.enums

enum class Rarity(val id: String, val color: String) {
	COMMON("Common", "<gray>"),
	UNCOMMON("Uncommon", "<green>"),
	RARE("Rare", "<blue>"),
	EPIC("Epic", "<dark_purple>"),
	LEGENDARY("Legendary", "<gold>"),
	SPECIAL("Special", "<rainbow>"),
	DEBUG("Debug", "<red>");

	companion object {
		fun getFromId(id: String?): Rarity {
			for (rarity in values()) {
				if (rarity.id.equals(id, ignoreCase = true)) return rarity
			}
			return COMMON
		}

		fun getFromInt(int: Int): Rarity {
			return when (int) {
				in 0..49 -> COMMON
				in 50..69 -> UNCOMMON
				in 70..84 -> RARE
				in 85..94 -> EPIC
				in 95..101 -> LEGENDARY
				in 100..150 -> SPECIAL
				else -> DEBUG
			}
		}
	}
}
