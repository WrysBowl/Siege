package net.siegerpg.siege.core.skills.implemented.archer;

import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.subTypes.ArcherSkill;
import org.bukkit.event.player.PlayerInteractEvent;

import javax.annotation.Nullable;
import java.util.HashMap;

public class PoisonArrows extends ArcherSkill {

    String ID = "A1";
    @Nullable HashMap<StatTypes,Double> STATS;
    Skill SKILL = this;
    boolean activeSkill = true;

    public PoisonArrows(String id, @Nullable HashMap<StatTypes,Double> stats, Skill skill){
        super(id, stats, skill);
    }

    @Override
    public void skillAction(PlayerInteractEvent e) {
        if(activeSkill) {
            return;
        }

    }
}
