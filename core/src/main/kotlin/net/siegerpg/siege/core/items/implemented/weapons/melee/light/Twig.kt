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
            s1(Stick(0)) //tier 1
            s4(Stick(0)) //tier 1
            item { player, b ->
                Twig(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s2(Stick(0)) //tier 1
            s5(Stick(0)) //tier 1
            item { player, b ->
                Twig(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s3(Stick(0)) //tier 1
            s6(Stick(0)) //tier 1
            item { player, b ->
                Twig(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s4(Stick(0)) //tier 1
            s7(Stick(0)) //tier 1
            item { player, b ->
                Twig(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s5(Stick(0)) //tier 1
            s8(Stick(0)) //tier 1
            item { player, b ->
                Twig(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s6(Stick(0)) //tier 1
            s9(Stick(0)) //tier 1
            item { player, b ->
                Twig(Utils.randRarity())
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