package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Slime
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.Club
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.GiantClub
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.giantClubs.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.StickyStick
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Twig
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.stickySticks.*
import net.siegerpg.siege.core.items.implemented.weapons.ranged.ScrapyardBow
import net.siegerpg.siege.core.items.implemented.weapons.ranged.WoodenBow
import net.siegerpg.siege.core.items.implemented.weapons.ranged.woodenBows.*
import net.siegerpg.siege.core.items.implemented.weapons.wands.GlisteningTwig
import net.siegerpg.siege.core.items.implemented.weapons.wands.LivingTwig
import net.siegerpg.siege.core.items.implemented.weapons.wands.glisteningTwigs.*
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Chip : Shop() {

	override var name : String = "Chip"
	override var permission : String = "siege.shops.shop.chip"
	override var items : List<ShopItem> = listOf(
			//LIGHT MELEE
			ShopItem(Twig(-1), -1, hashMapOf(Stick() to 12), true) {
				Twig(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StickyStick(-1), -1, hashMapOf(
					Slime() to 16,
					Stick() to 16
					                              ), true
			        ) {
				StickyStick(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					LuckyStickyStick(-1), -1, hashMapOf(
					Slime() to 12,
					Stick() to 16,
					Feather() to 4
					                                   ), true
			        ) {
				LuckyStickyStick(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongStickyStick(-1), -1, hashMapOf(
					Slime() to 12,
					Stick() to 16,
					Bone() to 2
					                                    ), true
			        ) {
				StrongStickyStick(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughStickyStick(-1), -1, hashMapOf(
					Slime() to 12,
					Stick() to 16,
					Pebble() to 4
					                                   ), true
			        ) {
				ToughStickyStick(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyStickyStick(-1), -1, hashMapOf(
					Slime() to 12,
					Stick() to 16,
					PlantMatter() to 4
					                                     ), true
			        ) {
				HealthyStickyStick(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingStickyStick(-1), -1, hashMapOf(
					Slime() to 12,
					Stick() to 16,
					Wheat() to 24
					                                     ), true
			        ) {
				HealingStickyStick(Utils.randRarity()).getUpdatedItem(false)
			},

			//RANGED
			ShopItem(
					ScrapyardBow(-1), -1, hashMapOf(
					Stick() to 24,
					Vine() to 16
					                               ), true
			        ) {
				ScrapyardBow(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					WoodenBow(-1), -1, hashMapOf(
					Stick() to 32,
					Vine() to 32
					                            ), true
			        ) {
				WoodenBow(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					LuckyWoodenBow(-1), -1, hashMapOf(
					Stick() to 32,
					Vine() to 24,
					Feather() to 16
					                                 ), true
			        ) {
				LuckyWoodenBow(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongWoodenBow(-1), -1, hashMapOf(
					Stick() to 32,
					Vine() to 24,
					Bone() to 12
					                                  ), true
			        ) {
				StrongWoodenBow(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughWoodenBow(-1), -1, hashMapOf(
					Stick() to 32,
					Vine() to 24,
					Pebble() to 16
					                                 ), true
			        ) {
				ToughWoodenBow(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyWoodenBow(-1), -1, hashMapOf(
					Stick() to 32,
					Vine() to 24,
					PlantMatter() to 16
					                                   ), true
			        ) {
				HealthyWoodenBow(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingWoodenBow(-1), -1, hashMapOf(
					Stick() to 32,
					Vine() to 24,
					Wheat() to 48
					                                   ), true
			        ) {
				HealingWoodenBow(Utils.randRarity()).getUpdatedItem(false)
			},

			//HEAVY MELEE
			ShopItem(
					Club(-1), -1, hashMapOf(
					Stick() to 24,
					Pebble() to 10
					                       ), true
			        ) {
				Club(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					GiantClub(-1), -1, hashMapOf(
					Stick() to 24,
					Pebble() to 10
					                            ), true
			        ) {
				GiantClub(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					LuckyGiantClub(-1), -1, hashMapOf(
					Stick() to 16,
					Pebble() to 10,
					Feather() to 8
					                                 ), true
			        ) {
				LuckyGiantClub(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongGiantClub(-1), -1, hashMapOf(
					Stick() to 16,
					Pebble() to 10,
					Bone() to 4
					                                  ), true
			        ) {
				StrongGiantClub(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughGiantClub(-1), -1, hashMapOf(
					Stick() to 16,
					Pebble() to 16
					                                 ), true
			        ) {
				ToughGiantClub(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyGiantCLub(-1), -1, hashMapOf(
					Stick() to 16,
					Pebble() to 10,
					PlantMatter() to 8
					                                   ), true
			        ) {
				HealthyGiantCLub(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingGiantClub(-1), -1, hashMapOf(
					Stick() to 16,
					Pebble() to 10,
					Wheat() to 32
					                                   ), true
			        ) {
				HealingGiantClub(Utils.randRarity()).getUpdatedItem(false)
			},

			//WANDS
			ShopItem(LivingTwig(-1), 600, hashMapOf(), false) {
				LivingTwig(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					GlisteningTwig(-1), -1, hashMapOf(
					Seed() to 12,
					Stick() to 32
					                                 ), true
			        ) {
				GlisteningTwig(Utils.randRarity()).getUpdatedItem(false)
			},

			ShopItem(
					LuckyGlisteningTwig(-1), -1, hashMapOf(
					Seed() to 12,
					Stick() to 24,
					Feather() to 12
					                                      ), true
			        ) {
				LuckyGlisteningTwig(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					StrongGlisteningTwig(-1), -1, hashMapOf(
					Seed() to 12,
					Stick() to 24,
					Bone() to 8
					                                       ), true
			        ) {
				StrongGlisteningTwig(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					ToughGlisteningTwig(-1), -1, hashMapOf(
					Seed() to 12,
					Stick() to 24,
					Pebble() to 16
					                                      ), true
			        ) {
				ToughGlisteningTwig(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealthyGlisteningTwig(-1), -1, hashMapOf(
					Seed() to 12,
					Stick() to 24,
					PlantMatter() to 16
					                                        ), true
			        ) {
				HealthyGlisteningTwig(Utils.randRarity()).getUpdatedItem(false)
			},
			ShopItem(
					HealingGlisteningTwig(-1), -1, hashMapOf(
					Seed() to 12,
					Stick() to 24,
					Wheat() to 32
					                                        ), true
			        ) {
				HealingGlisteningTwig(Utils.randRarity()).getUpdatedItem(false)
			},
	                                            )
}