package net.siegerpg.siege.core.items.implemented.armor.leggings.slimyLeggings

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Slime
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class LuckySlimyLeggings() : CustomLeggings(
    name = "Lucky Slimy Leggings",
    customModelData = 1,
    description = listOf("Waste high in sewage"),
    levelRequirement = 4,
    material = Material.LEATHER_LEGGINGS,
    baseStats = CustomItemUtils.statMap(health = 6.0, toughness = 10.0, luck = 4.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Slime.tier(2))
            s2(Slime.tier(2))
            s3(Slime.tier(2))
            s4(Feather.tier(2))
            s6(Feather.tier(2))
            s7(Feather.tier(2))
            item { player, b ->
                val newItem = LuckySlimyLeggings(if (b) 50 else Utils.randRarity())
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