package net.siegerpg.siege.core.skills;

import net.siegerpg.siege.core.items.enums.StatTypes;

import java.util.HashMap;

public interface Skill {
    String ID = null;
    HashMap<StatTypes,Double> stats = null;

    HashMap<String,Skill> skills = new HashMap<>(){
        {
            //put("A1", new ArcherPower());
        }
    };
}
