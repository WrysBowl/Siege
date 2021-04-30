package net.siegerpg.siege.core.items.implemented.weapons.melee

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Shovel
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class TestSword() : CustomMeleeWeapon(
    name = "Test Sword",
    customModelData = 1,
    description = listOf("A sword for testing"),
    levelRequirement = 0,
    material = Material.DIAMOND_SWORD,
    baseStats = CustomItemUtils.statMap(strength = 10.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(PlantMatter.tier(1))
            s4(PlantMatter.tier(1))
            item { player, b ->
                val newItem = TestSword(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
    },
    attackSpeed = 1.7
) {

    constructor(quality: Int): this() {
        this.quality = quality
        this.rarity = Rarity.getFromInt(quality)
        this.serialize()
    }

    @Suppress("unused")
    constructor(item: ItemStack): this() {
        this.item = item
        deserialize()
    }

}