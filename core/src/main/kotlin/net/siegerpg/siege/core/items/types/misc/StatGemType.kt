package net.siegerpg.siege.core.items.types.misc

import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.enums.ItemTypes
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.getNbtTag
import net.siegerpg.siege.core.items.recipes.CustomRecipeList
import net.siegerpg.siege.core.items.setNbtTags
import net.siegerpg.siege.core.utils.lore
import net.siegerpg.siege.core.utils.name
import org.bukkit.Material
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import kotlin.math.floor
import kotlin.math.pow

abstract class StatGemType(
    override val name: String,
    override val customModelData: Int? = null,
    override val levelRequirement: Int? = null,
    override val description: List<String>,
    override val material: Material,
    final override var quality: Int = -1,
    override var item: ItemStack = ItemStack(material),
    override val type: ItemTypes = ItemTypes.STATGEM,
    override val recipeList: CustomRecipeList? = null,
    val statType: StatTypes,
    val statAmount: Double = 0.0
) : CustomItem {

    override var rarity: Rarity = Rarity.COMMON


    init {
        this.rarity = Rarity.getFromInt(this.quality)
    }

    override fun serialize() {
        super.serialize()
        item = item.setNbtTags(
            "statGemTypeStat" to statType,
            "statGemTypeAmount" to statAmount
        )
    }

    override fun updateMeta(hideRarity: Boolean): ItemStack {

        val meta = item.itemMeta

        val shownRarity = if (hideRarity) Rarity.UNCOMMON else rarity

        meta.name(if (shownRarity == Rarity.SPECIAL) "<r><rainbow><b>$name</b></rainbow>" else "<r>${shownRarity.color}$name")

        if (meta.hasLore()) meta.lore(mutableListOf())

        meta.lore(if (shownRarity == Rarity.SPECIAL) "<r><rainbow><b>${shownRarity.id}</b></rainbow> <gray>${if (hideRarity) 50 else quality}%" else "<r>${shownRarity.color}${shownRarity.id} <gray>${if (hideRarity) 50 else quality}%")
        meta.lore(" ")
        meta.lore("<r><color:#FF3CFF>+${statAmount} <light_purple>${statType.stylizedName} Gem")
        meta.lore(" ")
        description.forEach {
            meta.lore("<r><dark_gray>$it")
        }
        meta.lore(" ")
        meta.lore("<yellow>$ ${floor(statAmount.pow(3))} <yellow>to Use")
        meta.lore("<r><gray>Level: $levelRequirement")
        if (hideRarity) meta.lore("<r><red>This is not the real item")

        meta.isUnbreakable = true
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE)
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
        result = 31 * result + statType.hashCode()
        result = 31 * result + statAmount.hashCode()
        result = 31 * result + rarity.hashCode()
        return result
    }

}