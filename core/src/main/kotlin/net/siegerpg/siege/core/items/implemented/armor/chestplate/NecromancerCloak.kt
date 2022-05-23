package net.siegerpg.siege.core.items.implemented.armor.chestplate

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class NecromancerCloak() : CustomChestplate(
		name = "Necromancer's Cloak",
		customModelData = 1,
		description = listOf("The Necromancer is the sixth guardian"),
		levelRequirement = 38,
		material = Material.LEATHER_CHESTPLATE,
		baseStats = CustomItemUtils.statMap(health = 170.0, strength = 40.0, regeneration = -30.0	),
		gearSetInfo = listOf("Life steal and speed"),
		leatherColor = Color.fromRGB(125, 25, 25)
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