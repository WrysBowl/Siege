package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.weapons.wands.HotRod
import net.siegerpg.siege.core.items.implemented.weapons.wands.hotRods.*
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Margaret : Shop() {

	override var name : String = "Margaret"
	override var permission : String = "siege.shops.shop.margaret"
	override var items : List<ShopItem> = listOf(
			//HOT ROD
			ShopItem(
					HotRod(-1), -1, hashMapOf(
					PlantMatter() to 196,
					Seed() to 256,
					Coal() to 64
					                         ), true
			        ) {
				HotRod(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyHotRod(-1), -1, hashMapOf(
					PlantMatter() to 196,
					Seed() to 196,
					Coal() to 64,
					Feather() to 64
					                              ), true
			        ) {
				LuckyHotRod(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongHotRod(-1), -1, hashMapOf(
					PlantMatter() to 196,
					Seed() to 196,
					Coal() to 64,
					Bone() to 48
					                               ), true
			        ) {
				StrongHotRod(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughHotRod(-1), -1, hashMapOf(
					PlantMatter() to 196,
					Seed() to 196,
					Coal() to 64,
					Pebble() to 64
					                              ), true
			        ) {
				ToughHotRod(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyHotRod(-1), -1, hashMapOf(
					PlantMatter() to 384,
					Seed() to 128,
					Coal() to 64
					                                ), true
			        ) {
				HealthyHotRod(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingHotRod(-1), -1, hashMapOf(
					PlantMatter() to 196,
					Seed() to 196,
					Coal() to 64,
					Wheat() to 512
					                                ), true
			        ) {
				HealingHotRod(Utils.randRarity()).getUpdatedItem(false)
			},
	                                            )
}