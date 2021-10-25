package net.siegerpg.siege.core.skills.subTypes;

import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.Skills;
import net.siegerpg.siege.core.skills.implemented.archer.CriticalShot;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;

import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import java.util.HashMap;

public class ArcherSkills {

    public static ArrayList<Skill> skills = new ArrayList<>(){
        {
	        this.add(new CriticalShot());
        }
    };

    public static String appendSkill(final Player player, final Skill skill){
        final int id = skill.getID();
        final String playerSkills = Skills.INSTANCE.getSkills(player);
        if (playerSkills.isEmpty()) return ("A_"+id);
        return (playerSkills + "_" + id);
    }
}
