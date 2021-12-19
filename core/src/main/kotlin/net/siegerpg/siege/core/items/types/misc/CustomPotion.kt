package net.siegerpg.siege.core.items.types.misc

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.enums.ItemTypes
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.listeners.NPC.Herbert
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.core.miscellaneous.lore
import net.siegerpg.siege.core.miscellaneous.name
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.player.PlayerItemConsumeEvent
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.PotionMeta
import org.bukkit.potion.PotionData
import org.bukkit.potion.PotionType

abstract class CustomPotion(
		override val name : String,
		override val customModelData : Int? = null,
		override val levelRequirement : Int? = null,
		override val description : List<String>,
		override val material : Material = Material.POTION,
		final override var quality : Int = -1,
		override var item : ItemStack = ItemStack(material),
		override val type : ItemTypes = ItemTypes.FOOD,
		val potion : PotionType = PotionType.INSTANT_HEAL
                           ) : CustomItem {

	override var rarity : Rarity = Rarity.COMMON

	init {
		this.rarity = Rarity.getFromInt(this.quality)
	}

	open fun speciality(player : Player) {}

	@Suppress("deprecated")
	open fun onConsume(e : PlayerItemConsumeEvent) {
		e.isCancelled =
				true //cancelled to prevent player from drinking a vanilla type potion
		Bukkit.getScheduler().runTask(Core.plugin(), Runnable {
			speciality(e.player)
		})
		e.player.inventory.setItemInMainHand(ItemStack(Material.AIR))
	}

	override fun updateMeta(hideRarity : Boolean) : ItemStack {

		val meta = item.itemMeta

		if (meta is PotionMeta) {
			item.type = material
			meta.basePotionData = PotionData(potion, false, false)
		}


		val shownRarity = if (hideRarity) Rarity.UNCOMMON else rarity

		meta.name(if (shownRarity == Rarity.SPECIAL) "<r><rainbow><b>$name</b></rainbow>" else "<r>${shownRarity.color}$name")

		if (meta.hasLore()) meta.lore(mutableListOf())

		meta.lore("<underlined><dark_gray>                    ")
		meta.lore(" ")
		Utils.getTextArray(description, 16).forEach {
			meta.lore("<r><dark_gray>$it")
		}
		meta.lore("<underlined><dark_gray>                    ")
		meta.lore(" ")
		meta.lore("<r><color:#E2DE5D>${Herbert.getSellValue(item)} \u26C1")

		meta.isUnbreakable = true
		meta.addItemFlags(
				ItemFlag.HIDE_ATTRIBUTES,
				ItemFlag.HIDE_UNBREAKABLE,
				ItemFlag.HIDE_POTION_EFFECTS
		                 )
		item.itemMeta = meta
		return item
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
		result = 31 * result + type.hashCode()
		result = 31 * result + rarity.hashCode()
		return result
	}
}