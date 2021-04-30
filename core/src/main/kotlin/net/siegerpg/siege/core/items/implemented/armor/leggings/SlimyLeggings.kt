package net.siegerpg.siege.core.items.implemented.armor.helmet

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.mobDrops.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class SlimyLeggings() : CustomHelmet(
    name = "Slimy Leggings",
    customModelData = 1,
    description = listOf("Waste high in sewage"),
    levelRequirement = 4,
    material = Material.LEATHER_LEGGINGS,
    baseStats = CustomItemUtils.statMap(health = 8.0, toughness = 30.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Slime(0)) //tier 2
            s2(Slime(0)) //tier 2
            s3(Slime(0)) //tier 2
            s4(Slime(0)) //tier 2
            s6(Slime(0)) //tier 2
            s7(Slime(0)) //tier 2
            s9(Slime(0)) //tier 2
            item { player, b ->
                SlimyLeggings(Utils.randRarity())
            }
        }
    },
    leatherColor = Color.LIME
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