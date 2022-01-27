package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Magma
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Slime
import net.siegerpg.siege.core.items.implemented.weapons.ranged.Crossbow
import net.siegerpg.siege.core.items.implemented.weapons.ranged.SewerShooter
import net.siegerpg.siege.core.items.implemented.weapons.ranged.crossbows.*
import net.siegerpg.siege.core.items.implemented.weapons.ranged.sewerShooters.*
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Julie : Shop() {

	override var name : String = "Julie"
	override var permission : String = "siege.shops.shop.julie"
	override var items : List<ShopItem> = listOf(
			//SEWER SHOOTER
			ShopItem(
					SewerShooter(-1), -1, hashMapOf(
					Slime() to 32,
					Magma() to 32,
					Stick() to 196,
					Vine() to 64
					                               ), true
			        ) {
				SewerShooter(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckySewerShooter(-1), -1, hashMapOf(
					Slime() to 32,
					Magma() to 32,
					Stick() to 128,
					Vine() to 64,
					Feather() to 64
					                                    ), true
			        ) {
				LuckySewerShooter(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongSewerShooter(-1), -1, hashMapOf(
					Slime() to 32,
					Magma() to 32,
					Stick() to 128,
					Vine() to 64,
					Bone() to 48
					                                     ), true
			        ) {
				StrongSewerShooter(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughSewerShooter(-1), -1, hashMapOf(
					Slime() to 32,
					Magma() to 32,
					Stick() to 128,
					Vine() to 64,
					Pebble() to 64
					                                    ), true
			        ) {
				ToughSewerShooter(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthySewerShooter(-1), -1, hashMapOf(
					Slime() to 32,
					Magma() to 32,
					Stick() to 128,
					Vine() to 64,
					PlantMatter() to 64
					                                      ), true
			        ) {
				HealthySewerShooter(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingSewerShooter(-1), -1, hashMapOf(
					Slime() to 32,
					Magma() to 32,
					Stick() to 196,
					Vine() to 64,
					Wheat() to 384
					                                      ), true
			        ) {
				HealingSewerShooter(Utils.randRarity()).getUpdatedItem(false)
			},

			//CROSSBOW
			ShopItem(Crossbow(-1), -1, hashMapOf(
					Vine() to 64,
					MetalScrap() to 128
												), false) {
				Crossbow(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyCrossbow(-1), -1, hashMapOf(
					Vine() to 64,
					MetalScrap() to 96,
					Feather() to 64
					                                ), true
			        ) {
				LuckyCrossbow(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongCrossbow(-1), -1, hashMapOf(
					Vine() to 64,
					MetalScrap() to 96,
					Bone() to 48
					                                 ), true
			        ) {
				StrongCrossbow(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughCrossbow(-1), -1, hashMapOf(
					Vine() to 64,
					MetalScrap() to 96,
					Pebble() to 64
					                                ), true
			        ) {
				ToughCrossbow(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyCrossbow(-1), -1, hashMapOf(
					Vine() to 64,
					MetalScrap() to 96,
					PlantMatter() to 64
					                                  ), true
			        ) {
				HealthyCrossbow(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingCrossbow(-1), -1, hashMapOf(
					Vine() to 64,
					MetalScrap() to 96,
					Wheat() to 256
					                                  ), true
			        ) {
				HealingCrossbow(Utils.randRarity()).getUpdatedItem(false)
			}
	                                            )
}