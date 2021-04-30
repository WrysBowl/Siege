package net.siegerpg.siege.core.items.implemented.weapons.melee.heavy

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class EarthernHammer() : CustomMeleeWeapon(
    name = "Earthern Hammer",
    customModelData = 130010,
    description = listOf("Let's go clobbing!"),
    levelRequirement = 39,
    material = Material.WOODEN_AXE,
    baseStats = CustomItemUtils.statMap(strength = 70.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(PlantMatter(0)) //tier 4
            s2(Stick(0)) //tier 3
            s4(PlantMatter(0)) //tier 4
            s5(Stick(0)) //tier 3
            s8(Stick(0)) //tier 3
            item { player, b ->
                EarthernHammer(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s2(PlantMatter(0)) //tier 4
            s3(Stick(0)) //tier 3
            s5(PlantMatter(0)) //tier 4
            s6(Stick(0)) //tier 3
            s9(Stick(0)) //tier 3
            item { player, b ->
                EarthernHammer(Utils.randRarity())
            }
        }
    },
    attackSpeed = 0.7
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