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
                in 0..40 -> COMMON
                in 40..60 -> UNCOMMON
                in 60..80 -> RARE
                in 80..95 -> EPIC
                in 95..101 -> LEGENDARY
                in 100..150 -> SPECIAL
                else -> DEBUG
            }
        }
    }
}
