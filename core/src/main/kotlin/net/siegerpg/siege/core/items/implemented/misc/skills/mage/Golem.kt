package net.siegerpg.siege.core.items.implemented.misc.skills.mage

import net.siegerpg.siege.core.items.types.misc.CustomSkill
import net.siegerpg.siege.core.skills.archer.CriticalShot
import net.siegerpg.siege.core.skills.archer.VenomousAura
import net.siegerpg.siege.core.skills.mage.Golem
import net.siegerpg.siege.core.skills.mage.IceBolt
import org.bukkit.inventory.ItemStack

class Golem() : CustomSkill(
		customModelData = 930016,
		skill = Golem(),
                           ) {


	constructor(level : Int) : this() {
		this.level = level
		this.serialize()
	}

	constructor(item : ItemStack) : this() {
		this.item = item
		deserialize()
	}

}