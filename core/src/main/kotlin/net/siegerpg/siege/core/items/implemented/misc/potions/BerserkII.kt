package net.siegerpg.siege.core.items.implemented.misc.potions

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

class BerserkII() : CustomPotion(
		name = "Berserk II",
		customModelData = 820002,
		description = listOf("Deal 75% more damage", "but take 75% more"),
		levelRequirement = 0,
		material = Material.POTION,
		potion = PotionType.STRENGTH
                                ) {

	override fun speciality(player : Player) {
		CustomItemKotlinListener().damageMulti[player] = 1.75
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