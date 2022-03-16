package net.siegerpg.siege.core.listeners

import net.siegerpg.siege.core.Core.plugin
import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.CustomItemUtils.getPlayerStat
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.types.misc.CustomFood
import net.siegerpg.siege.core.items.types.misc.CustomPotion
import net.siegerpg.siege.core.items.types.misc.CustomSkill
import net.siegerpg.siege.core.items.types.subtypes.CustomArmor
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.items.types.weapons.CustomWand
import net.siegerpg.siege.core.miscellaneous.DamageIndicator
import net.siegerpg.siege.core.miscellaneous.Levels
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.core.miscellaneous.cache.ActiveMobs
import net.siegerpg.siege.core.miscellaneous.cache.PlayerData
import org.bukkit.Material
import org.bukkit.Particle
import org.bukkit.attribute.Attribute
import org.bukkit.entity.*
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.entity.*
import org.bukkit.event.player.*
import org.bukkit.inventory.ItemStack
import org.bukkit.scheduler.BukkitRunnable
import java.math.BigDecimal
import kotlin.math.abs
import kotlin.math.sqrt


class CustomItemKotlinListener : Listener {

	companion object {

		fun calcReducedToughness(initToughness : Double) : Double {
			var multiplier = 1
			if (initToughness < 0.0) multiplier = -1
			return multiplier * (10.0 * sqrt(5.0 * abs(initToughness)))
		}
	}

	var cooldownWand : MutableList<Player> = mutableListOf()
	var damageMulti : HashMap<Player, Double> = hashMapOf()


	@EventHandler
	@Suppress("UNUSED_PARAMETER")
	fun onRegen(e : EntityRegainHealthEvent) {

		if (e.regainReason == EntityRegainHealthEvent.RegainReason.REGEN && e.entity is Player) {
			val player : Player = e.entity as Player
			val regen : Double =
					CustomItemUtils.getPlayerStat(player, StatTypes.REGENERATION)

			e.amount *= regen / 5
		}
	}

	@EventHandler
	fun onBowUse(e : ProjectileHitEvent) {
		if (e.entity is Arrow) {
			e.entity.remove()
		}
	}

	@EventHandler
	fun onSkillUse(e : PlayerInteractEvent) {
		val player : Player = e.player
		val item : ItemStack = player.inventory.itemInMainHand
		val customItem : CustomItem = CustomItemUtils.getCustomItem(item) ?: return
		if (customItem !is CustomSkill) return;
		customItem.skillUse(e)
	}

	@EventHandler(priority = EventPriority.LOWEST)
	@Suppress("unused")
	fun onHit(e : EntityDamageEvent) {
		if (e.isCancelled) return
		if (e.entity !is LivingEntity) return
		val victim = e.entity as LivingEntity
		val damage = e.damage
		var actualDamage = e.damage
		var maxDamage = damage
		var attacker : Entity? = null
		var item : CustomItem? = null
		val vicMaxHealth = victim.getAttribute(Attribute.GENERIC_MAX_HEALTH)!!.value
		if (e is EntityDamageByEntityEvent) {
			attacker =
					if (e.damager is Player) e.damager as Player
					else e.damager
			if (e.damager is Projectile) {
				if ((e.damager as Projectile).shooter is Player) {
					attacker = (e.damager as Projectile).shooter as Player
				}
			}
			if (attacker is Player) {
				maxDamage = attacker.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE)?.value as Double

				//Check for if player is using a trident to attack
				var itemStack : ItemStack = attacker.inventory.itemInMainHand
				if (e.damager is Trident) {
					itemStack = (e.damager as Trident).item
				}
				item = CustomItemUtils.getCustomItem(itemStack)


			}
		}
		if (attacker is Player) {
			if (item == null) {
				e.damage = 1.0
				setVictimName(victim, e.damage, vicMaxHealth)
				return
			}
			val levelReq = item.levelRequirement ?: -1
			if (levelReq > (Levels.blockingGetExpLevel(attacker)?.first ?: 0)) {
				attacker.sendActionBar(Utils.parse("<red>You're too weak to use this weapon"))
				e.damage = 1.0
				setVictimName(victim, e.damage, vicMaxHealth)
				return
			}
			if (item is CustomBow) {

				if (item.item.type != Material.TRIDENT) {
					if (e.cause == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
						e.damage = 1.0
						setVictimName(victim, e.damage, vicMaxHealth)
						return
					}
				}

				maxDamage = 7.25
				actualDamage = CustomItemUtils.getPlayerStat(attacker, StatTypes.STRENGTH)
			} else if (item is CustomWand) {
				maxDamage = damage
			} else if (item is CustomSkill) {
				maxDamage = 1.0
			}
			//If the item is an axe/sword and the damage cause is melee attack then set correct damage
			if (item is CustomMeleeWeapon && e.cause == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
				actualDamage = CustomItemUtils.getPlayerStat(attacker, StatTypes.STRENGTH)

				if ((damage / maxDamage) > 1) {
					if (item.item.type.equals(Material.WOODEN_AXE)) {
						maxDamage = 0.65
					} else {
						maxDamage = 0.85
					}
				} //less maxDamage = more damage (damage/maxDamage)
			}
			if (damage > 1.5 && maxDamage <= 1) {
				maxDamage = damage
				actualDamage = damage
			}

			/*
				Check for weapon skill from player's hand
			 */
			item.let {
				if (it is CustomMeleeWeapon) {
					it.onHit(e)
				}
			}

			victim.world.spawnParticle(Particle.SWEEP_ATTACK, victim.location, 1)
		}

		/*
			Check for armor skill from player's armor
		 */
		if (victim is Player) {
			val armor = victim.inventory.armorContents
			if (armor.isNullOrEmpty()) return
			armor.forEach { armorPiece ->
				val armorCustomItem : CustomItem? =
						CustomItemUtils.getCustomItem(armorPiece)
				armorCustomItem?.let {
					if (it is CustomArmor) {
						it.onHit(e)
					}
				}
			}
		}

		if (damageMulti[attacker] != null) {
			actualDamage = damageMulti[attacker]?.times(actualDamage) ?: actualDamage
		}
		val vicDefense =
				if (victim is Player)
					CustomItemUtils.getPlayerStat(
							victim,
							StatTypes.DEFENSE
					                             ) / (damageMulti[victim] ?: 1.0)
				else 0.0
		val attStrengthStat =
				if (attacker is Player && actualDamage > 0)
					(damage / maxDamage) * actualDamage //if player spam clicks it won't deal max damage
				else damage
		val reducedDamage =
				attStrengthStat * (1 - (calcReducedToughness(vicDefense) / 1000)) //custom attack damage with toughness considered

		//add luck
		if (attacker is Player) {
			val luck = getPlayerStat(attacker, StatTypes.LUCK, attacker.inventory.itemInMainHand)
			ActiveMobs.addLuck(victim, reducedDamage, luck)
		}

		e.damage = reducedDamage //scaled down to damage player by vanilla damage
		val isCritical = damage > maxDamage
		setVictimName(victim, e.damage, vicMaxHealth)
		if (victim is Mob) DamageIndicator.showDamageIndicator(reducedDamage, victim.location, isCritical)
	}

	private fun setVictimName(
			victim : LivingEntity,
			damage : Double,
			vicMaxHealth : Double
	                         ) {

		if (victim !is Mob) return

		//change the mob's displayed health
		val displayName : String = ActiveMobs.mobNames[victim] ?: return

		//calculates displayed mob health
		val mobHealth : BigDecimal = BigDecimal.valueOf(victim.health - damage)

		//sets displayed mob's health
		victim.customName = Utils.tacc(
				"$displayName &a${Utils.round(mobHealth.toDouble(), 2)}&2/&a${
					Utils.round(
							vicMaxHealth,
							1
					           )
				}"
		                              )
	}

	@EventHandler
	@Suppress("unused")
	fun onConsume(e : PlayerItemConsumeEvent) {
		object : BukkitRunnable() {
			override fun run() {
				val item : CustomItem = CustomItemUtils.getCustomItem(e.item) ?: return
				if (item is CustomFood) {
					item.onEat(e)
				} else if (item is CustomPotion) {
					item.onConsume(e)
				}
			}
		}.runTaskAsynchronously(plugin())
	}


	@EventHandler
	@Suppress("unused")
	fun onFoodHold(e : PlayerItemHeldEvent) {
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
	fun onInteract(event : PlayerInteractEvent) {
		if (event.action != Action.LEFT_CLICK_AIR &&
		    event.action != Action.LEFT_CLICK_BLOCK
		) return
		val player = event.player
		val item = player.inventory.itemInMainHand

		CustomItemUtils.getCustomItem(item)?.let {
			if (it is CustomWand) {
				var dmg = CustomItemUtils.getPlayerStat(player, StatTypes.STRENGTH, item)

				if (player.level < CustomItemUtils.getCustomItem(item)?.levelRequirement!!) dmg =
						1.0

				//MAKE THIS EFFICIENT
				val targetLoc = if (player.getTargetBlock(it.range) == null) {
					val block = player.getTargetBlock(it.range) ?: return
					block.location
				} else {
					val block = player.getTargetBlock(it.range) ?: return
					block.location
				}

				if (cooldownWand.contains(player)) {
					return
				}
				cooldownWand.add(player)
				object : BukkitRunnable() {
					override fun run() {
						cooldownWand.remove(player)
					}
				}.runTaskLater(plugin(), 30)

				// Checks if the player has enough mana
				val manaCost : Int = it.getManaCost()
				val playerMana = PlayerData.playerCurrentMana[player]
				if (playerMana == null || playerMana < manaCost) {
					player.sendMessage(Utils.lore("<red>You do not have enough mana to cast this wand."))
					return
				}
				// Removes the mana from the user
				PlayerData.playerCurrentMana[player] =
						playerMana - manaCost

				val loc =
						player.location.add(0.0, player.eyeHeight, 0.0) //player location
				val fromPlayerToTarget = targetLoc.toVector().subtract(loc.toVector())
				WandCast(
						plugin(),
						it,
						player,
						fromPlayerToTarget,
						loc,
						dmg,
						targetLoc,
						0.06
				        ).runTaskTimer(
						plugin(),
						1,
						0
				                      )
			}
		}
	}
}