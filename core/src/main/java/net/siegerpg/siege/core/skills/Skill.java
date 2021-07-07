package net.siegerpg.siege.core.skills;

import org.bukkit.event.player.PlayerInteractEvent;

public interface Skill {

    default void skillAction(PlayerInteractEvent e){}
    default Skill skill(){return this;}

    //DECODE and ENCODE from the database

}
