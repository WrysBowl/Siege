package net.siegerpg.siege.core.items.types.misc

import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.enums.ItemTypes
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.getNbtTag
import net.siegerpg.siege.core.miscellaneous.lore
import net.siegerpg.siege.core.miscellaneous.name
import net.siegerpg.siege.core.skills.Skill
import net.siegerpg.siege.core.skills.SkillClass
import net.siegerpg.siege.core.skills.SkillData
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

//be sure to remove excess variables (quality, recipe list, etc.) same with cosmetics
abstract class CustomSkill(
		override val name : String = "",
		override val customModelData : Int? = null,
		override val levelRequirement : Int? = null,
		override var rarity : Rarity = Rarity.RARE,
		override val description : List<String> = listOf(),
		override val material : Material = Material.BOOK,
		final override var quality : Int = -1,
		override var item : ItemStack = ItemStack(material),
		override val type : ItemTypes = ItemTypes.SKILL,
		val skill : Skill,
		var level : Int = 1,


		) : CustomItem {

	override fun updateMeta(hideRarity : Boolean) : ItemStack {
		val meta = item.itemMeta

		if (skill.skillClass.equals(SkillClass.WARRIOR)) meta.name("<color:#E35D73>$name")
		else if (skill.skillClass.equals(SkillClass.ARCHER)) meta.name("<color:#97CEEC>$name")
		else meta.name("<color:#DA97EC>$name")

		if (meta.hasLore()) meta.lore(mutableListOf())

		meta.lore(" ")
		meta.lore("<yellow>Right Click to")
		meta.lore("<yellow>Activate Skill")
		meta.lore("<underlined><dark_gray>                    ")

		meta.lore(" ")
		meta.lore(" <gray>Cooldown <aqua>${skill.getCooldown(level).seconds}s")
		meta.lore(" <gray>Mana <red>-${skill.getManaCost(level)}")
		meta.lore("<underlined><dark_gray>                    ")
		meta.lore(" ")

		description.forEach {
			meta.lore("<r><dark_gray>$it")
		}
		meta.lore("<underlined><dark_gray>                    ")

		meta.isUnbreakable = true
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE)
		item.itemMeta = meta
		return item
	}

	fun skillUse(e : PlayerInteractEvent) {
		skill.trigger(e.player)
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