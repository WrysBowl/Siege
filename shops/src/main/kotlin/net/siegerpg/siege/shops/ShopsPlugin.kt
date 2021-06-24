package net.siegerpg.siege.shops

import co.aikar.commands.PaperCommandManager
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.StickyStick
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Twig
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.WoodenSword
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.Listener
import org.bukkit.inventory.ItemStack
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
        shopRegistry["1"] = Shop("Test Shop", "siege.shops.shop.1", listOf(
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
            ShopItem(WoodenSword(50), 0, hashMapOf(Pebble.tier(1) to 2, Pebble.tier(1) to 2), true) {
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

        Bukkit.getLogger().info("Enabled!")
    }
}