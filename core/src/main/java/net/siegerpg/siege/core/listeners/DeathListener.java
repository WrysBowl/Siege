package net.siegerpg.siege.core.listeners;

import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.api.exceptions.InvalidMobTypeException;
import io.lumine.xikage.mythicmobs.mobs.ActiveMob;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.Webstore.WebstoreUtils;
import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.mobs.hillyWoods.bosses.*;
import net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon.*;
import net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile.*;
import net.siegerpg.siege.core.drops.mobs.hillyWoods.neutral.*;
import net.siegerpg.siege.core.drops.mobs.hillyWoods.passive.*;
import net.siegerpg.siege.core.utils.Scoreboard;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.utils.GoldEXPSpawning;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.VaultHook;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class DeathListener implements Listener, Runnable {

    public static HashMap<String, MobDropTable> mobDropTableHashMap = new HashMap<>(){
        {

            //BOSSES
            put("Ogre", new Ogre());

            //DUNGEON BOSSES
            put("RockSpirit", new RockSpirit());
            put("SlimeSpirit", new SlimeSpirit());
            put("MagmaSpirit", new MagmaSpirit());
            put("Werewolf", new Werewolf());
            put("FoxSpirit", new FoxSpirit());
            put("BullSpirit", new BullSpirit());
            put("Davy_Jones", new Davy_Jones());
            put("Necromancer", new Necromancer());
            put("Lich", new Lich());
            put("BroodMother", new BroodMother());

            //HOSTILES
            put("AngryBull", new AngryBull());
            put("Bandit", new Bandit());
            put("BanditArcher", new BanditArcher());
            put("Blob", new Blob());
            put("BloodSucker", new BloodSucker());
            put("ForestSpider", new ForestSpider());
            put("Goblin", new Goblin());
            put("GoldenGoblin", new GoldenGoblin());
            put("InfectedDigger", new InfectedDigger());
            put("Orc", new Orc());
            put("RockRat", new RockRat());
            put("ScorchingBlob", new ScorchingBlob());
            put("Sea_Warrior", new Sea_Warrior());
            put("ZombifiedDigger", new ZombifiedDigger());

            //NEUTRALS
            put("GiantHornet", new GiantHornet());
            put("WildFox", new WildFox());
            put("ChestMimic1", new ChestMimic1());
            put("ChestMimic2", new ChestMimic2());
            put("ChestMimic3", new ChestMimic3());
            put("ChestMimic4", new ChestMimic4());

            //PASSIVES
            put("FeatheredMeat", new FeatheredMeat());
            put("MooMoo", new MooMoo());
            put("Pigeon", new Pigeon());
            put("Porky", new Porky());
            put("Sushi", new Sushi());
            put("Wooly", new Wooly());
        }
    };

    @EventHandler
    public void damageDrops(EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player)) return;

        ActiveMob mm = MythicMobs.inst().getAPIHelper().getMythicMobInstance(e.getDamager());
        if (mm == null) return;

        ItemStack reward = null;
        double chance = 0.0;
        if (mm.getType().getInternalName().equals("Goblin")) {
            reward = new GoldenCarrot(100).getUpdatedItem(false);
            chance = 5.0;
        } else if (mm.getType().getInternalName().equals("WildFox")) {
            reward = new GoldenCarrot(50).getUpdatedItem(false);
            chance = 10.0;
        }
        if (reward == null) return;

        if (Utils.randTest(chance)) {
            if (e.getEntity().getLocation().distance(e.getEntity().getWorld().getSpawnLocation()) > 3) {
                e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), reward);
            }
        }
    }

    @EventHandler
    public void mobDeath(EntityDeathEvent e) throws InvalidMobTypeException {

        if (e.getEntity().getKiller() == null) return;
        if (!(MythicMobs.inst().getAPIHelper().isMythicMob(e.getEntity()))) return;

        String mm = MythicMobs.inst().getAPIHelper().getMythicMobInstance(e.getEntity()).getType().getInternalName();
        MobDropTable mobDrop = mobDropTableHashMap.get(mm);

        if (mobDrop instanceof ChestMimic1) {
            if (Utils.randTest(25.0)) {
                e.getEntity().getKiller().sendMessage(Utils.lore("<red>Oh no! Your supply drop carried zombies!"));
                MythicMobs.inst().getAPIHelper().spawnMythicMob("ZombifiedDigger", e.getEntity().getLocation());
                MythicMobs.inst().getAPIHelper().spawnMythicMob("ZombifiedDigger", e.getEntity().getLocation());
                MythicMobs.inst().getAPIHelper().spawnMythicMob("ZombifiedDigger", e.getEntity().getLocation());
                MythicMobs.inst().getAPIHelper().spawnMythicMob("ZombifiedDigger", e.getEntity().getLocation());
                MythicMobs.inst().getAPIHelper().spawnMythicMob("ZombifiedDigger", e.getEntity().getLocation());
            }
        }

        e.setDroppedExp(0);
        e.getDrops().clear();

        if (mobDrop == null) return;

        Player player = e.getEntity().getKiller();
        double luck = 0.0;
        int goldCoinAmt = mobDrop.getGold(true);
        Location loc = e.getEntity().getLocation();

        if (player != null) {luck = CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.LUCK, player.getItemInHand());}

        if (mobDrop.getExp(true) > 0 && player != null) {
            int exp = mobDrop.getExp(true);
            exp = (int) Math.floor(exp * WebstoreUtils.expMultiplier);
            if ((Math.random() * 100) <= luck) {
                exp *= 2;
            }
            GoldEXPSpawning.spawnEXP(exp, loc);
        } //Give exp reward

        if (goldCoinAmt > 0 && player != null) {
            goldCoinAmt = (int) Math.floor(goldCoinAmt * WebstoreUtils.goldMultiplier);
            if ((Math.random() * 100) <= luck) {
                goldCoinAmt *= 2;
            }
            GoldEXPSpawning.spawnGold(goldCoinAmt, loc);
        }

        for (ItemStack drop : mobDrop.getRewards(luck)) { //Loop through all drops
            loc.getWorld().dropItemNaturally(loc, drop);
        }
    }

    @EventHandler
    public void removePlayerGold(PlayerDeathEvent e) {
        e.deathMessage(null);
        Player player = e.getEntity().getPlayer();
        if (player != null) {
            if (player.getWorld().equals(Core.plugin().getServer().getWorld("SiegeHub"))) return;
            int bal = (int) Math.round(VaultHook.econ.getBalance(player));

            double percBal = (Math.floor(bal / 10000.0) / 100);
            if (percBal > 0.15) percBal = 0.15;
            int newBal = (int) Math.round(bal * (0.95 - percBal));


            if (newBal < 0) newBal = 0;
            VaultHook.econ.withdrawPlayer(player, bal);
            VaultHook.econ.depositPlayer(player, newBal);
            player.sendTitle(Utils.tacc("&c&lYou Died"), Utils.tacc("&c" + (bal - newBal) + " gold &7has been lost"), 1, 60, 1);
            Scoreboard.updateScoreboard(player);

            if (player.getWorld().equals(Core.plugin().getServer().getWorld("PVP"))) {
                Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), new Runnable() {
                    public void run() {
                        World HUB = Core.plugin().getServer().getWorld("Hub");
                        player.teleport(new Location(HUB, -52, 91, -8, 168, 0));
                    }
                }, 5);
            }
        }
    }

    @Override
    public void run() {

    }
}