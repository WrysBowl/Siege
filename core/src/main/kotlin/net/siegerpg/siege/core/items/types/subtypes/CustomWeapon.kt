package net.siegerpg.siege.core.items.types.subtypes

import de.tr7zw.nbtapi.NBTItem
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.getNbtTag
import net.siegerpg.siege.core.items.setNbtTags
import net.siegerpg.siege.core.items.statgems.StatGem
import org.bukkit.Bukkit
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDamageEvent

interface CustomWeapon : CustomEquipment {

	fun onHit(e : EntityDamageEvent) {

	}
}