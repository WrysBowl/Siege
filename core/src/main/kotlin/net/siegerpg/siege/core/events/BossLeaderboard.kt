package net.siegerpg.siege.core.events

import io.lumine.xikage.mythicmobs.mobs.ActiveMob
import net.siegerpg.siege.core.utils.BossLeaderboardDB
import org.bukkit.entity.EntityType
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDeathEvent
import java.time.Duration
import java.time.Instant
import java.util.*
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.round

data class BossFight(val startTime: Instant, val entity: ActiveMob) {
    val fighters = HashMap<UUID, Double>()
    val entityHealth = entity.entity.maxHealth
}

class BossLeaderboard : Listener {

    companion object {
        val currentBossFights = ArrayList<BossFight>()
    }


    @EventHandler
    public fun onBossGetHit(evt: EntityDamageByEntityEvent) {
        val bossFight = currentBossFights.find { b -> b.entity.uniqueId == evt.entity.uniqueId }
            ?: return
        if (evt.damager.type != EntityType.PLAYER) return
        val damager = evt.damager as Player
        val entity = evt.entity as LivingEntity
        val damageDone = if (evt.finalDamage > entity.health) entity.health else evt.finalDamage
        bossFight.fighters[damager.uniqueId] =
            (bossFight.fighters[damager.uniqueId] ?: 0.0) + damageDone
        println("User ${damager.name} has just dealt $damageDone (for a total of ${bossFight.fighters[damager.uniqueId]}) ")

    }

    @EventHandler
    public fun onBossUnlive(evt: EntityDeathEvent) {
        val deathTime = Instant.now()
        val bossFight = currentBossFights.find { b -> b.entity.uniqueId == evt.entity.uniqueId }
            ?: return
        // Uploads data to the db
        val hashMapData = HashMap<UUID, Pair<Byte, Int>>()
        val startingBossHealth = round(bossFight.entityHealth).toInt()
        val fightDuration = ceil((Duration.between(bossFight.startTime, deathTime).abs().toMillis() + 100.0) / 1000)
        bossFight.fighters.forEach { (fighter, damageDone) ->
            val percentageDamage = floor(damageDone / startingBossHealth * 100).toInt().toByte()
            hashMapData[fighter] = Pair(percentageDamage, fightDuration.toInt())
        }
        BossLeaderboardDB.setBossData(bossFight.entity.type.internalName, hashMapData)
    }
}