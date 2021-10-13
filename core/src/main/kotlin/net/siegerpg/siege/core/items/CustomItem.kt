package net.siegerpg.siege.core.items

import net.siegerpg.siege.core.items.enums.ItemTypes
import net.siegerpg.siege.core.items.enums.Rarity
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

interface CustomItem {
    val name: String
    val customModelData: Int?
    val levelRequirement: Int?
    val description: List<String>
    val type: ItemTypes
    val material: Material
    var quality: Int
    var rarity: Rarity
    var item: ItemStack

    fun updateMeta(hideRarity: Boolean): ItemStack

    fun getUpdatedItem(hideRarity: Boolean): ItemStack {
        return updateMeta(hideRarity)

    }

    fun serialize() {
        item = item.setNbtTags(
            "itemClass" to this::class.qualifiedName,
            "itemName" to name,
            "CustomModelData" to customModelData,
            "itemLevelRequirement" to levelRequirement,
            "itemType" to type.toString(),
            "itemQuality" to quality,
            "itemRarity" to rarity.toString()
        )
    }

    fun deserialize() {
        item.getNbtTag<Int>("itemQuality")?.let {
            quality = it
            rarity = Rarity.getFromInt(quality)
        }

    }

}