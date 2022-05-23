package net.siegerpg.siege.core.items.sets

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.miscellaneous.Levels
import net.siegerpg.siege.core.miscellaneous.Levels.blockingGetExpLevel
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.event.Listener
import org.bukkit.inventory.ItemStack
import org.bukkit.scheduler.BukkitRunnable

abstract class GearSet(
		val helmets : HashSet<CustomItem> = hashSetOf(),
		val chestplates : HashSet<CustomItem> = hashSetOf(),
		val leggings : HashSet<CustomItem> = hashSetOf(),
		val boots : HashSet<CustomItem> = hashSetOf(),
		val hand : CustomItem? = null,
		val offHand : CustomItem? = null

                      ) : Listener {

	/*
	Sets are gear pieces that give special effects when worn at the same time
	 */
	companion object {
		//in updateMeta check if item is contained in a gear set

		val sets : List<GearSet> = listOf(
				SlimeSet(), StrawSet(), MagmaSet(), SlimsSet(), MagmarsSet(),
				BoomiesSet(), BoneSet(), LichSet(), DavySet(), FoxySet(), BroodMotherSet()
		                                 )
		var currentSets : HashMap<Player, List<GearSet>> = hashMapOf()
	}

	private fun getPlayerItems(player : Player) : ArrayList<CustomItem> {
		val playerItems : Array<ItemStack> = player.inventory.armorContents
				.plus(player.inventory.itemInMainHand)
				.plus(player.inventory.itemInOffHand)

		val lvl = blockingGetExpLevel(player) ?: Pair((1.toShort()), 0)

		//list of Custom Items
		val customItems : ArrayList<CustomItem> = arrayListOf<CustomItem>()
		for (item in playerItems) {
			val newItem : CustomItem = CustomItemUtils.getCustomItem(item) ?: continue
			if (newItem.levelRequirement!! > lvl.first) continue
			customItems.add(newItem)
		}
		return customItems
	}

	private fun getRequiredPoints() : Int {
		var points : Int = 0
		if (helmets.isNotEmpty()) points++
		if (chestplates.isNotEmpty()) points++
		if (leggings.isNotEmpty()) points++
		if (boots.isNotEmpty()) points++
		if (hand != null) points++
		if (offHand != null) points++
		return points
	}

	/**
	 * Check if a player is wearing a set
	 */
	private fun hasSet(player : Player) : Boolean {

		val customArmor : ArrayList<CustomItem> = getPlayerItems(player)

		//get the amount of 'points' required to complete a set
		var points = 0

		customArmor.forEach {
			if (it.javaClass == hand?.javaClass) points++
			if (it.javaClass == offHand?.javaClass) points++
			if (Utils.contains(it, helmets)) points++
			if (Utils.contains(it, chestplates)) points++
			if (Utils.contains(it, leggings)) points++
			if (Utils.contains(it, boots)) points++
		}

		return points >= getRequiredPoints()
	}

	/**
	 * Do the special effect of the set
	 */
	open fun setEffect(player : Player) : Boolean {
		if (!hasSet(player)) return false
		val list : List<GearSet> = currentSets[player] ?: listOf()
		if (list.contains(this)) return false

		val set : List<GearSet> = currentSets[player]?.plus(this) ?: listOf(this)

		currentSets[player] = set

		object : BukkitRunnable() {
			override fun run() {
				player.spawnParticle(
						Particle.CRIMSON_SPORE,
						player.location.x,
						player.location.y+1,
						player.location.z, 20, 0.0, 0.0, 0.0, 0.05
				                    )
				player.playSound(
						player.location,
						Sound.BLOCK_ENCHANTMENT_TABLE_USE,
						1.0f,
						1.3f
				                )
			}

		}.runTaskLater(Core.plugin(), 5)


		return true

	}

	/**
	 * Remove the special effect of the set
	 */
	open fun removeEffect(player : Player) : Boolean {
		if (hasSet(player)) return false
		val list : List<GearSet> = currentSets[player] ?: listOf()
		if (!list.contains(this)) return false

		val set : List<GearSet> = currentSets[player]?.minus(this) ?: listOf()

		if (set.isEmpty()) {
			currentSets.remove(player)
		} else {
			currentSets[player] = set
		}

		object : BukkitRunnable() {
			override fun run() {
				player.spawnParticle(
						Particle.WARPED_SPORE,
						player.location.x,
						player.location.y+1,
						player.location.z, 20, 0.0, 0.0, 0.0, 0.05
				                    )
				player.playSound(
						player.location,
						Sound.BLOCK_GRINDSTONE_USE,
						0.8f,
						1.1f
				                )
			}

		}.runTaskLater(Core.plugin(), 5)

		return true
	}

}