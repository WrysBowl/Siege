package net.siegerpg.siege.core.items.implemented.weapons.ranged

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Vine
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Magma
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Slime
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class SewerShooter() : CustomBow(
    name = "Sewer Shooter",
    customModelData = 0,
    description = listOf("A bow made of mob flesh,", "that's a first"),
    levelRequirement = 22,
    material = Material.BOW,
    baseStats = CustomItemUtils.statMap(strength = 25.0, luck = 9.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Slime.tier(3))
            s2(Stick.tier(3))
            s3(Vine.tier(3))
            s4(Stick.tier(3))
            s6(Vine.tier(3))
            s7(Magma.tier(3))
            s8(Stick.tier(3))
            s9(Vine.tier(3))
            item { player, b ->
                val newItem = SewerShooter(if (b) 50 else Utils.randRarity())
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