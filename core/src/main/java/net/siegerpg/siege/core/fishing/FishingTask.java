package net.siegerpg.siege.core.fishing;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.utils.cache.playerData;
import net.siegerpg.siege.core.fishing.data.Cursor;
import net.siegerpg.siege.core.fishing.data.FishingData;
import net.siegerpg.siege.core.fishing.events.CustomFishEvent;
import net.siegerpg.siege.core.fishing.fish.FishCore;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class FishingTask extends BukkitRunnable {

	public static HashMap<UUID, FishingTask> runningTasks = new HashMap<UUID, FishingTask>();
	
	private CustomFishEvent e;
	private NamespacedKey keyProgress;
	



	public FishingTask(CustomFishEvent e) {
		this.e=e;
		
		//setting the score to a fourth
		e.getFishingData().setScore((double)e.getFishingData().getFish().getLevel().winScore/3);
		
		keyProgress = new NamespacedKey(Core.plugin(), "ProgressBar-" + e.getPlayer().getName());
		runningTasks.put(e.getPlayer().getUniqueId(), this);
	}
	

	
	
	@Override
	public void run() {
		FishCore fishCore = e.getFishingData().getFish();
		FishingData data = e.getFishingData();
		Cursor cursor = data.getCursor();
		//keeping up with score ;D
        if(data.getScore() >= fishCore.getLevel().winScore) {
        	e.win();
        	runningTasks.remove(e.getPlayer().getUniqueId());
        	this.cancel();
			playerData.hasActionBar.put(e.getPlayer(), false);
        }

        if(Utils.randTest(fishCore.getLevel().chanceToChangeDirection))
        	e.getFishingData().setDirection(!e.getFishingData().getDirection());
        
        e.getBaitModel().teleport(e.getBaitLocation());
        e.setBaitLocation(e.getHook().getLocation().subtract(0, 1.3, 0));
        

        if(data.getScore() <= 0) {
        	e.loose();
        	runningTasks.remove(e.getPlayer().getUniqueId());
        	this.cancel();
			playerData.hasActionBar.put(e.getPlayer(), false);
        }
		//label of the action bar
		String label="";
		
		data.setProcessToAdvance(data.getProcessToAdvance() + fishCore.getLevel().moveSpeed);
		
		//BossBar for progress
		if(Bukkit.getBossBar(keyProgress) == null ||  e.getProgressBar() == null)
		{
			BossBar bossbar = Bukkit.createBossBar(keyProgress,
					ChatColor.GREEN + "That close to catching the fish",
					BarColor.GREEN,
					BarStyle.SOLID,
					BarFlag.CREATE_FOG);
			bossbar.setProgress(data.getScore()/ fishCore.getLevel().winScore);
			bossbar.setVisible(true);
			bossbar.addPlayer(e.getPlayer());
			e.setProgressBar(bossbar);
		}
		BossBar progressBar = e.getProgressBar();
		if(data.getScore()/ fishCore.getLevel().winScore <=1 && data.getScore()/ fishCore.getLevel().winScore <=0)
			progressBar.setProgress(data.getScore()/ fishCore.getLevel().winScore);
		
		
		
		
		for(int i=0; i<e.getTotalLength(); i++) {
			boolean skip = false;
            for(int _i = Math.min(data.getLoc(), data.getLoc()+ fishCore.getLevel().length-1); _i <= (data.getLoc()+ fishCore.getLevel().length-1); _i++) {
                if(i== _i) {
                	
                    if(cursor.loc == i)
                    {
                        label = label+ChatColor.BLUE + "\u25AE";
                        
                        data.setScore(data.getScore()+0.1);

                        skip=true;
                        break;
                    }
                    else
                    {
                        label = label+ChatColor.GREEN + "\u25AE";
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
                label = label+ChatColor.DARK_BLUE + "\u25AE";
                
                data.setScore(data.getScore()-0.1);

			}
            else
				label = label + ChatColor.RED + "\u25AE";
        }
		if(data.getProcessToAdvance()>=1) {
			if(data.getLoc() + fishCore.getLevel().length == e.getTotalLength() && data.getDirection()){ data.setDirection(!data.getDirection());}
			if(data.getLoc()<=0 && !data.getDirection()) { data.setDirection(!data.getDirection());}
			if(data.getDirection()) { data.setLoc(data.getLoc()+1); }
			if(!data.getDirection()) {data.setLoc(data.getLoc()-1);}
			data.setProcessToAdvance(0); 
		}
		
		e.setTicksElapsed(e.getTicksElapsed()+2);
		e.setTotalTicksElapsed(e.getTotalTicksElapsed() + 2);
		if(e.getTicksElapsed() >= 20)
		{
			e.setTicksElapsed(0);
			e.setSecondsElapsed(e.getSecondsElapsed()+1);
		}
		e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(label));
		playerData.hasActionBar.put(e.getPlayer(), true);
	}
	
	public CustomFishEvent getEvent() {
		return this.e;
	}
	
	
	public NamespacedKey getKeyProgress() {
		return keyProgress;
	}




	public void setKeyProgress(NamespacedKey keyProgress) {
		this.keyProgress = keyProgress;
	}



}
