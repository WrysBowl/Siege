package net.siegerpg.siege.core.miscellaneous

import com.gmail.filoghost.holographicdisplays.api.HologramsAPI
import net.siegerpg.siege.core.Core
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.entity.*
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import java.text.DecimalFormat
import java.util.concurrent.ThreadLocalRandom
import kotlin.math.floor


class DamageIndicator : Listener {

	companion object {

		fun isCritical(damager : LivingEntity) : Boolean {
			return (
					damager.fallDistance > 0.0f &&
					!damager.isInWater &&
					damager.activePotionEffects.none { o : PotionEffect -> o.type == PotionEffectType.BLINDNESS } &&
					damager.vehicle == null && (if (damager is Player) (
							!damager.isSprinting &&
							damager.attackCooldown > 0.9f) else true)
			       )
		}

	}

	fun getIndicatorText(damage : Double, critical : Boolean) : String {
		var formatter = when (damage) {
			in 0.0..200.0      -> if (critical) DecimalFormat("&7-0.#&4❤") else DecimalFormat(
					"&c-0.#&4❤"
			                                                                                 )
			in 200.0..1000.0   -> if (critical) DecimalFormat("&8-0.#&4❤") else DecimalFormat(
					"&4-0.#&4❤"
			                                                                                 )
			in 1000.0..10000.0 -> if (critical) DecimalFormat("&6-0.#&4❤") else DecimalFormat(
					"&5-0.#&4❤"
			                                                                                 )
			else               -> DecimalFormat("0.#")
		}
		val format = formatter.format(damage)
		val colourCodes = "ea231dc6"
		val startingIndex = floor(Math.random() * (colourCodes.length)).toInt()
		if (damage >= 10000) {
			format.mapIndexed { index, c ->
				val sb = StringBuilder()
				sb.append("&")

				sb.append(
						"&" + colourCodes[(startingIndex + index) % colourCodes.length]
				         )
				sb.append(c)
				return sb.toString()
			}
		}
		return format
	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public fun onDamage(evt : EntityDamageByEntityEvent) {
		if (evt.entity !is LivingEntity) return;

		val entity = evt.entity as LivingEntity

		if (entity is ArmorStand) return;


		val random = ThreadLocalRandom.current()

		val isCritical = when (evt.damager) {
			is AbstractArrow -> (evt.damager as AbstractArrow).isCritical
			is Projectile    -> false
			else             -> isCritical(entity)
		}

		var spawnLocation
				: Location
		var attempts = 0
		do {
			attempts++
			spawnLocation = entity.location.add(
					random.nextDouble(0.0, 2.0) - 1.0,
					1.0,
					random.nextDouble(0.0, 2.0) - 1.0
			                                   )
			if (attempts > 20) {
				spawnLocation = entity.location
				break
			}
		} while (!spawnLocation.block.isPassable)


		val hologram = HologramsAPI.createHologram(Core.plugin(), spawnLocation)
		val text = getIndicatorText(evt.damage, isCritical)
		hologram.appendTextLine(Utils.tacc(text))

		Bukkit.getScheduler().runTaskLater(Core.plugin(), Runnable {
			hologram.delete()
		}, 2 * 20L)
	}
}