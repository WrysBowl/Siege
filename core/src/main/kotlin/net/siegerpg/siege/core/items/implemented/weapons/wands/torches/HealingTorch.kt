package net.siegerpg.siege.core.items.implemented.weapons.wands.torches

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

class HealingTorch() : CustomWand(
		name = "Healing Torch",
		customModelData = 140006,
		description = listOf("Ancient magic of the ancestors"),
		levelRequirement = 30,
		material = Material.WOODEN_HOE,
		baseStats = CustomItemUtils.statMap(
				strength = 18.0,
				luck = 7.0,
				regeneration = 6.0
		                                   ),

		range = 19,
		red = 255,
		green = 153,
		blue = 51,
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

		victim.fireTicks = 200
		victim.playEffect(EntityEffect.VILLAGER_ANGRY)
		player.playSound(victim.location, Sound.BLOCK_CAMPFIRE_CRACKLE, 1.0f, 1.0f)
	}

}