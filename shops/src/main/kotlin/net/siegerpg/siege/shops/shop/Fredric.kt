package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Magma
import net.siegerpg.siege.core.items.implemented.weapons.wands.FlamingHotTorch
import net.siegerpg.siege.core.items.implemented.weapons.wands.flamingHotTorches.*
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Fredric : Shop() {
    override var name: String = "Fredric"
    override var permission: String = "siege.shops.shop.fredric"
    override var items: List<ShopItem> = listOf(
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
            LuckyFlamingHotTorch(-1), -1, hashMapOf(
            Magma.tier(4) to 1,
            Seed.tier(3) to 4,
            Stick.tier(3) to 1,
            Feather.tier(3) to 3), true) {
            LuckyFlamingHotTorch(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            StrongFlamingHotTorch(-1), -1, hashMapOf(
            Magma.tier(4) to 1,
            Seed.tier(3) to 4,
            Stick.tier(3) to 1,
            Feather.tier(3) to 2), true) {
            StrongFlamingHotTorch(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            ToughFlamingHotTorch(-1), -1, hashMapOf(
            Magma.tier(4) to 1,
            Seed.tier(3) to 4,
            Stick.tier(3) to 1,
            Pebble.tier(3) to 3), true) {
            ToughFlamingHotTorch(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealthyFlamingHotTorch(-1), -1, hashMapOf(
            Magma.tier(4) to 1,
            Seed.tier(3) to 4,
            Stick.tier(3) to 1,
            PlantMatter.tier(3) to 3), true) {
            HealthyFlamingHotTorch(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealingFlamingHotTorch(-1), -1, hashMapOf(
            Magma.tier(4) to 1,
            Seed.tier(3) to 1,
            Stick.tier(3) to 1,
            Wheat.tier(4) to 4), true) {
            HealingFlamingHotTorch(Utils.randRarity()).getUpdatedItem(false)
        }
    )
}