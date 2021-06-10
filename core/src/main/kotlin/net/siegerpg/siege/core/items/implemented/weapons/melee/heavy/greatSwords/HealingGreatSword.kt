package net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.greatSwords

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealingGreatSword() : CustomMeleeWeapon(
    name = "Healing Great Sword",
    customModelData = 130006,
    description = listOf("A typical medieval weapon"),
    levelRequirement = 23,
    material = Material.WOODEN_AXE,
    baseStats = CustomItemUtils.statMap(strength = 32.0, regeneration = 5.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(MetalScrap.tier(3))
            s2(Stick.tier(3))
            s3(Wheat.tier(4))
            item { player, b ->
                val newItem = HealingGreatSword(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
    },
    attackSpeed = 0.9
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