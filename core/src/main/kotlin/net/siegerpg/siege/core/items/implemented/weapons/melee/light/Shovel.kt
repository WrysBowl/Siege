package net.siegerpg.siege.core.items.implemented.weapons.melee.light

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.Stick
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Shovel() : CustomMeleeWeapon(
    name = "Shovel",
    customModelData = 110004,
    description = listOf("A true grave digger"),
    levelRequirement = 7,
    material = Material.WOODEN_SWORD,
    baseStats = CustomItemUtils.statMap(strength = 17.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Pebble(0)) //tier 2
            s4(Stick(0)) //tier 3
            s7(Stick(0)) //tier 3
            item { player, b ->
                Shovel(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s2(Pebble(0)) //tier 2
            s5(Stick(0)) //tier 3
            s8(Stick(0)) //tier 3
            item { player, b ->
                Shovel(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s3(Pebble(0)) //tier 2
            s6(Stick(0)) //tier 3
            s9(Stick(0)) //tier 3
            item { player, b ->
                Shovel(Utils.randRarity())
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