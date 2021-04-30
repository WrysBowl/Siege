package net.siegerpg.siege.core.items.implemented.weapons.melee.heavy

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.RefinedMetal
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Clobber() : CustomMeleeWeapon(
    name = "Clobber",
    customModelData = 130009,
    description = listOf("Let's go clobbing!"),
    levelRequirement = 35,
    material = Material.WOODEN_AXE,
    baseStats = CustomItemUtils.statMap(strength = 50.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(RefinedMetal(0)) //tier 3
            s2(RefinedMetal(0)) //tier 3
            s4(RefinedMetal(0)) //tier 3
            s5(RefinedMetal(0)) //tier 3
            s8(RefinedMetal(0)) //tier 3
            item { player, b ->
                Clobber(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s2(RefinedMetal(0)) //tier 3
            s3(RefinedMetal(0)) //tier 3
            s5(RefinedMetal(0)) //tier 3
            s6(RefinedMetal(0)) //tier 3
            s9(RefinedMetal(0)) //tier 3
            item { player, b ->
                Clobber(Utils.randRarity())
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