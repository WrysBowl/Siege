package net.siegerpg.siege.core.listeners

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.types.misc.CustomWand
import org.bukkit.*
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.util.Vector
import kotlin.math.*

class WandCast : BukkitRunnable {
    private var plugin: Plugin = Core.plugin()
    private var customWand: CustomWand? = null
    private var player: Player? = null
    private var fromPlayerToTarget: Vector? = null
    private var loc: Location = Location(Bukkit.getWorld("world"), 0.0, 0.0, 0.0)
    private var targetLoc: Location = Location(Bukkit.getWorld("world"), 0.0, 0.0, 0.0)
    private var increment: Double = 0.0
    private var dmg: Double = 0.0
    private var counter: Double = 0.0

    constructor(plugin: JavaPlugin, customWand: CustomWand, player: Player, vector: Vector, playerLoc: Location, damage:Double, targetLoc: Location, length: Double) {
        this.plugin = plugin
        this.customWand = customWand
        this.player = player
        this.fromPlayerToTarget = vector
        this.loc = playerLoc
        this.dmg = damage
        this.targetLoc = targetLoc
        this.increment = length
    }

    override fun run() {
        counter += increment
        val x = fromPlayerToTarget?.x!! * counter
        val y = fromPlayerToTarget?.y!! * counter
        val z = fromPlayerToTarget?.z!! * counter
        loc.add(x, y, z)

        drawParticle(loc, customWand!!.red, customWand!!.green, customWand!!.blue)

        val x2 = sin(counter * 100) * 0.75
        val y2 = 0.0
        val z2 = cos(counter * 100) * 0.75
        loc.add(x2, y2, z2)

        drawParticle(loc, customWand!!.red, customWand!!.green, customWand!!.blue)

        loc.world.playSound(loc, Sound.ENTITY_PLAYER_ATTACK_SWEEP, 1.0f, 1.0f)
        for (e in loc.getNearbyLivingEntities(customWand!!.damageRadius)) {
            if (e is Player) continue
            e.damage(dmg, player)
        }
        if (loc.distance(targetLoc) < 1) {
            this.cancel()
        }
        loc.subtract(x, y, z)
        loc.subtract(x2, y2, z2)
    }

    private fun drawParticle(loc: Location, r: Int, g: Int, b: Int) {
        if (loc.world == null) return
        loc.world.spawnParticle(
            Particle.REDSTONE,
            loc,
            0,
            0.0,
            0.0,
            0.0,
            1.0,
            Particle.DustOptions(Color.fromRGB(r, g, b), 1.0F)
        )
    }

}