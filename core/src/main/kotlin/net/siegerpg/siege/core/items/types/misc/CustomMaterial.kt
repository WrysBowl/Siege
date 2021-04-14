package net.siegerpg.siege.core.items.types.misc

import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.enums.ItemTypes
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.getNbtTag
import net.siegerpg.siege.core.items.recipes.CustomRecipeList
import net.siegerpg.siege.core.items.setNbtTags
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

abstract class CustomMaterial(
    override val name: String,
    override val customModelData: Int? = null,
    override val levelRequirement: Int? = null,
    override val description: List<String>,
    override val material: Material,
    override var quality: Int = -1,
    override var item: ItemStack = ItemStack(material),
    override val type: ItemTypes = ItemTypes.MATERIAL,
    override val recipeList: CustomRecipeList? = null
) : CustomItem {

    override var rarity: Rarity = Rarity.COMMON

    var tier: Int = 1
        set(value) {
            field = value
            this.serialize()
        }

    init {
        rarity = Rarity.getFromInt(quality)
    }

    override fun serialize() {
        super.serialize()
        item = item.setNbtTags(
            "materialTier" to tier
        )
    }
    override fun deserialize() {
        super.deserialize()
        item.getNbtTag<Int>("materialTier")?.let {
            tier = it
        }
    }

    override fun updateMeta(hideRarity: Boolean) {

        val meta = item.itemMeta

        meta.displayName(Utils.parse("<gray>$name <yellow>${"✪".repeat(tier)}"))

        val newLore = mutableListOf(Utils.parse(" "))
        description.forEach {
            newLore.add(Utils.parse("<dark_gray>$it"))
        }
        meta.lore(newLore)

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE)
        item.itemMeta = meta
    }

}