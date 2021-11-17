package net.siegerpg.siege.core.miscellaneous

import com.gmail.filoghost.holographicdisplays.api.Hologram
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer
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
import kotlin.math.round


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

	fun getIndicatorText(damage : Double, critical : Boolean) : Component {
		val formatter = when (damage) {
			in 0.0..200.0      -> if (critical) DecimalFormat("<red>-0.#<dark_red>❤") else DecimalFormat(
					"<gray>-0.#<dark_red>❤"
			                                                                                            )
			in 200.0..1000.0   -> if (critical) DecimalFormat("<dark_red>-0.#<dark_red>❤") else DecimalFormat(
					"<dark_gray>-0.#<dark_red>❤"
			                                                                                                 )
			in 1000.0..10000.0 -> if (critical) DecimalFormat("<gold>-0.#<dark_red>❤") else DecimalFormat(
					"<dark_purple>-0.#<dark_red>❤"
			                                                                                             )
			else               -> DecimalFormat(
					"<rainbow:${
						round(Math.random() * 2 - 1).toInt()
					}>0.#</rainbow><dark_red>❤"
			                                   )
		}
		val format = formatter.format(damage)
		return Utils.parse(format)
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
		Core.plugin().hologramsToBeDeleted.add(hologram)
		val component = getIndicatorText(evt.damage, isCritical)
		hologram.appendTextLine(
				Utils.tacc(
						LegacyComponentSerializer.legacySection()
								.serialize(component)
				          )
		                       )
		Bukkit.getScheduler().runTaskLater(Core.plugin(), Runnable {
			hologram.delete()
			Core.plugin().hologramsToBeDeleted.remove(hologram)
		}, 3 * 20L)
	}
}