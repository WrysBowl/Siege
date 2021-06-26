package net.siegerpg.siege.shops

import co.aikar.commands.PaperCommandManager
import net.siegerpg.siege.core.items.implemented.armor.boots.*
import net.siegerpg.siege.core.items.implemented.armor.boots.slimyBoots.*
import net.siegerpg.siege.core.items.implemented.armor.boots.strawBoots.*
import net.siegerpg.siege.core.items.implemented.armor.boots.woolBoots.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.slimyChestplates.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.strawChestplates.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.woolChestplates.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.slimyHelmets.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.strawHelmets.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.woolHelmets.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.slimyLeggings.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.strawLeggings.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.woolLeggings.*
import net.siegerpg.siege.core.items.implemented.misc.food.*
import net.siegerpg.siege.core.items.implemented.misc.materials.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.core.items.implemented.misc.tools.*
import net.siegerpg.siege.core.items.implemented.misc.tools.IronAxe
import net.siegerpg.siege.core.items.implemented.misc.tools.StoneAxe
import net.siegerpg.siege.core.items.implemented.misc.wands.*
import net.siegerpg.siege.core.items.implemented.misc.wands.glisteningTwigs.*
import net.siegerpg.siege.core.items.implemented.misc.wands.glowingTwigs.*
import net.siegerpg.siege.core.items.implemented.misc.wands.slimeSpoofers.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.femurBones.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.giantClubs.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.stoneAxes.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.daggers.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.scrapShards.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.shanks.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.shovels.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.spades.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.splinteredBones.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.stickySticks.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.woodenSwords.*
import net.siegerpg.siege.core.items.implemented.weapons.ranged.*
import net.siegerpg.siege.core.items.implemented.weapons.ranged.pebbleShooters.*
import net.siegerpg.siege.core.items.implemented.weapons.ranged.reinforcedBows.*
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
            ShopItem(LivingTwig(-1), 200, hashMapOf(), false) {
                LivingTwig(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(GlisteningTwig(-1), 300, hashMapOf(
                Seed.tier(2) to 1,
                Stick.tier(2) to 1,
                Feather.tier(2) to 2), true) {
                GlisteningTwig(Utils.randRarity()).getUpdatedItem(false)
            },

            ShopItem(LuckyGlisteningTwig(-1), 400, hashMapOf(
                Seed.tier(2) to 1,
                Stick.tier(2) to 1,
                Feather.tier(2) to 2), true) {
                LuckyGlisteningTwig(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(StrongGlisteningTwig(-1), 400, hashMapOf(
                Seed.tier(2) to 1,
                Stick.tier(2) to 1,
                Bone.tier(2) to 1), true) {
                StrongGlisteningTwig(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(ToughGlisteningTwig(-1), 400, hashMapOf(
                Seed.tier(2) to 1,
                Stick.tier(2) to 1,
                Pebble.tier(2) to 2), true) {
                ToughGlisteningTwig(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealthyGlisteningTwig(-1), 400, hashMapOf(
                Seed.tier(2) to 1,
                Stick.tier(2) to 1,
                PlantMatter.tier(2) to 3), true) {
                HealthyGlisteningTwig(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealingGlisteningTwig(-1), 400, hashMapOf(
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
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
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
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
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
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
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
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
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
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
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
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
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
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
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
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
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
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
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
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
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
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
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
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
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
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
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
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            }
        ))
        shopRegistry["marco"] = Shop("Marco", "siege.shops.shop.marco", listOf(
            //WOODEN
            ShopItem(WoodenPickaxe(0), 200, hashMapOf(), false) {
                WoodenPickaxe(0).getUpdatedItem(false)
            },
            ShopItem(WoodenShovel(0), 200, hashMapOf(), false) {
                WoodenShovel(0).getUpdatedItem(false)
            },
            ShopItem(WoodenAxe(0), 200, hashMapOf(), false) {
                WoodenAxe(0).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(GlowingWoodenPickaxe(0), 400, hashMapOf(), false) {
                GlowingWoodenPickaxe(0).getUpdatedItem(false)
            },
            ShopItem(GlowingWoodenShovel(0), 400, hashMapOf(), false) {
                GlowingWoodenShovel(0).getUpdatedItem(false)
            },
            ShopItem(GlowingWoodenAxe(0), 400, hashMapOf(), false) {
                GlowingWoodenAxe(0).getUpdatedItem(false)
            },

            //BONE
            ShopItem(BonePickaxe(0), 600, hashMapOf(), false) {
                BonePickaxe(0).getUpdatedItem(false)
            },
            ShopItem(BoneShovel(0), 600, hashMapOf(), false) {
                BoneShovel(0).getUpdatedItem(false)
            },
            ShopItem(BoneAxe(0), 600, hashMapOf(), false) {
                BoneAxe(0).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(GlowingBonePickaxe(0), 800, hashMapOf(), false) {
                GlowingBonePickaxe(0).getUpdatedItem(false)
            },
            ShopItem(GlowingBoneShovel(0), 800, hashMapOf(), false) {
                GlowingBoneShovel(0).getUpdatedItem(false)
            },
            ShopItem(GlowingBoneAxe(0), 800, hashMapOf(), false) {
                GlowingBoneAxe(0).getUpdatedItem(false)
            },

            //STONE
            ShopItem(StonePickaxe(0), 1300, hashMapOf(), false) {
                StonePickaxe(0).getUpdatedItem(false)
            },
            ShopItem(StoneShovel(0), 1300, hashMapOf(), false) {
                StoneShovel(0).getUpdatedItem(false)
            },
            ShopItem(StoneAxe(0), 1300, hashMapOf(), false) {
               StoneAxe(0).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(GlowingStonePickaxe(0), 2000, hashMapOf(), false) {
                GlowingStonePickaxe(0).getUpdatedItem(false)
            },
            ShopItem(GlowingStoneShovel(0), 2000, hashMapOf(), false) {
                GlowingStoneShovel(0).getUpdatedItem(false)
            },
            ShopItem(GlowingStoneAxe(0), 2000, hashMapOf(), false) {
                GlowingStoneAxe(0).getUpdatedItem(false)
            },

            //IRON
            ShopItem(IronPickaxe(0), 2500, hashMapOf(), false) {
                IronPickaxe(0).getUpdatedItem(false)
            },
            ShopItem(IronShovel(0), 2500, hashMapOf(), false) {
                IronShovel(0).getUpdatedItem(false)
            },
            ShopItem(IronAxe(0), 2500, hashMapOf(), false) {
                IronAxe(0).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(GlowingIronPickaxe(0), 3500, hashMapOf(), false) {
                GlowingIronPickaxe(0).getUpdatedItem(false)
            },
            ShopItem(GlowingIronShovel(0), 3500, hashMapOf(), false) {
                GlowingIronShovel(0).getUpdatedItem(false)
            },
            ShopItem(GlowingIronAxe(0), 3500, hashMapOf(), false) {
                GlowingIronAxe(0).getUpdatedItem(false)
            },
        ))
        shopRegistry["clemont"] = Shop("Clemont", "siege.shops.shop.clemont", listOf(
            //LUCKY TOOLS
            ShopItem(HammerAndChisel(0), 5000, hashMapOf(), false) {
                HammerAndChisel(0).getUpdatedItem(false)
            },
            ShopItem(Trowel(0), 5000, hashMapOf(), false) {
                Trowel(0).getUpdatedItem(false)
            },
            ShopItem(Handsaw(0), 5000, hashMapOf(), false) {
                Handsaw(0).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(GlowingHammerAndChisel(0), 8000, hashMapOf(), false) {
                GlowingHammerAndChisel(0).getUpdatedItem(false)
            },
            ShopItem(GlowingTrowel(0), 8000, hashMapOf(), false) {
                GlowingTrowel(0).getUpdatedItem(false)
            },
            ShopItem(GlowingHandsaw(0), 8000, hashMapOf(), false) {
                GlowingHandsaw(0).getUpdatedItem(false)
            },

            //STEEL
            ShopItem(SteelPickaxe(0), 10000, hashMapOf(), false) {
                SteelPickaxe(0).getUpdatedItem(false)
            },
            ShopItem(SteelShovel(0), 10000, hashMapOf(), false) {
                SteelShovel(0).getUpdatedItem(false)
            },
            ShopItem(SteelAxe(0), 10000, hashMapOf(), false) {
                Handsaw(0).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(GlowingSteelPickaxe(0), 17500, hashMapOf(), false) {
                GlowingSteelPickaxe(0).getUpdatedItem(false)
            },
            ShopItem(GlowingSteelShovel(0), 17500, hashMapOf(), false) {
                GlowingSteelShovel(0).getUpdatedItem(false)
            },
            ShopItem(GlowingSteelAxe(0), 17500, hashMapOf(), false) {
                GlowingSteelAxe(0).getUpdatedItem(false)
            },

            //TITANIUM
            ShopItem(TitaniumPickaxe(0), 30000, hashMapOf(), false) {
                TitaniumPickaxe(0).getUpdatedItem(false)
            },
            ShopItem(TitaniumShovel(0), 30000, hashMapOf(), false) {
                TitaniumShovel(0).getUpdatedItem(false)
            },
            ShopItem(TitaniumAxe(0), 30000, hashMapOf(), false) {
                TitaniumAxe(0).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(GlowingTitaniumPickaxe(0), 50000, hashMapOf(), false) {
                GlowingTitaniumPickaxe(0).getUpdatedItem(false)
            },
            ShopItem(GlowingTitaniumShovel(0), 50000, hashMapOf(), false) {
                GlowingTitaniumShovel(0).getUpdatedItem(false)
            },
            ShopItem(GlowingTitaniumAxe(0), 50000, hashMapOf(), false) {
                GlowingTitaniumAxe(0).getUpdatedItem(false)
            },
        ))
        shopRegistry["bailey"] = Shop("Bailey", "siege.shops.shop.bailey", listOf(
            //SPADES
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

            //PEBBLE SHOOTERS
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
        ))
        shopRegistry["joe"] = Shop("Joe", "siege.shops.shop.joe", listOf(
            //STRAW HAT
            ShopItem(StrawHelmet(-1), 400, hashMapOf(
                Wheat.tier(3) to 4), true) {
                StrawHelmet(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(LuckyStrawHat(-1), 500, hashMapOf(
                Wheat.tier(3) to 2,
                Feather.tier(2) to 4), true) {
                LuckyStrawHat(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(StrongStrawHat(-1), 500, hashMapOf(
                Wheat.tier(3) to 2,
                Bone.tier(2) to 4), true) {
                StrongStrawHat(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(ToughStrawHat(-1), 500, hashMapOf(
                Wheat.tier(3) to 2,
                Pebble.tier(2) to 4), true) {
                ToughStrawHat(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealthyStrawHat(-1), 500, hashMapOf(
                Wheat.tier(3) to 2,
                PlantMatter.tier(2) to 4), true) {
                HealthyStrawHat(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealingStrawHat(-1), 500, hashMapOf(
                Wheat.tier(3) to 3), true) {
                HealingStrawHat(Utils.randRarity()).getUpdatedItem(false)
            },

            //STRAW CHESTPLATE
            ShopItem(StrawChestplate(-1), 600, hashMapOf(
                Wheat.tier(3) to 8), true) {
                StrawHelmet(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(LuckyStrawChestplate(-1), 700, hashMapOf(
                Wheat.tier(3) to 6,
                Feather.tier(2) to 2), true) {
                LuckyStrawChestplate(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(StrongStrawChestplate(-1), 700, hashMapOf(
                Wheat.tier(3) to 6,
                Bone.tier(2) to 2), true) {
                StrongStrawChestplate(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(ToughStrawChestplate(-1), 700, hashMapOf(
                Wheat.tier(3) to 6,
                Pebble.tier(2) to 5), true) {
                ToughStrawChestplate(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealthyStrawChestplate(-1), 700, hashMapOf(
                Wheat.tier(3) to 6,
                PlantMatter.tier(2) to 4), true) {
                HealthyStrawChestplate(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealingStrawChestplate(-1), 700, hashMapOf(
                Wheat.tier(3) to 10), true) {
                HealingStrawHat(Utils.randRarity()).getUpdatedItem(false)
            },

            //STRAW LEGGINGS
            ShopItem(StrawLeggings(-1), 500, hashMapOf(
                Wheat.tier(3) to 7), true) {
                StrawLeggings(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(LuckyStrawOveralls(-1), 600, hashMapOf(
                Wheat.tier(3) to 3,
                Feather.tier(2) to 3), true) {
                LuckyStrawOveralls(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(StrongStrawOveralls(-1), 600, hashMapOf(
                Wheat.tier(3) to 4,
                Bone.tier(2) to 3), true) {
                StrongStrawOveralls(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(ToughStrawOveralls(-1), 600, hashMapOf(
                Wheat.tier(3) to 2,
                Pebble.tier(2) to 5), true) {
                ToughStrawOveralls(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealthyStrawOveralls(-1), 600, hashMapOf(
                Wheat.tier(3) to 2,
                PlantMatter.tier(2) to 5), true) {
                HealthyStrawOveralls(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealingStrawOveralls(-1), 600, hashMapOf(
                Wheat.tier(3) to 8), true) {
                HealingStrawOveralls(Utils.randRarity()).getUpdatedItem(false)
            },

            //STRAW BOOTS
            ShopItem(StrawBoots(-1), 300, hashMapOf(
                Wheat.tier(3) to 4), true) {
                StrawBoots(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(LuckyStrawBoots(-1), 400, hashMapOf(
                Wheat.tier(3) to 2,
                Feather.tier(2) to 2), true) {
                LuckyStrawBoots(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(StrongStrawBoots(-1), 400, hashMapOf(
                Wheat.tier(3) to 2,
                Bone.tier(2) to 2), true) {
                StrongStrawBoots(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(ToughStrawBoots(-1), 400, hashMapOf(
                Wheat.tier(3) to 2,
                Pebble.tier(2) to 3), true) {
                ToughStrawBoots(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealthyStrawBoots(-1), 400, hashMapOf(
                Wheat.tier(3) to 2,
                PlantMatter.tier(2) to 3), true) {
                HealthyStrawBoots(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealingStrawBoots(-1), 400, hashMapOf(
                Wheat.tier(3) to 5), true) {
                HealingStrawBoots(Utils.randRarity()).getUpdatedItem(false)
            },
        ))
        shopRegistry["steve"] = Shop("Steve", "siege.shops.shop.steve", listOf(
            //WOOL HAT
            ShopItem(WoolHelmet(-1), 600, hashMapOf(
                Wool.tier(2) to 5), true) {
                WoolHelmet(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(LuckyWoolHelmet(-1), 700, hashMapOf(
                Wool.tier(2) to 3,
                Feather.tier(2) to 2), true) {
                LuckyWoolHelmet(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(StrongWoolHelmet(-1), 700, hashMapOf(
                Wool.tier(2) to 2,
                Bone.tier(2) to 3), true) {
                StrongWoolHelmet(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(ToughWoolHelmet(-1), 700, hashMapOf(
                Wool.tier(2) to 2,
                Pebble.tier(2) to 4), true) {
                ToughWoolHelmet(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealthyWoolHelmet(-1), 700, hashMapOf(
                Wool.tier(2) to 2,
                PlantMatter.tier(2) to 3), true) {
                HealthyWoolHelmet(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealingWoolHelmet(-1), 700, hashMapOf(
                Wool.tier(2) to 3,
                Wheat.tier(2) to 3), true) {
                HealingWoolHelmet(Utils.randRarity()).getUpdatedItem(false)
            },

            //WOOL CHESTPLATE
            ShopItem(WoolChestplate(-1), 800, hashMapOf(
                Wool.tier(2) to 8), true) {
                WoolChestplate(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(LuckyWoolChestplate(-1), 900, hashMapOf(
                Wool.tier(2) to 5,
                Feather.tier(2) to 3), true) {
                LuckyWoolChestplate(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(StrongWoolChestplate(-1), 900, hashMapOf(
                Wool.tier(2) to 5,
                Bone.tier(2) to 3), true) {
                StrongWoolChestplate(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(ToughWoolChestplate(-1), 900, hashMapOf(
                Wool.tier(2) to 4,
                Pebble.tier(2) to 4), true) {
                ToughWoolChestplate(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealthyWoolChestplate(-1), 900, hashMapOf(
                Wool.tier(2) to 3,
                PlantMatter.tier(2) to 5), true) {
                HealthyWoolChestplate(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealingWoolChestplate(-1), 900, hashMapOf(
                Wool.tier(2) to 4,
                Wheat.tier(2) to 4), true) {
                HealingWoolChestplate(Utils.randRarity()).getUpdatedItem(false)
            },

            //WOOL LEGGINGS
            ShopItem(WoolLeggings(-1), 700, hashMapOf(
                Wool.tier(2) to 7), true) {
                WoolLeggings(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(LuckyWoolLeggings(-1), 800, hashMapOf(
                Wool.tier(2) to 3,
                Feather.tier(2) to 4), true) {
                LuckyWoolLeggings(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(StrongWoolLeggings(-1), 800, hashMapOf(
                Wool.tier(2) to 3,
                Bone.tier(2) to 3), true) {
                StrongWoolLeggings(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(ToughWoolLeggings(-1), 800, hashMapOf(
                Wool.tier(2) to 2,
                Pebble.tier(2) to 5), true) {
                ToughWoolLeggings(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealthyWoolLeggings(-1), 800, hashMapOf(
                Wool.tier(2) to 3,
                PlantMatter.tier(2) to 4), true) {
                HealthyWoolLeggings(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealingWoolLeggings(-1), 800, hashMapOf(
                Wool.tier(2) to 4,
                Wheat.tier(2) to 3), true) {
                HealingWoolLeggings(Utils.randRarity()).getUpdatedItem(false)
            },

            //WOOL BOOTS
            ShopItem(WoolBoots(-1), 500, hashMapOf(
                Wool.tier(2) to 4), true) {
                WoolBoots(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(LuckyWoolBoots(-1), 600, hashMapOf(
                Wool.tier(2) to 2,
                Feather.tier(2) to 2), true) {
                LuckyWoolBoots(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(StrongWoolBoots(-1), 600, hashMapOf(
                Wool.tier(2) to 2,
                Bone.tier(2) to 2), true) {
                StrongWoolBoots(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(ToughWoolBoots(-1), 600, hashMapOf(
                Wool.tier(2) to 2,
                Pebble.tier(2) to 3), true) {
                ToughWoolBoots(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealthyWoolBoots(-1), 600, hashMapOf(
                Wool.tier(2) to 2,
                PlantMatter.tier(2) to 2), true) {
                HealthyWoolBoots(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealingWoolBoots(-1), 600, hashMapOf(
                Wool.tier(2) to 1,
                Wheat.tier(2) to 3), true) {
                HealingWoolBoots(Utils.randRarity()).getUpdatedItem(false)
            },
        ))
        shopRegistry["ellie"] = Shop("Ellie", "siege.shops.shop.ellie", listOf(
            //SHOVELS
            ShopItem(Shovel(-1), 600, hashMapOf(
                Pebble.tier(2) to 1,
                Stick.tier(3) to 2), true) {
                Shovel(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(LuckyShovel(-1), 700, hashMapOf(
                Pebble.tier(2) to 1,
                Stick.tier(3) to 1,
                Feather.tier(2) to 2), true) {
                LuckyShovel(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(StrongShovel(-1), 700, hashMapOf(
                Pebble.tier(2) to 1,
                Stick.tier(3) to 1,
                Bone.tier(2) to 1), true) {
                StrongShovel(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(ToughShovel(-1), 700, hashMapOf(
                Pebble.tier(2) to 4,
                Stick.tier(3) to 1), true) {
                ToughShovel(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealthyShovel(-1), 700, hashMapOf(
                Pebble.tier(2) to 1,
                Stick.tier(3) to 1,
                PlantMatter.tier(2) to 2), true) {
                HealthyShovel(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealingShovel(-1), 700, hashMapOf(
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
            ShopItem(
                StrongReinforcedBow(-1), 1200, hashMapOf(
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
        ))
        shopRegistry["barney"] = Shop("Barney", "siege.shops.shop.barney", listOf(
            //SHANK
            ShopItem(Shank(-1), 1000, hashMapOf(), false) {
                Shank(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(LuckyShank(-1), 1250, hashMapOf(), false) {
                LuckyShank(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(StrongShank(-1), 1250, hashMapOf(), false) {
                StrongShank(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(ToughShank(-1), 1250, hashMapOf(), false) {
                ToughShank(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealthyShank(-1), 1250, hashMapOf(), false) {
                HealthyShank(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealingShank(-1), 1250, hashMapOf(), false) {
                HealingShank(Utils.randRarity()).getUpdatedItem(false)
            },

            //DAGGERS
            ShopItem(Dagger(-1), 1500, hashMapOf(), false) {
                Dagger(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(LuckyDagger(-1), 1750, hashMapOf(), false) {
                LuckyDagger(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(StrongDagger(-1), 1750, hashMapOf(), false) {
                StrongDagger(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(ToughDagger(-1), 1750, hashMapOf(), false) {
                ToughDagger(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealthyDagger(-1), 1750, hashMapOf(), false) {
                HealthyDagger(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealingDagger(-1), 1750, hashMapOf(), false) {
                HealingDagger(Utils.randRarity()).getUpdatedItem(false)
            },

            //WOODEN SWORDS
            ShopItem(WoodenSword(-1), 2000, hashMapOf(), false) {
                WoodenSword(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(LuckyWoodenSword(-1), 2250, hashMapOf(), false) {
                LuckyWoodenSword(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(StrongWoodenSword(-1), 2250, hashMapOf(), false) {
                StrongWoodenSword(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(ToughWoodenSword(-1), 2250, hashMapOf(), false) {
                ToughWoodenSword(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealthyWoodenSword(-1), 2250, hashMapOf(), false) {
                HealthyWoodenSword(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealingWoodenSword(-1), 2250, hashMapOf(), false) {
                HealingWoodenSword(Utils.randRarity()).getUpdatedItem(false)
            },
        ))
        shopRegistry["jane"] = Shop("Jane", "siege.shops.shop.jane", listOf(
            //SCRAP SHARD
            ShopItem(ScrapShard(-1), 2250, hashMapOf(
                MetalScrap.tier(3) to 2), true) {
                ScrapShard(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(LuckyScrapShard(-1), 2250, hashMapOf(
                MetalScrap.tier(3) to 1,
                Feather.tier(3) to 2), true) {
                LuckyScrapShard(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(StrongScrapShard(-1), 2250, hashMapOf(
                MetalScrap.tier(3) to 1,
                Bone.tier(3) to 2), true) {
                StrongScrapShard(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(ToughScrapShard(-1), 2250, hashMapOf(
                MetalScrap.tier(3) to 1,
                Pebble.tier(3) to 2), true) {
                ToughScrapShard(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealthyScrapShard(-1), 2250, hashMapOf(
                MetalScrap.tier(3) to 1,
                PlantMatter.tier(3) to 2), true) {
                HealthyScrapShard(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealingScrapShard(-1), 2250, hashMapOf(
                MetalScrap.tier(3) to 1,
                Wheat.tier(3) to 3), true) {
                HealingScrapShard(Utils.randRarity()).getUpdatedItem(false)
            },

            //SPLINTERED BONE
            ShopItem(SplinteredBone(-1), 2500, hashMapOf(
                Bone.tier(3) to 2), true) {
                SplinteredBone(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(LuckySplinteredBone(-1), 2700, hashMapOf(
                Bone.tier(3) to 1,
                Feather.tier(3) to 2), true) {
                LuckySplinteredBone(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(StrongSplinteredBone(-1), 2700, hashMapOf(
                Bone.tier(3) to 3), true) {
                StrongSplinteredBone(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(ToughSplinteredBone(-1), 2700, hashMapOf(
                Bone.tier(3) to 1,
                Pebble.tier(3) to 2), true) {
                ToughSplinteredBone(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealthySplinteredBone(-1), 2700, hashMapOf(
                Bone.tier(3) to 1,
                PlantMatter.tier(3) to 2), true) {
                HealthySplinteredBone(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealingSplinteredBone(-1), 2700, hashMapOf(
                Bone.tier(3) to 1,
                Wheat.tier(3) to 3), true) {
                HealingSplinteredBone(Utils.randRarity()).getUpdatedItem(false)
            },

            //REFINED DAGGER
            ShopItem(RefinedDagger(-1), 2750, hashMapOf(
                RefinedMetal.tier(3) to 1,
                Stick.tier(3) to 1), true) {
                RefinedDagger(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
                GRAYFILLER(-1).getUpdatedItem(false)
            },
            ShopItem(LuckyRefinedDagger(-1), 3000, hashMapOf(
                RefinedMetal.tier(2) to 4,
                Stick.tier(3) to 1,
                Feather.tier(3) to 1), true) {
                LuckyRefinedDagger(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(StrongRefinedDagger(-1), 3000, hashMapOf(
                RefinedMetal.tier(2) to 4,
                Stick.tier(3) to 1,
                Bone.tier(3) to 1), true) {
                StrongRefinedDagger(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(ToughRefinedDagger(-1), 3000, hashMapOf(
                RefinedMetal.tier(2) to 4,
                Stick.tier(3) to 1,
                Pebble.tier(3) to 2), true) {
                ToughRefinedDagger(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealthyRefinedDagger(-1), 3000, hashMapOf(
                RefinedMetal.tier(2) to 4,
                Stick.tier(3) to 1,
                PlantMatter.tier(3) to 1), true) {
                HealthyRefinedDagger(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealingRefinedDagger(-1), 3000, hashMapOf(
                RefinedMetal.tier(2) to 4,
                Stick.tier(3) to 1,
                Wheat.tier(3) to 2), true) {
                HealingRefinedDagger(Utils.randRarity()).getUpdatedItem(false)
            },
        ))

        Bukkit.getLogger().info("Enabled!")
    }
}