package net.siegerpg.siege.core.items.sets

import com.destroystokyo.paper.event.player.PlayerJumpEvent
import net.siegerpg.siege.core.Core
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

		//TODO [BELOW] Send a heat wave of particles outwards, burning anything that touches it
	}
}