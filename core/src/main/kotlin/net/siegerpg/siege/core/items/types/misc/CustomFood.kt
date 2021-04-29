package net.siegerpg.siege.core.items.types.misc

import net.kyori.adventure.text.format.TextDecoration
import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.enums.ItemTypes
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.recipes.CustomRecipeList
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.event.player.PlayerItemConsumeEvent
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

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
    val health: Int = 0
) : CustomItem {

    override var rarity: Rarity = Rarity.COMMON

    init {
        this.rarity = Rarity.getFromInt(this.quality)
    }

    open fun onEat(e: PlayerItemConsumeEvent) {
        e.player.inventory.itemInMainHand.amount = item.amount - 1
        e.player.foodLevel = 20
        var health: Double = e.player.health + this.health
        if (health > e.player.maxHealth) health = e.player.maxHealth
        e.player.health = health
    }

    override fun updateMeta(hideRarity: Boolean): ItemStack {

        val meta = item.itemMeta

        val shownRarity = if (hideRarity) Rarity.UNCOMMON else rarity

        meta.displayName(Utils.parse(if (shownRarity == Rarity.SPECIAL) "<r><rainbow>$name</rainbow>" else "<r>${shownRarity.color}$name").decoration(
            TextDecoration.ITALIC, false))

        val newLore =
            mutableListOf(Utils.parse(if (shownRarity == Rarity.SPECIAL) "<r><rainbow>${shownRarity.id}</rainbow> <gray>${if (hideRarity) 50 else quality}%" else "<r>${shownRarity.color}${shownRarity.id} <gray>${if (hideRarity) 50 else quality}%"))
        val realHealth = health * getRarityMultiplier(quality)
        if (realHealth > 0) newLore.add(Utils.parse(" "))
        if (realHealth > 0) newLore.add(Utils.parse("<r><red>+$realHealth Health"))
        newLore.add(Utils.parse(" "))
        description.forEach {
            newLore.add(Utils.parse("<r><dark_gray>$it"))
        }
        newLore.add(Utils.parse(" "))
        newLore.add(Utils.parse("<r><gray>Level: $levelRequirement"))
        if (hideRarity) newLore.add(Utils.parse("<r><red>This is not the real item"))
        meta.lore(newLore)

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE)
        item.itemMeta = meta
        return item
    }

    private fun getRarityMultiplier(quality: Int): Double = quality / 100 + 0.5

}