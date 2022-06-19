package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.tools.*
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Clemont : Shop() {

	override var name : String = "Clemont"
	override var permission : String = "siege.shops.shop.clemont"
	override var items : List<ShopItem> = listOf(
			//LUCKY TOOLS
			ShopItem(HammerAndChisel(100), 100000, hashMapOf(), false) {
				HammerAndChisel().getUpdatedItem(false)
			},
			ShopItem(Trowel(100), 100000, hashMapOf(), false) {
				Trowel().getUpdatedItem(false)
			},
			ShopItem(Handsaw(100), 100000, hashMapOf(), false) {
				Handsaw().getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(GlowingHammerAndChisel(100), 125000, hashMapOf(), false) {
				GlowingHammerAndChisel().getUpdatedItem(false)
			},
			ShopItem(GlowingTrowel(100), 125000, hashMapOf(), false) {
				GlowingTrowel().getUpdatedItem(false)
			},
			ShopItem(GlowingHandsaw(100), 125000, hashMapOf(), false) {
				GlowingHandsaw().getUpdatedItem(false)
			},

			//STEEL
			ShopItem(SteelPickaxe(100), 175000, hashMapOf(), false) {
				SteelPickaxe().getUpdatedItem(false)
			},
			ShopItem(SteelShovel(100), 175000, hashMapOf(), false) {
				SteelShovel().getUpdatedItem(false)
			},
			ShopItem(SteelAxe(100), 175000, hashMapOf(), false) {
				Handsaw().getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(GlowingSteelPickaxe(100), 200000, hashMapOf(), false) {
				GlowingSteelPickaxe().getUpdatedItem(false)
			},
			ShopItem(GlowingSteelShovel(100), 200000, hashMapOf(), false) {
				GlowingSteelShovel().getUpdatedItem(false)
			},
			ShopItem(GlowingSteelAxe(100), 200000, hashMapOf(), false) {
				GlowingSteelAxe().getUpdatedItem(false)
			},

			//TITANIUM
			ShopItem(TitaniumPickaxe(100), 300000, hashMapOf(), false) {
				TitaniumPickaxe().getUpdatedItem(false)
			},
			ShopItem(TitaniumShovel(100), 300000, hashMapOf(), false) {
				TitaniumShovel().getUpdatedItem(false)
			},
			ShopItem(TitaniumAxe(100), 300000, hashMapOf(), false) {
				TitaniumAxe().getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(GlowingTitaniumPickaxe(100), 500000, hashMapOf(), false) {
				GlowingTitaniumPickaxe().getUpdatedItem(false)
			},
			ShopItem(GlowingTitaniumShovel(100), 500000, hashMapOf(), false) {
				GlowingTitaniumShovel().getUpdatedItem(false)
			},
			ShopItem(GlowingTitaniumAxe(100), 500000, hashMapOf(), false) {
				GlowingTitaniumAxe().getUpdatedItem(false)
			},
	                                            )
}