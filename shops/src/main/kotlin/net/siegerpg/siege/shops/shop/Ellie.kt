package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.weapons.wands.SlimeSpoofer
import net.siegerpg.siege.core.items.implemented.weapons.wands.slimeSpoofers.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.stoneAxes.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Shovel
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.shovels.*
import net.siegerpg.siege.core.items.implemented.weapons.ranged.ReinforcedBow
import net.siegerpg.siege.core.items.implemented.weapons.ranged.reinforcedBows.*
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Ellie : Shop() {
    override var name: String = "Ellie"
    override var permission: String = "siege.shops.shop.ellie"
    override var items: List<ShopItem> = listOf(
        //SHOVELS
        ShopItem(Shovel(-1), 600, hashMapOf(
            Pebble.tier(2) to 1,
            Stick.tier(3) to 2), true) {
            Shovel(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(LuckyShovel(-1), -1, hashMapOf(
            Pebble.tier(2) to 1,
            Stick.tier(3) to 1,
            Feather.tier(2) to 2), true) {
            LuckyShovel(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(StrongShovel(-1), -1, hashMapOf(
            Pebble.tier(2) to 1,
            Stick.tier(3) to 1,
            Bone.tier(2) to 1), true) {
            StrongShovel(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(ToughShovel(-1), -1, hashMapOf(
            Pebble.tier(2) to 4,
            Stick.tier(3) to 1), true) {
            ToughShovel(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(HealthyShovel(-1), -1, hashMapOf(
            Pebble.tier(2) to 1,
            Stick.tier(3) to 1,
            PlantMatter.tier(2) to 2), true) {
            HealthyShovel(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(HealingShovel(-1), -1, hashMapOf(
            Pebble.tier(2) to 1,
            Stick.tier(3) to 1,
            Wheat.tier(3) to 1), true) {
            HealingShovel(Utils.randRarity()).getUpdatedItem(false)
        },

        //REINFORCED BOWS
        ShopItem(ReinforcedBow(-1), 1000, hashMapOf(
            Stick.tier(3) to 3,
            Vine.tier(3) to 3), true) {
            ReinforcedBow(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(LuckyReinforcedBow(-1), 1200, hashMapOf(
            Stick.tier(3) to 3,
            Vine.tier(3) to 1,
            Feather.tier(3) to 1), true) {
            LuckyReinforcedBow(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(StrongReinforcedBow(-1), 1200, hashMapOf(
            Stick.tier(3) to 3,
            Vine.tier(3) to 1,
            Bone.tier(3) to 1), true) {
            StrongReinforcedBow(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(ToughReinforcedBow(-1), 1200, hashMapOf(
            Stick.tier(3) to 3,
            Vine.tier(3) to 1,
            Pebble.tier(3) to 2), true) {
            ToughReinforcedBow(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(HealthyReinforcedBow(-1), 1200, hashMapOf(
            Stick.tier(3) to 3,
            Vine.tier(3) to 1,
            PlantMatter.tier(3) to 2), true) {
            HealthyReinforcedBow(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(HealingReinforcedBow(-1), 1200, hashMapOf(
            Stick.tier(3) to 3,
            Vine.tier(3) to 1,
            Wheat.tier(3) to 2), true) {
            HealingReinforcedBow(Utils.randRarity()).getUpdatedItem(false)
        },

        //STONE AXES
        ShopItem(net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.StoneAxe(-1), 1000, hashMapOf(
            Pebble.tier(3) to 3,
            Stick.tier(3) to 2), true) {
            net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.StoneAxe(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(LuckyStoneAxe(-1), 1200, hashMapOf(
            Pebble.tier(3) to 1,
            Stick.tier(3) to 2,
            Feather.tier(3) to 2), true) {
            LuckyStoneAxe(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(StrongStoneAxe(-1), 1200, hashMapOf(
            Pebble.tier(3) to 1,
            Stick.tier(3) to 2,
            Bone.tier(3) to 2), true) {
            StrongStoneAxe(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(ToughStoneAxe(-1), 1200, hashMapOf(
            Pebble.tier(3) to 5,
            Stick.tier(3) to 2), true) {
            ToughStoneAxe(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(HealthyStoneAxe(-1), 1200, hashMapOf(
            Pebble.tier(3) to 1,
            Stick.tier(3) to 2,
            PlantMatter.tier(3) to 3), true) {
            HealthyStoneAxe(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(HealingStoneAxe(-1), 1200, hashMapOf(
            Pebble.tier(3) to 1,
            Stick.tier(3) to 2,
            Wheat.tier(4) to 1), true) {
            HealingStoneAxe(Utils.randRarity()).getUpdatedItem(false)
        },

        //SLIME SPOOFERS
        ShopItem(SlimeSpoofer(-1), 1300, hashMapOf(), false) {
            SlimeSpoofer(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(LuckySlimeSpoofer(-1), 1400, hashMapOf(), false) {
            LuckySlimeSpoofer(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(StrongSlimeSpoofer(-1), 1400, hashMapOf(), false) {
            StrongSlimeSpoofer(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(ToughSlimeSpoofer(-1), 1400, hashMapOf(), false) {
            ToughSlimeSpoofer(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(HealthySlimeSpoofer(-1), 1400, hashMapOf(), false) {
            HealthySlimeSpoofer(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(HealingSlimySpoofer(-1), 1400, hashMapOf(), false) {
            HealingSlimySpoofer(Utils.randRarity()).getUpdatedItem(false)
        },
    )
}