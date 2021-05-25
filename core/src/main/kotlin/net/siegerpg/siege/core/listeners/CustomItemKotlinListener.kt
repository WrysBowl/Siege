package net.siegerpg.siege.core.listeners

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.Core.plugin
import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.types.misc.CustomFood
import net.siegerpg.siege.core.items.types.misc.CustomWand
import net.siegerpg.siege.core.items.types.subtypes.CustomEquipment
import net.siegerpg.siege.core.items.types.subtypes.CustomWeapon
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
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.EntityRegainHealthEvent
import org.bukkit.event.entity.ProjectileHitEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerItemConsumeEvent
import org.bukkit.event.player.PlayerItemHeldEvent
import org.bukkit.event.player.PlayerSwapHandItemsEvent
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.scheduler.BukkitTask
import kotlin.math.cos
import kotlin.math.sin


class CustomItemKotlinListener : Listener, Runnable {

    var cooldownWand: MutableList<Player> = mutableListOf()
    var cooldownFood: MutableList<Player> = mutableListOf()


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

        if (e.isCancelled) return
        val victim = e.entity as LivingEntity
        var attacker =
            if (e.damager is Player) e.damager as Player
            else e.damager
        if (e.damager is Projectile) {
            if ((e.damager as Projectile).shooter is Player) {
                attacker = (e.damager as Projectile).shooter as Player
            }
        }
        val damage = e.damage
        var actualDamage = e.damage
        var maxDamage =
            if (attacker is Player)
                attacker.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE)?.value as Double
            else damage

        if (attacker is Player) {
            val item = CustomItemUtils.getCustomItem(attacker.inventory.itemInMainHand)
            if (item == null) {
                e.damage = 1.0
                return
            }
            val levelReq = item.levelRequirement
            if (levelReq == null) {
                e.damage = 1.0
                return
            }
            if (levelReq > Levels.getExpLevel(attacker).first) {
                e.damager.sendActionBar(Utils.parse("<red>You're too weak to use this weapon"))
                e.damage = 1.0
                return
            }



            if (item is CustomBow) {
                if (e.cause == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
                    e.damage = 1.0
                    return
                }
                maxDamage = 6.0
                actualDamage = CustomItemUtils.getPlayerStat(attacker, StatTypes.STRENGTH)
            } else if (item is CustomWand) {
                maxDamage = damage
            }
            //If the item is an axe/sword and the damage cause is melee attack then set correct damage
            if (item is CustomMeleeWeapon && e.cause == EntityDamageEvent.DamageCause.ENTITY_ATTACK){
                actualDamage = CustomItemUtils.getPlayerStat(attacker, StatTypes.STRENGTH)
            }
            if (damage > 1.5 && maxDamage <= 1) {
                maxDamage = damage
                actualDamage = damage
            }
        }

        val vicHealthStat =
            if (victim is Player) CustomItemUtils.getPlayerStat(victim, StatTypes.HEALTH) + victim.maxHealth + (victim.level*2)
            else victim.maxHealth
        val vicToughness =
            if (victim is Player) CustomItemUtils.getPlayerStat(victim, StatTypes.TOUGHNESS)
            else 0.0
        val attStrengthStat =
            if (attacker is Player && actualDamage > 0)
                (damage/maxDamage) * actualDamage //if player spam clicks it won't deal max damage
            else damage
        val reducedDamage = attStrengthStat * (1 - (vicToughness/1000)) //custom attack damage with toughness considered
        e.damage = (reducedDamage * victim.maxHealth)/vicHealthStat //scaled down to damage player by vanilla damage
    }

    @EventHandler
    @Suppress("unused")
    fun onConsume(e: PlayerItemConsumeEvent) {
        CustomItemUtils.getCustomItem(e.item)?.let {
            if (it is CustomFood) {
                it.onEat(e)
            }
        }
    }

    @EventHandler
    fun onFoodClick(e: PlayerInteractEvent) {
        if (e.action != Action.RIGHT_CLICK_AIR &&
            e.action != Action.RIGHT_CLICK_BLOCK
        ) return
        CustomItemUtils.getCustomItem(e.player.itemInHand)?.let {
            if (it is CustomFood) {
                val player: Player = e.player
                if (cooldownFood.contains(player)) {
                    player.sendActionBar(Utils.parse("<red>You're too full!"))
                    return
                }
                cooldownFood.add(player)
                it.onEat(e)
                e.player.itemInHand.amount = e.player.itemInHand.amount-1
                object : BukkitRunnable() {
                    override fun run() {
                        cooldownFood.remove(player)
                    }
                }.runTaskLater(plugin(), 50)
            }
        }

    }


    @EventHandler
    @Suppress("unused")
    fun onFoodHold(e: PlayerItemHeldEvent) {
        if (e.player.foodLevel < 19) return
        val food = CustomItemUtils.getCustomItem(e.player.inventory.getItem(e.newSlot))
        if (food != null) {
            if (food is CustomFood) {
                if (e.player.foodLevel == 20) e.player.foodLevel = 19
                else e.player.foodLevel = 20
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
        if (event.action != Action.LEFT_CLICK_AIR &&
            event.action != Action.LEFT_CLICK_BLOCK
        ) return
        val player = event.player
        val item = player.inventory.itemInMainHand

        CustomItemUtils.getCustomItem(item)?.let {
            if (it is CustomWand) {

                var dmg = it.baseStats[StatTypes.STRENGTH]!! + player.level
                if (player.level < CustomItemUtils.getCustomItem(item)?.levelRequirement!!) dmg = 1.0

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
                }.runTaskLater(plugin(), 30)


                val loc = player.location.add(0.0, player.eyeHeight, 0.0) //player location
                val fromPlayerToTarget = targetLoc.toVector().subtract(loc.toVector())
                WandCast(plugin(), it, player, fromPlayerToTarget, loc, dmg, targetLoc, 0.06).runTaskTimer(plugin(), 1, 0)
            }
        }
    }

    override fun run() {
        TODO("Not yet implemented")
    }
}