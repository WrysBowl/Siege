package net.siegerpg.siege.core.items.implemented.armor.helmet.woolHelmets

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealingWoolHelmet() : CustomHelmet(
    name = "Healing Wool Helmet",
    customModelData = 1,
    description = listOf("Keep your ears warm"),
    levelRequirement = 8,
    material = Material.LEATHER_HELMET,
    baseStats = CustomItemUtils.statMap(regeneration = 5.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Wool.tier(2))
            s2(Wool.tier(2))
            s3(Wool.tier(2))
            s4(Wheat.tier(2))
            s6(Wheat.tier(2))
            s6(Wheat.tier(2))
            item { player, b ->
                val newItem = HealingWoolHelmet(if (b) 50 else Utils.randRarity())
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