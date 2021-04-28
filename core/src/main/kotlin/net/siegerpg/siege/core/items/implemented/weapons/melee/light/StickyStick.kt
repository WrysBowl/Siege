package net.siegerpg.siege.core.items.implemented.weapons.melee.light

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.Stick
import net.siegerpg.siege.core.items.implemented.misc.materials.mobDrops.Slime
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class StickyStick() : CustomMeleeWeapon(
    name = "Sticky Stick",
    customModelData = 110002,
    description = listOf("Globs of slime on a stick"),
    levelRequirement = 3,
    material = Material.WOODEN_SWORD,
    baseStats = CustomItemUtils.statMap(strength = 8.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Stick(0)) //tier 2
            s4(Stick(0)) //tier 2
            s2(Slime(0)) //tier 2
            s5(Slime(0)) //tier 2
            item { player, b ->
                StickyStick(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s2(Stick(0)) //tier 2
            s5(Stick(0)) //tier 2
            s3(Slime(0)) //tier 2
            s6(Slime(0)) //tier 2
            item { player, b ->
                StickyStick(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s4(Stick(0)) //tier 2
            s7(Stick(0)) //tier 2
            s5(Slime(0)) //tier 2
            s8(Slime(0)) //tier 2
            item { player, b ->
                StickyStick(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s5(Stick(0)) //tier 2
            s8(Stick(0)) //tier 2
            s6(Slime(0)) //tier 2
            s9(Slime(0)) //tier 2
            item { player, b ->
                StickyStick(Utils.randRarity())
            }
        }
    },
    attackSpeed = 1.6
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