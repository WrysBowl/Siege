package net.siegerpg.siege.core.items.types.misc

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.ItemTypes
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.getNbtTag
import net.siegerpg.siege.core.items.recipes.CustomRecipeList
import net.siegerpg.siege.core.items.setNbtTags
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.items.types.subtypes.CustomCosmetics
import net.siegerpg.siege.core.listeners.ArmorEquip.ArmorEquipEvent
import net.siegerpg.siege.core.utils.lore
import net.siegerpg.siege.core.utils.name
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.attribute.Attribute
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.LeatherArmorMeta

abstract class Cosmetic(
    override val name: String,
    override var customModelData: Int? = null,
    override val levelRequirement: Int? = null,
    override val description: List<String>,
    override val type: ItemTypes = ItemTypes.COSMETIC,
    override var material: Material,
    override val recipeList: CustomRecipeList? = null,
    final override var quality: Int = -1,
    override var item: ItemStack = ItemStack(material),
    var leatherColor: Color = Core.defaultLeatherColor
) : CustomCosmetics {

    override var rarity: Rarity = Rarity.COMMON


    init {
        this.rarity = Rarity.getFromInt(this.quality)
    }

    override fun updateMeta(hideRarity: Boolean): ItemStack {
        item.type = this.material
        val meta = item.itemMeta

        if (item.type == Material.LEATHER_BOOTS ||
            item.type == Material.LEATHER_LEGGINGS ||
            item.type == Material.LEATHER_CHESTPLATE ||
            item.type == Material.LEATHER_HELMET) {
            try {
                val leatherMeta = meta as LeatherArmorMeta
                meta.setColor(leatherColor)
                item.itemMeta = leatherMeta
            } catch (e: Error) {}
        }

        val shownRarity = if (hideRarity) Rarity.UNCOMMON else rarity

        meta.name(if (shownRarity == Rarity.SPECIAL) "<r><rainbow><b>$name</b></rainbow>" else "<r>${shownRarity.color}$name")
        meta.lore(if (shownRarity == Rarity.SPECIAL) "<r><rainbow><b>${shownRarity.id}</b></rainbow> Tier" else "<r>${shownRarity.color}${shownRarity.id} Tier")

        if (meta.hasLore()) meta.lore(mutableListOf())

        meta.lore("<r><color:#79ECEB><b>COSMETIC")

        if (!description.contains("")) {
            meta.lore(" ")
            description.forEach {
                meta.lore("<r><dark_gray>$it")
            }
        }

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
        result = 31 * result + leatherColor.hashCode()
        result = 31 * result + rarity.hashCode()
        return result
    }

}