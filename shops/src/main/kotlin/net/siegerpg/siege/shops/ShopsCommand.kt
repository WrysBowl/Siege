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
import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.miscellaneous.Scoreboard
import net.siegerpg.siege.core.miscellaneous.VaultHook
import net.siegerpg.siege.core.miscellaneous.lore
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

@CommandAlias("shops")
@CommandPermission("siege.shops.open")
class ShopsCommand : BaseCommand() {

	@Default
	@SuppressWarnings("unused")
	fun default(
			sender : CommandSender,
			id : String,
			@Optional @CommandPermission("siege.shops.open.others") target : OnlinePlayer?
	           ) {


		if (target == null && sender is ConsoleCommandSender) {
			return sender.sendMessage(
					MiniMessage.get().parse("<red>Please specify a target player!")
			                         )
		}

		if (target != null && !sender.hasPermission("siege.shops.open.others")) return sender.sendMessage(
				MiniMessage.get()
						.parse("<red>You do not have permission to open shops for others!")
		                                                                                                 )

		val player : Player =
				if (target?.player == null) (sender as Player) else target.player

		if (!ShopsPlugin.instance?.shopRegistry?.contains(id)!!) return sender.sendMessage(
				MiniMessage.get().parse("<red>Invalid shop name!")
		                                                                                  )


		val shop = ShopsPlugin.instance?.shopRegistry?.get(id)!!
		if (sender is Player && !sender.hasPermission(shop.permission)) return sender.sendMessage(
				MiniMessage.get()
						.parse("<red>You do not have permission to open this shop!")
		                                                                                         )

		//This is some ugly code that I have yet to change
		var gui = ChestGui(3, shop.name)
		var outlinePane = OutlinePane(0, 0, 9, 3, Pane.Priority.LOWEST)
		var mainPane = StaticPane(1, 1, 9, 3, Pane.Priority.HIGHEST)

		if (shop.items.size in 8..14) {
			gui = ChestGui(4, shop.name)
			outlinePane = OutlinePane(0, 0, 9, 4, Pane.Priority.LOWEST)
			mainPane = StaticPane(1, 1, 9, 4, Pane.Priority.HIGHEST)
		} else if (shop.items.size in 15..21) {
			gui = ChestGui(5, shop.name)
			outlinePane = OutlinePane(0, 0, 9, 5, Pane.Priority.LOWEST)
			mainPane = StaticPane(1, 1, 9, 5, Pane.Priority.HIGHEST)
		} else if (shop.items.size in 22..28) {
			gui = ChestGui(6, shop.name)
			outlinePane = OutlinePane(0, 0, 9, 6, Pane.Priority.LOWEST)
			mainPane = StaticPane(1, 1, 9, 6, Pane.Priority.HIGHEST)
		}

		val glassPane = ItemStack(Material.GRAY_STAINED_GLASS_PANE)
		val glassPaneMeta = glassPane.itemMeta
		glassPaneMeta.displayName(MiniMessage.get().parse("<black><obf>|||"))
		glassPane.itemMeta = glassPaneMeta
		outlinePane.addItem(GuiItem(glassPane))
		outlinePane.setRepeat(true)
		outlinePane.setOnClick {
			it.isCancelled = true
		}

		// main pane

		mainPane.setOnClick {
			it.isCancelled = true
		}
		var currentX = 0
		var currentY = 0
		shop.items.forEach {
			var item = it.item.getUpdatedItem(true)
			val meta = item.itemMeta
			if (meta.displayName() != null) meta.lore("")
			if (it.craftable) {
				var counter = 0
				meta.lore("<gray><underlined>Crafting Ingredients")
				for (entry in it.recipe) {

					val itemMeta = entry.key.getUpdatedItem(false).itemMeta
					val updatedItem =
							if (itemMeta.hasDisplayName()) itemMeta.displayName else itemMeta.localizedName

					if (!player.inventory.containsAtLeast(
									entry.key.getUpdatedItem(false),
									entry.value)) {
						meta.lore("<red>\u2717 ${entry.value}x <pre>${updatedItem}</pre>")
					} else {
						meta.lore("<green>\u2714 ${entry.value}x <pre>${updatedItem}</pre>")
						counter++
					}
				}
				meta.lore("")
				if (counter == it.recipe.size) meta.lore("<green>\u2714 LEFT CLICK to craft!")
				else meta.lore("<red>\u2717 LEFT CLICK <gray>to craft!")

			}
			if (it.buyPrice > -1) {
				if (VaultHook.econ.getBalance(player) >= it.buyPrice) {
					meta.lore("<green>\u2714 RIGHT CLICK <gray>Cost ${String.format("%,d", it.buyPrice)} gold")
				} else {
					meta.lore("<red>\u2717 RIGHT CLICK <gray>Cost ${String.format("%,d", it.buyPrice)} gold")
				}
			}
			item.itemMeta = meta
			if (it.item is GRAYFILLER) {
				item = ItemStack(Material.GRAY_STAINED_GLASS_PANE)
				val itemMeta = item.itemMeta
				itemMeta.displayName(MiniMessage.get().parse("<black><obf>|||"))
				item.itemMeta = itemMeta
			}
			val guiItem = GuiItem(item)
			guiItem.setAction { event ->
				when {
					event.isLeftClick  -> {
						if (!it.craftable) return@setAction
						if (event.view.bottomInventory
										.firstEmpty() == -1
						) {
							player.playSound(
									player.location,
									Sound.ENTITY_VILLAGER_NO,
									1.0f,
									1.0f
							                )
							return@setAction player.sendMessage(
									MiniMessage.get()
											.parse("<red>Your inventory is full!")
							                                   )
						}
						for (entry in it.recipe) {
							if (!player.inventory.containsAtLeast(
											entry.key.getUpdatedItem(false),
											entry.value
							                                     )
							) {
								player.playSound(
										player.location,
										Sound.ENTITY_VILLAGER_NO,
										1.0f,
										1.0f
								                )
								return@setAction player.sendMessage(
										MiniMessage.get()
												.parse(if (entry.value == 1) "<red>You don't have a ${entry.key.name}!" else "<red>You don't have enough ${entry.key.name}s!")
								                                   )
							}
						}
						for (entry in it.recipe) {
							val stack = entry.key.getUpdatedItem(false)
							stack.amount = entry.value
							player.inventory.removeItem(stack)
						}
						player.inventory.addItem(it.generate())
						Bukkit.dispatchCommand(sender, "shops " + id + " " + player.name)
						player.playSound(
								player.location,
								Sound.ENTITY_VILLAGER_CELEBRATE,
								1.0f,
								1.0f
						                )
						player.updateInventory()
					}

					event.isRightClick -> {
						if (it.buyPrice < 0) return@setAction

						if (VaultHook.econ.getBalance(player) < it.buyPrice) {
							player.playSound(
									player.location,
									Sound.ENTITY_VILLAGER_NO,
									1.0f,
									1.0f
							                )
							return@setAction player.sendMessage(
									MiniMessage.get()
											.parse("<red>You don't have enough gold!")
							                                   )
						}
						if (event.view.bottomInventory
										.firstEmpty() == -1
						) {
							player.playSound(
									player.location,
									Sound.ENTITY_VILLAGER_CELEBRATE,
									1.0f,
									1.0f
							                )
							return@setAction player.sendMessage(
									MiniMessage.get()
											.parse("<red>Your inventory is full!")
							                                   )
						}

						player.inventory.addItem(it.generate())
						player.playSound(
								player.location,
								Sound.ENTITY_VILLAGER_CELEBRATE,
								1.0f,
								1.0f
						                )
						VaultHook.econ.withdrawPlayer(player, it.buyPrice.toDouble())
						player.updateInventory()
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