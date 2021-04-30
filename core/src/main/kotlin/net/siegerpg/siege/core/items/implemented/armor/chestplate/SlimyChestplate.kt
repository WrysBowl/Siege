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

class SlimyChestplate() : CustomHelmet(
    name = "Slimy Chestplate",
    customModelData = 1,
    description = listOf("Jelly belly"),
    levelRequirement = 4,
    material = Material.LEATHER_CHESTPLATE,
    baseStats = CustomItemUtils.statMap(health = 10.0, toughness = 50.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Slime(0)) //tier 2
            s3(Slime(0)) //tier 2
            s4(Slime(0)) //tier 2
            s5(Slime(0)) //tier 2
            s6(Slime(0)) //tier 2
            s7(Slime(0)) //tier 2
            s8(Slime(0)) //tier 2
            s9(Slime(0)) //tier 2
            item { player, b ->
                SlimyChestplate(Utils.randRarity())
            }
        }
    },
    leatherColor = Color.LIME
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