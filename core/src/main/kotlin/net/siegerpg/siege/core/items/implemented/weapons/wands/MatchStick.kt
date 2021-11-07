package net.siegerpg.siege.core.items.implemented.weapons.wands

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomWand
import net.siegerpg.siege.core.utils.Levels
import org.bukkit.Material
import org.bukkit.entity.Entity
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.inventory.ItemStack

class MatchStick() : CustomWand(
    name = "Match Stick",
    customModelData = 140006,
    description = listOf("Ancient magic of the ancestors"),
    levelRequirement = 11,
    material = Material.WOODEN_HOE,
    baseStats = CustomItemUtils.statMap(strength = 15.0, luck = 6.0),
    range = 17,
    red = 255,
    green = 153,
    blue = 51,
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
        victim.fireTicks = 20
    }

}