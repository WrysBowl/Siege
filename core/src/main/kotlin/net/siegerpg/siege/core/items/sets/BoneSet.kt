package net.siegerpg.siege.core.items.sets

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.implemented.armor.boots.BoneBoots
import net.siegerpg.siege.core.items.implemented.armor.boots.boneBoots.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.BoneChestplate
import net.siegerpg.siege.core.items.implemented.armor.chestplate.boneChestplates.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.BoneHelmet
import net.siegerpg.siege.core.items.implemented.armor.helmet.boneHelmets.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.BoneLeggings
import net.siegerpg.siege.core.items.implemented.armor.leggings.boneLeggings.*
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
import java.util.HashMap

class BoneSet : GearSet(
		helmets = hashSetOf(
				BoneHelmet(), LuckyBoneHelmet(),
				StrongBoneHelmet(), ToughBoneHelmet(),
				HealthyBoneHelmet(), HealingBoneHelmet()
		                   ),
		chestplates = hashSetOf(
				BoneChestplate(), LuckyBoneChestplate(),
				StrongBoneChestplate(), ToughBoneChestplate(),
				HealthyBoneChestplate(), HealingBoneChestplate()
		                       ),
		leggings = hashSetOf(
				BoneLeggings(), LuckyBoneLeggings(),
				StrongBoneLeggings(), ToughBoneLeggings(),
				HealthyBoneLeggings(), HealingBoneLeggings()
		                    ),
		boots = hashSetOf(
				BoneBoots(), LuckyBoneBoots(),
				StrongBoneBoots(), ToughBoneBoots(),
				HealthyBoneBoots(), HealingBoneBoots()
		                 )
                       ) {

	override fun setEffect(player : Player) : Boolean{
		if (!super.setEffect(player)) return false

		val stats : HashMap<StatTypes, Double> = CustomItemUtils.statAdditions[player] ?: hashMapOf()
		val strength : Double = stats.get(StatTypes.STRENGTH) ?: 0.0
		stats.put(StatTypes.STRENGTH, strength + 40)

		CustomItemUtils.statAdditions.put(player, stats)
		return true
	}

	override fun removeEffect(player : Player) : Boolean {
		if(!super.removeEffect(player)) return false

		val stats : HashMap<StatTypes, Double> = CustomItemUtils.statAdditions[player] ?: hashMapOf()
		val strength : Double = (stats.get(StatTypes.STRENGTH) ?: 40.0) - 40.0
		stats[StatTypes.STRENGTH] = strength

		CustomItemUtils.statAdditions.put(player, stats)
		return true
	}
}