package net.siegerpg.siege.core.items.implemented.armor.chestplate.hardenedLeatherChestplates

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealthyHardenedLeatherChestplate() : CustomChestplate(
    name = "Healthy Hardened Leather Chestplate",
    customModelData = 1,
    description = listOf("Skin tight. Literally."),
    levelRequirement = 18,
    material = Material.LEATHER_CHESTPLATE,
    baseStats = CustomItemUtils.statMap(health = 30.0, toughness = 20.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Leather.tier(2))
            s3(Leather.tier(2))
            s4(Leather.tier(2))
            s5(PlantMatter.tier(2))
            s6(PlantMatter.tier(2))
            s7(PlantMatter.tier(2))
            s8(PlantMatter.tier(2))
            s9(PlantMatter.tier(2))
            item { player, b ->
                val newItem = HealthyHardenedLeatherChestplate(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
    }
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