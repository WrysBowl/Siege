package net.siegerpg.siege.core.items.implemented.weapons.melee

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.MetalScrap
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.Stick
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Longsword() : CustomMeleeWeapon(
    name = "Longsword",
    customModelData = 130006,
    description = listOf("A typical medieval weapon"),
    levelRequirement = 23,
    material = Material.WOODEN_AXE,
    baseStats = CustomItemUtils.statMap(strength = 36.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(MetalScrap(0)) //tier 3
            s4(MetalScrap(0)) //tier 3
            s7(Stick(0)) //tier 3
            item { player, b ->
                Longsword(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s2(MetalScrap(0)) //tier 3
            s5(MetalScrap(0)) //tier 3
            s8(Stick(0)) //tier 3
            item { player, b ->
                Longsword(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s3(MetalScrap(0)) //tier 3
            s6(MetalScrap(0)) //tier 3
            s9(Stick(0)) //tier 3
            item { player, b ->
                Longsword(Utils.randRarity())
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