package net.siegerpg.siege.core.items.types.subtypes

import de.tr7zw.nbtapi.NBTItem
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.getNbtTag
import net.siegerpg.siege.core.items.setNbtTags
import net.siegerpg.siege.core.items.statgems.StatGem
import org.bukkit.Bukkit
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.EntityShootBowEvent

interface CustomWeapon : CustomEquipment {

	fun onShoot(e : EntityShootBowEvent) {
		// placeholder for optional event
	}

	fun onWandCast() {
		// placeholder for optional event
	}

}