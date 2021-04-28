package net.siegerpg.siege.core.items.implemented.weapons.melee.light

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.Stick
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Spade() : CustomMeleeWeapon(
    name = "Spade",
    customModelData = 110003,
    description = listOf("Not a shovel"),
    levelRequirement = 5,
    material = Material.WOODEN_SWORD,
    baseStats = CustomItemUtils.statMap(strength = 13.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Pebble(0)) //tier 2
            s4(Stick(0)) //tier 3
            item { player, b ->
                Spade(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s2(Pebble(0)) //tier 2
            s5(Stick(0)) //tier 3
            item { player, b ->
                Spade(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s3(Pebble(0)) //tier 2
            s6(Stick(0)) //tier 3
            item { player, b ->
                Spade(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s4(Pebble(0)) //tier 2
            s7(Stick(0)) //tier 3
            item { player, b ->
                Spade(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s5(Pebble(0)) //tier 2
            s8(Stick(0)) //tier 3
            item { player, b ->
                Spade(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s6(Pebble(0)) //tier 2
            s9(Stick(0)) //tier 3
            item { player, b ->
                Spade(Utils.randRarity())
            }
        }
    },
    attackSpeed = 1.5
) {

    constructor(quality: Int): this() {
        this.quality = quality
        this.rarity = Rarity.getFromInt(quality)
    }

    constructor(item: ItemStack): this() {
        this.item = item
        deserialize()
    }

}