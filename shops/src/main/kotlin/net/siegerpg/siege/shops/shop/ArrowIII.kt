package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.arrows.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Magma
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

class ArrowIII : Shop() {

	override var name : String = "Arrow Shop III"
	override var permission : String = "siege.shops.shop.arrowIII"
	override var items : List<ShopItem> = listOf(
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					StunningArrow(-1).asQuantity(16), 1200, hashMapOf(
					Pebble() to 40,
					Stick() to 16,
					Feather() to 8,
					ShroomPowder() to 32), true
			        ) {
				StunningArrow().getUpdatedItem(false).asQuantity(16)
			},
			ShopItem(
					SlownessArrow(-1).asQuantity(16), 400, hashMapOf(
					Pebble() to 40,
					Stick() to 16,
					Feather() to 8), true
			        ) {
				SlownessArrow().getUpdatedItem(false).asQuantity(16)
			},
			ShopItem(
					Arrow(-1).asQuantity(16), 100, hashMapOf(
					Pebble() to 8,
					Stick() to 16,
					Feather() to 8), true
			        ) {
				Arrow().getUpdatedItem(false).asQuantity(16)
			},
			ShopItem(
					PoisonArrow(-1).asQuantity(16), 600, hashMapOf(
					Pebble() to 8,
					Stick() to 16,
					Feather() to 8,
					PlantMatter() to 32,
					Seed() to 32,
					                                              ), true
			        ) {
				PoisonArrow().getUpdatedItem(false).asQuantity(16)
			},
			ShopItem(
					FlamingArrow(-1).asQuantity(16), 800, hashMapOf(
					Pebble() to 8,
					Stick() to 16,
					Feather() to 8,
					Magma() to 32), true
			        ) {
				FlamingArrow().getUpdatedItem(false).asQuantity(16)
			},
	                                            )
}