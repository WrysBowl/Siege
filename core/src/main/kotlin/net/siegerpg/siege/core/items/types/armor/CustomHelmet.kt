package net.siegerpg.siege.core.items.types.armor

import net.siegerpg.siege.core.items.StatGem
import net.siegerpg.siege.core.items.enums.ItemTypes
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.recipes.CustomRecipeList
import net.siegerpg.siege.core.items.types.subtypes.CustomArmor
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

abstract class CustomHelmet(
    override val name: String,
    override val customModelData: Int? = null,
    override val levelRequirement: Int? = null,
    override val description: List<String>,
    override val material: Material,
    override var quality: Int = -1,
    override var item: ItemStack = ItemStack(material),
    override val baseStats: HashMap<StatTypes, Double>,
    override val type: ItemTypes = ItemTypes.HELMET,
    override val recipeList: CustomRecipeList? = null,
    override var statGem: StatGem? = null
) : CustomArmor {

    override var rarity: Rarity = Rarity.COMMON

    init {
        rarity = Rarity.getFromInt(quality)
    }


}