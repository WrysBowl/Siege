package net.siegerpg.siege.core.items.implemented.armor.helmet

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.wands.GlowingTwig
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class SlimyBoots() : CustomHelmet(
    name = "Slimy Boots",
    customModelData = 1,
    description = listOf("Contrary to popular belief, slime boots don't make you jump high"),
    levelRequirement = 3,
    material = Material.LEATHER_BOOTS,
    baseStats = CustomItemUtils.statMap(health = 5.0, regeneration = 2.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Slime(0)) //tier 2
            s3(Slime(0)) //tier 2
            s4(Slime(0)) //tier 2
            s6(Slime(0)) //tier 2
            item { player, b ->
                SlimyBoots(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s4(Slime(0)) //tier 2
            s6(Slime(0)) //tier 2
            s7(Slime(0)) //tier 2
            s9(Slime(0)) //tier 2
            item { player, b ->
                SlimyBoots(Utils.randRarity())
            }
        }
    },
    leatherColor = Color.LIME
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