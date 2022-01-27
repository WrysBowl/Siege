package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.MetalScrap
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.ScrapShard
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.scrapShards.*
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Berta : Shop() {

	override var name : String = "Berta"
	override var permission : String = "siege.shops.shop.berta"
	override var items : List<ShopItem> = listOf(
			//SCRAP SHARD
			ShopItem(
					ScrapShard(-1), -1, hashMapOf(
					MetalScrap() to 96
					                               ), true
			        ) {
				ScrapShard(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyScrapShard(-1), -1, hashMapOf(
					MetalScrap() to 64,
					Feather() to 32
					                                  ), true
			        ) {
				LuckyScrapShard(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongScrapShard(-1), -1, hashMapOf(
					MetalScrap() to 64,
					Bone() to 32
					                                   ), true
			        ) {
				StrongScrapShard(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughScrapShard(-1), -1, hashMapOf(
					MetalScrap() to 64,
					Pebble() to 32
					                                  ), true
			        ) {
				ToughScrapShard(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyScrapShard(-1), -1, hashMapOf(
					MetalScrap() to 64,
					PlantMatter() to 32
					                                    ), true
			        ) {
				HealthyScrapShard(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingScrapShard(-1), -1, hashMapOf(
					MetalScrap() to 64,
					Wheat() to 128
					                                    ), true
			        ) {
				HealingScrapShard(Utils.randRarity()).getUpdatedItem(false)
			}
	                                            )
}