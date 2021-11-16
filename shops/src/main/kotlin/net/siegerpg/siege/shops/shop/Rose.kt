package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Seed
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Magma
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Slime
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Rose : Shop() {

	override var name: String = "Rose"
	override var permission: String = "siege.shops.shop.rose"
	override var items: List<ShopItem> = listOf(
		ShopItem(
			Slime.tier(1).asQuantity(4), -1, hashMapOf(
				Slime.tier(2) to 1
			                                          ), true
		        ) {
			Slime.tier(1).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Feather.tier(1).asQuantity(4) as CustomItem, -1, hashMapOf(
				Feather.tier(2) to 1
			                                                          ), true
		        ) {
			Feather.tier(1).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Magma.tier(1).asQuantity(4) as CustomItem, -1, hashMapOf(
				Magma.tier(2) to 1
			                                                        ), true
		        ) {
			Magma.tier(1).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			PlantMatter.tier(1).asQuantity(4) as CustomItem, -1, hashMapOf(
				PlantMatter.tier(2) to 1
			                                                              ), true
		        ) {
			PlantMatter.tier(1).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Seed.tier(1).asQuantity(4) as CustomItem, -1, hashMapOf(
				Seed.tier(2) to 1
			                                                       ), true
		        ) {
			Seed.tier(1).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Stick.tier(1).asQuantity(4) as CustomItem, -1, hashMapOf(
				Stick.tier(2) to 1
			                                                        ), true
		        ) {
			Stick.tier(1).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Pebble.tier(1).asQuantity(4) as CustomItem, -1, hashMapOf(
				Pebble.tier(2) to 1
			                                                         ), true
		        ) {
			Pebble.tier(1).getUpdatedItem(false).asQuantity(4)
		},

		//TIER 3
		ShopItem(
			Slime.tier(2).asQuantity(4) as CustomItem, -1, hashMapOf(
				Slime.tier(3) to 1
			                                                        ), true
		        ) {
			Slime.tier(2).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Feather.tier(2).asQuantity(4) as CustomItem, -1, hashMapOf(
				Feather.tier(3) to 1
			                                                          ), true
		        ) {
			Feather.tier(2).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Magma.tier(2).asQuantity(4) as CustomItem, -1, hashMapOf(
				Magma.tier(3) to 1
			                                                        ), true
		        ) {
			Magma.tier(2).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			PlantMatter.tier(2).asQuantity(4) as CustomItem, -1, hashMapOf(
				PlantMatter.tier(3) to 1
			                                                              ), true
		        ) {
			PlantMatter.tier(2).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Seed.tier(2).asQuantity(4) as CustomItem, -1, hashMapOf(
				Seed.tier(3) to 1
			                                                       ), true
		        ) {
			Seed.tier(2).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Stick.tier(2).asQuantity(4) as CustomItem, -1, hashMapOf(
				Stick.tier(3) to 1
			                                                        ), true
		        ) {
			Stick.tier(2).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Pebble.tier(2).asQuantity(4) as CustomItem, -1, hashMapOf(
				Pebble.tier(3) to 1
			                                                         ), true
		        ) {
			Pebble.tier(2).getUpdatedItem(false).asQuantity(4)
		},

		//TIER 4
		ShopItem(
			Slime.tier(3).asQuantity(4) as CustomItem, -1, hashMapOf(
				Slime.tier(4) to 1
			                                                        ), true
		        ) {
			Slime.tier(3).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Feather.tier(3).asQuantity(4) as CustomItem, -1, hashMapOf(
				Feather.tier(4) to 1
			                                                          ), true
		        ) {
			Feather.tier(3).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Magma.tier(3).asQuantity(4) as CustomItem, -1, hashMapOf(
				Magma.tier(4) to 1
			                                                        ), true
		        ) {
			Magma.tier(3).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			PlantMatter.tier(3).asQuantity(4) as CustomItem, -1, hashMapOf(
				PlantMatter.tier(4) to 1
			                                                              ), true
		        ) {
			PlantMatter.tier(3).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Seed.tier(3).asQuantity(4) as CustomItem, -1, hashMapOf(
				Seed.tier(4) to 1
			                                                       ), true
		        ) {
			Seed.tier(3).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Stick.tier(3).asQuantity(4) as CustomItem, -1, hashMapOf(
				Stick.tier(4) to 1
			                                                        ), true
		        ) {
			Stick.tier(3).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Pebble.tier(3).asQuantity(4) as CustomItem, -1, hashMapOf(
				Pebble.tier(4) to 1
			                                                         ), true
		        ) {
			Pebble.tier(3).getUpdatedItem(false).asQuantity(4)
		},

		//TIER 5
		ShopItem(
			Slime.tier(4).asQuantity(4) as CustomItem, -1, hashMapOf(
				Pebble.tier(5) to 1
			                                                        ), true
		        ) {
			Pebble.tier(4).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Feather.tier(4).asQuantity(4) as CustomItem, -1, hashMapOf(
				Feather.tier(5) to 1
			                                                          ), true
		        ) {
			Feather.tier(4).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Magma.tier(4).asQuantity(4) as CustomItem, -1, hashMapOf(
				Magma.tier(5) to 1
			                                                        ), true
		        ) {
			Magma.tier(4).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			PlantMatter.tier(4).asQuantity(4) as CustomItem, -1, hashMapOf(
				PlantMatter.tier(5) to 1
			                                                              ), true
		        ) {
			PlantMatter.tier(4).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Seed.tier(4).asQuantity(4) as CustomItem, -1, hashMapOf(
				Seed.tier(5) to 1
			                                                       ), true
		        ) {
			Seed.tier(4).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Stick.tier(4).asQuantity(4) as CustomItem, -1, hashMapOf(
				Stick.tier(5) to 1
			                                                        ), true
		        ) {
			Stick.tier(4).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Pebble.tier(4).asQuantity(4) as CustomItem, -1, hashMapOf(
				Pebble.tier(5) to 1
			                                                         ), true
		        ) {
			Pebble.tier(4).getUpdatedItem(false).asQuantity(4)
		},
	                                           )
}