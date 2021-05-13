package net.siegerpg.siege.core.items.implemented.armor.boots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.wands.GlowingTwig
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class SlimyBoots() : CustomBoots(
    name = "Slimy Boots",
    customModelData = 1,
    description = listOf("Contrary to popular belief,", "slime boots don't make you jump high"),
    levelRequirement = 3,
    material = Material.LEATHER_BOOTS,
    baseStats = CustomItemUtils.statMap(health = 5.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Slime.tier(2))
            s3(Slime.tier(2))
            s4(Slime.tier(2))
            s6(Slime.tier(2))
            item { player, b ->
                val newItem = SlimyBoots(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s4(Slime.tier(2))
            s6(Slime.tier(2))
            s7(Slime.tier(2))
            s9(Slime.tier(2))
            item { player, b ->
                val newItem = SlimyBoots(if (b) 50 else Utils.randRarity())
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