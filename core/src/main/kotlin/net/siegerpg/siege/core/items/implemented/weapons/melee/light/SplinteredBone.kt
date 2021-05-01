package net.siegerpg.siege.core.items.implemented.weapons.melee.light

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class SplinteredBone() : CustomMeleeWeapon(
    name = "Splintered Bone",
    customModelData = 110009,
    description = listOf("The shard of a human femur bone"),
    levelRequirement = 20,
    material = Material.WOODEN_SWORD,
    baseStats = CustomItemUtils.statMap(strength = 38.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Bone.tier(3))
            s4(Bone.tier(3))
            item { player, b ->
                val newItem = SplinteredBone(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s2(Bone.tier(3))
            s5(Bone.tier(3))
            item { player, b ->
                val newItem = SplinteredBone(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s3(Bone.tier(3))
            s6(Bone.tier(3))
            item { player, b ->
                val newItem = SplinteredBone(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s4(Bone.tier(3))
            s7(Bone.tier(3))
            item { player, b ->
                val newItem = SplinteredBone(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s5(Bone.tier(3))
            s8(Bone.tier(3))
            item { player, b ->
                val newItem = SplinteredBone(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s6(Bone.tier(3))
            s9(Bone.tier(3))
            item { player, b ->
                val newItem = SplinteredBone(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
    },
    attackSpeed = 1.5
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