@file:Suppress(
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused",
		"unused"
              )

package net.siegerpg.siege.core.items

import de.tr7zw.nbtapi.NBTItem
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import net.siegerpg.siege.core.items.types.subtypes.CustomEquipment
import net.siegerpg.siege.core.items.types.subtypes.CustomGear
import net.siegerpg.siege.core.items.types.subtypes.CustomWeapon
import net.siegerpg.siege.core.items.types.weapons.CustomWand
import net.siegerpg.siege.core.miscellaneous.Levels
import net.siegerpg.siege.core.miscellaneous.StatRewards
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.core.miscellaneous.cache.PlayerData
import org.bukkit.Bukkit
import org.bukkit.attribute.Attribute
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import java.lang.reflect.Constructor
import java.util.*
import kotlin.math.ceil


object CustomItemUtils {

	fun getCustomItem(item : ItemStack?) : CustomItem? {
		if (item == null) {
			return null
		}
		if (!item.hasItemMeta()) return null
		//Bukkit.getLogger().info("Item has meta")
		val nbtItem = NBTItem(item)
		return if (nbtItem.hasKey("itemClass")) {
			try {
				val className = nbtItem.getString("itemClass")
				//Bukkit.getLogger().info("class name is $className")
				val clazz : Class<*> = Class.forName(className)
				//Bukkit.getLogger().info("Got the class")
				val constructor : Constructor<out Any> =
						clazz.getConstructor(ItemStack::class.java)
				//Bukkit.getLogger().info("Got the constructor")
				val newClass = constructor.newInstance(item)
				//Bukkit.getLogger().info("Got the instance")
				newClass as? CustomItem

			} catch (e : Exception) {
				e.printStackTrace()
				//Bukkit.getLogger().info("Failed")
				null
			}
		} else {
			null
		}

	}

	fun isCustomItemType(item : ItemStack, className : String) : Boolean {
		val nbtItem = NBTItem(item)
		if (!nbtItem.hasKey("itemClass")) return false
		return className == nbtItem.getString("itemClass")
	}

	fun statMap(
			strength : Double? = null,
			regeneration : Double? = null,
			defense : Double? = null,
			health : Double? = null,
			luck : Double? = null,
			mana : Double? = null,
			mana_regen : Double? = null
	           ) : HashMap<StatTypes, Double> {
		val map = hashMapOf<StatTypes, Double>()
		strength?.let { map[StatTypes.STRENGTH] = it }
		regeneration?.let { map[StatTypes.REGENERATION] = it }
		defense?.let { map[StatTypes.DEFENSE] = it }
		health?.let { map[StatTypes.HEALTH] = it }
		luck?.let { map[StatTypes.LUCK] = it }
		mana?.let { map[StatTypes.MANA] = it }
		mana_regen?.let { map[StatTypes.MANA_REGEN] = it }
		return map
	}

	@JvmOverloads
	fun getPlayerStat(
			player : Player,
			statType : StatTypes,
			itemInMainHand : ItemStack? = null
	                 ) : Double {
		var output = 0.0
		val inventory = player.inventory
		val mainHand = itemInMainHand ?: inventory.itemInMainHand

		//get stats added from player's level and rebirth amount
		StatRewards.getRewardedStats(player)[statType]?.let { stat ->
			output += stat
		}

		getCustomItem(mainHand)?.let {
			if (it is CustomWeapon || it is CustomWand) {
				val itemStats =
						getStats(it as CustomEquipment, addGem = true, addRarity = true)
				itemStats[statType]?.let { stat ->
					if (it.levelRequirement == null) {
						output += stat
					} else if (it.levelRequirement!! <= player.level) {
						output += stat
					}

				}
			}
		}

		inventory.helmet?.let { helmet ->
			getCustomItem(helmet)?.let {
				if (it is CustomHelmet) {
					val itemStats = getStats(it, addGem = true, addRarity = true)
					itemStats[statType]?.let { stat ->
						if (it.levelRequirement == null) {
							output += stat
						} else if (it.levelRequirement!! <= player.level) {
							output += stat
						}
					}
				}
			}
		}
		//Bukkit.getLogger().info("Helmet: " + output)
		inventory.chestplate?.let { chestplate ->
			getCustomItem(chestplate)?.let {
				if (it is CustomChestplate) {
					val itemStats = getStats(it, addGem = true, addRarity = true)
					itemStats[statType]?.let { stat ->
						if (it.levelRequirement == null) {
							output += stat
						} else if (it.levelRequirement!! <= player.level) {
							output += stat
						}
					}
				}
			}
		}
		//Bukkit.getLogger().info("Chestplate: " + output)
		inventory.leggings?.let { leggings ->
			getCustomItem(leggings)?.let {
				if (it is CustomLeggings) {
					val itemStats = getStats(it, addGem = true, addRarity = true)
					itemStats[statType]?.let { stat ->
						if (it.levelRequirement == null) {
							output += stat
						} else if (it.levelRequirement!! <= player.level) {
							output += stat
						}
					}
				}
			}
		}
		//Bukkit.getLogger().info("Leggings: " + output)
		inventory.boots?.let { boots ->
			getCustomItem(boots)?.let {
				if (it is CustomBoots) {
					val itemStats = getStats(it, addGem = true, addRarity = true)
					itemStats[statType]?.let { stat ->
						if (it.levelRequirement == null) {
							output += stat
						} else if (it.levelRequirement!! <= player.level) {
							output += stat
						}
					}
				}
			}
		}
		return output
	}

	fun addHealth(player : Player, health : Double) {
		val playerMaxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH)!!.value
		val addedHealth = health + player.health
		if (addedHealth <= playerMaxHealth) player.health = addedHealth
		else player.health = playerMaxHealth
		PlayerData.setStats(player)
	}

	fun getStats(
			item : CustomEquipment,
			addGem : Boolean,
			addRarity : Boolean
	            ) : HashMap<StatTypes, Double> {
		val map = hashMapOf<StatTypes, Double>()
		StatTypes.values().forEach {
			var totalAmount = 0.0

			if (item is CustomGear) {
				if (item.addedStats != null) {
					if (item.addedStats!!.containsKey(it)) {
						totalAmount += item.addedStats!![it]!!
					}
				}
			}
			if (item.baseStats.containsKey(it)) {
				totalAmount += item.baseStats[it]!!
			}
			if (addRarity) {
				totalAmount *= if (item.quality < 0) getRarityMultiplier(50) else getRarityMultiplier(item.quality)

			}
			if (addGem) {
				item.statGem?.let { gem ->
					if (gem.type == it) {
						totalAmount += gem.amount
					}
				}
			}
			map[it] = Utils.round(totalAmount, 1)
		}

		return map
	}

	@JvmStatic
	fun getRarityMultiplier(quality : Int) : Double = quality / 100.0 + 0.5

	fun serializeToItem(nbtItem : NBTItem, hashmap : HashMap<String, Any>) {
		hashmap.forEach {
			when (it.value) {
				is String -> nbtItem.setString(it.key, it.value as String)
				is Int    -> nbtItem.setInteger(it.key, it.value as Int)
			}
		}
	}
}

fun ItemStack.setNbtTags(vararg pairs : Pair<String, Any?>) : ItemStack {
	val tags = hashMapOf(*pairs)
	val nbtItem = NBTItem(this)
	tags.forEach { entry ->
		if (entry.value == null) {
			nbtItem.removeKey(entry.key)
		} else
			entry.value?.let {
				when (it) {
					// Numbers
					is Int       -> nbtItem.setInteger(entry.key, it)
					is Long      -> nbtItem.setLong(entry.key, it)
					is Short     -> nbtItem.setShort(entry.key, it)
					is Double    -> nbtItem.setDouble(entry.key, it)
					is Float     -> nbtItem.setFloat(entry.key, it)
					is IntArray  -> nbtItem.setIntArray(entry.key, it)
					// Bytes
					is Byte      -> nbtItem.setByte(entry.key, it)
					is ByteArray -> nbtItem.setByteArray(entry.key, it)
					// Other Types
					is String    -> nbtItem.setString(entry.key, it)
					is Boolean   -> nbtItem.setBoolean(entry.key, it)
					// Useful Objects
					is ItemStack -> nbtItem.setItemStack(entry.key, it)
					is UUID      -> nbtItem.setUUID(entry.key, it)
					// Leftovers
					else         -> nbtItem.setObject(entry.key, it)
				}
			}

	}
	return nbtItem.item
}

fun ItemStack.deleteNbtTags(vararg tags : String) : ItemStack {
	val nbtItem = NBTItem(this)
	for (tag in tags) {
		nbtItem.removeKey(tag)
	}
	return nbtItem.item
}

fun <T> ItemStack.getNbtTags(vararg pairs : Pair<String, T>) : HashMap<String, Any?> {
	val nbtItem = NBTItem(this)
	val output = hashMapOf<String, Any?>()
	pairs.forEach {
		val value : Any? = when (it.second!!::class.qualifiedName) {
			"kotlin.Int.Companion"           -> nbtItem.getInteger(it.first)
			"kotlin.Long.Companion"          -> nbtItem.getLong(it.first)
			"kotlin.Short.Companion"         -> nbtItem.getShort(it.first)
			"kotlin.Double.Companion"        -> nbtItem.getDouble(it.first)
			"kotlin.Float.Companion"         -> nbtItem.getFloat(it.first)
			"kotlin.IntArray"                -> nbtItem.getIntArray(it.first)
			// Bytes
			"kotlin.Byte.Companion"          -> nbtItem.getByte(it.first)
			"kotlin.ByteArray"               -> nbtItem.getByteArray(it.first)
			// Other Types
			"kotlin.String.Companion"        -> nbtItem.getString(it.first)
			"kotlin.Boolean.Companion"       -> nbtItem.getBoolean(it.first)
			// Useful Objects
			"org.bukkit.inventory.ItemStack" -> nbtItem.getItemStack(it.first)
			"java.util.UUID"                 -> nbtItem.getUUID(it.first)
			else                             -> null
		}
		output[it.first] = value
	}
	return output
}

inline fun <reified T> ItemStack.getNbtTag(key : String) : T? {
	val nbtItem = NBTItem(this)
	return when (T::class) {
		// Numbers
		Int::class       -> nbtItem.getInteger(key) as T?
		Long::class      -> nbtItem.getLong(key) as T?
		Short::class     -> nbtItem.getShort(key) as T?
		Double::class    -> nbtItem.getDouble(key) as T?
		Float::class     -> nbtItem.getFloat(key) as T?
		IntArray::class  -> nbtItem.getIntArray(key) as T?
		// Bytes
		Byte::class      -> nbtItem.getByte(key) as T?
		ByteArray::class -> nbtItem.getByteArray(key) as T?
		// Other Types
		String::class    -> nbtItem.getString(key) as T?
		Boolean::class   -> nbtItem.getBoolean(key) as T?
		// Useful Objects
		ItemStack::class -> nbtItem.getItemStack(key) as T?
		UUID::class      -> nbtItem.getUUID(key) as T?
		else             -> null
	}
}
