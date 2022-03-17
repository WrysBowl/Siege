package net.siegerpg.siege.core.items.types.sets

import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.CustomItemUtils
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

abstract class GearSet(
		val helmets : List<CustomItem> = listOf(),
		val chestplates : List<CustomItem> = listOf(),
		val leggings : List<CustomItem> = listOf(),
		val boots : List<CustomItem> = listOf(),
		val hand : CustomItem? = null,
		val offHand : CustomItem? = null

		) {

	/*
	Sets are gear pieces that give special effects when worn at the same time
	 */
	companion object {

		val sets : List<GearSet> = listOf(
				SlimeSet()
		                                 )
	}

	private fun getPlayerItems(player : Player) : ArrayList<CustomItem> {
		val playerItems : Array<ItemStack> = player.inventory.armorContents
				.plus(player.inventory.itemInMainHand)
				.plus(player.inventory.itemInOffHand)

		//list of Custom Items
		val customItems : ArrayList<CustomItem> = arrayListOf<CustomItem>()
		for (item in playerItems) {
			customItems.add(CustomItemUtils.getCustomItem(item) ?: continue)
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
			if (hand == it) points++
			if (offHand == it) points++
			if (helmets.contains(it)) points++
			if (chestplates.contains(it)) points++
			if (leggings.contains(it)) points++
			if (boots.contains(it)) points++
		}

		return points >= getRequiredPoints()
	}

	/**
	 * Do the special effect of the set
	 */
	open fun setEffect(player : Player) {
		if (!hasSet(player)) return
	}

	/**
	 * Remove the special effect of the set
	 */
	open fun removeEffect(player : Player) {
		if (hasSet(player)) return
	}

}