package net.siegerpg.siege.shops

open class Shop(name: String, permission: String, items: List<ShopItem>) {
    val name : String = name
    val permission : String = permission
    val items : List<ShopItem> = items
}