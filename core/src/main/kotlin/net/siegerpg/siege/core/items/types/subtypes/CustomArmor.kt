package net.siegerpg.siege.core.items.types.subtypes

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.StatTypes
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageByEntityEvent

interface CustomArmor: CustomEquipment {

    fun onHit(e: EntityDamageByEntityEvent) {
        val toughness = CustomItemUtils.getPlayerStat(e.entity as Player, StatTypes.TOUGHNESS)
        e.damage = e.damage * (1 - (toughness/1000))
    }

}