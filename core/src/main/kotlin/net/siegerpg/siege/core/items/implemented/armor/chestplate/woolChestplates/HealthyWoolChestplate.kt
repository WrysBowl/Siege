package net.siegerpg.siege.core.items.implemented.armor.chestplate.woolChestplates

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Wool
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealthyWoolChestplate() : CustomChestplate(
    name = "Healthy Wool Chestplate",
    customModelData = 1,
    description = listOf("A cotton jacket"),
    levelRequirement = 9,
    material = Material.LEATHER_CHESTPLATE,
    baseStats = CustomItemUtils.statMap(health = 25.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Wool.tier(2))
            s3(Wool.tier(2))
            s4(Wool.tier(2))
            s5(PlantMatter.tier(2))
            s6(PlantMatter.tier(2))
            s7(PlantMatter.tier(2))
            s8(PlantMatter.tier(2))
            s9(PlantMatter.tier(2))
            item { player, b ->
                val newItem = HealthyWoolChestplate(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
    },
    leatherColor = Color.WHITE
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