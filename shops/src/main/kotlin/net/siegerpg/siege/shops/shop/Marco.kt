package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.tools.*
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Marco : Shop() {

	override var name : String = "Marco"
	override var permission : String = "siege.shops.shop.marco"
	override var items : List<ShopItem> = listOf(
			//WOODEN
			ShopItem(WoodenPickaxe(100), 1000, hashMapOf(), false) {
				WoodenPickaxe(100).getUpdatedItem(false)
			},
			ShopItem(WoodenShovel(100), 1000, hashMapOf(), false) {
				WoodenShovel(100).getUpdatedItem(false)
			},
			ShopItem(WoodenAxe(100), 1000, hashMapOf(), false) {
				WoodenAxe(100).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(GlowingWoodenPickaxe(100), 2000, hashMapOf(), false) {
				GlowingWoodenPickaxe(100).getUpdatedItem(false)
			},
			ShopItem(GlowingWoodenShovel(100), 2000, hashMapOf(), false) {
				GlowingWoodenShovel(100).getUpdatedItem(false)
			},
			ShopItem(GlowingWoodenAxe(100), 2000, hashMapOf(), false) {
				GlowingWoodenAxe(100).getUpdatedItem(false)
			},

			//BONE
			ShopItem(BonePickaxe(100), 4000, hashMapOf(), false) {
				BonePickaxe(100).getUpdatedItem(false)
			},
			ShopItem(BoneShovel(100), 4000, hashMapOf(), false) {
				BoneShovel(100).getUpdatedItem(false)
			},
			ShopItem(BoneAxe(100), 4000, hashMapOf(), false) {
				BoneAxe(100).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(GlowingBonePickaxe(100), 8000, hashMapOf(), false) {
				GlowingBonePickaxe(100).getUpdatedItem(false)
			},
			ShopItem(GlowingBoneShovel(100), 8000, hashMapOf(), false) {
				GlowingBoneShovel(100).getUpdatedItem(false)
			},
			ShopItem(GlowingBoneAxe(100), 8000, hashMapOf(), false) {
				GlowingBoneAxe(100).getUpdatedItem(false)
			},

			//STONE
			ShopItem(StonePickaxe(100), 15000, hashMapOf(), false) {
				StonePickaxe(100).getUpdatedItem(false)
			},
			ShopItem(StoneShovel(100), 15000, hashMapOf(), false) {
				StoneShovel(100).getUpdatedItem(false)
			},
			ShopItem(StoneAxe(100), 15000, hashMapOf(), false) {
				StoneAxe(100).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(GlowingStonePickaxe(100), 30000, hashMapOf(), false) {
				GlowingStonePickaxe(100).getUpdatedItem(false)
			},
			ShopItem(GlowingStoneShovel(100), 30000, hashMapOf(), false) {
				GlowingStoneShovel(100).getUpdatedItem(false)
			},
			ShopItem(GlowingStoneAxe(100), 30000, hashMapOf(), false) {
				GlowingStoneAxe(100).getUpdatedItem(false)
			},

			//IRON
			ShopItem(IronPickaxe(100), 50000, hashMapOf(), false) {
				IronPickaxe(100).getUpdatedItem(false)
			},
			ShopItem(IronShovel(100), 50000, hashMapOf(), false) {
				IronShovel(100).getUpdatedItem(false)
			},
			ShopItem(IronAxe(100), 50000, hashMapOf(), false) {
				IronAxe(100).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(GlowingIronPickaxe(100), 75000, hashMapOf(), false) {
				GlowingIronPickaxe(100).getUpdatedItem(false)
			},
			ShopItem(GlowingIronShovel(100), 75000, hashMapOf(), false) {
				GlowingIronShovel(100).getUpdatedItem(false)
			},
			ShopItem(GlowingIronAxe(100), 75000, hashMapOf(), false) {
				GlowingIronAxe(100).getUpdatedItem(false)
			},
	                                            )
}