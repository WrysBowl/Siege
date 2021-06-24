package net.siegerpg.siege.shops

import co.aikar.commands.PaperCommandManager
import net.siegerpg.siege.core.items.implemented.armor.boots.*
import net.siegerpg.siege.core.items.implemented.armor.boots.slimyBoots.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.slimyChestplates.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.slimyHelmets.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.slimyLeggings.*
import net.siegerpg.siege.core.items.implemented.misc.food.*
import net.siegerpg.siege.core.items.implemented.misc.materials.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.core.items.implemented.misc.wands.*
import net.siegerpg.siege.core.items.implemented.misc.wands.glisteningTwigs.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.giantClubs.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.stickySticks.*
import net.siegerpg.siege.core.items.implemented.weapons.ranged.*
import net.siegerpg.siege.core.items.implemented.weapons.ranged.woodenBows.*
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Bukkit
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin


class ShopsPlugin: JavaPlugin(), Listener {
    // while this is singleton, a class must be initialized by Bukkit, so we can't use 'object'
    // Please make it possible to fill a slot with a blank item
    companion object {
        var instance: ShopsPlugin? = null
            private set;
    }

    val shopRegistry: HashMap<String, Shop> = hashMapOf()

    override fun onEnable() {
        instance = this;
        val manager = PaperCommandManager(this)
        manager.registerCommand(ShopsCommand())


        server.pluginManager.registerEvents(this, this)

        shopRegistry["0"] = Shop("Test Shop", "siege.shops.shop.0", listOf(
            ShopItem(WoodenSword(50), 10, hashMapOf(Twig(50) to 2), false) {
                WoodenSword(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(WoodenSword(50), -1, hashMapOf(Twig(50) to 1), true) {
                WoodenSword(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(WoodenSword(50), 200, hashMapOf(Twig(50) to 2), true) {
                WoodenSword(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(WoodenSword(50), 0, hashMapOf(Twig(50) to 2), true) {
                WoodenSword(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(WoodenSword(50), 0, hashMapOf(Twig(50) to 2), true) {
                WoodenSword(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(WoodenSword(50), 0, hashMapOf(Pebble.tier(1) to 2), true) {
                WoodenSword(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(WoodenSword(50), 0, hashMapOf(Twig(50) to 2), true) {
                WoodenSword(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(WoodenSword(50), 0, hashMapOf(Twig(50) to 2), true) {
                WoodenSword(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(WoodenSword(50), 0, hashMapOf(Twig(50) to 2), true) {
                WoodenSword(Utils.randRarity()).getUpdatedItem(false)
            }
        ))
        shopRegistry["chip"] = Shop("Chip", "siege.shops.shop.chip", listOf(
            //LIGHT MELEE
            ShopItem(Twig(-1), 100, hashMapOf(Stick.tier(1) to 2), true) {
                Twig(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(StickyStick(-1), 150, hashMapOf(
                Slime.tier(2) to 2,
                Stick.tier(2) to 2), true) {
                StickyStick(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(LuckyStickyStick(-1), 200, hashMapOf(
                Slime.tier(2) to 1,
                Stick.tier(2) to 2,
                Feather.tier(1) to 4), true) {
                LuckyStickyStick(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(StrongStickyStick(-1), 200, hashMapOf(
                Slime.tier(2) to 1,
                Stick.tier(2) to 2,
                Bone.tier(1) to 1), true) {
                StrongStickyStick(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(ToughStickyStick(-1), 200, hashMapOf(
                Slime.tier(2) to 1,
                Stick.tier(2) to 2,
                Pebble.tier(1) to 6), true) {
                ToughStickyStick(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealthyStickyStick(-1), 200, hashMapOf(
                Slime.tier(2) to 1,
                Stick.tier(2) to 2,
                PlantMatter.tier(2) to 1), true) {
                HealthyStickyStick(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealingStickyStick(-1), 200, hashMapOf(
                Slime.tier(2) to 1,
                Stick.tier(2) to 2,
                Wheat.tier(2) to 2), true) {
                HealingStickyStick(Utils.randRarity()).getUpdatedItem(false)
            },

            //RANGED
            ShopItem(ScrapyardBow(-1), 100, hashMapOf(
                Stick.tier(2) to 3,
                Vine.tier(2) to 3), true) {
                ScrapyardBow(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(WoodenBow(-1), 250, hashMapOf(
                Stick.tier(3) to 3,
                Vine.tier(3) to 3), true) {
                WoodenBow(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(LuckyWoodenBow(-1), 300, hashMapOf(
                Stick.tier(3) to 3,
                Vine.tier(3) to 1,
                Feather.tier(3) to 1), true) {
                LuckyWoodenBow(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(StrongWoodenBow(-1), 300, hashMapOf(
                Stick.tier(3) to 3,
                Vine.tier(3) to 1,
                Bone.tier(2) to 6), true) {
                StrongWoodenBow(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(ToughWoodenBow(-1), 300, hashMapOf(
                Stick.tier(3) to 3,
                Vine.tier(3) to 1,
                Pebble.tier(3) to 1), true) {
                ToughWoodenBow(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealthyWoodenBow(-1), 300, hashMapOf(
                Stick.tier(3) to 3,
                Vine.tier(3) to 1,
                PlantMatter.tier(3) to 1), true) {
                HealthyWoodenBow(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealingWoodenBow(-1), 300, hashMapOf(
                Stick.tier(3) to 3,
                Vine.tier(3) to 1,
                Wheat.tier(3) to 1), true) {
                HealingWoodenBow(Utils.randRarity()).getUpdatedItem(false)
            },

            //HEAVY MELEE
            ShopItem(Club(-1), 200, hashMapOf(
                Stick.tier(2) to 2), true) {
                Club(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(GiantClub(-1), 300, hashMapOf(), false) {
                GiantClub(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(LuckyGiantClub(-1), 400, hashMapOf(), false) {
                LuckyGiantClub(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(StrongGiantClub(-1), 400, hashMapOf(), false) {
                StrongGiantClub(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(ToughGiantClub(-1), 400, hashMapOf(), false) {
                ToughGiantClub(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealthyGiantCLub(-1), 400, hashMapOf(), false) {
                HealthyGiantCLub(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealingGiantClub(-1), 400, hashMapOf(), false) {
                HealingGiantClub(Utils.randRarity()).getUpdatedItem(false)
            },

            //WANDS
            ShopItem(LivingTwig(-1), 300, hashMapOf(), false) {
                LivingTwig(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(GlisteningTwig(-1), 500, hashMapOf(
                Seed.tier(2) to 1,
                Stick.tier(2) to 1,
                Feather.tier(2) to 2), true) {
                GlisteningTwig(Utils.randRarity()).getUpdatedItem(false)
            },

            ShopItem(LuckyGlisteningTwig(-1), 600, hashMapOf(
                Seed.tier(2) to 1,
                Stick.tier(2) to 1,
                Feather.tier(2) to 2), true) {
                LuckyGlisteningTwig(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(StrongGlisteningTwig(-1), 600, hashMapOf(
                Seed.tier(2) to 1,
                Stick.tier(2) to 1,
                Bone.tier(2) to 1), true) {
                StrongGlisteningTwig(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(ToughGlisteningTwig(-1), 600, hashMapOf(
                Seed.tier(2) to 1,
                Stick.tier(2) to 1,
                Pebble.tier(2) to 2), true) {
                ToughGlisteningTwig(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealthyGlisteningTwig(-1), 600, hashMapOf(
                Seed.tier(2) to 1,
                Stick.tier(2) to 1,
                PlantMatter.tier(2) to 3), true) {
                HealthyGlisteningTwig(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealingGlisteningTwig(-1), 600, hashMapOf(
                Seed.tier(2) to 1,
                Stick.tier(2) to 1,
                Wheat.tier(2) to 2), true) {
                HealingGlisteningTwig(Utils.randRarity()).getUpdatedItem(false)
            },
        ))
        shopRegistry["chop"] = Shop("Chop", "siege.shops.shop.chop", listOf(
            //SLIMY HELMETS
            ShopItem(SlimyHelmet(-1), 250, hashMapOf(
                Slime.tier(2) to 5), true) {
                SlimyHelmet(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(LuckySlimyHelmet(-1), 300, hashMapOf(
                Slime.tier(2) to 3,
                Feather.tier(2) to 2), true) {
                LuckySlimyHelmet(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(StrongSlimyHelmet(-1), 300, hashMapOf(
                Slime.tier(2) to 3,
                Bone.tier(2) to 1), true) {
                StrongSlimyHelmet(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(ToughSlimyHelmet(-1), 300, hashMapOf(
                Slime.tier(2) to 3,
                Pebble.tier(2) to 2), true) {
                ToughSlimyHelmet(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealthySlimyHelmet(-1), 300, hashMapOf(
                Slime.tier(2) to 3,
                PlantMatter.tier(2) to 2), true) {
                HealthySlimyHelmet(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealingSlimyHelmet(-1), 300, hashMapOf(
                Slime.tier(2) to 3,
                Wheat.tier(2) to 3), true) {
                HealingSlimyHelmet(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(GRAYFILLER(-1) to 1), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },

            //SLIMY CHESTPLATES
            ShopItem(SlimyChestplate(-1), 450, hashMapOf(
                Slime.tier(2) to 8), true) {
                SlimyChestplate(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(LuckySlimyChestplate(-1), 600, hashMapOf(
                Slime.tier(2) to 5,
                Feather.tier(2) to 3), true) {
                LuckySlimyChestplate(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(StrongSlimyChestplate(-1), 600, hashMapOf(
                Slime.tier(2) to 5,
                Bone.tier(2) to 2), true) {
                StrongSlimyChestplate(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(ToughSlimyChestplate(-1), 600, hashMapOf(
                Slime.tier(2) to 5,
                Pebble.tier(3) to 1), true) {
                ToughSlimyChestplate(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealthySlimyChestplate(-1), 600, hashMapOf(
                Slime.tier(2) to 5,
                PlantMatter.tier(3) to 1), true) {
                HealthySlimyChestplate(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealingSlimyChestplate(-1), 600, hashMapOf(
                Slime.tier(2) to 5,
                Wheat.tier(3) to 1), true) {
                HealingSlimyChestplate(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(GRAYFILLER(-1) to 1), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },

            //SLIMY LEGGINGS
            ShopItem(SlimyLeggings(-1), 350, hashMapOf(
                Slime.tier(2) to 7), true) {
                SlimyLeggings(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(LuckySlimyLeggings(-1), 500, hashMapOf(
                Slime.tier(2) to 3,
                Feather.tier(2) to 3), true) {
                LuckySlimyLeggings(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(StrongSlimyLeggings(-1), 500, hashMapOf(
                Slime.tier(2) to 3,
                Bone.tier(2) to 4), true) {
                StrongSlimyLeggings(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(ToughSlimyLeggings(-1), 500, hashMapOf(
                Slime.tier(2) to 4,
                Pebble.tier(2) to 4), true) {
                ToughSlimyLeggings(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealthySlimyLeggings(-1), 500, hashMapOf(
                Slime.tier(2) to 4,
                PlantMatter.tier(2) to 3), true) {
                HealthySlimyLeggings(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealingSlimyLeggings(-1), 500, hashMapOf(
                Slime.tier(2) to 3,
                Wheat.tier(2) to 4), true) {
                HealingSlimyLeggings(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(GRAYFILLER(-1) to 1), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },

            //SLIMY BOOTS
            ShopItem(SlimyBoots(-1), 200, hashMapOf(
                Slime.tier(2) to 4), true) {
                SlimyBoots(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(LuckySlimyBoots(-1), 300, hashMapOf(
                Slime.tier(2) to 3,
                Feather.tier(2) to 2), true) {
                LuckySlimyBoots(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(StrongSlimyBoots(-1), 300, hashMapOf(
                Slime.tier(2) to 2,
                Bone.tier(2) to 3), true) {
                StrongSlimyBoots(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(ToughSlimyBoots(-1), 300, hashMapOf(
                Slime.tier(2) to 2,
                Pebble.tier(2) to 3), true) {
                ToughSlimyBoots(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealthySlimyBoots(-1), 300, hashMapOf(
                Slime.tier(2) to 2,
                PlantMatter.tier(2) to 3), true) {
                HealthySlimyBoots(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealingSlimyBoots(-1), 300, hashMapOf(
                Slime.tier(2) to 2,
                Wheat.tier(2) to 6), true) {
                HealingSlimyBoots(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(GRAYFILLER(-1) to 1), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
        ))
        shopRegistry["sylvester"] = Shop("Sylvester", "siege.shops.shop.sylvester", listOf(
            //TIER 2
            ShopItem(Slime.tier(2), -1, hashMapOf(
                Slime.tier(1) to 8), true) {
                Slime.tier(2).getUpdatedItem(false)
            },
            ShopItem(Feather.tier(2), -1, hashMapOf(
                Feather.tier(1) to 8), true) {
                Feather.tier(2).getUpdatedItem(false)
            },
            ShopItem(Magma.tier(2), -1, hashMapOf(
                Magma.tier(1) to 8), true) {
                Magma.tier(2).getUpdatedItem(false)
            },
            ShopItem(PlantMatter.tier(2), -1, hashMapOf(
                PlantMatter.tier(1) to 8), true) {
                PlantMatter.tier(2).getUpdatedItem(false)
            },
            ShopItem(Seed.tier(2), -1, hashMapOf(
                Seed.tier(1) to 8), true) {
                Seed.tier(2).getUpdatedItem(false)
            },
            ShopItem(Stick.tier(2), -1, hashMapOf(
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
            ShopItem(Magma.tier(3), -1, hashMapOf(
                Magma.tier(2) to 8), true) {
                Magma.tier(3).getUpdatedItem(false)
            },
            ShopItem(PlantMatter.tier(3), -1, hashMapOf(
                PlantMatter.tier(2) to 8), true) {
                PlantMatter.tier(3).getUpdatedItem(false)
            },
            ShopItem(Seed.tier(3), -1, hashMapOf(
                Seed.tier(2) to 8), true) {
                Seed.tier(3).getUpdatedItem(false)
            },
            ShopItem(Stick.tier(3), -1, hashMapOf(
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
            ShopItem(Magma.tier(4), -1, hashMapOf(
                Magma.tier(3) to 8), true) {
                Magma.tier(4).getUpdatedItem(false)
            },
            ShopItem(PlantMatter.tier(4), -1, hashMapOf(
                PlantMatter.tier(3) to 8), true) {
                PlantMatter.tier(4).getUpdatedItem(false)
            },
            ShopItem(Seed.tier(4), -1, hashMapOf(
                Seed.tier(3) to 8), true) {
                Seed.tier(4).getUpdatedItem(false)
            },
            ShopItem(Stick.tier(4), -1, hashMapOf(
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
            ShopItem(Magma.tier(5), -1, hashMapOf(
                Magma.tier(4) to 8), true) {
                Magma.tier(5).getUpdatedItem(false)
            },
            ShopItem(PlantMatter.tier(5), -1, hashMapOf(
                PlantMatter.tier(4) to 8), true) {
                PlantMatter.tier(5).getUpdatedItem(false)
            },
            ShopItem(Seed.tier(5), -1, hashMapOf(
                Seed.tier(4) to 8), true) {
                Seed.tier(5).getUpdatedItem(false)
            },
            ShopItem(Stick.tier(5), -1, hashMapOf(
                Stick.tier(4) to 8), true) {
                Stick.tier(5).getUpdatedItem(false)
            },
            ShopItem(Pebble.tier(5), -1, hashMapOf(
                Pebble.tier(4) to 8), true) {
                Pebble.tier(5).getUpdatedItem(false)
            },
        ))
        shopRegistry["phillip"] = Shop("Phillip", "siege.shops.shop.phillip", listOf(
            //TIER 2
            ShopItem(Vine.tier(2), -1, hashMapOf(
                Vine.tier(1) to 8), true) {
                Vine.tier(2).getUpdatedItem(false)
            },
            ShopItem(Bone.tier(2), -1, hashMapOf(
                Bone.tier(1) to 8), true) {
                Bone.tier(2).getUpdatedItem(false)
            },
            ShopItem(Wool.tier(2), -1, hashMapOf(
                Wool.tier(1) to 8), true) {
                Wool.tier(2).getUpdatedItem(false)
            },
            ShopItem(Leather.tier(2), -1, hashMapOf(
                Leather.tier(1) to 8), true) {
                Leather.tier(2).getUpdatedItem(false)
            },
            ShopItem(Wheat.tier(2), -1, hashMapOf(
                Wheat.tier(1) to 8), true) {
                Wheat.tier(2).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                Wheat.tier(2).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(GRAYFILLER(-1) to 1), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },

            //TIER 3
            ShopItem(Vine.tier(3), -1, hashMapOf(
                Vine.tier(2) to 8), true) {
                Vine.tier(3).getUpdatedItem(false)
            },
            ShopItem(Bone.tier(3), -1, hashMapOf(
                Bone.tier(2) to 8), true) {
                Bone.tier(3).getUpdatedItem(false)
            },
            ShopItem(Wool.tier(3), -1, hashMapOf(
                Wool.tier(2) to 8), true) {
                Wool.tier(3).getUpdatedItem(false)
            },
            ShopItem(Leather.tier(3), -1, hashMapOf(
                Leather.tier(2) to 8), true) {
                Leather.tier(3).getUpdatedItem(false)
            },
            ShopItem(Wheat.tier(3), -1, hashMapOf(
                Wheat.tier(2) to 8), true) {
                Wheat.tier(3).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(GRAYFILLER(-1) to 1), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(GRAYFILLER(-1) to 1), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },

            //TIER 4
            ShopItem(Vine.tier(4), -1, hashMapOf(
                Vine.tier(3) to 8), true) {
                Vine.tier(4).getUpdatedItem(false)
            },
            ShopItem(Bone.tier(4), -1, hashMapOf(
                Bone.tier(3) to 8), true) {
                Bone.tier(4).getUpdatedItem(false)
            },
            ShopItem(Wool.tier(4), -1, hashMapOf(
                Wool.tier(3) to 8), true) {
                Wool.tier(4).getUpdatedItem(false)
            },
            ShopItem(Leather.tier(4), -1, hashMapOf(
                Leather.tier(3) to 8), true) {
                Leather.tier(4).getUpdatedItem(false)
            },
            ShopItem(Wheat.tier(4), -1, hashMapOf(
                Wheat.tier(3) to 8), true) {
                Wheat.tier(4).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(GRAYFILLER(-1) to 1), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(GRAYFILLER(-1) to 1), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },

            //TIER 5
            ShopItem(Vine.tier(5), -1, hashMapOf(
                Vine.tier(4) to 8), true) {
                Vine.tier(5).getUpdatedItem(false)
            },
            ShopItem(Bone.tier(5), -1, hashMapOf(
                Bone.tier(4) to 8), true) {
                Bone.tier(5).getUpdatedItem(false)
            },
            ShopItem(Wool.tier(5), -1, hashMapOf(
                Wool.tier(4) to 8), true) {
                Wool.tier(5).getUpdatedItem(false)
            },
            ShopItem(Leather.tier(5), -1, hashMapOf(
                Leather.tier(4) to 8), true) {
                Leather.tier(5).getUpdatedItem(false)
            },
            ShopItem(Wheat.tier(5), -1, hashMapOf(
                Wheat.tier(4) to 8), true) {
                Wheat.tier(5).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(GRAYFILLER(-1) to 1), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(GRAYFILLER(-1) to 1), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
        ))
        shopRegistry["minnow"] = Shop("Minnow", "siege.shops.shop.minnow", listOf(
            //TIER 2
            ShopItem(Chain.tier(2), -1, hashMapOf(
                Chain.tier(1) to 8), true) {
                Chain.tier(2).getUpdatedItem(false)
            },
            ShopItem(Coal.tier(2), -1, hashMapOf(
                Coal.tier(1) to 8), true) {
                Coal.tier(2).getUpdatedItem(false)
            },
            ShopItem(MetalScrap.tier(2), -1, hashMapOf(
                MetalScrap.tier(1) to 8), true) {
                MetalScrap.tier(2).getUpdatedItem(false)
            },
            ShopItem(RefinedMetal.tier(2), -1, hashMapOf(
                RefinedMetal.tier(1) to 8), true) {
                RefinedMetal.tier(2).getUpdatedItem(false)
            },
            ShopItem(Titanium.tier(2), -1, hashMapOf(
                Titanium.tier(1) to 8), true) {
                Titanium.tier(2).getUpdatedItem(false)
            },
            ShopItem(RefinedMetal.tier(1), -1, hashMapOf(
                MetalScrap.tier(1) to 8), true) {
                RefinedMetal.tier(1).getUpdatedItem(false)
            },
            ShopItem(Titanium.tier(1), -1, hashMapOf(
                RefinedMetal.tier(1) to 8), true) {
                Titanium.tier(1).getUpdatedItem(false)
            },

            //TIER 3
            ShopItem(Chain.tier(3), -1, hashMapOf(
                Chain.tier(2) to 8), true) {
                Chain.tier(3).getUpdatedItem(false)
            },
            ShopItem(Coal.tier(3), -1, hashMapOf(
                Coal.tier(2) to 8), true) {
                Coal.tier(3).getUpdatedItem(false)
            },
            ShopItem(MetalScrap.tier(3), -1, hashMapOf(
                MetalScrap.tier(2) to 8), true) {
                MetalScrap.tier(3).getUpdatedItem(false)
            },
            ShopItem(RefinedMetal.tier(3), -1, hashMapOf(
                RefinedMetal.tier(2) to 8), true) {
                RefinedMetal.tier(3).getUpdatedItem(false)
            },
            ShopItem(Titanium.tier(3), -1, hashMapOf(
                Titanium.tier(2) to 8), true) {
                Titanium.tier(3).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(GRAYFILLER(-1) to 1), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(GRAYFILLER(-1) to 1), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },

            //TIER 4
            ShopItem(Chain.tier(4), -1, hashMapOf(
                Chain.tier(3) to 8), true) {
                Chain.tier(4).getUpdatedItem(false)
            },
            ShopItem(Coal.tier(4), -1, hashMapOf(
                Coal.tier(3) to 8), true) {
                Coal.tier(4).getUpdatedItem(false)
            },
            ShopItem(MetalScrap.tier(4), -1, hashMapOf(
                MetalScrap.tier(3) to 8), true) {
                MetalScrap.tier(4).getUpdatedItem(false)
            },
            ShopItem(RefinedMetal.tier(4), -1, hashMapOf(
                RefinedMetal.tier(3) to 8), true) {
                RefinedMetal.tier(4).getUpdatedItem(false)
            },
            ShopItem(Titanium.tier(4), -1, hashMapOf(
                Titanium.tier(3) to 8), true) {
                Titanium.tier(4).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(GRAYFILLER(-1) to 1), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(GRAYFILLER(-1) to 1), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },

            //TIER 5
            ShopItem(Chain.tier(5), -1, hashMapOf(
                Chain.tier(4) to 8), true) {
                Chain.tier(5).getUpdatedItem(false)
            },
            ShopItem(Coal.tier(5), -1, hashMapOf(
                Coal.tier(4) to 8), true) {
                Coal.tier(5).getUpdatedItem(false)
            },
            ShopItem(MetalScrap.tier(5), -1, hashMapOf(
                MetalScrap.tier(4) to 8), true) {
                MetalScrap.tier(5).getUpdatedItem(false)
            },
            ShopItem(RefinedMetal.tier(5), -1, hashMapOf(
                RefinedMetal.tier(4) to 8), true) {
                RefinedMetal.tier(5).getUpdatedItem(false)
            },
            ShopItem(Titanium.tier(5), -1, hashMapOf(
                Titanium.tier(4) to 8), true) {
                Titanium.tier(5).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(GRAYFILLER(-1) to 1), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(GRAYFILLER(-1) to 1), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
        ))
        shopRegistry["chelsea"] = Shop("Chelsea", "siege.shops.shop.chelsea", listOf(
            //Quality 0
            ShopItem(Drumstick(0), 25, hashMapOf(), false) {
                Drumstick(0).getUpdatedItem(false)
            },
            ShopItem(Apple(0), 20, hashMapOf(), false) {
                Apple(0).getUpdatedItem(false)
            },
            ShopItem(Bread(0), 25, hashMapOf(), false) {
                Bread(0).getUpdatedItem(false)
            },
            ShopItem(Bread(0), -1, hashMapOf(Wheat.tier(1) to 6), true) {
                Bread(0).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(GRAYFILLER(-1) to 1), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(GRAYFILLER(-1) to 1), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(GRAYFILLER(-1) to 1), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },

            //Quality 50
            ShopItem(Drumstick(50), 60, hashMapOf(), false) {
                Drumstick(50).getUpdatedItem(false)
            },
            ShopItem(Apple(50), 45, hashMapOf(), false) {
                Apple(50).getUpdatedItem(false)
            },
            ShopItem(Bread(50), 75, hashMapOf(), false) {
                Bread(50).getUpdatedItem(false)
            },
            ShopItem(Bread(50), -1, hashMapOf(Wheat.tier(2) to 2), true) {
                Bread(50).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(GRAYFILLER(-1) to 1), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(GRAYFILLER(-1) to 1), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(GRAYFILLER(-1) to 1), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },

            //Quality 1000
            ShopItem(Drumstick(100), 110, hashMapOf(), false) {
                Drumstick(100).getUpdatedItem(false)
            },
            ShopItem(Apple(100), 75, hashMapOf(), false) {
                Apple(100).getUpdatedItem(false)
            },
            ShopItem(Bread(100), 125, hashMapOf(), false) {
                Bread(100).getUpdatedItem(false)
            },
            ShopItem(Bread(100), -1, hashMapOf(Wheat.tier(2) to 3), true) {
                Bread(100).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(GRAYFILLER(-1) to 1), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(GRAYFILLER(-1) to 1), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(GRAYFILLER(-1) to 1), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            }
        ))

        Bukkit.getLogger().info("Enabled!")
    }
}