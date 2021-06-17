package net.siegerpg.siege.core.items.types.misc

import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.enums.ItemTypes
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.recipes.CustomRecipeList
import net.siegerpg.siege.core.utils.lore
import net.siegerpg.siege.core.utils.name
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

abstract class CustomTool(
    override val name: String,
    override val customModelData: Int? = null,
    override val levelRequirement: Int? = null,
    override val description: List<String>,
    override val material: Material,
    final override var quality: Int = -1,
    override var item: ItemStack = ItemStack(material),
    override val type: ItemTypes = ItemTypes.MATERIAL,
    override val recipeList: CustomRecipeList? = null,
    val enchantments: MutableMap<Enchantment, Int>
) : CustomItem {

    override var rarity: Rarity = Rarity.COMMON

    init {
        this.rarity = Rarity.getFromInt(this.quality)
    }

    override fun updateMeta(hideRarity: Boolean): ItemStack {

        val meta = item.itemMeta

        meta.name("<r><gray>$name")

        if (meta.hasLore()) meta.lore(mutableListOf())

        meta.lore(" ")
        description.forEach {
            meta.lore("<r><dark_gray>$it")
        }

        meta.isUnbreakable = true
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ENCHANTS)
        enchantments.forEach { (key, value) ->
            meta.addEnchant(key, value, true)
        }
        item.itemMeta = meta
        return item
    }

    override fun equals(other: Any?): Boolean {
        other?.let { return false }
        if (this::class.qualifiedName != other!!::class.qualifiedName) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + (customModelData ?: 0)
        result = 31 * result + (levelRequirement ?: 0)
        result = 31 * result + description.hashCode()
        result = 31 * result + material.hashCode()
        result = 31 * result + quality
        result = 31 * result + item.hashCode()
        result = 31 * result + type.hashCode()
        result = 31 * result + (recipeList?.hashCode() ?: 0)
        result = 31 * result + enchantments.hashCode()
        result = 31 * result + rarity.hashCode()
        return result
    }


}