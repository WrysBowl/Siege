package net.siegerpg.siege.core.utils.levelReward

import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Twig
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Sound
import org.bukkit.entity.Player

class Reward1 : LevelReward {
    override fun giveReward(player: Player, level: Short) {
        player.playSound(player.location, Sound.ENTITY_PLAYER_LEVELUP,5.0f, 5.0f)
        player.sendTitle(null, Utils.tacc("&d${level-1} &7\u21E2 &5$level"), 10, 60, 20)
        player.sendMessage(Utils.lore(""))
        player.sendMessage(Utils.lore("<gray>You leveled up to level $level!"))
        player.sendMessage(Utils.lore("<gold><bold>Level Reward"))
        player.sendMessage(Utils.lore("<yellow>+ 100 gold"))
        player.sendMessage(Utils.lore("<red>+ 2 HP"))
        player.sendMessage(Utils.lore("<green>+ Twig <yellow>???"))
        player.sendMessage(Utils.lore("<green>+ Stick \u272a x12"))
        player.sendMessage(Utils.lore(""))

        GoldExpListener().giveGold(player, 100)
        Utils.giveItem(player, Twig(Utils.randRarity()).getUpdatedItem(false))
        Utils.giveItem(player, Stick.tier(1).getUpdatedItem(false).asQuantity(12))
    }
}