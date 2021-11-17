package net.siegerpg.siege.core.miscellaneous

import com.gmail.filoghost.holographicdisplays.api.HologramsAPI
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer
import net.siegerpg.siege.core.Core
import org.bukkit.Bukkit
import org.bukkit.Location
import java.text.DecimalFormat
import java.util.concurrent.ThreadLocalRandom
import kotlin.math.floor


object DamageIndicator {


	private fun getIndicatorText(damage : Double, critical : Boolean) : Component {
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
						floor(Math.random() * 2).toInt()
					}>0.#</rainbow><dark_red>❤"
			                                   )
		}
		val format = formatter.format(damage)
		return Utils.parse(format)
	}

	public fun showDamageIndicator(
			damage : Double,
			position : Location,
			isCritical : Boolean
	                              ) {

		val random = ThreadLocalRandom.current()


		var spawnLocation
				: Location
		var attempts = 0
		do {
			attempts++
			spawnLocation = position.clone().add(
					random.nextDouble(0.0, 2.0) - 1.0,
					1.0,
					random.nextDouble(0.0, 2.0) - 1.0
			                                    )
			if (attempts > 20) {
				spawnLocation = position
				break
			}
		} while (!spawnLocation.block.isPassable)


		val hologram = HologramsAPI.createHologram(Core.plugin(), spawnLocation)
		Core.plugin().hologramsToBeDeleted.add(hologram)
		val component = getIndicatorText(damage, isCritical)
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