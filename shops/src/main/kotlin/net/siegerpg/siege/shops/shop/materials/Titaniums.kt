package net.siegerpg.siege.shops.shop.materials

import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Titaniums : Shop() {

	override var name : String = "Titanium"
	override var permission : String = "siege.shops.shop.titanium"
	override var items : List<ShopItem> = listOf(
			ShopItem(Titanium.tier(2), -1, hashMapOf(
					Titanium.tier(1) to 8), true) {
				Titanium.tier(2).getUpdatedItem(false)
			},
			ShopItem(Titanium.tier(3), -1, hashMapOf(
					Titanium.tier(2) to 8), true) {
				Titanium.tier(3).getUpdatedItem(false)
			},
			ShopItem(Titanium.tier(4), -1, hashMapOf(
					Titanium.tier(3) to 8), true) {
				Titanium.tier(4).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(Titanium.tier(1).asQuantity(8) as CustomItem, -1, hashMapOf(
					Titanium.tier(2) to 1), true) {
				Titanium.tier(1).getUpdatedItem(false).asQuantity(8)
			},
			ShopItem(Titanium.tier(2).asQuantity(8) as CustomItem, -1, hashMapOf(
					Titanium.tier(3) to 1), true) {
				Titanium.tier(2).getUpdatedItem(false).asQuantity(8)
			},
			ShopItem(Titanium.tier(3).asQuantity(8) as CustomItem, -1, hashMapOf(
					Titanium.tier(4) to 1), true) {
				Titanium.tier(3).getUpdatedItem(false).asQuantity(8)
			})
}