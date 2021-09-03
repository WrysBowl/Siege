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
import org.bukkit.event.player.PlayerFishEvent.State;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class CustomFishEvent {

	
	private ArrayList<ItemStack> rewards = new ArrayList<ItemStack>();
	
	private final Player player;
	private final FishHook hook;
	private final State state;
	private final FishingData data;
	private int ticksElapsed =0;
	private int totalTicksElapsed =0;
	private int secondsElapsed = 0;
	private int totalLength = 70;
	private BossBar progressBar;
	private Location baitLocation;
	private ArmorStand baitModel;
	
	
	public CustomFishEvent(PlayerFishEvent e) {
		this.player=e.getPlayer();
		this.hook=e.getHook();
		this.state=e.getState();
		this.data = new FishingData();
		
		Location loc = e.getHook().getLocation();	
		loc.subtract(new Vector(0, 0.3, 0));
		this.baitLocation=loc;
		ArmorStand stand = ((ArmorStand)e.getPlayer().getLocation().getWorld().spawnEntity(baitLocation, EntityType.ARMOR_STAND));
		stand.setVisible(false);
		stand.setSmall(true);
		stand.setInvulnerable(true);
		stand.setGravity(false);
		stand.teleport(loc);
        setBaitModel(stand);


        if(!(player.getInventory().getItemInOffHand()== null) && !(player.getInventory().getItemInOffHand().getType() == Material.AIR)) {
			ItemStack offHand = e.getPlayer().getInventory().getItemInOffHand();
        	NBTItem nbt = new NBTItem(offHand);

        	if (nbt.hasNBTData() && nbt.hasKey("baitType")) {
        		String baitType = nbt.getString("baitType");
        		if (BaitCore.hasBait(baitType)) {
					stand.getEquipment().setHelmet(new ItemStack(Material.SEA_PICKLE));
					this.getFishingData().setBait(BaitCore.getBait(baitType));
					player.getItemInHand().setAmount(player.getItemInHand().getAmount()-1);
				}
			}
		}

        //Bait is null, unable to pass through params
		Fish fish = FishCore.chooseRandomFish(this.data.getBait(), player);
		this.getFishingData().setFish(fish);
	}
	public void trigger() {
		data.setFishing(true);
		new FishingTask(this).runTaskTimerAsynchronously(Core.plugin(), 0, 2);
		player.playSound(player.getLocation(), Sound.ENTITY_FISHING_BOBBER_SPLASH, 2.0f, 2.0f);
	}
	
	public void win() {
		this.remove();
		Fish fish = data.getFish();
		player.playSound(player.getLocation(), Sound.ENTITY_WANDERING_TRADER_YES, 1.0f, 1.0f);
		player.getInventory().addItem(FishCore.getItem(fish));
		Levels.INSTANCE.addExp(player, (int) fish.actualSize);
	}
	public void lose() {
		this.remove();
		player.playSound(player.getLocation(), Sound.ENTITY_WANDERING_TRADER_NO, 1.0f, 1.0f);
	}
	
	
	public void remove() {
		baitModel.remove();
		progressBar.removeAll();
		this.hook.remove();
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
		if(num >=0 && num < 21)
			this.ticksElapsed = num;
	}
	public void setSecondsElapsed(int num) {
		this.secondsElapsed=num;
	}
	public int getSecondsElapsed() {
		return this.secondsElapsed;
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
	public ArrayList<ItemStack> getRewards() {
		return rewards;
	}
	public void setRewards(ArrayList<ItemStack> rewards) {
		this.rewards = rewards;
	}
	public BossBar getProgressBar() {
		return progressBar;
	}
	public void setProgressBar(BossBar progressBar) {
		this.progressBar = progressBar;
	}
	public ArmorStand getBaitModel() {
		return baitModel;
	}
	public void setBaitModel(ArmorStand baitModel) {
		this.baitModel = baitModel;
	}
	public Location getBaitLocation() {
		return baitLocation;
	}
	public void setBaitLocation(Location baitLocation) {
		this.baitLocation = baitLocation;
	}
	
}
