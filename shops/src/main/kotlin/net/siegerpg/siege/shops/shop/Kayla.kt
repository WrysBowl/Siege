package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.armor.boots.ChainBoots
import net.siegerpg.siege.core.items.implemented.armor.boots.chainBoots.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.ChainChestplate
import net.siegerpg.siege.core.items.implemented.armor.chestplate.chainChestplates.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.ChainHelmet
import net.siegerpg.siege.core.items.implemented.armor.helmet.chainHelmets.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.ChainLeggings
import net.siegerpg.siege.core.items.implemented.armor.leggings.chainLeggings.*
import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Chain
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Kayla : Shop() {

	override var name : String = "Kayla"
	override var permission : String = "siege.shops.shop.kayla"
	override var items : List<ShopItem> = listOf(
			//Chain HELMET
			ShopItem(
					ChainHelmet(-1), -1, hashMapOf(
					Chain() to 40
					                              ), true
			        ) {
				ChainHelmet(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyChainHelmet(-1), -1, hashMapOf(
					Chain() to 24,
					Feather() to 24,
					                                   ), true
			        ) {
				LuckyChainHelmet(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongChainHelmet(-1), -1, hashMapOf(
					Chain() to 24,
					Bone() to 40
					                                    ), true
			        ) {
				StrongChainHelmet(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughChainHelmet(-1), -1, hashMapOf(
					Chain() to 24,
					Pebble() to 40
					                                   ), true
			        ) {
				ToughChainHelmet(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyChainHelmet(-1), -1, hashMapOf(
					Chain() to 24,
					PlantMatter() to 40
					                                     ), true
			        ) {
				HealthyChainHelmet(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingChainHelmet(-1), -1, hashMapOf(
					Chain() to 24,
					Wheat() to 196
					                                     ), true
			        ) {
				HealingChainHelmet(Utils.randRarity()).getUpdatedItem(false)
			},

			//Chain CHESTPLATE
			ShopItem(
					ChainChestplate(-1), -1, hashMapOf(
					Chain() to 128
					                                  ), true
			        ) {
				ChainChestplate(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyChainChestplate(-1), -1, hashMapOf(
					Chain() to 96,
					Feather() to 64
					                                       ), true
			        ) {
				LuckyChainChestplate(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongChainChestplate(-1), -1, hashMapOf(
					Chain() to 96,
					Bone() to 40
					                                        ), true
			        ) {
				StrongChainChestplate(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughChainChestplate(-1), -1, hashMapOf(
					Chain() to 96,
					Pebble() to 64,
					                                       ), true
			        ) {
				ToughChainChestplate(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyChainChestplate(-1), -1, hashMapOf(
					Chain() to 96,
					PlantMatter() to 64
					                                         ), true
			        ) {
				HealthyChainChestplate(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingChainChestplate(-1), -1, hashMapOf(
					Chain() to 96,
					Wheat() to 256
					                                         ), true
			        ) {
				HealingChainChestplate(Utils.randRarity()).getUpdatedItem(false)
			},

			//Chain LEGGINGS
			ShopItem(
					ChainLeggings(-1), -1, hashMapOf(
					Chain() to 96
					                                ), true
			        ) {
				ChainLeggings(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyChainLeggings(-1), -1, hashMapOf(
					Chain() to 64,
					Feather() to 64
					                                     ), true
			        ) {
				LuckyChainLeggings(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongChainLeggings(-1), -1, hashMapOf(
					Chain() to 64,
					Bone() to 48,
					                                      ), true
			        ) {
				StrongChainLeggings(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughChainLeggings(-1), -1, hashMapOf(
					Chain() to 64,
					Pebble() to 64
					                                     ), true
			        ) {
				ToughChainLeggings(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyChainLeggings(-1), -1, hashMapOf(
					Chain() to 64,
					PlantMatter() to 64
					                                       ), true
			        ) {
				HealthyChainLeggings(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingChainLeggings(-1), -1, hashMapOf(
					Chain() to 64,
					Wheat() to 256
					                                       ), true
			        ) {
				HealingChainLeggings(Utils.randRarity()).getUpdatedItem(false)
			},

			//Chain BOOTS
			ShopItem(
					ChainBoots(-1), -1, hashMapOf(
					Chain() to 32
					                             ), true
			        ) {
				ChainBoots(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyChainBoots(-1), -1, hashMapOf(
					Chain() to 24,
					Feather() to 16,
					                                  ), true
			        ) {
				LuckyChainBoots(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongChainBoots(-1), -1, hashMapOf(
					Chain() to 24,
					Bone() to 16,
					                                   ), true
			        ) {
				StrongChainBoots(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughChainBoots(-1), -1, hashMapOf(
					Chain() to 24,
					Pebble() to 24,
					                                  ), true
			        ) {
				ToughChainBoots(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyChainBoots(-1), -1, hashMapOf(
					Chain() to 24,
					PlantMatter() to 32
					                                    ), true
			        ) {
				HealthyChainBoots(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingChainBoots(-1), -1, hashMapOf(
					Chain() to 24,
					Wheat() to 64
					                                    ), true
			        ) {
				HealingChainBoots(Utils.randRarity()).getUpdatedItem(false)
			}
	                                            )
}