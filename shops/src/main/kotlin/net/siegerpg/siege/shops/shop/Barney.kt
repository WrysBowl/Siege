package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Dagger
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Shank
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.daggers.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.shanks.*
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Barney : Shop() {

	override var name : String = "Barney"
	override var permission : String = "siege.shops.shop.barney"
	override var items : List<ShopItem> = listOf(
			//SHANK
			ShopItem(Shank(-1), 1500, hashMapOf(), false) {
				Shank(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(LuckyShank(-1), 2500, hashMapOf(), false) {
				LuckyShank(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(StrongShank(-1), 2500, hashMapOf(), false) {
				StrongShank(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(ToughShank(-1), 2500, hashMapOf(), false) {
				ToughShank(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(HealthyShank(-1), 2500, hashMapOf(), false) {
				HealthyShank(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(HealingShank(-1), 2500, hashMapOf(), false) {
				HealingShank(Utils.randRarity()).getUpdatedItem(false)
			},

			//DAGGERS
			ShopItem(Dagger(-1), 2000, hashMapOf(), false) {
				Dagger(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(LuckyDagger(-1), 4000, hashMapOf(), false) {
				LuckyDagger(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(StrongDagger(-1), 4000, hashMapOf(), false) {
				StrongDagger(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(ToughDagger(-1), 4000, hashMapOf(), false) {
				ToughDagger(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(HealthyDagger(-1), 4000, hashMapOf(), false) {
				HealthyDagger(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(HealingDagger(-1), 4000, hashMapOf(), false) {
				HealingDagger(Utils.randRarity()).getUpdatedItem(false)
			}
	                                            )
}