package net.siegerpg.siege.core.commands.admin.dailyRewards;

import net.siegerpg.siege.core.commands.admin.dailyRewards.rewards.*;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class DailyRewardCommand implements CommandExecutor {

	HashMap<Integer, DailyReward> dailyRewards = new HashMap<>(){
		{
			put(1, new DailyReward1());
			put(2, new DailyReward2());
			put(3, new DailyReward3());
			put(4, new DailyReward4());
			put(5, new DailyReward5());
			put(6, new DailyReward6());
			put(7, new DailyReward7());
			put(8, new DailyReward8());
			put(9, new DailyReward9());
			put(10, new DailyReward10());
			put(11, new DailyReward11());
			put(12, new DailyReward12());
			put(13, new DailyReward13());
			put(14, new DailyReward14());
			put(15, new DailyReward15());
			put(16, new DailyReward16());
			put(17, new DailyReward17());
			put(18, new DailyReward18());
			put(19, new DailyReward19());
			put(20, new DailyReward20());
			put(21, new DailyReward21());
			put(22, new DailyReward22());
			put(23, new DailyReward23());
			put(24, new DailyReward24());
			put(25, new DailyReward25());
			put(26, new DailyReward26());
			put(27, new DailyReward27());
			put(28, new DailyReward28());
			put(29, new DailyReward29());
			put(30, new DailyReward30());

		}
	};

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		Player player;
		int day;
		try {
			player = Bukkit.getPlayer(args[0]);
			day = Integer.parseInt(args[1]);
			if (player == null) return false;
			if (day < 1 || day > 30) return false;
		} catch (Exception ignored) {return false;}

		if (sender instanceof Player) {
			sender.sendMessage(Utils.lore("<red>Only console can use this command."));
			return false;
		}

		DailyReward reward = dailyRewards.get(day);
		reward.sendReward(player);

		return true;
	}

}
