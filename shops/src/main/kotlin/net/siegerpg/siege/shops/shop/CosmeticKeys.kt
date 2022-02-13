package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.armor.boots.StrawBoots
import net.siegerpg.siege.core.items.implemented.armor.boots.strawBoots.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.StrawChestplate
import net.siegerpg.siege.core.items.implemented.armor.chestplate.strawChestplates.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.StrawHelmet
import net.siegerpg.siege.core.items.implemented.armor.helmet.strawHelmets.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.StrawLeggings
import net.siegerpg.siege.core.items.implemented.armor.leggings.strawLeggings.*
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.*
import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class CosmeticKeys : Shop() {

	override var name : String = "Cosmetic Keys"
	override var permission : String = "siege.shops.shop.cosmeticKeys"
	override var items : List<ShopItem> = listOf(
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			//COMMON
			ShopItem(CommonKey(-1), 5000, hashMapOf(), false
			        ) {
				CommonKey(0).getUpdatedItem(false)
			},

			//UNCOMMON
			ShopItem(UncommonKey(-1), 10000, hashMapOf(), false
			        ) {
				UncommonKey(0).getUpdatedItem(false)
			},

			//NORMAL
			ShopItem(NormalKey(-1), 7500, hashMapOf(), false
			        ) {
				NormalKey(0).getUpdatedItem(false)
			},

			//SUPERIOR
			ShopItem(SuperiorKey(-1), 15000, hashMapOf(), false
			        ) {
				SuperiorKey(0).getUpdatedItem(false)
			},

			//RARE
			ShopItem(RareKey(-1), 20000, hashMapOf(), false
			        ) {
				RareKey(0).getUpdatedItem(false)
			},
	                                            )

}