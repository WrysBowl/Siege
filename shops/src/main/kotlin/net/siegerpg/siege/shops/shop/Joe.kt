package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.armor.boots.StrawBoots
import net.siegerpg.siege.core.items.implemented.armor.boots.strawBoots.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.StrawChestplate
import net.siegerpg.siege.core.items.implemented.armor.chestplate.strawChestplates.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.StrawHelmet
import net.siegerpg.siege.core.items.implemented.armor.helmet.strawHelmets.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.StrawLeggings
import net.siegerpg.siege.core.items.implemented.armor.leggings.strawLeggings.*
import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Joe : Shop() {

	override var name : String = "Joe"
	override var permission : String = "siege.shops.shop.joe"
	override var items : List<ShopItem> = listOf(
			//STRAW HAT
			ShopItem(
					StrawHelmet(-1), 400, hashMapOf(
					Wheat.tier(1) to 40
					                               ), true
			        ) {
				StrawHelmet(Utils.randRarity()).getUpdatedItem(false)
			},

			//STRAW CHESTPLATE
			ShopItem(
					StrawChestplate(-1), 600, hashMapOf(
					Wheat.tier(1) to 64
					                                   ), true
			        ) {
				StrawChestplate(Utils.randRarity()).getUpdatedItem(false)
			},

			//STRAW LEGGINGS
			ShopItem(
					StrawLeggings(-1), 500, hashMapOf(
					Wheat.tier(1) to 56
					                                 ), true
			        ) {
				StrawLeggings(Utils.randRarity()).getUpdatedItem(false)
			},

			//STRAW BOOTS
			ShopItem(
					StrawBoots(-1), 300, hashMapOf(
					Wheat.tier(1) to 32
					                              ), true
			        ) {
				StrawBoots(Utils.randRarity()).getUpdatedItem(false)
			})
}