package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
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

class Twig : Shop() {

	override var name : String = "Crafting a Twig"
	override var permission : String = "siege.shops.shop.twig"
	override var items : List<ShopItem> = listOf(
			//LIGHT MELEE
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
				GRAYFILLER(-1).getUpdatedItem(false)
			},
			ShopItem(Twig(-1), -1, hashMapOf(Stick.tier(2) to 1), true) {
				Twig(Utils.randRarity()).getUpdatedItem(false)
			},
	                                            )
}