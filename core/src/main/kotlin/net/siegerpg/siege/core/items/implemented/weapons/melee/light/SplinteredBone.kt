package net.siegerpg.siege.core.items.implemented.weapons.melee.light

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.mobDrops.Bone
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
            s1(Bone(0)) //tier 3
            s4(Bone(0)) //tier 3
            item { player, b ->
                SplinteredBone(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s2(Bone(0)) //tier 3
            s5(Bone(0)) //tier 3
            item { player, b ->
                SplinteredBone(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s3(Bone(0)) //tier 3
            s6(Bone(0)) //tier 3
            item { player, b ->
                SplinteredBone(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s4(Bone(0)) //tier 3
            s7(Bone(0)) //tier 3
            item { player, b ->
                SplinteredBone(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s5(Bone(0)) //tier 3
            s8(Bone(0)) //tier 3
            item { player, b ->
                SplinteredBone(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s6(Bone(0)) //tier 3
            s9(Bone(0)) //tier 3
            item { player, b ->
                SplinteredBone(Utils.randRarity())
            }
        }
    },
    attackSpeed = 1.5
) {

    constructor(quality: Int): this() {
        this.quality = quality
        this.rarity = Rarity.getFromInt(quality)
    }

    constructor(item: ItemStack): this() {
        this.item = item
        deserialize()
    }

}