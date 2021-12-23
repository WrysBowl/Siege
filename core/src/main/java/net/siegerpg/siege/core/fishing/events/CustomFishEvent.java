package net.siegerpg.siege.core.fishing.events;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.fishing.FishingTask;
import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.fishing.catches.FishCore;
import net.siegerpg.siege.core.fishing.data.FishingData;
import net.siegerpg.siege.core.miscellaneous.Levels;
import net.siegerpg.siege.core.miscellaneous.Scoreboard;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerFishEvent.State;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class CustomFishEvent {


	private final Player player;
	private final FishHook hook;
	private final State state;
	private final FishingData data;
	private ArrayList< ItemStack > rewards = new ArrayList< ItemStack >();
	private int ticksElapsed = 0;
	private int totalTicksElapsed = 0;
	private int secondsElapsed = 0;
	private int totalLength = 120;
	private BossBar progressBar;


	public CustomFishEvent(PlayerFishEvent e) {

		this.player = e.getPlayer();
		this.hook = e.getHook();
		this.state = e.getState();
		this.data = new FishingData();

		//Bait is null, unable to pass through params
		Fish fish = FishCore.chooseRandomFish(player);
		this
				.getFishingData()
				.setFish(fish);
	}

	public void trigger() {

		data.setFishing(true);
		new FishingTask(this).runTaskTimerAsynchronously(Core.plugin(), 0, 1);
		player.playSound(player.getLocation(), Sound.ENTITY_FISHING_BOBBER_SPLASH, 2.0f, 2.0f);
	}

	public void win() {

		Fish fish = data.getFish();
		Location loc = hook.getLocation();

		//win rewards should be synchronous with the thread
		new BukkitRunnable() {
			@Override
			public void run() {
				remove();

				//Item displayedItem = DropUtils.Companion.dropItemNaturallyForPlayers(loc, fish.getItem(), List.of(player.getUniqueId()));
				Item displayedItem = loc
						.getWorld()
						.dropItemNaturally(loc, fish.getItem());
				displayedItem.setPickupDelay(99999);

				Vector vector = Utils.getDifferentialVector(
						loc, player
								.getLocation()
								.add(0, 2, 0));
				vector.normalize();
				vector.setX(vector.getX() / 1.2);
				vector.setY(vector.getY() / 1.2);
				vector.setZ(vector.getZ() / 1.2);
				displayedItem.setVelocity(vector);


				//add timer
				new BukkitRunnable() {
					@Override
					public void run() {

						player.playSound(
								player.getLocation(), Sound.ENTITY_WANDERING_TRADER_YES, 1.0f,
								1.0f
						                );
						fish.accomplishment(player);
						displayedItem.remove();
						Utils.giveItem(player, fish.getItem());

						if (fish.actualSize > 0) {
							Levels.INSTANCE.addExpShared(player, (int) (fish.actualSize / 2));
							player.sendActionBar(Utils.parse(
									"<dark_purple>+ " + (int) (fish.actualSize / 2) +
									" <dark_purple>EXP"));
							Bukkit
									.getServer()
									.getScheduler()
									.runTaskLater(Core.plugin(), new Runnable() {
										public void run() {

											Scoreboard.updateScoreboard(player);
										}
									}, 20);
						}
					}
				}.runTaskLater(Core.plugin(), 20);
			}
		}.runTask(Core.plugin());
	}

	public void lose() {

		this.remove();
		player.playSound(player.getLocation(), Sound.ENTITY_WANDERING_TRADER_NO, 1.0f, 1.0f);
	}


	public void remove() {

		progressBar.removeAll();
	}

	public Player getPlayer() {

		return player;
	}

	public FishHook getHook() {

		return hook;
	}

	public State getState() {

		return state;
	}

	public int getTicksElapsed() {

		return ticksElapsed;
	}

	public void setTicksElapsed(int num) {

		if (num >= 0 && num < 21)
			this.ticksElapsed = num;
	}

	public int getSecondsElapsed() {

		return this.secondsElapsed;
	}

	public void setSecondsElapsed(int num) {

		this.secondsElapsed = num;
	}

	public int getTotalTicksElapsed() {

		return totalTicksElapsed;
	}

	public void setTotalTicksElapsed(int totalTicksElapsed) {

		this.totalTicksElapsed = totalTicksElapsed;
	}

	public FishingData getFishingData() {

		return this.data;
	}

	public int getTotalLength() {

		return totalLength;
	}

	public void setTotalLength(int totalLength) {

		this.totalLength = totalLength;
	}

	public ArrayList< ItemStack > getRewards() {

		return rewards;
	}

	public void setRewards(ArrayList< ItemStack > rewards) {

		this.rewards = rewards;
	}

	public BossBar getProgressBar() {

		return progressBar;
	}

	public void setProgressBar(BossBar progressBar) {

		this.progressBar = progressBar;
	}

}
