package net.siegerpg.siege.core.items.implemented.weapons.ranged

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.Stick
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.Vine
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ReinforcedBow() : CustomBow(
    name = "Reinforced Bow",
    customModelData = 0,
    description = listOf("Stronger wood to give the bow a bit more wam"),
    levelRequirement = 18,
    material = Material.BOW,
    baseStats = CustomItemUtils.statMap(strength = 15.0, luck = 7.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s2(Stick(0)) //tier 4
            s3(Vine(0)) //tier 3
            s4(Stick(0)) //tier 4
            s6(Vine(0)) //tier 3
            s8(Stick(0)) //tier 4
            s9(Vine(0)) //tier 3
            item { player, b ->
                ReinforcedBow(Utils.randRarity())
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