package net.siegerpg.siege.core.skills.subTypes;

import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.implemented.archer.CriticalShot;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;

public class ArcherSkill extends Skill {

    public static String appendSkill(Player player, int id){
        //get player's skill string here
        String skills = "";
        if (skills.isEmpty() || skills == null) return ("A_"+id);
        return (skills + "_" + id);
    }

}
