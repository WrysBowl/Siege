package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.informants.StatVariables;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.listeners.ArmorEquip.ArmorEquipEvent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

public class StatChangeListener implements Listener {

    /*
    Bukkit.getLogger().info("ArmorEquipEvent - " + event.getMethod());
        Bukkit.getLogger().info("Type: " + event.getType());
        Bukkit.getLogger().info("New: " + (event.getNewArmorPiece() != null ? event.getNewArmorPiece().getType() : "null"));
        Bukkit.getLogger().info("Old: " + (event.getOldArmorPiece() != null ? event.getOldArmorPiece().getType() : "null"));
        boolean test = true;
        if(test){
            // Does a test where if you start in survival without a helmet on you SHOULD end up in survival without the helmet on, or adventure mode if helmet is on.
            // Used to make sure spam clicking doesn't mess up, no clue if a better test exists.
            if(event.getOldArmorPiece() != null && event.getOldArmorPiece().getType().equals(Material.DIAMOND_HELMET)){
                event.getPlayer().setGameMode(event.getPlayer().getGameMode().equals(GameMode.ADVENTURE) ? GameMode.SURVIVAL : GameMode.ADVENTURE);
            }
            if(event.getNewArmorPiece() != null && event.getNewArmorPiece().getType().equals(Material.DIAMOND_HELMET)){
                event.getPlayer().setGameMode(event.getPlayer().getGameMode().equals(GameMode.ADVENTURE) ? GameMode.SURVIVAL : GameMode.ADVENTURE);
            }
            Bukkit.getLogger().info("New Gamemode: " + event.getPlayer().getGameMode());
        }
     */

    @EventHandler
    public void onEquip(ArmorEquipEvent e){
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.plugin(), () -> {
            StatVariables.playerHealth.put(
                    e.getPlayer(),
                    CustomItemUtils.INSTANCE.getPlayerStat(e.getPlayer(), StatTypes.HEALTH));

            StatVariables.playerToughness.put(
                    e.getPlayer(),
                    CustomItemUtils.INSTANCE.getPlayerStat(e.getPlayer(), StatTypes.TOUGHNESS));
        }, 2);
    }

    @EventHandler
    public void toolSwitch(PlayerItemHeldEvent e) {
        if (CustomItemUtils.INSTANCE.getCustomItem(e.getPlayer().getInventory().getItemInMainHand()) != null) {
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.plugin(), () -> {
                StatVariables.playerHealth.put(
                        e.getPlayer(),
                        CustomItemUtils.INSTANCE.getPlayerStat(e.getPlayer(), StatTypes.HEALTH));

                StatVariables.playerToughness.put(
                        e.getPlayer(),
                        CustomItemUtils.INSTANCE.getPlayerStat(e.getPlayer(), StatTypes.TOUGHNESS));
            }, 2);
        }
    }
}
