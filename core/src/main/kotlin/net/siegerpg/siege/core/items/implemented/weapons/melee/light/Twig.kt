package net.siegerpg.siege.core.items.implemented.weapons.melee.light

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Twig() : CustomMeleeWeapon(
    name = "Twig",
    customModelData = 110001,
    description = listOf("A twig found on the ground"),
    levelRequirement = 1,
    material = Material.WOODEN_SWORD,
    baseStats = CustomItemUtils.statMap(strength = 4.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Stick.tier(1))
            s4(Stick.tier(1))
            item { player, b ->
                val newItem = Twig(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s2(Stick.tier(1))
            s5(Stick.tier(1))
            item { player, b ->
                val newItem = Twig(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s3(Stick.tier(1))
            s6(Stick.tier(1))
            item { player, b ->
                val newItem = Twig(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s4(Stick.tier(1))
            s7(Stick.tier(1))
            item { player, b ->
                val newItem = Twig(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s5(Stick.tier(1))
            s8(Stick.tier(1))
            item { player, b ->
                val newItem = Twig(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s6(Stick.tier(1))
            s9(Stick.tier(1))
            item { player, b ->
                val newItem = Twig(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
    },
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