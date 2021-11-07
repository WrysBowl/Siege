package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.weapons.wands.EarthernWand
import net.siegerpg.siege.core.items.implemented.weapons.wands.earthernWands.*
import net.siegerpg.siege.core.utils.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Katherine : Shop() {
    override var name: String = "Katherine"
    override var permission: String = "siege.shops.shop.katherine"
    override var items: List<ShopItem> = listOf(
        //EARTHERN WAND
        ShopItem(
            EarthernWand(-1), 5250, hashMapOf(
                Pebble.tier(3) to 1,
                Seed.tier(3) to 2,
                Coal.tier(3) to 2), true) {
            EarthernWand(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(
            LuckyEarthernWand(-1), 5250, hashMapOf(
                PlantMatter.tier(3) to 1,
                Seed.tier(3) to 1,
                Coal.tier(3) to 1,
                Feather.tier(3) to 3), true) {
            LuckyEarthernWand(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            StrongEarthernWand(-1), 5250, hashMapOf(
                PlantMatter.tier(3) to 1,
                Seed.tier(3) to 1,
                Coal.tier(3) to 1,
                Bone.tier(3) to 2), true) {
            StrongEarthernWand(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            ToughEarthernWand(-1), 5250, hashMapOf(
                PlantMatter.tier(3) to 1,
                Seed.tier(3) to 1,
                Coal.tier(3) to 1,
                Pebble.tier(3) to 4), true) {
            ToughEarthernWand(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealthyEarthernWand(-1), 5250, hashMapOf(
                PlantMatter.tier(3) to 4,
                Seed.tier(3) to 1,
                Coal.tier(3) to 1), true) {
            HealthyEarthernWand(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealingEarthernWand(-1), 5250, hashMapOf(
                PlantMatter.tier(3) to 1,
                Seed.tier(3) to 1,
                Coal.tier(3) to 1,
                Wheat.tier(4) to 1), true) {
            HealingEarthernWand(Utils.randRarity()).getUpdatedItem(false)
        }
    )
}