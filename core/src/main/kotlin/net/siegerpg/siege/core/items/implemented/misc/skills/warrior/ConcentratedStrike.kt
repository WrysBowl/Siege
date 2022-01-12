package net.siegerpg.siege.core.items.implemented.misc.skills.warrior

import net.siegerpg.siege.core.items.types.misc.CustomSkill
import net.siegerpg.siege.core.skills.warrior.ConcentratedStrike
import net.siegerpg.siege.core.skills.warrior.Slash
import org.bukkit.inventory.ItemStack

class ConcentratedStrike() : CustomSkill(
		customModelData = 910011,
		skill = ConcentratedStrike(),
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