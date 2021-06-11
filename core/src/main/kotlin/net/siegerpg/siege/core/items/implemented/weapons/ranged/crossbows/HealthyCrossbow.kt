package net.siegerpg.siege.core.items.implemented.weapons.ranged.crossbows

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.MetalScrap
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Vine
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.weapons.ranged.IronBow
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealthyCrossbow() : CustomBow(
    name = "Healthy Crossbow",
    customModelData = 0,
    description = listOf("The OG pistol"),
    levelRequirement = 26,
    material = Material.CROSSBOW,
    baseStats = CustomItemUtils.statMap(strength = 27.0, luck = 7.0, health = 15.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Vine.tier(3))
            s2(Vine.tier(3))
            s3(Vine.tier(3))
            s4(MetalScrap.tier(3))
            s5(MetalScrap.tier(3))
            s6(MetalScrap.tier(3))
            s7(PlantMatter.tier(3))
            s8(PlantMatter.tier(3))
            s9(PlantMatter.tier(3))
            item { player, b ->
                val newItem = HealthyCrossbow(if (b) 50 else Utils.randRarity())
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