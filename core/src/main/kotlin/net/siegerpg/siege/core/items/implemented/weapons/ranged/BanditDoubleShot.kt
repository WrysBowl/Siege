package net.siegerpg.siege.core.items.implemented.weapons.ranged

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import net.siegerpg.siege.core.miscellaneous.Levels
import org.bukkit.Material
import org.bukkit.attribute.Attribute
import org.bukkit.entity.*
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.util.Vector

class BanditDoubleShot() : CustomBow(
		name = "Bandit Double Shot",
		customModelData = 120004,
		description = listOf("Shoots another arrow", "after shooting"),
		levelRequirement = 20,
		material = Material.BOW,
		baseStats = CustomItemUtils.statMap(strength = 17.0)
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

	override fun onHit(e : EntityDamageEvent) {
		val victim : Entity = e.entity
		var attacker : Entity? = null
		if (victim !is LivingEntity) return

		if (e is EntityDamageByEntityEvent) {
			attacker =
					if (e.damager is Player) e.damager as Player
					else e.damager
			if (e.damager is Projectile) {
				if ((e.damager as Projectile).shooter is Player) {
					attacker = (e.damager as Projectile).shooter as Player
				}
			}
		}

		if (attacker !is LivingEntity) return;
		val playerDirection : Vector = victim.getLocation().direction
		val arrow : Arrow = attacker.launchProjectile(Arrow::class.java, playerDirection)
		arrow.pickupStatus = AbstractArrow.PickupStatus.DISALLOWED
	}

}