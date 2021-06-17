package net.siegerpg.siege.core.items.implemented.armor.chestplate.strawChestplates

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Seed
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealingStrawChestplate() : CustomChestplate(
    name = "Healing Straw Chestplate",
    customModelData = 1,
    description = listOf("Scarecrow..."),
    levelRequirement = 4,
    material = Material.LEATHER_CHESTPLATE,
    baseStats = CustomItemUtils.statMap(health = 6.0, regeneration = 5.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Seed.tier(2))
            s3(Seed.tier(2))
            s4(Seed.tier(2))
            s5(Wheat.tier(2))
            s6(Wheat.tier(2))
            s7(Wheat.tier(2))
            s8(Wheat.tier(2))
            s9(Wheat.tier(2))
            s9(Wheat.tier(2))
            item { player, b ->
                val newItem = HealingStrawChestplate(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
    },
    leatherColor = Color.YELLOW
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