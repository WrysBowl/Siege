package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Vine
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Wool
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Phillip : Shop() {
    override var name: String = "Phillip"
    override var permission: String = "siege.shops.shop.phillip"
    override var items: List<ShopItem> = listOf(
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
    )
}