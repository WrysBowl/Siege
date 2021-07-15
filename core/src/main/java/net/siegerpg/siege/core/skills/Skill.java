package net.siegerpg.siege.core.skills;

import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.skills.implemented.archer.CriticalShot;
import net.siegerpg.siege.core.skills.subTypes.ArcherSkill;
import net.siegerpg.siege.core.utils.cache.PlayerData;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;

public class Skill {

    //Decode needs to be static for us to reference it, but then skillTypes need to be static, and so I transferred
    //all the hashmaps and methods to another class
    @Nullable HashMap<StatTypes,Double> STATS;
    int ID;
    Skill SKILL;
    @Nullable HashMap<Integer, ArcherSkill> CHILDREN;
    ItemStack displayItem;
    @Nullable Integer MANACOST;

    public Skill(){
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
        this.displayItem = new ItemStack(Material.AIR);
        this.MANACOST = 0;
    }
    public Skill(int id, @Nullable HashMap<StatTypes,Double> stats, @Nullable HashMap<Integer, ArcherSkill> children, int manaCost) {
        this.ID = id;
        this.STATS = stats;
        this.CHILDREN = children;
        this.MANACOST = manaCost;
    }
    public Skill(Skill skill) {
        this.SKILL = skill;
    }

    public boolean skillCheck(PlayerInteractEvent e){
        Player player = e.getPlayer();
        if (player.getGameMode().equals(GameMode.CREATIVE) ||
                player.getGameMode().equals(GameMode.SPECTATOR)) return false;
        if (!player.getOpenInventory().getType().equals(InventoryType.CRAFTING)) return false;



        //if (StatChangeListener.mana.get(player) >= matchedSkill.STATS.get(StatTypes.MANA)) return false;
        return true;
    }



}
