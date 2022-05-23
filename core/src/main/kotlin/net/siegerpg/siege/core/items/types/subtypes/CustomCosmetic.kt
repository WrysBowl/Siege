package net.siegerpg.siege.core.items.types.subtypes

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent
import io.papermc.paper.event.player.AsyncChatEvent
import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.getNbtTag
import net.siegerpg.siege.core.items.setNbtTags
import net.siegerpg.siege.core.listeners.NPC.Herbert
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.core.miscellaneous.lore
import net.siegerpg.siege.core.miscellaneous.name
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.LeatherArmorMeta

interface CustomCosmetic : CustomItem {

	var leatherColor : Color

	fun onCosmeticInteract(e : PlayerInteractEvent) {}
	fun onCosmeticEquip(e : PlayerArmorChangeEvent) {}
	fun onCosmeticSpeak(e : AsyncChatEvent) {}
	fun onCosmeticDamage(e : EntityDamageByEntityEvent) {}

	override fun serialize() {
		super.serialize()
		item = item.setNbtTags(
				"leatherColor" to leatherColor.asRGB()
		                      )
	}

	override fun deserialize() {
		super.deserialize()
		try {
			item.getNbtTag<Int>("leatherColor")?.let {
				leatherColor = Color.fromRGB(it)
			}
		} catch (e : Exception) {
		}
	}

	override fun getSellValue() : Int {
		return 1
	}

	override fun updateMeta(hideRarity : Boolean) : ItemStack {
		item.type = this.material
		if (item.type == Material.LEATHER_BOOTS ||
		    item.type == Material.LEATHER_LEGGINGS ||
		    item.type == Material.LEATHER_CHESTPLATE ||
		    item.type == Material.LEATHER_HELMET
		) {
			try {
				val leatherMeta = item.itemMeta as LeatherArmorMeta
				leatherMeta.setColor(leatherColor)
				item.itemMeta = leatherMeta
			} catch (e : Error) {
			}
		}
		val meta = item.itemMeta

		val shownRarity = if (hideRarity) Rarity.UNCOMMON else rarity

		meta.name(if (shownRarity == Rarity.SPECIAL) "<r><rainbow><b>$name</b></rainbow>" else "<r>${shownRarity.color}$name")

		if (meta.hasLore()) meta.lore(mutableListOf())

		meta.lore("<r><color:#79ECEB><b>COSMETIC")
		val length =
				if (name.length > 16) name.length
				else 16
		if (!description.contains("")) {
			meta.lore(" ")
			Utils.getTextArray(description, length).forEach {
				meta.lore("<r><dark_gray>$it")
			}
		}
		meta.lore(" ")
		meta.lore("<r><color:#E2DE5D>${String.format("%,d",getSellValue())} \u26C1")
		meta.lore("")
		meta.lore(if (shownRarity == Rarity.SPECIAL) "<r><rainbow><b>${shownRarity.id}</b></rainbow> Tier" else "<r>${shownRarity.color}${shownRarity.id} Tier")
		meta.isUnbreakable = true
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE)

		item.itemMeta = meta
		return item
	}

}