package net.siegerpg.siege.core.items.implemented.weapons.melee.heavy

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.Stick
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Club() : CustomMeleeWeapon(
    name = "Club",
    customModelData = 130001,
    description = listOf("A primative weapon composed of one big stick"),
    levelRequirement = 3,
    material = Material.WOODEN_AXE,
    baseStats = CustomItemUtils.statMap(strength = 14.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Stick(0)) //tier 2
            s4(Stick(0)) //tier 2
            item { player, b ->
                Club(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s2(Stick(0)) //tier 2
            s5(Stick(0)) //tier 2
            item { player, b ->
                Club(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s3(Stick(0)) //tier 2
            s6(Stick(0)) //tier 2
            item { player, b ->
                Club(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s4(Stick(0)) //tier 2
            s7(Stick(0)) //tier 2
            item { player, b ->
                Club(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s5(Stick(0)) //tier 2
            s8(Stick(0)) //tier 2
            item { player, b ->
                Club(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s6(Stick(0)) //tier 2
            s9(Stick(0)) //tier 2
            item { player, b ->
                Club(Utils.randRarity())
            }
        }
    },
    attackSpeed = 0.9
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