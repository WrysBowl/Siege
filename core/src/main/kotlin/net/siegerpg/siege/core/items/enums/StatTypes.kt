package net.siegerpg.siege.core.items.enums

enum class StatTypes(val stylizedName : String, val color : String) {
	HEALTH("Health", "<red>"),
	DEFENSE("Defense", "<blue>"),

	STRENGTH("Strength", "<dark_red>"),
	REGENERATION("Regeneration", "<gold>"),
	LUCK("Luck", "<green>"),

	MANA("Mana", "<dark_aqua>"),
	MANA_REGEN("Mana Regen", "<light_blue>");

	companion object {

		fun getFromId(id : String?) : StatTypes? {
			for (statType in values()) {
				if (statType.name == id) return statType
			}
			return null
		}
	}
}