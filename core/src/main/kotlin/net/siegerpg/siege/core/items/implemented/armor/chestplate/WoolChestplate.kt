package net.siegerpg.siege.core.items.implemented.armor.helmet

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.mobDrops.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class WoolChestplate() : CustomHelmet(
    name = "Wool Chestplate",
    customModelData = 1,
    description = listOf("A cotton jacket"),
    levelRequirement = 4,
    material = Material.LEATHER_CHESTPLATE,
    baseStats = CustomItemUtils.statMap(health = 16.0, regeneration = 5.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Wool(0)) //tier 2
            s3(Wool(0)) //tier 2
            s4(Wool(0)) //tier 2
            s5(Wool(0)) //tier 2
            s6(Wool(0)) //tier 2
            s7(Wool(0)) //tier 2
            s8(Wool(0)) //tier 2
            s9(Wool(0)) //tier 2
            item { player, b ->
                WoolChestplate(Utils.randRarity())
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