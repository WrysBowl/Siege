package net.siegerpg.siege.core.items.implemented.misc.potions

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomFood
import net.siegerpg.siege.core.items.types.misc.CustomPotion
import net.siegerpg.siege.core.listeners.CustomItemKotlinListener
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.potion.PotionType
import org.bukkit.scheduler.BukkitRunnable

class BerserkII() : CustomPotion(
		name = "Berserk II",
		customModelData = 820002,
		description = listOf("Deal 75% more damage", "but take 75% more"),
		levelRequirement = 0,
		material = Material.POTION,
		potion = PotionType.STRENGTH,
		quality = 70
                                ) {

	override fun speciality(player : Player) {
		CustomItemKotlinListener().damageMulti[player] = 1.75

		val potion = PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1800, 1)
		player.addPotionEffect(potion)

		object : BukkitRunnable() {
			override fun run() {
				CustomItemKotlinListener().damageMulti.remove(player)
			}
		}.runTaskLater(Core.plugin(), 1800)
	}

	constructor(quality : Int) : this() {
		this.quality = quality
		this.rarity = Rarity.getFromInt(quality)
		this.serialize()
	}

	constructor(item : ItemStack) : this() {
		this.item = item
		this.deserialize()
	}

}