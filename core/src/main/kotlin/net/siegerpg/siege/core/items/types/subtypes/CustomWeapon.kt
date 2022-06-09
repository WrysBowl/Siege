package net.siegerpg.siege.core.items.types.subtypes

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.getNbtTag
import net.siegerpg.siege.core.items.setNbtTags
import net.siegerpg.siege.core.items.statgems.StatGem
import net.siegerpg.siege.core.items.types.misc.CustomSkill
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.core.miscellaneous.lore
import net.siegerpg.siege.core.skills.SkillClass
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.block.Action
import org.bukkit.event.entity.EntityShootBowEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta


interface CustomWeapon : CustomGear {

	fun onShoot(e : EntityShootBowEvent) {
		// placeholder for optional event
	}

	fun onWandCast() {
		// placeholder for optional event
	}

	var customSkill : CustomSkill?

	fun hasSkill() : Boolean{
		return this.customSkill != null
	}

	fun canMerge(type : CustomSkill) : Boolean{
		val checkedSkill : SkillClass = customSkill?.skill?.skillClass ?: return false
		val matchSkill : SkillClass = if (type is CustomBow) {
			SkillClass.ARCHER
		} else if (type is CustomMeleeWeapon) {
			SkillClass.WARRIOR
		} else {
			SkillClass.MAGE
		}
		return checkedSkill.equals(matchSkill)
	}

	fun addSkill(skill : CustomSkill) {

		this.customSkill = skill
		this.serialize()
	}

	fun removeSkill() {

		this.customSkill = null
		this.serialize()
	}

	fun displaySkillText(meta : ItemMeta) : ItemMeta {
		meta.lore(" ")
		if (this.customSkill == null) {
			meta.lore("<dark_gray>\u25C7 <italic>Skill Slot")
		} else {
			val name : String = customSkill?.skill?.name ?: return meta
			val skillClass : SkillClass = customSkill?.skill?.skillClass ?: return meta

			meta.lore("<r><color:#7fd4a4>${skillClass.action} <color:#5c9976>${name}")
		}
		return meta
	}

	override fun serialize() {
		super.serialize()
		item = item.setNbtTags(
				"skill" to if (this.customSkill != null) this.customSkill?.item else null
		                      )
	}

	override fun deserialize() {
		super.deserialize()
		try {
			item.getNbtTag<ItemStack>("skill")?.let {
				val skill  = CustomItemUtils.getCustomItem(it)
				if (skill is CustomSkill) this.customSkill = skill
			}
		} catch (e : Exception) {
		}

	}

}