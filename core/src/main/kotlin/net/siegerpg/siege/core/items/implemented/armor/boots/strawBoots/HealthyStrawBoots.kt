package net.siegerpg.siege.core.items.implemented.armor.boots.strawBoots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealthyStrawBoots() : CustomBoots(
		name = "Healthy Straw Boots",
		customModelData = 1,
		description = listOf("Crunch, crunch, crunch"),
		levelRequirement = 3,
		material = Material.LEATHER_BOOTS,
		baseStats = CustomItemUtils.statMap(health = 7.0),
		leatherColor = Color.YELLOW,
		gearSetInfo = listOf("Regenerates health quickly")
                                       ) {

	constructor(quality : Int) : this() {
		this.quality = quality
		this.rarity = Rarity.getFromInt(quality)
		this.serialize()
	}

	constructor(item : ItemStack) : this() {
		this.item = item
		deserialize()
	}

}