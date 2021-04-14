package net.siegerpg.siege.core.items.recipes

import net.siegerpg.siege.core.items.implemented.weapons.melee.TestSword

fun recipes(init: CustomRecipeList.() -> Unit): CustomRecipeList {
    val customRecipeList = CustomRecipeList()
    customRecipeList.init()
    return customRecipeList
}

fun test() {
    recipes {
        recipe {
            shaped = false
            s1(TestSword(25))
            s2(TestSword(25))
            item { player, b ->
                val customItem = TestSword(50)
                customItem.updateMeta(b)
                customItem
            }
        }
        recipe {
            shaped = true
            s3(TestSword(50))
            s4(TestSword(50))
            item { player, b ->
                val customItem = TestSword(50)
                customItem.updateMeta(b)
                customItem
            }
        }
    }

}

class CustomRecipeList {
    var recipeList = mutableListOf<CustomRecipe>()
    fun recipe(init: CustomRecipe.() -> Unit): CustomRecipe {
        val customRecipe = CustomRecipe()
        customRecipe.init()
        recipeList.add(customRecipe)
        return customRecipe
    }
}