package net.siegerpg.siege.core.items.implemented.misc.cosmetics.legendary

import net.kyori.adventure.util.RGBLike
import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.Cosmetic
import net.siegerpg.siege.core.utils.HexColorCode
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack
import org.w3c.dom.css.RGBColor

class HexShifter() : Cosmetic(
    name = "Hex Shifter",
    customModelData = 1,
    description = listOf(""),
    material = Material.LEATHER_HELMET,
    leatherColor = Color.fromRGB(0xFBC84B)
) {

    override fun onCosmeticSpeak(e: AsyncPlayerChatEvent) {
        super.onCosmeticSpeak(e)
        val player: Player = e.player
        val message: String = e.message
        if (HexColorCode.isValidHexCode(message)) {
            leatherColor = HexColorCode.hex2Rgb(message)
            player.sendMessage(Utils.lore("<color:$message>Cosmetic color changed!"))
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