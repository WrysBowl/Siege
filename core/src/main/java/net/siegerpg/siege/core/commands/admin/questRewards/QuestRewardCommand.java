package net.siegerpg.siege.core.commands.admin.questRewards;

import net.siegerpg.siege.core.commands.admin.questRewards.rewards.*;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class QuestRewardCommand implements CommandExecutor {

	HashMap<String, QuestReward > questRewards = new HashMap<>(){
		{
			put("hillyWoodTrials", new HillyWoodTrials());
			put("joeTheWeaver", new JoeTheWeaver());
			put("goingClubbing", new GoingClubbing());
			put("movingUp", new MovingUp());
			put("realWorld", new RealWorld());

		}
	};

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		Player player;
		String id;
		try {
			player = Bukkit.getPlayer(args[0]);
			id = args[1];
			if (!questRewards.containsKey(id)) return false;
			if (player == null) return false;
		} catch (Exception ignored) {return false;}

		if (sender instanceof Player) {
			sender.sendMessage(Utils.lore("<red>Only console can use this command."));
			return false;
		}

		QuestReward reward = questRewards.get(id);
		reward.sendReward(player);

		return true;
	}

}
