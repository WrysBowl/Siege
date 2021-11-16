package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Coal
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Seed
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.weapons.wands.HotRod
import net.siegerpg.siege.core.items.implemented.weapons.wands.hotRods.HealingHotRod
import net.siegerpg.siege.core.items.implemented.weapons.wands.hotRods.HealthyHotRod
import net.siegerpg.siege.core.items.implemented.weapons.wands.hotRods.LuckyHotRod
import net.siegerpg.siege.core.items.implemented.weapons.wands.hotRods.StrongHotRod
import net.siegerpg.siege.core.items.implemented.weapons.wands.hotRods.ToughHotRod
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Margaret : Shop() {

	override var name: String = "Margaret"
	override var permission: String = "siege.shops.shop.margaret"
	override var items: List<ShopItem> = listOf(
		//HOT ROD
		ShopItem(
			HotRod(-1), 6500, hashMapOf(
				PlantMatter.tier(3) to 1,
				Seed.tier(4) to 2,
				Coal.tier(4) to 2
			                           ), true
		        ) {
			HotRod(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
			GRAYFILLER(-1).getUpdatedItem(false)
		},
		ShopItem(
			LuckyHotRod(-1), -1, hashMapOf(
				PlantMatter.tier(3) to 1,
				Seed.tier(4) to 1,
				Coal.tier(4) to 1,
				Feather.tier(4) to 2
			                              ), true
		        ) {
			LuckyHotRod(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			StrongHotRod(-1), -1, hashMapOf(
				PlantMatter.tier(3) to 1,
				Seed.tier(4) to 1,
				Coal.tier(4) to 1,
				Bone.tier(4) to 1
			                               ), true
		        ) {
			StrongHotRod(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			ToughHotRod(-1), -1, hashMapOf(
				PlantMatter.tier(3) to 1,
				Seed.tier(4) to 1,
				Coal.tier(4) to 1,
				Pebble.tier(4) to 3
			                              ), true
		        ) {
			ToughHotRod(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealthyHotRod(-1), -1, hashMapOf(
				PlantMatter.tier(4) to 2,
				Seed.tier(4) to 1,
				Coal.tier(4) to 1
			                                ), true
		        ) {
			HealthyHotRod(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealingHotRod(-1), -1, hashMapOf(
				PlantMatter.tier(3) to 1,
				Seed.tier(4) to 1,
				Coal.tier(4) to 1,
				Wheat.tier(4) to 3
			                                ), true
		        ) {
			HealingHotRod(Utils.randRarity()).getUpdatedItem(false)
		},
	                                           )
}