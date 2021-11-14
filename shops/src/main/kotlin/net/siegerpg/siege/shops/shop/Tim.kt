package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Dagger
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Shank
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.WoodenSword
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.daggers.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.shanks.*
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.woodenSwords.*
import net.siegerpg.siege.core.utils.*
import net.siegerpg.siege.shops.*

class Tim : Shop() {
    override var name: String = "Time"
    override var permission: String = "siege.shops.shop.tim"
    override var items: List<ShopItem> = listOf(
        //WOODEN SWORDS
        ShopItem(WoodenSword(-1), 2500, hashMapOf(), false) {
            WoodenSword(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(LuckyWoodenSword(-1), -1, hashMapOf(), false) {
            LuckyWoodenSword(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(StrongWoodenSword(-1), -1, hashMapOf(), false) {
            StrongWoodenSword(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(ToughWoodenSword(-1), -1, hashMapOf(), false) {
            ToughWoodenSword(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(HealthyWoodenSword(-1), -1, hashMapOf(), false) {
            HealthyWoodenSword(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(HealingWoodenSword(-1), -1, hashMapOf(), false) {
            HealingWoodenSword(Utils.randRarity()).getUpdatedItem(false)
        }
    )
}