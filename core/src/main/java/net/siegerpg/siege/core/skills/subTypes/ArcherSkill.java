package net.siegerpg.siege.core.skills.subTypes;

import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.implemented.archer.CriticalShot;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;

public class ArcherSkill extends Skill {

    int ID;
    @Nullable HashMap<StatTypes,Double> STATS;
    Skill SKILL;
    @Nullable HashMap<Integer, ArcherSkill> CHILDREN;
    final ArrayList<ArcherSkill> SKILLS = new ArrayList<>(){
        {
            add(new CriticalShot());
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
                put(1, new CriticalShot());
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
}
