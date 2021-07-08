package net.siegerpg.siege.core.skills.implemented.archer;

import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.subTypes.ArcherSkill;
import org.bukkit.event.player.PlayerInteractEvent;

import javax.annotation.Nullable;
import java.util.HashMap;

public class PoisonArrows extends ArcherSkill {

    int ID;
    @Nullable HashMap<StatTypes,Double> STATS;
    Skill SKILL;
    boolean activeSkill;
    @Nullable HashMap<Integer, ArcherSkill> CHILDREN;

    public PoisonArrows(){
        this.ID = 1;
        this.SKILL = this;
        this.activeSkill = true;
        this.CHILDREN = new HashMap<>(){
            {
            put(1, new PoisonArrows());
            }
        };
    }
    public PoisonArrows(int id, @Nullable HashMap<StatTypes,Double> stats, @Nullable HashMap<Integer, ArcherSkill> children) {
        this.ID = id;
        this.STATS = stats;
        this.CHILDREN = children;
    }
    public PoisonArrows(Skill skill) {
        this.SKILL = skill;
    }

    @Override
    public void skillAction(PlayerInteractEvent e) {
        if(activeSkill) {
            return;
        }
    }
}
