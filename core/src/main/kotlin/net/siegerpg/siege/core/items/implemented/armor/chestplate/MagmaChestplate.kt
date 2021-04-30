package net.siegerpg.siege.core.items.implemented.armor.helmet

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

class MagmaChestplate() : CustomHelmet(
    name = "Magma Chestplate",
    customModelData = 1,
    description = listOf("This really warms my heart"),
    levelRequirement = 9,
    material = Material.LEATHER_CHESTPLATE,
    baseStats = CustomItemUtils.statMap(health = 16.0, toughness = 75.0, regeneration = 5.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Magma(0)) //tier 2
            s3(Magma(0)) //tier 2
            s4(Magma(0)) //tier 2
            s5(Magma(0)) //tier 2
            s6(Magma(0)) //tier 2
            s7(Magma(0)) //tier 2
            s8(Magma(0)) //tier 2
            s9(Magma(0)) //tier 2
            item { player, b ->
                MagmaChestplate(Utils.randRarity())
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