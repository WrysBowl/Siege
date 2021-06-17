package net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.warHammers

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.MetalScrap
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealthyWarHammer() : CustomMeleeWeapon(
    name = "Healthy War Hammer",
    customModelData = 130007,
    description = listOf("Both ends have proven to be deadly"),
    levelRequirement = 27,
    material = Material.WOODEN_AXE,
    baseStats = CustomItemUtils.statMap(strength = 45.0, health = 10.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(MetalScrap.tier(3))
            s2(Pebble.tier(3))
            s3(Pebble.tier(3))
            s4(Stick.tier(3))
            s5(Stick.tier(3))
            s6(PlantMatter.tier(3))
            s7(PlantMatter.tier(3))
            item { player, b ->
                val newItem = HealthyWarHammer(if (b) 50 else Utils.randRarity())
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