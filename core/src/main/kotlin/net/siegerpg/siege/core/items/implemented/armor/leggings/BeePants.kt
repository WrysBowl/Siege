package net.siegerpg.siege.core.items.implemented.armor.leggings

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.CustomItemUtils.getCustomItem
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class BeePants() : CustomLeggings(
		name = "Bee Stinger",
		customModelData = 1,
		description = listOf("Sting like a bee!"),
		levelRequirement = 12,
		material = Material.LEATHER_LEGGINGS,
		baseStats = CustomItemUtils.statMap(health = 20.0, strength = 5.0, mana = 2.0),
		leatherColor = Color.YELLOW
                                 ) {

	constructor(quality : Int) : this() {
		this.quality = quality
		this.rarity = Rarity.getFromInt(quality)
		this.serialize()
	}

	constructor(item : ItemStack) : this() {
		this.item = item
		deserialize()
	}

	override fun onHit(e : EntityDamageEvent) {
		if (e !is EntityDamageByEntityEvent) return
		if (e.damager !is Player) return
		if (e.damager is Player && e.damager.world.name == "PVP") return
		val player = (e.damager as Player).player ?: return
		val item = player.inventory.leggings
		val cusItem = getCustomItem(item) ?: return
		if (cusItem.levelRequirement == null) return
		if (cusItem.levelRequirement!! > player.level) return
		val potion = PotionEffect(PotionEffectType.POISON, 60, 3)
		(e.entity as LivingEntity).addPotionEffect(potion)
	}

}