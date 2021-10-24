package net.siegerpg.siege.core.events

import io.lumine.xikage.mythicmobs.mobs.ActiveMob
import net.siegerpg.siege.core.utils.BossLeaderboardDB
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDeathEvent
import java.time.Duration
import java.time.Instant
import java.util.*
import kotlin.math.floor

data class BossFight(val startTime: Instant, val entity: ActiveMob) {
    val fighters = HashMap<UUID, Double>()
    val entityHealth = entity.entity.health
}

class BossLeaderboard : Listener {

    companion object {
        val currentBossFights = ArrayList<BossFight>()
    }


    @EventHandler
    public fun onBossGetHit(evt: EntityDamageByEntityEvent) {
        val bossFight = currentBossFights.find { b -> b.entity.uniqueId == evt.entity.uniqueId }
            ?: return
        println("Ouch! The boss called ${bossFight.entity.displayName} got hit!")
        if (evt.damager.type != EntityType.PLAYER) return
        val damager = evt.damager as Player
        println("Omg woah ${bossFight.entity.displayName} was hit by a PLAYER :o")
        bossFight.fighters[damager.uniqueId] =
            (bossFight.fighters[damager.uniqueId] ?: 0.0) + evt.finalDamage
        println("New data: ${bossFight.fighters[damager.uniqueId]}")
        println("Data from currentBossFights: ${currentBossFights.find { b -> b.entity.uniqueId == evt.entity.uniqueId }?.fighters?.map { (k, v) -> "$k: $v" }}")
    }

    @EventHandler
    public fun onBossUnlive(evt: EntityDeathEvent) {
        val deathTime = Instant.now()
        val bossFight = currentBossFights.find { b -> b.entity.uniqueId == evt.entity.uniqueId }
            ?: return
        println("RIP! The boss called ${bossFight.entity.displayName} died!")
        // Uploads data to the db
        val hashMapData = HashMap<UUID, Pair<Byte, Int>>()
        val startingBossHealth = floor(bossFight.entityHealth).toInt()
        val fightDuration = Duration.between(bossFight.startTime, deathTime).abs().seconds
        println("The fight lasted $fightDuration seconds!")
        bossFight.fighters.forEach { (fighter, damageDone) ->
            val percentageDamage = floor(damageDone / startingBossHealth * 100).toInt().toByte()
            println("The fighter $fighter did $damageDone out of $startingBossHealth! Crazy ikr?")
            hashMapData[fighter] = Pair(percentageDamage, fightDuration.toInt())
        }
        println("New data:")
        hashMapData.forEach { (uuid, pair) -> print("$uuid did ${pair.first}% in ${pair.second} seconds") }
        BossLeaderboardDB.setBossData(bossFight.entity.type.internalName, hashMapData)
    }
}