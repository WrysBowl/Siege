package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Magma
import net.siegerpg.siege.core.items.implemented.misc.wands.FlamingHotTorch
import net.siegerpg.siege.core.items.implemented.misc.wands.HotRod
import net.siegerpg.siege.core.items.implemented.misc.wands.Torch
import net.siegerpg.siege.core.items.implemented.misc.wands.flamingHotTorches.*
import net.siegerpg.siege.core.items.implemented.misc.wands.hotRods.*
import net.siegerpg.siege.core.items.implemented.misc.wands.torches.*
import net.siegerpg.siege.core.utils.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Fredric : Shop() {
    override var name: String = "Fredric"
    override var permission: String = "siege.shops.shop.fredric"
    override var items: List<ShopItem> = listOf(
        //TORCH
        ShopItem(
            Torch(-1), 3500, hashMapOf(
            Magma.tier(3) to 1,
            Stick.tier(3) to 2), true) {
            Torch(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(
            LuckyTorch(-1), 3750, hashMapOf(
            Magma.tier(3) to 1,
            Feather.tier(3) to 1,
            Stick.tier(3) to 1), true) {
            LuckyTorch(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            StrongTorch(-1), 3750, hashMapOf(
            Magma.tier(3) to 1,
            Bone.tier(3) to 1,
            Stick.tier(3) to 1), true) {
            StrongTorch(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            ToughTorch(-1), 3750, hashMapOf(
            Magma.tier(3) to 1,
            Pebble.tier(3) to 2,
            Stick.tier(3) to 1), true) {
            ToughTorch(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealthyTorch(-1), 3750, hashMapOf(
            Magma.tier(3) to 1,
            PlantMatter.tier(3) to 2,
            Stick.tier(3) to 1), true) {
            HealthyTorch(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealingTorch(-1), 3750, hashMapOf(
            Magma.tier(3) to 1,
            Wheat.tier(4) to 1,
            Stick.tier(3) to 1), true) {
            HealingTorch(Utils.randRarity()).getUpdatedItem(false)
        },

        //FLAMING HOT TORCH
        ShopItem(
            FlamingHotTorch(-1), 5250, hashMapOf(
            Magma.tier(4) to 1,
            Seed.tier(4) to 1,
            Stick.tier(3) to 1), true) {
            FlamingHotTorch(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(
            LuckyFlamingHotTorch(-1), 5250, hashMapOf(
            Magma.tier(4) to 1,
            Seed.tier(3) to 4,
            Stick.tier(3) to 1,
            Feather.tier(3) to 3), true) {
            LuckyFlamingHotTorch(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            StrongFlamingHotTorch(-1), 5250, hashMapOf(
            Magma.tier(4) to 1,
            Seed.tier(3) to 4,
            Stick.tier(3) to 1,
            Feather.tier(3) to 2), true) {
            StrongFlamingHotTorch(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            ToughFlamingHotTorch(-1), 5250, hashMapOf(
            Magma.tier(4) to 1,
            Seed.tier(3) to 4,
            Stick.tier(3) to 1,
            Pebble.tier(3) to 3), true) {
            ToughFlamingHotTorch(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealthyFlamingHotTorch(-1), 5250, hashMapOf(
            Magma.tier(4) to 1,
            Seed.tier(3) to 4,
            Stick.tier(3) to 1,
            PlantMatter.tier(3) to 3), true) {
            HealthyFlamingHotTorch(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealingFlamingHotTorch(-1), 5250, hashMapOf(
            Magma.tier(4) to 1,
            Seed.tier(3) to 1,
            Stick.tier(3) to 1,
            Wheat.tier(4) to 4), true) {
            HealingFlamingHotTorch(Utils.randRarity()).getUpdatedItem(false)
        },

        //HOT ROD
        ShopItem(
            HotRod(-1), 6500, hashMapOf(
            PlantMatter.tier(3) to 1,
            Seed.tier(4) to 2,
            Coal.tier(4) to 2), true) {
            HotRod(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(
            LuckyHotRod(-1), 6750, hashMapOf(
            PlantMatter.tier(3) to 1,
            Seed.tier(4) to 1,
            Coal.tier(4) to 1,
            Feather.tier(4) to 2), true) {
            LuckyHotRod(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            StrongHotRod(-1), 6750, hashMapOf(
            PlantMatter.tier(3) to 1,
            Seed.tier(4) to 1,
            Coal.tier(4) to 1,
            Bone.tier(4) to 1), true) {
            StrongHotRod(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            ToughHotRod(-1), 6750, hashMapOf(
            PlantMatter.tier(3) to 1,
            Seed.tier(4) to 1,
            Coal.tier(4) to 1,
            Pebble.tier(4) to 3), true) {
            ToughHotRod(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealthyHotRod(-1), 6750, hashMapOf(
            PlantMatter.tier(4) to 2,
            Seed.tier(4) to 1,
            Coal.tier(4) to 1), true) {
            HealthyHotRod(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealingHotRod(-1), 6750, hashMapOf(
            PlantMatter.tier(3) to 1,
            Seed.tier(4) to 1,
            Coal.tier(4) to 1,
            Wheat.tier(4) to 3), true) {
            HealingHotRod(Utils.randRarity()).getUpdatedItem(false)
        },
    )
}