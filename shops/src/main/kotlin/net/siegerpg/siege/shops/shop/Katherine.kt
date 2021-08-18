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

class Katherine : Shop() {
    override var name: String = "Katherine"
    override var permission: String = "siege.shops.shop.katherine"
    override var items: List<ShopItem> = listOf(
        //ROCK WAND
        ShopItem(
            RockWand(-1), 3500, hashMapOf(
                Pebble.tier(3) to 1,
                Stick.tier(3) to 2), true) {
            RockWand(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(
            LuckyRockWand(-1), 3750, hashMapOf(
                Pebble.tier(3) to 1,
                Feather.tier(3) to 2,
                Stick.tier(3) to 1), true) {
            LuckyRockWand(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            StrongRockWand(-1), 3750, hashMapOf(
                Pebble.tier(3) to 1,
                Feather.tier(3) to 1,
                Bone.tier(3) to 1), true) {
            StrongRockWand(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            ToughRockWand(-1), 3750, hashMapOf(
                Pebble.tier(3) to 3,
                Stick.tier(3) to 1), true) {
            ToughRockWand(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealthyRockWand(-1), 3750, hashMapOf(
                Pebble.tier(3) to 1,
                PlantMatter.tier(3) to 2,
                Stick.tier(3) to 1), true) {
            HealthyRockWand(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealingRockWand(-1), 3750, hashMapOf(
                Pebble.tier(3) to 1,
                Wheat.tier(3) to 3,
                Stick.tier(3) to 1), true) {
            HealingRockWand(Utils.randRarity()).getUpdatedItem(false)
        },

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
        },

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
        },
    )
}