package net.siegerpg.siege.core.items.implemented.misc.cosmetics.legendary

import io.papermc.paper.event.player.AsyncChatEvent
import net.kyori.adventure.text.TextComponent
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.Cosmetic
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class HexShifter() : Cosmetic(
		name = "Hex Shifter",
		customModelData = 750001,
		description = listOf(
				"1. Hold cosmetic helmet",
				"2. Type HEX color in chat",
				"Ex. #FBC84B"
		                    ),
		material = Material.LEATHER_HELMET,
		leatherColor = Color.fromRGB(0xFBC84B),
		quality = 100
                             ) {

	override fun onCosmeticSpeak(e : AsyncChatEvent) {
		val player : Player = e.player
		var message : String = (e.message() as TextComponent).content()
		if (Utils.isValidHexCode(message) || Utils.isValidHexCode("#$message")) {
			message = if (!message.contains("#")) "#$message" else message
			e.isCancelled = true
			player.sendMessage(Utils.lore("<color:$message>Cosmetic color changed!"))

			leatherColor = Utils.hex2Rgb(message)
			item = this.getUpdatedItem(false)
			this.serialize()
			player.inventory.setItemInMainHand(item)
		}
	}


	constructor(quality : Int) : this() {
		this.quality = quality
		this.rarity = Rarity.getFromInt(quality)
		this.serialize()
	}

	constructor(item : ItemStack) : this() {
		this.item = item
		deserialize()
	}

}