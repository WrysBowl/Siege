package net.siegerpg.siege.core.items.implemented.weapons.melee.heavy

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealingIronAxe() : CustomMeleeWeapon(
    name = "Healing Iron Axe",
    customModelData = 130008,
    description = listOf("A fast tree cutter"),
    levelRequirement = 31,
    material = Material.WOODEN_AXE,
    baseStats = CustomItemUtils.statMap(strength = 35.0, regeneration = 7.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(RefinedMetal.tier(3))
            s2(RefinedMetal.tier(3))
            s3(Stick.tier(3))
            s4(Stick.tier(3))
            s5(Wheat.tier(4))
            item { player, b ->
                val newItem = HealingIronAxe(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
    },
    attackSpeed = 1.0
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