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

class Helen : Shop() {
    override var name: String = "Helen"
    override var permission: String = "siege.shops.shop.helen"
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
        }
    )
}