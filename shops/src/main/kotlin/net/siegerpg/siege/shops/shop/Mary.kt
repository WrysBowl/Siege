package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.FishingExplanation
import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.tools.fishingRod.*
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Mary : Shop() {
    override var name: String = "Mary"
    override var permission: String = "siege.shops.shop.mary"
    override var items: List<ShopItem> = listOf(
        //Chain HELMET
        ShopItem(
            OldRod(-1), 3500, hashMapOf(
                Vine.tier(3) to 2,
                Stick.tier(3) to 3), true) {
            OldRod(0).getUpdatedItem(false)
        },
        ShopItem(
            OakRod(-1), 7500, hashMapOf(
                Vine.tier(4) to 2,
                Stick.tier(5) to 1), true) {
            OakRod(0).getUpdatedItem(false)
        },
        ShopItem(
            BoneRod(-1), 11500, hashMapOf(
                Vine.tier(4) to 2,
                Bone.tier(3) to 3), true) {
            BoneRod(0).getUpdatedItem(false)
        },
        ShopItem(FishingExplanation(-1), -1, hashMapOf(), false) {
            FishingExplanation(-1).getUpdatedItem(false)
        },
        ShopItem(
            MetalRod(-1), 15000, hashMapOf(
                Chain.tier(2) to 3,
                MetalScrap.tier(4) to 2), true) {
            MetalRod(0).getUpdatedItem(false)
        },
        ShopItem(
            RefinedRod(-1), 20000, hashMapOf(
                Chain.tier(3) to 2,
                RefinedMetal.tier(4) to 2), true) {
            RefinedRod(0).getUpdatedItem(false)
        },
        ShopItem(
            TitaniumRod(-1), 25000, hashMapOf(
                Chain.tier(3) to 2,
                Titanium.tier(4) to 1), true) {
            TitaniumRod(0).getUpdatedItem(false)
        }
    )
}