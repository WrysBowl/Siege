package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.food.*
import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Chelsea : Shop() {

	override var name : String = "Chelsea"
	override var permission : String = "siege.shops.shop.chelsea"
	override var items : List<ShopItem> = listOf(
			ShopItem(Drumstick(), 50, hashMapOf(), false) {
				Drumstick().getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(Apple(), 40, hashMapOf(), false) {
				Apple().getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(Bread(), 100, hashMapOf(Wheat() to 24), true) {
				Bread().getUpdatedItem(false)
			},

			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(GoldenCarrot(), 1000, hashMapOf(Carrot() to 512), false) {
				GoldenCarrot().getUpdatedItem(false)
			},


			)
}