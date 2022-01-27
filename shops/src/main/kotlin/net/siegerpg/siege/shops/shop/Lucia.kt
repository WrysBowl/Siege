package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.weapons.wands.EarthernStaff
import net.siegerpg.siege.core.items.implemented.weapons.wands.earthernStaffs.*
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Lucia : Shop() {

	override var name : String = "Lucia"
	override var permission : String = "siege.shops.shop.lucia"
	override var items : List<ShopItem> = listOf(
			//EARTHERN STAFF
			ShopItem(
					EarthernStaff(-1), -1, hashMapOf(
					PlantMatter() to 128,
					Seed() to 196,
					Coal() to 64
					                                ), true
			        ) {
				EarthernStaff(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyEarthernStaff(-1), -1, hashMapOf(
					PlantMatter() to 114,
					Seed() to 164,
					Coal() to 64,
					Feather() to 64
					                                     ), true
			        ) {
				LuckyEarthernStaff(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongEarthernStaff(-1), -1, hashMapOf(
					PlantMatter() to 114,
					Seed() to 164,
					Coal() to 64,
					Bone() to 48
					                                      ), true
			        ) {
				StrongEarthernStaff(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughEarthernStaff(-1), -1, hashMapOf(
					PlantMatter() to 114,
					Seed() to 164,
					Coal() to 64,
					Pebble() to 64
					                                     ), true
			        ) {
				ToughEarthernStaff(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyEarthernStaff(-1), -1, hashMapOf(
					PlantMatter() to 256,
					Seed() to 164,
					Coal() to 64
					                                       ), true
			        ) {
				HealthyEarthernStaff(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingEarthernStaff(-1), -1, hashMapOf(
					PlantMatter() to 114,
					Seed() to 164,
					Coal() to 64,
					Wheat() to 448
					                                       ), true
			        ) {
				HealingEarthernStaff(Utils.randRarity()).getUpdatedItem(false)
			}
	                                            )
}