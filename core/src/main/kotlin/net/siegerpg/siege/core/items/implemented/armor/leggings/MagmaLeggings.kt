package net.siegerpg.siege.core.items.implemented.armor.leggings

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class MagmaLeggings() : CustomLeggings(
    name = "Magma Leggings",
    customModelData = 1,
    description = listOf("Burning fashion. Quite literally"),
    levelRequirement = 13,
    material = Material.LEATHER_LEGGINGS,
    baseStats = CustomItemUtils.statMap(health = 20.0, toughness = 40.0, regeneration = 15.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Magma.tier(2))
            s2(Magma.tier(2))
            s3(Magma.tier(2))
            s4(Magma.tier(2))
            s6(Magma.tier(2))
            s7(Magma.tier(2))
            s9(Magma.tier(2))
            item { player, b ->
                val newItem = MagmaLeggings(if (b) 50 else Utils.randRarity())
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