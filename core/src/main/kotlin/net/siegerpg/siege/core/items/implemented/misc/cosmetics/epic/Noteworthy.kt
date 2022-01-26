package net.siegerpg.siege.core.items.implemented.misc.cosmetics.epic

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.Cosmetic
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.inventory.ItemStack
import java.util.*

class Noteworthy() : Cosmetic(
		name = "Noteworthy",
		customModelData = 1,
		description = listOf(""),
		material = Material.NOTE_BLOCK,
		quality = 90
                             ) {

	override fun onCosmeticDamage(e : EntityDamageByEntityEvent) {
		val hitPlayer = e.entity as Player
		val notePitch =
				0.5f + Random().nextFloat() * (2.0f - 0.5f) // Random pitch between 0.5f and 2.0f
		hitPlayer.world.playSound(
				hitPlayer.location,
				Sound.BLOCK_NOTE_BLOCK_BELL,
				1.0f,
				notePitch
		                         )
	}

	constructor(quality : Int) : this() {
		this.quality = quality
		this.rarity = Rarity.getFromInt(quality)
		this.serialize()
	}

	constructor(item : ItemStack) : this() {
		this.item = item
		deserialize()
	}

}