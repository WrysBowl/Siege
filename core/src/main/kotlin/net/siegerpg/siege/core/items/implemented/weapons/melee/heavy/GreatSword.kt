package net.siegerpg.siege.core.items.implemented.weapons.melee.heavy

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.blocks.MetalScrap
import net.siegerpg.siege.core.items.implemented.misc.materials.blocks.Stick
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class GreatSword() : CustomMeleeWeapon(
    name = "Great Sword",
    customModelData = 130006,
    description = listOf("A typical medieval weapon"),
    levelRequirement = 23,
    material = Material.WOODEN_AXE,
    baseStats = CustomItemUtils.statMap(strength = 36.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(MetalScrap.tier(3))
            s4(MetalScrap.tier(3))
            s7(Stick.tier(3))
            item { player, b ->
                val newItem = GreatSword(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s2(MetalScrap.tier(3))
            s5(MetalScrap.tier(3))
            s8(Stick.tier(3))
            item { player, b ->
                val newItem = GreatSword(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s3(MetalScrap.tier(3))
            s6(MetalScrap.tier(3))
            s9(Stick.tier(3))
            item { player, b ->
                val newItem = GreatSword(if (b) 50 else Utils.randRarity())
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