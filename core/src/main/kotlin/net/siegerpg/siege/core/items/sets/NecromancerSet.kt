package net.siegerpg.siege.core.items.sets

import com.destroystokyo.paper.event.player.PlayerJumpEvent
import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.implemented.armor.boots.MagmarsTrekkers
import net.siegerpg.siege.core.items.implemented.armor.boots.NecromancerFootpads
import net.siegerpg.siege.core.items.implemented.armor.boots.SlimsBoots
import net.siegerpg.siege.core.items.implemented.armor.boots.SlimyBoots
import net.siegerpg.siege.core.items.implemented.armor.boots.slimyBoots.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.MagmarsChestplate
import net.siegerpg.siege.core.items.implemented.armor.chestplate.NecromancerCloak
import net.siegerpg.siege.core.items.implemented.armor.chestplate.SlimsChestplate
import net.siegerpg.siege.core.items.implemented.armor.chestplate.SlimyChestplate
import net.siegerpg.siege.core.items.implemented.armor.chestplate.slimyChestplates.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.MagmarsCrown
import net.siegerpg.siege.core.items.implemented.armor.helmet.NecromancerHood
import net.siegerpg.siege.core.items.implemented.armor.helmet.SlimsHelmet
import net.siegerpg.siege.core.items.implemented.armor.helmet.SlimyHelmet
import net.siegerpg.siege.core.items.implemented.armor.helmet.slimyHelmets.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.MagmarsLeggings
import net.siegerpg.siege.core.items.implemented.armor.leggings.NecromancerLeggings
import net.siegerpg.siege.core.items.implemented.armor.leggings.SlimsLeggings
import net.siegerpg.siege.core.items.implemented.armor.leggings.SlimyLeggings
import net.siegerpg.siege.core.items.implemented.armor.leggings.slimyLeggings.*
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.core.miscellaneous.cache.PlayerData
import net.siegerpg.siege.core.miscellaneous.particleEffects.Waves
import org.bukkit.Bukkit
import org.bukkit.Particle
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.player.PlayerToggleSneakEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.scheduler.BukkitRunnable

class NecromancerSet : GearSet(
		helmets = hashSetOf(NecromancerHood()),
		chestplates = hashSetOf(NecromancerCloak()),
		leggings = hashSetOf(NecromancerLeggings()),
		boots = hashSetOf(NecromancerFootpads())
                              ) {

	@EventHandler
	fun onHit(e : EntityDamageByEntityEvent) {
		if (e.damager !is Player) return
		if (e.entity !is LivingEntity) return
		if (e.isCancelled) return

		val player : Player = e.damager as Player
		val list : List<GearSet> = currentSets[player] ?: listOf()

		if (!Utils.contains(this, list)) return
		val victim : LivingEntity = e.entity as LivingEntity
		val dmg : Double = CustomItemUtils.getPlayerStat(player, StatTypes.STRENGTH)

		player.addPotionEffect(
				PotionEffect(
						PotionEffectType.SPEED,
						60,
						1,
						false,
						false
				            )
		                      )
		victim.addPotionEffect(
				PotionEffect(
						PotionEffectType.SLOW,
						60,
						1,
						false,
						false
				            )
		                      )

		PlayerData.addHealth(player, (dmg / 4).toInt())
		victim.world.spawnParticle(
				Particle.REDSTONE,
				victim.location.x,
				victim.location.y,
				victim.location.z, 10,
				0.0, 0.0, 0.0, 0.1
		                    )
	}
}