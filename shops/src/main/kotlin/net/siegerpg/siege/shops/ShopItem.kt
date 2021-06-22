package net.siegerpg.siege.shops

import net.siegerpg.siege.core.items.CustomItem

data class ShopItem(
    val item: CustomItem,
    val buyPrice: Int,
    val sellPrice: Int,
    val craftable: Boolean
)