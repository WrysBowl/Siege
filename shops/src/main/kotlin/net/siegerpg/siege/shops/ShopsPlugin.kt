package net.siegerpg.siege.shops

import co.aikar.commands.PaperCommandManager
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.core.items.implemented.misc.wands.GlisteningTwig
import net.siegerpg.siege.core.items.implemented.misc.wands.LivingTwig
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
            ShopItem(Twig(-1), 25, hashMapOf(Stick.tier(1) to 2), true) {
                Twig(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(StickyStick(-1), 50, hashMapOf(
                Slime.tier(2) to 2,
                Stick.tier(2) to 2), true) {
                StickyStick(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(LuckyStickyStick(-1), 50, hashMapOf(
                Slime.tier(2) to 1,
                Stick.tier(2) to 2,
                Feather.tier(1) to 4), true) {
                LuckyStickyStick(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(StrongStickyStick(-1), 50, hashMapOf(
                Slime.tier(2) to 1,
                Stick.tier(2) to 2,
                Bone.tier(1) to 1), true) {
                StrongStickyStick(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(ToughStickyStick(-1), 50, hashMapOf(
                Slime.tier(2) to 1,
                Stick.tier(2) to 2,
                Pebble.tier(1) to 6), true) {
                ToughStickyStick(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealthyStickyStick(-1), 50, hashMapOf(
                Slime.tier(2) to 1,
                Stick.tier(2) to 2,
                PlantMatter.tier(2) to 1), true) {
                HealthyStickyStick(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealingStickyStick(-1), 50, hashMapOf(
                Slime.tier(2) to 1,
                Stick.tier(2) to 2,
                Wheat.tier(2) to 2), true) {
                HealingStickyStick(Utils.randRarity()).getUpdatedItem(false)
            },

            //RANGED
            ShopItem(ScrapyardBow(-1), 25, hashMapOf(
                Stick.tier(2) to 3,
                Vine.tier(2) to 3), true) {
                ScrapyardBow(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(WoodenBow(-1), 75, hashMapOf(
                Stick.tier(3) to 3,
                Vine.tier(3) to 3), true) {
                WoodenBow(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(LuckyWoodenBow(-1), 75, hashMapOf(
                Stick.tier(3) to 3,
                Vine.tier(3) to 1,
                Feather.tier(3) to 1), true) {
                LuckyWoodenBow(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(StrongWoodenBow(-1), 75, hashMapOf(
                Stick.tier(3) to 3,
                Vine.tier(3) to 1,
                Bone.tier(2) to 6), true) {
                StrongWoodenBow(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(ToughWoodenBow(-1), 75, hashMapOf(
                Stick.tier(3) to 3,
                Vine.tier(3) to 1,
                Pebble.tier(3) to 1), true) {
                ToughWoodenBow(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealthyWoodenBow(-1), 75, hashMapOf(
                Stick.tier(3) to 3,
                Vine.tier(3) to 1,
                PlantMatter.tier(3) to 1), true) {
                HealthyWoodenBow(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealingWoodenBow(-1), 75, hashMapOf(
                Stick.tier(3) to 3,
                Vine.tier(3) to 1,
                Wheat.tier(3) to 1), true) {
                HealingWoodenBow(Utils.randRarity()).getUpdatedItem(false)
            },

            //HEAVY MELEE
            ShopItem(Club(-1), 50, hashMapOf(
                Stick.tier(2) to 2), true) {
                Club(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(GiantClub(-1), 100, hashMapOf(), false) {
                GiantClub(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(LuckyGiantClub(-1), 100, hashMapOf(), false) {
                LuckyGiantClub(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(StrongGiantClub(-1), 100, hashMapOf(), false) {
                StrongGiantClub(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(ToughGiantClub(-1), 100, hashMapOf(), false) {
                ToughGiantClub(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealthyGiantCLub(-1), 100, hashMapOf(), false) {
                HealthyGiantCLub(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(HealingGiantClub(-1), 100, hashMapOf(), false) {
                HealingGiantClub(Utils.randRarity()).getUpdatedItem(false)
            },

            //WANDS
            ShopItem(LivingTwig(-1), 150, hashMapOf(), false) {
                LivingTwig(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(GlisteningTwig(-1), 300, hashMapOf(
                Seed.tier(2) to 1,
                Stick.tier(2) to 1,
                Feather.tier(2) to 2), true) {
                GlisteningTwig(Utils.randRarity()).getUpdatedItem(false)
            },

            //I FORGOT TO IMPLEMENT WAND VARIANTS
            ShopItem(GlisteningTwig(-1), 300, hashMapOf(
                Seed.tier(2) to 1,
                Stick.tier(2) to 1,
                Feather.tier(2) to 2), true) {
                GlisteningTwig(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(GlisteningTwig(-1), 300, hashMapOf(
                Seed.tier(2) to 1,
                Stick.tier(2) to 1,
                Bone.tier(2) to 1), true) {
                GlisteningTwig(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(GlisteningTwig(-1), 300, hashMapOf(
                Seed.tier(2) to 1,
                Stick.tier(2) to 1,
                Pebble.tier(2) to 2), true) {
                GlisteningTwig(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(GlisteningTwig(-1), 300, hashMapOf(
                Seed.tier(2) to 1,
                Stick.tier(2) to 1,
                PlantMatter.tier(2) to 3), true) {
                GlisteningTwig(Utils.randRarity()).getUpdatedItem(false)
            },
            ShopItem(GlisteningTwig(-1), 300, hashMapOf(
                Seed.tier(2) to 1,
                Stick.tier(2) to 1,
                Wheat.tier(2) to 2), true) {
                GlisteningTwig(Utils.randRarity()).getUpdatedItem(false)
            },
        ))

        Bukkit.getLogger().info("Enabled!")
    }
}