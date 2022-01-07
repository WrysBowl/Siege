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
					MetalScrap.tier(3) to 1,
					Pebble.tier(3) to 4,
					Stick.tier(3) to 2
					                              ), true
			        ) {
				WarHammer(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyWarHammer(-1), -1, hashMapOf(
					MetalScrap.tier(3) to 1,
					Pebble.tier(3) to 2,
					Stick.tier(3) to 2,
					Feather.tier(3) to 2
					                                 ), true
			        ) {
				LuckyWarHammer(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongWarHammer(-1), -1, hashMapOf(
					MetalScrap.tier(3) to 1,
					Pebble.tier(3) to 2,
					Stick.tier(3) to 2,
					Bone.tier(3) to 4
					                                  ), true
			        ) {
				StrongWarHammer(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughWarHammer(-1), -1, hashMapOf(
					MetalScrap.tier(3) to 1,
					Pebble.tier(3) to 1,
					Stick.tier(3) to 2
					                                 ), true
			        ) {
				ToughWarHammer(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyWarHammer(-1), -1, hashMapOf(
					MetalScrap.tier(3) to 1,
					Pebble.tier(3) to 2,
					Stick.tier(3) to 2,
					PlantMatter.tier(3) to 2
					                                   ), true
			        ) {
				HealthyWarHammer(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingWarHammer(-1), -1, hashMapOf(
					MetalScrap.tier(3) to 1,
					Pebble.tier(3) to 2,
					Stick.tier(3) to 2,
					Wheat.tier(3) to 1
					                                   ), true
			        ) {
				HealingWarHammer(Utils.randRarity()).getUpdatedItem(false)
			}
	                                            )
}