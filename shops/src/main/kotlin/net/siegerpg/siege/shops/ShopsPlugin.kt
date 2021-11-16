package net.siegerpg.siege.shops

import co.aikar.commands.PaperCommandManager
import net.siegerpg.siege.shops.shop.Bailey
import net.siegerpg.siege.shops.shop.Barney
import net.siegerpg.siege.shops.shop.Berta
import net.siegerpg.siege.shops.shop.Brown
import net.siegerpg.siege.shops.shop.Charles
import net.siegerpg.siege.shops.shop.Chelsea
import net.siegerpg.siege.shops.shop.Chip
import net.siegerpg.siege.shops.shop.Chop
import net.siegerpg.siege.shops.shop.Clemont
import net.siegerpg.siege.shops.shop.Edith
import net.siegerpg.siege.shops.shop.Edward
import net.siegerpg.siege.shops.shop.Ellie
import net.siegerpg.siege.shops.shop.Forest
import net.siegerpg.siege.shops.shop.Fredric
import net.siegerpg.siege.shops.shop.Gale
import net.siegerpg.siege.shops.shop.Gilbert
import net.siegerpg.siege.shops.shop.Grace
import net.siegerpg.siege.shops.shop.Helen
import net.siegerpg.siege.shops.shop.Jane
import net.siegerpg.siege.shops.shop.Jewel
import net.siegerpg.siege.shops.shop.Joe
import net.siegerpg.siege.shops.shop.Julie
import net.siegerpg.siege.shops.shop.Katherine
import net.siegerpg.siege.shops.shop.Kayla
import net.siegerpg.siege.shops.shop.Lucia
import net.siegerpg.siege.shops.shop.Magmar
import net.siegerpg.siege.shops.shop.Marco
import net.siegerpg.siege.shops.shop.Margaret
import net.siegerpg.siege.shops.shop.Mary
import net.siegerpg.siege.shops.shop.Minnow
import net.siegerpg.siege.shops.shop.Phillip
import net.siegerpg.siege.shops.shop.Rancher
import net.siegerpg.siege.shops.shop.Rose
import net.siegerpg.siege.shops.shop.Steve
import net.siegerpg.siege.shops.shop.Sylvester
import net.siegerpg.siege.shops.shop.Tim
import net.siegerpg.siege.shops.shop.Valentine
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin


class ShopsPlugin : JavaPlugin(), Listener {
	// while this is singleton, a class must be initialized by Bukkit, so we can't use 'object'
	// Please make it possible to fill a slot with a blank item
	companion object {

		var instance: ShopsPlugin? = null
			private set
	}

	val shopRegistry: HashMap<String, Shop> = hashMapOf()

	override fun onEnable() {
		instance = this
		val manager = PaperCommandManager(this)
		manager.registerCommand(ShopsCommand())
		server.pluginManager.registerEvents(this, this)

		shopRegistry.putAll(
			hashMapOf(
				"chip" to Chip(),
				"chop" to Chop(),
				"sylvester" to Sylvester(),
				"phillip" to Phillip(),
				"minnow" to Minnow(),
				"chelsea" to Chelsea(),
				"marco" to Marco(),
				"clemont" to Clemont(),
				"bailey" to Bailey(),
				"joe" to Joe(),
				"steve" to Steve(),
				"ellie" to Ellie(),
				"barney" to Barney(),
				"jane" to Jane(),
				"julie" to Julie(),
				"valentine" to Valentine(),
				"gale" to Gale(),
				"forest" to Forest(),
				"fredric" to Fredric(),
				"katherine" to Katherine(),
				"magmar" to Magmar(),
				"rancher" to Rancher(),
				"brown" to Brown(),
				"kayla" to Kayla(),
				"mary" to Mary(),
				"rose" to Rose(),
				"grace" to Grace(),
				"edward" to Edward(),
				"edith" to Edith(),
				"lucia" to Lucia(),
				"margaret" to Margaret(),
				"helen" to Helen(),
				"charles" to Charles(),
				"tim" to Tim(),
				"gilbert" to Gilbert(),
				"jewel" to Jewel(),
				"berta" to Berta()
			         )
		                   )

	}
}