package net.siegerpg.siege.core.skills.subTypes;

import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.implemented.archer.PoisonArrows;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.HashMap;

public class ArcherSkill implements Skill {

    int ID;
    @Nullable HashMap<StatTypes,Double> STATS;
    Skill SKILL;
    @Nullable HashMap<Integer, ArcherSkill> CHILDREN;

    public ArcherSkill(){
        this.ID = 0;
        this.STATS = new HashMap<>(){
            {
                put(StatTypes.LUCK, 0.0);
                put(StatTypes.STRENGTH, 0.0);
                put(StatTypes.TOUGHNESS, 0.0);
                put(StatTypes.HEALTH, 0.0);
                put(StatTypes.REGENERATION, 0.0);
                put(StatTypes.MANA, 0.0);
                put(StatTypes.MANA_REGEN, 0.0);
            }
        };
        this.SKILL = this;
        this.CHILDREN = new HashMap<>(){
            {
                put(1, new PoisonArrows());
            }
        };
    }
    public ArcherSkill(int id, @Nullable HashMap<StatTypes,Double> stats, @Nullable HashMap<Integer, ArcherSkill> children) {
        this.ID = id;
        this.STATS = stats;
        this.CHILDREN = children;
    }
    public ArcherSkill(Skill skill) {
        this.SKILL = skill;
    }

    public static String appendSkill(Player player, int id){
        //get player's skill string here
        String skills = "";
        if (skills.isEmpty() || skills == null) return ("A_"+id);
        return (skills + "_" + id);
    }
    /**
     * DECODE
     * Takes the skill string from the database, given a player
     * Uses the skill string to return a hashmap of the skill IDs and skill objects
     */
}
