package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.splinteredBones.*
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Jane : Shop() {

	override var name : String = "Jane"
	override var permission : String = "siege.shops.shop.jane"
	override var items : List<ShopItem> = listOf(
			//SPLINTERED BONE
			ShopItem(
					SplinteredBone(-1), -1, hashMapOf(
					Bone() to 128
					                                   ), true
			        ) {
				SplinteredBone(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckySplinteredBone(-1), -1, hashMapOf(
					Bone() to 96,
					Feather() to 48
					                                      ), true
			        ) {
				LuckySplinteredBone(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongSplinteredBone(-1), -1, hashMapOf(
					Bone() to 160
					                                       ), true
			        ) {
				StrongSplinteredBone(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughSplinteredBone(-1), -1, hashMapOf(
					Bone() to 96,
					Pebble() to 48
					                                      ), true
			        ) {
				ToughSplinteredBone(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthySplinteredBone(-1), -1, hashMapOf(
					Bone() to 96,
					PlantMatter() to 48
					                                        ), true
			        ) {
				HealthySplinteredBone(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingSplinteredBone(-1), -1, hashMapOf(
					Bone() to 96,
					Wheat() to 196
					                                        ), true
			        ) {
				HealingSplinteredBone(Utils.randRarity()).getUpdatedItem(false)
			},

			//REFINED DAGGER
			ShopItem(
					RefinedDagger(-1), -1, hashMapOf(
					RefinedMetal() to 160,
					Stick() to 128
					                                  ), true
			        ) {
				RefinedDagger(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyRefinedDagger(-1), -1, hashMapOf(
					RefinedMetal() to 128,
					Stick() to 128,
					Feather() to 96
					                                       ), true
			        ) {
				LuckyRefinedDagger(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongRefinedDagger(-1), -1, hashMapOf(
					RefinedMetal() to 128,
					Stick() to 128,
					Bone() to 64
					                                        ), true
			        ) {
				StrongRefinedDagger(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughRefinedDagger(-1), -1, hashMapOf(
					RefinedMetal() to 128,
					Stick() to 128,
					Pebble() to 96
					                                       ), true
			        ) {
				ToughRefinedDagger(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyRefinedDagger(-1), -1, hashMapOf(
					RefinedMetal() to 128,
					Stick() to 128,
					PlantMatter() to 96
					                                         ), true
			        ) {
				HealthyRefinedDagger(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingRefinedDagger(-1), -1, hashMapOf(
					RefinedMetal() to 128,
					Stick() to 128,
					Wheat() to 256
					                                         ), true
			        ) {
				HealingRefinedDagger(Utils.randRarity()).getUpdatedItem(false)
			},
	                                            )
}