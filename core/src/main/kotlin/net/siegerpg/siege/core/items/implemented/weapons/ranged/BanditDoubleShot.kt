package net.siegerpg.siege.core.items.implemented.weapons.ranged

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import net.siegerpg.siege.core.utils.Levels
import org.bukkit.Material
import org.bukkit.entity.*
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.util.Vector

class BanditDoubleShot() : CustomBow(
    name = "Bandit Double Shot",
    customModelData = 120004,
    description = listOf("Shoots another arrow","after shooting"),
    levelRequirement = 20,
    material = Material.BOW,
    baseStats = CustomItemUtils.statMap(strength = 17.0)
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

        val playerDirection: Vector = victim.getLocation().direction
        val arrow: Arrow = player.launchProjectile(Arrow::class.java, playerDirection)
        arrow.pickupStatus = AbstractArrow.PickupStatus.DISALLOWED
    }

}