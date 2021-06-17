package net.siegerpg.siege.core.items.implemented.armor.helmet.strawHelmets

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Seed
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ToughStrawHat() : CustomHelmet(
    name = "Tough Straw Hat",
    customModelData = 1,
    description = listOf("Farmer"),
    levelRequirement = 3,
    material = Material.LEATHER_HELMET,
    baseStats = CustomItemUtils.statMap(health = 2.0, toughness = 20.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Seed.tier(2))
            s2(Seed.tier(2))
            s3(Pebble.tier(2))
            s4(Pebble.tier(2))
            s6(Pebble.tier(2))
            s6(Pebble.tier(2))
            item { player, b ->
                val newItem = ToughStrawHat(if (b) 50 else Utils.randRarity())
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