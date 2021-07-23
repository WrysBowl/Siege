package net.siegerpg.siege.core.skills;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.cache.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.HashMap;

public class SkillListener implements Listener, Runnable {

    @EventHandler
    public boolean skillActivate(PlayerInteractEvent e){
        Player player = e.getPlayer();
        if (player.getGameMode().equals(GameMode.CREATIVE) || player.getGameMode().equals(GameMode.SPECTATOR)) return false;
        if (!player.getOpenInventory().getType().equals(InventoryType.CRAFTING)) return false;
        //Some method to start checking when the server should track the player's clicks

        ArrayList<Action> playerTriggers = PlayerData.playerTriggers.get(player);
        playerTriggers.add(e.getAction());

        //If the player hasn't finished their trigger skill activation yet (less than three clicks)
        if (playerTriggers.size() < 3) {
            //Send player title messages to notify them what their current click trigger setup is
            PlayerData.playerTriggers.put(player, playerTriggers);
            if (playerTriggers.size() == 1) {
                player.sendTitle(null,Utils.tacc("&e&l"+playerTriggers.get(0)+"  &c&l?  ?"), 10, 30, 10);
            } else if (playerTriggers.size() == 2) {
                player.sendTitle(null,Utils.tacc("&e&l"+playerTriggers.get(0)+"  "+playerTriggers.get(1)+"  &c&l?"), 10, 30, 10);
            }
            return false;

        } else {
            player.sendTitle(null,Utils.tacc("&e&l"+playerTriggers.get(0)+"  "+playerTriggers.get(1)+"  "+playerTriggers.get(2)), 10, 30, 10);
            HashMap<Integer, Skill> playerSkills = PlayerData.playerSkills.get(player);
            PlayerData.playerTriggers.get(player).clear();

            //Compare the player's cached skills to the trigger they have created and activate the skill
            for(Skill skill : playerSkills.values()) {
                if (skill.getTrigger()!=playerTriggers) continue;

                //Checks if player has enough mana to use the skill
                if (PlayerData.playerCurrentMana.get(player) < skill.getManaCost()) {
                    player.sendTitle(
                            skill.DISPLAY_ITEM.getI18NDisplayName(),
                            Utils.tacc("&c&l"+PlayerData.playerCurrentMana.get(player)+"&4/"+skill.getManaCost()+" &emana needed"),
                            10, 30, 10);
                    return false;
                }
                //Removes the cost of the skill from the player's current mana data
                PlayerData.playerCurrentMana.put(player, PlayerData.playerCurrentMana.get(player)-skill.getManaCost());
                skill.skillAction(e);
            }
        }
        return true;
    }

    @Override
    public void run() {

    }
}
