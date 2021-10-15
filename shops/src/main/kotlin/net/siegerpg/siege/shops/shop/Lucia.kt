package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.misc.wands.EarthernStaff
import net.siegerpg.siege.core.items.implemented.misc.wands.EarthernWand
import net.siegerpg.siege.core.items.implemented.misc.wands.RockWand
import net.siegerpg.siege.core.items.implemented.misc.wands.earthernStaffs.*
import net.siegerpg.siege.core.items.implemented.misc.wands.earthernWands.*
import net.siegerpg.siege.core.items.implemented.misc.wands.rockWands.*
import net.siegerpg.siege.core.utils.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Lucia : Shop() {
    override var name: String = "Lucia"
    override var permission: String = "siege.shops.shop.lucia"
    override var items: List<ShopItem> = listOf(
        //EARTHERN STAFF
        ShopItem(
            EarthernStaff(-1), 6000, hashMapOf(
                PlantMatter.tier(3) to 1,
                Seed.tier(4) to 2,
                Coal.tier(4) to 2), true) {
            EarthernStaff(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(
            LuckyEarthernStaff(-1), 6500, hashMapOf(
                PlantMatter.tier(3) to 1,
                Seed.tier(4) to 1,
                Coal.tier(4) to 1,
                Feather.tier(4) to 2), true) {
            LuckyEarthernStaff(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            StrongEarthernStaff(-1), 6500, hashMapOf(
                PlantMatter.tier(3) to 1,
                Seed.tier(4) to 1,
                Coal.tier(4) to 1,
                Pebble.tier(4) to 3), true) {
            StrongEarthernStaff(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            ToughEarthernStaff(-1), 6500, hashMapOf(
                PlantMatter.tier(3) to 1,
                Seed.tier(3) to 1,
                Coal.tier(3) to 1,
                Pebble.tier(3) to 4), true) {
            ToughEarthernStaff(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealthyEarthernStaff(-1), 6500, hashMapOf(
                PlantMatter.tier(4) to 2,
                Seed.tier(4) to 1,
                Coal.tier(4) to 1), true) {
            HealthyEarthernStaff(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealingEarthernStaff(-1), 6500, hashMapOf(
                PlantMatter.tier(3) to 1,
                Seed.tier(4) to 1,
                Coal.tier(4) to 1,
                Wheat.tier(5) to 1), true) {
            HealingEarthernStaff(Utils.randRarity()).getUpdatedItem(false)
        }
    )
}