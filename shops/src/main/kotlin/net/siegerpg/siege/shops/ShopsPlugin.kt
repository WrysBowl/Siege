package net.siegerpg.siege.shops

import co.aikar.commands.PaperCommandManager
import net.siegerpg.siege.shops.shop.*
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin


class ShopsPlugin: JavaPlugin(), Listener {
    // while this is singleton, a class must be initialized by Bukkit, so we can't use 'object'
    // Please make it possible to fill a slot with a blank item
    companion object {
        var instance: ShopsPlugin? = null
            private set
    }

    val shopRegistry: HashMap<String, Shop> = hashMapOf(
        "chip" to Chip(), "chop" to Chop(), "sylvester" to Sylvester(), "phillip" to Phillip(),
        "minnow" to Minnow(), "chelsea" to Chelsea(), "marco" to Marco(), "clemont" to Clemont(),
        "bailey" to Bailey(), "joe" to Joe(), "steve" to Steve(), "ellie" to Ellie(),
        "barney" to Barney(), "jane" to Jane(), "julie" to Julie(), "valentine" to Valentine(),
        "gale" to Gale(), "forest" to Forest(), "fredric" to Fredric(), "katherine" to Katherine(),
        "magmar" to Magmar(), "rancher" to Rancher(), "brown" to Brown(), "kayla" to Kayla(),
        "mary" to Mary(), "hillySpirit" to HillySpirit()
    )

    override fun onEnable() {
        instance = this
        val manager = PaperCommandManager(this)
        manager.registerCommand(ShopsCommand())
        server.pluginManager.registerEvents(this, this)
    }
}