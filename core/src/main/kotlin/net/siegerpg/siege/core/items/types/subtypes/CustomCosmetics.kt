package net.siegerpg.siege.core.items.types.subtypes

import io.papermc.paper.event.player.AsyncChatEvent
import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.listeners.ArmorEquip.ArmorEquipEvent
import org.bukkit.event.player.PlayerInteractEvent

interface CustomCosmetics: CustomItem {

    fun onCosmeticInteract(e: PlayerInteractEvent) {}
    fun onCosmeticEquip(e: ArmorEquipEvent) {}
    fun onCosmeticSpeak(e: AsyncChatEvent) {}

}