package net.siegerpg.siege.core.items.implemented.armor.helmet.magmaHelmets

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Magma
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealingMagmaHelmet() : CustomHelmet(
    name = "Healing Magma Helmet",
    customModelData = 1,
    description = listOf("Quite the hot head"),
    levelRequirement = 12,
    material = Material.LEATHER_HELMET,
    baseStats = CustomItemUtils.statMap(health = 5.0, toughness = 10.0, regeneration = 4.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Magma.tier(2))
            s2(Magma.tier(2))
            s4(Wheat.tier(2))
            s6(Wheat.tier(2))
            s6(Wheat.tier(2))
            item { player, b ->
                val newItem = HealingMagmaHelmet(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
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