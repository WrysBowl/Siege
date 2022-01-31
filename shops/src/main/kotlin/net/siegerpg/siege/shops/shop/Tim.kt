package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.WoodenSword
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.woodenSwords.*
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Tim : Shop() {

	override var name : String = "Tim"
	override var permission : String = "siege.shops.shop.tim"
	override var items : List<ShopItem> = listOf(
			//WOODEN SWORDS
			ShopItem(
					WoodenSword(-1), -1, hashMapOf(
					Stick() to 320,
					Coal() to 48
					                              ), true
			        ) {
				WoodenSword(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyWoodenSword(-1), -1, hashMapOf(
					Stick() to 288,
					Coal() to 48,
					Feather() to 64
					                                   ), true
			        ) {
				LuckyWoodenSword(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongWoodenSword(-1), -1, hashMapOf(
					Stick() to 288,
					Coal() to 48,
					Bone() to 48
					                                    ), true
			        ) {
				StrongWoodenSword(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughWoodenSword(-1), -1, hashMapOf(
					Stick() to 288,
					Coal() to 48,
					Pebble() to 64
					                                   ), true
			        ) {
				ToughWoodenSword(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyWoodenSword(-1), -1, hashMapOf(
					Stick() to 288,
					Coal() to 48,
					PlantMatter() to 64
					                                     ), true
			        ) {
				HealthyWoodenSword(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingWoodenSword(-1), -1, hashMapOf(
					Stick() to 288,
					Coal() to 48,
					Wheat() to 256
					                                     ), true
			        ) {
				HealingWoodenSword(Utils.randRarity()).getUpdatedItem(false)
			}
	                                            )
}