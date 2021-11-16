package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Vine
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Wool
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Grace : Shop() {

	override var name: String = "Grace"
	override var permission: String = "siege.shops.shop.grace"
	override var items: List<ShopItem> = listOf(
		ShopItem(
			Vine.tier(1).asQuantity(4), -1, hashMapOf(
				Vine.tier(2) to 1
			                                         ), true
		        ) {
			Vine.tier(1).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Bone.tier(1).asQuantity(4) as CustomItem, -1, hashMapOf(
				Bone.tier(2) to 1
			                                                       ), true
		        ) {
			Bone.tier(1).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Wool.tier(1).asQuantity(4) as CustomItem, -1, hashMapOf(
				Wool.tier(2) to 1
			                                                       ), true
		        ) {
			Wool.tier(1).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Leather.tier(1).asQuantity(4) as CustomItem, -1, hashMapOf(
				Leather.tier(2) to 1
			                                                          ), true
		        ) {
			Leather.tier(1).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Wheat.tier(1).asQuantity(4) as CustomItem, -1, hashMapOf(
				Wheat.tier(2) to 1
			                                                        ), true
		        ) {
			Wheat.tier(1).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
			GRAYFILLER(-1).getUpdatedItem(false)
		},
		ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
			GRAYFILLER(-1).getUpdatedItem(false)
		},

		//TIER 3
		ShopItem(
			Vine.tier(2).asQuantity(4) as CustomItem, -1, hashMapOf(
				Vine.tier(3) to 1
			                                                       ), true
		        ) {
			Vine.tier(2).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Bone.tier(2).asQuantity(4) as CustomItem, -1, hashMapOf(
				Bone.tier(3) to 1
			                                                       ), true
		        ) {
			Bone.tier(2).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Wool.tier(2).asQuantity(4) as CustomItem, -1, hashMapOf(
				Wool.tier(3) to 1
			                                                       ), true
		        ) {
			Wool.tier(2).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Leather.tier(2).asQuantity(4) as CustomItem, -1, hashMapOf(
				Leather.tier(3) to 1
			                                                          ), true
		        ) {
			Leather.tier(2).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Wheat.tier(2).asQuantity(4) as CustomItem, -1, hashMapOf(
				Wheat.tier(3) to 1
			                                                        ), true
		        ) {
			Wheat.tier(2).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
			GRAYFILLER(-1).getUpdatedItem(false)
		},
		ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
			GRAYFILLER(-1).getUpdatedItem(false)
		},

		//TIER 4
		ShopItem(
			Vine.tier(3).asQuantity(4) as CustomItem, -1, hashMapOf(
				Vine.tier(4) to 1
			                                                       ), true
		        ) {
			Vine.tier(3).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Bone.tier(3).asQuantity(4) as CustomItem, -1, hashMapOf(
				Bone.tier(4) to 1
			                                                       ), true
		        ) {
			Bone.tier(3).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Wool.tier(3).asQuantity(4) as CustomItem, -1, hashMapOf(
				Wool.tier(4) to 1
			                                                       ), true
		        ) {
			Wool.tier(3).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Leather.tier(3).asQuantity(4) as CustomItem, -1, hashMapOf(
				Leather.tier(4) to 1
			                                                          ), true
		        ) {
			Leather.tier(3).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Wheat.tier(3).asQuantity(4) as CustomItem, -1, hashMapOf(
				Wheat.tier(4) to 1
			                                                        ), true
		        ) {
			Wheat.tier(3).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
			GRAYFILLER(-1).getUpdatedItem(false)
		},
		ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
			GRAYFILLER(-1).getUpdatedItem(false)
		},

		//TIER 5
		ShopItem(
			Vine.tier(4).asQuantity(4) as CustomItem, -1, hashMapOf(
				Vine.tier(5) to 1
			                                                       ), true
		        ) {
			Vine.tier(4).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Bone.tier(4).asQuantity(4) as CustomItem, -1, hashMapOf(
				Bone.tier(5) to 1
			                                                       ), true
		        ) {
			Bone.tier(4).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Wool.tier(4).asQuantity(4) as CustomItem, -1, hashMapOf(
				Wool.tier(5) to 1
			                                                       ), true
		        ) {
			Wool.tier(4).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Leather.tier(4).asQuantity(4) as CustomItem, -1, hashMapOf(
				Leather.tier(5) to 1
			                                                          ), true
		        ) {
			Leather.tier(4).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(
			Wheat.tier(4).asQuantity(4) as CustomItem, -1, hashMapOf(
				Wheat.tier(5) to 1
			                                                        ), true
		        ) {
			Wheat.tier(4).getUpdatedItem(false).asQuantity(4)
		},
		ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
			GRAYFILLER(-1).getUpdatedItem(false)
		},
		ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
			GRAYFILLER(-1).getUpdatedItem(false)
		},
	                                           )
}