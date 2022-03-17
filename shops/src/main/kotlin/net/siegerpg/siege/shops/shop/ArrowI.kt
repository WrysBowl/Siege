package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.arrows.Arrow
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.FemurBone
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.femurBones.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Spade
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.spades.*
import net.siegerpg.siege.core.items.implemented.weapons.ranged.PebbleShooter
import net.siegerpg.siege.core.items.implemented.weapons.ranged.pebbleShooters.*
import net.siegerpg.siege.core.items.implemented.weapons.wands.GlowingTwig
import net.siegerpg.siege.core.items.implemented.weapons.wands.glowingTwigs.*
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class ArrowI : Shop() {

	override var name : String = "Arrow Shop I"
	override var permission : String = "siege.shops.shop.arrowI"
	override var items : List<ShopItem> = listOf(
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					Arrow(-1).asQuantity(16), 100, hashMapOf(
					Pebble() to 8,
					Stick() to 16,
					Feather() to 8), true
			        ) {
				Arrow().getUpdatedItem(false).asQuantity(16)
			}
	                                            )
}