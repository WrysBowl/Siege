package net.siegerpg.siege.core.items.enums

enum class StatTypes(val stylizedName : String) {
	STRENGTH("Strength"),
	DEFENSE("Defense"),
	HEALTH("Health"),
	LUCK("Luck"),
	REGENERATION("Regeneration"),
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