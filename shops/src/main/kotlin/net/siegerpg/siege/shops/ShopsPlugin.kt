package net.siegerpg.siege.shops

import co.aikar.commands.PaperCommandManager
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.StickyStick
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.WoodenSword
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

        shopRegistry["one"] = Shop("Test Shop", "siege.shops.whitelist.one", listOf(
            ShopItem(WoodenSword(50), 10, -1, true),
            ShopItem(WoodenSword(50), -1, 50, true),
            ShopItem(WoodenSword(50), 0, 0, true),
            ShopItem(WoodenSword(50), 0, 0, true),
            ShopItem(WoodenSword(50), 0, 0, true),
            ShopItem(WoodenSword(50), 0, 0, true),
            ShopItem(WoodenSword(50), 0, 0, true),
            ShopItem(WoodenSword(50), 0, 0, true),
            ShopItem(WoodenSword(50), 0, 0, true)
        ))

        Bukkit.getLogger().info("Enabled!")
    }
}