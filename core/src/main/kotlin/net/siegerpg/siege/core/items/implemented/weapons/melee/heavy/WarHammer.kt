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

class WarHammer() : CustomMeleeWeapon(
    name = "War Hammer",
    customModelData = 130007,
    description = listOf("Both ends have proven to be deadly"),
    levelRequirement = 27,
    material = Material.WOODEN_AXE,
    baseStats = CustomItemUtils.statMap(strength = 52.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Pebble(0)) //tier 3
            s2(MetalScrap(0)) //tier 3
            s3(Pebble(0)) //tier 3
            s4(Pebble(0)) //tier 3
            s5(Stick(0)) //tier 3
            s6(Pebble(0)) //tier 3
            s7(Stick(0)) //tier 3
            item { player, b ->
                Longsword(Utils.randRarity())
            }
        }
    },
    attackSpeed = 0.7
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