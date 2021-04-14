package net.siegerpg.siege.core.items.types.misc

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
    override var quality: Int = -1,
    override var item: ItemStack = ItemStack(material),
    override val type: ItemTypes = ItemTypes.FOOD,
    override val recipeList: CustomRecipeList? = null,
    val health: Int = 0
) : CustomItem {

    override var rarity: Rarity = Rarity.COMMON

    init {
        rarity = Rarity.getFromInt(quality)
    }

    open fun onEat(e: PlayerItemConsumeEvent) {
        e.player.inventory.itemInMainHand.amount = item.amount - 1
        e.player.foodLevel = 20
        var health: Double = e.player.health + this.health
        if (health > e.player.maxHealth) health = e.player.maxHealth
        e.player.health = health
    }

    override fun updateMeta(hideRarity: Boolean) {

        val meta = item.itemMeta

        meta.displayName(Utils.parse(if (rarity == Rarity.SPECIAL) "<rainbow>$name</rainbow>" else "${rarity.color}$name"))

        val newLore =
            mutableListOf(Utils.parse(if (rarity == Rarity.SPECIAL) "<rainbow>$rarity</rainbow> <gray>${if (hideRarity) 50 else quality}%" else "${rarity.color}$rarity <gray>$quality%"))
        val realHealth = health * getRarityMultiplier(quality)
        if (realHealth > 0) newLore.add(Utils.parse(" "))
        if (realHealth > 0) newLore.add(Utils.parse("<red>+$realHealth Health"))
        newLore.add(Utils.parse(" "))
        description.forEach {
            newLore.add(Utils.parse("<dark_gray>$it"))
        }
        newLore.add(Utils.parse(" "))
        newLore.add(Utils.parse("<gray>Level: $levelRequirement"))
        if (hideRarity) newLore.add(Utils.parse("<red>This is not the real item"))
        meta.lore(newLore)

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE)
        item.itemMeta = meta
    }

    private fun getRarityMultiplier(quality: Int): Double = quality / 100 + 0.5

}