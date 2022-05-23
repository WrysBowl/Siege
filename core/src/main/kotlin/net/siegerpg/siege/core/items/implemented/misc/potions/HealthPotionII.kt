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

class HealthPotionII() : CustomPotion(
		name = "Health Potion II",
		customModelData = 820001,
		description = listOf("Heals you by +200 HP"),
		levelRequirement = 0,
		material = Material.POTION,
		potion = PotionType.INSTANT_HEAL,
		quality = 50
                                     ) {

	override fun speciality(player : Player) {
		CustomItemUtils.addHealth(player, 200.0)
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