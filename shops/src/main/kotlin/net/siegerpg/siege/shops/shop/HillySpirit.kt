package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.*
import net.siegerpg.siege.core.items.implemented.misc.materials.*
import net.siegerpg.siege.shops.*

class HillySpirit : Shop() {
    override var name: String = "Hilly Spirit"
    override var permission: String = "siege.shops.shop.hillySpirit"
    override var items: List<ShopItem> = listOf(
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(
            HillyWoodsSpirit(0), -1, hashMapOf(
                RockSpiritKey(0) to 1,
                SlimeSpiritKey(0) to 1,
                MagmaSpiritKey(0) to 1,
                FoxSpiritKey(0) to 1,
                WerewolfKey(0) to 1,
                BullSpiritKey(0) to 1,
                DavyJonesKey(0) to 1,
                NecromancerKey(0) to 1,
                LichKey(0) to 1,
                BroodmotherKey(0) to 1), true) {
            HillyWoodsSpirit(0).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        }
    )
}