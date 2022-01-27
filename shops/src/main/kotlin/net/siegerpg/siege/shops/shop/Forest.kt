package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.WarHammer
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.warHammers.*
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Forest : Shop() {

	override var name : String = "Forest"
	override var permission : String = "siege.shops.shop.forest"
	override var items : List<ShopItem> = listOf(
			//WAR HAMMER
			ShopItem(
					WarHammer(-1), -1, hashMapOf(
					MetalScrap() to 96,
					Pebble() to 128,
					Stick() to 128
					                              ), true
			        ) {
				WarHammer(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyWarHammer(-1), -1, hashMapOf(
					MetalScrap() to 64,
					Pebble() to 128,
					Stick() to 128,
					Feather() to 64
					                                 ), true
			        ) {
				LuckyWarHammer(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongWarHammer(-1), -1, hashMapOf(
					MetalScrap() to 64,
					Pebble() to 128,
					Stick() to 128,
					Bone() to 48
					                                  ), true
			        ) {
				StrongWarHammer(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughWarHammer(-1), -1, hashMapOf(
					MetalScrap() to 64,
					Pebble() to 196,
					Stick() to 128
					                                 ), true
			        ) {
				ToughWarHammer(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyWarHammer(-1), -1, hashMapOf(
					MetalScrap() to 64,
					Pebble() to 128,
					Stick() to 128,
					PlantMatter() to 64
					                                   ), true
			        ) {
				HealthyWarHammer(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingWarHammer(-1), -1, hashMapOf(
					MetalScrap() to 64,
					Pebble() to 128,
					Stick() to 128,
					Wheat() to 256
					                                   ), true
			        ) {
				HealingWarHammer(Utils.randRarity()).getUpdatedItem(false)
			}
	                                            )
}