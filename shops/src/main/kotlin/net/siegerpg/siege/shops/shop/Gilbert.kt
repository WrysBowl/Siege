package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.*
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Gilbert : Shop() {

	override var name : String = "Gilbert"
	override var permission : String = "siege.shops.shop.gilbert"
	override var items : List<ShopItem> = listOf(
			//IRON AXE
			ShopItem(IronAxe(-1), -1, hashMapOf(
					RefinedMetal() to 96,
					Stick() to 196
											   ), false) {
				IronAxe(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyIronAxe(-1), -1, hashMapOf(
					RefinedMetal() to 96,
					Stick() to 96,
					Feather() to 64
					                               ), true
			        ) {
				LuckyIronAxe(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongIronAxe(-1), -1, hashMapOf(
					RefinedMetal() to 96,
					Stick() to 96,
					Bone() to 48
					                                ), true
			        ) {
				StrongIronAxe(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughIronAxe(-1), -1, hashMapOf(
					RefinedMetal() to 96,
					Stick() to 96,
					Pebble() to 64
					                               ), true
			        ) {
				ToughIronAxe(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyIronAxe(-1), -1, hashMapOf(
					RefinedMetal() to 96,
					Stick() to 96,
					PlantMatter() to 64
					                                 ), true
			        ) {
				HealthyIronAxe(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingIronAxe(-1), -1, hashMapOf(
					RefinedMetal() to 96,
					Stick() to 96,
					Wheat() to 256
					                                 ), true
			        ) {
				HealingIronAxe(Utils.randRarity()).getUpdatedItem(false)
			},
	                                            )
}