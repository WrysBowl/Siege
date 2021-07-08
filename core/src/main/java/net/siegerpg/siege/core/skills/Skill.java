package net.siegerpg.siege.core.skills;

import net.siegerpg.siege.core.skills.implemented.archer.PoisonArrows;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

public interface Skill {

    default void skillAction(PlayerInteractEvent e){}
}
