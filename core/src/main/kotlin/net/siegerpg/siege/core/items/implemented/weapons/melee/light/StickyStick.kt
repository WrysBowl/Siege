package net.siegerpg.siege.core.items.implemented.weapons.melee.light

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Slime
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
            s1(Stick.tier(2)) //tier 2
            s4(Stick.tier(2)) //tier 2
            s2(Slime.tier(2)) //tier 2
            s5(Slime.tier(2)) //tier 2
            item { player, b ->
                StickyStick(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s2(Stick.tier(2)) //tier 2
            s5(Stick.tier(2)) //tier 2
            s3(Slime.tier(2)) //tier 2
            s6(Slime.tier(2)) //tier 2
            item { player, b ->
                StickyStick(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s4(Stick.tier(2)) //tier 2
            s7(Stick.tier(2)) //tier 2
            s5(Slime.tier(2)) //tier 2
            s8(Slime.tier(2)) //tier 2
            item { player, b ->
                StickyStick(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s5(Stick.tier(2)) //tier 2
            s8(Stick.tier(2)) //tier 2
            s6(Slime.tier(2)) //tier 2
            s9(Slime.tier(2)) //tier 2
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
        this.serialize()
    }

    constructor(item: ItemStack): this() {
        this.item = item
        deserialize()
    }

}