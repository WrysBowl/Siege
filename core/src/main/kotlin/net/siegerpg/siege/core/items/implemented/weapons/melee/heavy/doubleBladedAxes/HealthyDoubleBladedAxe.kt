package net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.doubleBladedAxes

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealthyDoubleBladedAxe() : CustomMeleeWeapon(
    name = "Healthy Double Bladed Axe",
    customModelData = 130005,
    description = listOf("You're really only going to use one side"),
    levelRequirement = 19,
    material = Material.WOODEN_AXE,
    baseStats = CustomItemUtils.statMap(strength = 34.0, health = 6.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Pebble.tier(3))
            s2(Pebble.tier(3))
            s3(Pebble.tier(3))
            s4(Stick.tier(3))
            s5(Stick.tier(3))
            s6(PlantMatter.tier(3))
            s7(PlantMatter.tier(3))
            s8(PlantMatter.tier(3))
            item { player, b ->
                val newItem = HealthyDoubleBladedAxe(if (b) 50 else Utils.randRarity())
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