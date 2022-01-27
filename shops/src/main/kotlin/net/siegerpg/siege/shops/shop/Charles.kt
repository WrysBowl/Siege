package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.Clobber
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.EarthernHammer
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.clobbers.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.earthernHammers.*
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Charles : Shop() {

	override var name : String = "Charles"
	override var permission : String = "siege.shops.shop.charles"
	override var items : List<ShopItem> = listOf(
			//CLOBBER
			ShopItem(
					Clobber(-1), -1, hashMapOf(
					RefinedMetal() to 128
					                          ), true
			        ) {
				Clobber(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyClobber(-1), -1, hashMapOf(
					RefinedMetal() to 114,
					Feather() to 32
					                               ), true
			        ) {
				LuckyClobber(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongClobber(-1), -1, hashMapOf(
					RefinedMetal() to 114,
					Bone() to 24
					                                ), true
			        ) {
				StrongClobber(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughClobber(-1), -1, hashMapOf(
					RefinedMetal() to 114,
					Pebble() to 32
					                               ), true
			        ) {
				ToughClobber(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyClobber(-1), -1, hashMapOf(
					RefinedMetal() to 114,
					PlantMatter() to 32
					                                 ), true
			        ) {
				HealthyClobber(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingClobber(-1), -1, hashMapOf(
					RefinedMetal() to 114,
					Wheat() to 64
					                                 ), true
			        ) {
				HealingClobber(Utils.randRarity()).getUpdatedItem(false)
			},

			//EARTHERN HAMMER
			ShopItem(
					EarthernHammer(-1), -1, hashMapOf(
					PlantMatter() to 196,
					Stick() to 64
					                                 ), true
			        ) {
				EarthernHammer(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyEarthernHammer(-1), -1, hashMapOf(
					PlantMatter() to 128,
					Stick() to 64,
					Feather() to 64
					                                      ), true
			        ) {
				LuckyEarthernHammer(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongEarthernHammer(-1), -1, hashMapOf(
					PlantMatter() to 128,
					Stick() to 64,
					Bone() to 48
					                                       ), true
			        ) {
				StrongEarthernHammer(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughEarthernHammer(-1), -1, hashMapOf(
					PlantMatter() to 128,
					Stick() to 64,
					Pebble() to 64
					                                      ), true
			        ) {
				ToughEarthernHammer(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyEarthernHammer(-1), -1, hashMapOf(
					PlantMatter() to 256,
					Stick() to 32
					                                        ), true
			        ) {
				HealthyEarthernHammer(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingEarthernHammer(-1), -1, hashMapOf(
					PlantMatter() to 128,
					Stick() to 32,
					Wheat() to 256
					                                        ), true
			        ) {
				HealingEarthernHammer(Utils.randRarity()).getUpdatedItem(false)
			},
	                                            )
}