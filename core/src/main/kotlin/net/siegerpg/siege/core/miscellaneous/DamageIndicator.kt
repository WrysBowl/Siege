package net.siegerpg.siege.core.miscellaneous

import com.gmail.filoghost.holographicdisplays.api.HologramsAPI
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer
import net.siegerpg.siege.core.Core
import org.bukkit.Bukkit
import org.bukkit.Location
import java.text.DecimalFormat
import java.util.concurrent.ThreadLocalRandom


object DamageIndicator {


	private fun getIndicatorText(damage : Double, critical : Boolean) : Component {
		val formatted = DecimalFormat("0.#").format(damage)
		val coloured = when (damage) {
			in 0.0..200.0      -> if (critical) "<red>-$formatted<dark_red>❤" else
				"<gray>-$formatted<dark_red>❤"

			in 200.0..1000.0   -> if (critical) "<dark_red>-$formatted<dark_red>❤" else
				"<dark_gray>-$formatted<dark_red>❤"

			in 1000.0..10000.0 -> if (critical) "<gold>-$formatted<dark_red>❤" else
				"<dark_purple>-$formatted<dark_red>❤"

			else               ->
				"<rainbow:${
					(Math.random() * 31).toInt()
				}>-$formatted</rainbow><dark_red>❤"

		}
		return Utils.parse(coloured)
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