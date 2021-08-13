package net.siegerpg.siege.shops

abstract class Shop {
    abstract var name: String
    abstract var permission: String
    abstract var items: List<ShopItem>
}