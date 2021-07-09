package net.siegerpg.siege.core.skills;

import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.skills.implemented.archer.CriticalShot;
import net.siegerpg.siege.core.skills.subTypes.ArcherSkill;
import net.siegerpg.siege.core.utils.cache.PlayerData;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;

public class Skill {

    //Decode needs to be static for us to reference it, but then skillTypes need to be static, and so I transferred
    //all the hashmaps and methods to another class
    @Nullable HashMap<StatTypes,Double> STATS = new HashMap<>(){
        {
            put(StatTypes.LUCK, 0.0);
            put(StatTypes.STRENGTH, 0.0);
            put(StatTypes.TOUGHNESS, 0.0);
            put(StatTypes.HEALTH, 0.0);
            put(StatTypes.REGENERATION, 0.0);
            put(StatTypes.MANA, 0.0);
            put(StatTypes.MANA_REGEN, 2.0);
        }
    };;

    public boolean skillCheck(PlayerInteractEvent e){
        Player player = e.getPlayer();
        if (player.getGameMode().equals(GameMode.CREATIVE) ||
                player.getGameMode().equals(GameMode.SPECTATOR)) return false;
        if (!player.getOpenInventory().getType().equals(InventoryType.CRAFTING)) return false;

        

        //if (StatChangeListener.mana.get(player) >= matchedSkill.STATS.get(StatTypes.MANA)) return false;
        return true;
    }

    /* do later
    public static String appendSkill(Player player, int id){
        //get player's skill string here
        String skills = "";
        if (skills.isEmpty() || skills == null) return ("A_"+id);
        return (skills + "_" + id);
    }
     */
}
