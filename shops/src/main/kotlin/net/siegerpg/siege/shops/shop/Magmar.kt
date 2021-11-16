package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.armor.boots.MagmaBoots
import net.siegerpg.siege.core.items.implemented.armor.boots.magmaBoots.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.MagmaChestplate
import net.siegerpg.siege.core.items.implemented.armor.chestplate.magmaChestplates.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.MagmaHelmet
import net.siegerpg.siege.core.items.implemented.armor.helmet.magmaHelmets.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.MagmaLeggings
import net.siegerpg.siege.core.items.implemented.armor.leggings.magmaLeggings.*
import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Magma
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Magmar : Shop() {
    override var name: String = "Magmar"
    override var permission: String = "siege.shops.shop.magmar"
    override var items: List<ShopItem> = listOf(
        //MAGMA HELMET
        ShopItem(MagmaHelmet(-1), 1000, hashMapOf(
            Magma.tier(2) to 5), true) {
            MagmaHelmet(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(
            LuckyMagmaHelmet(-1), -1, hashMapOf(
                Magma.tier(2) to 3,
                Feather.tier(2) to 3), true) {
            LuckyMagmaHelmet(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            StrongMagmaHelmet(-1), -1, hashMapOf(
                Magma.tier(2) to 3,
                Bone.tier(2) to 2), true) {
            StrongMagmaHelmet(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            ToughMagmaHelmet(-1), -1, hashMapOf(
                Magma.tier(2) to 2,
                Pebble.tier(2) to 3), true) {
            ToughMagmaHelmet(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealthyMagmaHelmet(-1), -1, hashMapOf(
                Magma.tier(2) to 3,
                PlantMatter.tier(2) to 2), true) {
            HealthyMagmaHelmet(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealingMagmaHelmet(-1), -1, hashMapOf(
                Magma.tier(2) to 2,
                Wheat.tier(3) to 1), true) {
            HealingMagmaHelmet(Utils.randRarity()).getUpdatedItem(false)
        },

        //MAGMA CHESTPLATE
        ShopItem(MagmaChestplate(-1), 2000, hashMapOf(
            Magma.tier(2) to 8), true) {
            MagmaChestplate(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(
            LuckyMagmaChestplate(-1), 2250, hashMapOf(
                Magma.tier(2) to 5,
                Feather.tier(2) to 3), true) {
            LuckyMagmaChestplate(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            StrongMagmaChestplate(-1), 2250, hashMapOf(
                Magma.tier(2) to 4,
                Bone.tier(2) to 3), true) {
            StrongMagmaChestplate(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            ToughMagmaChestplate(-1), 2250, hashMapOf(
                Magma.tier(2) to 3,
                Pebble.tier(2) to 5), true) {
            ToughMagmaChestplate(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealthyMagmaChestplate(-1), 2250, hashMapOf(
                Magma.tier(2) to 4,
                PlantMatter.tier(2) to 4), true) {
            HealthyMagmaChestplate(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealingMagmaChestplate(-1), 2250, hashMapOf(
                Magma.tier(2) to 4,
                Wheat.tier(3) to 2), true) {
            HealingMagmaChestplate(Utils.randRarity()).getUpdatedItem(false)
        },

        //MAGMA LEGGINGS
        ShopItem(MagmaLeggings(-1), 1750, hashMapOf(
            Magma.tier(2) to 7), true) {
            MagmaLeggings(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(
            LuckyMagmaLeggings(-1), 2000, hashMapOf(
                Magma.tier(2) to 4,
                Feather.tier(2) to 3), true) {
            LuckyMagmaLeggings(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            StrongMagmaLeggings(-1), 2000, hashMapOf(
                Magma.tier(2) to 4,
                Bone.tier(2) to 3), true) {
            StrongMagmaLeggings(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            ToughMagmaLeggings(-1), 2000, hashMapOf(
                Magma.tier(2) to 3,
                Pebble.tier(2) to 5), true) {
            ToughMagmaLeggings(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealthyMagmaLeggings(-1), 2000, hashMapOf(
                Magma.tier(2) to 3,
                PlantMatter.tier(2) to 4), true) {
            HealthyMagmaLeggings(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealingMagmaLeggings(-1), 2000, hashMapOf(
                Magma.tier(2) to 4,
                Wheat.tier(3) to 1), true) {
            HealingMagmaLeggings(Utils.randRarity()).getUpdatedItem(false)
        },

        //MAGMA BOOTS
        ShopItem(MagmaBoots(-1), 1000, hashMapOf(
            Magma.tier(2) to 4), true) {
            MagmaBoots(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(
            LuckyMagmaBoots(-1), -1, hashMapOf(
                Magma.tier(2) to 2,
                Feather.tier(2) to 2), true) {
            LuckyMagmaBoots(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            StrongMagmaBoots(-1), -1, hashMapOf(
                Magma.tier(2) to 2,
                Bone.tier(2) to 2), true) {
            StrongMagmaBoots(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            ToughMagmaBoots(-1), -1, hashMapOf(
                Magma.tier(2) to 2,
                Pebble.tier(2) to 2), true) {
            ToughMagmaBoots(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealthyMagmaBoots(-1), -1, hashMapOf(
                Magma.tier(2) to 3,
                PlantMatter.tier(2) to 2), true) {
            HealthyMagmaBoots(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealingMagmaBoots(-1), -1, hashMapOf(
                Magma.tier(2) to 1,
                Feather.tier(3) to 1), true) {
            HealingMagmaBoots(Utils.randRarity()).getUpdatedItem(false)
        },
    )
}