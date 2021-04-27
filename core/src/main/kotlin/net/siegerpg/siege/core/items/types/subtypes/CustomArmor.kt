package net.siegerpg.siege.core.items.types.subtypes

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.StatGem
import net.siegerpg.siege.core.items.enums.StatTypes
import org.bukkit.Color
import org.bukkit.attribute.Attribute
import org.bukkit.attribute.AttributeModifier
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.inventory.meta.LeatherArmorMeta

interface CustomArmor: CustomEquipment {

    var leatherColor: Color

    fun onHit(e: EntityDamageByEntityEvent) {
        val toughness = CustomItemUtils.getPlayerStat(e.entity as Player, StatTypes.TOUGHNESS)
        e.damage = e.damage * (1 - (toughness/1000))
    }

    override fun updateMeta(hideRarity: Boolean) {
        super.updateMeta(hideRarity)
        val meta = item.itemMeta
        try {
            val leatherMeta = meta as LeatherArmorMeta
            leatherMeta.setColor(leatherColor)
            item.itemMeta = leatherMeta
        } catch(e: Error) {

        }

    }

}