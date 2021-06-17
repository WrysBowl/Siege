package net.siegerpg.siege.core.items.implemented.weapons.melee.heavy

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Club() : CustomMeleeWeapon(
    name = "Club",
    customModelData = 130001,
    description = listOf("A primative weapon composed", "of one big stick"),
    levelRequirement = 3,
    material = Material.WOODEN_AXE,
    baseStats = CustomItemUtils.statMap(strength = 14.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Stick.tier(2))
            s4(Stick.tier(2))
            item { player, b ->
                val newItem = Club(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s2(Stick.tier(2))
            s5(Stick.tier(2))
            item { player, b ->
                val newItem = Club(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s3(Stick.tier(2))
            s6(Stick.tier(2))
            item { player, b ->
                val newItem = Club(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s4(Stick.tier(2))
            s7(Stick.tier(2))
            item { player, b ->
                val newItem = Club(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s5(Stick.tier(2))
            s8(Stick.tier(2))
            item { player, b ->
                val newItem = Club(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s6(Stick.tier(2))
            s9(Stick.tier(2))
            item { player, b ->
                val newItem = Club(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
    },
    attackSpeed = 0.9
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