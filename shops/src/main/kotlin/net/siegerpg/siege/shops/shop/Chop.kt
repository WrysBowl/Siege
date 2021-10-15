package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.armor.boots.*
import net.siegerpg.siege.core.items.implemented.armor.boots.slimyBoots.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.slimyChestplates.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.slimyHelmets.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.slimyLeggings.*
import net.siegerpg.siege.core.items.implemented.misc.materials.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.core.utils.*
import net.siegerpg.siege.shops.*

class Chop : Shop() {
    override var name: String = "Chop"
    override var permission: String = "siege.shops.shop.chop"
    override var items: List<ShopItem> = listOf(
        ShopItem(SlimyHelmet(-1), 250, hashMapOf(
            Slime.tier(2) to 5), true) {
            SlimyHelmet(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(LuckySlimyHelmet(-1), 300, hashMapOf(
            Slime.tier(2) to 3,
            Feather.tier(2) to 2), true) {
            LuckySlimyHelmet(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(StrongSlimyHelmet(-1), 300, hashMapOf(
            Slime.tier(2) to 3,
            Bone.tier(2) to 1), true) {
            StrongSlimyHelmet(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(ToughSlimyHelmet(-1), 300, hashMapOf(
            Slime.tier(2) to 3,
            Pebble.tier(2) to 2), true) {
            ToughSlimyHelmet(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(HealthySlimyHelmet(-1), 300, hashMapOf(
            Slime.tier(2) to 3,
            PlantMatter.tier(2) to 2), true) {
            HealthySlimyHelmet(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(HealingSlimyHelmet(-1), 300, hashMapOf(
            Slime.tier(2) to 3,
            Wheat.tier(2) to 3), true) {
            HealingSlimyHelmet(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },

        //SLIMY CHESTPLATES
        ShopItem(SlimyChestplate(-1), 450, hashMapOf(
            Slime.tier(2) to 8), true) {
            SlimyChestplate(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(LuckySlimyChestplate(-1), 600, hashMapOf(
            Slime.tier(2) to 5,
            Feather.tier(2) to 3), true) {
            LuckySlimyChestplate(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(StrongSlimyChestplate(-1), 600, hashMapOf(
            Slime.tier(2) to 5,
            Bone.tier(2) to 2), true) {
            StrongSlimyChestplate(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(ToughSlimyChestplate(-1), 600, hashMapOf(
            Slime.tier(2) to 5,
            Pebble.tier(3) to 1), true) {
            ToughSlimyChestplate(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(HealthySlimyChestplate(-1), 600, hashMapOf(
            Slime.tier(2) to 5,
            PlantMatter.tier(3) to 1), true) {
            HealthySlimyChestplate(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(HealingSlimyChestplate(-1), 600, hashMapOf(
            Slime.tier(2) to 5,
            Wheat.tier(3) to 1), true) {
            HealingSlimyChestplate(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },

        //SLIMY LEGGINGS
        ShopItem(SlimyLeggings(-1), 350, hashMapOf(
            Slime.tier(2) to 7), true) {
            SlimyLeggings(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(LuckySlimyLeggings(-1), 500, hashMapOf(
            Slime.tier(2) to 3,
            Feather.tier(2) to 3), true) {
            LuckySlimyLeggings(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(StrongSlimyLeggings(-1), 500, hashMapOf(
            Slime.tier(2) to 3,
            Bone.tier(2) to 4), true) {
            StrongSlimyLeggings(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            ToughSlimyLeggings(-1), 500, hashMapOf(
                Slime.tier(2) to 4,
                Pebble.tier(2) to 4), true) {
            ToughSlimyLeggings(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(HealthySlimyLeggings(-1), 500, hashMapOf(
            Slime.tier(2) to 4,
            PlantMatter.tier(2) to 3), true) {
            HealthySlimyLeggings(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(HealingSlimyLeggings(-1), 500, hashMapOf(
            Slime.tier(2) to 3,
            Wheat.tier(2) to 4), true) {
            HealingSlimyLeggings(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },

        //SLIMY BOOTS
        ShopItem(SlimyBoots(-1), 200, hashMapOf(
            Slime.tier(2) to 4), true) {
            SlimyBoots(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(LuckySlimyBoots(-1), 300, hashMapOf(
            Slime.tier(2) to 3,
            Feather.tier(2) to 2), true) {
            LuckySlimyBoots(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(StrongSlimyBoots(-1), 300, hashMapOf(
            Slime.tier(2) to 2,
            Bone.tier(2) to 3), true) {
            StrongSlimyBoots(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(ToughSlimyBoots(-1), 300, hashMapOf(
            Slime.tier(2) to 2,
            Pebble.tier(2) to 3), true) {
            ToughSlimyBoots(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(HealthySlimyBoots(-1), 300, hashMapOf(
            Slime.tier(2) to 2,
            PlantMatter.tier(2) to 3), true) {
            HealthySlimyBoots(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(HealingSlimyBoots(-1), 300, hashMapOf(
            Slime.tier(2) to 2,
            Wheat.tier(2) to 6), true) {
            HealingSlimyBoots(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
    )
}