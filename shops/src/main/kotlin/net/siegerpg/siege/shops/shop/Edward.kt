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
	override var name: String = "Edward"
	override var permission: String = "siege.shops.shop.edward"
	override var items: List<ShopItem> = listOf(
		//Iron HELMET
		ShopItem(
			IronHelmet(-1), 2750, hashMapOf(
				RefinedMetal.tier(2) to 5
			), true
		) {
			IronHelmet(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
			GRAYFILLER(-1).getUpdatedItem(false)
		},
		ShopItem(
			LuckyIronHelmet(-1), -1, hashMapOf(
				RefinedMetal.tier(2) to 3,
				Feather.tier(2) to 3
			), true
		) {
			LuckyIronHelmet(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			StrongIronHelmet(-1), -1, hashMapOf(
				RefinedMetal.tier(2) to 3,
				Bone.tier(2) to 5
			), true
		) {
			StrongIronHelmet(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			ToughIronHelmet(-1), -1, hashMapOf(
				RefinedMetal.tier(2) to 3,
				Pebble.tier(2) to 5
			), true
		) {
			ToughIronHelmet(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealthyIronHelmet(-1), -1, hashMapOf(
				RefinedMetal.tier(2) to 3,
				PlantMatter.tier(2) to 5
			), true
		) {
			HealthyIronHelmet(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealingIronHelmet(-1), -1, hashMapOf(
				RefinedMetal.tier(2) to 3,
				Wheat.tier(4) to 1
			), true
		) {
			HealingIronHelmet(Utils.randRarity()).getUpdatedItem(false)
		},

		//Iron CHESTPLATE
		ShopItem(
			IronChestplate(-1), 4000, hashMapOf(
				RefinedMetal.tier(2) to 8
			), true
		) {
			IronChestplate(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
			GRAYFILLER(-1).getUpdatedItem(false)
		},
		ShopItem(
			LuckyIronChestplate(-1), 4250, hashMapOf(
				RefinedMetal.tier(2) to 6,
				Feather.tier(2) to 4
			), true
		) {
			LuckyIronChestplate(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			StrongIronChestplate(-1), 4250, hashMapOf(
				RefinedMetal.tier(3) to 5,
				Bone.tier(2) to 5
			), true
		) {
			StrongIronChestplate(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			ToughIronChestplate(-1), 4250, hashMapOf(
				RefinedMetal.tier(2) to 4,
				Pebble.tier(2) to 6
			), true
		) {
			ToughIronChestplate(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealthyIronChestplate(-1), 4250, hashMapOf(
				RefinedMetal.tier(2) to 4,
				PlantMatter.tier(2) to 4
			), true
		) {
			HealthyIronChestplate(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealingIronChestplate(-1), 4250, hashMapOf(
				RefinedMetal.tier(2) to 5,
				Wheat.tier(4) to 1
			), true
		) {
			HealingIronChestplate(Utils.randRarity()).getUpdatedItem(false)
		},

		//Iron LEGGINGS
		ShopItem(
			IronLeggings(-1), 3750, hashMapOf(
				RefinedMetal.tier(2) to 7
			), true
		) {
			IronLeggings(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
			GRAYFILLER(-1).getUpdatedItem(false)
		},

		ShopItem(
			LuckyIronLeggings(-1), 4000, hashMapOf(
				RefinedMetal.tier(2) to 5,
				Feather.tier(2) to 4
			), true
		) {
			LuckyIronLeggings(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			StrongIronLeggings(-1), 4000, hashMapOf(
				RefinedMetal.tier(2) to 5,
				Bone.tier(2) to 3
			), true
		) {
			StrongIronLeggings(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			ToughIronLeggings(-1), 4000, hashMapOf(
				RefinedMetal.tier(2) to 6,
				Pebble.tier(2) to 4
			), true
		) {
			ToughIronLeggings(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealthyIronLeggings(-1), 4000, hashMapOf(
				RefinedMetal.tier(2) to 5,
				PlantMatter.tier(2) to 4
			), true
		) {
			HealthyIronLeggings(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealingIronLeggings(-1), 4000, hashMapOf(
				RefinedMetal.tier(2) to 5,
				Wheat.tier(4) to 1
			), true
		) {
			HealingIronLeggings(Utils.randRarity()).getUpdatedItem(false)
		},

		//Iron BOOTS
		ShopItem(
			IronBoots(-1), 2500, hashMapOf(
				RefinedMetal.tier(2) to 4
			), true
		) {
			IronBoots(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
			GRAYFILLER(-1).getUpdatedItem(false)
		},
		ShopItem(
			LuckyIronBoots(-1), 2750, hashMapOf(
				RefinedMetal.tier(2) to 3,
				Feather.tier(2) to 2
			), true
		) {
			LuckyIronBoots(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			StrongIronBoots(-1), 2750, hashMapOf(
				RefinedMetal.tier(2) to 3,
				Bone.tier(2) to 2
			), true
		) {
			StrongIronBoots(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			ToughIronBoots(-1), 2750, hashMapOf(
				RefinedMetal.tier(2) to 3,
				Pebble.tier(2) to 3
			), true
		) {
			ToughIronBoots(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealthyIronBoots(-1), 2750, hashMapOf(
				RefinedMetal.tier(2) to 3,
				PlantMatter.tier(2) to 4
			), true
		) {
			HealthyIronBoots(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealingIronBoots(-1), 2750, hashMapOf(
				RefinedMetal.tier(2) to 3,
				Wheat.tier(4) to 1
			), true
		) {
			HealingIronBoots(Utils.randRarity()).getUpdatedItem(false)
		}
	)
}