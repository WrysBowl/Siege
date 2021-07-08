package net.siegerpg.siege.core.skills.subTypes;

import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.implemented.archer.PoisonArrows;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;

public class ArcherSkill implements Skill {

    int ID;
    @Nullable HashMap<StatTypes,Double> STATS;
    Skill SKILL;
    @Nullable HashMap<Integer, ArcherSkill> CHILDREN;
    final ArrayList<ArcherSkill> SKILLS = new ArrayList<>(){
        {
            add(new PoisonArrows());
        }
    };

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

    // Takes string code i.e. "A_1_4_7" and returns hashmap of skills
    public HashMap<Integer, ArcherSkill> decode(String code) {
        HashMap<Integer, ArcherSkill> map = new HashMap<Integer, ArcherSkill>(); // HashMap to return
        int indexNum = 0; // ID of skill
        // Start loop at index 2 and iterate by twos across the string
        for (int i = 2; i < code.length(); i += 2) {
            indexNum = code.charAt(i); // IDs will be at even locations
            map.put(indexNum, SKILLS.get(indexNum)); // Update return hashmap
        }
        return map;
    }

    // Takes hashmap from decode and returns total stat change from skills in the form of a hashmap
    public HashMap<StatTypes, Double> getStats(HashMap<Integer, ArcherSkill> decoded) {
        HashMap<StatTypes, Double> map; // HashMap to return
        // Init with zero values
        map = new HashMap<>(){
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
        // Loop across every entry in the decoded map
        for (HashMap.Entry<Integer, ArcherSkill> entry : decoded.entrySet()) {
            ArcherSkill value = entry.getValue(); // get value of each entry
            HashMap<StatTypes,Double> skillStats = value.STATS; // get the stat changes for each entry
            // Loop across every stat change in an entry
            for (HashMap.Entry<StatTypes, Double> vEntry : skillStats.entrySet()) {
                map.replace(vEntry.getKey(), STATS.get(vEntry.getKey()) + vEntry.getValue()); // Update return hashmap
            }
        }
        return map;
    }
    /**
     * DECODE
     * Takes the skill string from the database, given a player
     * Uses the skill string to return a hashmap of the skill IDs and skill objects
     */
}
