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
import net.siegerpg.siege.core.drops.mobs.twilight.bosses.Unicorn;
import net.siegerpg.siege.core.drops.mobs.twilight.hostile.*;
import net.siegerpg.siege.core.drops.mobs.twilight.neutral.*;
import net.siegerpg.siege.core.drops.mobs.twilight.passive.*;
import net.siegerpg.siege.core.drops.mobs.twilight.passive.Bat;
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
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class DeathListener implements Listener, Runnable {

    public HashMap<String, MobDropTable> mobDropTableHashMap = new HashMap<>(){
        {
            //BOSSES
            put("Blubber", new Blubber());
            put("DeathBull", new DeathBull());
            put("Mercenary", new Mercenary());
            put("Molter", new Molter());
            put("Ogre", new Ogre());
            put("Orc", new Orc());
            put("RockSpirit", new RockSpirit());
            put("Werewolf", new Werewolf());

            put("Unicorn", new Unicorn());

            //DUNGEON BOSSES
            put("Broodmother", new Broodmother());
            put("BullSpirit", new BullSpirit());
            put("Davy_Jones", new Davy_Jones());
            put("FoxSpirit", new FoxSpirit());
            put("Lich", new Lich());
            put("MagmaSpirit", new MagmaSpirit());
            put("Necromancer", new Necromancer());
            put("SlimeSpirit", new SlimeSpirit());

            //HOSTILES
            put("AngryBull", new AngryBull());
            put("Bandit", new Bandit());
            put("BanditArcher", new BanditArcher());
            put("Blob", new Blob());
            put("BloodSucker", new BloodSucker());
            put("Bully", new Bully());
            put("FlamingGoo", new FlamingGoo());
            put("ForestSpider", new ForestSpider());
            put("Goblin", new Goblin());
            put("GoldenGoblin", new GoldenGoblin());
            put("Goo", new Goo());
            put("InfectedDigger", new InfectedDigger());
            put("RockRat", new RockRat());
            put("ScorchingBlob", new ScorchingBlob());
            put("ScrapRat", new ScrapRat());
            put("Sea_Warrior", new Sea_Warrior());
            put("Skeletal_Archer", new Skeletal_Archer());
            put("Skeletal_Warrior", new Skeletal_Warrior());
            put("Thief", new Thief());
            put("ZombifiedDigger", new ZombifiedDigger());

            put("SkeletalGeneral", new SkeletalGeneral());
            put("Corrupted_Skeleton", new Corrupted_Skeleton());
            put("Dark_Elf", new Dark_Elf());
            put("Dark_Fairy", new Dark_Fairy());
            put("Digger_Overseer", new Digger_Overseer());
            put("Fairy_Outlaw", new Fairy_Outlaw());
            put("Freezing_Skeletal_Warrior", new Freezing_Skeletal_Warrior());
            put("Greater_Spider", new Greater_Spider());
            put("Leaf_Monster", new Leaf_Monster());
            put("Moss_Lurker", new Moss_Lurker());
            put("Nightmare", new Nightmare());
            put("Shroomlight_Monster", new Shroomlight_Monster());
            put("Stone_Monster", new Stone_Monster());

            //NEUTRALS
            put("GiantHornet", new GiantHornet());
            put("WildFox", new WildFox());
            put("ChestMimic1", new ChestMimic1());
            put("ChestMimic2", new ChestMimic2());
            put("ChestMimic3", new ChestMimic3());
            put("ChestMimic4", new ChestMimic4());

            put("Archer_Elf", new Archer_Elf());
            put("Warrior_Elf", new Warrior_Elf());
            put("Twilight_Wolf", new Twilight_Wolf());


            //PASSIVES
            put("FeatheredMeat", new FeatheredMeat());
            put("MooMoo", new MooMoo());
            put("Pigeon", new Pigeon());
            put("Porky", new Porky());
            put("Sushi", new Sushi());
            put("Wooly", new Wooly());

            put("Bat", new Bat());
            put("Crow", new Crow());
            put("Crystal_Rat", new Crystal_Rat());
            put("Crystal_Turtle", new Crystal_Turtle());
            put("Polar_Bear", new Polar_Bear());
            put("Twilight_Cat", new Twilight_Cat());
            put("Warrior_Dwarf", new Warrior_Dwarf());
            put("Wind_Rabbit", new Wind_Rabbit());
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
    public void mobDeath(EntityDeathEvent e) throws InvalidMobTypeException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {

        if (e.getEntity().getKiller() == null) return;
        if (!(MythicMobs.inst().getAPIHelper().isMythicMob(e.getEntity()))) return;

        String mm = MythicMobs.inst().getAPIHelper().getMythicMobInstance(e.getEntity()).getType().getInternalName();
        MobDropTable mobDrop = mobDropTableHashMap.get(mm).getClass().getDeclaredConstructor().newInstance();



        e.setDroppedExp(0);
        e.getDrops().clear();

        if (mobDrop == null) return;

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
            int newBal = (int) Math.round(bal * (0.90 - percBal));


            if (newBal < 0) newBal = 0;
            VaultHook.econ.withdrawPlayer(player, bal);
            VaultHook.econ.depositPlayer(player, newBal);
            int goldLost = bal-newBal;
            new BukkitRunnable() {
                @Override
                public void run() {
                    player.spigot().respawn();
                    player.sendTitle(Utils.tacc("&c&lYou Died"), Utils.tacc("&c" + goldLost + " gold &7has been lost"), 1, 60, 1);
                    Scoreboard.updateScoreboard(player);
                }
            }.runTaskLater(Core.plugin(), 1);

        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        Player player = e.getPlayer();
        World world = player.getWorld();
        if (world.getName().equals("Hilly_Woods")) {
            e.setRespawnLocation(world.getSpawnLocation());
            return;
        }
        /*if (player.getWorld() == Core.plugin().getServer().getWorld("Dungeons")) { //Checks if player died in the dungeon world
            World HUB = Core.plugin().getServer().getWorld("Hub");
            assert HUB != null;
            e.setRespawnLocation(HUB.getSpawnLocation());
            return;
        }*/
        if (player.getWorld().equals(Core.plugin().getServer().getWorld("PVP"))) {
            World HUB = Core.plugin().getServer().getWorld("Hub");
            e.setRespawnLocation(new Location(HUB, -52, 91, -8, 168, 0));
        }
    }

    @Override
    public void run() {

    }
}