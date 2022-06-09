package net.siegerpg.siege.core.items.types.subtypes

import net.siegerpg.siege.core.items.types.misc.CustomSkill
import net.siegerpg.siege.core.miscellaneous.lore
import net.siegerpg.siege.core.skills.SkillClass
import org.bukkit.event.block.Action
import org.bukkit.event.entity.EntityShootBowEvent
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
			val customSkill : CustomSkill = this.customSkill ?: return meta
			val skillClass : SkillClass = customSkill.skill.skillClass
			meta.lore("<r><color:#7fd4a4>${skillClass.action} <color:#5c9976>${this.customSkill?.name}")
		}
		return meta
	}

}