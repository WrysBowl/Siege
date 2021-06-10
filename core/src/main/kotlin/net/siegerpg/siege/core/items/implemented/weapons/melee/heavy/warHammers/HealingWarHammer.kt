package net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.warHammers

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealingWarHammer() : CustomMeleeWeapon(
    name = "Healing War Hammer",
    customModelData = 130007,
    description = listOf("Both ends have proven to be deadly"),
    levelRequirement = 27,
    material = Material.WOODEN_AXE,
    baseStats = CustomItemUtils.statMap(strength = 46.0, regeneration = 5.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(MetalScrap.tier(3))
            s2(Pebble.tier(3))
            s3(Pebble.tier(3))
            s4(Stick.tier(3))
            s5(Stick.tier(3))
            s6(Wheat.tier(4))
            item { player, b ->
                val newItem = HealingWarHammer(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
    },
    attackSpeed = 0.7
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