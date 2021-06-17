package net.siegerpg.siege.shops

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.Default
import co.aikar.commands.annotation.Optional
import com.comphenix.protocol.PacketType
import com.github.stefvanschie.inventoryframework.gui.GuiItem
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui
import com.github.stefvanschie.inventoryframework.pane.OutlinePane
import com.github.stefvanschie.inventoryframework.pane.PaginatedPane
import com.github.stefvanschie.inventoryframework.pane.Pane
import com.github.stefvanschie.inventoryframework.pane.StaticPane
import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.Material
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import net.siegerpg.siege.core.utils.lore


@CommandAlias("shops")
class ShopsCommand: BaseCommand() {

   @Default
   fun default(sender: CommandSender, id: String, @Optional target: Player?) {
       if (sender is Player && sender.name != "Sumowo") return
        if (target == null && sender is ConsoleCommandSender) {
            return sender.sendMessage(MiniMessage.get().parse("<red>Please specify a target player!"))
        }
       val player: Player = if (target == null) sender as Player else target
       if (!ShopsPlugin.instance?.shopRegistry?.contains(id)!!) {
           return sender.sendMessage(MiniMessage.get().parse("<red>Invalid shop name!"))
       } else {
           val shop = ShopsPlugin.instance?.shopRegistry?.get(id)!!
           val gui = ChestGui(6, shop.name)
           val outlinePane = OutlinePane(0, 0, 9, 6, Pane.Priority.LOWEST)
           val glassPane = ItemStack(Material.GRAY_STAINED_GLASS_PANE)
           val glassPaneMeta = glassPane.itemMeta
           glassPaneMeta.displayName(MiniMessage.get().parse("<black><obf>|||"))
           glassPane.setItemMeta(glassPaneMeta)
           outlinePane.addItem(GuiItem(glassPane))
           outlinePane.setRepeat(true)
           outlinePane.setOnClick {
               it.isCancelled = true
           }
           val paginatedPane = PaginatedPane(1, 1, 9, 6, Pane.Priority.HIGHEST)

           val mainPane = StaticPane(0, 0, 9, 6, Pane.Priority.HIGHEST)
           paginatedPane.setOnClick {
               it.isCancelled = true
           }
           var currentX = 0
           var currentY = 0
           shop.items.forEach {
               val item = it.getUpdatedItem(true)
               val meta = item.itemMeta
               meta.lore("")
               meta.lore("<yellow>Click to craft!")
               item.itemMeta = meta
               mainPane.addItem(GuiItem(item), currentX, currentY)
               currentX += 1
               if (currentX > 6) {
                   currentX = 0
                   currentY += 1
               }
           }
           val panesList: List<StaticPane> = listOf(mainPane)
           var paneIndex = 0
           for (staticPane in panesList) {
               paginatedPane.addPane(paneIndex, staticPane)
               paneIndex++
           }
           //mainPane.addItem(GuiItem(ItemStack(Material.STONE)), 0, 0)
           gui.addPane(outlinePane)
           gui.addPane(paginatedPane)
           gui.show(player)
       }

   }
}