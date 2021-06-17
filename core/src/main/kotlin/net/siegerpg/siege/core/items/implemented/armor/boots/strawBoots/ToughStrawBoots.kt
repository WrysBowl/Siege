package net.siegerpg.siege.core.items.implemented.armor.boots.strawBoots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Seed
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ToughStrawBoots() : CustomBoots(
    name = "Tough Straw Boots",
    customModelData = 1,
    description = listOf("Crunch, crunch, crunch"),
    levelRequirement = 3,
    material = Material.LEATHER_BOOTS,
    baseStats = CustomItemUtils.statMap(toughness = 20.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Seed.tier(2))
            s3(Pebble.tier(2))
            s4(Pebble.tier(2))
            s6(Pebble.tier(2))
            item { player, b ->
                val newItem = ToughStrawBoots(if (b) 50 else Utils.randRarity())
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