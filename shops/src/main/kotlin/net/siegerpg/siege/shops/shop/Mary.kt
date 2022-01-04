package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.FishingExplanation
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.tools.fishingRod.*
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Mary : Shop() {

	override var name : String = "Mary"
	override var permission : String = "siege.shops.shop.mary"
	override var items : List<ShopItem> = listOf(
			//RODS
			ShopItem(
					OldRod(-1), 1000, hashMapOf(), false
			        ) {
				OldRod(0).getUpdatedItem(false)
			},
			ShopItem(
					OakRod(-1), 20000, hashMapOf(
					Vine.tier(3) to 2,
					Stick.tier(3) to 1
					                            ), true
			        ) {
				OakRod(0).getUpdatedItem(false)
			},
			ShopItem(
					BoneRod(-1), 35000, hashMapOf(
					Vine.tier(3) to 2,
					Bone.tier(3) to 3
					                             ), true
			        ) {
				BoneRod(0).getUpdatedItem(false)
			},
			ShopItem(FishingExplanation(-1), -1, hashMapOf(), false) {
				FishingExplanation(-1).getUpdatedItem(false)
			},
			ShopItem(
					MetalRod(-1), 55000, hashMapOf(
					Chain.tier(2) to 3,
					MetalScrap.tier(3) to 2
					                              ), true
			        ) {
				MetalRod(0).getUpdatedItem(false)
			},
			ShopItem(
					RefinedRod(-1), 80000, hashMapOf(
					Chain.tier(3) to 2,
					RefinedMetal.tier(3) to 4
					                                ), true
			        ) {
				RefinedRod(0).getUpdatedItem(false)
			},
			ShopItem(
					TitaniumRod(-1), 110000, hashMapOf(
					Chain.tier(3) to 2,
					Titanium.tier(3) to 4
					                                  ), true
			        ) {
				TitaniumRod(0).getUpdatedItem(false)
			}
	                                            )
}