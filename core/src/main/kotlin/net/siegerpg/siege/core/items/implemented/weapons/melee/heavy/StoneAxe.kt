package net.siegerpg.siege.core.items.implemented.weapons.melee

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.mobDrops.*
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class StoneAxe() : CustomMeleeWeapon(
    name = "Stone Axe",
    customModelData = 130004,
    description = listOf("Commonly used for chopping trees"),
    levelRequirement = 15,
    material = Material.WOODEN_AXE,
    baseStats = CustomItemUtils.statMap(strength = 32.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Pebble(0)) //tier 3
            s2(Pebble(0)) //tier 3
            s4(Pebble(0)) //tier 3
            s5(Stick(0)) //tier 3
            s8(Stick(0)) //tier 3
            item { player, b ->
                StoneAxe(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s2(Pebble(0)) //tier 3
            s3(Pebble(0)) //tier 3
            s5(Pebble(0)) //tier 3
            s6(Stick(0)) //tier 3
            s9(Stick(0)) //tier 3
            item { player, b ->
                StoneAxe(Utils.randRarity())
            }
        }
    },
    attackSpeed = 0.8
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