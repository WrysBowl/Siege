package net.siegerpg.siege.core.skills;

import de.tr7zw.nbtapi.NBTContainer;
import de.tr7zw.nbtapi.NBTItem;
import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.skills.implemented.archer.CriticalShot;
import net.siegerpg.siege.core.skills.subTypes.ArcherSkills;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.cache.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class SkillUtils {

    static ArrayList<Skill> warriorSkills = new ArrayList<>(){
        {
        }
    };
    static ArrayList<Skill> mageSkills = new ArrayList<>(){
        {
        }
    };
    static ArrayList<Skill> heavySkills = new ArrayList<>(){
        {
        }
    };
    static HashMap<Character, ArrayList<Skill>> skillTypes = new HashMap<>(){
        {
	        this.put('A', ArcherSkills.skills);
	        this.put('W', SkillUtils.warriorSkills);
	        this.put('M', SkillUtils.mageSkills);
	        this.put('H', SkillUtils.heavySkills);
        }
    };

    // Takes string code i.e. "A_1_4_7" and returns hashmap of skills
    public static HashMap<Integer, Skill> decode(final String code) {
        final HashMap<Integer, Skill> map = new HashMap<Integer, Skill>(); // HashMap to return
        if (code.equals("")) return map;
        final ArrayList<Skill> arr = SkillUtils.skillTypes.get(code.charAt(0));
        int indexNum = 0; // ID of skill
        // Start loop at index 2 and iterate by twos across the string
        for (int i = 2; i < code.length(); i += 2) {
            indexNum = code.charAt(i); // IDs will be at even locations
            map.put(indexNum, arr.get(indexNum)); // Update return hashmap
        }
        return map;
    }

    // Takes hashmap from decode and returns total stat change from skills in the form of a hashmap
    public static HashMap<StatTypes, Double> getStats(final HashMap<Integer, Skill> decoded) {
        final HashMap<StatTypes, Double> map; // HashMap to return
        // Init with zero values
        map = new HashMap<>(){
            {
	            this.put(StatTypes.LUCK, 0.0);
	            this.put(StatTypes.STRENGTH, 0.0);
	            this.put(StatTypes.TOUGHNESS, 0.0);
	            this.put(StatTypes.HEALTH, 0.0);
	            this.put(StatTypes.REGENERATION, 0.0);
	            this.put(StatTypes.MANA, 0.0);
	            this.put(StatTypes.MANA_REGEN, 2.0);
            }
        };
        // Loop across every entry in the decoded map
        for (final HashMap.Entry<Integer, Skill> entry : decoded.entrySet()) {
            final Skill value = entry.getValue(); // get value of each entry
            final HashMap<StatTypes,Double> skillStats = value.STATS; // get the stat changes for each entry
            // Loop across every stat change in an entry
            assert skillStats != null;
            for (final HashMap.Entry<StatTypes, Double> vEntry : skillStats.entrySet()) {
                map.replace(vEntry.getKey(), value.STATS.get(vEntry.getKey()) + vEntry.getValue()); // Update return hashmap
            }
        }
        return map;
    }
    public static boolean isSkillOrb(final ItemStack item) {
        final NBTContainer nbt = NBTItem.convertItemtoNBT(item);
        return nbt.getBoolean("skillItem");
    }
    public static boolean canActivate(final Player player, final Skill skill) {
        if (PlayerData.playerCurrentMana.get(player) < skill.getManaCost()) {
            player.sendTitle(
                    skill.DISPLAY_ITEM.getI18NDisplayName(),
                    Utils.tacc("&c&l"+PlayerData.playerCurrentMana.get(player)+"&4/"+skill.getManaCost()+" &emana needed"),
                    10, 30, 10);
            return false;
        }
        return true;
    }
    public static void sendTriggers(final Player player, final ArrayList<Action> triggers) {
        if (triggers.size() == 1) {
            player.sendTitle(null,Utils.tacc("&e&l"+triggers.get(0)+"  &c&l?  ?"), 10, 30, 10);
        } else if (triggers.size() == 2) {
            player.sendTitle(null,Utils.tacc("&e&l"+triggers.get(0)+"  "+triggers.get(1)+"  &c&l?"), 10, 30, 10);
        } else {
            player.sendTitle(null,Utils.tacc("&e&l"+triggers.get(0)+"  "+triggers.get(1)+"  "+triggers.get(2)), 10, 30, 10);
        }
    }
}
