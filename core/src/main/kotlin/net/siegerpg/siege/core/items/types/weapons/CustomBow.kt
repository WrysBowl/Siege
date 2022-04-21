package net.siegerpg.siege.core.items.types.weapons

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.ItemTypes
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.statgems.StatGem
import net.siegerpg.siege.core.items.types.misc.CustomSkill
import net.siegerpg.siege.core.items.types.subtypes.CustomWeapon
import net.siegerpg.siege.core.miscellaneous.lore
import net.siegerpg.siege.core.miscellaneous.name
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

abstract class CustomBow(
		override val name : String,
		override val customModelData : Int? = null,
		override val levelRequirement : Int? = null,
		override val description : List<String>,
		override val material : Material,
		final override var quality : Int = -1,
		override var item : ItemStack = ItemStack(material),
		override val baseStats : HashMap<StatTypes, Double>,
		override val type : ItemTypes = ItemTypes.BOW,
		override var statGem : StatGem? = null,
		override var skillBooks : List<CustomSkill?> = listOf(null),
		override var addedStats : HashMap<StatTypes, Double>? = null,
		override val gearSetInfo : List<String>? = null,
		) : CustomWeapon {

	override var rarity : Rarity = Rarity.COMMON

	init {
		this.rarity = Rarity.getFromInt(quality)
	}

	override fun updateMeta(hideRarity : Boolean) : ItemStack {
		super.updateMeta(hideRarity)
		val meta = item.itemMeta

		if (material == Material.CROSSBOW) {
			meta.addEnchant(Enchantment.PIERCING, 4, true)
			meta.addEnchant(Enchantment.QUICK_CHARGE, 3, true)
		}
		if (material == Material.TRIDENT) meta.addEnchant(Enchantment.LOYALTY, 3, true)

		meta.addItemFlags(
				ItemFlag.HIDE_ATTRIBUTES,
				ItemFlag.HIDE_UNBREAKABLE,
				ItemFlag.HIDE_ENCHANTS,
				ItemFlag.HIDE_DYE
		                 )

		item.itemMeta = meta
		return item
	}

	override fun displaySkillText(meta : ItemMeta) : ItemMeta {
		meta.lore(" ")
		for(skill in skillBooks) {
			if (skill == null) {
				meta.lore("<dark_gray>\u25C7 <italic>Skill Slot")
			} else {
				meta.lore("<r><color:#7fd4a4>[L-Click] <color:#5c9976>${skill.name}")
			}
		}
		return meta
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
		result = 31 * result + rarity.hashCode()
		return result
	}


}