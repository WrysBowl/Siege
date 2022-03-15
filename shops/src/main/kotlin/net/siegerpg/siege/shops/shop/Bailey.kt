package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
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

class Bailey : Shop() {

	override var name : String = "Bailey"
	override var permission : String = "siege.shops.shop.bailey"
	override var items : List<ShopItem> = listOf(
			ShopItem(
					Spade(-1), -1, hashMapOf(
					Pebble() to 24,
					Stick() to 48
					                        ), true
			        ) {
				Spade(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckySpade(-1), -1, hashMapOf(
					Pebble() to 24,
					Stick() to 32,
					Feather() to 16
					                             ), true
			        ) {
				LuckySpade(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongSpade(-1), -1, hashMapOf(
					Pebble() to 24,
					Stick() to 32,
					Bone() to 16
					                              ), true
			        ) {
				StrongSpade(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughSpade(-1), -1, hashMapOf(
					Pebble() to 48,
					Stick() to 32
					                             ), true
			        ) {
				ToughSpade(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthySpade(-1), -1, hashMapOf(
					Pebble() to 24,
					Stick() to 32,
					PlantMatter() to 16
					                               ), true
			        ) {
				HealthySpade(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingSpade(-1), -1, hashMapOf(
					Pebble() to 24,
					Stick() to 32,
					Wheat() to 64
					                               ), true
			        ) {
				HealingSpade(Utils.randRarity()).getUpdatedItem(false)
			},

			//PEBBLE SHOOTERS
			ShopItem(
					PebbleShooter(-1), -1, hashMapOf(
					Pebble() to 16,
					Stick() to 32,
					Vine() to 16
					                                ), true
			        ) {
				PebbleShooter(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyPebbleShooter(-1), -1, hashMapOf(
					Pebble() to 8,
					Stick() to 32,
					Vine() to 16,
					Feather() to 8
					                                     ), true
			        ) {
				LuckyPebbleShooter(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongPebbleShooter(-1), -1, hashMapOf(
					Pebble() to 8,
					Stick() to 32,
					Vine() to 16,
					Bone() to 8
					                                      ), true
			        ) {
				StrongPebbleShooter(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughPebbleShooter(-1), -1, hashMapOf(
					Pebble() to 16,
					Stick() to 32,
					Vine() to 16
					                                     ), true
			        ) {
				ToughPebbleShooter(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyPebbleShooter(-1), -1, hashMapOf(
					Pebble() to 8,
					Stick() to 32,
					Vine() to 16,
					PlantMatter() to 8
					                                       ), true
			        ) {
				HealthyPebbleShooter(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingPebbleShooter(-1), -1, hashMapOf(
					Pebble() to 8,
					Stick() to 32,
					Vine() to 16,
					Wheat() to 32
					                                       ), true
			        ) {
				HealingPebbleShooter(Utils.randRarity()).getUpdatedItem(false)
			},

			//FEMUR BONES
			ShopItem(
					FemurBone(-1), -1, hashMapOf(
					Bone() to 32
					                            ), true
			        ) {
				FemurBone(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyFemurBone(-1), -1, hashMapOf(
					Bone() to 24,
					Feather() to 12
					                                 ), true
			        ) {
				LuckyFemurBone(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongFemurBone(-1), -1, hashMapOf(
					Bone() to 48
					                                  ), true
			        ) {
				StrongFemurBone(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughFemurBone(-1), -1, hashMapOf(
					Bone() to 24,
					Pebble() to 12
					                                 ), true
			        ) {
				ToughFemurBone(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyFemurBone(-1), -1, hashMapOf(
					Bone() to 24,
					PlantMatter() to 12
					                                   ), true
			        ) {
				HealthyFemurBone(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingFemurBone(-1), -1, hashMapOf(
					Bone() to 24,
					Wheat() to 48
					                                   ), true
			        ) {
				HealingFemurBone(Utils.randRarity()).getUpdatedItem(false)
			},

			//GLOWING TWIG
			ShopItem(
					GlowingTwig(-1), -1, hashMapOf(
					PlantMatter() to 48
					                              ), true
			        ) {
				GlowingTwig(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyGlowingTwig(-1), -1, hashMapOf(
					PlantMatter() to 32,
					Feather() to 16
					                                   ), true
			        ) {
				LuckyGlowingTwig(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongGlowingTwig(-1), -1, hashMapOf(
					PlantMatter() to 32,
					Bone() to 16
					                                    ), true
			        ) {
				StrongGlowingTwig(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughGlowingTwig(-1), -1, hashMapOf(
					PlantMatter() to 32,
					Pebble() to 16
					                                   ), true
			        ) {
				ToughGlowingTwig(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyGlowingTwig(-1), -1, hashMapOf(
					PlantMatter() to 64
					                                     ), true
			        ) {
				HealthyGlowingTwig(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingGlowingTwig(-1), -1, hashMapOf(
					PlantMatter() to 32,
					Wheat() to 64
					                                     ), true
			        ) {
				HealingGlowingTwig(Utils.randRarity()).getUpdatedItem(false)
			},
	                                            )
}