package net.siegerpg.siege.core.events

import com.gmail.filoghost.holographicdisplays.api.HologramsAPI
import io.lumine.xikage.mythicmobs.MythicMobs
import io.lumine.xikage.mythicmobs.mobs.ActiveMob
import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.drops.MobDropTable
import net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon.*
import net.siegerpg.siege.core.utils.*
import net.siegerpg.siege.core.utils.cache.GlobalMultipliers
import org.bukkit.Bukkit
import org.bukkit.entity.Item
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.entity.Projectile
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.inventory.ItemStack
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

    private val dungeonBossDropTableHashMap = mutableMapOf(
        "Broodmother" to Broodmother(),
        "BullSpirit" to BullSpirit(),
        "Davy_Jones" to Davy_Jones(),
        "FoxSpirit" to FoxSpirit(),
        "Lich" to Lich(),
        "MagmaSpirit" to MagmaSpirit(),
        "Necromancer" to Necromancer(),
        "SlimeSpirit" to SlimeSpirit()
    ) as HashMap<String, MobDropTable>

    companion object {
        val currentBossFights = ArrayList<BossFight>()
    }


    @EventHandler
    public fun onBossGetHit(evt: EntityDamageByEntityEvent) {
        val bossFight = currentBossFights.find { b -> b.entity.uniqueId == evt.entity.uniqueId }
            ?: return
        var damager =
            if (evt.damager is Player) evt.damager as Player
            else evt.damager

        if (evt.damager is Projectile) {
            if ((evt.damager as Projectile).shooter is Player) {
                damager = (evt.damager as Projectile).shooter as Player
            }
        }

        if (damager !is Player) return
        val entity = evt.entity as LivingEntity
        val damageDone = if (evt.finalDamage > entity.health) entity.health else evt.finalDamage
        bossFight.fighters[damager.uniqueId] =
            (bossFight.fighters[damager.uniqueId] ?: 0.0) + damageDone

    }

    @EventHandler
    public fun onBossUnlive(evt: EntityDeathEvent) {
        val deathTime = Instant.now()
        val bossFight = currentBossFights.find { b -> b.entity.uniqueId == evt.entity.uniqueId }
            ?: return

        var dropTable: MobDropTable? = null
        if (MythicMobs.inst().apiHelper.isMythicMob(evt.entity)) {
            val bossName = MythicMobs.inst().apiHelper.getMythicMobInstance(evt.entity).type.internalName
            if (dungeonBossDropTableHashMap.containsKey(bossName)) {
                dropTable = dungeonBossDropTableHashMap[bossName]
            }
        }

        // Uploads data to the db
        val hashMapData = HashMap<UUID, Pair<Byte, Int>>()
        val startingBossHealth = round(bossFight.entityHealth).toInt()
        val fightDuration = ceil((Duration.between(bossFight.startTime, deathTime).abs().toMillis() + 100.0) / 1000)
        bossFight.fighters.forEach { (fighter, damageDone) ->
            val percentageDamage = floor(damageDone / startingBossHealth * 100).toInt()
            hashMapData[fighter] = Pair(percentageDamage.toByte(), fightDuration.toInt())

            if (dropTable != null) {

                val dropMultiplier = if (percentageDamage >= 50) 1.0 else percentageDamage.toDouble() / 100 * 2

                Bukkit.getPlayer(fighter)
                    ?.sendMessage(Utils.lore("<green>You dealt <gold>$percentageDamage% <green>of the damage to the boss!"))

                val tableExp = dropTable.getExp(true) ?: 0
                Levels.addExpShared(
                    Bukkit.getOfflinePlayer(fighter),
                    floor(tableExp.toDouble() * dropMultiplier).toInt()
                )

                val tableGoldCoinAmt = dropTable.getGold(true) ?: 0
                val goldCoinAmt =
                    floor(tableGoldCoinAmt.toDouble() * GlobalMultipliers.goldMultiplier * dropMultiplier).toInt()
                val gold: Item = DropUtils.dropItemNaturallyForPlayers(
                    evt.entity.location,
                    GoldEXPSpawning.getGoldCoin(1), listOf(fighter)
                )
                gold.customName = Utils.tacc("&e+$goldCoinAmt Gold")
                gold.isCustomNameVisible = true;
                gold.itemStack.amount = goldCoinAmt

                for (drop in getRewards((percentageDamage / 100.0), dropTable)) { //Loop through all drops
                    DropUtils.dropItemNaturallyForPlayers(evt.entity.location, drop, listOf(fighter))
                }

            }
        }
        BossLeaderboardDB.setBossData(bossFight.entity.type.internalName, hashMapData) {
            val holograms = HologramsAPI.getHolograms(Core.plugin())
            holograms.forEach { hologram ->
                //TODO()
            }
        }
    }

    private fun getRewards(dmgPercent: Double, dropTable: MobDropTable): ArrayList<ItemStack> {
        val itemList = ArrayList<ItemStack>()
        for (reward in dropTable.rewards) {
            val chance: Double = (2 * dmgPercent) * reward.chance
            if (Utils.randTest(chance)) {
                itemList.add(reward.item)
            }
        }
        return itemList
    }
}