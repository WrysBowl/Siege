package net.siegerpg.siege.core.fishing;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.fishing.fish.Fish;
import net.siegerpg.siege.core.utils.cache.PlayerData;
import net.siegerpg.siege.core.fishing.data.Cursor;
import net.siegerpg.siege.core.fishing.data.FishingData;
import net.siegerpg.siege.core.fishing.events.CustomFishEvent;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class FishingTask extends BukkitRunnable {

	public static HashMap<UUID, FishingTask> runningTasks = new HashMap<UUID, FishingTask>();
	
	private final CustomFishEvent e;
	private NamespacedKey keyProgress;
	private final int delay = 1;
	private int currentWait;
	public int direction = 1; //-1 for left, 1 for right



	public FishingTask(final CustomFishEvent e) {
		this.e=e;
		
		//setting the score to a fourth
		e.getFishingData().setScore(e.getFishingData().getFish().winScore /3);

		this.keyProgress = new NamespacedKey(Core.plugin(), "ProgressBar-" + e.getPlayer().getName());
		FishingTask.runningTasks.put(e.getPlayer().getUniqueId(), this);
	}
	

	
	
	@Override
	public void run() {
		final Fish fish = this.e.getFishingData().getFish();
		final FishingData data = this.e.getFishingData();
		final Cursor cursor = data.getCursor();
		//keeping up with score ;D
        if(data.getScore() >= fish.winScore) {
	        this.e.win();
	        FishingTask.runningTasks.remove(this.e.getPlayer().getUniqueId());
        	cancel();
			PlayerData.hasActionBar.put(this.e.getPlayer(), false);
        }

        if(Utils.randTest(fish.chanceToChangeDirection))
	        this.e.getFishingData().setDirection(!this.e.getFishingData().getDirection());

		this.e.getBaitModel().teleport(this.e.getBaitLocation());
		this.e.setBaitLocation(this.e.getHook().getLocation().subtract(0, 1.3, 0));
        

        if(data.getScore() <= 0) {
	        this.e.lose();
	        FishingTask.runningTasks.remove(this.e.getPlayer().getUniqueId());
        	cancel();
			PlayerData.hasActionBar.put(this.e.getPlayer(), false);
        }
		//label of the action bar
		String label="";
		
		data.setProcessToAdvance(data.getProcessToAdvance() + fish.moveSpeed);
		
		//BossBar for progress
		final double progress = data.getScore() / fish.winScore;
		if(Bukkit.getBossBar(this.keyProgress) == null || this.e.getProgressBar() == null)
		{
			final BossBar bossbar = Bukkit.createBossBar(this.keyProgress,
					Utils.tacc("&a&lStay in the Green!"),
					BarColor.GREEN,
					BarStyle.SOLID,
					BarFlag.CREATE_FOG);
			bossbar.setProgress(progress);
			bossbar.setVisible(true);
			bossbar.addPlayer(this.e.getPlayer());
			this.e.setProgressBar(bossbar);

		}
		final BossBar progressBar = this.e.getProgressBar();
		if(progress <=1 && progress >=0) {
			progressBar.setProgress(progress);
			if (currentWait < delay) {
				currentWait++;
			} else {
				currentWait = 0;
				if (data.getCursor().getLoc() > 0 && data.getCursor().getLoc() < this.getEvent().getTotalLength()) {
					//location of cursor is less than the length of the action bar
					//location of cursor is greater than the beginning of the action bar
					data.getCursor().setLoc(data.getCursor().getLoc()+ direction);
				} else if(direction == -1) {
					data.getCursor().setLoc(this.getEvent().getTotalLength()-1);
				} else if(direction == 1) {
					data.getCursor().setLoc(1);
				}
			}
		}
		
		
		
		
		for(int i = 0; i< this.e.getTotalLength(); i++) {
			boolean skip = false;
            for(int _i = Math.min(data.getLoc(), data.getLoc()+ fish.length-1); _i <= (data.getLoc()+ fish.length-1); _i++) {
                if(i== _i) {
                	
                    if(cursor.loc == i)
                    {
                        label = label+ChatColor.BLUE + Utils.tacc("&l\u25AA");
                        
                        data.setScore(data.getScore()+0.1);

                        skip=true;
                        break;
                    }
                    else
                    {
                        label = label+ChatColor.GREEN + Utils.tacc("&l\u25AA");
                        skip=true;
                        break;
                    }
                }
            }
            if(skip) {
				continue;
			}
            if(cursor.loc == i)
            {
                label = label+ChatColor.BLUE + Utils.tacc("&l\u25AA");
                
                data.setScore(data.getScore()-0.1);
	            this.e.getPlayer().playSound(this.e.getPlayer().getLocation(), Sound.ENTITY_FISH_SWIM, 2.0f, 2.0f);

			}
            else
				label = label + ChatColor.RED + Utils.tacc("&l\u25AA");
        }
		if(data.getProcessToAdvance()>=1) {
			if(data.getLoc() + fish.length == this.e.getTotalLength() && data.getDirection()){ data.setDirection(!data.getDirection());}
			if(data.getLoc()<=0 && !data.getDirection()) { data.setDirection(!data.getDirection());}
			if(data.getDirection()) { data.setLoc(data.getLoc()+1); }
			if(!data.getDirection()) {data.setLoc(data.getLoc()-1);}
			data.setProcessToAdvance(0); 
		}

		this.e.setTicksElapsed(this.e.getTicksElapsed()+2);
		this.e.setTotalTicksElapsed(this.e.getTotalTicksElapsed() + 2);
		if(this.e.getTicksElapsed() >= 20)
		{
			this.e.setTicksElapsed(0);
			this.e.setSecondsElapsed(this.e.getSecondsElapsed()+1);
		}
		this.e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(label));
		PlayerData.hasActionBar.put(this.e.getPlayer(), true);
	}
	
	public CustomFishEvent getEvent() {
		return e;
	}
	
	
	public NamespacedKey getKeyProgress() {
		return this.keyProgress;
	}




	public void setKeyProgress(final NamespacedKey keyProgress) {
		this.keyProgress = keyProgress;
	}



}
