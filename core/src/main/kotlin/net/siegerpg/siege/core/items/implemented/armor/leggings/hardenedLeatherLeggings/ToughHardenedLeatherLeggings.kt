package net.siegerpg.siege.core.items.implemented.armor.leggings.hardenedLeatherLeggings

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ToughHardenedLeatherLeggings() : CustomLeggings(
    name = "Tough Hardened Leather Leggings",
    customModelData = 1,
    description = listOf("Leather but erect"),
    levelRequirement = 18,
    material = Material.LEATHER_LEGGINGS,
    baseStats = CustomItemUtils.statMap(health = 20.0, toughness = 70.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Leather.tier(2))
            s2(Leather.tier(2))
            s3(Pebble.tier(2))
            s4(Pebble.tier(2))
            s6(Pebble.tier(2))
            s7(Pebble.tier(2))
            s9(Pebble.tier(2))
            item { player, b ->
                val newItem = ToughHardenedLeatherLeggings(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
    }
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