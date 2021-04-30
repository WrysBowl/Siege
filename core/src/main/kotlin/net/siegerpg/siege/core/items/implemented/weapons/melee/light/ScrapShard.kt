package net.siegerpg.siege.core.items.implemented.weapons.melee.light

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.MetalScrap
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ScrapShard() : CustomMeleeWeapon(
    name = "Scrap Shard",
    customModelData = 110008,
    description = listOf("Scrap metal put together to create a sharp shank"),
    levelRequirement = 18,
    material = Material.WOODEN_SWORD,
    baseStats = CustomItemUtils.statMap(strength = 34.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(MetalScrap(0)) //tier 3
            s4(MetalScrap(0)) //tier 3
            item { player, b ->
                ScrapShard(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s2(MetalScrap(0)) //tier 3
            s5(MetalScrap(0)) //tier 3
            item { player, b ->
                ScrapShard(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s3(MetalScrap(0)) //tier 3
            s6(MetalScrap(0)) //tier 3
            item { player, b ->
                ScrapShard(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s4(MetalScrap(0)) //tier 3
            s7(MetalScrap(0)) //tier 3
            item { player, b ->
                ScrapShard(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s5(MetalScrap(0)) //tier 3
            s8(MetalScrap(0)) //tier 3
            item { player, b ->
                ScrapShard(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s6(MetalScrap(0)) //tier 3
            s9(MetalScrap(0)) //tier 3
            item { player, b ->
                ScrapShard(Utils.randRarity())
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