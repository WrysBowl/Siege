package net.siegerpg.siege.core.items.implemented.misc.wands

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.misc.CustomWand
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class GlisteningTwig() : CustomWand(
    name = "Glistening Twig",
    customModelData = 140002,
    description = listOf("A dead twig reborn"),
    levelRequirement = 6,
    material = Material.WOODEN_HOE,
    baseStats = CustomItemUtils.statMap(strength = 8.0, luck = 6.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Seed(0)) //tier 3
            s4(PlantMatter(0)) //tier 2
            s7(Stick(0)) //tier 2
            item { player, b ->
                GlowingTwig(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s2(Seed(0)) //tier 3
            s5(PlantMatter(0)) //tier 2
            s8(Stick(0)) //tier 2
            item { player, b ->
                GlowingTwig(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s3(Pebble(0)) //tier 3
            s6(PlantMatter(0)) //tier 2
            s9(Stick(0)) //tier 2
            item { player, b ->
                GlowingTwig(Utils.randRarity())
            }
        }
    },
    range = 15,
    red = 255,
    green = 255,
    blue = 153,
    damageRadius = 1.5
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