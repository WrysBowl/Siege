package net.siegerpg.siege.core.items.enums

enum class StatTypes(val stylizedName : String) {
	HEALTH("Health"),
	DEFENSE("Defense"),

	STRENGTH("Strength"),
	REGENERATION("Regeneration"),
	LUCK("Luck"),

	MANA("Mana"),
	MANA_REGEN("Mana Regen");

	companion object {

		fun getFromId(id : String?) : StatTypes? {
			for (statType in values()) {
				if (statType.name == id) return statType
			}
			return null
		}
	}
}