package net.siegerpg.siege.core.items.implemented.armor.helmet

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class IronBoots() : CustomHelmet(
    name = "Iron Boots",
    customModelData = 1,
    description = listOf("Iron clad boots"),
    levelRequirement = 34,
    material = Material.IRON_BOOTS,
    baseStats = CustomItemUtils.statMap(health = 40.0, toughness = 60.0, regeneration = 15.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(RefinedMetal.tier(2)) //tier 2
            s3(RefinedMetal.tier(2)) //tier 2
            s4(RefinedMetal.tier(2)) //tier 2
            s6(RefinedMetal.tier(2)) //tier 2
            item { player, b ->
                IronBoots(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s4(RefinedMetal.tier(2)) //tier 2
            s6(RefinedMetal.tier(2)) //tier 2
            s7(RefinedMetal.tier(2)) //tier 2
            s9(RefinedMetal.tier(2)) //tier 2
            item { player, b ->
                IronBoots(Utils.randRarity())
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