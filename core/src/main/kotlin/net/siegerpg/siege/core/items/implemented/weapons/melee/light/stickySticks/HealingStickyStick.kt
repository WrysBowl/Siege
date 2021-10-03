package net.siegerpg.siege.core.items.implemented.weapons.melee.light.stickySticks

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Slime
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealingStickyStick() : CustomMeleeWeapon(
    name = "Healing Sticky Stick",
    customModelData = 110002,
    description = listOf("Globs of slime on a stick"),
    levelRequirement = 5,
    material = Material.WOODEN_SWORD,
    baseStats = CustomItemUtils.statMap(strength = 5.0, regeneration = 4.0),
    attackSpeed = 1.6
) {

    constructor(quality: Int): this() {
        this.quality = quality
        this.rarity = Rarity.getFromInt(quality)
        this.serialize()
    }

    constructor(item: ItemStack): this() {
        this.item = item
        deserialize()
    }

}