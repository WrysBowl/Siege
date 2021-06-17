package net.siegerpg.siege.core.items.implemented.weapons.melee.light

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.RefinedMetal
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ToughRefinedDagger() : CustomMeleeWeapon(
    name = "Tough Refined Dagger",
    customModelData = 110010,
    description = listOf("A dagger, but shinier", "and more pointy"),
    levelRequirement = 37,
    material = Material.WOODEN_SWORD,
    baseStats = CustomItemUtils.statMap(strength = 34.0, toughness = 60.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(RefinedMetal.tier(2))
            s2(RefinedMetal.tier(2))
            s3(RefinedMetal.tier(2))
            s4(RefinedMetal.tier(2))
            s5(Stick.tier(3))
            s6(Pebble.tier(3))
            s7(Pebble.tier(3))
            item { player, b ->
                val newItem = ToughRefinedDagger(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
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