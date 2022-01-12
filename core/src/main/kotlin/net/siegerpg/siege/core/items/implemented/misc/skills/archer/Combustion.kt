package net.siegerpg.siege.core.items.implemented.misc.skills.archer

import net.siegerpg.siege.core.items.types.misc.CustomSkill
import net.siegerpg.siege.core.skills.archer.Combustion
import net.siegerpg.siege.core.skills.archer.CriticalShot
import org.bukkit.inventory.ItemStack

class Combustion() : CustomSkill(
		customModelData = 920014,
		skill = Combustion(),
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