package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Seed
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Vine
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Slime
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.Club
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.GiantClub
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.giantClubs.HealingGiantClub
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.giantClubs.HealthyGiantCLub
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.giantClubs.LuckyGiantClub
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.giantClubs.StrongGiantClub
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.giantClubs.ToughGiantClub
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.StickyStick
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Twig
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.stickySticks.HealingStickyStick
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.stickySticks.HealthyStickyStick
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.stickySticks.LuckyStickyStick
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.stickySticks.StrongStickyStick
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.stickySticks.ToughStickyStick
import net.siegerpg.siege.core.items.implemented.weapons.ranged.ScrapyardBow
import net.siegerpg.siege.core.items.implemented.weapons.ranged.WoodenBow
import net.siegerpg.siege.core.items.implemented.weapons.ranged.woodenBows.HealingWoodenBow
import net.siegerpg.siege.core.items.implemented.weapons.ranged.woodenBows.HealthyWoodenBow
import net.siegerpg.siege.core.items.implemented.weapons.ranged.woodenBows.LuckyWoodenBow
import net.siegerpg.siege.core.items.implemented.weapons.ranged.woodenBows.StrongWoodenBow
import net.siegerpg.siege.core.items.implemented.weapons.ranged.woodenBows.ToughWoodenBow
import net.siegerpg.siege.core.items.implemented.weapons.wands.GlisteningTwig
import net.siegerpg.siege.core.items.implemented.weapons.wands.LivingTwig
import net.siegerpg.siege.core.items.implemented.weapons.wands.glisteningTwigs.HealingGlisteningTwig
import net.siegerpg.siege.core.items.implemented.weapons.wands.glisteningTwigs.HealthyGlisteningTwig
import net.siegerpg.siege.core.items.implemented.weapons.wands.glisteningTwigs.LuckyGlisteningTwig
import net.siegerpg.siege.core.items.implemented.weapons.wands.glisteningTwigs.StrongGlisteningTwig
import net.siegerpg.siege.core.items.implemented.weapons.wands.glisteningTwigs.ToughGlisteningTwig
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Chip : Shop() {

	override var name: String = "Chip"
	override var permission: String = "siege.shops.shop.chip"
	override var items: List<ShopItem> = listOf(
		//LIGHT MELEE
		ShopItem(Twig(-1), 100, hashMapOf(Stick.tier(1) to 2), true) {
			Twig(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			StickyStick(-1), 150, hashMapOf(
				Slime.tier(2) to 2,
				Stick.tier(2) to 2
			                               ), true
		        ) {
			StickyStick(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			LuckyStickyStick(-1), -1, hashMapOf(
				Slime.tier(2) to 1,
				Stick.tier(2) to 2,
				Feather.tier(1) to 4
			                                   ), true
		        ) {
			LuckyStickyStick(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			StrongStickyStick(-1), -1, hashMapOf(
				Slime.tier(2) to 1,
				Stick.tier(2) to 2,
				Bone.tier(1) to 1
			                                    ), true
		        ) {
			StrongStickyStick(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			ToughStickyStick(-1), -1, hashMapOf(
				Slime.tier(2) to 1,
				Stick.tier(2) to 2,
				Pebble.tier(1) to 6
			                                   ), true
		        ) {
			ToughStickyStick(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealthyStickyStick(-1), -1, hashMapOf(
				Slime.tier(2) to 1,
				Stick.tier(2) to 2,
				PlantMatter.tier(2) to 1
			                                     ), true
		        ) {
			HealthyStickyStick(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealingStickyStick(-1), -1, hashMapOf(
				Slime.tier(2) to 1,
				Stick.tier(2) to 2,
				Wheat.tier(2) to 2
			                                     ), true
		        ) {
			HealingStickyStick(Utils.randRarity()).getUpdatedItem(false)
		},

		//RANGED
		ShopItem(
			ScrapyardBow(-1), 100, hashMapOf(
				Stick.tier(2) to 3,
				Vine.tier(2) to 3
			                                ), true
		        ) {
			ScrapyardBow(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			WoodenBow(-1), 250, hashMapOf(
				Stick.tier(3) to 3,
				Vine.tier(3) to 3
			                             ), true
		        ) {
			WoodenBow(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			LuckyWoodenBow(-1), -1, hashMapOf(
				Stick.tier(3) to 3,
				Vine.tier(3) to 1,
				Feather.tier(3) to 1
			                                 ), true
		        ) {
			LuckyWoodenBow(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			StrongWoodenBow(-1), -1, hashMapOf(
				Stick.tier(3) to 3,
				Vine.tier(3) to 1,
				Bone.tier(2) to 6
			                                  ), true
		        ) {
			StrongWoodenBow(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			ToughWoodenBow(-1), -1, hashMapOf(
				Stick.tier(3) to 3,
				Vine.tier(3) to 1,
				Pebble.tier(3) to 1
			                                 ), true
		        ) {
			ToughWoodenBow(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealthyWoodenBow(-1), -1, hashMapOf(
				Stick.tier(3) to 3,
				Vine.tier(3) to 1,
				PlantMatter.tier(3) to 1
			                                   ), true
		        ) {
			HealthyWoodenBow(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealingWoodenBow(-1), -1, hashMapOf(
				Stick.tier(3) to 3,
				Vine.tier(3) to 1,
				Wheat.tier(3) to 1
			                                   ), true
		        ) {
			HealingWoodenBow(Utils.randRarity()).getUpdatedItem(false)
		},

		//HEAVY MELEE
		ShopItem(
			Club(-1), 200, hashMapOf(
				Stick.tier(2) to 2
			                        ), true
		        ) {
			Club(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(GiantClub(-1), 300, hashMapOf(), false) {
			GiantClub(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(LuckyGiantClub(-1), 400, hashMapOf(), false) {
			LuckyGiantClub(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(StrongGiantClub(-1), 400, hashMapOf(), false) {
			StrongGiantClub(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(ToughGiantClub(-1), 400, hashMapOf(), false) {
			ToughGiantClub(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(HealthyGiantCLub(-1), 400, hashMapOf(), false) {
			HealthyGiantCLub(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(HealingGiantClub(-1), 400, hashMapOf(), false) {
			HealingGiantClub(Utils.randRarity()).getUpdatedItem(false)
		},

		//WANDS
		ShopItem(LivingTwig(-1), 200, hashMapOf(), false) {
			LivingTwig(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			GlisteningTwig(-1), 300, hashMapOf(
				Seed.tier(2) to 1,
				Stick.tier(2) to 1,
				Feather.tier(2) to 2
			                                  ), true
		        ) {
			GlisteningTwig(Utils.randRarity()).getUpdatedItem(false)
		},

		ShopItem(
			LuckyGlisteningTwig(-1), 400, hashMapOf(
				Seed.tier(2) to 1,
				Stick.tier(2) to 1,
				Feather.tier(2) to 2
			                                       ), true
		        ) {
			LuckyGlisteningTwig(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			StrongGlisteningTwig(-1), 400, hashMapOf(
				Seed.tier(2) to 1,
				Stick.tier(2) to 1,
				Bone.tier(2) to 1
			                                        ), true
		        ) {
			StrongGlisteningTwig(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			ToughGlisteningTwig(-1), 400, hashMapOf(
				Seed.tier(2) to 1,
				Stick.tier(2) to 1,
				Pebble.tier(2) to 2
			                                       ), true
		        ) {
			ToughGlisteningTwig(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealthyGlisteningTwig(-1), 400, hashMapOf(
				Seed.tier(2) to 1,
				Stick.tier(2) to 1,
				PlantMatter.tier(2) to 3
			                                         ), true
		        ) {
			HealthyGlisteningTwig(Utils.randRarity()).getUpdatedItem(false)
		},
		ShopItem(
			HealingGlisteningTwig(-1), 400, hashMapOf(
				Seed.tier(2) to 1,
				Stick.tier(2) to 1,
				Wheat.tier(2) to 2
			                                         ), true
		        ) {
			HealingGlisteningTwig(Utils.randRarity()).getUpdatedItem(false)
		},
	                                           )
}