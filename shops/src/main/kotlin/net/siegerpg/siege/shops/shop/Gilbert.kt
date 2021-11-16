package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.*
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Gilbert : Shop() {
    override var name: String = "Gilbert"
    override var permission: String = "siege.shops.shop.gilbert"
    override var items: List<ShopItem> = listOf(
        //IRON AXE
        ShopItem(net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.IronAxe(-1), 4750, hashMapOf(), false) {
            net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.IronAxe(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(
            LuckyIronAxe(-1), -1, hashMapOf(
                RefinedMetal.tier(3) to 2,
                Stick.tier(3) to 2,
                Feather.tier(3) to 2), true) {
            LuckyIronAxe(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            StrongIronAxe(-1), -1, hashMapOf(
                RefinedMetal.tier(3) to 2,
                Stick.tier(3) to 2,
                Bone.tier(3) to 2), true) {
            StrongIronAxe(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            ToughIronAxe(-1), -1, hashMapOf(
                RefinedMetal.tier(3) to 2,
                Stick.tier(3) to 2,
                Pebble.tier(3) to 2), true) {
            ToughIronAxe(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealthyIronAxe(-1), -1, hashMapOf(
                RefinedMetal.tier(3) to 2,
                Stick.tier(3) to 1,
                PlantMatter.tier(3) to 3), true) {
            HealthyIronAxe(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealingIronAxe(-1), -1, hashMapOf(
                RefinedMetal.tier(3) to 2,
                Stick.tier(3) to 2,
                Wheat.tier(4) to 1), true) {
            HealingIronAxe(Utils.randRarity()).getUpdatedItem(false)
        },
    )
}