package net.siegerpg.siege.core.items.implemented.weapons.wands.hotRods

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomWand
import net.siegerpg.siege.core.miscellaneous.Levels
import org.bukkit.EntityEffect
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.entity.Entity
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.inventory.ItemStack

class ToughHotRod() : CustomWand(
		name = "Tough Hot Rod",
		customModelData = 140009,
		description = listOf(
				"A super heated rod of iron which",
				"can be directed to attackers!"
		                    ),
		levelRequirement = 51,
		material = Material.WOODEN_HOE,
		baseStats = CustomItemUtils.statMap(
				strength = 20.0,
				luck = 6.0,
				defense = 50.0
		                                   ),

		range = 19,
		red = 204,
		green = 51,
		blue = 0,
		damageRadius = 2.0
                                ) {

	constructor(quality : Int) : this() {
		this.quality = quality
		this.rarity = Rarity.getFromInt(quality)
		this.serialize()
	}

	constructor(item : ItemStack) : this() {
		this.item = item
		deserialize()
	}
	override fun onHit(e : EntityDamageByEntityEvent) {
		super.onHit(e)
		val player = (e.damager as Player).player ?: return
		val victim : Entity = e.entity
		if (victim !is LivingEntity) return
		if (this.levelRequirement == null) return
		if (this.levelRequirement > (Levels.blockingGetExpLevel(player)?.first
		                             ?: 0)
		) return

		victim.fireTicks = 300
		victim.playEffect(EntityEffect.VILLAGER_ANGRY)
		player.playSound(victim.location, Sound.BLOCK_CAMPFIRE_CRACKLE, 1.0f, 1.0f)
	}

}