package net.siegerpg.siege.core.items.types.subtypes

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.StatTypes
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.attribute.Attribute
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.LeatherArmorMeta

interface CustomArmor: CustomEquipment {

    var leatherColor: Color

    fun onHit(e: EntityDamageByEntityEvent) {
        val toughness = CustomItemUtils.getPlayerStat(e.entity as Player, StatTypes.TOUGHNESS)
        e.damage = e.damage * (1 - (toughness/1000))
    }

    override fun updateMeta(hideRarity: Boolean): ItemStack {
        super.updateMeta(hideRarity)
        val meta = item.itemMeta
        if (item.type == Material.LEATHER_BOOTS ||
            item.type == Material.LEATHER_LEGGINGS ||
            item.type == Material.LEATHER_CHESTPLATE ||
            item.type == Material.LEATHER_HELMET) {
            try {
                val leatherMeta = meta as LeatherArmorMeta
                meta.setColor(leatherColor)
                item.itemMeta = leatherMeta
            } catch (e: Error) {

            }
        }
        meta.removeAttributeModifier(Attribute.GENERIC_ARMOR)
        item.itemMeta = meta
        return item

    }

}