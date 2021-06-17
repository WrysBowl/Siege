package net.siegerpg.siege.core.items.implemented.weapons.melee.light.scrapShards

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.MetalScrap
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealthyScrapShard() : CustomMeleeWeapon(
    name = "Healthy Scrap Shard",
    customModelData = 110008,
    description = listOf("Scrap metal put together", "to create a sharp shank"),
    levelRequirement = 29,
    material = Material.WOODEN_SWORD,
    baseStats = CustomItemUtils.statMap(strength = 28.0, health = 10.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(MetalScrap.tier(3))
            s2(PlantMatter.tier(3))
            s3(PlantMatter.tier(3))
            item { player, b ->
                val newItem = HealthyScrapShard(if (b) 50 else Utils.randRarity())
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