package net.siegerpg.siege.core.items.implemented.weapons.ranged

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Vine
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class BeginnerScrapyardBow() : CustomBow(
    name = "Beginner Scrapyard Bow",
    customModelData = 0,
    description = listOf("Try out this ranged weapon!"),
    levelRequirement = 0,
    material = Material.BOW,
    baseStats = CustomItemUtils.statMap(strength = 5.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s2(Stick.tier(2))
            s3(Vine.tier(2))
            s4(Stick.tier(2))
            s6(Vine.tier(2))
            s8(Stick.tier(2))
            s9(Vine.tier(2))
            item { player, b ->
                val newItem = ScrapyardBow(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
    },
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