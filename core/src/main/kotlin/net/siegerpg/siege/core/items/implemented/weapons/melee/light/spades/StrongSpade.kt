package net.siegerpg.siege.core.items.implemented.weapons.melee.light.spades

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Slime
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class StrongSpade() : CustomMeleeWeapon(
    name = "Strong Spade",
    customModelData = 110002,
    description = listOf("Not a shovel"),
    levelRequirement = 9,
    material = Material.WOODEN_SWORD,
    baseStats = CustomItemUtils.statMap(strength = 15.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Stick.tier(2))
            s2(Stick.tier(2))
            s3(Stick.tier(2))
            s4(Stick.tier(2))
            s5(Pebble.tier(2))
            s6(Bone.tier(1))
            s7(Bone.tier(1))
            s8(Bone.tier(1))
            s9(Bone.tier(1))
            item { player, b ->
                val newItem = StrongSpade(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
    },
    attackSpeed = 1.5
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