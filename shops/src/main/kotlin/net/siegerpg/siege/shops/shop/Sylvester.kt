package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.armor.boots.*
import net.siegerpg.siege.core.items.implemented.armor.boots.slimyBoots.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.slimyChestplates.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.slimyHelmets.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.slimyLeggings.*
import net.siegerpg.siege.core.items.implemented.misc.materials.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.core.utils.*
import net.siegerpg.siege.shops.*

class Sylvester : Shop("Sylvester", "siege.shops.shop.sylvester", listOf(
    ShopItem(Slime.tier(2), -1, hashMapOf(
        Slime.tier(1) to 8), true) {
        Slime.tier(2).getUpdatedItem(false)
    },
    ShopItem(Feather.tier(2), -1, hashMapOf(
        Feather.tier(1) to 8), true) {
        Feather.tier(2).getUpdatedItem(false)
    },
    ShopItem(
        Magma.tier(2), -1, hashMapOf(
        Magma.tier(1) to 8), true) {
        Magma.tier(2).getUpdatedItem(false)
    },
    ShopItem(PlantMatter.tier(2), -1, hashMapOf(
        PlantMatter.tier(1) to 8), true) {
        PlantMatter.tier(2).getUpdatedItem(false)
    },
    ShopItem(
        Seed.tier(2), -1, hashMapOf(
        Seed.tier(1) to 8), true) {
        Seed.tier(2).getUpdatedItem(false)
    },
    ShopItem(
        Stick.tier(2), -1, hashMapOf(
        Stick.tier(1) to 8), true) {
        Stick.tier(2).getUpdatedItem(false)
    },
    ShopItem(Pebble.tier(2), -1, hashMapOf(
        Pebble.tier(1) to 8), true) {
        Pebble.tier(2).getUpdatedItem(false)
    },

    //TIER 3
    ShopItem(Slime.tier(3), -1, hashMapOf(
        Slime.tier(2) to 8), true) {
        Slime.tier(3).getUpdatedItem(false)
    },
    ShopItem(Feather.tier(3), -1, hashMapOf(
        Feather.tier(2) to 8), true) {
        Feather.tier(3).getUpdatedItem(false)
    },
    ShopItem(
        Magma.tier(3), -1, hashMapOf(
        Magma.tier(2) to 8), true) {
        Magma.tier(3).getUpdatedItem(false)
    },
    ShopItem(PlantMatter.tier(3), -1, hashMapOf(
        PlantMatter.tier(2) to 8), true) {
        PlantMatter.tier(3).getUpdatedItem(false)
    },
    ShopItem(
        Seed.tier(3), -1, hashMapOf(
        Seed.tier(2) to 8), true) {
        Seed.tier(3).getUpdatedItem(false)
    },
    ShopItem(
        Stick.tier(3), -1, hashMapOf(
        Stick.tier(2) to 8), true) {
        Stick.tier(3).getUpdatedItem(false)
    },
    ShopItem(Pebble.tier(3), -1, hashMapOf(
        Pebble.tier(2) to 8), true) {
        Pebble.tier(3).getUpdatedItem(false)
    },

    //TIER 4
    ShopItem(Slime.tier(4), -1, hashMapOf(
        Slime.tier(3) to 8), true) {
        Slime.tier(4).getUpdatedItem(false)
    },
    ShopItem(Feather.tier(4), -1, hashMapOf(
        Feather.tier(3) to 8), true) {
        Feather.tier(4).getUpdatedItem(false)
    },
    ShopItem(
        Magma.tier(4), -1, hashMapOf(
        Magma.tier(3) to 8), true) {
        Magma.tier(4).getUpdatedItem(false)
    },
    ShopItem(PlantMatter.tier(4), -1, hashMapOf(
        PlantMatter.tier(3) to 8), true) {
        PlantMatter.tier(4).getUpdatedItem(false)
    },
    ShopItem(
        Seed.tier(4), -1, hashMapOf(
        Seed.tier(3) to 8), true) {
        Seed.tier(4).getUpdatedItem(false)
    },
    ShopItem(
        Stick.tier(4), -1, hashMapOf(
        Stick.tier(3) to 8), true) {
        Stick.tier(4).getUpdatedItem(false)
    },
    ShopItem(Pebble.tier(4), -1, hashMapOf(
        Pebble.tier(3) to 8), true) {
        Pebble.tier(4).getUpdatedItem(false)
    },

    //TIER 5
    ShopItem(Slime.tier(5), -1, hashMapOf(
        Slime.tier(4) to 8), true) {
        Slime.tier(5).getUpdatedItem(false)
    },
    ShopItem(Feather.tier(5), -1, hashMapOf(
        Feather.tier(4) to 8), true) {
        Feather.tier(5).getUpdatedItem(false)
    },
    ShopItem(
        Magma.tier(5), -1, hashMapOf(
        Magma.tier(4) to 8), true) {
        Magma.tier(5).getUpdatedItem(false)
    },
    ShopItem(PlantMatter.tier(5), -1, hashMapOf(
        PlantMatter.tier(4) to 8), true) {
        PlantMatter.tier(5).getUpdatedItem(false)
    },
    ShopItem(
        Seed.tier(5), -1, hashMapOf(
        Seed.tier(4) to 8), true) {
        Seed.tier(5).getUpdatedItem(false)
    },
    ShopItem(
        Stick.tier(5), -1, hashMapOf(
        Stick.tier(4) to 8), true) {
        Stick.tier(5).getUpdatedItem(false)
    },
    ShopItem(Pebble.tier(5), -1, hashMapOf(
        Pebble.tier(4) to 8), true) {
        Pebble.tier(5).getUpdatedItem(false)
    },
))