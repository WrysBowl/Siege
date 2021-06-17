package net.siegerpg.siege.core.items.implemented.weapons.ranged.crossbows

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.MetalScrap
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Vine
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealingCrossbow() : CustomBow(
    name = "Healing Crossbow",
    customModelData = 0,
    description = listOf("The OG pistol"),
    levelRequirement = 26,
    material = Material.CROSSBOW,
    baseStats = CustomItemUtils.statMap(strength = 27.0, luck = 8.0, regeneration = 8.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Vine.tier(3))
            s2(Vine.tier(3))
            s3(Vine.tier(3))
            s4(MetalScrap.tier(3))
            s5(MetalScrap.tier(3))
            s6(MetalScrap.tier(3))
            s7(Wheat.tier(4))
            item { player, b ->
                val newItem = HealingCrossbow(if (b) 50 else Utils.randRarity())
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