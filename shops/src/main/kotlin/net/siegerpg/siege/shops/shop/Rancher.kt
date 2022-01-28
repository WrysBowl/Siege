package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.armor.boots.LeatherBoots
import net.siegerpg.siege.core.items.implemented.armor.boots.hardenedLeatherBoots.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.LeatherChestplate
import net.siegerpg.siege.core.items.implemented.armor.chestplate.hardenedLeatherChestplates.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.LeatherHelmet
import net.siegerpg.siege.core.items.implemented.armor.helmet.hardenedLeatherHelmets.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.LeatherLeggings
import net.siegerpg.siege.core.items.implemented.armor.leggings.hardenedLeatherLeggings.*
import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Rancher : Shop() {

	override var name : String = "Rancher"
	override var permission : String = "siege.shops.shop.rancher"
	override var items : List<ShopItem> = listOf(
			//HARDENED LEATHER HELMET
			ShopItem(
					LeatherHelmet(-1), -1, hashMapOf(
					Leather() to 40
					                                ), true
			        ) {
				LeatherHelmet(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyHardenedLeatherHelmet(-1), -1, hashMapOf(
					Leather() to 32,
					Feather() to 32
					                                             ), true
			        ) {
				LuckyHardenedLeatherHelmet(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongHardenedLeatherHelmet(-1), -1, hashMapOf(
					Leather() to 32,
					Bone() to 32
					                                              ), true
			        ) {
				StrongHardenedLeatherHelmet(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughHardenedLeatherHelmet(-1), -1, hashMapOf(
					Leather() to 32,
					Pebble() to 32
					                                             ), true
			        ) {
				ToughHardenedLeatherHelmet(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyHardenedLeatherHelmet(-1), -1, hashMapOf(
					Leather() to 32,
					PlantMatter() to 32
					                                               ), true
			        ) {
				HealthyHardenedLeatherHelmet(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingHardenedLeatherHelmet(-1), -1, hashMapOf(
					Leather() to 32,
					Wheat() to 128
					                                               ), true
			        ) {
				HealingHardenedLeatherHelmet(Utils.randRarity()).getUpdatedItem(false)
			},

			//HardenedLeather CHESTPLATE
			ShopItem(
					LeatherChestplate(-1), -1, hashMapOf(
					Leather() to 64
					                                    ), true
			        ) {
				LeatherChestplate(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyHardenedLeatherChestplate(-1), -1, hashMapOf(
					Leather() to 32,
					Feather() to 32
					                                                 ), true
			        ) {
				LuckyHardenedLeatherChestplate(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongHardenedLeatherChestplate(-1), -1, hashMapOf(
					Leather() to 40,
					Bone() to 32
					                                                  ), true
			        ) {
				StrongHardenedLeatherChestplate(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughHardenedLeatherChestplate(-1), -1, hashMapOf(
					Leather() to 32,
					Pebble() to 40
					                                                 ), true
			        ) {
				ToughHardenedLeatherChestplate(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyHardenedLeatherChestplate(-1), -1, hashMapOf(
					Leather() to 32,
					PlantMatter() to 40
					                                                   ), true
			        ) {
				HealthyHardenedLeatherChestplate(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingHardenedLeatherChestplate(-1), -1, hashMapOf(
					Leather() to 32,
					Wheat() to 384
					                                                   ), true
			        ) {
				HealingHardenedLeatherChestplate(Utils.randRarity()).getUpdatedItem(false)
			},

			//HardenedLeather LEGGINGS
			ShopItem(
					LeatherLeggings(-1), -1, hashMapOf(
					Leather() to 56
					                                  ), true
			        ) {
				LeatherLeggings(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyHardenedLeatherLeggings(-1), -1, hashMapOf(
					Leather() to 32,
					Feather() to 32
					                                               ), true
			        ) {
				LuckyHardenedLeatherLeggings(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongHardenedLeatherLeggings(-1), -1, hashMapOf(
					Leather() to 32,
					Bone() to 32
					                                                ), true
			        ) {
				StrongHardenedLeatherLeggings(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughHardenedLeatherLeggings(-1), -1, hashMapOf(
					Leather() to 32,
					Pebble() to 40
					                                               ), true
			        ) {
				ToughHardenedLeatherLeggings(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyHardenedLeatherLeggings(-1), -1, hashMapOf(
					Leather() to 32,
					PlantMatter() to 32
					                                                 ), true
			        ) {
				HealthyHardenedLeatherLeggings(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingHardenedLeatherLeggings(-1), -1, hashMapOf(
					Leather() to 32,
					Wheat() to 196
					                                                 ), true
			        ) {
				HealingHardenedLeatherLeggings(Utils.randRarity()).getUpdatedItem(false)
			},

			//HardenedLeather BOOTS
			ShopItem(
					LeatherBoots(-1), -1, hashMapOf(
					Leather() to 32
					                               ), true
			        ) {
				LeatherBoots(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyHardenedLeatherBoots(-1), -1, hashMapOf(
					Leather() to 32,
					Feather() to 32
					                                            ), true
			        ) {
				LuckyHardenedLeatherBoots(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongHardenedLeatherBoots(-1), -1, hashMapOf(
					Leather() to 32,
					Bone() to 8
					                                             ), true
			        ) {
				StrongHardenedLeatherBoots(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughHardenedLeatherBoots(-1), -1, hashMapOf(
					Leather() to 32,
					Pebble() to 32
					                                            ), true
			        ) {
				ToughHardenedLeatherBoots(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyHardenedLeatherBoots(-1), -1, hashMapOf(
					Leather() to 8,
					PlantMatter() to 32
					                                              ), true
			        ) {
				HealthyHardenedLeatherBoots(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingHardenedLeatherBoots(-1), -1, hashMapOf(
					Leather() to 32,
					Wheat() to 256
					                                              ), true
			        ) {
				HealingHardenedLeatherBoots(Utils.randRarity()).getUpdatedItem(false)
			},
	                                            )
}