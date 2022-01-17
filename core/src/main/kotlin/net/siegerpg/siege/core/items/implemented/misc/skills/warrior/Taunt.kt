package net.siegerpg.siege.core.items.implemented.misc.skills.warrior

import net.siegerpg.siege.core.items.types.misc.CustomSkill
import net.siegerpg.siege.core.skills.warrior.Slash
import net.siegerpg.siege.core.skills.warrior.Taunt
import org.bukkit.inventory.ItemStack

class Taunt() : CustomSkill(
		customModelData = 910003,
		skill = Taunt(),
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