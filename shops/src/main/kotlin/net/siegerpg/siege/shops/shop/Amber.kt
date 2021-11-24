package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.potions.*
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Amber : Shop() {

	override var name : String = "Amber"
	override var permission : String = "siege.shops.shop.amber"
	override var items : List<ShopItem> = listOf(
			//HEALTH POTIONS
			ShopItem(HealthPotionI(-1), 500, hashMapOf(), false) {
				HealthPotionI(0).getUpdatedItem(false)
			},
			ShopItem(HealthPotionII(-1), 1000, hashMapOf(), false) {
				HealthPotionII(0).getUpdatedItem(false)
			},
			ShopItem(HealthPotionIII(-1), 1500, hashMapOf(), false) {
				HealthPotionIII(0).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			//SLIME POTION
			ShopItem(SlimyI(-1), 500, hashMapOf(), false) {
				SlimyI(0).getUpdatedItem(false)
			},
			ShopItem(SlimyII(-1), 1000, hashMapOf(), false) {
				SlimyII(0).getUpdatedItem(false)
			},
			ShopItem(SlimyIII(-1), 1500, hashMapOf(), false) {
				SlimyIII(0).getUpdatedItem(false)
			},

			//BURN
			ShopItem(BurnI(-1), 750, hashMapOf(), false) {
				BurnI(0).getUpdatedItem(false)
			},
			ShopItem(BurnII(-1), 1500, hashMapOf(), false) {
				BurnII(0).getUpdatedItem(false)
			},
			ShopItem(BurnIII(-1), 2250, hashMapOf(), false) {
				BurnIII(0).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			//BERSERK
			ShopItem(BerserkI(-1), 1000, hashMapOf(), false) {
				BerserkI(0).getUpdatedItem(false)
			},
			ShopItem(BerserkII(-1), 1500, hashMapOf(), false) {
				BerserkII(0).getUpdatedItem(false)
			},
			ShopItem(BerserkIII(-1), 2500, hashMapOf(), false) {
				BerserkIII(0).getUpdatedItem(false)
			},

			//AoESlowness
			ShopItem(AoESlownessI(-1), 750, hashMapOf(), false) {
				AoESlownessI(0).getUpdatedItem(false)
			},
			ShopItem(AoESlownessII(-1), 1500, hashMapOf(), false) {
				AoESlownessII(0).getUpdatedItem(false)
			},
			ShopItem(AoESlownessIII(-1), 2250, hashMapOf(), false) {
				AoESlownessIII(0).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			//AoEPoison
			ShopItem(AoEPoisonI(-1), 1000, hashMapOf(), false) {
				AoEPoisonI(0).getUpdatedItem(false)
			},
			ShopItem(AoEPoisonII(-1), 1500, hashMapOf(), false) {
				AoEPoisonII(0).getUpdatedItem(false)
			},
			ShopItem(AoEPoisonIII(-1), 2500, hashMapOf(), false) {
				AoEPoisonIII(0).getUpdatedItem(false)
			},
	                                            )
}