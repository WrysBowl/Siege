package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.Club
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.ScrapShard
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.scrapShards.*
import net.siegerpg.siege.core.items.implemented.weapons.ranged.ScrapyardBow
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Tutorial : Shop() {

	override var name : String = "Shop"
	override var permission : String = "siege.shops.shop.tutorial"
	override var items : List<ShopItem> = listOf(
			
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					ScrapyardBow(-1), -1, hashMapOf(
					Stick() to 24,
					Vine() to 16
					                               ), true
			        ) {
				ScrapyardBow(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					Club(-1), -1, hashMapOf(
					Stick() to 24,
					Pebble() to 10
					                       ), true
			        ) {
				Club(Utils.randRarity()).getUpdatedItem(false)
			},
	                                            )
}