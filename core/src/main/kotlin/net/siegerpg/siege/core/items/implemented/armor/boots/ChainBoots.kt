package net.siegerpg.siege.core.items.implemented.armor.helmet

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.wands.GlowingTwig
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ChainBoots() : CustomHelmet(
    name = "Chain Boots",
    customModelData = 1,
    description = listOf("Not the best foot wear"),
    levelRequirement = 29,
    material = Material.CHAINMAIL_BOOTS,
    baseStats = CustomItemUtils.statMap(health = 60.0, toughness = 30.0, regeneration = 15.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Chain.tier(2)) //tier 2
            s3(Chain.tier(2)) //tier 2
            s4(Chain.tier(2)) //tier 2
            s6(Chain.tier(2)) //tier 2
            item { player, b ->
                ChainBoots(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s4(Chain.tier(2)) //tier 2
            s6(Chain.tier(2)) //tier 2
            s7(Chain.tier(2)) //tier 2
            s9(Chain.tier(2)) //tier 2
            item { player, b ->
                ChainBoots(Utils.randRarity())
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