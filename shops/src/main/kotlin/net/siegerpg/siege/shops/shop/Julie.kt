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
					SewerShooter(-1), 1750, hashMapOf(
					Slime.tier(3) to 1,
					Magma.tier(3) to 1,
					Stick.tier(3) to 3,
					Vine.tier(3) to 3
					                                 ), true
			        ) {
				SewerShooter(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckySewerShooter(-1), -1, hashMapOf(
					Slime.tier(3) to 1,
					Magma.tier(3) to 1,
					Stick.tier(3) to 3,
					Vine.tier(3) to 1,
					Feather.tier(3) to 2
					                                    ), true
			        ) {
				LuckySewerShooter(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongSewerShooter(-1), -1, hashMapOf(
					Slime.tier(3) to 1,
					Magma.tier(3) to 1,
					Stick.tier(3) to 3,
					Vine.tier(3) to 1,
					Bone.tier(3) to 1
					                                     ), true
			        ) {
				StrongSewerShooter(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughSewerShooter(-1), -1, hashMapOf(
					Slime.tier(3) to 1,
					Magma.tier(3) to 1,
					Stick.tier(3) to 3,
					Vine.tier(3) to 1,
					Pebble.tier(3) to 2
					                                    ), true
			        ) {
				ToughSewerShooter(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthySewerShooter(-1), -1, hashMapOf(
					Slime.tier(3) to 1,
					Magma.tier(3) to 1,
					Stick.tier(3) to 3,
					Vine.tier(3) to 1,
					PlantMatter.tier(3) to 2
					                                      ), true
			        ) {
				HealthySewerShooter(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingSewerShooter(-1), -1, hashMapOf(
					Slime.tier(3) to 1,
					Magma.tier(3) to 1,
					Stick.tier(3) to 3,
					Vine.tier(3) to 1,
					Wheat.tier(3) to 3
					                                      ), true
			        ) {
				HealingSewerShooter(Utils.randRarity()).getUpdatedItem(false)
			},

			//CROSSBOW
			ShopItem(Crossbow(-1), 2750, hashMapOf(), false) {
				Crossbow(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyCrossbow(-1), 3000, hashMapOf(
					Vine.tier(3) to 3,
					MetalScrap.tier(3) to 1,
					Feather.tier(3) to 3
					                                  ), true
			        ) {
				LuckyCrossbow(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongCrossbow(-1), 2700, hashMapOf(
					Vine.tier(3) to 3,
					MetalScrap.tier(3) to 1,
					Bone.tier(3) to 3
					                                   ), true
			        ) {
				StrongCrossbow(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughCrossbow(-1), 2700, hashMapOf(
					Vine.tier(3) to 3,
					MetalScrap.tier(3) to 1,
					Pebble.tier(3) to 3
					                                  ), true
			        ) {
				ToughCrossbow(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyCrossbow(-1), 2700, hashMapOf(
					Vine.tier(3) to 3,
					MetalScrap.tier(3) to 1,
					PlantMatter.tier(3) to 3
					                                    ), true
			        ) {
				HealthyCrossbow(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingCrossbow(-1), 2700, hashMapOf(
					Vine.tier(3) to 3,
					MetalScrap.tier(3) to 1,
					Wheat.tier(3) to 1
					                                    ), true
			        ) {
				HealingCrossbow(Utils.randRarity()).getUpdatedItem(false)
			}
	                                            )
}