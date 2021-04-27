package net.siegerpg.siege.core.items.implemented.weapons.melee

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.Stick
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.Vine
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class PebbleShooter() : CustomBow(
    name = "Pebble Shooter",
    customModelData = 0,
    description = listOf("Now comes with pebble shooting support!"),
    levelRequirement = 10,
    material = Material.BOW, //This needs to be changed to a crossbow
    baseStats = CustomItemUtils.statMap(strength = 12.0, luck = 5.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s2(Pebble(0)) //tier 3
            s4(Stick(0)) //tier 3
            s6(Stick(0)) //tier 3
            s7(Vine(0)) //tier 3
            s8(Vine(0)) //tier 3
            s9(Vine(0)) //tier 3
            item { player, b ->
                PebbleShooter(Utils.randRarity())
            }
        }
    },
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