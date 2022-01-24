package net.siegerpg.siege.shops.shop.materials

import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class RefinedMetals : Shop() {

	override var name : String = "Refined Metal"
	override var permission : String = "siege.shops.shop.refinedMetal"
	override var items : List<ShopItem> = listOf(
			ShopItem(RefinedMetal.tier(2), -1, hashMapOf(
					RefinedMetal.tier(1) to 8), true) {
				RefinedMetal.tier(2).getUpdatedItem(false)
			},
			ShopItem(RefinedMetal.tier(3), -1, hashMapOf(
					RefinedMetal.tier(2) to 8), true) {
				RefinedMetal.tier(3).getUpdatedItem(false)
			},
			ShopItem(RefinedMetal.tier(4), -1, hashMapOf(
					RefinedMetal.tier(3) to 8), true) {
				RefinedMetal.tier(4).getUpdatedItem(false)
			},
			ShopItem(RefinedMetal.tier(1), -1, hashMapOf(
					MetalScrap.tier(1) to 8), true) {
				RefinedMetal.tier(1).getUpdatedItem(false)
			},
			ShopItem(RefinedMetal.tier(1).asQuantity(8) as CustomItem, -1, hashMapOf(
					RefinedMetal.tier(2) to 1), true) {
				RefinedMetal.tier(1).getUpdatedItem(false).asQuantity(8)
			},
			ShopItem(RefinedMetal.tier(2).asQuantity(8) as CustomItem, -1, hashMapOf(
					RefinedMetal.tier(3) to 1), true) {
				RefinedMetal.tier(2).getUpdatedItem(false).asQuantity(8)
			},
			ShopItem(RefinedMetal.tier(3).asQuantity(8) as CustomItem, -1, hashMapOf(
					RefinedMetal.tier(4) to 1), true) {
				RefinedMetal.tier(3).getUpdatedItem(false).asQuantity(8)
			})
}