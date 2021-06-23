package net.siegerpg.siege.core.items.implemented.weapons.ranged.bowbas

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.RefinedMetal
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Vine
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealingBowba() : CustomBow(
    name = "Healing Bowba",
    customModelData = 120010,
    description = listOf("Bones fused with metal in the shape of a bow"),
    levelRequirement = 38,
    material = Material.BOW,
    baseStats = CustomItemUtils.statMap(strength = 45.0, luck = 13.0, regeneration = 17.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Vine.tier(3))
            s2(Vine.tier(3))
            s3(Vine.tier(3))
            s4(RefinedMetal.tier(3))
            s5(RefinedMetal.tier(3))
            s6(RefinedMetal.tier(3))
            s7(Bone.tier(4))
            s8(Wheat.tier(4))
            s9(Wheat.tier(4))
            item { player, b ->
                val newItem = HealingBowba(if (b) 50 else Utils.randRarity())
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