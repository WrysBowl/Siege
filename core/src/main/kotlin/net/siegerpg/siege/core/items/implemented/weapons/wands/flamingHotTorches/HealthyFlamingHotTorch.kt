package net.siegerpg.siege.core.items.implemented.weapons.wands.flamingHotTorches

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomWand
import net.siegerpg.siege.core.miscellaneous.Levels
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.EntityEffect
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.entity.Entity
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class HealthyFlamingHotTorch() : CustomWand(
		name = "Healthy Flaming Hot Torch",
		customModelData = 140007,
		description = listOf(
				"This weapon was said to have the ability",
				"to generate mass amounts of electricity"
		                    ),
		levelRequirement = 37,
		material = Material.WOODEN_HOE,
		baseStats = CustomItemUtils.statMap(strength = 15.0, luck = 14.0, health = 12.0),

		range = 19,
		red = 255,
		green = 0,
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

		victim.fireTicks = 200

		if (Utils.randTest(25.0)) {
			victim.addPotionEffect(
					PotionEffect(
							PotionEffectType.SLOW,
							40,
							9,
							false,
							false
					            )
			                      )
			victim.playEffect(EntityEffect.RAVAGER_STUNNED)
			player.playSound(victim.location, Sound.ENTITY_FIREWORK_ROCKET_TWINKLE, 1.0f, 1.2f)

		} else {
			player.playSound(victim.location, Sound.BLOCK_CAMPFIRE_CRACKLE, 1.0f, 1.2f)
		}
	}

}