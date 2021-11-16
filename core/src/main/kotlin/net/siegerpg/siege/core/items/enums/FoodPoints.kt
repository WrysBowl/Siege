package net.siegerpg.siege.core.items.enums

import org.bukkit.Material

object FoodPoints {

	//Hello this is Wrys. I copied this from here: https://bukkit.org/threads/get-nutrition-values-of-food.186559/
	// I am too lazy to make these into and enum
	fun getHungerRegenValue(mat : Material) : Int {
		if (mat === Material.POTATO || mat === Material.BEETROOT || mat === Material.KELP || mat === Material.TROPICAL_FISH) return 1
		if (mat === Material.CAKE || mat === Material.COOKIE || mat === Material.MUTTON || mat === Material.MELON || mat === Material.POISONOUS_POTATO || mat === Material.CHICKEN || mat === Material.COD || mat === Material.SPIDER_EYE || mat === Material.COOKIE || mat === Material.MELON_SLICE || mat === Material.POISONOUS_POTATO || mat === Material.SWEET_BERRIES) return 2
		if (mat === Material.PORKCHOP || mat === Material.BEEF || mat === Material.SALMON || mat === Material.CARROT || mat === Material.RABBIT) return 3
		if (mat === Material.APPLE || mat === Material.GOLDEN_APPLE || mat === Material.ROTTEN_FLESH || mat === Material.CHORUS_FRUIT || mat === Material.ENCHANTED_GOLDEN_APPLE) return 4
		if (mat === Material.BAKED_POTATO || mat === Material.BREAD || mat === Material.COOKED_COD || mat === Material.COOKED_RABBIT) return 5
		if (mat === Material.COOKED_CHICKEN || mat === Material.GOLDEN_CARROT || mat === Material.MUSHROOM_STEW || mat === Material.BEETROOT_SOUP || mat === Material.COOKED_MUTTON || mat === Material.COOKED_SALMON || mat === Material.GOLDEN_CARROT || mat === Material.HONEY_BOTTLE || mat === Material.SUSPICIOUS_STEW) return 6
		if (mat === Material.COOKED_BEEF || mat === Material.COOKED_PORKCHOP || mat === Material.PUMPKIN_PIE) return 8
		if (mat === Material.RABBIT_STEW) return 10
		return 0
	}

	fun getSaturationValue(mat : Material) : Double {
		if (mat === Material.CAKE || mat === Material.COOKIE) return 0.4
		if (mat === Material.POTATO) return 0.6
		if (mat === Material.ROTTEN_FLESH) return 0.8
		if (mat === Material.MELON || mat === Material.POISONOUS_POTATO || mat === Material.CHICKEN || mat === Material.COD) return 1.2
		if (mat === Material.PORKCHOP || mat === Material.BEEF) return 1.8
		if (mat === Material.APPLE) return 2.4
		if (mat === Material.SPIDER_EYE) return 3.2
		if (mat === Material.CARROT || mat === Material.PUMPKIN_PIE) return 4.8
		if (mat === Material.BREAD || mat === Material.COOKED_COD) return 6.0
		if (mat === Material.BAKED_POTATO || mat === Material.COOKED_CHICKEN || mat === Material.MUSHROOM_STEW) return 7.2
		if (mat === Material.GOLDEN_APPLE) return 9.6
		if (mat === Material.COOKED_BEEF || mat === Material.PORKCHOP) return 12.8
		if (mat === Material.GOLDEN_CARROT) return 14.4
		return 0.0
	}
}