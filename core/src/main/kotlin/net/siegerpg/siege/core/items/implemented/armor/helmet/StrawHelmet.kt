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

class StrawHelmet() : CustomHelmet(
    name = "Straw Hat",
    customModelData = 1,
    description = listOf("Farmer"),
    levelRequirement = 3,
    material = Material.LEATHER_HELMET,
    baseStats = CustomItemUtils.statMap(health = 8.0, toughness = 5.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Seed.tier(2))
            s2(Seed.tier(2))
            s3(Seed.tier(2))
            s4(Seed.tier(2))
            s6(Seed.tier(2))
            item { player, b ->
                val newItem = StrawHelmet(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s4(Seed.tier(2))
            s5(Seed.tier(2))
            s6(Seed.tier(2))
            s7(Seed.tier(2))
            s9(Seed.tier(2))
            item { player, b ->
                val newItem = StrawHelmet(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
    },
    leatherColor = Color.YELLOW
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