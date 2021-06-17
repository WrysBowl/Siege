package net.siegerpg.siege.core.items.implemented.weapons.melee.light.scrapShards

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.MetalScrap
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class StrongScrapShard() : CustomMeleeWeapon(
    name = "Strong Scrap Shard",
    customModelData = 110008,
    description = listOf("Scrap metal put together", "to create a sharp shank"),
    levelRequirement = 29,
    material = Material.WOODEN_SWORD,
    baseStats = CustomItemUtils.statMap(strength = 38.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(MetalScrap.tier(3))
            s2(Bone.tier(3))
            s3(Bone.tier(3))
            item { player, b ->
                val newItem = StrongScrapShard(if (b) 50 else Utils.randRarity())
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