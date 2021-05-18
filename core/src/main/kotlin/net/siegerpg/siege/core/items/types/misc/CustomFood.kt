package net.siegerpg.siege.core.items.types.misc

import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.ItemTypes
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.recipes.CustomRecipeList
import net.siegerpg.siege.core.utils.Utils
import net.siegerpg.siege.core.utils.lore
import net.siegerpg.siege.core.utils.name
import org.bukkit.Material
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerItemConsumeEvent
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

abstract class CustomFood(
    override val name: String,
    override val customModelData: Int? = null,
    override val levelRequirement: Int? = null,
    override val description: List<String>,
    override val material: Material,
    final override var quality: Int = -1,
    override var item: ItemStack = ItemStack(material),
    override val type: ItemTypes = ItemTypes.FOOD,
    override val recipeList: CustomRecipeList? = null,
    val health: Int = 0,
    val potion: List<PotionEffect>? = null
) : CustomItem {

    override var rarity: Rarity = Rarity.COMMON

    init {
        this.rarity = Rarity.getFromInt(this.quality)
    }

    open fun onEat(e: PlayerItemConsumeEvent) {
        val healthStat = CustomItemUtils.getPlayerStat(e.player, StatTypes.HEALTH) + e.player.maxHealth + (e.player.level*2)
        val currentCustomHealth = CustomItemUtils.getCustomHealth(e.player)
        val addedHealth = (((health * getRarityMultiplier(quality)) + currentCustomHealth)/healthStat) * e.player.maxHealth
        if (addedHealth <= e.player.maxHealth)
            e.player.health = addedHealth
        else e.player.health = e.player.maxHealth
        potion?.forEach {
            val realPotionDuration = (it.duration * getRarityMultiplier(quality)).toInt()
            val realPotion = PotionEffect(it.type, realPotionDuration, it.amplifier)
            e.player.addPotionEffect(realPotion)
        }
    }

    override fun updateMeta(hideRarity: Boolean): ItemStack {

        val meta = item.itemMeta

        val shownRarity = if (hideRarity) Rarity.UNCOMMON else rarity

        meta.name(if (shownRarity == Rarity.SPECIAL) "<r><rainbow><b>$name</b></rainbow>" else "<r>${shownRarity.color}$name")

        if (meta.hasLore()) meta.lore(mutableListOf())

        meta.lore(if (shownRarity == Rarity.SPECIAL) "<r><rainbow><b>${shownRarity.id}</b></rainbow> <gray>${if (hideRarity) 50 else quality}%" else "<r>${shownRarity.color}${shownRarity.id} <gray>${if (hideRarity) 50 else quality}%")
        val realHealth = health * getRarityMultiplier(quality)
        if (realHealth > 0 || potion != null) meta.lore(" ")
        if (realHealth > 0) meta.lore("<r><red>+ $realHealth Health")
        potion?.forEach {
            val realPotionDuration = ((it.duration * getRarityMultiplier(quality))/20).toInt()
            val realPotionAmplifier = it.amplifier + 1
            meta.lore("<r><yellow>+ ${it.type.name} " + "<r><yellow>$realPotionAmplifier " + "<r><gold>$realPotionDuration sec")
        }
        meta.lore(" ")
        description.forEach {
            meta.lore("<r><dark_gray>$it")
        }
        meta.lore(" ")
        meta.lore("<r><gray>Level: $levelRequirement")
        if (hideRarity) meta.lore("<r><red>This is not the real item")

        meta.isUnbreakable = true
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE)
        item.itemMeta = meta
        return item
    }

    private fun getRarityMultiplier(quality: Int): Double = quality / 100.0 + 0.5

    override fun equals(other: Any?): Boolean {
        other?.let { return false }
        if (this::class.qualifiedName != other!!::class.qualifiedName) return false
        return true
    }

}