package net.siegerpg.siege.core.items.implemented.weapons.melee.heavy

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Shovel
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class FemurBone() : CustomMeleeWeapon(
    name = "Femur Bone",
    customModelData = 130003,
    description = listOf("A large animal's femur"),
    levelRequirement = 11,
    material = Material.WOODEN_AXE,
    baseStats = CustomItemUtils.statMap(strength = 25.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Bone.tier(3))
            s4(Bone.tier(3))
            s7(Bone.tier(3))
            item { player, b ->
                Shovel(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s2(Bone.tier(3))
            s5(Bone.tier(3))
            s8(Bone.tier(3))
            item { player, b ->
                Shovel(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s3(Bone.tier(3))
            s6(Bone.tier(3))
            s9(Bone.tier(3))
            item { player, b ->
                Shovel(Utils.randRarity())
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