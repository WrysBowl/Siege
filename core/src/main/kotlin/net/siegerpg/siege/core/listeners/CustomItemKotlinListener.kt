package net.siegerpg.siege.core.listeners

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.events.ArmorEquipEvent
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.types.misc.CustomFood
import net.siegerpg.siege.core.items.types.misc.CustomWand
import net.siegerpg.siege.core.utils.Levels
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.*
import org.bukkit.attribute.Attribute
import org.bukkit.entity.ArmorStand
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityRegainHealthEvent
import org.bukkit.event.entity.ProjectileHitEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerItemConsumeEvent
import org.bukkit.event.player.PlayerItemHeldEvent
import org.bukkit.scheduler.BukkitRunnable

class CustomItemKotlinListener : Listener {

    var cooldown: MutableList<Player> = mutableListOf()

    @EventHandler
    @Suppress("unused")
    fun onHit(e: ProjectileHitEvent) {

    }


    /*
    @EventHandler()
    @Suppress("unused")
    fun onArmorEquip(e: ArmorEquipEvent) {
        // TODO: Permanent fadein action bar
    }*/


    @EventHandler
    @Suppress("unused")
    fun onItemSwitch(e: PlayerItemHeldEvent) {
        //e.player.chat("switched item from ${e.previousSlot} to ${e.newSlot}")
        //CustomItemUtils.getPlayerStat(e.player, StatTypes.STRENGTH)
        //e.player.sendMessage("item in new slot: ${e.player.inventory.getItem(e.newSlot)?.type}")
        //e.player.sendMessage("item in main hand: ${e.player.inventory.itemInMainHand.type}")
        //e.player.sendMessage("item in previous slot: ${e.player.inventory.getItem(e.previousSlot)?.type}")
        //e.player.sendMessage("strength stat: ${CustomItemUtils.getPlayerStat(e.player, StatTypes.STRENGTH, e.player.inventory.getItem(e.newSlot))}")
        // TODO: Permanent fadein action bar
//        GlobalScope.launch {
//            delay(10)
//            e.player.sendMessage("item now in main hand: ${e.player.inventory.itemInMainHand.type}")
//            e.player.sendMessage("strength stat: ${CustomItemUtils.getPlayerStat(e.player, StatTypes.STRENGTH)}")
//        }
//        Thread.sleep(50)
//        Scoreboard.updateScoreboard(e.player)

//        val customItem = e.player.inventory.getItem(e.newSlot)?.let { CustomItemUtils.getCustomItem(it) }
//        customItem?.let {
//            Scoreboard.updateScoreboard(e.player)
//        }

    }

    @EventHandler
    @Suppress("unused")
    fun onHit(e: EntityDamageByEntityEvent) {

        if (e.damager is Player) {
            val item = CustomItemUtils.getCustomItem((e.damager as Player).inventory.itemInMainHand)
            if (item == null) {
                e.damage = 1.0
                return
            }

            val levelReq = item.levelRequirement
            if (levelReq == null) {
                e.damage = 1.0
                return
            }

            if (levelReq > Levels.getLevel(e.damager as OfflinePlayer)) {
                e.damager.sendActionBar(Utils.parse("<red>You're too weak to use this weapon"))
                e.damage = 1.0
                return
            }
        }

        val victim = e.entity as LivingEntity
        val attacker =
            if (e.damager is Player) e.damager as Player
            else e.damager
        val damage = e.damage
        val maxDamage =
            if (attacker is Player)
                attacker.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE)?.value as Double
            else damage
        val vicHealthStat =
            if (victim is Player && CustomItemUtils.getPlayerStat(victim, StatTypes.HEALTH) != 0.0)
                CustomItemUtils.getPlayerStat(victim, StatTypes.HEALTH)
            else victim.health
        val vicToughness =
            if (victim is Player) CustomItemUtils.getPlayerStat(victim, StatTypes.TOUGHNESS)
            else 0.0
        val attStrengthStat =
            if (attacker is Player && CustomItemUtils.getPlayerStat(attacker, StatTypes.STRENGTH) != 0.0)
                    (damage/maxDamage) * CustomItemUtils.getPlayerStat(attacker, StatTypes.STRENGTH) //if player spam clicks it won't deal max damage
            else damage
        val reducedDamage = attStrengthStat * (1 - (vicToughness/1000)) //custom attack damage with toughness considered
        e.damage = reducedDamage/(vicHealthStat/victim.health) //scaled down to damage player by vanilla damage

        /*
        if (e.damager is Player) {
            val item = (e.damager as Player).inventory.itemInMainHand
            val customItem: CustomItem? = CustomItemUtils.getCustomItem(item)

            customItem?.let {
                if (it is CustomMeleeWeapon) {
                    it.onHit(e)
                }
            }
        }
        if (e.entity is Player) {
            val armor = (e.entity as Player).inventory.armorContents
            if (armor.isNullOrEmpty()) return
            armor.forEach { item ->
                val customItem: CustomItem? = CustomItemUtils.getCustomItem(item)
                customItem?.let {
                    if (it is CustomArmor) {
                        it.onHit(e)
                    }
                }
            }
        }
        */
    }

    @EventHandler
    @Suppress("unused")
    fun onConsume(e: PlayerItemConsumeEvent) {
        CustomItemUtils.getCustomItem(e.item)?.let {
            if (it is CustomFood) it.onEat(e)
        }
    }

    @EventHandler
    @Suppress("unused")
    fun onRegen(e: EntityRegainHealthEvent) {
        if (e.regainReason != EntityRegainHealthEvent.RegainReason.CUSTOM) {
            e.isCancelled = true
        }
    }


    @EventHandler
    @Suppress("unused")
    fun onInteract(event: PlayerInteractEvent) {
        if (event.action != Action.RIGHT_CLICK_AIR &&
            event.action != Action.RIGHT_CLICK_BLOCK
        ) return
        val player = event.player
        val item = player.inventory.itemInMainHand

        CustomItemUtils.getCustomItem(item)?.let {
            if (it is CustomWand) {
                val entity = player.getTargetEntity(it.range)
                val loc = if (entity == null || entity.isDead) {
                    val block = player.getTargetBlock(it.range) ?: return
                    block.location
                } else {
                    entity.location.add(0.0, entity.height, 0.0)
                }
                if (cooldown.contains(player)) return
                cooldown.add(player)
                drawParticles(player.location.add(0.0, player.eyeHeight, 0.0), loc, it.red, it.green, it.blue)
                for (e in loc.getNearbyLivingEntities(it.damageRadius)) {
                    if (e is Player) continue
                    e.damage(it.baseStats[StatTypes.STRENGTH]!!)
                }
                object : BukkitRunnable() {
                    override fun run() {
                        cooldown.remove(player)
                    }
                }.runTaskLaterAsynchronously(Core.plugin(), 2)
            }
        }
    }



    private fun drawParticles(aL: Location, bL: Location, r: Int, g: Int, b: Int) {
        Thread(Runnable {
            var i = 0
            if (aL.world == null || bL.world == null || aL.world != bL.world) return@Runnable
            val distance = aL.distance(bL)
            val p1 = aL.toVector()
            val p2 = bL.toVector()
            val vector = p2.clone().subtract(p1).normalize().multiply(0.2)
            var length = 0.0
            while (length < distance) {
                i++
                val loc = p1.toLocation(aL.world)
                aL.world.spawnParticle(
                    Particle.REDSTONE,
                    loc,
                    0,
                    0.0,
                    0.0,
                    0.0,
                    1.0,
                    Particle.DustOptions(Color.fromRGB(r, g, b), 1.0F)
                )
                length += 0.2
                try {
                    if (i % 10 == 0) Thread.sleep(50)
                } catch (ignored: InterruptedException) {
                }
                p1.add(vector)
            }
        }).start()
    }
}