package net.siegerpg.siege.shops.shop.materials

import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Vine
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Wool
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Bones : Shop() {

	override var name : String = "Bone"
	override var permission : String = "siege.shops.shop.bone"
	override var items : List<ShopItem> = listOf(
			ShopItem(Bone.tier(2), -1, hashMapOf(
					Bone.tier(1) to 8), true) {
				Bone.tier(2).getUpdatedItem(false)
			},
			ShopItem(Bone.tier(3), -1, hashMapOf(
					Bone.tier(2) to 8), true) {
				Bone.tier(3).getUpdatedItem(false)
			},
			ShopItem(Bone.tier(4), -1, hashMapOf(
					Bone.tier(3) to 8), true) {
				Bone.tier(4).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(Bone.tier(1).asQuantity(8) as CustomItem, -1, hashMapOf(
					Bone.tier(2) to 1), true) {
				Bone.tier(1).getUpdatedItem(false).asQuantity(8)
			},
			ShopItem(Bone.tier(2).asQuantity(8) as CustomItem, -1, hashMapOf(
					Bone.tier(3) to 1), true) {
				Bone.tier(2).getUpdatedItem(false).asQuantity(8)
			},
			ShopItem(Bone.tier(3).asQuantity(8) as CustomItem, -1, hashMapOf(
					Bone.tier(4) to 1), true) {
				Bone.tier(3).getUpdatedItem(false).asQuantity(8)
			},

	                                            )
}