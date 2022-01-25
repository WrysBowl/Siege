package net.siegerpg.siege.core.items.types.misc

import io.lumine.xikage.mythicmobs.MythicMobs.p
import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.enums.ItemTypes
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.getNbtTag
import net.siegerpg.siege.core.items.setNbtTags
import net.siegerpg.siege.core.listeners.NPC.Herbert
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.core.miscellaneous.lore
import net.siegerpg.siege.core.miscellaneous.name
import net.siegerpg.siege.core.skills.Skill
import net.siegerpg.siege.core.skills.SkillClass
import net.siegerpg.siege.core.skills.SkillCooldown
import net.siegerpg.siege.core.skills.SkillData
import net.siegerpg.siege.core.skills.warrior.Slash
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.Damageable
import org.bukkit.scheduler.BukkitRunnable
import java.time.Instant
import kotlin.math.ceil
import kotlin.math.max


//be sure to remove excess variables (quality, recipe list, etc.) same with cosmetics
@Suppress("unused")
abstract class CustomSkill(
		override val name : String = "",
		override val customModelData : Int? = null,
		override val levelRequirement : Int? = null,
		override var rarity : Rarity = Rarity.RARE,
		override val description : List<String> = listOf(),
		override val material : Material = Material.NETHERITE_SHOVEL,
		final override var quality : Int = -1,
		override var item : ItemStack = ItemStack(material),
		override val type : ItemTypes = ItemTypes.SKILL,
		val skill : Skill = Slash(),
		var level : Int = 1,
		override var sellCost : Int? = 1500 * level,


		) : CustomItem {

	override fun updateMeta(hideRarity : Boolean) : ItemStack {
		val meta = item.itemMeta

		if (skill.skillClass == SkillClass.WARRIOR) meta.name("<color:#E35D73>${skill.getName(level)}")
		else if (skill.skillClass == SkillClass.ARCHER) meta.name("<color:#97CEEC>${skill.getName(level)}")
		else meta.name("<color:#DA97EC>${skill.getName(level)}")

		if (meta.hasLore()) meta.lore(mutableListOf())

		meta.lore(" ")
		meta.lore(" <gray>Cooldown <aqua>${skill.getCooldown(level).seconds}s")
		meta.lore(" <gray>Mana <red>-${skill.getManaCost(level)}")

		val length =
				if (skill.getName(level).length > 16) skill.getName(level).length
				else 16
		meta.lore(" ")
		Utils.getTextArray(skill.description, length).forEach {
			meta.lore("<r><dark_gray>$it")
		}
		meta.lore(" ")
		meta.lore("<r><gray>Level <color:#BC74EE>$levelRequirement   <r><color:#E2DE5D>${String.format("%,d", Herbert.getSellValue(item))} \u26C1")

		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE)
		item.itemMeta = meta
		return item
	}

	fun skillUse(e : PlayerInteractEvent) {
		val player : Player = e.player

		//give player updated version of skill book
		val itemGiven : ItemStack = this.getUpdatedItem(false)
		player.inventory.setItemInMainHand(itemGiven)


		//check if player has skill unlocked
		val skillLevel = SkillData.getSkillLevel(player, skill) ?: 1
		/*
		if (skillLevel == null || skillLevel < 1) {
			player.sendMessage(Utils.lore("<red>You have not unlocked this skill."))
			return
		}
		*/
		this.level = skillLevel
		this.serialize()


		//check if skill passes conditions
		if(!skill.trigger(player, this.level)) return

		val initTime : Instant = Instant.now()
		val endTime : Instant = SkillCooldown.getResetTime(player.uniqueId, skill) ?: initTime.plusSeconds(3)
		val differenceInTicks : Long = (endTime.epochSecond - initTime.epochSecond) * 20

		val maxDurability = this.material.maxDurability
		val durabilityPerTick = maxDurability / differenceInTicks
		val inventorySlot : Int = player.inventory.heldItemSlot //inventory slot of item
		val meta : Damageable = itemGiven.itemMeta as Damageable
		meta.damage = maxDurability.toInt()
		var currentDamage : Double = meta.damage.toDouble()

		//change the durability to match cooldown
		object : BukkitRunnable() {
			override fun run() {
				val itemInSlot : ItemStack? = player.inventory.getItem(inventorySlot)
				if (itemInSlot == null) {
					this.cancel()
					return
				}
				if (itemInSlot.itemMeta?.displayName != itemGiven.itemMeta.displayName) {
					this.cancel()
					return
				}
				if (meta.damage <= 0) {
					this.cancel()
					return
				}
				currentDamage -= (durabilityPerTick * 4)
				meta.damage = currentDamage.toInt()
				itemGiven.itemMeta = meta

				player.inventory.setItem(inventorySlot, itemGiven)
			}

		}.runTaskTimer(Core.plugin(), 4, 4)
	}

	override fun serialize() {
		super.serialize()
		item = item.setNbtTags(
				"skillLevel" to level,
		                      )
	}

	override fun deserialize() {
		super.deserialize()
		item.getNbtTag<Int>("skillLevel")?.let {
			level = it
		}
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