package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.RefinedMetal
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Vine
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.weapons.ranged.RecurveBow
import net.siegerpg.siege.core.items.implemented.weapons.ranged.recurveBows.HealingRecurveBow
import net.siegerpg.siege.core.items.implemented.weapons.ranged.recurveBows.HealthyRecurveBow
import net.siegerpg.siege.core.items.implemented.weapons.ranged.recurveBows.LuckyRecurveBow
import net.siegerpg.siege.core.items.implemented.weapons.ranged.recurveBows.StrongRecurveBow
import net.siegerpg.siege.core.items.implemented.weapons.ranged.recurveBows.ToughRecurveBow
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Jewel : Shop() {

	override var name: String = "Jewel"
	override var permission: String = "siege.shops.shop.jewel"
	override var items: List<ShopItem> = listOf(
		//RECURVE BOW
		ShopItem(RecurveBow(-1), 3000, hashMapOf(), false) {
			RecurveBow(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
			GRAYFILLER(-1).getUpdatedItem(false)
		},
		ShopItem(
			LuckyRecurveBow(-1), -1, hashMapOf(
				Vine.tier(3) to 3,
				RefinedMetal.tier(3) to 1,
				Feather.tier(4) to 1
			                                  ), true
		        ) {
			LuckyRecurveBow(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			StrongRecurveBow(-1), -1, hashMapOf(
				Vine.tier(3) to 3,
				RefinedMetal.tier(3) to 1,
				Bone.tier(3) to 4
			                                   ), true
		        ) {
			StrongRecurveBow(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			ToughRecurveBow(-1), -1, hashMapOf(
				Vine.tier(3) to 3,
				RefinedMetal.tier(3) to 1,
				Pebble.tier(4) to 1
			                                  ), true
		        ) {
			ToughRecurveBow(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealthyRecurveBow(-1), -1, hashMapOf(
				Vine.tier(3) to 3,
				RefinedMetal.tier(3) to 1,
				PlantMatter.tier(4) to 1
			                                    ), true
		        ) {
			HealthyRecurveBow(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealingRecurveBow(-1), -1, hashMapOf(
				Vine.tier(3) to 3,
				RefinedMetal.tier(3) to 1,
				Wheat.tier(4) to 2
			                                    ), true
		        ) {
			HealingRecurveBow(Utils.randRarity()).getUpdatedItem(false)
		},
	                                           )
}