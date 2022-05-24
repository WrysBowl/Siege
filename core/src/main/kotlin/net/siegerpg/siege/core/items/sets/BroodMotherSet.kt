package net.siegerpg.siege.core.items.sets

import com.destroystokyo.paper.ParticleBuilder
import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.implemented.armor.boots.BoomiesHooves
import net.siegerpg.siege.core.items.implemented.armor.boots.BroodMotherClaws
import net.siegerpg.siege.core.items.implemented.armor.chestplate.BoomiesChestplate
import net.siegerpg.siege.core.items.implemented.armor.chestplate.BroodMotherCloak
import net.siegerpg.siege.core.items.implemented.armor.helmet.BoomiesHorns
import net.siegerpg.siege.core.items.implemented.armor.helmet.BroodMotherCap
import net.siegerpg.siege.core.items.implemented.armor.leggings.BoomiesLeggings
import net.siegerpg.siege.core.items.implemented.armor.leggings.BroodMotherLegs
import net.siegerpg.siege.core.items.implemented.weapons.wands.BroodMotherWand
import net.siegerpg.siege.core.listeners.WandCast
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.core.miscellaneous.particleEffects.Waves
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerToggleSneakEvent
import org.bukkit.material.MaterialData
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.util.Vector

class BroodMotherSet : GearSet(
		helmets = hashSetOf(BroodMotherCap()),
		chestplates = hashSetOf(BroodMotherCloak()),
		leggings = hashSetOf(BroodMotherLegs()),
		boots = hashSetOf(BroodMotherClaws())
                              ) {

	companion object {

		val cooldown : ArrayList<Player> = arrayListOf()
	}

	@EventHandler
	fun onSneak(e : PlayerToggleSneakEvent) {
		val player : Player = e.player
		if (cooldown.contains(player)) return
		val list : List<GearSet> = currentSets[player] ?: listOf()
		if (!Utils.contains(this, list)) return

		//cooldown for 5 seconds
		cooldown.add(player)
		object : BukkitRunnable() {
			override fun run() {
				cooldown.remove(player)
			}
		}.runTaskLater(Core.plugin(), 100)

		val targetLoc = if (player.getTargetBlock(60) == null) {
			val block = player.getTargetBlock(60) ?: return
			block.location
		} else {
			val block = player.getTargetBlock(60) ?: return
			block.location
		}

		val loc =
				player.location.add(0.0, player.eyeHeight, 0.0) //player location
		val fromPlayerToTarget = targetLoc.toVector().subtract(loc.toVector())
		WandCast(
				Core.plugin(),
				BroodMotherWand(),
				player,
				fromPlayerToTarget,
				loc,
				CustomItemUtils.getPlayerStat(player, StatTypes.STRENGTH, BroodMotherWand().getUpdatedItem(false)),
				targetLoc,
				0.06
		        ).runTaskTimer(
				Core.plugin(),
				1,
				0)
	}
}