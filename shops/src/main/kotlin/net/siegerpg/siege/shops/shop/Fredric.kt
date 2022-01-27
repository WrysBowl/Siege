package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Magma
import net.siegerpg.siege.core.items.implemented.weapons.wands.FlamingHotTorch
import net.siegerpg.siege.core.items.implemented.weapons.wands.flamingHotTorches.*
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Fredric : Shop() {

	override var name : String = "Fredric"
	override var permission : String = "siege.shops.shop.fredric"
	override var items : List<ShopItem> = listOf(
			//FLAMING HOT TORCH
			ShopItem(
					FlamingHotTorch(-1), -1, hashMapOf(
					Magma() to 96,
					Seed() to 128,
					Stick() to 64
					                                    ), true
			        ) {
				FlamingHotTorch(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(
					LuckyFlamingHotTorch(-1), -1, hashMapOf(
					Magma() to 64,
					Seed() to 128,
					Stick() to 64,
					Feather() to 32
					                                       ), true
			        ) {
				LuckyFlamingHotTorch(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongFlamingHotTorch(-1), -1, hashMapOf(
					Magma() to 64,
					Seed() to 128,
					Stick() to 64,
					Bone() to 32
					                                        ), true
			        ) {
				StrongFlamingHotTorch(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughFlamingHotTorch(-1), -1, hashMapOf(
					Magma() to 64,
					Seed() to 128,
					Stick() to 64,
					Pebble() to 32
					                                       ), true
			        ) {
				ToughFlamingHotTorch(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyFlamingHotTorch(-1), -1, hashMapOf(
					Magma() to 64,
					Seed() to 128,
					Stick() to 64,
					PlantMatter() to 32
					                                         ), true
			        ) {
				HealthyFlamingHotTorch(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingFlamingHotTorch(-1), -1, hashMapOf(
					Magma() to 64,
					Seed() to 128,
					Stick() to 64,
					Wheat() to 256
					                                         ), true
			        ) {
				HealingFlamingHotTorch(Utils.randRarity()).getUpdatedItem(false)
			}
	                                            )
}