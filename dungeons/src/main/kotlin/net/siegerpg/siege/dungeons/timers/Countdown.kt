package net.siegerpg.siege.dungeons.timers

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.utils.Utils
import net.siegerpg.siege.dungeons.Dungeon
import net.siegerpg.siege.dungeons.DungeonPlugin
import net.siegerpg.siege.dungeons.DungeonRejoin
import org.bukkit.World
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable

class Countdown {
    fun dungeonLeave(player: Player, dungeon: Dungeon, countDown: Int) {
        val world: World = player.world
        object : BukkitRunnable() {
            //BukkitRunnable, not Runnable
            var countdown = countDown //Instance variable in our anonymous class to easily hold the countdown value
            override fun run() {
                if (countdown <= 0 || !player.isOnline || player.world != world) { //countdown is over or player left the server, just two example reasons to exit
                    this.cancel() //cancel the repeating task
                    dungeon.delete() //deletes dungeon after countdown
                    DungeonRejoin(DungeonPlugin.plugin()).dungeonDeaths[player] = 0
                    return  //exit the method
                }
                player.sendTitle(Utils.tacc("&6Teleporting to Hub..."), Utils.tacc("&e$countdown seconds"), 0, 30, 0)
                countdown-- //decrement
            }
        }.runTaskTimer(
            Core.plugin(),
            0,
            20
        ) //Repeating task with 0 ticks initial delay, run once per 20 ticks (one second). Make sure you pass a valid instance of your plugin.
    }

    fun dungeonJoin(player: Player, dungeon: Dungeon, countDown: Int) {
        object : BukkitRunnable() {
            //BukkitRunnable, not Runnable
            var countdown = countDown //Instance variable in our anonymous class to easily hold the countdown value
            override fun run() {
                if (countdown <= 0 || !player.isOnline) { //countdown is over or player left the server, just two example reasons to exit
                    this.cancel() //cancel the repeating task
                    player.teleport(dungeon.getSpawn())
                    return  //exit the method
                }
                player.sendTitle(Utils.tacc("&6Teleporting to Dungeon..."), Utils.tacc("&e$countdown seconds"), 0, 30, 0)
                countdown-- //decrement
            }
        }.runTaskTimer(
            Core.plugin(),
            0,
            20
        ) //Repeating task with 0 ticks initial delay, run once per 20 ticks (one second). Make sure you pass a valid instance of your plugin.
    }
}