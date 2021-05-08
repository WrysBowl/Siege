package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.listeners.ArmorEquip.ArmorEquipEvent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

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
    public void equip(ArmorEquipEvent event){
        
    }
}
