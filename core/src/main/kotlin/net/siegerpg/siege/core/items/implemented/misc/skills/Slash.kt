package net.siegerpg.siege.core.items.implemented.misc.skills

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomMount
import net.siegerpg.siege.core.items.types.misc.CustomSkill
import net.siegerpg.siege.core.items.types.misc.CustomTool
import net.siegerpg.siege.core.skills.warrior.Slash
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Slash() : CustomSkill(
		customModelData = 910001,
		skill = Slash()
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