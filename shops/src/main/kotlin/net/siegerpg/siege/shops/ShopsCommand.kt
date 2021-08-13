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
import net.siegerpg.siege.core.utils.Scoreboard
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

       // if (sender is Player && sender.name == "Sumowo") sender.inventory.addItem(Pebble.tier(1).getUpdatedItem(false))

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
           if (meta.displayName != "") meta.lore("")
           if (it.craftable) {
               meta.lore("<gray>Crafting Materials")
               for (entry in it.recipe) {
                   meta.lore("<aqua>${entry.value}x ${entry.key.getUpdatedItem(false).itemMeta.displayName}")
               }
               meta.lore("<yellow>Left click to craft!")
           }
           if (it.buyPrice > -1) meta.lore("<yellow>Right click to buy for ${it.buyPrice} gold!")
           item.itemMeta = meta
           val guiItem = GuiItem(item)
           guiItem.setAction { event ->
               when {
                   event.isLeftClick -> {
                       if (!it.craftable) return@setAction
                       if (event.getView().getBottomInventory().firstEmpty() == -1) return@setAction player.sendMessage(MiniMessage.get().parse("<red>Your inventory is full!"))
                       for (entry in it.recipe) {
                           if (!player.inventory.containsAtLeast(entry.key.getUpdatedItem(false), entry.value)) {
                               return@setAction player.sendMessage(MiniMessage.get().parse(if (entry.value == 1) "<red>You don't have a ${entry.key.name}!" else "<red>You don't have enough ${entry.key.name}s!"))
                           }
                       }
                       for (entry in it.recipe) {
                           val stack = entry.key.getUpdatedItem(false)
                           stack.amount = entry.value
                           player.inventory.removeItem(stack)
                       }
                       player.inventory.addItem(it.generate())
                   }
                   event.isRightClick -> {
                       if (it.buyPrice < 0) return@setAction

                       if (VaultHook.econ.getBalance(player) < it.buyPrice) {
                           player.sendMessage(MiniMessage.get().parse("<red>You don't have enough gold!"))
                           return@setAction
                       }
                       if (event.getView().getBottomInventory().firstEmpty() == -1) return@setAction player.sendMessage(MiniMessage.get().parse("<red>Your inventory is full!"))

                       player.inventory.addItem(it.generate())
                       VaultHook.econ.withdrawPlayer(player, it.buyPrice.toDouble())
                       Scoreboard.updateScoreboard(event.whoClicked as Player)
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