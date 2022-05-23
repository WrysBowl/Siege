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
			ShopItem(HealthPotionI(-1), 1500, hashMapOf(), false) {
				HealthPotionI().getUpdatedItem(false)
			},
			ShopItem(HealthPotionII(-1), 2000, hashMapOf(), false) {
				HealthPotionII().getUpdatedItem(false)
			},
			ShopItem(HealthPotionIII(-1), 2500, hashMapOf(), false) {
				HealthPotionIII().getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			//SLIME POTION
			ShopItem(SlimyI(-1), 1500, hashMapOf(), false) {
				SlimyI().getUpdatedItem(false)
			},
			ShopItem(SlimyII(-1), 2000, hashMapOf(), false) {
				SlimyII().getUpdatedItem(false)
			},
			ShopItem(SlimyIII(-1), 2500, hashMapOf(), false) {
				SlimyIII().getUpdatedItem(false)
			},

			//BURN
			ShopItem(BurnI(-1), 1750, hashMapOf(), false) {
				BurnI().getUpdatedItem(false)
			},
			ShopItem(BurnII(-1), 2500, hashMapOf(), false) {
				BurnII().getUpdatedItem(false)
			},
			ShopItem(BurnIII(-1), 3250, hashMapOf(), false) {
				BurnIII().getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			//BERSERK
			ShopItem(BerserkI(-1), 2000, hashMapOf(), false) {
				BerserkI().getUpdatedItem(false)
			},
			ShopItem(BerserkII(-1), 2500, hashMapOf(), false) {
				BerserkII().getUpdatedItem(false)
			},
			ShopItem(BerserkIII(-1), 3500, hashMapOf(), false) {
				BerserkIII().getUpdatedItem(false)
			},

			//AoESlowness
			ShopItem(AoESlownessI(-1), 1750, hashMapOf(), false) {
				AoESlownessI().getUpdatedItem(false)
			},
			ShopItem(AoESlownessII(-1), 2500, hashMapOf(), false) {
				AoESlownessII().getUpdatedItem(false)
			},
			ShopItem(AoESlownessIII(-1), 3250, hashMapOf(), false) {
				AoESlownessIII().getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			//AoEPoison
			ShopItem(AoEPoisonI(-1), 2000, hashMapOf(), false) {
				AoEPoisonI().getUpdatedItem(false)
			},
			ShopItem(AoEPoisonII(-1), 2500, hashMapOf(), false) {
				AoEPoisonII().getUpdatedItem(false)
			},
			ShopItem(AoEPoisonIII(-1), 3500, hashMapOf(), false) {
				AoEPoisonIII().getUpdatedItem(false)
			},
	                                            )
}