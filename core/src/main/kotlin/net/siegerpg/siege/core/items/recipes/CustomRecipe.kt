@file:Suppress("MemberVisibilityCanBePrivate")

package net.siegerpg.siege.core.items.recipes

import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.implemented.weapons.melee.TestSword
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.reflections.Reflections

open class CustomRecipe(var items: MutableList<CustomItem?>, var shaped: Boolean = true, var createItem: (Player?, Boolean) -> CustomItem) {

    fun matches(matrix: List<CustomItem?>): Boolean {
        return if (shaped) {
            matrix == items
        } else {
            matrix.containsAll(items)
        }
    }

    constructor() : this(arrayOfNulls<CustomItem?>(9).toMutableList(), true, { _: Player?, _: Boolean ->
        TestSword(5)
    })

    fun item(createItem: (Player?, Boolean) -> CustomItem) {
        this.createItem = createItem
    }

    fun s1(item: CustomItem?) {
        items[0] = item
    }

    fun s2(item: CustomItem?) {
        items[1] = item
    }

    fun s3(item: CustomItem?) {
        items[2] = item
    }

    fun s4(item: CustomItem?) {
        items[3] = item
    }

    fun s5(item: CustomItem?) {
        items[4] = item
    }

    fun s6(item: CustomItem?) {
        items[5] = item
    }

    fun s7(item: CustomItem?) {
        items[6] = item
    }

    fun s8(item: CustomItem?) {
        items[7] = item
    }

    fun s9(item: CustomItem?) {
        items[8] = item
    }

    companion object {
        val recipes: MutableList<CustomRecipe> = mutableListOf()

        val classList = hashMapOf<String, Class<out CustomItem>>()

        fun registerRecipe(recipe: CustomRecipe) {
            recipes.add(recipe)
        }

        fun getRecipe(matrix: List<CustomItem?>): CustomRecipe? {
//            matrix.forEach {
//                if (it == null) {
//                    Bukkit.getLogger().info("null")
//                } else {
//                    Bukkit.getLogger().info(it::class.qualifiedName)
//                }
//
//            }
            return recipes.firstOrNull {
                it.matches(matrix)
            }
//            val item = result?.createItem
//            item?.let {
//                Bukkit.getLogger().info("Item isn't null")
//                Bukkit.getLogger().info(item(null, false)::class.qualifiedName)
//            }
//            if (result != null) Bukkit.getLogger().info("Result should not be null")
//            return result
        }


        fun registerAllRecipes() {
            //TestSword().registerRecipes()
            val reflections = Reflections("net.siegerpg.siege.core.items.implemented")
            reflections.getSubTypesOf(CustomItem::class.java).forEach {
                if (it.canonicalName.contains("implemented")) {
                    try {
                        val clazz = Class.forName(it.canonicalName)
                        val item = clazz.newInstance()
                        if (item is CustomItem) {
                            item.registerRecipes()
                            classList[it.canonicalName] = clazz as Class<out CustomItem>
                        }

                    } catch (e: Exception) {
                        Bukkit.getLogger().info("Failed to register recipes for ${it.canonicalName}")
                    }

                }

            }
//            getAllSuperTypes(TestSword::class.java).forEach {
//                Bukkit.getLogger().info(it.canonicalName)
//            }
        }
    }

}
