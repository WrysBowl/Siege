package net.siegerpg.siege.core.items.implemented.armor.helmet

import io.lumine.xikage.mythicmobs.MythicMobs
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.miscellaneous.Levels
import org.bukkit.Material
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class BanditCap() : CustomHelmet(
		name = "Bandit's Cap",
		customModelData = 1,
		description = listOf("Bandits freeze for 3", "seconds if they hit you"),
		levelRequirement = 20,
		material = Material.LEATHER_HELMET,
		baseStats = CustomItemUtils.statMap(health = 30.0, defense = 20.0),
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
		val player = (e.entity as Player).player ?: return
		val item = player.inventory.chestplate
		val cusItem = CustomItemUtils.getCustomItem(item) ?: return
		if (cusItem.levelRequirement == null) return
		if (cusItem.levelRequirement!! > (Levels.blockingGetExpLevel(player)?.first
		                                  ?: 0)
		) return
		if (e !is EntityDamageByEntityEvent) return
		val attacker = e.damager
		if (attacker !is LivingEntity) return
		if (!MythicMobs.inst().apiHelper.isMythicMob(e.getEntity())) return
		val mm =
				MythicMobs.inst().apiHelper.getMythicMobInstance(attacker).type.internalName
		if (mm.equals("BanditArcher") || mm.equals("Bandit")) {
			attacker.addPotionEffect(PotionEffect(PotionEffectType.SLOW, 100, 4))
		}
	}
}