package net.siegerpg.siege.shops

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.CommandPermission
import co.aikar.commands.annotation.Default
import co.aikar.commands.annotation.Optional
import co.aikar.commands.bukkit.contexts.OnlinePlayer
import com.github.stefvanschie.inventoryframework.gui.GuiItem
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui
import com.github.stefvanschie.inventoryframework.pane.OutlinePane
import com.github.stefvanschie.inventoryframework.pane.Pane
import com.github.stefvanschie.inventoryframework.pane.StaticPane
import net.kyori.adventure.text.minimessage.MiniMessage
import net.siegerpg.siege.core.informants.Scoreboard
import net.siegerpg.siege.core.utils.Utils
import net.siegerpg.siege.core.utils.VaultHook
import net.siegerpg.siege.core.utils.lore
import org.bukkit.Material
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

@CommandAlias("shops")
@CommandPermission("siege.shops.open")
class ShopsCommand: BaseCommand() {

   @Default
   fun default(sender: CommandSender, id: String, @Optional @CommandPermission("siege.shops.open.others") target: OnlinePlayer?) {

       //if (sender is Player && sender.name != "Sumowo") return

       if (target == null && sender is ConsoleCommandSender) {
           return sender.sendMessage(MiniMessage.get().parse("<red>Please specify a target player!"))
       }

       if (target != null && !sender.hasPermission("siege.shops.open.others")) return sender.sendMessage(MiniMessage.get().parse("<red>You do not have permission to open shops for others!"))

       val player: Player = if (target == null || target.player == null) (sender as Player) else target.player

       if (!ShopsPlugin.instance?.shopRegistry?.contains(id)!!) return sender.sendMessage(MiniMessage.get().parse("<red>Invalid shop name!"))


       val shop = ShopsPlugin.instance?.shopRegistry?.get(id)!!
       if (sender is Player && !sender.hasPermission(shop.permission)) return sender.sendMessage(MiniMessage.get().parse("<red>You do not have permission to open this shop!"))

       val gui = ChestGui(6, shop.name)

       // glass outline
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

       // main pane
       val mainPane = StaticPane(1, 1, 9, 6, Pane.Priority.HIGHEST)
       mainPane.setOnClick {
           it.isCancelled = true
       }
       var currentX = 0
       var currentY = 0
       shop.items.forEach {
           val item = it.item.getUpdatedItem(true)
           val meta = item.itemMeta
           meta.lore("")
           if (it.buyPrice > -1) meta.lore("<aqua>Click to buy for ${it.buyPrice} gold!")
           if (it.sellPrice > -1) meta.lore("<aqua>Right click to sell for ${it.sellPrice} gold!")
           if (it.craftable) meta.lore("<yellow>Middle click to craft!")
           item.itemMeta = meta
           val guiItem = GuiItem(item)
           guiItem.setAction { event ->
               when {
                   event.isLeftClick -> {
                       if (it.buyPrice < 0) return@setAction
                       if (VaultHook.econ.getBalance(player) >= it.buyPrice) {
                           if (event.getView().getBottomInventory().firstEmpty() != -1) {
                               //player.inventory.addItem(it.item.getUpdatedItem(false))
                               VaultHook.econ.withdrawPlayer(player, it.buyPrice.toDouble())
                               Scoreboard.updateScoreboard(event.getWhoClicked() as Player)
                           } else {
                               player.sendMessage(Utils.tacc("&cYour inventory is full!"))
                           }
                       } else {
                           player.sendMessage(Utils.tacc("&cYou do not have enough money to purchase this item!"))
                       }
                       //gui.inventory.close()
                   }
                   event.isRightClick -> {
                       if (it.sellPrice < 0) return@setAction
                       event.whoClicked.sendMessage(MiniMessage.get().parse("<yellow>This item sells for ${it.sellPrice}!"))
                       gui.inventory.close()
                   }

               }
           }
           mainPane.addItem(guiItem, currentX, currentY)
           currentX += 1
           if (currentX > 6) {
               currentX = 0
               currentY += 1
           }
       }

       // add panes to GUI
       gui.addPane(outlinePane)
       gui.addPane(mainPane)
       gui.show(player)

   }
}