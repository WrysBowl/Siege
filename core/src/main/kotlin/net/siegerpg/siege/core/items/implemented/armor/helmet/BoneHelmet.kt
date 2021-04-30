package net.siegerpg.siege.core.items.implemented.armor.helmet

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.mobDrops.*
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.*
import net.siegerpg.siege.core.items.implemented.misc.wands.GlowingTwig
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class BoneHelmet() : CustomHelmet(
    name = "Bone Helmet",
    customModelData = 1,
    description = listOf("A second skull"),
    levelRequirement = 23,
    material = Material.LEATHER_HELMET,
    baseStats = CustomItemUtils.statMap(health = 40.0, toughness = 50.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Bone(0)) //tier 2
            s2(Bone(0)) //tier 2
            s3(Bone(0)) //tier 2
            s4(Bone(0)) //tier 2
            s6(Bone(0)) //tier 2
            item { player, b ->
                BoneHelmet(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s4(Bone(0)) //tier 2
            s5(Bone(0)) //tier 2
            s6(Bone(0)) //tier 2
            s7(Bone(0)) //tier 2
            s9(Bone(0)) //tier 2
            item { player, b ->
                BoneHelmet(Utils.randRarity())
            }
        }
    },
    leatherColor = Color.GRAY
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