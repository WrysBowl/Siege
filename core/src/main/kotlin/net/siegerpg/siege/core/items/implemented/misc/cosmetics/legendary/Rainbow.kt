package net.siegerpg.siege.core.items.implemented.misc.cosmetics.legendary

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent
import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.Cosmetic
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.scheduler.BukkitRunnable

class Rainbow() : Cosmetic(
		name = "Rainbow",
		customModelData = 750003,
		description = listOf("Disco ball :)"),
		material = Material.WHITE_STAINED_GLASS
                          ) {

	override fun onCosmeticEquip(e : PlayerArmorChangeEvent) {
		val player = e.player
		val newArmor = CustomItemUtils.getCustomItem(e.newItem) ?: return
		val rainbowArray : ArrayList<Material> = arrayListOf(
				Material.RED_STAINED_GLASS,
				Material.ORANGE_STAINED_GLASS,
				Material.PINK_STAINED_GLASS,
				Material.YELLOW_STAINED_GLASS,
				Material.LIME_STAINED_GLASS,
				Material.GREEN_STAINED_GLASS,
				Material.LIGHT_BLUE_STAINED_GLASS,
				Material.CYAN_STAINED_GLASS,
				Material.BLUE_STAINED_GLASS,
				Material.MAGENTA_STAINED_GLASS,
				Material.PURPLE_STAINED_GLASS
		                                                    )
		object : BukkitRunnable() {
			override fun run() {
				if (player.inventory.helmet == null || !e.player.isOnline) {
					cancel()
				} else if (player.inventory.helmet == newArmor.item) {
					val randNum : Int = (Math.random() * rainbowArray.size).toInt()
					newArmor.item.type = rainbowArray[randNum]
					player.inventory.helmet = newArmor.item
				}
			}
		}.runTaskTimer(Core.plugin(), 20, 20)
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