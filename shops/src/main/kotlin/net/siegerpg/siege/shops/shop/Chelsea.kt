package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.food.Apple
import net.siegerpg.siege.core.items.implemented.misc.food.Bread
import net.siegerpg.siege.core.items.implemented.misc.food.Drumstick
import net.siegerpg.siege.core.items.implemented.misc.materials.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.shops.*

class Chelsea : Shop() {
    override var name: String = "Chelsea"
    override var permission: String = "siege.shops.shop.chelsea"
    override var items: List<ShopItem> = listOf(
        ShopItem(Drumstick(0), 25, hashMapOf(), false) {
            Drumstick(0).getUpdatedItem(false)
        },
        ShopItem(Apple(0), 20, hashMapOf(), false) {
            Apple(0).getUpdatedItem(false)
        },
        ShopItem(Bread(0), 40, hashMapOf(), false) {
            Bread(0).getUpdatedItem(false)
        },
        ShopItem(Bread(0), -1, hashMapOf(Wheat.tier(2) to 4), true) {
            Bread(0).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },

        //Quality 50
        ShopItem(Drumstick(50), 60, hashMapOf(), false) {
            Drumstick(50).getUpdatedItem(false)
        },
        ShopItem(Apple(50), 45, hashMapOf(), false) {
            Apple(50).getUpdatedItem(false)
        },
        ShopItem(Bread(50), 80, hashMapOf(), false) {
            Bread(50).getUpdatedItem(false)
        },
        ShopItem(Bread(50), -1, hashMapOf(Wheat.tier(3) to 1), true) {
            Bread(50).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },

        //Quality 1000
        ShopItem(Drumstick(100), 110, hashMapOf(), false) {
            Drumstick(100).getUpdatedItem(false)
        },
        ShopItem(Apple(100), 75, hashMapOf(), false) {
            Apple(100).getUpdatedItem(false)
        },
        ShopItem(Bread(100), 140, hashMapOf(), false) {
            Bread(100).getUpdatedItem(false)
        },
        ShopItem(Bread(100), -1, hashMapOf(Wheat.tier(3) to 3), true) {
            Bread(100).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        }
    )
}