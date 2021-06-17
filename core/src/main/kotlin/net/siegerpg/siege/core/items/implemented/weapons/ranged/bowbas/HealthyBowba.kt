package net.siegerpg.siege.core.items.implemented.weapons.ranged.bowbas

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.RefinedMetal
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Vine
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealthyBowba() : CustomBow(
    name = "Healthy Bowba",
    customModelData = 0,
    description = listOf("Bones fused with metal in the shape of a bow"),
    levelRequirement = 38,
    material = Material.BOW,
    baseStats = CustomItemUtils.statMap(strength = 40.0, luck = 13.0, health = 25.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Vine.tier(3))
            s2(Vine.tier(3))
            s3(Vine.tier(3))
            s4(RefinedMetal.tier(4))
            s5(Bone.tier(4))
            s6(PlantMatter.tier(4))
            s7(PlantMatter.tier(4))
            item { player, b ->
                val newItem = HealthyBowba(if (b) 50 else Utils.randRarity())
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