package net.siegerpg.siege.core.items.implemented.weapons.melee.heavy

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.RefinedMetal
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class LuckyIronAxe() : CustomMeleeWeapon(
    name = "Lucky Iron Axe",
    customModelData = 130008,
    description = listOf("A fast tree cutter"),
    levelRequirement = 31,
    material = Material.WOODEN_AXE,
    baseStats = CustomItemUtils.statMap(strength = 36.0, luck = 5.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(RefinedMetal.tier(3))
            s2(RefinedMetal.tier(3))
            s3(Stick.tier(3))
            s4(Stick.tier(3))
            s5(Feather.tier(3))
            s6(Feather.tier(3))
            item { player, b ->
                val newItem = LuckyIronAxe(if (b) 50 else Utils.randRarity())
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