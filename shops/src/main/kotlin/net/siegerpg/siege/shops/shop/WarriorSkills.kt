package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.skills.warrior.*
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class WarriorSkills : Shop() {

	override var name : String = "Warrior Skills"
	override var permission : String = "siege.shops.shop.warriorSkills"
	override var items : List<ShopItem> = listOf(
			ShopItem(Armory(1), -1, hashMapOf(), false) {
				Armory(1).getUpdatedItem(false)
			},
			ShopItem(Armory(1), -1, hashMapOf(), false) {
				Armory(1).getUpdatedItem(false)
			},
			ShopItem(BloodLust(1), -1, hashMapOf(), false) {
				BloodLust(1).getUpdatedItem(false)
			},
			ShopItem(BloodWork(1), -1, hashMapOf(), false) {
				BloodWork(1).getUpdatedItem(false)
			},
			ShopItem(ConcentratedStrike(1), -1, hashMapOf(), false) {
				ConcentratedStrike(1).getUpdatedItem(false)
			},
			ShopItem(DivinePresence(1), -1, hashMapOf(), false) {
				DivinePresence(1).getUpdatedItem(false)
			},
			ShopItem(DoubleStrike(1), -1, hashMapOf(), false) {
				DoubleStrike(1).getUpdatedItem(false)
			},
			ShopItem(GroundPound(1), -1, hashMapOf(), false) {
				GroundPound(1).getUpdatedItem(false)
			},
			ShopItem(LightField(1), -1, hashMapOf(), false) {
				LightField(1).getUpdatedItem(false)
			},
			ShopItem(Lunge(1), -1, hashMapOf(), false) {
				Lunge(1).getUpdatedItem(false)
			},
			ShopItem(Parry(1), -1, hashMapOf(), false) {
				Parry(1).getUpdatedItem(false)
			},
			ShopItem(QuakeCharge(1), -1, hashMapOf(), false) {
				QuakeCharge(1).getUpdatedItem(false)
			},
			ShopItem(SelflessDefense(1), -1, hashMapOf(), false) {
				SelflessDefense(1).getUpdatedItem(false)
			},
			ShopItem(Slash(1), -1, hashMapOf(), false) {
				Slash(1).getUpdatedItem(false)
			},
			ShopItem(Taunt(1), -1, hashMapOf(), false) {
				Taunt(1).getUpdatedItem(false)
			},
			ShopItem(WarCry(1), -1, hashMapOf(), false) {
				WarCry(1).getUpdatedItem(false)
			},
			ShopItem(WoundingStrike(1), -1, hashMapOf(), false) {
				WoundingStrike(1).getUpdatedItem(false)
			}
			)
}