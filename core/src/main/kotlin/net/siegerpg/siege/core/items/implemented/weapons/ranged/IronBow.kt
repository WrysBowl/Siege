package net.siegerpg.siege.core.items.implemented.weapons.melee

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.RefinedMetal
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.Vine
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class IronBow() : CustomBow(
    name = "Iron Bow",
    customModelData = 0,
    description = listOf("Heavy and durable"),
    levelRequirement = 34,
    material = Material.BOW,
    baseStats = CustomItemUtils.statMap(strength = 28.0, luck = 15.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s2(RefinedMetal(0)) //tier 3
            s3(Vine(0)) //tier 3
            s4(RefinedMetal(0)) //tier 3
            s6(Vine(0)) //tier 3
            s8(RefinedMetal(0)) //tier 3
            s9(Vine(0)) //tier 3
            item { player, b ->
                IronBow(Utils.randRarity())
            }
        }
    },
) {

    constructor(quality: Int): this() {
        this.quality = quality
        this.rarity = Rarity.getFromInt(quality)
    }

    constructor(item: ItemStack): this() {
        this.item = item
        deserialize()
    }

}