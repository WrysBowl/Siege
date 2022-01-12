package net.siegerpg.siege.core.items.implemented.misc.skills.warrior

import net.siegerpg.siege.core.items.types.misc.CustomSkill
import net.siegerpg.siege.core.skills.warrior.Slash
import net.siegerpg.siege.core.skills.warrior.WarCry
import org.bukkit.inventory.ItemStack

class WarCry() : CustomSkill(
		customModelData = 910010,
		skill = WarCry(),
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