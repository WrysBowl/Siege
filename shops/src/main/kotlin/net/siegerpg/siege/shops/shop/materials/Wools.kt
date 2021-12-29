package net.siegerpg.siege.shops.shop.materials

import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Wools : Shop() {

	override var name : String = "Wool"
	override var permission : String = "siege.shops.shop.wool"
	override var items : List<ShopItem> = listOf(
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(Wool.tier(2), -1, hashMapOf(
					Wool.tier(1) to 8), true) {
				Wool.tier(2).getUpdatedItem(false)
			},
			ShopItem(Wool.tier(3), -1, hashMapOf(
					Wool.tier(2) to 8), true) {
				Wool.tier(3).getUpdatedItem(false)
			},
			ShopItem(Wool.tier(4), -1, hashMapOf(
					Wool.tier(3) to 8), true) {
				Wool.tier(4).getUpdatedItem(false)
			},
			ShopItem(Wool.tier(5), -1, hashMapOf(
					Wool.tier(4) to 8), true) {
				Wool.tier(5).getUpdatedItem(false)
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
			ShopItem(Wool.tier(1).asQuantity(4) as CustomItem, -1, hashMapOf(
					Wool.tier(2) to 1), true) {
				Wool.tier(1).getUpdatedItem(false).asQuantity(4)
			},
			ShopItem(Wool.tier(2).asQuantity(4) as CustomItem, -1, hashMapOf(
					Wool.tier(3) to 1), true) {
				Wool.tier(2).getUpdatedItem(false).asQuantity(4)
			},
			ShopItem(Wool.tier(3).asQuantity(4) as CustomItem, -1, hashMapOf(
					Wool.tier(4) to 1), true) {
				Wool.tier(3).getUpdatedItem(false).asQuantity(4)
			},
			ShopItem(Wool.tier(4).asQuantity(4) as CustomItem, -1, hashMapOf(
					Wool.tier(5) to 1), true) {
				Wool.tier(4).getUpdatedItem(false).asQuantity(4)
			})
}