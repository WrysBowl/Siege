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
			ShopItem(Drumstick(), 25, hashMapOf(), false) {
				Drumstick().getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(Apple(), 20, hashMapOf(), false) {
				Apple().getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(Bread(), 40, hashMapOf(Wheat.tier(2) to 4), false) {
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
			ShopItem(GoldenCarrot(), 1000, hashMapOf(Carrot(0) to 512), false) {
				Bread().getUpdatedItem(false)
			},


			)
}