package net.siegerpg.siege.core.items.implemented.misc.skills.archer

import net.siegerpg.siege.core.items.types.misc.CustomSkill
import net.siegerpg.siege.core.skills.archer.AchillesHeel
import org.bukkit.inventory.ItemStack

class AchillesHeel() : CustomSkill(
		customModelData = 920002,
		skill = AchillesHeel(),
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