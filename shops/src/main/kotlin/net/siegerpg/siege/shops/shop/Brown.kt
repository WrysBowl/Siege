package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.armor.boots.*
import net.siegerpg.siege.core.items.implemented.armor.boots.boneBoots.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.boneChestplates.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.boneHelmets.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.boneLeggings.*
import net.siegerpg.siege.core.items.implemented.misc.materials.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.core.miscellaneous.*
import net.siegerpg.siege.shops.*

class Brown : Shop() {
    override var name: String = "Brown"
    override var permission: String = "siege.shops.shop.brown"
    override var items: List<ShopItem> = listOf(
        //Bone HELMET
        ShopItem(BoneHelmet(-1), 1750, hashMapOf(
        Bone.tier(2) to 5), true) {
            BoneHelmet(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(
        LuckyBoneHelmet(-1), -1, hashMapOf(
        Bone.tier(2) to 3,
        Feather.tier(2) to 3), true) {
            LuckyBoneHelmet(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
        StrongBoneHelmet(-1), -1, hashMapOf(
        Bone.tier(2) to 6), true) {
            StrongBoneHelmet(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
        ToughBoneHelmet(-1), -1, hashMapOf(
        Bone.tier(2) to 3,
        Pebble.tier(2) to 3), true) {
            ToughBoneHelmet(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
        HealthyBoneHelmet(-1), -1, hashMapOf(
        Bone.tier(2) to 3,
        PlantMatter.tier(2) to 3), true) {
            HealthyBoneHelmet(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
        HealingBoneHelmet(-1), -1, hashMapOf(
        Bone.tier(2) to 3,
        Wheat.tier(4) to 1), true) {
            HealingBoneHelmet(Utils.randRarity()).getUpdatedItem(false)
        },

        //BONE CHESTPLATE
        ShopItem(BoneChestplate(-1), -1, hashMapOf(
        Bone.tier(2) to 8), true) {
            BoneChestplate(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(
        LuckyBoneChestplate(-1), -1, hashMapOf(
        Bone.tier(2) to 6,
        Feather.tier(2) to 4), true) {
            LuckyBoneChestplate(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
        StrongBoneChestplate(-1), -1, hashMapOf(
        Bone.tier(3) to 2), true) {
            StrongBoneChestplate(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
        ToughBoneChestplate(-1), -1, hashMapOf(
        Bone.tier(2) to 5,
        Pebble.tier(2) to 5), true) {
            ToughBoneChestplate(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
        HealthyBoneChestplate(-1), -1, hashMapOf(
        Bone.tier(2) to 6,
        PlantMatter.tier(2) to 4), true) {
            HealthyBoneChestplate(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
        HealingBoneChestplate(-1), -1, hashMapOf(
        Bone.tier(2) to 3,
        Wheat.tier(4) to 1), true) {
            HealingBoneChestplate(Utils.randRarity()).getUpdatedItem(false)
        },

        //BONE LEGGINGS
        ShopItem(BoneLeggings(-1), 2750, hashMapOf(
        Bone.tier(2) to 7), true) {
            BoneLeggings(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(
        LuckyBoneLeggings(-1), -1, hashMapOf(
        Bone.tier(2) to 5,
        Feather.tier(2) to 4), true) {
            LuckyBoneLeggings(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
        StrongBoneLeggings(-1), -1, hashMapOf(
        Bone.tier(2) to 8), true) {
            StrongBoneLeggings(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
        ToughBoneLeggings(-1), -1, hashMapOf(
        Bone.tier(2) to 6,
        Pebble.tier(2) to 5), true) {
            ToughBoneLeggings(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
        HealthyBoneLeggings(-1), -1, hashMapOf(
        Bone.tier(2) to 6,
        PlantMatter.tier(2) to 4), true) {
            HealthyBoneLeggings(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
        HealingBoneLeggings(-1), -1, hashMapOf(
        Bone.tier(2) to 6,
        Wheat.tier(4) to 1), true) {
            HealingBoneLeggings(Utils.randRarity()).getUpdatedItem(false)
        },

        //BONE BOOTS
        ShopItem(BoneBoots(-1), 1500, hashMapOf(
        Bone.tier(2) to 4), true) {
            BoneBoots(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(
        LuckyBoneBoots(-1), -1, hashMapOf(
        Bone.tier(2) to 3,
        Feather.tier(2) to 2), true) {
            LuckyBoneBoots(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
        StrongBoneBoots(-1), -1, hashMapOf(
        Bone.tier(2) to 6), true) {
            StrongBoneBoots(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
        ToughBoneBoots(-1), -1, hashMapOf(
        Bone.tier(2) to 3,
        Pebble.tier(2) to 3), true) {
            ToughBoneBoots(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
        HealthyBoneBoots(-1), -1, hashMapOf(
        Bone.tier(2) to 3,
        PlantMatter.tier(2) to 4), true) {
            HealthyBoneBoots(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
        HealingBoneBoots(-1), -1, hashMapOf(
        Bone.tier(2) to 3,
        Wheat.tier(4) to 1), true) {
            HealingBoneBoots(Utils.randRarity()).getUpdatedItem(false)
        },
    )
}