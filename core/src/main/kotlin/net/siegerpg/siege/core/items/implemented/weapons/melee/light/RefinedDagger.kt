package net.siegerpg.siege.core.items.implemented.weapons.melee.light

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.RefinedMetal
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.Stick
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class RefinedDagger() : CustomMeleeWeapon(
    name = "Refined Dagger",
    customModelData = 110010,
    description = listOf("A dagger, but shinier and more pointy"),
    levelRequirement = 22,
    material = Material.WOODEN_SWORD,
    baseStats = CustomItemUtils.statMap(strength = 40.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(RefinedMetal(0)) //tier 3
            s4(Stick(0)) //tier 3
            item { player, b ->
                RefinedDagger(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s2(RefinedMetal(0)) //tier 3
            s5(Stick(0)) //tier 3
            item { player, b ->
                RefinedDagger(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s3(RefinedMetal(0)) //tier 3
            s6(Stick(0)) //tier 3
            item { player, b ->
                RefinedDagger(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s4(RefinedMetal(0)) //tier 3
            s7(Stick(0)) //tier 3
            item { player, b ->
                RefinedDagger(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s5(RefinedMetal(0)) //tier 3
            s8(Stick(0)) //tier 3
            item { player, b ->
                RefinedDagger(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s6(RefinedMetal(0)) //tier 3
            s9(Stick(0)) //tier 3
            item { player, b ->
                RefinedDagger(Utils.randRarity())
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