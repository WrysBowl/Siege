package net.siegerpg.siege.core.items.implemented.armor.boots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.wands.GlowingTwig
import net.siegerpg.siege.core.items.implemented.weapons.ranged.Bowba
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class BoneBoots() : CustomBoots(
    name = "Bone Boots",
    customModelData = 1,
    description = listOf("Clunky footpads"),
    levelRequirement = 23,
    material = Material.LEATHER_BOOTS,
    baseStats = CustomItemUtils.statMap(health = 40.0, toughness = 30.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Bone.tier(2))
            s3(Bone.tier(2))
            s4(Bone.tier(2))
            s6(Bone.tier(2))
            item { player, b ->
                val newItem = BoneBoots(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s4(Bone.tier(2))
            s6(Bone.tier(2))
            s7(Bone.tier(2))
            s9(Bone.tier(2))
            item { player, b ->
                val newItem = BoneBoots(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
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