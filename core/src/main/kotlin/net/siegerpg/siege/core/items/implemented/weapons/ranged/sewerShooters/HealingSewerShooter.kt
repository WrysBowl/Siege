package net.siegerpg.siege.core.items.implemented.weapons.ranged.sewerShooters

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Vine
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Magma
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Slime
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealingSewerShooter() : CustomBow(
    name = "Healing Sewer Shooter",
    customModelData = 0,
    description = listOf("A bow made of mob flesh,", "that's a first"),
    levelRequirement = 22,
    material = Material.BOW,
    baseStats = CustomItemUtils.statMap(strength = 23.0, luck = 5.0, regeneration = 9.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Slime.tier(3))
            s2(Magma.tier(3))
            s3(Stick.tier(3))
            s4(Stick.tier(3))
            s5(Stick.tier(3))
            s6(Vine.tier(3))
            s7(Wheat.tier(3))
            s8(Wheat.tier(3))
            s9(Wheat.tier(3))
            item { player, b ->
                val newItem = HealingSewerShooter(if (b) 50 else Utils.randRarity())
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