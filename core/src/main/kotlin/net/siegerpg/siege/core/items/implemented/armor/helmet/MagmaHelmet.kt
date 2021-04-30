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

class MagmaHelmet() : CustomHelmet(
    name = "Magma Helmet",
    customModelData = 1,
    description = listOf("Quite the hot head"),
    levelRequirement = 8,
    material = Material.LEATHER_HELMET,
    baseStats = CustomItemUtils.statMap(health = 8.0, toughness = 30.0, regeneration = 5.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Magma(0)) //tier 2
            s2(Magma(0)) //tier 2
            s3(Magma(0)) //tier 2
            s4(Magma(0)) //tier 2
            s6(Magma(0)) //tier 2
            item { player, b ->
                MagmaHelmet(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s4(Magma(0)) //tier 2
            s5(Magma(0)) //tier 2
            s6(Magma(0)) //tier 2
            s7(Magma(0)) //tier 2
            s9(Magma(0)) //tier 2
            item { player, b ->
                MagmaHelmet(Utils.randRarity())
            }
        }
    },
    leatherColor = Color.ORANGE
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