package net.siegerpg.siege.core.items.implemented.weapons.ranged

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

class PebbleShooter() : CustomBow(
    name = "Pebble Shooter",
    customModelData = 0,
    description = listOf("Now comes with pebble", "shooting support!"),
    levelRequirement = 10,
    material = Material.BOW, //This needs to be changed to a crossbow
    baseStats = CustomItemUtils.statMap(strength = 12.0, luck = 5.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s2(Pebble.tier(3))
            s4(Stick.tier(3))
            s6(Stick.tier(3))
            s7(Vine.tier(3))
            s8(Vine.tier(3))
            s9(Vine.tier(3))
            item { player, b ->
                val newItem = PebbleShooter(if (b) 50 else Utils.randRarity())
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