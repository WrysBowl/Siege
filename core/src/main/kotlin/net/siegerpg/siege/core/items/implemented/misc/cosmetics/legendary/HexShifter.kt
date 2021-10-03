package net.siegerpg.siege.core.items.implemented.misc.cosmetics.legendary

import io.papermc.paper.event.player.AsyncChatEvent
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
    description = listOf(""),
    material = Material.LEATHER_HELMET,
    leatherColor = Color.fromRGB(0xFBC84B)
) {

    override fun onCosmeticSpeak(e: AsyncChatEvent) {
        val player: Player = e.player
        val message: String = e.message().toString()
        Bukkit.getLogger().info(message)
        if (HexColorCode.isValidHexCode(message)) {
            leatherColor = HexColorCode.hex2Rgb(message)
            player.sendMessage(Utils.lore("<color:$message>Cosmetic color changed!"))
            player.inventory.setItemInMainHand(this.getUpdatedItem(false))
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