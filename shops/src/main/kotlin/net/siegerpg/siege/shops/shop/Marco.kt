package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.tools.BoneAxe
import net.siegerpg.siege.core.items.implemented.misc.tools.BonePickaxe
import net.siegerpg.siege.core.items.implemented.misc.tools.BoneShovel
import net.siegerpg.siege.core.items.implemented.misc.tools.GlowingBoneAxe
import net.siegerpg.siege.core.items.implemented.misc.tools.GlowingBonePickaxe
import net.siegerpg.siege.core.items.implemented.misc.tools.GlowingBoneShovel
import net.siegerpg.siege.core.items.implemented.misc.tools.GlowingIronAxe
import net.siegerpg.siege.core.items.implemented.misc.tools.GlowingIronPickaxe
import net.siegerpg.siege.core.items.implemented.misc.tools.GlowingIronShovel
import net.siegerpg.siege.core.items.implemented.misc.tools.GlowingStoneAxe
import net.siegerpg.siege.core.items.implemented.misc.tools.GlowingStonePickaxe
import net.siegerpg.siege.core.items.implemented.misc.tools.GlowingStoneShovel
import net.siegerpg.siege.core.items.implemented.misc.tools.GlowingWoodenAxe
import net.siegerpg.siege.core.items.implemented.misc.tools.GlowingWoodenPickaxe
import net.siegerpg.siege.core.items.implemented.misc.tools.GlowingWoodenShovel
import net.siegerpg.siege.core.items.implemented.misc.tools.IronAxe
import net.siegerpg.siege.core.items.implemented.misc.tools.IronPickaxe
import net.siegerpg.siege.core.items.implemented.misc.tools.IronShovel
import net.siegerpg.siege.core.items.implemented.misc.tools.StoneAxe
import net.siegerpg.siege.core.items.implemented.misc.tools.StonePickaxe
import net.siegerpg.siege.core.items.implemented.misc.tools.StoneShovel
import net.siegerpg.siege.core.items.implemented.misc.tools.WoodenAxe
import net.siegerpg.siege.core.items.implemented.misc.tools.WoodenPickaxe
import net.siegerpg.siege.core.items.implemented.misc.tools.WoodenShovel
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Marco : Shop() {

	override var name: String = "Marco"
	override var permission: String = "siege.shops.shop.marco"
	override var items: List<ShopItem> = listOf(
		//WOODEN
		ShopItem(WoodenPickaxe(0), 200, hashMapOf(), false) {
			WoodenPickaxe(0).getUpdatedItem(false)
		},
		ShopItem(WoodenShovel(0), 200, hashMapOf(), false) {
			WoodenShovel(0).getUpdatedItem(false)
		},
		ShopItem(WoodenAxe(0), 200, hashMapOf(), false) {
			WoodenAxe(0).getUpdatedItem(false)
		},
		ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
			GRAYFILLER(-1).getUpdatedItem(false)
		},
		ShopItem(GlowingWoodenPickaxe(0), 400, hashMapOf(), false) {
			GlowingWoodenPickaxe(0).getUpdatedItem(false)
		},
		ShopItem(GlowingWoodenShovel(0), 400, hashMapOf(), false) {
			GlowingWoodenShovel(0).getUpdatedItem(false)
		},
		ShopItem(GlowingWoodenAxe(0), 400, hashMapOf(), false) {
			GlowingWoodenAxe(0).getUpdatedItem(false)
		},

		//BONE
		ShopItem(BonePickaxe(0), 600, hashMapOf(), false) {
			BonePickaxe(0).getUpdatedItem(false)
		},
		ShopItem(BoneShovel(0), 600, hashMapOf(), false) {
			BoneShovel(0).getUpdatedItem(false)
		},
		ShopItem(BoneAxe(0), 600, hashMapOf(), false) {
			BoneAxe(0).getUpdatedItem(false)
		},
		ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
			GRAYFILLER(-1).getUpdatedItem(false)
		},
		ShopItem(GlowingBonePickaxe(0), 800, hashMapOf(), false) {
			GlowingBonePickaxe(0).getUpdatedItem(false)
		},
		ShopItem(GlowingBoneShovel(0), 800, hashMapOf(), false) {
			GlowingBoneShovel(0).getUpdatedItem(false)
		},
		ShopItem(GlowingBoneAxe(0), 800, hashMapOf(), false) {
			GlowingBoneAxe(0).getUpdatedItem(false)
		},

		//STONE
		ShopItem(StonePickaxe(0), 1300, hashMapOf(), false) {
			StonePickaxe(0).getUpdatedItem(false)
		},
		ShopItem(StoneShovel(0), 1300, hashMapOf(), false) {
			StoneShovel(0).getUpdatedItem(false)
		},
		ShopItem(StoneAxe(0), 1300, hashMapOf(), false) {
			StoneAxe(0).getUpdatedItem(false)
		},
		ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
			GRAYFILLER(-1).getUpdatedItem(false)
		},
		ShopItem(GlowingStonePickaxe(0), 2000, hashMapOf(), false) {
			GlowingStonePickaxe(0).getUpdatedItem(false)
		},
		ShopItem(GlowingStoneShovel(0), 2000, hashMapOf(), false) {
			GlowingStoneShovel(0).getUpdatedItem(false)
		},
		ShopItem(GlowingStoneAxe(0), 2000, hashMapOf(), false) {
			GlowingStoneAxe(0).getUpdatedItem(false)
		},

		//IRON
		ShopItem(IronPickaxe(0), 2500, hashMapOf(), false) {
			IronPickaxe(0).getUpdatedItem(false)
		},
		ShopItem(IronShovel(0), 2500, hashMapOf(), false) {
			IronShovel(0).getUpdatedItem(false)
		},
		ShopItem(IronAxe(0), 2500, hashMapOf(), false) {
			IronAxe(0).getUpdatedItem(false)
		},
		ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
			GRAYFILLER(-1).getUpdatedItem(false)
		},
		ShopItem(GlowingIronPickaxe(0), 3500, hashMapOf(), false) {
			GlowingIronPickaxe(0).getUpdatedItem(false)
		},
		ShopItem(GlowingIronShovel(0), 3500, hashMapOf(), false) {
			GlowingIronShovel(0).getUpdatedItem(false)
		},
		ShopItem(GlowingIronAxe(0), 3500, hashMapOf(), false) {
			GlowingIronAxe(0).getUpdatedItem(false)
		},
	                                           )
}