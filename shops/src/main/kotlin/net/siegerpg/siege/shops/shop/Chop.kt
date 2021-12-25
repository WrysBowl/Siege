package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.armor.boots.SlimyBoots
import net.siegerpg.siege.core.items.implemented.armor.boots.slimyBoots.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.SlimyChestplate
import net.siegerpg.siege.core.items.implemented.armor.chestplate.slimyChestplates.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.SlimyHelmet
import net.siegerpg.siege.core.items.implemented.armor.helmet.slimyHelmets.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.SlimyLeggings
import net.siegerpg.siege.core.items.implemented.armor.leggings.slimyLeggings.*
import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Slime
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Chop : Shop() {

	override var name : String = "Chop"
	override var permission : String = "siege.shops.shop.chop"
	override var items : List<ShopItem> = listOf(
			ShopItem(
					SlimyHelmet(-1), 250, hashMapOf(
					Slime.tier(1) to 40
					                               ), true
			        ) {
				SlimyHelmet(Utils.randRarity()).getUpdatedItem(false)
			},

			//SLIMY CHESTPLATES
			ShopItem(
					SlimyChestplate(-1), 450, hashMapOf(
					Slime.tier(1) to 64
					                                   ), true
			        ) {
				SlimyChestplate(Utils.randRarity()).getUpdatedItem(false)
			},

			//SLIMY LEGGINGS
			ShopItem(
					SlimyLeggings(-1), 350, hashMapOf(
					Slime.tier(1) to 56
					                                 ), true
			        ) {
				SlimyLeggings(Utils.randRarity()).getUpdatedItem(false)
			},

			//SLIMY BOOTS
			ShopItem(
					SlimyBoots(-1), 200, hashMapOf(
					Slime.tier(1) to 32
					                              ), true
			        ) {
				SlimyBoots(Utils.randRarity()).getUpdatedItem(false)
			})
}