package net.siegerpg.siege.core.items.implemented.misc.potions

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomFood
import net.siegerpg.siege.core.items.types.misc.CustomPotion
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.potion.PotionType

class HealthPotionI() : CustomPotion(
		name = "Health Potion I",
		customModelData = 810001,
		description = listOf("Heals you by a small amount"),
		levelRequirement = 0,
		material = Material.POTION,
		potion = PotionType.INSTANT_HEAL
                                    ) {

	override fun speciality(player : Player) {
		CustomItemUtils.addHealth(player, 100.0)
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