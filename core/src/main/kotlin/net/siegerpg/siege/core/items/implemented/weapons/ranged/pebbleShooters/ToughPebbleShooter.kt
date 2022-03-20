package net.siegerpg.siege.core.items.implemented.weapons.ranged.pebbleShooters

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.EntityEffect
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.entity.Item
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Projectile
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityShootBowEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class ToughPebbleShooter() : CustomBow(
		name = "Tough Pebble Shooter",
		customModelData = 120003,
		description = listOf("Now comes with pebble", "shooting support!"),
		levelRequirement = 10,
		material = Material.BOW,
		baseStats = CustomItemUtils.statMap(strength = 18.0, defense = 40.0),
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

	override fun onShoot(e : EntityShootBowEvent) {
		super.onShoot(e)
		val loc : Location = e.projectile.location
		val item : Item = loc.world.dropItem(loc.clone(), Pebble().item)
		e.projectile.addPassenger(item)
	}

	override fun onHit(e : EntityDamageByEntityEvent) {
		super.onHit(e)
		if (e.damager !is Projectile) return
		if (e.entity !is LivingEntity) return

		val victim : LivingEntity = e.entity as LivingEntity

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
			victim.world.playSound(victim.location, Sound.ENTITY_FIREWORK_ROCKET_TWINKLE, 1.0f, 1.2f)

		} else {
			victim.world.playSound(victim.location, Sound.BLOCK_CAMPFIRE_CRACKLE, 1.0f, 1.2f)
		}
	}

}