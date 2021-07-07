package net.siegerpg.siege.core.skills.subTypes;

import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.skills.Skill;

import javax.annotation.Nullable;
import java.util.HashMap;

public class ArcherSkill implements Skill {

    String ID;
    @Nullable HashMap<StatTypes,Double> STATS;
    Skill SKILL;

    public ArcherSkill(){
        this.ID = "A0";
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
        this.SKILL = null;
    }

    public ArcherSkill(String id, @Nullable HashMap<StatTypes,Double> stats, Skill skill) {
        this.ID = id;
        this.STATS = stats;
        this.SKILL = skill;
    }
}
