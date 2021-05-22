package net.siegerpg.siege.core.items.implemented.armor.boots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.mobs.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class MagmaBoots() : CustomBoots(
    name = "Magma Boots",
    customModelData = 1,
    description = listOf("Some lit boots"),
    levelRequirement = 12,
    material = Material.LEATHER_BOOTS,
    baseStats = CustomItemUtils.statMap(health = 20.0, toughness = 15.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Magma.tier(2))
            s3(Magma.tier(2))
            s4(Magma.tier(2))
            s6(Magma.tier(2))
            item { player, b ->
                val newItem = MagmaBoots(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s4(Magma.tier(2))
            s6(Magma.tier(2))
            s7(Magma.tier(2))
            s9(Magma.tier(2))
            item { player, b ->
                val newItem = MagmaBoots(if (b) 50 else Utils.randRarity())
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