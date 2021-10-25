package net.siegerpg.siege.core.listeners;

import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.api.exceptions.InvalidMobTypeException;
import io.lumine.xikage.mythicmobs.mobs.ActiveMob;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.utils.cache.GlobalMultipliers;
import net.siegerpg.siege.core.webstore.categories.boosters.WebstoreBoosters;
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
            this.put("Blubber", new Blubber());
            this.put("DeathBull", new DeathBull());
            this.put("Mercenary", new Mercenary());
            this.put("Molter", new Molter());
            this.put("Ogre", new Ogre());
            this.put("Orc", new Orc());
            this.put("RockSpirit", new RockSpirit());
            this.put("Werewolf", new Werewolf());

            this.put("Unicorn", new Unicorn());

            //DUNGEON BOSSES
            this.put("Broodmother", new Broodmother());
            this.put("BullSpirit", new BullSpirit());
            this.put("Davy_Jones", new Davy_Jones());
            this.put("FoxSpirit", new FoxSpirit());
            this.put("Lich", new Lich());
            this.put("MagmaSpirit", new MagmaSpirit());
            this.put("Necromancer", new Necromancer());
            this.put("SlimeSpirit", new SlimeSpirit());

            //HOSTILES
            this.put("AngryBull", new AngryBull());
            this.put("Bandit", new Bandit());
            this.put("BanditArcher", new BanditArcher());
            this.put("Blob", new Blob());
            this.put("BloodSucker", new BloodSucker());
            this.put("Bully", new Bully());
            this.put("FlamingGoo", new FlamingGoo());
            this.put("ForestSpider", new ForestSpider());
            this.put("Goblin", new Goblin());
            this.put("GoldenGoblin", new GoldenGoblin());
            this.put("Goo", new Goo());
            this.put("InfectedDigger", new InfectedDigger());
            this.put("RockRat", new RockRat());
            this.put("ScorchingBlob", new ScorchingBlob());
            this.put("ScrapRat", new ScrapRat());
            this.put("Sea_Warrior", new Sea_Warrior());
            this.put("Skeletal_Archer", new Skeletal_Archer());
            this.put("Skeletal_Warrior", new Skeletal_Warrior());
            this.put("Thief", new Thief());
            this.put("ZombifiedDigger", new ZombifiedDigger());

            this.put("SkeletalGeneral", new SkeletalGeneral());
            this.put("Corrupted_Skeleton", new Corrupted_Skeleton());
            this.put("Dark_Elf", new Dark_Elf());
            this.put("Dark_Fairy", new Dark_Fairy());
            this.put("Digger_Overseer", new Digger_Overseer());
            this.put("Fairy_Outlaw", new Fairy_Outlaw());
            this.put("Freezing_Skeletal_Warrior", new Freezing_Skeletal_Warrior());
            this.put("Greater_Spider", new Greater_Spider());
            this.put("Leaf_Monster", new Leaf_Monster());
            this.put("Moss_Lurker", new Moss_Lurker());
            this.put("Nightmare", new Nightmare());
            this.put("Shroomlight_Monster", new Shroomlight_Monster());
            this.put("Stone_Monster", new Stone_Monster());

            //NEUTRALS
            this.put("GiantHornet", new GiantHornet());
            this.put("WildFox", new WildFox());
            this.put("ChestMimic1", new ChestMimic1());
            this.put("ChestMimic2", new ChestMimic2());
            this.put("ChestMimic3", new ChestMimic3());
            this.put("ChestMimic4", new ChestMimic4());

            this.put("Archer_Elf", new Archer_Elf());
            this.put("Warrior_Elf", new Warrior_Elf());
            this.put("Twilight_Wolf", new Twilight_Wolf());


            //PASSIVES
            this.put("FeatheredMeat", new FeatheredMeat());
            this.put("MooMoo", new MooMoo());
            this.put("Pigeon", new Pigeon());
            this.put("Porky", new Porky());
            this.put("Sushi", new Sushi());
            this.put("Wooly", new Wooly());

            this.put("Bat", new Bat());
            this.put("Crow", new Crow());
            this.put("Crystal_Rat", new Crystal_Rat());
            this.put("Crystal_Turtle", new Crystal_Turtle());
            this.put("Polar_Bear", new Polar_Bear());
            this.put("Twilight_Cat", new Twilight_Cat());
            this.put("Warrior_Dwarf", new Warrior_Dwarf());
            this.put("Wind_Rabbit", new Wind_Rabbit());
        }
    };

    @EventHandler
    public void damageDrops(final EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player)) return;

        final ActiveMob mm = MythicMobs.inst().getAPIHelper().getMythicMobInstance(e.getDamager());
        if (mm == null) return;

        ItemStack reward = null;
        double chance = 0.0;
        if (mm.getType().getInternalName().equals("Goblin")) {
            reward = new GoldenCarrot(100).getUpdatedItem(false);
            chance = 1.0;
        } else if (mm.getType().getInternalName().equals("WildFox")) {
            reward = new GoldenCarrot(50).getUpdatedItem(false);
            chance = 1.0;
        }
        if (reward == null) return;

        if (Utils.randTest(chance)) {
            if (e.getEntity().getLocation().distance(e.getEntity().getWorld().getSpawnLocation()) > 3) {
                e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), reward);
            }
        }
    }

    @EventHandler
    public void mobDeath(final EntityDeathEvent e) throws InvalidMobTypeException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {

        if (e.getEntity().getKiller() == null) return;
        if (!(MythicMobs.inst().getAPIHelper().isMythicMob(e.getEntity()))) return;

        final String mm = MythicMobs.inst().getAPIHelper().getMythicMobInstance(e.getEntity()).getType().getInternalName();
        final MobDropTable mobDrop = this.mobDropTableHashMap.get(mm).getClass().getDeclaredConstructor().newInstance();



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

        final Player player = e.getEntity().getKiller();
        double luck = 0.0;
        int goldCoinAmt = mobDrop.getGold(true);
        int exp = mobDrop.getExp(true);
        final Location loc = e.getEntity().getLocation();

        if (player != null) {luck = CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.LUCK, player.getItemInHand());}

        if (exp > 0 && player != null) {
            exp = (int) Math.floor(exp * GlobalMultipliers.expMultiplier);
            if ((Math.random() * 100) <= luck) {
                exp *= 2;
            }
            GoldEXPSpawning.spawnEXP(exp, loc);
        } //Give exp reward

        if (goldCoinAmt > 0 && player != null) {
            goldCoinAmt = (int) Math.floor(goldCoinAmt * GlobalMultipliers.goldMultiplier);
            if ((Math.random() * 100) <= luck) {
                goldCoinAmt *= 2;
            }
            GoldEXPSpawning.spawnGold(goldCoinAmt, loc);
        }

        for (final ItemStack drop : mobDrop.getRewards(luck)) { //Loop through all drops
            loc.getWorld().dropItemNaturally(loc, drop);
        }
    }

    @EventHandler
    public void removePlayerGold(final PlayerDeathEvent e) {
        e.deathMessage(null);
        final Player player = e.getEntity().getPlayer();
        if (player != null) {
            if (player.getWorld().equals(Core.plugin().getServer().getWorld("SiegeHub"))) return;
            final int bal = (int) Math.round(VaultHook.econ.getBalance(player));

            double percBal = (Math.floor(bal / 10000.0) / 100);
            if (percBal > 0.15) percBal = 0.15;
            int newBal = (int) Math.round(bal * (0.90 - percBal));


            if (newBal < 0) newBal = 0;
            VaultHook.econ.withdrawPlayer(player, bal);
            VaultHook.econ.depositPlayer(player, newBal);
            final int goldLost = bal-newBal;
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
    public void onRespawn(final PlayerRespawnEvent e) {
        final Player player = e.getPlayer();
        final World world = player.getWorld();
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
            final World HUB = Core.plugin().getServer().getWorld("Hub");
            e.setRespawnLocation(new Location(HUB, -52, 91, -8, 168, 0));
        }
    }

    @Override
    public void run() {

    }
}