package net.siegerpg.siege.core.items.implemented.weapons.ranged

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Vine
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class WoodenBow() : CustomBow(
    name = "Wooden Bow",
    customModelData = 0,
    description = listOf("Your standard issue ranged weapon"),
    levelRequirement = 6,
    material = Material.BOW,
    baseStats = CustomItemUtils.statMap(strength = 8.0, luck = 3.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s2(Stick.tier(3))
            s3(Vine.tier(3))
            s4(Stick.tier(3))
            s6(Vine.tier(3))
            s8(Stick.tier(3))
            s9(Vine.tier(3))
            item { player, b ->
                val newItem = WoodenBow(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
    },
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