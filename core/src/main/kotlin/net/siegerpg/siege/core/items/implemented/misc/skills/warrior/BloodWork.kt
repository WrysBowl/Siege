package net.siegerpg.siege.core.items.implemented.misc.skills.warrior

import net.siegerpg.siege.core.items.types.misc.CustomSkill
import net.siegerpg.siege.core.skills.warrior.BloodWork
import net.siegerpg.siege.core.skills.warrior.Slash
import org.bukkit.inventory.ItemStack

class BloodWork() : CustomSkill(
		customModelData = 910008,
		skill = BloodWork(),
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