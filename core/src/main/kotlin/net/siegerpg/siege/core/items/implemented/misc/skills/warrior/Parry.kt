package net.siegerpg.siege.core.items.implemented.misc.skills.warrior

import net.siegerpg.siege.core.items.types.misc.CustomSkill
import net.siegerpg.siege.core.skills.warrior.Parry
import net.siegerpg.siege.core.skills.warrior.Slash
import org.bukkit.inventory.ItemStack

class Parry() : CustomSkill(
		customModelData = 910009,
		skill = Parry(),
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