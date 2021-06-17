package net.siegerpg.siege.core.items.implemented.weapons.ranged.woodenBows

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Vine
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ToughWoodenBow() : CustomBow(
    name = "Tough Wooden Bow",
    customModelData = 0,
    description = listOf("Your standard issue ranged weapon"),
    levelRequirement = 6,
    material = Material.BOW,
    baseStats = CustomItemUtils.statMap(strength = 15.0, toughness = 30.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Stick.tier(3))
            s2(Stick.tier(3))
            s3(Stick.tier(3))
            s4(Vine.tier(3))
            s5(Pebble.tier(3))
            item { player, b ->
                val newItem = ToughWoodenBow(if (b) 50 else Utils.randRarity())
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