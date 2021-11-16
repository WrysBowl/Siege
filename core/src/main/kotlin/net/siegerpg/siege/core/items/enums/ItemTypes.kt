package net.siegerpg.siege.core.items.enums

import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import net.siegerpg.siege.core.items.types.misc.Cosmetic
import net.siegerpg.siege.core.items.types.misc.CustomFood
import net.siegerpg.siege.core.items.types.misc.CustomMaterial
import net.siegerpg.siege.core.items.types.misc.StatGemType
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.items.types.weapons.CustomWand
import kotlin.reflect.KClass

enum class ItemTypes(val stylizedName: String, val clazz: KClass<out CustomItem>) {
	MELEEWEAPON("Melee Weapon", CustomMeleeWeapon::class),
	BOW("Bow", CustomBow::class),
	HELMET("Helmet", CustomHelmet::class),
	CHESTPLATE("Chestplate", CustomChestplate::class),
	LEGGINGS("Leggings", CustomLeggings::class),
	BOOTS("Boots", CustomBoots::class),
	WAND("Wand", CustomWand::class),
	FOOD("Food", CustomFood::class),
	STATGEM("Stat Gem", StatGemType::class),
	MATERIAL("Material", CustomMaterial::class),
	COSMETIC("COSMETIC", Cosmetic::class);

	companion object {

		fun getFromId(id: String?): ItemTypes? {
			for (itemType in values()) {
				if (itemType.stylizedName.equals(id, ignoreCase = true)) return itemType
			}
			return null
		}
	}
}