package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.DoubleBladedAxe
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.GreatSword
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.doubleBladedAxes.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.greatSwords.*
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Gale : Shop() {

	override var name : String = "Gale"
	override var permission : String = "siege.shops.shop.gale"
	override var items : List<ShopItem> = listOf(
			//DOUBLE BLADED AXE
			ShopItem(DoubleBladedAxe(-1), 25000, hashMapOf(), false) {
				DoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyDoubleBladedAxe(-1), -1, hashMapOf(
					Pebble() to 196,
					Stick() to 128,
					Feather() to 64
					                                       ), true
			        ) {
				LuckyDoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongDoubleBladedAxe(-1), -1, hashMapOf(
					Pebble() to 196,
					Stick() to 128,
					Bone() to 48
					                                        ), true
			        ) {
				StrongDoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughDoubleBladedAxe(-1), -1, hashMapOf(
					Pebble() to 256,
					Stick() to 128
					                                       ), true
			        ) {
				ToughDoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyDoubleBladedAxe(-1), -1, hashMapOf(
					Pebble() to 196,
					Stick() to 128,
					PlantMatter() to 64
					                                         ), true
			        ) {
				HealthyDoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingDoubleBladedAxe(-1), -1, hashMapOf(
					Pebble() to 196,
					Stick() to 128,
					Wheat() to 256
					                                         ), true
			        ) {
				HealingDoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false)
			},

			//GREAT SWORD
			ShopItem(
					GreatSword(-1), -1, hashMapOf(
					MetalScrap() to 128,
					Stick() to 64
					                             ), true
			        ) {
				GreatSword(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyGreatSword(-1), -1, hashMapOf(
					MetalScrap() to 96,
					Stick() to 64,
					Feather() to 32
					                                  ), true
			        ) {
				LuckyGreatSword(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongGreatSword(-1), -1, hashMapOf(
					MetalScrap() to 96,
					Stick() to 64,
					Bone() to 24
					                                   ), true
			        ) {
				StrongGreatSword(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughGreatSword(-1), -1, hashMapOf(
					MetalScrap() to 96,
					Stick() to 64,
					Pebble() to 32
					                                  ), true
			        ) {
				ToughGreatSword(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyGreatSword(-1), -1, hashMapOf(
					MetalScrap() to 96,
					Stick() to 64,
					PlantMatter() to 32
					                                    ), true
			        ) {
				HealthyGreatSword(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingGreatSword(-1), -1, hashMapOf(
					MetalScrap() to 96,
					Stick() to 64,
					Wheat() to 128
					                                    ), true
			        ) {
				HealingGreatSword(Utils.randRarity()).getUpdatedItem(false)
			}
	                                            )
}