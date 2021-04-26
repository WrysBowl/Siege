package net.siegerpg.siege.core.items.implemented.weapons.melee

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.mobDrops.*
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ScrapyardBow() : CustomBow(
    name = "Scrapyard Bow",
    customModelData = 0,
    description = listOf("Instructions unclear . . . made an arrow flinger"),
    levelRequirement = 2,
    material = Material.BOW,
    baseStats = CustomItemUtils.statMap(strength = 5.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s2(Stick(0)) //tier 2
            s3(Vine(0)) //tier 2
            s4(Stick(0)) //tier 2
            s6(Vine(0)) //tier 2
            s8(Stick(0)) //tier 2
            s9(Vine(0)) //tier 2
            item { player, b ->
                ScrapyardBow(Utils.randRarity())
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