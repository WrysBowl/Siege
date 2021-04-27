package net.siegerpg.siege.core.items.types.misc

import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.enums.ItemTypes
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.getNbtTag
import net.siegerpg.siege.core.items.recipes.CustomRecipeList
import net.siegerpg.siege.core.items.setNbtTags
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

abstract class StatGemType(
    override val name: String,
    override val customModelData: Int? = null,
    override val levelRequirement: Int? = null,
    override val description: List<String>,
    override val material: Material,
    override var quality: Int = -1,
    override var item: ItemStack = ItemStack(material),
    override val type: ItemTypes = ItemTypes.STATGEM,
    override val recipeList: CustomRecipeList? = null,
    val statType: StatTypes
) : CustomItem {

    override var rarity: Rarity = Rarity.COMMON

    open var statAmount: Double = 0.0
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
            "statGemTypeStat" to statType,
            "statGemTypeAmount" to statAmount
        )
    }
    override fun deserialize() {
        super.deserialize()
        item.getNbtTag<Double>("statGemTypeAmount")?.let {
            statAmount = it
        }
    }

    override fun updateMeta(hideRarity: Boolean) {

        val meta = item.itemMeta

        /*
        DisplayName and Lore has been changed to use strings instead of components. Will be fixed in the future
         */

        meta.displayName(Utils.parse(if (rarity == Rarity.SPECIAL) "<rainbow>$name</rainbow>" else "${rarity.color}$name"))

        val newLore = mutableListOf(Utils.parse(if (rarity == Rarity.SPECIAL) "<rainbow>$rarity</rainbow> <gray>${if (hideRarity) 50 else quality}%" else "${rarity.color}$rarity <gray>$quality%"))
        newLore.add(Utils.parse(" "))
        newLore.add(Utils.parse("<color:#FF3CFF>+${statAmount} <light_purple>${statType.stylizedName} Gem"))
        newLore.add(Utils.parse(" "))
        description.forEach {
            newLore.add(Utils.parse("<dark_gray>$it"))
        }
        newLore.add(Utils.parse(" "))
        newLore.add(Utils.parse("<gray>Level: $levelRequirement"))
        if (hideRarity) newLore.add(Utils.parse("<red>This is not the real item"))
        meta.lore(newLore)

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE)
        item.itemMeta = meta
    }

}