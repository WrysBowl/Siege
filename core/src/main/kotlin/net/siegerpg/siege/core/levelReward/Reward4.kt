package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.CommonKey
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.NormalKey
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Sound
import org.bukkit.entity.Player

class Reward4 : LevelReward {
    override fun giveReward(player: Player) {
        val level: Short = 5
        player.playSound(player.location, Sound.ENTITY_PLAYER_LEVELUP,5.0f, 5.0f)
        player.sendTitle(Utils.tacc(""), Utils.tacc("&d${level-1} &7\u21E2 &5$level"), 10, 80, 10)
        player.sendMessage(Utils.lore(""))
        player.sendMessage(Utils.lore("<gray>You leveled up to level $level!"))
        player.sendMessage(Utils.lore("<gold><bold>Level Reward"))
        player.sendMessage(Utils.lore("<yellow>+ 1,500 gold"))
        player.sendMessage(Utils.lore("<red>+ 2 HP"))
        player.sendMessage(Utils.lore("<green>+ 1 Normal Cosmetic Key"))
        player.sendMessage(Utils.lore(""))

        GoldExpListener.giveGold(player, 1500)
        Utils.giveItem(player, NormalKey(0).getUpdatedItem(false))
    }
}