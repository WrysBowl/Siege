package net.siegerpg.siege.core.items.implemented.misc.materials

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomMaterial
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class FishingExplanation() : CustomMaterial(
	name = Utils.tacc("&3Fishing 101"),
	description = listOf(
		Utils.tacc("&eFishing can be complicated"),
		Utils.tacc("&e at first, but once you get"),
		Utils.tacc("&ethe hang of it, it's really fun!"),
		"",
		Utils.tacc("&b1. Cast fishing rod as normal"),
		Utils.tacc("&b2. Wait for your bobber to get caught"),
		Utils.tacc("&b3. Right click to start catching the fish"),
		Utils.tacc("&b4. Click once to change the direction"),
		Utils.tacc("&bof the blue '|' above your hot bar"),
		Utils.tacc("&b5. Your objective is to keep up with the"),
		Utils.tacc("&bmoving green bar so that the progress in"),
		Utils.tacc("&bthe bar at the top of your screen can fill up"),
		"",
		Utils.tacc("&eGreen moving bar above your hot bar is the"),
		Utils.tacc("&etemper of the fish. It doesn't want you to"),
		Utils.tacc("&ecatch it, so it moves around a lot"),
		Utils.tacc("&eStay within the green moving"),
		Utils.tacc("&ebar to keep up with it!"),
		Utils.tacc("&e&lGO FISH!"),
	                    ),
	material = Material.WRITTEN_BOOK
                                           ) {

	constructor(quality: Int) : this() {
		this.quality = quality
		this.rarity = Rarity.getFromInt(quality)
		this.serialize()
	}

	constructor(item: ItemStack) : this() {
		this.item = item
		deserialize()
	}

}