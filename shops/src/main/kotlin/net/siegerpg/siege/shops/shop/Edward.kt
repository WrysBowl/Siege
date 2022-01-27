package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.armor.boots.IronBoots
import net.siegerpg.siege.core.items.implemented.armor.boots.ironBoots.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.IronChestplate
import net.siegerpg.siege.core.items.implemented.armor.chestplate.ironChestplates.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.IronHelmet
import net.siegerpg.siege.core.items.implemented.armor.helmet.ironHelmets.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.IronLeggings
import net.siegerpg.siege.core.items.implemented.armor.leggings.ironleggings.*
import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.RefinedMetal
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Edward : Shop() {

	override var name : String = "Edward"
	override var permission : String = "siege.shops.shop.edward"
	override var items : List<ShopItem> = listOf(
			//Iron HELMET
			ShopItem(
					IronHelmet(-1), -1, hashMapOf(
					RefinedMetal() to 40
					                             ), true
			        ) {
				IronHelmet(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyIronHelmet(-1), -1, hashMapOf(
					RefinedMetal() to 32,
					Feather() to 40
					                                  ), true
			        ) {
				LuckyIronHelmet(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongIronHelmet(-1), -1, hashMapOf(
					RefinedMetal() to 32,
					Bone() to 20
					                                   ), true
			        ) {
				StrongIronHelmet(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughIronHelmet(-1), -1, hashMapOf(
					RefinedMetal() to 32,
					Pebble() to 40
					                                  ), true
			        ) {
				ToughIronHelmet(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyIronHelmet(-1), -1, hashMapOf(
					RefinedMetal() to 32,
					PlantMatter() to 40
					                                    ), true
			        ) {
				HealthyIronHelmet(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingIronHelmet(-1), -1, hashMapOf(
					RefinedMetal() to 32,
					Wheat() to 128
					                                    ), true
			        ) {
				HealingIronHelmet(Utils.randRarity()).getUpdatedItem(false)
			},

			//Iron CHESTPLATE
			ShopItem(
					IronChestplate(-1), -1, hashMapOf(
					RefinedMetal() to 64
					                                 ), true
			        ) {
				IronChestplate(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyIronChestplate(-1), -1, hashMapOf(
					RefinedMetal() to 48,
					Feather() to 64
					                                      ), true
			        ) {
				LuckyIronChestplate(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongIronChestplate(-1), -1, hashMapOf(
					RefinedMetal() to 48,
					Bone() to 48
					                                       ), true
			        ) {
				StrongIronChestplate(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughIronChestplate(-1), -1, hashMapOf(
					RefinedMetal() to 48,
					Pebble() to 64
					                                      ), true
			        ) {
				ToughIronChestplate(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyIronChestplate(-1), -1, hashMapOf(
					RefinedMetal() to 48,
					PlantMatter() to 64
					                                        ), true
			        ) {
				HealthyIronChestplate(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingIronChestplate(-1), -1, hashMapOf(
					RefinedMetal() to 64,
					Wheat() to 256
					                                        ), true
			        ) {
				HealingIronChestplate(Utils.randRarity()).getUpdatedItem(false)
			},

			//Iron LEGGINGS
			ShopItem(
					IronLeggings(-1), -1, hashMapOf(
					RefinedMetal() to 56
					                               ), true
			        ) {
				IronLeggings(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},

			ShopItem(
					LuckyIronLeggings(-1), -1, hashMapOf(
					RefinedMetal() to 48,
					Feather() to 48
					                                    ), true
			        ) {
				LuckyIronLeggings(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongIronLeggings(-1), -1, hashMapOf(
					RefinedMetal() to 48,
					Bone() to 32
					                                     ), true
			        ) {
				StrongIronLeggings(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughIronLeggings(-1), -1, hashMapOf(
					RefinedMetal() to 48,
					Pebble() to 48
					                                    ), true
			        ) {
				ToughIronLeggings(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyIronLeggings(-1), -1, hashMapOf(
					RefinedMetal() to 48,
					PlantMatter() to 48
					                                      ), true
			        ) {
				HealthyIronLeggings(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingIronLeggings(-1), -1, hashMapOf(
					RefinedMetal() to 48,
					Wheat() to 196
					                                      ), true
			        ) {
				HealingIronLeggings(Utils.randRarity()).getUpdatedItem(false)
			},

			//Iron BOOTS
			ShopItem(
					IronBoots(-1), -1, hashMapOf(
					RefinedMetal() to 24
					                            ), true
			        ) {
				IronBoots(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyIronBoots(-1), -1, hashMapOf(
					RefinedMetal() to 16,
					Feather() to 32
					                                 ), true
			        ) {
				LuckyIronBoots(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongIronBoots(-1), -1, hashMapOf(
					RefinedMetal() to 16,
					Bone() to 24
					                                  ), true
			        ) {
				StrongIronBoots(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughIronBoots(-1), -1, hashMapOf(
					RefinedMetal() to 16,
					Pebble() to 32
					                                 ), true
			        ) {
				ToughIronBoots(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyIronBoots(-1), -1, hashMapOf(
					RefinedMetal() to 16,
					PlantMatter() to 32
					                                   ), true
			        ) {
				HealthyIronBoots(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingIronBoots(-1), -1, hashMapOf(
					RefinedMetal() to 16,
					Wheat() to 64
					                                   ), true
			        ) {
				HealingIronBoots(Utils.randRarity()).getUpdatedItem(false)
			}
	                                            )
}