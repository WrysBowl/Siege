package net.siegerpg.siege.core.items.implemented.armor.leggings

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class BeePants() : CustomLeggings(
    name = "Bee Stinger",
    customModelData = 1,
    description = listOf("Sting like a bee!"),
    levelRequirement = 12,
    material = Material.LEATHER_LEGGINGS,
    baseStats = CustomItemUtils.statMap(health = 20.0, strength = 5.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Seed.tier(3))
            s2(Magma.tier(3))
            s3(Seed.tier(3))
            s4(Seed.tier(2))
            s6(Seed.tier(2))
            s7(Seed.tier(2))
            s9(Seed.tier(2))
            item { player, b ->
                val newItem = BeePants(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
    },
    leatherColor = Color.YELLOW
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