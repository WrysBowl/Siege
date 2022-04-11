package net.siegerpg.siege.core.items.types.subtypes

import net.siegerpg.siege.core.items.enums.SkillTriggers
import net.siegerpg.siege.core.items.types.misc.CustomSkill
import net.siegerpg.siege.core.miscellaneous.lore
import org.apache.commons.lang.ObjectUtils.Null
import org.bukkit.event.entity.EntityShootBowEvent
import org.bukkit.inventory.meta.ItemMeta
import org.checkerframework.checker.units.qual.t
import java.util.*


interface CustomWeapon : CustomGear {

	fun onShoot(e : EntityShootBowEvent) {
		// placeholder for optional event
	}

	fun onWandCast() {
		// placeholder for optional event
	}

	var skillBooks : List<CustomSkill?>

	fun canAddSkill() : Boolean{
		var count = 0
		for (skill in this.skillBooks) {
			if (skill != null) {
				count++
			}
		}
		return count < this.skillBooks.size

	}

	fun addSkill(skill : CustomSkill) {
		val newSkillBooks : List<CustomSkill?> = this.skillBooks
		newSkillBooks.toMutableList().add(skill)

		this.skillBooks = newSkillBooks
		this.serialize()
	}

	fun removeSkill(skill : CustomSkill) {
		val newSkillBooks : List<CustomSkill?> = this.skillBooks
		if (newSkillBooks.isNotEmpty()) newSkillBooks.toMutableList().remove(skill)

		this.skillBooks = newSkillBooks
		this.serialize()
	}

	fun hasSkill() : Boolean {
		for (skill in this.skillBooks) {
			if (skill == null) {
				return false
			}
		}
		return true
	}

	fun displaySkillText(meta : ItemMeta) : ItemMeta {
		for(i in 0..(skillBooks.size)) {
			meta.lore(" ")
			meta.lore("<r><color:#7fd4a4>[${SkillTriggers.getFromInt(i).display}] <color:#5c9976>${skillBooks.get(i)}")
		}
		for(i in 0..(skillBooks.size)) {
			meta.lore(" ")
			meta.lore("<dark_gray>\u25C7 <italic>Skill Slot")
		}
		return meta
	}

}