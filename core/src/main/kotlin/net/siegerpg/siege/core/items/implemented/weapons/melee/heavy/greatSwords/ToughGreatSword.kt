package net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.greatSwords

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.MetalScrap
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ToughGreatSword() : CustomMeleeWeapon(
    name = "Tough Great Sword",
    customModelData = 130006,
    description = listOf("A typical medieval weapon"),
    levelRequirement = 23,
    material = Material.WOODEN_AXE,
    baseStats = CustomItemUtils.statMap(strength = 30.0, toughness = 50.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(MetalScrap.tier(3))
            s2(Stick.tier(3))
            s3(Pebble.tier(3))
            s4(Pebble.tier(3))
            s5(Pebble.tier(3))
            item { player, b ->
                val newItem = ToughGreatSword(if (b) 50 else Utils.randRarity())
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