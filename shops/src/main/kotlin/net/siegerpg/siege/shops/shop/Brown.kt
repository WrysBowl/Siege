package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.armor.boots.BoneBoots
import net.siegerpg.siege.core.items.implemented.armor.boots.boneBoots.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.BoneChestplate
import net.siegerpg.siege.core.items.implemented.armor.chestplate.boneChestplates.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.BoneHelmet
import net.siegerpg.siege.core.items.implemented.armor.helmet.boneHelmets.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.BoneLeggings
import net.siegerpg.siege.core.items.implemented.armor.leggings.boneLeggings.*
import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Brown : Shop() {

	override var name : String = "Brown"
	override var permission : String = "siege.shops.shop.brown"
	override var items : List<ShopItem> = listOf(
			//Bone HELMET
			ShopItem(
					BoneHelmet(-1), -1, hashMapOf(
					Bone() to 40
					                             ), true
			        ) {
				BoneHelmet(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyBoneHelmet(-1), -1, hashMapOf(
					Bone() to 32,
					Feather() to 16
					                                  ), true
			        ) {
				LuckyBoneHelmet(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongBoneHelmet(-1), -1, hashMapOf(
					Bone() to 48
					                                   ), true
			        ) {
				StrongBoneHelmet(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughBoneHelmet(-1), -1, hashMapOf(
					Bone() to 32,
					Pebble() to 32
					                                  ), true
			        ) {
				ToughBoneHelmet(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyBoneHelmet(-1), -1, hashMapOf(
					Bone() to 32,
					PlantMatter() to 32
					                                    ), true
			        ) {
				HealthyBoneHelmet(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingBoneHelmet(-1), -1, hashMapOf(
					Bone() to 32,
					Wheat() to 128
					                                    ), true
			        ) {
				HealingBoneHelmet(Utils.randRarity()).getUpdatedItem(false)
			},

			//BONE CHESTPLATE
			ShopItem(
					BoneChestplate(-1), -1, hashMapOf(
					Bone() to 64
					                                 ), true
			        ) {
				BoneChestplate(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyBoneChestplate(-1), -1, hashMapOf(
					Bone() to 48,
					Feather() to 32
					                                      ), true
			        ) {
				LuckyBoneChestplate(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongBoneChestplate(-1), -1, hashMapOf(
					Bone() to 80
					                                       ), true
			        ) {
				StrongBoneChestplate(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughBoneChestplate(-1), -1, hashMapOf(
					Bone() to 48,
					Pebble() to 64
					                                      ), true
			        ) {
				ToughBoneChestplate(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyBoneChestplate(-1), -1, hashMapOf(
					Bone() to 32,
					PlantMatter() to 64
					                                        ), true
			        ) {
				HealthyBoneChestplate(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingBoneChestplate(-1), -1, hashMapOf(
					Bone() to 32,
					Wheat() to 128
					                                        ), true
			        ) {
				HealingBoneChestplate(Utils.randRarity()).getUpdatedItem(false)
			},

			//BONE LEGGINGS
			ShopItem(
					BoneLeggings(-1), -1, hashMapOf(
					Bone() to 56
					                               ), true
			        ) {
				BoneLeggings(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyBoneLeggings(-1), -1, hashMapOf(
					Bone() to 40,
					Feather() to 32
					                                    ), true
			        ) {
				LuckyBoneLeggings(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongBoneLeggings(-1), -1, hashMapOf(
					Bone() to 64
					                                     ), true
			        ) {
				StrongBoneLeggings(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughBoneLeggings(-1), -1, hashMapOf(
					Bone() to 40,
					Pebble() to 40
					                                    ), true
			        ) {
				ToughBoneLeggings(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyBoneLeggings(-1), -1, hashMapOf(
					Bone() to 40,
					PlantMatter() to 40
					                                      ), true
			        ) {
				HealthyBoneLeggings(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingBoneLeggings(-1), -1, hashMapOf(
					Bone() to 40,
					Wheat() to 128
					                                      ), true
			        ) {
				HealingBoneLeggings(Utils.randRarity()).getUpdatedItem(false)
			},

			//BONE BOOTS
			ShopItem(
					BoneBoots(-1), -1, hashMapOf(
					Bone() to 32
					                            ), true
			        ) {
				BoneBoots(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyBoneBoots(-1), -1, hashMapOf(
					Bone() to 24,
					Feather() to 16
					                                 ), true
			        ) {
				LuckyBoneBoots(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongBoneBoots(-1), -1, hashMapOf(
					Bone() to 40
					                                  ), true
			        ) {
				StrongBoneBoots(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughBoneBoots(-1), -1, hashMapOf(
					Bone() to 24,
					Pebble() to 24
					                                 ), true
			        ) {
				ToughBoneBoots(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyBoneBoots(-1), -1, hashMapOf(
					Bone() to 24,
					PlantMatter() to 32
					                                   ), true
			        ) {
				HealthyBoneBoots(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingBoneBoots(-1), -1, hashMapOf(
					Bone() to 24,
					Wheat() to 64
					                                   ), true
			        ) {
				HealingBoneBoots(Utils.randRarity()).getUpdatedItem(false)
			},
	                                            )
}