package net.siegerpg.siege.core.items.implemented.armor.helmet

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class BoneChestplate() : CustomHelmet(
    name = "Bone Chestplate",
    customModelData = 1,
    description = listOf("Spare ribs"),
    levelRequirement = 24,
    material = Material.LEATHER_CHESTPLATE,
    baseStats = CustomItemUtils.statMap(health = 60.0, toughness = 120.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Bone(0)) //tier 2
            s3(Bone(0)) //tier 2
            s4(Bone(0)) //tier 2
            s5(Bone(0)) //tier 2
            s6(Bone(0)) //tier 2
            s7(Bone(0)) //tier 2
            s8(Bone(0)) //tier 2
            s9(Bone(0)) //tier 2
            item { player, b ->
                BoneChestplate(Utils.randRarity())
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