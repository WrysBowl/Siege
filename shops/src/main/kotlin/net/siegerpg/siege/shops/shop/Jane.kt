package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.RefinedMetal
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.HealingRefinedDagger
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.HealthyRefinedDagger
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.LuckyRefinedDagger
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.RefinedDagger
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.SplinteredBone
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.StrongRefinedDagger
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.ToughRefinedDagger
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.splinteredBones.HealingSplinteredBone
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.splinteredBones.HealthySplinteredBone
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.splinteredBones.LuckySplinteredBone
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.splinteredBones.StrongSplinteredBone
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.splinteredBones.ToughSplinteredBone
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Jane : Shop() {

	override var name: String = "Jane"
	override var permission: String = "siege.shops.shop.jane"
	override var items: List<ShopItem> = listOf(
		//SPLINTERED BONE
		ShopItem(
			SplinteredBone(-1), 2500, hashMapOf(
				Bone.tier(3) to 2
			                                   ), true
		        ) {
			SplinteredBone(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
			GRAYFILLER(-1).getUpdatedItem(false)
		},
		ShopItem(
			LuckySplinteredBone(-1), -1, hashMapOf(
				Bone.tier(3) to 1,
				Feather.tier(3) to 2
			                                      ), true
		        ) {
			LuckySplinteredBone(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			StrongSplinteredBone(-1), -1, hashMapOf(
				Bone.tier(3) to 3
			                                       ), true
		        ) {
			StrongSplinteredBone(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			ToughSplinteredBone(-1), -1, hashMapOf(
				Bone.tier(3) to 1,
				Pebble.tier(3) to 2
			                                      ), true
		        ) {
			ToughSplinteredBone(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealthySplinteredBone(-1), -1, hashMapOf(
				Bone.tier(3) to 1,
				PlantMatter.tier(3) to 2
			                                        ), true
		        ) {
			HealthySplinteredBone(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealingSplinteredBone(-1), -1, hashMapOf(
				Bone.tier(3) to 1,
				Wheat.tier(3) to 3
			                                        ), true
		        ) {
			HealingSplinteredBone(Utils.randRarity()).getUpdatedItem(false)
		},

		//REFINED DAGGER
		ShopItem(
			RefinedDagger(-1), 2750, hashMapOf(
				RefinedMetal.tier(3) to 1,
				Stick.tier(3) to 1
			                                  ), true
		        ) {
			RefinedDagger(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
			GRAYFILLER(-1).getUpdatedItem(false)
		},
		ShopItem(
			LuckyRefinedDagger(-1), 3000, hashMapOf(
				RefinedMetal.tier(2) to 4,
				Stick.tier(3) to 1,
				Feather.tier(3) to 1
			                                       ), true
		        ) {
			LuckyRefinedDagger(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			StrongRefinedDagger(-1), 3000, hashMapOf(
				RefinedMetal.tier(2) to 4,
				Stick.tier(3) to 1,
				Bone.tier(3) to 1
			                                        ), true
		        ) {
			StrongRefinedDagger(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			ToughRefinedDagger(-1), 3000, hashMapOf(
				RefinedMetal.tier(2) to 4,
				Stick.tier(3) to 1,
				Pebble.tier(3) to 2
			                                       ), true
		        ) {
			ToughRefinedDagger(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealthyRefinedDagger(-1), 3000, hashMapOf(
				RefinedMetal.tier(2) to 4,
				Stick.tier(3) to 1,
				PlantMatter.tier(3) to 1
			                                         ), true
		        ) {
			HealthyRefinedDagger(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealingRefinedDagger(-1), 3000, hashMapOf(
				RefinedMetal.tier(2) to 4,
				Stick.tier(3) to 1,
				Wheat.tier(3) to 2
			                                         ), true
		        ) {
			HealingRefinedDagger(Utils.randRarity()).getUpdatedItem(false)
		},
	                                           )
}