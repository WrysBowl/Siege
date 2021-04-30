package net.siegerpg.siege.core.items.implemented.armor.helmet

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.mobDrops.*
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.*
import net.siegerpg.siege.core.items.implemented.misc.wands.GlowingTwig
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class IronHelmet() : CustomHelmet(
    name = "Iron Helmet",
    customModelData = 1,
    description = listOf("Thick skull"),
    levelRequirement = 29,
    material = Material.IRON_HELMET,
    baseStats = CustomItemUtils.statMap(health = 40.0, toughness = 80.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(RefinedMetal(0)) //tier 2
            s2(RefinedMetal(0)) //tier 2
            s3(RefinedMetal(0)) //tier 2
            s4(RefinedMetal(0)) //tier 2
            s6(RefinedMetal(0)) //tier 2
            item { player, b ->
                IronHelmet(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s4(RefinedMetal(0)) //tier 2
            s5(RefinedMetal(0)) //tier 2
            s6(RefinedMetal(0)) //tier 2
            s7(RefinedMetal(0)) //tier 2
            s9(RefinedMetal(0)) //tier 2
            item { player, b ->
                IronHelmet(Utils.randRarity())
            }
        }
    },
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