package net.siegerpg.siege.core.items.implemented.weapons.ranged.recurveBows

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.RefinedMetal
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Vine
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.weapons.ranged.IronBow
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class StrongRecurveBow() : CustomBow(
    name = "Strong Recurve Bow",
    customModelData = 0,
    description = listOf("Slight curves at the ends", "give the bow a bit more power"),
    levelRequirement = 30,
    material = Material.CROSSBOW,
    baseStats = CustomItemUtils.statMap(strength = 41.0, luck = 4.0),
    recipeList = recipes {
        recipe{
            shaped = true
            s1(Vine.tier(3))
            s2(Vine.tier(3))
            s3(Vine.tier(3))
            s4(RefinedMetal.tier(3))
            s5(RefinedMetal.tier(3))
            s6(Bone.tier(3))
            s7(Bone.tier(3))
            s8(Bone.tier(3))
            s9(Bone.tier(3))
            item { player, b ->
                val newItem = StrongRecurveBow(if (b) 50 else Utils.randRarity())
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