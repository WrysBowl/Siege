package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey
import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.WoodenSword
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.woodenSwords.*
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class MobKey : Shop() {

	override var name : String = "Mob Keys"
	override var permission : String = "siege.shops.shop.mobKey"
	override var items : List<ShopItem> = listOf(
			//WOODEN SWORDS
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(MobKey(), 2000, hashMapOf(), false) {
				MobKey().getUpdatedItem(false)
			},
			ShopItem(MobKey().asQuantity(4), 7000, hashMapOf(), false) {
				MobKey().getUpdatedItem(false).asQuantity(4)
			},
			ShopItem(MobKey().asQuantity(12), 20000, hashMapOf(), false) {
				MobKey().getUpdatedItem(false).asQuantity(12)
			},
	                                            )
}