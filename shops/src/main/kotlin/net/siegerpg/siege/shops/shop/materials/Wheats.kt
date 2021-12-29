package net.siegerpg.siege.shops.shop.materials

import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Wheats : Shop() {

	override var name : String = "Wheat"
	override var permission : String = "siege.shops.shop.wheat"
	override var items : List<ShopItem> = listOf(
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(Wheat.tier(2), -1, hashMapOf(
					Wheat.tier(1) to 8), true) {
				Wheat.tier(2).getUpdatedItem(false)
			},
			ShopItem(Wheat.tier(3), -1, hashMapOf(
					Wheat.tier(2) to 8), true) {
				Wheat.tier(3).getUpdatedItem(false)
			},
			ShopItem(Wheat.tier(4), -1, hashMapOf(
					Wheat.tier(3) to 8), true) {
				Wheat.tier(4).getUpdatedItem(false)
			},
			ShopItem(Wheat.tier(5), -1, hashMapOf(
					Wheat.tier(4) to 8), true) {
				Wheat.tier(5).getUpdatedItem(false)
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
			ShopItem(Wheat.tier(1).asQuantity(4) as CustomItem, -1, hashMapOf(
					Wheat.tier(2) to 1), true) {
				Wheat.tier(1).getUpdatedItem(false).asQuantity(4)
			},
			ShopItem(Wheat.tier(2).asQuantity(4) as CustomItem, -1, hashMapOf(
					Wheat.tier(3) to 1), true) {
				Wheat.tier(2).getUpdatedItem(false).asQuantity(4)
			},
			ShopItem(Wheat.tier(3).asQuantity(4) as CustomItem, -1, hashMapOf(
					Wheat.tier(4) to 1), true) {
				Wheat.tier(3).getUpdatedItem(false).asQuantity(4)
			},
			ShopItem(Wheat.tier(4).asQuantity(4) as CustomItem, -1, hashMapOf(
					Wheat.tier(5) to 1), true) {
				Wheat.tier(4).getUpdatedItem(false).asQuantity(4)
			})
}