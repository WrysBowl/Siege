package net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.femurBones

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class StrongFemurBone() : CustomMeleeWeapon(
    name = "Strong Femur Bone",
    customModelData = 130003,
    description = listOf("A large animal's femur"),
    levelRequirement = 11,
    material = Material.WOODEN_AXE,
    baseStats = CustomItemUtils.statMap(strength = 30.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Bone.tier(4))
            item { player, b ->
                val newItem = StrongFemurBone(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
    },
    attackSpeed = 0.9
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