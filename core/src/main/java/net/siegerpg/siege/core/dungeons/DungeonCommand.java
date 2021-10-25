package net.siegerpg.siege.core.dungeons;

import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.api.exceptions.InvalidMobTypeException;
import io.lumine.xikage.mythicmobs.mobs.ActiveMob;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.dungeons.dungeon.*;
import net.siegerpg.siege.core.events.BossFight;
import net.siegerpg.siege.core.events.BossLeaderboard;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.types.misc.CustomKey;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Instant;
import java.util.HashMap;

public class DungeonCommand implements CommandExecutor, Runnable {

    public static HashMap<String, Dungeon> dungeons = new HashMap<>() {
        {
            this.put("SlimeSpirit", new SlimeSpirit());
            this.put("MagmaSpirit", new MagmaSpirit());
            this.put("BullSpirit", new BullSpirit());
            this.put("Lich", new Lich());
            this.put("Davy_Jones", new Davy_Jones());
            this.put("Necromancer", new Necromancer());
            this.put("FoxSpirit", new FoxSpirit());
            this.put("Broodmother", new Broodmother());

        }
    };

    public HashMap<String, Long> coolDowns = new HashMap<>();


    @Override
    public boolean onCommand(@NotNull final CommandSender sender, @NotNull final Command command, @NotNull final String label, @NotNull final String[] args) {
        if (sender instanceof Player) {
            sender.sendMessage(Utils.lore("<red>You are not able to run the dungeons command."));
            return false;
        }

        //cooldown
        final int cooldownTime = 2;
        if(this.coolDowns.containsKey(sender.getName())) {
            final long secondsLeft = ((this.coolDowns.get(sender.getName())/1000)+cooldownTime) - (System.currentTimeMillis()/1000);
            if(secondsLeft>0) {
                return false;
            }
        }
        this.coolDowns.put(sender.getName(), System.currentTimeMillis());

        try {
            final String boss = args[0];
            final Player player = Bukkit.getPlayer(args[1]);
            if (player == null) return false;

            final Dungeon dungeon = DungeonCommand.dungeons.get(boss);

            final CustomKey reqKey = dungeon.reqKey;
            final CustomItem hand = CustomItemUtils.INSTANCE.getCustomItem(player.getInventory().getItemInMainHand());
            if (hand == null) {
                player.sendMessage(Utils.lore("<yellow>" + dungeon.currentKeyCount + "<yellow>/8 keys <gray>have been used."));
                return false;
            }
            if (dungeon.boss != null) {
                player.sendMessage(Utils.lore("<red>The boss is currently alive... somewhere."));
                return false;
            }
            if (hand.getClass() != reqKey.getClass()) {
                player.sendMessage(Utils.lore("<red>Please use the correct key."));
                return false;
            }
            player.getInventory().removeItem(hand.getItem().asOne());
            final int count = dungeon.currentKeyCount + 1; //add one to key count
            if (count < 8) { //if key count + 1 is less than 8, add to key count
                dungeon.currentKeyCount = count;
                player.sendMessage(Utils.lore("<yellow>" + dungeon.currentKeyCount + "<yellow>/8 keys <gray>have been used."));
            } else {
                dungeon.currentKeyCount = 0; //reset key count
                dungeon.spawning();
                final Location loc = dungeon.spawnLoc;
                loc.setWorld(Core.plugin().getServer().getWorld(dungeon.world));
                Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), () -> {
                    try {
                        dungeon.boss = MythicMobs.inst().getAPIHelper().spawnMythicMob(boss, loc);
                        final ActiveMob mythicMob = MythicMobs.inst().getAPIHelper().getMythicMobInstance(dungeon.boss);
                        final BossFight newBossFight = new BossFight(Instant.now(), mythicMob);
                        BossLeaderboard.Companion.getCurrentBossFights().add(newBossFight);
                    } catch (final InvalidMobTypeException e) {
                        e.printStackTrace();
                    }
                }, dungeon.bossSpawnDelay);
                player.sendMessage(Utils.lore("<green>The boss has spawned!"));
            }

        } catch (final Exception x) {
            return false;
        }
        return false;
    }

    @Override
    public void run() {

    }
}