package net.siegerpg.siege.core.fishing.events;

import net.siegerpg.siege.core.fishing.FishingTask;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.types.misc.CustomTool;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.cache.LevelEXPStorage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;


public class RightClickEvent implements Listener {
	
	
	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		if(FishingTask.runningTasks.containsKey(player.getUniqueId())) {
			FishingTask task = FishingTask.runningTasks.get(player.getUniqueId());
			CustomFishEvent ce = task.getEvent();
			if(ce.getFishingData().isFishing())
			{
				e.setCancelled(true);
				if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK)
				{
					if (task.direction == -1) {
						task.direction = 1;
					} else {
						task.direction = -1;
					}
				}
			}
		} else if (player.getInventory().getItemInMainHand().getType().equals(Material.FISHING_ROD)) {
			ItemStack item = player.getInventory().getItemInMainHand();
			CustomItem customItem = CustomItemUtils.INSTANCE.getCustomItem(item);
			e.setCancelled(true);
			if (!(customItem instanceof CustomTool)) return;
			if (customItem.getLevelRequirement() == null) return;
			if (customItem.getLevelRequirement() > LevelEXPStorage.playerLevel.get(player)) {
				player.sendMessage(Utils.parse("<red>You are too weak to cast this fishing rod!"));
				player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);

				return;
			}
			e.setCancelled(false);

		}
	}

}
