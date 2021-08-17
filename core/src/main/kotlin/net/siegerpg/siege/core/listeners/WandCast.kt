package net.siegerpg.siege.core.listeners

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.types.misc.CustomWand
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Levels
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.*
import org.bukkit.attribute.Attribute
import org.bukkit.entity.Entity
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.entity.Projectile
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDamageEvent
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
    private var damageRadius: Double = 0.0

    constructor(plugin: JavaPlugin, customWand: CustomWand, player: Player, vector: Vector, playerLoc: Location, damage:Double, targetLoc: Location, length: Double) {
        this.plugin = plugin
        this.customWand = customWand
        this.player = player
        this.fromPlayerToTarget = vector
        this.loc = playerLoc
        this.dmg = damage
        this.targetLoc = targetLoc
        this.increment = length
        this.damageRadius = customWand.damageRadius
    }

    override fun run() {
        counter += increment
        val x = fromPlayerToTarget?.x!! * counter
        val y = fromPlayerToTarget?.y!! * counter
        val z = fromPlayerToTarget?.z!! * counter
        loc.add(x, y, z)

        drawParticle(loc, customWand!!.red, customWand!!.green, customWand!!.blue)
        loc.world.playSound(loc, Sound.ENTITY_PLAYER_ATTACK_SWEEP, 0.05f, 0.05f)
        if (loc.distance(targetLoc) < 1) {
            this.cancel()
        }
        for (e in loc.getNearbyLivingEntities(damageRadius)) {
            if (e.equals(player)) continue
            if (e is Player && e.world.name != "PVP") continue
            for (en in loc.getNearbyLivingEntities(damageRadius)) {
                if (e.equals(player)) continue
                if (en is Player && en.world.name != "PVP") continue
                en.damage(dmg, player)
            }
            this.cancel()
        }

        loc.subtract(x, y, z)
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