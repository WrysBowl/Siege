package net.siegerpg.siege.core.items.implemented.weapons.wands.slimeSpoofers

import io.lumine.xikage.mythicmobs.MythicMobs
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomWand
import net.siegerpg.siege.core.miscellaneous.Levels
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.entity.Entity
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.inventory.ItemStack

class StrongSlimeSpoofer() : CustomWand(
		name = "Strong Slime Spoofer",
		customModelData = 140004,
		description = listOf("Made from the life force of slimes"),
		levelRequirement = 18,
		material = Material.WOODEN_HOE,
		baseStats = CustomItemUtils.statMap(strength = 15.0, luck = 4.0),

		range = 10,
		red = 153,
		green = 255,
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
		if (!Utils.randTest(50.0)) return

		MythicMobs.inst().apiHelper.spawnMythicMob("Goo", victim.location)
		player.playSound(victim.location, Sound.ENTITY_SLIME_SQUISH_SMALL, 1.0f, 1.2f)
	}

}