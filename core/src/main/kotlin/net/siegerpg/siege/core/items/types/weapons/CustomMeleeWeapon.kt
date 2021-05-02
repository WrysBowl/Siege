package net.siegerpg.siege.core.items.types.weapons

import net.siegerpg.siege.core.items.statgems.StatGem
import net.siegerpg.siege.core.items.enums.ItemTypes
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.recipes.CustomRecipeList
import net.siegerpg.siege.core.items.types.subtypes.CustomWeapon
import org.bukkit.Material
import org.bukkit.attribute.Attribute
import org.bukkit.attribute.AttributeModifier
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.ItemStack
import java.util.*
import kotlin.collections.HashMap

abstract class CustomMeleeWeapon(
    override val name: String,
    override val customModelData: Int? = null,
    override val levelRequirement: Int? = null,
    override val description: List<String>,
    override val material: Material,
    final override var quality: Int = -1,
    override var item: ItemStack = ItemStack(material),
    override val baseStats: HashMap<StatTypes, Double>,
    override val type: ItemTypes = ItemTypes.MELEEWEAPON,
    override val recipeList: CustomRecipeList? = null,
    val attackSpeed: Double,
    override var statGem: StatGem? = null
) : CustomWeapon {

    override var rarity: Rarity = Rarity.COMMON

    init {
        this.rarity = Rarity.getFromInt(quality)
    }

    override fun updateMeta(hideRarity: Boolean): ItemStack {
        super.updateMeta(hideRarity)
        val meta = item.itemMeta
        meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_SPEED)
        val modifier =  AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", attackSpeed - 1.5, AttributeModifier.Operation.ADD_SCALAR)
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier)
        item.itemMeta = meta
        return item
    }

    override fun equals(other: Any?): Boolean {
        other?.let { return false }
        if (this::class.qualifiedName != other!!::class.qualifiedName) return false
        return true
    }

}