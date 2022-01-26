package net.siegerpg.siege.core.items.implemented.misc.cosmetics.legendary

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent
import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.Cosmetic
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.scheduler.BukkitRunnable

class GlowSquid() : Cosmetic(
		name = "Glow Squid",
		customModelData = 750002,
		description = listOf("Makes you glow!"),
		material = Material.KNOWLEDGE_BOOK,
		quality = 100
                            ) {

	override fun onCosmeticEquip(e : PlayerArmorChangeEvent) {
		val player = e.player
		val newArmor = CustomItemUtils.getCustomItem(e.newItem) ?: return

		object : BukkitRunnable() {
			override fun run() {
				if (player.inventory.helmet == null || !e.player.isOnline) {
					cancel()
				} else if (player.inventory.helmet == newArmor.item) {
					player.addPotionEffect(PotionEffect(PotionEffectType.GLOWING, 100, 9))
				}
			}
		}.runTaskTimer(Core.plugin(), 50, 50)
	}


	constructor(quality : Int) : this() {
		this.quality = quality
		this.rarity = Rarity.getFromInt(quality)
		this.serialize()
	}

	constructor(item : ItemStack) : this() {
		this.item = item
		deserialize()
	}

}