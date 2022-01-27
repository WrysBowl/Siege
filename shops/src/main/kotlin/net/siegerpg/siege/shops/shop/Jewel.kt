package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.weapons.ranged.RecurveBow
import net.siegerpg.siege.core.items.implemented.weapons.ranged.recurveBows.*
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Jewel : Shop() {

	override var name : String = "Jewel"
	override var permission : String = "siege.shops.shop.jewel"
	override var items : List<ShopItem> = listOf(
			//RECURVE BOW
			ShopItem(RecurveBow(-1), -1, hashMapOf(
					Vine() to 128,
					RefinedMetal() to 128
													 ), false) {
				RecurveBow(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyRecurveBow(-1), -1, hashMapOf(
					Vine() to 128,
					RefinedMetal() to 96,
					Feather() to 64
					                                  ), true
			        ) {
				LuckyRecurveBow(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongRecurveBow(-1), -1, hashMapOf(
					Vine() to 128,
					RefinedMetal() to 96,
					Bone() to 48
					                                   ), true
			        ) {
				StrongRecurveBow(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughRecurveBow(-1), -1, hashMapOf(
					Vine() to 128,
					RefinedMetal() to 96,
					Pebble() to 64
					                                  ), true
			        ) {
				ToughRecurveBow(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyRecurveBow(-1), -1, hashMapOf(
					Vine() to 128,
					RefinedMetal() to 96,
					PlantMatter() to 64
					                                    ), true
			        ) {
				HealthyRecurveBow(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingRecurveBow(-1), -1, hashMapOf(
					Vine() to 128,
					RefinedMetal() to 96,
					Wheat() to 384
					                                    ), true
			        ) {
				HealingRecurveBow(Utils.randRarity()).getUpdatedItem(false)
			},
	                                            )
}