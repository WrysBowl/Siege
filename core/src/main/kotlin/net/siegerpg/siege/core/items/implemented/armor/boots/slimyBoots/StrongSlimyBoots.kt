package net.siegerpg.siege.core.items.implemented.armor.boots.slimyBoots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.wands.GlowingTwig
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class StrongSlimyBoots() : CustomBoots(
    name = "Strong Slimy Boots",
    customModelData = 1,
    description = listOf("Contrary to popular belief,", "slime boots don't make you jump high"),
    levelRequirement = 3,
    material = Material.LEATHER_BOOTS,
    baseStats = CustomItemUtils.statMap(strength = 3.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Slime.tier(2))
            s3(Slime.tier(2))
            s6(Bone.tier(2))
            s6(Bone.tier(2))
            s6(Bone.tier(2))
            item { player, b ->
                val newItem = StrongSlimyBoots(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
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