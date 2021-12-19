package net.siegerpg.siege.shops.shop.materials

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Slimes : Shop() {

	override var name : String = "Slime"
	override var permission : String = "siege.shops.shop.slime"
	override var items : List<ShopItem> = listOf(
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(Slime.tier(2), -1, hashMapOf(
					Slime.tier(1) to 8), true) {
				Slime.tier(2).getUpdatedItem(false)
			},
			ShopItem(Slime.tier(3), -1, hashMapOf(
					Slime.tier(2) to 8), true) {
				Slime.tier(3).getUpdatedItem(false)
			},
			ShopItem(Slime.tier(4), -1, hashMapOf(
					Slime.tier(3) to 8), true) {
				Slime.tier(4).getUpdatedItem(false)
			},
			ShopItem(Slime.tier(5), -1, hashMapOf(
					Slime.tier(4) to 8), true) {
				Slime.tier(5).getUpdatedItem(false)
			})
}