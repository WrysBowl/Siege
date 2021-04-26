package net.siegerpg.siege.core.items.implemented.weapons.melee

import com.sk89q.worldedit.world.item.ItemTypes.CROSSBOW
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.mobDrops.*
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Crossbow() : CustomBow(
    name = "Crossbow",
    customModelData = 0,
    description = listOf("The OG pistol"),
    levelRequirement = 26,
    material = Material.BOW, //This needs to be changed to a crossbow
    baseStats = CustomItemUtils.statMap(strength = 20.0, luck = 11.0),
    recipeList = recipes {
    },
) {

    constructor(quality: Int): this() {
        this.quality = quality
        this.rarity = Rarity.getFromInt(quality)
    }

    constructor(item: ItemStack): this() {
        this.item = item
        deserialize()
    }

}