package net.siegerpg.siege.core.items.implemented.armor.helmet

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.*
import net.siegerpg.siege.core.items.implemented.misc.materials.mobDrops.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ChainChestplate() : CustomHelmet(
    name = "Chain Chestplate",
    customModelData = 1,
    description = listOf("Cut resistant"),
    levelRequirement = 30,
    material = Material.CHAINMAIL_CHESTPLATE,
    baseStats = CustomItemUtils.statMap(health = 80.0, toughness = 100.0, regeneration = 15.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Chain(0)) //tier 2
            s3(Chain(0)) //tier 2
            s4(Chain(0)) //tier 2
            s5(Chain(0)) //tier 2
            s6(Chain(0)) //tier 2
            s7(Chain(0)) //tier 2
            s8(Chain(0)) //tier 2
            s9(Chain(0)) //tier 2
            item { player, b ->
                ChainChestplate(Utils.randRarity())
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