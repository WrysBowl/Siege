package net.siegerpg.siege.core.items.types.armor

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.ItemTypes
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.getNbtTag
import net.siegerpg.siege.core.items.setNbtTags
import net.siegerpg.siege.core.items.statgems.StatGem
import net.siegerpg.siege.core.items.types.misc.Cosmetic
import net.siegerpg.siege.core.items.types.subtypes.CustomArmor
import net.siegerpg.siege.core.items.types.subtypes.CustomCosmetic
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

abstract class CustomHelmet(
		override val name : String,
		override var customModelData : Int? = null,
		override val levelRequirement : Int? = null,
		override val description : List<String>,
		override var material : Material,
		final override var quality : Int = -1,
		override var item : ItemStack = ItemStack(material),
		override val baseStats : HashMap<StatTypes, Double>,
		override val type : ItemTypes = ItemTypes.HELMET,
		override var statGem : StatGem? = null,
		override var addedStats : HashMap<StatTypes, Double>? = null,
		override var leatherColor : Color = Core.defaultLeatherColor,
		override val gearSetInfo : List<List<String>>? = null,
		var initMaterial : Material? = null,
		var initCustomModelData : Int? = null,
		var storedItem : ItemStack? = null
                           ) : CustomArmor {

	override var rarity : Rarity = Rarity.COMMON

	init {
		this.rarity = Rarity.getFromInt(this.quality)
	}

	override fun serialize() {
		super.serialize()
		item = item.setNbtTags(
				"initMaterial" to initMaterial.toString(),
				"initCustomModelData" to initCustomModelData,
				"storedItem" to storedItem,
		                      ) //need to now figure out how to deserialize and create the item with a method
	}

	override fun deserialize() {
		super.deserialize()
		try {
			item.getNbtTag<String>("initMaterial")?.let {
				initMaterial = Material.valueOf(it)
			}
			item.getNbtTag<Int>("initCustomModelData")?.let {
				initCustomModelData = it
			}
			item.getNbtTag<ItemStack>("storedItem")?.let {
				storedItem = it
			}
		} catch (e : Exception) {
		}
	}

	fun fuseCosmetic(cosmetic : CustomCosmetic) {

		this.storedItem = cosmetic.item.asOne() //store the cosmetic item
		this.initMaterial = this.material //store the original material
		this.initCustomModelData =
				this.customModelData //store the original customModelData

		this.material = cosmetic.material
		this.customModelData = cosmetic.customModelData
		this.leatherColor = cosmetic.leatherColor

		this.serialize()
	}

	fun unFuseCosmetic(hideRarity : Boolean) : ItemStack? {
		val nbtItem : CustomItem =
				CustomItemUtils.getCustomItem(this.storedItem) ?: return null
		if (nbtItem !is Cosmetic) return null

		this.item = nbtItem.item

		this.storedItem = null
		this.initMaterial = null
		this.initCustomModelData = null
		this.serialize()
		return nbtItem.getUpdatedItem(hideRarity)
	}

	override fun equals(other : Any?) : Boolean {
		other?.let { return false }
		if (this::class.qualifiedName != other!!::class.qualifiedName) return false
		return true
	}

	override fun hashCode() : Int {
		var result = name.hashCode()
		result = 31 * result + (customModelData ?: 0)
		result = 31 * result + (levelRequirement ?: 0)
		result = 31 * result + description.hashCode()
		result = 31 * result + material.hashCode()
		result = 31 * result + quality
		result = 31 * result + item.hashCode()
		result = 31 * result + baseStats.hashCode()
		result = 31 * result + type.hashCode()
		result = 31 * result + (statGem?.hashCode() ?: 0)
		result = 31 * result + leatherColor.hashCode()
		result = 31 * result + (initMaterial?.hashCode() ?: 0)
		result = 31 * result + (initCustomModelData ?: 0)
		result = 31 * result + (storedItem?.hashCode() ?: 0)
		result = 31 * result + rarity.hashCode()
		return result
	}
}