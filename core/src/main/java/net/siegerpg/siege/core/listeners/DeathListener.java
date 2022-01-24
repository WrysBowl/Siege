package net.siegerpg.siege.core.listeners;

import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.api.exceptions.InvalidMobTypeException;
import io.lumine.xikage.mythicmobs.mobs.ActiveMob;
import net.kyori.adventure.text.Component;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.mobs.hillyWoods.bosses.*;
import net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile.*;
import net.siegerpg.siege.core.drops.mobs.hillyWoods.neutral.*;
import net.siegerpg.siege.core.drops.mobs.hillyWoods.passive.*;
import net.siegerpg.siege.core.drops.mobs.twilight.bosses.Unicorn;
import net.siegerpg.siege.core.drops.mobs.twilight.hostile.*;
import net.siegerpg.siege.core.drops.mobs.twilight.neutral.*;
import net.siegerpg.siege.core.drops.mobs.twilight.passive.*;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.items.implemented.misc.food.GoldenCarrot;
import net.siegerpg.siege.core.miscellaneous.GoldEXPSpawning;
import net.siegerpg.siege.core.miscellaneous.Scoreboard;
import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.miscellaneous.VaultHook;
import net.siegerpg.siege.core.miscellaneous.cache.GlobalMultipliers;
import net.siegerpg.siege.core.miscellaneous.cache.PlayerData;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class DeathListener implements Listener, Runnable {

	public static HashMap< String, MobDropTable > mobDropTableHashMap = new HashMap<>() {
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

		ActiveMob mm = MythicMobs
				.inst()
				.getAPIHelper()
				.getMythicMobInstance(e.getDamager());
		if (mm == null) return;

		ItemStack reward = null;
		double chance = 0.0;
		if (mm
				.getType()
				.getInternalName()
				.equals("Goblin")) {
			reward = new GoldenCarrot(100).getUpdatedItem(false);
			chance = 1.0;
		} else if (mm
				.getType()
				.getInternalName()
				.equals("WildFox")) {
			reward = new GoldenCarrot(50).getUpdatedItem(false);
			chance = 1.0;
		}
		if (reward == null) return;

		if (Utils.randTest(chance)) {
			if (e
					    .getEntity()
					    .getLocation()
					    .distance(e
							              .getEntity()
							              .getWorld()
							              .getSpawnLocation()) > 3) {
				e
						.getEntity()
						.getWorld()
						.dropItemNaturally(e
								                   .getEntity()
								                   .getLocation(), reward);
			}
		}
	}

	@EventHandler
	public void mobDeath(EntityDeathEvent e) throws InvalidMobTypeException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {

		if (e.getEntity().getKiller() == null) return;
		if (!(MythicMobs.inst().getAPIHelper().isMythicMob(e.getEntity()))) return;

		e.setDroppedExp(0);
		e.getDrops().clear();

		String mm = MythicMobs
				.inst()
				.getAPIHelper()
				.getMythicMobInstance(e.getEntity())
				.getType()
				.getInternalName();
		if (!(mobDropTableHashMap.containsKey(mm))) return;
		MobDropTable mobDrop = mobDropTableHashMap
				.get(mm)
				.getClass()
				.getDeclaredConstructor()
				.newInstance();

		Player player = e.getEntity().getKiller();
		double luck = 0.0;
		int goldCoinAmt = mobDrop.getGold(true);
		int exp = mobDrop.getExp(true);
		Location loc = e.getEntity().getLocation();

		loc.getWorld().spawnParticle(Particle.SOUL.builder().particle(), loc.add(0,1,0), 5);

		if (player != null) {
			luck = CustomItemUtils.INSTANCE.getPlayerStat(
					player, StatTypes.LUCK, player.getItemInHand());
			if (luck < 0) luck = 0;

		}

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
		} //give gold reward

		for (ItemStack drop : mobDrop.calculateRewards(luck)) { //Loop through all drops
			loc.getWorld().dropItemNaturally(loc, drop);
			if (player == null) continue;
			CustomItem customItem = CustomItemUtils.INSTANCE.getCustomItem(drop);
			if (customItem == null) continue;
			if (customItem.getQuality() < 85) continue;

			//broadcast 80%+ drops
			String displayName = MythicMobs.inst().getAPIHelper().getMythicMobInstance(e.getEntity()).getDisplayName();
			if (displayName == null) continue;
			Component miniMessage = Utils.lore(
					"<color:#5DD5B5>"+player.getName()+
					"<color:#ACD55D> has found a " + drop.getItemMeta().getDisplayName() +
					" <color:#ACD55D>from a "+displayName).hoverEvent(drop);
			Bukkit.broadcast(miniMessage);
		}
	}

	@EventHandler
	public void removePlayerGold(PlayerDeathEvent e) {

		e.setDeathSound(Sound.ENTITY_PLAYER_DEATH);

		//set last death
		EntityDamageEvent event = e.getEntity().getLastDamageCause();
		if (event != null) {
			Entity entity = event.getEntity();
			try {
				String mm = MythicMobs
						.inst()
						.getAPIHelper()
						.getMythicMobInstance(entity)
						.getDisplayName();
				entity.setCustomName(mm);
				e.getEntity().setLastDamageCause(new EntityDamageEvent(entity, event.getCause(), event.getDamage()));
			} catch (Exception ignored) {
			}
		}
		//set death message
		Player player = e.getEntity().getPlayer();
		String deathMessage = Utils.tacc("&c" + e.getDeathMessage());
		e.setDeathMessage(deathMessage);

		if (player == null) return;

		//display last death time
		Player killer = player.getKiller();
		String time = Utils.secondsToHHMMSS(e.getEntity().getStatistic(Statistic.TIME_SINCE_DEATH) / 20);
		player.sendMessage("");
		player.sendMessage(Utils.lore("<gray>Time Since Last Death: <yellow>" + time));

		//remove money from player's balance
		int bal = (int) Math.round(VaultHook.econ.getBalance(player));
		int newBal = (int) Math.round(bal * 0.95);
		if (newBal < 1) newBal = 0;
		VaultHook.econ.withdrawPlayer(player, bal);
		VaultHook.econ.depositPlayer(player, newBal);
		int goldLost = bal - newBal;

		//give killer gold
		if (killer != null) {
			GoldExpListener.giveGold(killer, goldLost);
		}

		new BukkitRunnable() {
			@Override
			public void run() {

				player
						.spigot()
						.respawn();
				player.sendTitle(
						Utils.tacc("&c&lYou Died"), Utils.tacc(
								"&c" + String.format("%,d", goldLost) +
								" gold &7has been lost"), 1, 60, 1);
				Scoreboard.updateScoreboard(player);
			}
		}.runTaskLater(Core.plugin(), 1);

	}

	@EventHandler
	public void onRespawn(PlayerRespawnEvent e) {

		Player player = e.getPlayer();
		World world = player.getWorld();
		if (world
				.getName()
				.equals("Hilly_Woods")) {
			e.setRespawnLocation((player.getBedSpawnLocation() == null) ?
			                     world.getSpawnLocation() : player.getBedSpawnLocation());
		}

		final Location deathLocation = PlayerData.playerDeathLocations.get(player);
		if (deathLocation == null) return;
		int locationCostComputation = (int) player.getLocation().distance(deathLocation)*2;
		int deathTeleportCost = (player.hasPermission("siege.mera.0")) ? 0 : locationCostComputation;

		player.sendMessage("");
		player.sendMessage(Utils.parse("<color:#E94545><underlined>   Teleport Back?   <reset>"));
		player.sendMessage(Utils.parse(" <color:#E94545><click:run_command:/meraChat>Click</click> to teleport back for <yellow> "+deathTeleportCost+" \u26C1"));
		player.sendMessage("");
	}

	@Override
	public void run() {

	}

}