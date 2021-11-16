package net.siegerpg.siege.core.items.implemented.weapons.melee.light.scrapShards

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealingScrapShard() : CustomMeleeWeapon(
	name = "Healing Scrap Shard",
	customModelData = 110008,
	description = listOf("Scrap metal put together", "to create a sharp shank"),
	levelRequirement = 29,
	material = Material.WOODEN_SWORD,
	baseStats = CustomItemUtils.statMap(strength = 27.0, regeneration = 8.0),
	attackSpeed = 1.5
) {

	constructor(quality: Int) : this() {
		this.quality = quality
		this.rarity = Rarity.getFromInt(quality)
		this.serialize()
	}

	constructor(item: ItemStack) : this() {
		this.item = item
		deserialize()
	}

}