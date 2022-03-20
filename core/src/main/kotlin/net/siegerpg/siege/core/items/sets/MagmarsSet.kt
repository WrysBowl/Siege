package net.siegerpg.siege.core.items.sets

import com.destroystokyo.paper.event.player.PlayerJumpEvent
import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.implemented.armor.boots.MagmarsTrekkers
import net.siegerpg.siege.core.items.implemented.armor.boots.SlimsBoots
import net.siegerpg.siege.core.items.implemented.armor.boots.SlimyBoots
import net.siegerpg.siege.core.items.implemented.armor.boots.slimyBoots.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.MagmarsChestplate
import net.siegerpg.siege.core.items.implemented.armor.chestplate.SlimsChestplate
import net.siegerpg.siege.core.items.implemented.armor.chestplate.SlimyChestplate
import net.siegerpg.siege.core.items.implemented.armor.chestplate.slimyChestplates.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.MagmarsCrown
import net.siegerpg.siege.core.items.implemented.armor.helmet.SlimsHelmet
import net.siegerpg.siege.core.items.implemented.armor.helmet.SlimyHelmet
import net.siegerpg.siege.core.items.implemented.armor.helmet.slimyHelmets.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.MagmarsLeggings
import net.siegerpg.siege.core.items.implemented.armor.leggings.SlimsLeggings
import net.siegerpg.siege.core.items.implemented.armor.leggings.SlimyLeggings
import net.siegerpg.siege.core.items.implemented.armor.leggings.slimyLeggings.*
import net.siegerpg.siege.core.miscellaneous.Utils
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

class MagmarsSet : GearSet(
		helmets = hashSetOf(MagmarsCrown()),
		chestplates = hashSetOf(MagmarsChestplate()),
		leggings = hashSetOf(MagmarsLeggings()),
		boots = hashSetOf(MagmarsTrekkers())
                          ) {

	@EventHandler
	fun onSneak(e : PlayerToggleSneakEvent) {
		val player : Player = e.player
		val list : List<GearSet> = currentSets[player] ?: listOf()
		if (!Utils.contains(this, list)) return

		Waves().createWaves(player.location, Particle.FLAME)
		object : BukkitRunnable() {
			var counter : Double = 0.0
			val dmg : Double = CustomItemUtils.getPlayerStat(player, StatTypes.STRENGTH)
			override fun run() {
				counter += 0.5
				for(entity in player.location.getNearbyLivingEntities(counter)) {
					if (entity.equals(player)) continue
					entity.damage(dmg/4, player)
					entity.fireTicks = 200
				}
				if (counter >= 10) {
					this.cancel()
					return
				}
			}
		}.runTaskTimer(Core.plugin(), 0, 10)
	}
}