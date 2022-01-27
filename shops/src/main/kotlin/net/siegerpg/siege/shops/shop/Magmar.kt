package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.armor.boots.MagmaBoots
import net.siegerpg.siege.core.items.implemented.armor.boots.magmaBoots.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.MagmaChestplate
import net.siegerpg.siege.core.items.implemented.armor.chestplate.magmaChestplates.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.MagmaHelmet
import net.siegerpg.siege.core.items.implemented.armor.helmet.magmaHelmets.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.MagmaLeggings
import net.siegerpg.siege.core.items.implemented.armor.leggings.magmaLeggings.*
import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Magma
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Magmar : Shop() {

	override var name : String = "Magmar"
	override var permission : String = "siege.shops.shop.magmar"
	override var items : List<ShopItem> = listOf(
			//MAGMA HELMET
			ShopItem(
					MagmaHelmet(-1), -1, hashMapOf(
					Magma() to 40
					                              ), true
			        ) {
				MagmaHelmet(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyMagmaHelmet(-1), -1, hashMapOf(
					Magma() to 24,
					Feather() to 24
					                                   ), true
			        ) {
				LuckyMagmaHelmet(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongMagmaHelmet(-1), -1, hashMapOf(
					Magma() to 24,
					Bone() to 16
					                                    ), true
			        ) {
				StrongMagmaHelmet(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughMagmaHelmet(-1), -1, hashMapOf(
					Magma() to 24,
					Pebble() to 24
					                                   ), true
			        ) {
				ToughMagmaHelmet(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyMagmaHelmet(-1), -1, hashMapOf(
					Magma() to 24,
					PlantMatter() to 24
					                                     ), true
			        ) {
				HealthyMagmaHelmet(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingMagmaHelmet(-1), -1, hashMapOf(
					Magma() to 24,
					Wheat() to 96
					                                     ), true
			        ) {
				HealingMagmaHelmet(Utils.randRarity()).getUpdatedItem(false)
			},

			//MAGMA CHESTPLATE
			ShopItem(
					MagmaChestplate(-1), -1, hashMapOf(
					Magma() to 64
					                                  ), true
			        ) {
				MagmaChestplate(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyMagmaChestplate(-1), -1, hashMapOf(
					Magma() to 48,
					Feather() to 32
					                                       ), true
			        ) {
				LuckyMagmaChestplate(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongMagmaChestplate(-1), -1, hashMapOf(
					Magma() to 48,
					Bone() to 24
					                                        ), true
			        ) {
				StrongMagmaChestplate(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughMagmaChestplate(-1), -1, hashMapOf(
					Magma() to 48,
					Pebble() to 32
					                                       ), true
			        ) {
				ToughMagmaChestplate(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyMagmaChestplate(-1), -1, hashMapOf(
					Magma() to 48,
					PlantMatter() to 32
					                                         ), true
			        ) {
				HealthyMagmaChestplate(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingMagmaChestplate(-1), -1, hashMapOf(
					Magma() to 48,
					Wheat() to 96
					                                         ), true
			        ) {
				HealingMagmaChestplate(Utils.randRarity()).getUpdatedItem(false)
			},

			//MAGMA LEGGINGS
			ShopItem(
					MagmaLeggings(-1), -1, hashMapOf(
					Magma() to 56
					                                ), true
			        ) {
				MagmaLeggings(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyMagmaLeggings(-1), -1, hashMapOf(
					Magma() to 48,
					Feather() to 24
					                                     ), true
			        ) {
				LuckyMagmaLeggings(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongMagmaLeggings(-1), -1, hashMapOf(
					Magma() to 48,
					Bone() to 16
					                                      ), true
			        ) {
				StrongMagmaLeggings(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughMagmaLeggings(-1), -1, hashMapOf(
					Magma() to 48,
					Pebble() to 24
					                                     ), true
			        ) {
				ToughMagmaLeggings(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyMagmaLeggings(-1), -1, hashMapOf(
					Magma() to 48,
					PlantMatter() to 24
					                                       ), true
			        ) {
				HealthyMagmaLeggings(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingMagmaLeggings(-1), -1, hashMapOf(
					Magma() to 48,
					Wheat() to 128
					                                       ), true
			        ) {
				HealingMagmaLeggings(Utils.randRarity()).getUpdatedItem(false)
			},

			//MAGMA BOOTS
			ShopItem(
					MagmaBoots(-1), -1, hashMapOf(
					Magma() to 32
					                             ), true
			        ) {
				MagmaBoots(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyMagmaBoots(-1), -1, hashMapOf(
					Magma() to 24,
					Feather() to 16
					                                  ), true
			        ) {
				LuckyMagmaBoots(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongMagmaBoots(-1), -1, hashMapOf(
					Magma() to 24,
					Bone() to 12
					                                   ), true
			        ) {
				StrongMagmaBoots(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughMagmaBoots(-1), -1, hashMapOf(
					Magma() to 24,
					Pebble() to 16
					                                  ), true
			        ) {
				ToughMagmaBoots(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyMagmaBoots(-1), -1, hashMapOf(
					Magma() to 24,
					PlantMatter() to 16
					                                    ), true
			        ) {
				HealthyMagmaBoots(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingMagmaBoots(-1), -1, hashMapOf(
					Magma() to 24,
					Wheat() to 96
					                                    ), true
			        ) {
				HealingMagmaBoots(Utils.randRarity()).getUpdatedItem(false)
			},
	                                            )
}