package net.siegerpg.siege.core.commands;

import de.tr7zw.nbtapi.NBTContainer;
import de.tr7zw.nbtapi.NBTItem;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.CustomItemUtilsKt;
import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.items.types.misc.CustomMaterial;
import net.siegerpg.siege.core.items.types.subtypes.CustomEquipment;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class StatUpgradeListener implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if (!(sender instanceof Player)) return false;
		Player player = ((Player) sender).getPlayer();
		if (player == null) return false;

		ItemStack mainItem = player.getInventory().getItemInMainHand();
		ItemStack materialItem = player.getInventory().getItemInOffHand();

		CustomItem customMainItem = CustomItemUtils.INSTANCE.getCustomItem(mainItem);
		CustomItem customMaterialItem = CustomItemUtils.INSTANCE.getCustomItem(materialItem);

		if (customMainItem == null) return false;

		if (customMaterialItem == null) return false;

		if (!(customMaterialItem instanceof CustomMaterial)) return false;


		HashMap<Integer, HashMap< StatTypes, Double>> tierStatMap = ((CustomMaterial) customMaterialItem).getUpgradeStats();
		if (tierStatMap == null) return false;

		HashMap< StatTypes, Double> materialStatMap = tierStatMap.get(((CustomMaterial) customMaterialItem).getTier());
		if (!(customMainItem instanceof CustomEquipment)) return false;

		//add maps to one map
		((CustomEquipment) customMainItem).addUpgradeStats(materialStatMap);
		customMainItem.updateMeta(false);

		player.getInventory().setItemInMainHand(customMainItem.getItem());
		return false;
	}

}
