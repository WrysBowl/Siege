package net.siegerpg.siege.core.items.implemented.weapons.ranged

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.RefinedMetal
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.Vine
import net.siegerpg.siege.core.items.implemented.misc.materials.mobDrops.Bone
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Bowba() : CustomBow(
    name = "Bowba",
    customModelData = 0,
    description = listOf("You put bowba in your drink. Bowba will get ruined"),
    levelRequirement = 38,
    material = Material.BOW,
    baseStats = CustomItemUtils.statMap(strength = 35.0, luck = 19.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s2(RefinedMetal(0)) //tier 4
            s3(Vine(0)) //tier 3
            s4(Bone(0)) //tier 4
            s6(Vine(0)) //tier 3
            s8(RefinedMetal(0)) //tier 4
            s9(Vine(0)) //tier 3
            item { player, b ->
                Bowba(Utils.randRarity())
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