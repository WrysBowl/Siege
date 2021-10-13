package net.siegerpg.siege.core.items.implemented.misc.wands

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomWand
import net.siegerpg.siege.core.utils.Levels
import org.bukkit.Material
import org.bukkit.entity.Entity
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class PebbleWand() : CustomWand(
    name = "Pebble Wand",
    customModelData = 140005,
    description = listOf("Nature made rocks to be weaponized"),
    levelRequirement = 5,
    material = Material.WOODEN_HOE,
    baseStats = CustomItemUtils.statMap(strength = 6.0, luck = 3.0),
    range = 15,
    red = 140,
    green = 140,
    blue = 140,
    damageRadius = 2.0
) {

    constructor(quality: Int): this() {
        this.quality = quality
        this.rarity = Rarity.getFromInt(quality)
        this.serialize()
    }

    constructor(item: ItemStack): this() {
        this.item = item
        deserialize()
    }

    override fun onHit(e: EntityDamageByEntityEvent) {
        val player = (e.entity as Player).player ?: return
        val item = player.inventory.itemInMainHand
        val cusItem = CustomItemUtils.getCustomItem(item) ?: return
        if (cusItem.levelRequirement == null) return
        if (cusItem.levelRequirement!! > (Levels.blockingGetExpLevel(player)?.first ?: 0)) return
        val victim: Entity = e.entity
        if (victim !is LivingEntity) return
        victim.addPotionEffect(PotionEffect(PotionEffectType.SLOW, 10, 0))
    }

}