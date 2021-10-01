package net.siegerpg.siege.core.items.types.armor

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.ItemTypes
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.getNbtTag
import net.siegerpg.siege.core.items.recipes.CustomRecipeList
import net.siegerpg.siege.core.items.setNbtTags
import net.siegerpg.siege.core.items.statgems.StatGem
import net.siegerpg.siege.core.items.types.subtypes.CustomArmor
import org.bukkit.Bukkit
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

abstract class CustomHelmet(
    override val name: String,
    override var customModelData: Int? = null,
    override val levelRequirement: Int? = null,
    override val description: List<String>,
    override var material: Material,
    final override var quality: Int = -1,
    override var item: ItemStack = ItemStack(material),
    override val baseStats: HashMap<StatTypes, Double>,
    override val type: ItemTypes = ItemTypes.HELMET,
    override val recipeList: CustomRecipeList? = null,
    override var statGem: StatGem? = null,
    override var leatherColor: Color = Core.defaultLeatherColor,
    val cosmetic: Boolean = false,
    var initMaterial: Material? = null,
    var initCustomModelData: Int? = null,
    var storedItem: ItemStack? = null
) : CustomArmor {

    override var rarity: Rarity = Rarity.COMMON

    init {
        this.rarity = Rarity.getFromInt(this.quality)
    }

    override fun equals(other: Any?): Boolean {
        other?.let { return false }
        if (this::class.qualifiedName != other!!::class.qualifiedName) return false
        return true
    }

    fun fuseCosmetic(cosmetic: CustomHelmet) {

        this.storedItem = cosmetic.item //store the cosmetic item
        this.initMaterial = this.material //store the original material
        this.initCustomModelData = this.customModelData //store the original customModelData

        this.material = cosmetic.material
        this.customModelData = cosmetic.customModelData
        this.leatherColor = cosmetic.leatherColor

        this.serialize()
    }

    fun unFuseCosmetic(hideRarity: Boolean): ItemStack? {
        val nbtItem: CustomItem = CustomItemUtils.getCustomItem(this.storedItem) ?: return null
        if (nbtItem !is CustomHelmet) return null

        this.item = nbtItem.item

        this.storedItem = null
        this.initMaterial = null
        this.initCustomModelData = null
        this.serialize()

        return nbtItem.getUpdatedItem(hideRarity)
    }

    override fun serialize() {
        super.serialize()
        item = item.setNbtTags(
            "cosmetic" to cosmetic,
            "initMaterial" to initMaterial.toString(),
            "initCustomModelData" to initCustomModelData,
            "storedItem" to storedItem
        ) //need to now figure out how to deserialize and create the item with a method
    }

    override fun deserialize() {
        super.deserialize()
        try {
            item.getNbtTag<String>("initMaterial")?.let {
                initMaterial = Material.valueOf(it)
                Bukkit.getLogger().info("1 initMaterial: $it")
            }
            item.getNbtTag<Int>("initCustomModelData")?.let {
                initCustomModelData = it
                Bukkit.getLogger().info("1 initCustomModelData: $it")
            }
            item.getNbtTag<ItemStack>("storedItem")?.let {
                storedItem = it
                Bukkit.getLogger().info("1 storedItem: $it")
            }
        } catch(e: Exception) { }
    }
}