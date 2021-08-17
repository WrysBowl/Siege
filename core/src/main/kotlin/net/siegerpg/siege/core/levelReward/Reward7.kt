package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Sound
import org.bukkit.entity.Player

class Reward7 : LevelReward {
    override fun giveReward(player: Player, level: Short) {
        player.playSound(player.location, Sound.ENTITY_PLAYER_LEVELUP,5.0f, 5.0f)
        player.sendTitle(Utils.tacc(""), Utils.tacc("&d${level-1} &7\u21E2 &5$level"), 10, 80, 10)
        player.sendMessage(Utils.lore(""))
        player.sendMessage(Utils.lore("<gray>You leveled up to level $level!"))
        player.sendMessage(Utils.lore("<gold><bold>Level Reward"))
        player.sendMessage(Utils.lore("<yellow>+ 500 gold"))
        player.sendMessage(Utils.lore("<red>+ 2 HP"))
        player.sendMessage(Utils.lore("<green>+ Stick \u272a\u272a x4"))
        player.sendMessage(Utils.lore("<green>+ Wool \u272a\u272a x24"))
        player.sendMessage(Utils.lore(""))

        GoldExpListener.giveGold(player, 500)
        Utils.giveItem(player, Stick.tier(2).getUpdatedItem(false).asQuantity(4))
        Utils.giveItem(player, Wool.tier(2).getUpdatedItem(false).asQuantity(24))

    }
}