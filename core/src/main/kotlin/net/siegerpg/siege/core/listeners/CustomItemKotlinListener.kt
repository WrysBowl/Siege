package net.siegerpg.siege.core.listeners

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.Core.plugin
import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.CustomItemUtils.getCustomItem
import net.siegerpg.siege.core.items.CustomItemUtils.getPlayerStat
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.types.misc.CustomArrow
import net.siegerpg.siege.core.items.types.misc.CustomFood
import net.siegerpg.siege.core.items.types.misc.CustomPotion
import net.siegerpg.siege.core.items.types.misc.CustomSkill
import net.siegerpg.siege.core.items.types.subtypes.CustomEquipment
import net.siegerpg.siege.core.items.types.subtypes.CustomWeapon
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
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.event.player.*
import org.bukkit.inventory.ItemStack
import org.bukkit.metadata.FixedMetadataValue
import org.bukkit.potion.PotionEffectType
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

		var currentlyUsingWand : MutableList<Player> = mutableListOf()
		var cooldownWand : MutableList<Player> = mutableListOf()
		var damageMulti : HashMap<Player, Double> = hashMapOf()
		var lastShotArrow : HashMap<Player, ItemStack> = hashMapOf()

		fun removeDamageMulti(damage : Double, player : Player) {
			var newDamage = damageMulti[player] ?: 1.0
			newDamage -= damage
			setDamageMulti(newDamage, player)

		}

		fun addDamageMulti(damage : Double, player : Player) {
			var newDamage = damageMulti[player] ?: 1.0
			newDamage += damage
			setDamageMulti(newDamage, player)
		}

		fun setDamageMulti(damage : Double, player : Player) {
			damageMulti[player] = damage
		}
	}

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
		if (e.entity !is Arrow) return
		e.entity.remove()

		if (e.entity.shooter !is Player) return
		val player : Player = e.entity.shooter as Player

		lastShotArrow[player]?.let {
			if (it.type == Material.AIR) return
			val item : CustomItem = CustomItemUtils.getCustomItem(it) ?: return@let
			if (item is CustomArrow) {
				item.onShoot(e)
			}
		}
	}

	@EventHandler
	fun onShootEvent(e : EntityShootBowEvent) {
		if (e.entity !is Player) return
		val player : Player = e.entity as Player

		player.inventory.itemInMainHand.let {
			if (it is CustomWeapon) {
				it.onShoot(e)
			}
		}

		Utils.getArrowStack(player).let {
			val item : CustomItem = CustomItemUtils.getCustomItem(it) ?: return@let
			if (item is CustomArrow) {
				item.onShoot(e)
				lastShotArrow[player] = it
			}
		}

	}

	@EventHandler
	fun updateItemEachHit(e : InventoryCloseEvent) {
		val player = e.player
		val item = player.inventory.itemInMainHand
		if (item.type == Material.AIR) return
		if (item.type == Material.TRIDENT) return

		val customItem = getCustomItem(item) ?: return
		player.inventory.setItemInMainHand(customItem.getUpdatedItem(false))
	}

	@EventHandler
	fun updateItemEachHit(e : PlayerSwapHandItemsEvent) {
		e.isCancelled = true
	}

	@EventHandler
	fun onInteractEvent(e : PlayerInteractEvent) {
		e.player.inventory.armorContents.forEach {
			if (it is CustomEquipment) {
				it.onInteract(e)
			}
		}
		e.player.inventory.itemInMainHand.let {
			if (it is CustomWeapon) {
				it.onInteract(e)
			}
		}

	}

	@EventHandler
	fun onSneakEvent(e : PlayerToggleSneakEvent) {
		e.player.inventory.armorContents.forEach {
			if (it is CustomEquipment) {
				it.onSneak(e)
			}
		}
		e.player.inventory.itemInMainHand.let {
			if (it is CustomEquipment) {
				it.onSneak(e)
			}
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

	@EventHandler
	fun onBowShoot(e : EntityShootBowEvent) {
		e.projectile.setMetadata("cooldown", FixedMetadataValue(plugin(), e.force))
	}


	@EventHandler(priority = EventPriority.LOWEST)
	@Suppress("unused")
	fun onHit(e : EntityDamageEvent) {
		if (e.isCancelled) return
		if (e.entity !is LivingEntity) return
		val victim = e.entity as LivingEntity
		if (victim.hasMetadata("NPC")) return

		var damage = e.damage //changed if player is the damager
		var attacker : Entity? = null
		var item : CustomItem? = null
		var isCritical : Boolean = false
		val vicMaxHealth = victim.getAttribute(Attribute.GENERIC_MAX_HEALTH)!!.value


		/*
			Check if an entity was damaged by an entity
		 */
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

				//get the player's item
				var itemStack : ItemStack = attacker.inventory.itemInMainHand
				if (e.damager is Trident) {
					itemStack = (e.damager as Trident).item
				}
				item = CustomItemUtils.getCustomItem(itemStack)

				//check the level requirement of the item
				if (item != null) {
					val levelReq = item.levelRequirement ?: -1
					if (levelReq > (Levels.blockingGetExpLevel(attacker)?.first ?: 0)) {
						attacker.sendActionBar(Utils.parse("<red>You're too weak to use this weapon"))
						e.damage = 1.0
						setVictimName(victim, e.damage, vicMaxHealth)
						return
					}
				}

				//remove player from wand list
				if (currentlyUsingWand.contains(attacker)) {
					currentlyUsingWand.remove(attacker)
				} else {
					//set the damage from the player
					val playerStrength : Double =
							getPlayerStat(attacker, StatTypes.STRENGTH)
					var cooldown = attacker.attackCooldown
					val flag =
							attacker.getFallDistance() > 0.0f &&
							!attacker.isOnGround() &&
							!attacker.hasPotionEffect(PotionEffectType.BLINDNESS) &&
							attacker.getVehicle() == null

					if (e.damager is Projectile) {
						try {
							cooldown = e.damager.getMetadata("cooldown").get(0).asFloat()
							if (cooldown == 1.0F) isCritical = true;
						} catch (x : Exception) {
							throw Error(x)
						}

					}

					//damage multiplication if crit || cooldowns
					damage = playerStrength * cooldown
					if (flag && item != null) {
						var multiplier = 1.5
						if (item is CustomBow) {
							multiplier = 2.0
						} else if (item is CustomMeleeWeapon) {
							val attackSpeed = item.attackSpeed
							if (attackSpeed > 1.0) { //medium+ speed
								multiplier = 1.25
							} else {
								multiplier = 2.5
							}
						}
						damage *= multiplier
						isCritical = true
					}
				}
			}
		}

		if (attacker is Player && item != null) {
			//to prevent players from melee damaging mobs with a bow
			if (item.item.type != Material.TRIDENT && item is CustomBow) {
				if (e.cause == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
					e.damage = 1.0
					setVictimName(victim, e.damage, vicMaxHealth)
					return
				}
			}
			item.let {
				if (it is CustomEquipment) {
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
					if (it is CustomEquipment) {
						it.onHit(e)
					}
				}
			}
		}


		//apply damage multiplier
		if (damageMulti[attacker] != null) {
			damage = damageMulti[attacker]?.times(damage) ?: damage
		}

		val vicDefense =
				if (victim is Player)
					CustomItemUtils.getPlayerStat(
							victim,
							StatTypes.DEFENSE
					                             ) / (damageMulti[victim] ?: 1.0)
				else 0.0
		val reducedDamage =
				damage * (1 - (calcReducedToughness(vicDefense) / 1000)) //custom attack damage with toughness considered

		//add luck
		if (attacker is Player) {
			val luck =
					getPlayerStat(
							attacker,
							StatTypes.LUCK,
							attacker.inventory.itemInMainHand
					             )
			ActiveMobs.addLuck(victim, reducedDamage, luck)
		}

		e.damage = reducedDamage //scaled down to damage player by vanilla damage
		setVictimName(victim, e.damage, vicMaxHealth)
		if (victim is Mob) DamageIndicator.showDamageIndicator(
				reducedDamage,
				victim.location,
				isCritical
		                                                      )
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

				item.let {
					if (it is CustomWeapon) {
						it.onWandCast()
					}
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