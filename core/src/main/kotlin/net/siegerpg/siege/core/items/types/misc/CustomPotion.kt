package net.siegerpg.siege.core.items.types.misc

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.enums.ItemTypes
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.miscellaneous.lore
import net.siegerpg.siege.core.miscellaneous.name
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.player.PlayerItemConsumeEvent
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

abstract class CustomPotion(
	override val name: String,
	override val customModelData: Int? = null,
	override val levelRequirement: Int? = null,
	override val description: List<String>,
	override val material: Material,
	final override var quality: Int = -1,
	override var item: ItemStack = ItemStack(material),
	override val type: ItemTypes = ItemTypes.FOOD,
                           ) : CustomItem {

	override var rarity: Rarity = Rarity.COMMON

	init {
		this.rarity = Rarity.getFromInt(this.quality)
	}

	open fun speciality(player: Player) {}

	@Suppress("deprecated")
	open fun onConsume(e: PlayerItemConsumeEvent) {
		e.isCancelled = true //cancelled to prevent player from drinking a vanilla type potion
		e.setItem(e.item.asQuantity(e.item.amount - 1))
		Bukkit.getScheduler().runTask(Core.plugin(), Runnable {
			speciality(e.player)
		})
	}

	override fun updateMeta(hideRarity: Boolean): ItemStack {

		val meta = item.itemMeta

		val shownRarity = if (hideRarity) Rarity.UNCOMMON else rarity

		meta.name(if (shownRarity == Rarity.SPECIAL) "<r><rainbow><b>$name</b></rainbow>" else "<r>${shownRarity.color}$name")

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
		result = 31 * result + rarity.hashCode()
		return result
	}
}