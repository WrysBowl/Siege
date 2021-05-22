package net.siegerpg.siege.core.items.implemented.misc.wands

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.blocks.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.misc.CustomWand
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class RockWand() : CustomWand(
    name = "Rock Wand",
    customModelData = 140005,
    description = listOf("Nature made rocks to be weaponized"),
    levelRequirement = 15,
    material = Material.WOODEN_HOE,
    baseStats = CustomItemUtils.statMap(strength = 20.0, luck = 6.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Pebble.tier(3))
            s4(Stick.tier(3))
            s7(Stick.tier(3))
            item { player, b ->
                val newItem = RockWand(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s2(Pebble.tier(3))
            s5(Stick.tier(3))
            s8(Stick.tier(3))
            item { player, b ->
                val newItem = RockWand(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s3(Pebble.tier(3))
            s6(Stick.tier(3))
            s9(Stick.tier(3))
            item { player, b ->
                val newItem = RockWand(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
    },
    range = 19,
    red = 140,
    green = 140,
    blue = 140,
    damageRadius = 2.0
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