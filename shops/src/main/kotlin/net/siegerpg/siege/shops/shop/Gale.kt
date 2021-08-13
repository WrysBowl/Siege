package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.doubleBladedAxes.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.greatSwords.*
import net.siegerpg.siege.core.utils.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Gale : Shop() {
    override var name: String = "Gale"
    override var permission: String = "siege.shops.shop.gale"
    override var items: List<ShopItem> = listOf(
        //DOUBLE BLADED AXE
        ShopItem(DoubleBladedAxe(-1), 3000, hashMapOf(), false) {
            DoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(
            LuckyDoubleBladedAxe(-1), 3500, hashMapOf(
                Pebble.tier(3) to 3,
                Stick.tier(3) to 2,
                Feather.tier(3) to 2), true) {
            LuckyDoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            StrongDoubleBladedAxe(-1), 3500, hashMapOf(
                Pebble.tier(3) to 3,
                Stick.tier(3) to 2,
                Bone.tier(3) to 2), true) {
            StrongDoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            ToughDoubleBladedAxe(-1), 3500, hashMapOf(
                Pebble.tier(4) to 1,
                Stick.tier(3) to 2), true) {
            ToughDoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealthyDoubleBladedAxe(-1), 3500, hashMapOf(
                Pebble.tier(3) to 3,
                Stick.tier(3) to 2,
                PlantMatter.tier(3) to 2), true) {
            HealthyDoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealingDoubleBladedAxe(-1), 3500, hashMapOf(
                Pebble.tier(3) to 3,
                Stick.tier(3) to 2,
                Wheat.tier(4) to 1), true) {
            HealingDoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false)
        },

        //GREAT SWORD
        ShopItem(
            GreatSword(-1), 3750, hashMapOf(
                MetalScrap.tier(3) to 2,
                Stick.tier(3) to 1), true) {
            GreatSword(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(
            LuckyGreatSword(-1), 4000, hashMapOf(
                MetalScrap.tier(3) to 1,
                Stick.tier(3) to 1,
                Feather.tier(3) to 2), true) {
            LuckyGreatSword(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            StrongGreatSword(-1), 4000, hashMapOf(
                MetalScrap.tier(3) to 1,
                Stick.tier(3) to 1,
                Bone.tier(3) to 2), true) {
            StrongGreatSword(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            ToughGreatSword(-1), 4000, hashMapOf(
                MetalScrap.tier(3) to 1,
                Stick.tier(3) to 1,
                Pebble.tier(3) to 3), true) {
            ToughGreatSword(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealthyGreatSword(-1), 4000, hashMapOf(
                MetalScrap.tier(3) to 1,
                Stick.tier(3) to 1,
                PlantMatter.tier(3) to 2), true) {
            HealthyGreatSword(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealingGreatSword(-1), 4000, hashMapOf(
                MetalScrap.tier(3) to 1,
                Stick.tier(3) to 1,
                Wheat.tier(4) to 1), true) {
            HealingGreatSword(Utils.randRarity()).getUpdatedItem(false)
        },

        //IRON AXE
        ShopItem(net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.IronAxe(-1), 4750, hashMapOf(), false) {
            net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.IronAxe(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(
            LuckyIronAxe(-1), 5000, hashMapOf(
                RefinedMetal.tier(3) to 2,
                Stick.tier(3) to 2,
                Feather.tier(3) to 2), true) {
            LuckyIronAxe(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            StrongIronAxe(-1), 5000, hashMapOf(
                RefinedMetal.tier(3) to 2,
                Stick.tier(3) to 2,
                Bone.tier(3) to 2), true) {
            StrongIronAxe(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            ToughIronAxe(-1), 5000, hashMapOf(
                RefinedMetal.tier(3) to 2,
                Stick.tier(3) to 2,
                Pebble.tier(3) to 2), true) {
            ToughIronAxe(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealthyIronAxe(-1), 5000, hashMapOf(
                RefinedMetal.tier(3) to 2,
                Stick.tier(3) to 1,
                PlantMatter.tier(3) to 3), true) {
            HealthyIronAxe(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealingIronAxe(-1), 5000, hashMapOf(
                RefinedMetal.tier(3) to 2,
                Stick.tier(3) to 2,
                Wheat.tier(4) to 1), true) {
            HealingIronAxe(Utils.randRarity()).getUpdatedItem(false)
        },
    )
}