package net.siegerpg.siege.core.items.implemented.armor.chestplate.hardenedLeatherChestplates

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealingHardenedLeatherChestplate() : CustomChestplate(
    name = "Healing Hardened Leather Chestplate",
    customModelData = 1,
    description = listOf("Skin tight. Literally."),
    levelRequirement = 18,
    material = Material.LEATHER_CHESTPLATE,
    baseStats = CustomItemUtils.statMap(health = 20.0, regeneration = 5.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Leather.tier(2))
            s3(Leather.tier(2))
            s4(Leather.tier(2))
            s5(Leather.tier(2))
            s6(Wheat.tier(2))
            s7(Wheat.tier(2))
            s8(Wheat.tier(2))
            s9(Wheat.tier(2))
            item { player, b ->
                val newItem = HealingHardenedLeatherChestplate(if (b) 50 else Utils.randRarity())
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