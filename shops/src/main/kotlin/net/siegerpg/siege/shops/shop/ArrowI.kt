package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.arrows.Arrow
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class ArrowI : Shop() {

	override var name : String = "Arrow Shop I"
	override var permission : String = "siege.shops.shop.arrowI"
	override var items : List<ShopItem> = listOf(
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					Arrow(-1).asQuantity(16), 100, hashMapOf(
					Pebble() to 8,
					Stick() to 16,
					Feather() to 8), true
			        ) {
				Arrow().getUpdatedItem(false).asQuantity(16)
			}
	                                            )
}