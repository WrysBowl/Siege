package net.siegerpg.siege.core.fishing.events;

import de.tr7zw.nbtapi.NBTItem;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.fishing.FishingTask;
import net.siegerpg.siege.core.fishing.baits.BaitCore;
import net.siegerpg.siege.core.fishing.data.FishingData;
import net.siegerpg.siege.core.fishing.fish.Fish;
import net.siegerpg.siege.core.fishing.fish.FishCore;
import net.siegerpg.siege.core.fishing.fish.implemented.BigBlueTuna;
import net.siegerpg.siege.core.utils.Levels;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class CustomFishEvent {

	
	private ArrayList<ItemStack> rewards = new ArrayList<ItemStack>();
	
	private final Player player;
	private final FishHook hook;
	private final PlayerFishEvent.State state;
	private final FishingData data;
	private int ticksElapsed;
	private int totalTicksElapsed;
	private int secondsElapsed;
	private int totalLength = 70;
	private BossBar progressBar;
	private Location baitLocation;
	private ArmorStand baitModel;


	public CustomFishEvent(final PlayerFishEvent e) {
		player=e.getPlayer();
		hook=e.getHook();
		state=e.getState();
		data = new FishingData();

		final Location loc = e.getHook().getLocation();
		loc.subtract(new Vector(0, 0.3, 0));
		baitLocation=loc;
		final ArmorStand stand = ((ArmorStand)e.getPlayer().getLocation().getWorld().spawnEntity(this.baitLocation, EntityType.ARMOR_STAND));
		stand.setVisible(false);
		stand.setSmall(true);
		stand.setInvulnerable(true);
		stand.setGravity(false);
		stand.teleport(loc);
		this.setBaitModel(stand);


        if(!(this.player.getInventory().getItemInOffHand()== null) && !(this.player.getInventory().getItemInOffHand().getType() == Material.AIR)) {
			final ItemStack offHand = e.getPlayer().getInventory().getItemInOffHand();
        	final NBTItem nbt = new NBTItem(offHand);

        	if (nbt.hasNBTData() && nbt.hasKey("baitType")) {
        		final String baitType = nbt.getString("baitType");
        		if (BaitCore.hasBait(baitType)) {
					stand.getEquipment().setHelmet(new ItemStack(Material.SEA_PICKLE));
					getFishingData().setBait(BaitCore.getBait(baitType));
			        this.player.getItemInHand().setAmount(this.player.getItemInHand().getAmount()-1);
				}
			}
		}

        //Bait is null, unable to pass through params
		final Fish fish = FishCore.chooseRandomFish(data.getBait(), this.player);
		getFishingData().setFish(fish);
	}
	public void trigger() {
		this.data.setFishing(true);
		new FishingTask(this).runTaskTimerAsynchronously(Core.plugin(), 0, 2);
		this.player.playSound(this.player.getLocation(), Sound.ENTITY_FISHING_BOBBER_SPLASH, 2.0f, 2.0f);
	}

	public void win() {
		remove();
		final Fish fish = this.data.getFish();
		this.player.playSound(this.player.getLocation(), Sound.ENTITY_WANDERING_TRADER_YES, 1.0f, 1.0f);
		this.player.getInventory().addItem(FishCore.getItem(fish));
		Levels.INSTANCE.addExpShared(this.player, (int) fish.actualSize);
	}
	public void lose() {
		remove();
		this.player.playSound(this.player.getLocation(), Sound.ENTITY_WANDERING_TRADER_NO, 1.0f, 1.0f);
	}


	public void remove() {
		this.baitModel.remove();
		this.progressBar.removeAll();
		hook.remove();
	}

	public Player getPlayer() {
		return this.player;
	}
	public FishHook getHook() {
		return this.hook;
	}
	public PlayerFishEvent.State getState() {
		return this.state;
	}
	public int getTicksElapsed() {
		return this.ticksElapsed;
	}
	public void setTicksElapsed(final int num) {
		if(num >=0 && num < 21)
			ticksElapsed = num;
	}
	public void setSecondsElapsed(final int num) {
		secondsElapsed=num;
	}
	public int getSecondsElapsed() {
		return secondsElapsed;
	}
	public int getTotalTicksElapsed() {
		return this.totalTicksElapsed;
	}
	public void setTotalTicksElapsed(final int totalTicksElapsed) {
		this.totalTicksElapsed = totalTicksElapsed;
	}
	public FishingData getFishingData() {
		return data;
	}
	public int getTotalLength() {
		return this.totalLength;
	}
	public void setTotalLength(final int totalLength) {
		this.totalLength = totalLength;
	}
	public ArrayList<ItemStack> getRewards() {
		return this.rewards;
	}
	public void setRewards(final ArrayList<ItemStack> rewards) {
		this.rewards = rewards;
	}
	public BossBar getProgressBar() {
		return this.progressBar;
	}
	public void setProgressBar(final BossBar progressBar) {
		this.progressBar = progressBar;
	}
	public ArmorStand getBaitModel() {
		return this.baitModel;
	}
	public void setBaitModel(final ArmorStand baitModel) {
		this.baitModel = baitModel;
	}
	public Location getBaitLocation() {
		return this.baitLocation;
	}
	public void setBaitLocation(final Location baitLocation) {
		this.baitLocation = baitLocation;
	}
	
}
