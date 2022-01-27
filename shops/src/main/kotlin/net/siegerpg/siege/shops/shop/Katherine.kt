package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.weapons.wands.EarthernWand
import net.siegerpg.siege.core.items.implemented.weapons.wands.earthernWands.*
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Katherine : Shop() {

	override var name : String = "Katherine"
	override var permission : String = "siege.shops.shop.katherine"
	override var items : List<ShopItem> = listOf(
			//EARTHERN WAND
			ShopItem(
					EarthernWand(-1), -1, hashMapOf(
					PlantMatter() to 64,
					Seed() to 128,
					Coal() to 128
					                               ), true
			        ) {
				EarthernWand(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyEarthernWand(-1), -1, hashMapOf(
					PlantMatter() to 64,
					Seed() to 96,
					Coal() to 96,
					Feather() to 64
					                                    ), true
			        ) {
				LuckyEarthernWand(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongEarthernWand(-1), -1, hashMapOf(
					PlantMatter() to 64,
					Seed() to 96,
					Coal() to 96,
					Bone() to 48
					                                     ), true
			        ) {
				StrongEarthernWand(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughEarthernWand(-1), -1, hashMapOf(
					PlantMatter() to 64,
					Seed() to 96,
					Coal() to 96,
					Pebble() to 64
					                                    ), true
			        ) {
				ToughEarthernWand(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyEarthernWand(-1), -1, hashMapOf(
					PlantMatter() to 128,
					Seed() to 96,
					Coal() to 96
					                                      ), true
			        ) {
				HealthyEarthernWand(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingEarthernWand(-1), -1, hashMapOf(
					PlantMatter() to 64,
					Seed() to 96,
					Coal() to 96,
					Wheat() to 256
					                                      ), true
			        ) {
				HealingEarthernWand(Utils.randRarity()).getUpdatedItem(false)
			}
	                                            )
}