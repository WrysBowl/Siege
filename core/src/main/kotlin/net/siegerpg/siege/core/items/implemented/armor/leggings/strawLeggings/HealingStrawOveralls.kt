package net.siegerpg.siege.core.items.implemented.armor.leggings.strawLeggings

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Seed
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealingStrawOveralls() : CustomLeggings(
    name = "Healing Straw Overalls",
    customModelData = 1,
    description = listOf("The Last Straw"),
    levelRequirement = 4,
    material = Material.LEATHER_LEGGINGS,
    baseStats = CustomItemUtils.statMap(health = 5.0, regeneration = 6.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Seed.tier(2))
            s2(Seed.tier(2))
            s3(Seed.tier(2))
            s4(Wheat.tier(2))
            s6(Wheat.tier(2))
            s7(Wheat.tier(2))
            s7(Wheat.tier(2))
            item { player, b ->
                val newItem = HealingStrawOveralls(if (b) 50 else Utils.randRarity())
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