package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.MetalScrap
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.DoubleBladedAxe
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.GreatSword
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.doubleBladedAxes.HealingDoubleBladedAxe
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.doubleBladedAxes.HealthyDoubleBladedAxe
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.doubleBladedAxes.LuckyDoubleBladedAxe
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.doubleBladedAxes.StrongDoubleBladedAxe
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.doubleBladedAxes.ToughDoubleBladedAxe
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.greatSwords.HealingGreatSword
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.greatSwords.HealthyGreatSword
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.greatSwords.LuckyGreatSword
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.greatSwords.StrongGreatSword
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.greatSwords.ToughGreatSword
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Gale : Shop() {

	override var name: String = "Gale"
	override var permission: String = "siege.shops.shop.gale"
	override var items: List<ShopItem> = listOf(
		//DOUBLE BLADED AXE
		ShopItem(DoubleBladedAxe(-1), 3000, hashMapOf(), false) {
			DoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
			GRAYFILLER(-1).getUpdatedItem(false)
		},
		ShopItem(
			LuckyDoubleBladedAxe(-1), -1, hashMapOf(
				Pebble.tier(3) to 3,
				Stick.tier(3) to 2,
				Feather.tier(3) to 2
			                                       ), true
		        ) {
			LuckyDoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			StrongDoubleBladedAxe(-1), -1, hashMapOf(
				Pebble.tier(3) to 3,
				Stick.tier(3) to 2,
				Bone.tier(3) to 2
			                                        ), true
		        ) {
			StrongDoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			ToughDoubleBladedAxe(-1), -1, hashMapOf(
				Pebble.tier(4) to 1,
				Stick.tier(3) to 2
			                                       ), true
		        ) {
			ToughDoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealthyDoubleBladedAxe(-1), -1, hashMapOf(
				Pebble.tier(3) to 3,
				Stick.tier(3) to 2,
				PlantMatter.tier(3) to 2
			                                         ), true
		        ) {
			HealthyDoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealingDoubleBladedAxe(-1), -1, hashMapOf(
				Pebble.tier(3) to 3,
				Stick.tier(3) to 2,
				Wheat.tier(4) to 1
			                                         ), true
		        ) {
			HealingDoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false)
		},

		//GREAT SWORD
		ShopItem(
			GreatSword(-1), 3750, hashMapOf(
				MetalScrap.tier(3) to 2,
				Stick.tier(3) to 1
			                               ), true
		        ) {
			GreatSword(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
			GRAYFILLER(-1).getUpdatedItem(false)
		},
		ShopItem(
			LuckyGreatSword(-1), 4000, hashMapOf(
				MetalScrap.tier(3) to 1,
				Stick.tier(3) to 1,
				Feather.tier(3) to 2
			                                    ), true
		        ) {
			LuckyGreatSword(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			StrongGreatSword(-1), 4000, hashMapOf(
				MetalScrap.tier(3) to 1,
				Stick.tier(3) to 1,
				Bone.tier(3) to 2
			                                     ), true
		        ) {
			StrongGreatSword(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			ToughGreatSword(-1), 4000, hashMapOf(
				MetalScrap.tier(3) to 1,
				Stick.tier(3) to 1,
				Pebble.tier(3) to 3
			                                    ), true
		        ) {
			ToughGreatSword(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealthyGreatSword(-1), 4000, hashMapOf(
				MetalScrap.tier(3) to 1,
				Stick.tier(3) to 1,
				PlantMatter.tier(3) to 2
			                                      ), true
		        ) {
			HealthyGreatSword(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealingGreatSword(-1), 4000, hashMapOf(
				MetalScrap.tier(3) to 1,
				Stick.tier(3) to 1,
				Wheat.tier(4) to 1
			                                      ), true
		        ) {
			HealingGreatSword(Utils.randRarity()).getUpdatedItem(false)
		}
	                                           )
}