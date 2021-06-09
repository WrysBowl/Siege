package net.siegerpg.siege.core.items.implemented.armor.chestplate.slimyChestplates

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class LuckySlimyChestplate() : CustomChestplate(
    name = "Lucky Slimy Chestplate",
    customModelData = 1,
    description = listOf("Jelly belly"),
    levelRequirement = 4,
    material = Material.LEATHER_CHESTPLATE,
    baseStats = CustomItemUtils.statMap(health = 8.0, toughness = 20.0, luck = 4.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Slime.tier(2))
            s3(Slime.tier(2))
            s4(Slime.tier(2))
            s5(Slime.tier(2))
            s6(Slime.tier(2))
            s7(Feather.tier(2))
            s8(Feather.tier(2))
            s9(Feather.tier(2))
            item { player, b ->
                val newItem = LuckySlimyChestplate(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
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