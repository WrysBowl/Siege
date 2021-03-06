package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.armor.boots.WoolBoots
import net.siegerpg.siege.core.items.implemented.armor.boots.woolBoots.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.WoolChestplate
import net.siegerpg.siege.core.items.implemented.armor.chestplate.woolChestplates.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.WoolHelmet
import net.siegerpg.siege.core.items.implemented.armor.helmet.woolHelmets.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.WoolLeggings
import net.siegerpg.siege.core.items.implemented.armor.leggings.woolLeggings.*
import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Wool
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Steve : Shop() {

	override var name : String = "Steve"
	override var permission : String = "siege.shops.shop.steve"
	override var items : List<ShopItem> = listOf(
			//WOOL HAT
			ShopItem(
					WoolHelmet(-1), 600, hashMapOf(
					Wool.tier(2) to 5
					                              ), true
			        ) {
				WoolHelmet(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyWoolHelmet(-1), -1, hashMapOf(
					Wool.tier(2) to 3,
					Feather.tier(2) to 2
					                                  ), true
			        ) {
				LuckyWoolHelmet(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongWoolHelmet(-1), -1, hashMapOf(
					Wool.tier(2) to 2,
					Bone.tier(2) to 3
					                                   ), true
			        ) {
				StrongWoolHelmet(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughWoolHelmet(-1), -1, hashMapOf(
					Wool.tier(2) to 2,
					Pebble.tier(2) to 4
					                                  ), true
			        ) {
				ToughWoolHelmet(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyWoolHelmet(-1), -1, hashMapOf(
					Wool.tier(2) to 2,
					PlantMatter.tier(2) to 3
					                                    ), true
			        ) {
				HealthyWoolHelmet(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingWoolHelmet(-1), -1, hashMapOf(
					Wool.tier(2) to 3,
					Wheat.tier(2) to 3
					                                    ), true
			        ) {
				HealingWoolHelmet(Utils.randRarity()).getUpdatedItem(false)
			},

			//WOOL CHESTPLATE
			ShopItem(
					WoolChestplate(-1), 800, hashMapOf(
					Wool.tier(2) to 8
					                                  ), true
			        ) {
				WoolChestplate(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyWoolChestplate(-1), -1, hashMapOf(
					Wool.tier(2) to 5,
					Feather.tier(2) to 3
					                                       ), true
			        ) {
				LuckyWoolChestplate(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongWoolChestplate(-1), -1, hashMapOf(
					Wool.tier(2) to 5,
					Bone.tier(2) to 3
					                                        ), true
			        ) {
				StrongWoolChestplate(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughWoolChestplate(-1), -1, hashMapOf(
					Wool.tier(2) to 4,
					Pebble.tier(2) to 4
					                                       ), true
			        ) {
				ToughWoolChestplate(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyWoolChestplate(-1), -1, hashMapOf(
					Wool.tier(2) to 3,
					PlantMatter.tier(2) to 5
					                                         ), true
			        ) {
				HealthyWoolChestplate(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingWoolChestplate(-1), -1, hashMapOf(
					Wool.tier(2) to 4,
					Wheat.tier(2) to 4
					                                         ), true
			        ) {
				HealingWoolChestplate(Utils.randRarity()).getUpdatedItem(false)
			},

			//WOOL LEGGINGS
			ShopItem(
					WoolLeggings(-1), 700, hashMapOf(
					Wool.tier(2) to 7
					                                ), true
			        ) {
				WoolLeggings(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyWoolLeggings(-1), -1, hashMapOf(
					Wool.tier(2) to 3,
					Feather.tier(2) to 4
					                                     ), true
			        ) {
				LuckyWoolLeggings(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongWoolLeggings(-1), -1, hashMapOf(
					Wool.tier(2) to 3,
					Bone.tier(2) to 3
					                                      ), true
			        ) {
				StrongWoolLeggings(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughWoolLeggings(-1), -1, hashMapOf(
					Wool.tier(2) to 2,
					Pebble.tier(2) to 5
					                                     ), true
			        ) {
				ToughWoolLeggings(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyWoolLeggings(-1), -1, hashMapOf(
					Wool.tier(2) to 3,
					PlantMatter.tier(2) to 4
					                                       ), true
			        ) {
				HealthyWoolLeggings(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingWoolLeggings(-1), -1, hashMapOf(
					Wool.tier(2) to 4,
					Wheat.tier(2) to 3
					                                       ), true
			        ) {
				HealingWoolLeggings(Utils.randRarity()).getUpdatedItem(false)
			},

			//WOOL BOOTS
			ShopItem(
					WoolBoots(-1), 500, hashMapOf(
					Wool.tier(2) to 4
					                             ), true
			        ) {
				WoolBoots(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyWoolBoots(-1), -1, hashMapOf(
					Wool.tier(2) to 2,
					Feather.tier(2) to 2
					                                  ), true
			        ) {
				LuckyWoolBoots(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongWoolBoots(-1), -1, hashMapOf(
					Wool.tier(2) to 2,
					Bone.tier(2) to 2
					                                   ), true
			        ) {
				StrongWoolBoots(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughWoolBoots(-1), -1, hashMapOf(
					Wool.tier(2) to 2,
					Pebble.tier(2) to 3
					                                  ), true
			        ) {
				ToughWoolBoots(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyWoolBoots(-1), -1, hashMapOf(
					Wool.tier(2) to 2,
					PlantMatter.tier(2) to 2
					                                    ), true
			        ) {
				HealthyWoolBoots(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingWoolBoots(-1), -1, hashMapOf(
					Wool.tier(2) to 1,
					Wheat.tier(2) to 3
					                                    ), true
			        ) {
				HealingWoolBoots(Utils.randRarity()).getUpdatedItem(false)
			},
	                                            )
}