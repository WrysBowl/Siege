package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.core.items.implemented.weapons.wands.GlowingTwig
import net.siegerpg.siege.core.items.implemented.weapons.wands.glowingTwigs.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.FemurBone
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.femurBones.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Spade
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.spades.*
import net.siegerpg.siege.core.items.implemented.weapons.ranged.PebbleShooter
import net.siegerpg.siege.core.items.implemented.weapons.ranged.pebbleShooters.*
import net.siegerpg.siege.core.utils.*
import net.siegerpg.siege.shops.*

class Bailey : Shop() {
    override var name: String = "bailey"
    override var permission: String = "siege.shops.shop.bailey"
    override var items: List<ShopItem> = listOf(
        ShopItem(Spade(-1), 400, hashMapOf(
                Pebble.tier(2) to 1,
                Stick.tier(3) to 1), true) {
            Spade(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(LuckySpade(-1), 500, hashMapOf(
                Pebble.tier(2) to 1,
                Stick.tier(2) to 4,
                Feather.tier(2) to 1), true) {
            LuckySpade(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(StrongSpade(-1), 500, hashMapOf(
                Pebble.tier(2) to 1,
                Stick.tier(2) to 4,
                Bone.tier(1) to 4), true) {
            StrongSpade(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(ToughSpade(-1), 500, hashMapOf(
                Pebble.tier(2) to 4,
                Stick.tier(2) to 4), true) {
            ToughSpade(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(HealthySpade(-1), 500, hashMapOf(
                Pebble.tier(2) to 1,
                Stick.tier(2) to 4,
                PlantMatter.tier(2) to 1), true) {
            HealthySpade(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(HealingSpade(-1), 500, hashMapOf(
                Pebble.tier(2) to 1,
                Stick.tier(2) to 4,
                Wheat.tier(2) to 2), true) {
            HealingSpade(Utils.randRarity()).getUpdatedItem(false)
        },

        //PEBBLE SHOOTERS
        ShopItem(PebbleShooter(-1), 750, hashMapOf(
                Pebble.tier(2) to 1,
                Stick.tier(2) to 2,
                Vine.tier(2) to 3), true) {
            PebbleShooter(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(LuckyPebbleShooter(-1), 900, hashMapOf(
                Pebble.tier(2) to 1,
                Stick.tier(2) to 2,
                Vine.tier(2) to 1,
                Feather.tier(2) to 2), true) {
            LuckyPebbleShooter(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(StrongPebbleShooter(-1), 900, hashMapOf(
                Pebble.tier(2) to 1,
                Stick.tier(2) to 2,
                Vine.tier(2) to 3,
                Bone.tier(2) to 1), true) {
            StrongPebbleShooter(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(ToughPebbleShooter(-1), 900, hashMapOf(
                Pebble.tier(2) to 2,
                Stick.tier(2) to 2,
                Vine.tier(2) to 1), true) {
            ToughPebbleShooter(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(HealthyPebbleShooter(-1), 900, hashMapOf(
                Pebble.tier(2) to 1,
                Stick.tier(2) to 2,
                Vine.tier(2) to 1,
                PlantMatter.tier(2) to 2), true) {
            HealthyPebbleShooter(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(HealingPebbleShooter(-1), 900, hashMapOf(
                Pebble.tier(2) to 1,
                Stick.tier(2) to 2,
                Vine.tier(2) to 1,
                Wheat.tier(2) to 4), true) {
            HealingPebbleShooter(Utils.randRarity()).getUpdatedItem(false)
        },

        //FEMUR BONES
        ShopItem(FemurBone(-1), 1000, hashMapOf(
                Bone.tier(3) to 2), true) {
            FemurBone(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(LuckyFemurBone(-1), 1250, hashMapOf(
                Bone.tier(3) to 1,
                Feather.tier(3) to 1), true) {
            LuckyFemurBone(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(StrongFemurBone(-1), 1250, hashMapOf(
                Bone.tier(4) to 1), true) {
            StrongFemurBone(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(ToughFemurBone(-1), 1250, hashMapOf(
                Bone.tier(3) to 1,
                Pebble.tier(3) to 1), true) {
            ToughFemurBone(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(HealthyFemurBone(-1), 1250, hashMapOf(
                Bone.tier(3) to 1,
                PlantMatter.tier(3) to 1), true) {
            HealthyFemurBone(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(HealingFemurBone(-1), 1250, hashMapOf(
                Bone.tier(3) to 1,
                Wheat.tier(4) to 1), true) {
            HealingFemurBone(Utils.randRarity()).getUpdatedItem(false)
        },

        //GLOWING TWIG
        ShopItem(GlowingTwig(-1), 1500, hashMapOf(
                PlantMatter.tier(3) to 3), true) {
            GlowingTwig(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(LuckyGlowingTwig(-1), 1750, hashMapOf(
                PlantMatter.tier(3) to 2,
                Feather.tier(3) to 1), true) {
            LuckyGlowingTwig(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(StrongGlowingTwig(-1), 1750, hashMapOf(
                PlantMatter.tier(3) to 2,
                Bone.tier(2) to 4), true) {
            StrongGlowingTwig(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(ToughGlowingTwig(-1), 1750, hashMapOf(
                PlantMatter.tier(3) to 2,
                Pebble.tier(3) to 1), true) {
            ToughGlowingTwig(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(HealthyGlowingTwig(-1), 1750, hashMapOf(
                PlantMatter.tier(3) to 4), true) {
            HealthyGlowingTwig(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(HealingGlowingTwig(-1), 1750, hashMapOf(
                PlantMatter.tier(3) to 2,
                Wheat.tier(3) to 2), true) {
            HealingGlowingTwig(Utils.randRarity()).getUpdatedItem(false)
        },
    )
}