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

class Phillip : Shop("Phillip", "siege.shops.shop.phillip", listOf(
    //TIER 2
    ShopItem(Vine.tier(2), -1, hashMapOf(
        Vine.tier(1) to 8), true) {
        Vine.tier(2).getUpdatedItem(false)
    },
    ShopItem(Bone.tier(2), -1, hashMapOf(
        Bone.tier(1) to 8), true) {
        Bone.tier(2).getUpdatedItem(false)
    },
    ShopItem(Wool.tier(2), -1, hashMapOf(
        Wool.tier(1) to 8), true) {
        Wool.tier(2).getUpdatedItem(false)
    },
    ShopItem(Leather.tier(2), -1, hashMapOf(
        Leather.tier(1) to 8), true) {
        Leather.tier(2).getUpdatedItem(false)
    },
    ShopItem(Wheat.tier(2), -1, hashMapOf(
        Wheat.tier(1) to 8), true) {
        Wheat.tier(2).getUpdatedItem(false)
    },
    ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
        Wheat.tier(2).getUpdatedItem(false)
    },
    ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
        GRAYFILLER(-1).getUpdatedItem(false)
    },

    //TIER 3
    ShopItem(Vine.tier(3), -1, hashMapOf(
        Vine.tier(2) to 8), true) {
        Vine.tier(3).getUpdatedItem(false)
    },
    ShopItem(Bone.tier(3), -1, hashMapOf(
        Bone.tier(2) to 8), true) {
        Bone.tier(3).getUpdatedItem(false)
    },
    ShopItem(Wool.tier(3), -1, hashMapOf(
        Wool.tier(2) to 8), true) {
        Wool.tier(3).getUpdatedItem(false)
    },
    ShopItem(Leather.tier(3), -1, hashMapOf(
        Leather.tier(2) to 8), true) {
        Leather.tier(3).getUpdatedItem(false)
    },
    ShopItem(Wheat.tier(3), -1, hashMapOf(
        Wheat.tier(2) to 8), true) {
        Wheat.tier(3).getUpdatedItem(false)
    },
    ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
        GRAYFILLER(-1).getUpdatedItem(false)
    },
    ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
        GRAYFILLER(-1).getUpdatedItem(false)
    },

    //TIER 4
    ShopItem(Vine.tier(4), -1, hashMapOf(
        Vine.tier(3) to 8), true) {
        Vine.tier(4).getUpdatedItem(false)
    },
    ShopItem(Bone.tier(4), -1, hashMapOf(
        Bone.tier(3) to 8), true) {
        Bone.tier(4).getUpdatedItem(false)
    },
    ShopItem(Wool.tier(4), -1, hashMapOf(
        Wool.tier(3) to 8), true) {
        Wool.tier(4).getUpdatedItem(false)
    },
    ShopItem(Leather.tier(4), -1, hashMapOf(
        Leather.tier(3) to 8), true) {
        Leather.tier(4).getUpdatedItem(false)
    },
    ShopItem(Wheat.tier(4), -1, hashMapOf(
        Wheat.tier(3) to 8), true) {
        Wheat.tier(4).getUpdatedItem(false)
    },
    ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
        GRAYFILLER(-1).getUpdatedItem(false)
    },
    ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
        GRAYFILLER(-1).getUpdatedItem(false)
    },

    //TIER 5
    ShopItem(Vine.tier(5), -1, hashMapOf(
        Vine.tier(4) to 8), true) {
        Vine.tier(5).getUpdatedItem(false)
    },
    ShopItem(Bone.tier(5), -1, hashMapOf(
        Bone.tier(4) to 8), true) {
        Bone.tier(5).getUpdatedItem(false)
    },
    ShopItem(Wool.tier(5), -1, hashMapOf(
        Wool.tier(4) to 8), true) {
        Wool.tier(5).getUpdatedItem(false)
    },
    ShopItem(Leather.tier(5), -1, hashMapOf(
        Leather.tier(4) to 8), true) {
        Leather.tier(5).getUpdatedItem(false)
    },
    ShopItem(Wheat.tier(5), -1, hashMapOf(
        Wheat.tier(4) to 8), true) {
        Wheat.tier(5).getUpdatedItem(false)
    },
    ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
        GRAYFILLER(-1).getUpdatedItem(false)
    },
    ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
        GRAYFILLER(-1).getUpdatedItem(false)
    },
))