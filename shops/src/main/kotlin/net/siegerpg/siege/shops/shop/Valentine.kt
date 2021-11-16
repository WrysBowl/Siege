package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.weapons.ranged.Bowba
import net.siegerpg.siege.core.items.implemented.weapons.ranged.IronBow
import net.siegerpg.siege.core.items.implemented.weapons.ranged.bowbas.*
import net.siegerpg.siege.core.items.implemented.weapons.ranged.ironBows.*
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Valentine : Shop() {

	override var name: String = "Valentine"
	override var permission: String = "siege.shops.shop.valentine"
	override var items: List<ShopItem> = listOf(
		//IRON BOW
		ShopItem(
			IronBow(-1), 3200, hashMapOf(
				Vine.tier(3) to 3,
				RefinedMetal.tier(3) to 3
			                            ), true
		        ) {
			IronBow(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
			GRAYFILLER(-1).getUpdatedItem(false)
		},
		ShopItem(
			LuckyIronBow(-1), -1, hashMapOf(
				Vine.tier(3) to 3,
				RefinedMetal.tier(3) to 1,
				Feather.tier(3) to 4
			                               ), true
		        ) {
			LuckyIronBow(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			StrongIronBow(-1), -1, hashMapOf(
				Vine.tier(3) to 3,
				RefinedMetal.tier(3) to 1,
				Bone.tier(3) to 4
			                                ), true
		        ) {
			StrongIronBow(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			ToughIronBow(-1), -1, hashMapOf(
				Vine.tier(3) to 3,
				RefinedMetal.tier(3) to 1,
				Pebble.tier(3) to 4
			                               ), true
		        ) {
			ToughIronBow(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealthyIronBow(-1), -1, hashMapOf(
				Vine.tier(3) to 3,
				RefinedMetal.tier(3) to 1,
				PlantMatter.tier(3) to 3
			                                 ), true
		        ) {
			HealthyIronBow(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealingIronBow(-1), -1, hashMapOf(
				Vine.tier(3) to 3,
				RefinedMetal.tier(3) to 1,
				Wheat.tier(4) to 1
			                                 ), true
		        ) {
			HealingIronBow(Utils.randRarity()).getUpdatedItem(false)
		},

		//BOWBA
		ShopItem(
			Bowba(-1), 4000, hashMapOf(
				Vine.tier(3) to 3,
				RefinedMetal.tier(4) to 1,
				Bone.tier(4) to 2
			                          ), true
		        ) {
			Bowba(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
			GRAYFILLER(-1).getUpdatedItem(false)
		},
		ShopItem(
			LuckyBowba(-1), 4500, hashMapOf(
				Vine.tier(3) to 3,
				RefinedMetal.tier(3) to 4,
				Bone.tier(4) to 1,
				Feather.tier(4) to 2
			                               ), true
		        ) {
			LuckyBowba(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			StrongBowba(-1), 4500, hashMapOf(
				Vine.tier(3) to 3,
				RefinedMetal.tier(3) to 4,
				Bone.tier(4) to 2
			                                ), true
		        ) {
			StrongBowba(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			ToughBowba(-1), 4500, hashMapOf(
				Vine.tier(3) to 3,
				RefinedMetal.tier(3) to 4,
				Bone.tier(4) to 1,
				Pebble.tier(4) to 2
			                               ), true
		        ) {
			ToughBowba(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealthyBowba(-1), 4500, hashMapOf(
				Vine.tier(3) to 3,
				RefinedMetal.tier(3) to 4,
				Bone.tier(4) to 1,
				PlantMatter.tier(4) to 2
			                                 ), true
		        ) {
			HealthyBowba(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealingBowba(-1), 4500, hashMapOf(
				Vine.tier(3) to 3,
				RefinedMetal.tier(3) to 4,
				Bone.tier(4) to 1,
				Wheat.tier(4) to 4
			                                 ), true
		        ) {
			HealingBowba(Utils.randRarity()).getUpdatedItem(false)
		},
	                                           )
}