package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.weapons.wands.RockWand
import net.siegerpg.siege.core.items.implemented.weapons.wands.rockWands.*
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Edith : Shop() {

	override var name : String = "Edith"
	override var permission : String = "siege.shops.shop.edith"
	override var items : List<ShopItem> = listOf(
			//ROCK WAND
			ShopItem(
					RockWand(-1), -1, hashMapOf(
					Pebble() to 64,
					Stick() to 128
					                             ), true
			        ) {
				RockWand(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyRockWand(-1), -1, hashMapOf(
					Pebble() to 64,
					Feather() to 128,
					Stick() to 128
					                                ), true
			        ) {
				LuckyRockWand(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongRockWand(-1), -1, hashMapOf(
					Pebble() to 64,
					Feather() to 64,
					Bone() to 64
					                                 ), true
			        ) {
				StrongRockWand(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughRockWand(-1), -1, hashMapOf(
					Pebble() to 196,
					Stick() to 64
					                                ), true
			        ) {
				ToughRockWand(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyRockWand(-1), -1, hashMapOf(
					Pebble() to 64,
					PlantMatter() to 128,
					Stick() to 64
					                                  ), true
			        ) {
				HealthyRockWand(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingRockWand(-1), -1, hashMapOf(
					Pebble() to 64,
					Wheat() to 196,
					Stick() to 64
					                                  ), true
			        ) {
				HealingRockWand(Utils.randRarity()).getUpdatedItem(false)
			}
	                                            )
}