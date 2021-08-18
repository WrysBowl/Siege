package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Minnow : Shop() {
    override var name: String = "Minnow"
    override var permission: String = "siege.shops.shop.minnow"
    override var items: List<ShopItem> = listOf(
        //TIER 2
        ShopItem(Chain.tier(2), -1, hashMapOf(
            Chain.tier(1) to 8), true) {
            Chain.tier(2).getUpdatedItem(false)
        },
        ShopItem(Coal.tier(2), -1, hashMapOf(
            Coal.tier(1) to 8), true) {
            Coal.tier(2).getUpdatedItem(false)
        },
        ShopItem(MetalScrap.tier(2), -1, hashMapOf(
            MetalScrap.tier(1) to 8), true) {
            MetalScrap.tier(2).getUpdatedItem(false)
        },
        ShopItem(RefinedMetal.tier(2), -1, hashMapOf(
            RefinedMetal.tier(1) to 8), true) {
            RefinedMetal.tier(2).getUpdatedItem(false)
        },
        ShopItem(Titanium.tier(2), -1, hashMapOf(
            Titanium.tier(1) to 8), true) {
            Titanium.tier(2).getUpdatedItem(false)
        },
        ShopItem(RefinedMetal.tier(1), -1, hashMapOf(
            MetalScrap.tier(1) to 8), true) {
            RefinedMetal.tier(1).getUpdatedItem(false)
        },
        ShopItem(Titanium.tier(1), -1, hashMapOf(
            RefinedMetal.tier(1) to 8), true) {
            Titanium.tier(1).getUpdatedItem(false)
        },

        //TIER 3
        ShopItem(Chain.tier(3), -1, hashMapOf(
            Chain.tier(2) to 8), true) {
            Chain.tier(3).getUpdatedItem(false)
        },
        ShopItem(Coal.tier(3), -1, hashMapOf(
            Coal.tier(2) to 8), true) {
            Coal.tier(3).getUpdatedItem(false)
        },
        ShopItem(MetalScrap.tier(3), -1, hashMapOf(
            MetalScrap.tier(2) to 8), true) {
            MetalScrap.tier(3).getUpdatedItem(false)
        },
        ShopItem(RefinedMetal.tier(3), -1, hashMapOf(
            RefinedMetal.tier(2) to 8), true) {
            RefinedMetal.tier(3).getUpdatedItem(false)
        },
        ShopItem(Titanium.tier(3), -1, hashMapOf(
            Titanium.tier(2) to 8), true) {
            Titanium.tier(3).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },

        //TIER 4
        ShopItem(Chain.tier(4), -1, hashMapOf(
            Chain.tier(3) to 8), true) {
            Chain.tier(4).getUpdatedItem(false)
        },
        ShopItem(Coal.tier(4), -1, hashMapOf(
            Coal.tier(3) to 8), true) {
            Coal.tier(4).getUpdatedItem(false)
        },
        ShopItem(MetalScrap.tier(4), -1, hashMapOf(
            MetalScrap.tier(3) to 8), true) {
            MetalScrap.tier(4).getUpdatedItem(false)
        },
        ShopItem(RefinedMetal.tier(4), -1, hashMapOf(
            RefinedMetal.tier(3) to 8), true) {
            RefinedMetal.tier(4).getUpdatedItem(false)
        },
        ShopItem(Titanium.tier(4), -1, hashMapOf(
            Titanium.tier(3) to 8), true) {
            Titanium.tier(4).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },

        //TIER 5
        ShopItem(Chain.tier(5), -1, hashMapOf(
            Chain.tier(4) to 8), true) {
            Chain.tier(5).getUpdatedItem(false)
        },
        ShopItem(Coal.tier(5), -1, hashMapOf(
            Coal.tier(4) to 8), true) {
            Coal.tier(5).getUpdatedItem(false)
        },
        ShopItem(MetalScrap.tier(5), -1, hashMapOf(
            MetalScrap.tier(4) to 8), true) {
            MetalScrap.tier(5).getUpdatedItem(false)
        },
        ShopItem(RefinedMetal.tier(5), -1, hashMapOf(
            RefinedMetal.tier(4) to 8), true) {
            RefinedMetal.tier(5).getUpdatedItem(false)
        },
        ShopItem(Titanium.tier(5), -1, hashMapOf(
            Titanium.tier(4) to 8), true) {
            Titanium.tier(5).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
    )
}