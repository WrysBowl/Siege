package net.siegerpg.siege.core.items.types.misc

import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.enums.ItemTypes
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.getNbtTag
import net.siegerpg.siege.core.items.recipes.CustomRecipeList
import net.siegerpg.siege.core.items.setNbtTags
import net.siegerpg.siege.core.utils.lore
import net.siegerpg.siege.core.utils.name
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

abstract class CustomMaterial(
    override val name: String,
    override val customModelData: Int? = null,
    override val levelRequirement: Int? = null,
    override val description: List<String>,
    override val material: Material,
    final override var quality: Int = -1,
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
        this.rarity = Rarity.getFromInt(this.quality)
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

    override fun updateMeta(hideRarity: Boolean): ItemStack {

        val meta = item.itemMeta

        meta.name("<r><gray>$name <yellow>${"\u272A".repeat(tier)}")

        if (meta.hasLore()) meta.lore(mutableListOf())

        meta.lore(" ")
        description.forEach {
           meta.lore("<r><dark_gray>$it")
        }

        meta.isUnbreakable = true
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE)
        item.itemMeta = meta
        return item
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        Bukkit.getLogger().info("Other is not null")
        if (this::class.qualifiedName != other!!::class.qualifiedName) return false
        Bukkit.getLogger().info("Qualified names match")
        val castedOther = other as CustomMaterial

        if (this.tier != castedOther.tier) return false
        Bukkit.getLogger().info("Tiers match")
        return true
    }


}