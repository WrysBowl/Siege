package net.siegerpg.siege.core.items.implemented.armor.chestplate

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.CustomItemUtils.getCustomItem
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import net.siegerpg.siege.core.utils.Utils
import net.siegerpg.siege.core.utils.cache.LevelEXPStorage
import net.siegerpg.siege.core.utils.cache.PlayerData
import org.bukkit.Color
import org.bukkit.EntityEffect
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.inventory.ItemStack

class GrieferChestplate() : CustomChestplate(
    name = "Griefer Chestplate",
    customModelData = 1,
    description = listOf("Random blasts when hit"),
    levelRequirement = 16,
    material = Material.LEATHER_CHESTPLATE,
    baseStats = CustomItemUtils.statMap(health = 10.0, luck = 10.0),
    leatherColor = Color.BLACK
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
        if (Utils.randTest(20.0)) {
            val item = player.inventory.chestplate
            val cusItem = getCustomItem(item) ?: return
            if (cusItem.levelRequirement == null) return
            if (cusItem.levelRequirement!! > LevelEXPStorage.playerLevel[player]!!) return
            for (entity in player.location.getNearbyLivingEntities(4.0)) {
                if (entity is Player) continue
                entity.damage(50.0, player)
                entity.playEffect(EntityEffect.HURT_EXPLOSION)
                player.playSound(entity.location, Sound.ENTITY_GENERIC_EXPLODE, 1.0f, 1.0f)
            }
        }
    }

}