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

    @Nullable HashMap<StatTypes,Double> STATS;

    ArrayList<Skill> archerSkills = new ArrayList<>(){
        {
            add(new CriticalShot());
        }
    };
    ArrayList<Skill> warriorSkills = new ArrayList<>(){
        {
        }
    };
    ArrayList<Skill> mageSkills = new ArrayList<>(){
        {
        }
    };
    ArrayList<Skill> heavySkills = new ArrayList<>(){
        {
        }
    };
    HashMap<Character, ArrayList<Skill>> skillTypes = new HashMap<>(){
        {
            put('A', archerSkills);
        }
    };

    // Takes string code i.e. "A_1_4_7" and returns hashmap of skills
    public HashMap<Integer, Skill> decode(String code) {
        HashMap<Integer, Skill> map = new HashMap<Integer, Skill>(); // HashMap to return
        ArrayList<Skill> arr = skillTypes.get(code.charAt(0));
        int indexNum = 0; // ID of skill
        // Start loop at index 2 and iterate by twos across the string
        for (int i = 2; i < code.length(); i += 2) {
            indexNum = code.charAt(i); // IDs will be at even locations
            map.put(indexNum, arr.get(indexNum)); // Update return hashmap
        }
        return map;
    }

    // Takes hashmap from decode and returns total stat change from skills in the form of a hashmap
    public HashMap<StatTypes, Double> getStats(HashMap<Integer, Skill> decoded) {
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
        for (HashMap.Entry<Integer, Skill> entry : decoded.entrySet()) {
            Skill value = entry.getValue(); // get value of each entry
            HashMap<StatTypes,Double> skillStats = value.STATS; // get the stat changes for each entry
            // Loop across every stat change in an entry
            for (HashMap.Entry<StatTypes, Double> vEntry : skillStats.entrySet()) {
                map.replace(vEntry.getKey(), STATS.get(vEntry.getKey()) + vEntry.getValue()); // Update return hashmap
            }
        }
        return map;
    }

    public boolean skillTrigger(PlayerInteractEvent e){
        Player player = e.getPlayer();
        if (player.getGameMode().equals(GameMode.CREATIVE) ||
                player.getGameMode().equals(GameMode.SPECTATOR)) return false;
        if (!player.getOpenInventory().getType().equals(InventoryType.CRAFTING)) return false;
        //if (PlayerData.mana.get(player) >= matchedSkill.STATS.get(StatTypes.MANA)) return false;
        //FOR FUTURE REFERENCE
        //To get player total mana
        //Skills.getStats(Skills.decode(Skills.INSTANCE.someMethodToGetTheSkillString())).get(StatTypes.MANA)
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
