package net.siegerpg.siege.core.skills;

import net.siegerpg.siege.core.miscellaneous.cache.PlayerData;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.HashMap;

public class SkillListener implements Listener, Runnable {

	public boolean skillActivate(PlayerInteractEvent e) {

		Player player = e.getPlayer();
		if (player
				    .getGameMode()
				    .equals(GameMode.CREATIVE) || player
				    .getGameMode()
				    .equals(GameMode.SPECTATOR))
			return false;
		if (!player
				.getOpenInventory()
				.getType()
				.equals(InventoryType.CRAFTING)) return false;
		if (!SkillUtils.isSkillOrb(player.getItemInHand())) return false;

		ArrayList< Action > playerTriggers = PlayerData.playerTriggers.get(player);
		playerTriggers.add(e.getAction());

		//If the player hasn't finished their trigger skill activation yet (less than three clicks)
		SkillUtils.sendTriggers(player, playerTriggers);
		if (playerTriggers.size() < 3) {
			PlayerData.playerTriggers.put(player, playerTriggers);
			return false;

		} else {
			HashMap< Integer, Skill > playerSkills = PlayerData.playerSkills.get(player);
			PlayerData.playerTriggers
					.get(player)
					.clear();

			//Compare the player's cached skills to the trigger they have created and activate the skill
			for (Skill skill : playerSkills.values()) {
				if (skill.getTrigger() != playerTriggers) continue;

				//Checks if player does not have enough mana to use the skill
				if (!SkillUtils.canActivate(player, skill)) return false;
				//Removes the cost of the skill from the player's current mana data
				PlayerData.playerCurrentMana.put(player, PlayerData.playerCurrentMana.get(player) -
				                                         skill.getManaCost());
				skill.skillAction(e);
			}
		}
		return true;
	}

	@Override
	public void run() {

	}

}
