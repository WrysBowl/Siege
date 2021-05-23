package net.siegerpg.siege.core.cache;

import kotlin.Triple;
import net.siegerpg.siege.core.drops.BlockDrops;
import net.siegerpg.siege.core.utils.Bank;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.HashMap;

public class PreviousBrokenBlock {
    public static ArrayList<Triple<Player, Material, BlockDrops>> previousBlock = new ArrayList<>();
}
