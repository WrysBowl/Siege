package net.siegerpg.siege.core.items.types.misc

import net.siegerpg.siege.core.items.StatGem
import net.siegerpg.siege.core.items.enums.ItemTypes
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.recipes.CustomRecipeList
import net.siegerpg.siege.core.items.setNbtTags
import net.siegerpg.siege.core.items.types.subtypes.CustomEquipment
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

abstract class CustomWand(
    override val name: String,
    override val customModelData: Int? = null,
    override val levelRequirement: Int? = null,
    override val description: List<String>,
    override val material: Material,
    override var quality: Int = -1,
    override var item: ItemStack = ItemStack(material),
    override val type: ItemTypes = ItemTypes.WAND,
    override val recipeList: CustomRecipeList? = null,
    override val baseStats: HashMap<StatTypes, Double>,
    val range: Int = 12,
    val red: Int = 255,
    val green: Int = 255,
    val blue: Int = 255,
    val damageRadius: Double = 2.5,
    override var statGem: StatGem? = null
) : CustomEquipment {

    override var rarity: Rarity = Rarity.COMMON

    init {
        rarity = Rarity.getFromInt(quality)
    }

    override fun serialize() {
        super.serialize()
        item = item.setNbtTags(
            "wandRange" to range,
            "wandRed" to red,
            "wandGreen" to green,
            "wandBlue" to blue,
            "wandDamageRadius" to damageRadius
        )
    }


}