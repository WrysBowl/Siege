package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.arrows.Arrow
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.arrows.PoisonArrow
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.arrows.SlownessArrow
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class ArrowII : Shop() {

	override var name : String = "Arrow Shop II"
	override var permission : String = "siege.shops.shop.arrowII"
	override var items : List<ShopItem> = listOf(
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					SlownessArrow(-1).asQuantity(16), 400, hashMapOf(
					Pebble() to 40,
					Stick() to 16,
					Feather() to 8), true
			        ) {
				SlownessArrow().getUpdatedItem(false).asQuantity(16)
			},
			ShopItem(
					Arrow(-1).asQuantity(16), 100, hashMapOf(
					Pebble() to 8,
					Stick() to 16,
					Feather() to 8), true
			        ) {
				Arrow().getUpdatedItem(false).asQuantity(16)
			},
			ShopItem(
					PoisonArrow(-1).asQuantity(16), 600, hashMapOf(
					Pebble() to 8,
					Stick() to 16,
					Feather() to 8,
					PlantMatter() to 32,
					Seed() to 32,
					                                              ), true
			        ) {
				PoisonArrow().getUpdatedItem(false).asQuantity(16)
			}
	                                            )
}