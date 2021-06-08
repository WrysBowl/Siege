package net.siegerpg.siege.core.items.implemented.weapons.ranged.reinforcedBows

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Vine
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ToughReinforcedBow() : CustomBow(
    name = "Tough Reinforced Bow",
    customModelData = 0,
    description = listOf("Stronger wood to give", "the bow a bit more wam"),
    levelRequirement = 18,
    material = Material.BOW,
    baseStats = CustomItemUtils.statMap(strength = 14.0, luck = 5.0, toughness = 60.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s2(Stick.tier(3))
            s3(Stick.tier(3))
            s4(Stick.tier(3))
            s6(Pebble.tier(3))
            s7(Pebble.tier(3))
            s9(Vine.tier(3))
            item { player, b ->
                val newItem = ToughReinforcedBow(if (b) 50 else Utils.randRarity())
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