package net.siegerpg.siege.core.items.implemented.armor.helmet

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.Chain
import net.siegerpg.siege.core.items.implemented.misc.materials.mobDrops.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ChainLeggings() : CustomHelmet(
    name = "Chain Leggings",
    customModelData = 1,
    description = listOf("Flimsy legs"),
    levelRequirement = 30,
    material = Material.CHAINMAIL_LEGGINGS,
    baseStats = CustomItemUtils.statMap(health = 70.0, toughness = 60.0, regeneration = 15.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Chain(0)) //tier 2
            s2(Chain(0)) //tier 2
            s3(Chain(0)) //tier 2
            s4(Chain(0)) //tier 2
            s6(Chain(0)) //tier 2
            s7(Chain(0)) //tier 2
            s9(Chain(0)) //tier 2
            item { player, b ->
                ChainLeggings(Utils.randRarity())
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