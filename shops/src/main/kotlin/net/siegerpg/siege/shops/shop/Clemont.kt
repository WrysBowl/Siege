package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.tools.*
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Clemont : Shop() {

	override var name: String = "Clemont"
	override var permission: String = "siege.shops.shop.clemont"
	override var items: List<ShopItem> = listOf(
		//LUCKY TOOLS
		ShopItem(HammerAndChisel(0), 5000, hashMapOf(), false) {
			HammerAndChisel(0).getUpdatedItem(false)
		},
		ShopItem(Trowel(0), 5000, hashMapOf(), false) {
			Trowel(0).getUpdatedItem(false)
		},
		ShopItem(Handsaw(0), 5000, hashMapOf(), false) {
			Handsaw(0).getUpdatedItem(false)
		},
		ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
			GRAYFILLER(-1).getUpdatedItem(false)
		},
		ShopItem(GlowingHammerAndChisel(0), 8000, hashMapOf(), false) {
			GlowingHammerAndChisel(0).getUpdatedItem(false)
		},
		ShopItem(GlowingTrowel(0), 8000, hashMapOf(), false) {
			GlowingTrowel(0).getUpdatedItem(false)
		},
		ShopItem(GlowingHandsaw(0), 8000, hashMapOf(), false) {
			GlowingHandsaw(0).getUpdatedItem(false)
		},

		//STEEL
		ShopItem(SteelPickaxe(0), 10000, hashMapOf(), false) {
			SteelPickaxe(0).getUpdatedItem(false)
		},
		ShopItem(SteelShovel(0), 10000, hashMapOf(), false) {
			SteelShovel(0).getUpdatedItem(false)
		},
		ShopItem(SteelAxe(0), 10000, hashMapOf(), false) {
			Handsaw(0).getUpdatedItem(false)
		},
		ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
			GRAYFILLER(-1).getUpdatedItem(false)
		},
		ShopItem(GlowingSteelPickaxe(0), 17500, hashMapOf(), false) {
			GlowingSteelPickaxe(0).getUpdatedItem(false)
		},
		ShopItem(GlowingSteelShovel(0), 17500, hashMapOf(), false) {
			GlowingSteelShovel(0).getUpdatedItem(false)
		},
		ShopItem(GlowingSteelAxe(0), 17500, hashMapOf(), false) {
			GlowingSteelAxe(0).getUpdatedItem(false)
		},

		//TITANIUM
		ShopItem(TitaniumPickaxe(0), 30000, hashMapOf(), false) {
			TitaniumPickaxe(0).getUpdatedItem(false)
		},
		ShopItem(TitaniumShovel(0), 30000, hashMapOf(), false) {
			TitaniumShovel(0).getUpdatedItem(false)
		},
		ShopItem(TitaniumAxe(0), 30000, hashMapOf(), false) {
			TitaniumAxe(0).getUpdatedItem(false)
		},
		ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
			GRAYFILLER(-1).getUpdatedItem(false)
		},
		ShopItem(GlowingTitaniumPickaxe(0), 50000, hashMapOf(), false) {
			GlowingTitaniumPickaxe(0).getUpdatedItem(false)
		},
		ShopItem(GlowingTitaniumShovel(0), 50000, hashMapOf(), false) {
			GlowingTitaniumShovel(0).getUpdatedItem(false)
		},
		ShopItem(GlowingTitaniumAxe(0), 50000, hashMapOf(), false) {
			GlowingTitaniumAxe(0).getUpdatedItem(false)
		},
	                                           )
}