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

	override var name : String = "Valentine"
	override var permission : String = "siege.shops.shop.valentine"
	override var items : List<ShopItem> = listOf(
			//IRON BOW
			ShopItem(
					IronBow(-1), -1, hashMapOf(
					Vine() to 256,
					RefinedMetal() to 196
					                          ), true
			        ) {
				IronBow(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyIronBow(-1), -1, hashMapOf(
					Vine() to 196,
					RefinedMetal() to 196,
					Feather() to 96
					                               ), true
			        ) {
				LuckyIronBow(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongIronBow(-1), -1, hashMapOf(
					Vine() to 196,
					RefinedMetal() to 196,
					Bone() to 64
					                                ), true
			        ) {
				StrongIronBow(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughIronBow(-1), -1, hashMapOf(
					Vine() to 196,
					RefinedMetal() to 196,
					Pebble() to 96
					                               ), true
			        ) {
				ToughIronBow(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyIronBow(-1), -1, hashMapOf(
					Vine() to 196,
					RefinedMetal() to 196,
					PlantMatter() to 96
					                                 ), true
			        ) {
				HealthyIronBow(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingIronBow(-1), -1, hashMapOf(
					Vine() to 196,
					RefinedMetal() to 196,
					Wheat() to 256
					                                 ), true
			        ) {
				HealingIronBow(Utils.randRarity()).getUpdatedItem(false)
			},

			//BOWBA
			ShopItem(
					Bowba(-1), -1, hashMapOf(
					Vine() to 160,
					RefinedMetal() to 64,
					Bone() to 128
					                        ), true
			        ) {
				Bowba(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyBowba(-1), -1, hashMapOf(
					Vine() to 160,
					RefinedMetal() to 64,
					Bone() to 64,
					Feather() to 96
					                             ), true
			        ) {
				LuckyBowba(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongBowba(-1), -1, hashMapOf(
					Vine() to 160,
					RefinedMetal() to 64,
					Bone() to 160
					                              ), true
			        ) {
				StrongBowba(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughBowba(-1), -1, hashMapOf(
					Vine() to 160,
					RefinedMetal() to 64,
					Bone() to 64,
					Pebble() to 96
					                             ), true
			        ) {
				ToughBowba(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyBowba(-1), -1, hashMapOf(
					Vine() to 160,
					RefinedMetal() to 64,
					Bone() to 64,
					PlantMatter() to 96
					                               ), true
			        ) {
				HealthyBowba(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingBowba(-1), -1, hashMapOf(
					Vine() to 160,
					RefinedMetal() to 64,
					Bone() to 64,
					Wheat() to 512
					                               ), true
			        ) {
				HealingBowba(Utils.randRarity()).getUpdatedItem(false)
			},
	                                            )
}