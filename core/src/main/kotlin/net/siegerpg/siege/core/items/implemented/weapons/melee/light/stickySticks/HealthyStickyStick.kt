package net.siegerpg.siege.core.items.implemented.weapons.melee.light.stickySticks

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Slime
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealthyStickyStick() : CustomMeleeWeapon(
    name = "Healthy Sticky Stick",
    customModelData = 110002,
    description = listOf("Globs of slime on a stick"),
    levelRequirement = 5,
    material = Material.WOODEN_SWORD,
    baseStats = CustomItemUtils.statMap(strength = 5.0, health = 4.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Stick.tier(2))
            s2(Slime.tier(2))
            s3(Stick.tier(2))
            s4(PlantMatter.tier(2))
            item { player, b ->
                val newItem = HealthyStickyStick(if (b) 50 else Utils.randRarity())
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