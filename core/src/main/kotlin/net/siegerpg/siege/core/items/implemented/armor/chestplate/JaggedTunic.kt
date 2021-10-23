package net.siegerpg.siege.core.items.implemented.armor.chestplate

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import net.siegerpg.siege.core.utils.Levels
import org.bukkit.Color
import org.bukkit.EntityEffect
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.entity.Entity
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.inventory.ItemStack

class JaggedTunic() : CustomChestplate(
    name = "Jagged Tunic",
    customModelData = 1,
    description = listOf("Deals small amount of","damage to the damager"),
    levelRequirement = 2,
    material = Material.LEATHER_CHESTPLATE,
    baseStats = CustomItemUtils.statMap(health = 5.0, strength = 2.0),
    leatherColor = Color.GRAY
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

    override fun onHit(e: EntityDamageEvent) {
        val player = (e.entity as Player).player ?: return
        val item = player.inventory.chestplate
        val cusItem = CustomItemUtils.getCustomItem(item) ?: return
        if (e !is EntityDamageByEntityEvent) return
        if (cusItem.levelRequirement == null) return
        if (cusItem.levelRequirement!! > (Levels.blockingGetExpLevel(player)?.first ?: 0)) return
        val attacker: Entity = e.damager
        (attacker as LivingEntity).damage(5.0, player)
        attacker.playEffect(EntityEffect.SHIELD_BREAK)
        player.playSound(attacker.location, Sound.BLOCK_SAND_STEP, 1.0f, 5.0f)
    }

}