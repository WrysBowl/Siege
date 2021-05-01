package net.siegerpg.siege.core.items.implemented.armor.helmet

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class IronLeggings() : CustomHelmet(
    name = "Iron Leggings",
    customModelData = 1,
    description = listOf("Iron jenkins"),
    levelRequirement = 35,
    material = Material.IRON_LEGGINGS,
    baseStats = CustomItemUtils.statMap(health = 50.0, toughness = 100.0, regeneration = 30.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(RefinedMetal.tier(2))
            s2(RefinedMetal.tier(2))
            s3(RefinedMetal.tier(2))
            s4(RefinedMetal.tier(2))
            s6(RefinedMetal.tier(2))
            s7(RefinedMetal.tier(2))
            s9(RefinedMetal.tier(2))
            item { player, b ->
                val newItem = IronLeggings(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
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