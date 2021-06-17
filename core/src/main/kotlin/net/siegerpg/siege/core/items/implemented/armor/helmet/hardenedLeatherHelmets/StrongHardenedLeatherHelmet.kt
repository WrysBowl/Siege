package net.siegerpg.siege.core.items.implemented.armor.helmet.hardenedLeatherHelmets

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class StrongHardenedLeatherHelmet() : CustomHelmet(
    name = "Strong Hardened Leather Helmet",
    customModelData = 1,
    description = listOf("Cow Hat"),
    levelRequirement = 17,
    material = Material.LEATHER_HELMET,
    baseStats = CustomItemUtils.statMap(toughness = 25.0, strength = 6.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Leather.tier(2))
            s2(Leather.tier(2))
            s3(Leather.tier(2))
            s4(Bone.tier(2))
            s6(Bone.tier(2))
            item { player, b ->
                val newItem = StrongHardenedLeatherHelmet(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
    }
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