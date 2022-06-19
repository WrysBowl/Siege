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
				WoodenPickaxe().getUpdatedItem(false)
			},
			ShopItem(WoodenShovel(100), 1000, hashMapOf(), false) {
				WoodenShovel().getUpdatedItem(false)
			},
			ShopItem(WoodenAxe(100), 1000, hashMapOf(), false) {
				WoodenAxe().getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(GlowingWoodenPickaxe(100), 2000, hashMapOf(), false) {
				GlowingWoodenPickaxe().getUpdatedItem(false)
			},
			ShopItem(GlowingWoodenShovel(100), 2000, hashMapOf(), false) {
				GlowingWoodenShovel().getUpdatedItem(false)
			},
			ShopItem(GlowingWoodenAxe(100), 2000, hashMapOf(), false) {
				GlowingWoodenAxe().getUpdatedItem(false)
			},

			//BONE
			ShopItem(BonePickaxe(100), 4000, hashMapOf(), false) {
				BonePickaxe().getUpdatedItem(false)
			},
			ShopItem(BoneShovel(100), 4000, hashMapOf(), false) {
				BoneShovel().getUpdatedItem(false)
			},
			ShopItem(BoneAxe(100), 4000, hashMapOf(), false) {
				BoneAxe().getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(GlowingBonePickaxe(100), 8000, hashMapOf(), false) {
				GlowingBonePickaxe().getUpdatedItem(false)
			},
			ShopItem(GlowingBoneShovel(100), 8000, hashMapOf(), false) {
				GlowingBoneShovel().getUpdatedItem(false)
			},
			ShopItem(GlowingBoneAxe(100), 8000, hashMapOf(), false) {
				GlowingBoneAxe().getUpdatedItem(false)
			},

			//STONE
			ShopItem(StonePickaxe(100), 15000, hashMapOf(), false) {
				StonePickaxe().getUpdatedItem(false)
			},
			ShopItem(StoneShovel(100), 15000, hashMapOf(), false) {
				StoneShovel().getUpdatedItem(false)
			},
			ShopItem(StoneAxe(100), 15000, hashMapOf(), false) {
				StoneAxe().getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(GlowingStonePickaxe(100), 30000, hashMapOf(), false) {
				GlowingStonePickaxe().getUpdatedItem(false)
			},
			ShopItem(GlowingStoneShovel(100), 30000, hashMapOf(), false) {
				GlowingStoneShovel().getUpdatedItem(false)
			},
			ShopItem(GlowingStoneAxe(100), 30000, hashMapOf(), false) {
				GlowingStoneAxe().getUpdatedItem(false)
			},

			//IRON
			ShopItem(IronPickaxe(100), 50000, hashMapOf(), false) {
				IronPickaxe().getUpdatedItem(false)
			},
			ShopItem(IronShovel(100), 50000, hashMapOf(), false) {
				IronShovel().getUpdatedItem(false)
			},
			ShopItem(IronAxe(100), 50000, hashMapOf(), false) {
				IronAxe().getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(GlowingIronPickaxe(100), 75000, hashMapOf(), false) {
				GlowingIronPickaxe().getUpdatedItem(false)
			},
			ShopItem(GlowingIronShovel(100), 75000, hashMapOf(), false) {
				GlowingIronShovel().getUpdatedItem(false)
			},
			ShopItem(GlowingIronAxe(100), 75000, hashMapOf(), false) {
				GlowingIronAxe().getUpdatedItem(false)
			},
	                                            )
}