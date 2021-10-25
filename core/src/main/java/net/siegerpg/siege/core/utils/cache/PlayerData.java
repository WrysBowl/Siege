package net.siegerpg.siege.core.utils.cache;

import kotlin.Pair;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.items.types.misc.CustomMaterial;
import net.siegerpg.siege.core.listeners.ArmorEquip.ArmorEquipEvent;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.utils.Levels;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayerData implements Listener {
    public static HashMap<Player, Boolean> hasActionBar = new HashMap<>();
    public static HashMap<Player, Boolean> broadcastTips = new HashMap<>();
    public static HashMap<Player, Double> playerHealth = new HashMap<>();
    public static HashMap<Player, Double> playerCurrentMana = new HashMap<>();
    public static HashMap<Player, Double> playerMana = new HashMap<>();
    public static HashMap<Player, HashMap<Integer, Skill>> playerSkills = new HashMap<>();
    public static HashMap<Player, ArrayList<Action>> playerTriggers = new HashMap<>();

    @EventHandler
    public void onEnable(final PluginEnableEvent e) {
        for (final Player player : Bukkit.getOnlinePlayers()) {
            PlayerData.setStats(player);
            PlayerData.hasActionBar.put(player, false);
            broadcastTips.put(player, true);
            //playerSkills.put(player, SkillUtils.decode(Skills.INSTANCE.getSkills(player)));
        }
    }

    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        final Player player = e.getPlayer();
        PlayerData.hasActionBar.put(player, false);
        PlayerData.setStats(player);
        //playerSkills.put(player, SkillUtils.decode(Skills.INSTANCE.getSkills(player)));
        if (!broadcastTips.containsKey(player)) {
            broadcastTips.put(player, true);
        }
    }

    @EventHandler
    public void onLeave(final PlayerQuitEvent e) {
        final Player player = e.getPlayer();
        PlayerData.playerHealth.remove(player);
        PlayerData.playerMana.remove(player);
        PlayerData.playerCurrentMana.remove(player);
        PlayerData.playerSkills.remove(player);
    }

    public static void setStats(final Player player) {
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.plugin(), () -> {
            PlayerData.playerHealth.put(
                    player,
                    CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.HEALTH) + player.getMaxHealth() + player.getLevel() * 2);

            PlayerData.playerMana.put(
                    player,
                    CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.MANA));

        }, 2);
    }


    @EventHandler
    public void onEquip(final ArmorEquipEvent e) {
        @Nullable final CustomItem item = CustomItemUtils.INSTANCE.getCustomItem(e.getNewArmorPiece());
        if (item == null) {
            PlayerData.setStats(e.getPlayer());
            return;
        }
        if (item.getLevelRequirement() == null) {
            return;
        }
        final Pair<Short, Integer> expLevel = Levels.INSTANCE.blockingGetExpLevel(e.getPlayer());
        if (item.getLevelRequirement() > (expLevel != null ? expLevel.getFirst() : 0)) {
            e.getPlayer().sendTitle("", ChatColor.RED + "Too weak to use this armor's stats", 1, 80, 1);
            return;
        }
        PlayerData.setStats(e.getPlayer());
    }

    @EventHandler
    public void toolSwitch(final PlayerItemHeldEvent e) {
        final CustomItem item = CustomItemUtils.INSTANCE.getCustomItem(e.getPlayer().getInventory().getItemInMainHand());
        if (item != null) {
            if (!(item instanceof CustomMaterial)) {
                PlayerData.setStats(e.getPlayer());
            }
        }
    }
}
