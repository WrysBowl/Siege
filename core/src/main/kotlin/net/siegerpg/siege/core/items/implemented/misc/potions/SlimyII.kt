package net.siegerpg.siege.core.items.implemented.misc.potions

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomFood
import net.siegerpg.siege.core.items.types.misc.CustomPotion
import net.siegerpg.siege.core.listeners.CustomItemKotlinListener
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.potion.PotionType
import org.bukkit.scheduler.BukkitRunnable

class SlimyII() : CustomPotion(
		name = "Slimy II",
		customModelData = 820007,
		description = listOf("Jump II potion effect"),
		levelRequirement = 0,
		material = Material.POTION,
		potion = PotionType.JUMP
                              ) {

	override fun speciality(player : Player) {
		val potion = PotionEffect(PotionEffectType.JUMP, 1800, 1)
		player.addPotionEffect(potion)
	}

	constructor(quality : Int) : this() {
		this.quality = 0
		this.rarity = Rarity.COMMON
		this.serialize()
	}

	constructor(item : ItemStack) : this() {
		this.item = item
		this.deserialize()
	}

}