package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.RefinedMetal
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.Clobber
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.EarthernHammer
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.clobbers.HealingClobber
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.clobbers.HealthyClobber
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.clobbers.LuckyClobber
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.clobbers.StrongClobber
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.clobbers.ToughClobber
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.earthernHammers.HealingEarthernHammer
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.earthernHammers.HealthyEarthernHammer
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.earthernHammers.LuckyEarthernHammer
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.earthernHammers.StrongEarthernHammer
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.earthernHammers.ToughEarthernHammer
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Charles : Shop() {

	override var name: String = "Charles"
	override var permission: String = "siege.shops.shop.charles"
	override var items: List<ShopItem> = listOf(
		//CLOBBER
		ShopItem(
			Clobber(-1), 5250, hashMapOf(
				RefinedMetal.tier(3) to 5
			                            ), true
		        ) {
			Clobber(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
			GRAYFILLER(-1).getUpdatedItem(false)
		},
		ShopItem(
			LuckyClobber(-1), -1, hashMapOf(
				RefinedMetal.tier(3) to 3,
				Feather.tier(4) to 1
			                               ), true
		        ) {
			LuckyClobber(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			StrongClobber(-1), -1, hashMapOf(
				RefinedMetal.tier(3) to 3,
				Bone.tier(3) to 3
			                                ), true
		        ) {
			StrongClobber(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			ToughClobber(-1), -1, hashMapOf(
				RefinedMetal.tier(3) to 3,
				Pebble.tier(4) to 1
			                               ), true
		        ) {
			ToughClobber(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealthyClobber(-1), -1, hashMapOf(
				RefinedMetal.tier(3) to 3,
				PlantMatter.tier(3) to 3
			                                 ), true
		        ) {
			HealthyClobber(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealingClobber(-1), -1, hashMapOf(
				RefinedMetal.tier(3) to 3,
				Wheat.tier(4) to 2
			                                 ), true
		        ) {
			HealingClobber(Utils.randRarity()).getUpdatedItem(false)
		},

		//EARTHERN HAMMER
		ShopItem(
			EarthernHammer(-1), 5750, hashMapOf(
				PlantMatter.tier(4) to 2,
				Stick.tier(3) to 3
			                                   ), true
		        ) {
			EarthernHammer(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
			GRAYFILLER(-1).getUpdatedItem(false)
		},
		ShopItem(
			LuckyEarthernHammer(-1), -1, hashMapOf(
				PlantMatter.tier(4) to 1,
				Stick.tier(3) to 3,
				Feather.tier(3) to 4
			                                      ), true
		        ) {
			LuckyEarthernHammer(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			StrongEarthernHammer(-1), -1, hashMapOf(
				PlantMatter.tier(4) to 1,
				Stick.tier(3) to 3,
				Bone.tier(3) to 4
			                                       ), true
		        ) {
			StrongEarthernHammer(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			ToughEarthernHammer(-1), -1, hashMapOf(
				PlantMatter.tier(4) to 1,
				Stick.tier(3) to 3,
				Pebble.tier(3) to 4
			                                      ), true
		        ) {
			ToughEarthernHammer(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealthyEarthernHammer(-1), -1, hashMapOf(
				PlantMatter.tier(4) to 1,
				Stick.tier(3) to 3,
				PlantMatter.tier(3) to 4
			                                        ), true
		        ) {
			HealthyEarthernHammer(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealingEarthernHammer(-1), -1, hashMapOf(
				PlantMatter.tier(4) to 1,
				Stick.tier(3) to 3,
				Wheat.tier(4) to 2
			                                        ), true
		        ) {
			HealingEarthernHammer(Utils.randRarity()).getUpdatedItem(false)
		},
	                                           )
}