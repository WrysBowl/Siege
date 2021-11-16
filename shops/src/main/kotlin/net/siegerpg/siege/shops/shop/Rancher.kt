package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.armor.boots.LeatherBoots
import net.siegerpg.siege.core.items.implemented.armor.boots.hardenedLeatherBoots.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.LeatherChestplate
import net.siegerpg.siege.core.items.implemented.armor.chestplate.hardenedLeatherChestplates.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.LeatherHelmet
import net.siegerpg.siege.core.items.implemented.armor.helmet.hardenedLeatherHelmets.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.LeatherLeggings
import net.siegerpg.siege.core.items.implemented.armor.leggings.hardenedLeatherLeggings.*
import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Rancher : Shop() {
    override var name: String = "Rancher"
    override var permission: String = "siege.shops.shop.rancher"
    override var items: List<ShopItem> = listOf(
        //HARDENED LEATHER HELMET
        ShopItem(LeatherHelmet(-1), 1500, hashMapOf(
            Leather.tier(2) to 5), true) {
            LeatherHelmet(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(
            LuckyHardenedLeatherHelmet(-1), -1, hashMapOf(
                Leather.tier(2) to 3,
                Feather.tier(2) to 3), true) {
            LuckyHardenedLeatherHelmet(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            StrongHardenedLeatherHelmet(-1), -1, hashMapOf(
                Leather.tier(2) to 3,
                Bone.tier(2) to 2), true) {
            StrongHardenedLeatherHelmet(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            ToughHardenedLeatherHelmet(-1), -1, hashMapOf(
                Leather.tier(2) to 3,
                Pebble.tier(2) to 3), true) {
            ToughHardenedLeatherHelmet(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealthyHardenedLeatherHelmet(-1), -1, hashMapOf(
                Leather.tier(2) to 3,
                PlantMatter.tier(2) to 3), true) {
            HealthyHardenedLeatherHelmet(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealingHardenedLeatherHelmet(-1), -1, hashMapOf(
                Leather.tier(2) to 3,
                Wheat.tier(4) to 1), true) {
            HealingHardenedLeatherHelmet(Utils.randRarity()).getUpdatedItem(false)
        },

        //HardenedLeather CHESTPLATE
        ShopItem(LeatherChestplate(-1), 2750, hashMapOf(
            Leather.tier(2) to 8), true) {
            LeatherChestplate(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(
            LuckyHardenedLeatherChestplate(-1), 3000, hashMapOf(
                Leather.tier(2) to 4,
                Feather.tier(2) to 4), true) {
            LuckyHardenedLeatherChestplate(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            StrongHardenedLeatherChestplate(-1), 3000, hashMapOf(
                Leather.tier(2) to 5,
                Bone.tier(2) to 3), true) {
            StrongHardenedLeatherChestplate(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            ToughHardenedLeatherChestplate(-1), 3000, hashMapOf(
                Leather.tier(2) to 3,
                Pebble.tier(2) to 5), true) {
            ToughHardenedLeatherChestplate(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealthyHardenedLeatherChestplate(-1), 3000, hashMapOf(
                Leather.tier(2) to 3,
                PlantMatter.tier(2) to 5), true) {
            HealthyHardenedLeatherChestplate(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealingHardenedLeatherChestplate(-1), 3000, hashMapOf(
                Leather.tier(2) to 4,
                Wheat.tier(4) to 1), true) {
            HealingHardenedLeatherChestplate(Utils.randRarity()).getUpdatedItem(false)
        },

        //HardenedLeather LEGGINGS
        ShopItem(LeatherLeggings(-1), 2250, hashMapOf(
            Leather.tier(2) to 7), true) {
            LeatherLeggings(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(
            LuckyHardenedLeatherLeggings(-1), 2500, hashMapOf(
                Leather.tier(2) to 3,
                Feather.tier(2) to 4), true) {
            LuckyHardenedLeatherLeggings(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            StrongHardenedLeatherLeggings(-1), 2500, hashMapOf(
                Leather.tier(2) to 4,
                Bone.tier(2) to 3), true) {
            StrongHardenedLeatherLeggings(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            ToughHardenedLeatherLeggings(-1), 2500, hashMapOf(
                Leather.tier(2) to 2,
                Pebble.tier(2) to 5), true) {
            ToughHardenedLeatherLeggings(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealthyHardenedLeatherLeggings(-1), 2500, hashMapOf(
                Leather.tier(2) to 3,
                PlantMatter.tier(2) to 4), true) {
            HealthyHardenedLeatherLeggings(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealingHardenedLeatherLeggings(-1), 2500, hashMapOf(
                Leather.tier(2) to 3,
                Wheat.tier(4) to 1), true) {
            HealingHardenedLeatherLeggings(Utils.randRarity()).getUpdatedItem(false)
        },

        //HardenedLeather BOOTS
        ShopItem(LeatherBoots(-1), 1250, hashMapOf(
            Leather.tier(2) to 4), true) {
            LeatherBoots(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(
            LuckyHardenedLeatherBoots(-1), 1500, hashMapOf(
                Leather.tier(2) to 2,
                Feather.tier(2) to 2), true) {
            LuckyHardenedLeatherBoots(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            StrongHardenedLeatherBoots(-1), 1500, hashMapOf(
                Leather.tier(2) to 3,
                Bone.tier(2) to 1), true) {
            StrongHardenedLeatherBoots(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            ToughHardenedLeatherBoots(-1), 1500, hashMapOf(
                Leather.tier(2) to 2,
                Pebble.tier(2) to 3), true) {
            ToughHardenedLeatherBoots(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealthyHardenedLeatherBoots(-1), 1500, hashMapOf(
                Leather.tier(2) to 1,
                PlantMatter.tier(2) to 4), true) {
            HealthyHardenedLeatherBoots(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealingHardenedLeatherBoots(-1), 1500, hashMapOf(
                Leather.tier(2) to 2,
                Wheat.tier(3) to 4), true) {
            HealingHardenedLeatherBoots(Utils.randRarity()).getUpdatedItem(false)
        },
    )
}