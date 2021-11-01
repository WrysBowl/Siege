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
import net.siegerpg.siege.core.utils.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Joe : Shop() {
    override var name: String = "Joe"
    override var permission: String = "siege.shops.shop.joe"
    override var items: List<ShopItem> = listOf(
        //STRAW HAT
        ShopItem(StrawHelmet(-1), 400, hashMapOf(
            Wheat.tier(2) to 4), true) {
            StrawHelmet(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(
            LuckyStrawHat(-1), 500, hashMapOf(
                Wheat.tier(2) to 2,
                Feather.tier(2) to 4), true) {
            LuckyStrawHat(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            StrongStrawHat(-1), 500, hashMapOf(
                Wheat.tier(2) to 2,
                Bone.tier(2) to 4), true) {
            StrongStrawHat(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            ToughStrawHat(-1), 500, hashMapOf(
                Wheat.tier(2) to 2,
                Pebble.tier(2) to 4), true) {
            ToughStrawHat(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealthyStrawHat(-1), 500, hashMapOf(
                Wheat.tier(2) to 2,
                PlantMatter.tier(2) to 4), true) {
            HealthyStrawHat(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealingStrawHat(-1), 500, hashMapOf(
                Wheat.tier(2) to 3), true) {
            HealingStrawHat(Utils.randRarity()).getUpdatedItem(false)
        },

        //STRAW CHESTPLATE
        ShopItem(StrawChestplate(-1), 600, hashMapOf(
            Wheat.tier(2) to 8), true) {
            StrawChestplate(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(
            LuckyStrawChestplate(-1), 700, hashMapOf(
                Wheat.tier(2) to 6,
                Feather.tier(2) to 2), true) {
            LuckyStrawChestplate(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            StrongStrawChestplate(-1), 700, hashMapOf(
                Wheat.tier(2) to 6,
                Bone.tier(2) to 2), true) {
            StrongStrawChestplate(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            ToughStrawChestplate(-1), 700, hashMapOf(
                Wheat.tier(2) to 6,
                Pebble.tier(2) to 5), true) {
            ToughStrawChestplate(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealthyStrawChestplate(-1), 700, hashMapOf(
                Wheat.tier(2) to 6,
                PlantMatter.tier(2) to 4), true) {
            HealthyStrawChestplate(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealingStrawChestplate(-1), 700, hashMapOf(
                Wheat.tier(2) to 10), true) {
            HealingStrawChestplate(Utils.randRarity()).getUpdatedItem(false)
        },

        //STRAW LEGGINGS
        ShopItem(StrawLeggings(-1), 500, hashMapOf(
            Wheat.tier(2) to 7), true) {
            StrawLeggings(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(
            LuckyStrawOveralls(-1), 600, hashMapOf(
                Wheat.tier(2) to 3,
                Feather.tier(2) to 3), true) {
            LuckyStrawOveralls(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            StrongStrawOveralls(-1), 600, hashMapOf(
                Wheat.tier(2) to 4,
                Bone.tier(2) to 3), true) {
            StrongStrawOveralls(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            ToughStrawOveralls(-1), 600, hashMapOf(
                Wheat.tier(2) to 2,
                Pebble.tier(2) to 5), true) {
            ToughStrawOveralls(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealthyStrawOveralls(-1), 600, hashMapOf(
                Wheat.tier(2) to 2,
                PlantMatter.tier(2) to 5), true) {
            HealthyStrawOveralls(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealingStrawOveralls(-1), 600, hashMapOf(
                Wheat.tier(2) to 8), true) {
            HealingStrawOveralls(Utils.randRarity()).getUpdatedItem(false)
        },

        //STRAW BOOTS
        ShopItem(StrawBoots(-1), 300, hashMapOf(
            Wheat.tier(2) to 4), true) {
            StrawBoots(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(
            LuckyStrawBoots(-1), 400, hashMapOf(
                Wheat.tier(2) to 2,
                Feather.tier(2) to 2), true) {
            LuckyStrawBoots(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            StrongStrawBoots(-1), 400, hashMapOf(
                Wheat.tier(2) to 2,
                Bone.tier(2) to 2), true) {
            StrongStrawBoots(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            ToughStrawBoots(-1), 400, hashMapOf(
                Wheat.tier(2) to 2,
                Pebble.tier(2) to 3), true) {
            ToughStrawBoots(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealthyStrawBoots(-1), 400, hashMapOf(
                Wheat.tier(2) to 2,
                PlantMatter.tier(2) to 3), true) {
            HealthyStrawBoots(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealingStrawBoots(-1), 400, hashMapOf(
                Wheat.tier(2) to 5), true) {
            HealingStrawBoots(Utils.randRarity()).getUpdatedItem(false)
        },
    )
}