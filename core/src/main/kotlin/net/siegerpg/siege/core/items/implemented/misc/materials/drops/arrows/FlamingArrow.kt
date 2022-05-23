package net.siegerpg.siege.core.items.implemented.misc.materials.drops.arrows

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomArrow
import net.siegerpg.siege.core.items.types.misc.CustomMaterial
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Entity
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Projectile
import org.bukkit.event.entity.ProjectileHitEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.potion.PotionType

class FlamingArrow() : CustomArrow(
		name = "Flaming Arrow",
		customModelData = 1,
		description = listOf("Burns your target for 5 seconds"),
		levelRequirement = 0,
		material = Material.TIPPED_ARROW,
		potion = PotionType.FIRE_RESISTANCE
                                  ) {
	override fun getSellValue() : Int {
		return 40
	}

	override fun onShoot(e : ProjectileHitEvent) {
		super.onShoot(e)
		if (e.hitEntity !is LivingEntity) return
		val mob : LivingEntity = e.hitEntity as LivingEntity
		mob.fireTicks = 200
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