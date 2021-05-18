package net.siegerpg.siege.core.listeners

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.Core.plugin
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.types.misc.CustomFood
import net.siegerpg.siege.core.items.types.misc.CustomWand
import net.siegerpg.siege.core.utils.Levels
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.*
import org.bukkit.attribute.Attribute
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
import org.bukkit.scheduler.BukkitTask
import kotlin.math.cos
import kotlin.math.sin


class CustomItemKotlinListener : Listener, Runnable {

    var cooldownWand: MutableList<Player> = mutableListOf()
    var cooldownFood: MutableList<Player> = mutableListOf()

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

            if (levelReq > Levels.getExpLevel((e.damager as Player)).first) {
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
            if (victim is Player) CustomItemUtils.getPlayerStat(victim, StatTypes.HEALTH) + victim.maxHealth + (victim.level*2)
            else victim.maxHealth
        val vicToughness =
            if (victim is Player) CustomItemUtils.getPlayerStat(victim, StatTypes.TOUGHNESS)
            else 0.0
        val attStrengthStat =
            if (attacker is Player && CustomItemUtils.getPlayerStat(attacker, StatTypes.STRENGTH) != 0.0)
                    (damage/maxDamage) * (CustomItemUtils.getPlayerStat(attacker, StatTypes.STRENGTH) + attacker.level) //if player spam clicks it won't deal max damage
            else damage
        val reducedDamage = attStrengthStat * (1 - (vicToughness/1000)) //custom attack damage with toughness considered
        e.damage = (reducedDamage * victim.maxHealth)/vicHealthStat //scaled down to damage player by vanilla damage

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
        Bukkit.getServer().scheduler.scheduleSyncDelayedTask(Core.plugin(), {
            CustomItemUtils.getCustomItem(e.item)?.let {
                if (it is CustomFood) {
                    it.onEat(e)
                }
            }
        }, 1)
    }


    @EventHandler
    @Suppress("unused")
    fun onFoodHold(e: PlayerItemHeldEvent) {
        if (e.player.foodLevel != 20) return
        val food = CustomItemUtils.getCustomItem(e.player.inventory.getItem(e.newSlot))
        if (food != null) {
            if (food is CustomFood) {
                e.player.foodLevel = 19
            }
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

                player.sendActionBar((Utils.parse("<red>Wands still buggy :(")))

                //MAKE THIS EFFICIENT
                val targetLoc = if (player.getTargetBlock(it.range) == null) {
                    val block = player.getTargetBlock(it.range) ?: return
                    block.location
                } else {
                    val block = player.getTargetBlock(it.range) ?: return
                    block.location
                }


                if (cooldownWand.contains(player)) {
                    player.sendActionBar(Utils.parse("<red>You are on cooldown"))
                    return
                }
                cooldownWand.add(player)
                object : BukkitRunnable() {
                    override fun run() {
                        cooldownWand.remove(player)
                    }
                }.runTaskLaterAsynchronously(plugin(), 10)


                var dmg = it.baseStats[StatTypes.STRENGTH]!!
                if (player.level < CustomItemUtils.getCustomItem(item)?.levelRequirement!!) dmg = 1.0

                val loc = player.location.add(0.0, player.eyeHeight, 0.0) //player location
                val distance = loc.distance(targetLoc)
                val fromPlayerToTarget = targetLoc.toVector().subtract(loc.toVector())
                WandCast(plugin(), it, player, fromPlayerToTarget, loc, dmg, targetLoc, 0.02).runTaskTimer(plugin(), 10, 0)
            }
        }
    }

    override fun run() {
        TODO("Not yet implemented")
    }
}