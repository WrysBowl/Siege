package net.siegerpg.siege.core.items.types.subtypes

import net.siegerpg.siege.core.items.*
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.statgems.StatGem
import net.siegerpg.siege.core.utils.Utils
import net.siegerpg.siege.core.utils.lore
import net.siegerpg.siege.core.utils.name
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

interface CustomEquipment : CustomItem {

    var statGem: StatGem?
    val baseStats: HashMap<StatTypes, Double>

    fun addStatGem(newStatGem: StatGem) {
        this.statGem = newStatGem
        this.serialize()
    }

    override fun updateMeta(hideRarity: Boolean): ItemStack {
        val meta = item.itemMeta

        val shownRarity = if (hideRarity) Rarity.UNCOMMON else rarity

        meta.name(if (shownRarity == Rarity.SPECIAL) "<r><rainbow><b>$name</b></rainbow>" else "<r>${shownRarity.color}$name")

        if (meta.hasLore()) meta.lore(mutableListOf())

        meta.lore(if (shownRarity == Rarity.SPECIAL) "<r><rainbow><b>${shownRarity.id}</b></rainbow> <gray>${if (hideRarity) 50 else quality}%" else "<r>${shownRarity.color}${shownRarity.id} <gray>${if (hideRarity) 50 else quality}%")
        statGem?.let {
            meta.lore(" ")
            meta.lore("<r><color:#FF3CFF>+${it.amount} <light_purple>${it.type.stylizedName} Gem")
        }
        if (baseStats.size != 0) {
            meta.lore(" ")
            val realStats = CustomItemUtils.getStats(this, addGem = false, addRarity = true)
            baseStats.keys.forEach {
                meta.lore("<r><green>+${realStats[it]} <gray>${it.stylizedName}") // TODO: Make special items work with rarity multiplier
            }
        }
        meta.lore(" ")
        description.forEach {
            meta.lore("<r><dark_gray>$it")
        }
        meta.lore(" ")
        meta.lore("<r><gray>Level: $levelRequirement")
        //if (hideRarity) meta.lore("<r><red>This is not the real item")

        meta.isUnbreakable = true
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE)
        item.itemMeta = meta
        return item
    }

    override fun serialize() {
        super.serialize()
        item = item.setNbtTags(
            "equipmentStatGem" to if (statGem != null) statGem.toString() else null
        )
    }

    override fun deserialize() {
        super.deserialize()
        try {
            item.getNbtTag<String>("equipmentStatGem")?.let {
                statGem = StatGem.fromString(it)
            }
        } catch(e: Exception) {

        }

    }
}