package net.siegerpg.siege.core.items.implemented.misc.cosmetics.legendary

import io.papermc.paper.event.player.AsyncChatEvent
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextComponent
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.Cosmetic
import net.siegerpg.siege.core.utils.HexColorCode
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Bukkit
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class HexShifter() : Cosmetic(
    name = "Hex Shifter",
    customModelData = 1,
    description = listOf("1. Hold cosmetic helmet", "2. Type HEX color in chat", "Ex. #FBC84B"),
    material = Material.LEATHER_HELMET,
    leatherColor = Color.fromRGB(0xFBC84B)
) {

    override fun onCosmeticSpeak(e: AsyncChatEvent) {
        val player: Player = e.player
        var message: String = (e.message() as TextComponent).content()
        if (HexColorCode.isValidHexCode(message) || HexColorCode.isValidHexCode("#$message")) {
            message = if (!message.contains("#")) "#$message" else message
            e.isCancelled = true
            this.leatherColor = HexColorCode.hex2Rgb(message)
            this.item = this.getUpdatedItem(false)
            player.sendMessage(Utils.lore("<color:$message>Cosmetic color changed!"))
            player.inventory.setItemInMainHand(this.item)
            this.serialize()
        }
    }


    constructor(quality: Int): this() {
        this.quality = 100
        this.rarity = Rarity.LEGENDARY
        this.serialize()
    }

    constructor(item: ItemStack): this() {
        this.item = item
        deserialize()
    }

}