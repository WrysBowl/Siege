package net.siegerpg.siege.shops.shop.materials

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Pebbles : Shop() {

	override var name : String = "Pebble"
	override var permission : String = "siege.shops.shop.pebble"
	override var items : List<ShopItem> = listOf(
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(Pebble.tier(2), -1, hashMapOf(
					Pebble.tier(1) to 8), true) {
				Pebble.tier(2).getUpdatedItem(false)
			},
			ShopItem(Pebble.tier(3), -1, hashMapOf(
					Pebble.tier(2) to 8), true) {
				Pebble.tier(3).getUpdatedItem(false)
			},
			ShopItem(Pebble.tier(4), -1, hashMapOf(
					Pebble.tier(3) to 8), true) {
				Pebble.tier(4).getUpdatedItem(false)
			},
			ShopItem(Pebble.tier(5), -1, hashMapOf(
					Pebble.tier(4) to 8), true) {
				Pebble.tier(5).getUpdatedItem(false)
			})
}