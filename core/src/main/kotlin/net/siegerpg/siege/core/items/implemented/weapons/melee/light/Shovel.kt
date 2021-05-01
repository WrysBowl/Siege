package net.siegerpg.siege.core.items.implemented.weapons.melee.light

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Shovel() : CustomMeleeWeapon(
    name = "Shovel",
    customModelData = 110004,
    description = listOf("A true grave digger"),
    levelRequirement = 7,
    material = Material.WOODEN_SWORD,
    baseStats = CustomItemUtils.statMap(strength = 17.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Pebble.tier(2))
            s4(Stick.tier(3))
            s7(Stick.tier(3))
            item { player, b ->
                val newItem = Shovel(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s2(Pebble.tier(2))
            s5(Stick.tier(3))
            s8(Stick.tier(3))
            item { player, b ->
                val newItem = Shovel(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s3(Pebble.tier(2))
            s6(Stick.tier(3))
            s9(Stick.tier(3))
            item { player, b ->
                val newItem = Shovel(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
    },
    attackSpeed = 1.5
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