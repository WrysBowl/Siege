package net.siegerpg.siege.core.items.implemented.misc.cosmetics.legendary

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.Cosmetic
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class GlowSquid() : Cosmetic(
		name = "Glow Squid",
		customModelData = 750002,
		description = listOf("Makes you glow!"),
		material = Material.KNOWLEDGE_BOOK
                            ) {

	override fun onCosmeticEquip(e : PlayerArmorChangeEvent) {
		val player = e.player
		val newArmor = CustomItemUtils.getCustomItem(e.newItem)
		val oldArmor = CustomItemUtils.getCustomItem(e.oldItem)

		if (newArmor != null) {
			if (newArmor is GlowSquid) player.addPotionEffect(
					PotionEffect(
							PotionEffectType.GLOWING,
							999999,
							9
					            )
			                                                 )
		}
		if (oldArmor != null) {
			if (oldArmor is GlowSquid) player.removePotionEffect(PotionEffectType.GLOWING)
		}
	}


	constructor(quality : Int) : this() {
		this.quality = 100
		this.rarity = Rarity.LEGENDARY
		this.serialize()
	}

	constructor(item : ItemStack) : this() {
		this.item = item
		deserialize()
	}

}