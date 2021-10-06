package net.siegerpg.siege.core.crates;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.items.types.misc.Cosmetic;
import net.siegerpg.siege.core.items.types.subtypes.CustomCosmetic;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Animation implements Runnable{
    public void openCrate(Location loc, Set<CustomCosmetic> cosmetics, CustomCosmetic cosmetic, Player player) {
        new BukkitRunnable() {

            int ticker = 10;
            final int duration = 100;
            int durationTicks = duration;
            final ArrayList<CustomCosmetic> cosmeticArray = new ArrayList<>(cosmetics);
            Item displayedItem;

            public void run() {

                //exponentially increase delay
                int randomNumber = (int)(Math.random()*cosmeticArray.size());
                ItemStack randomItem = cosmeticArray.get(randomNumber).getUpdatedItem(false);
                if (displayedItem != null) displayedItem.remove();
                displayedItem = loc.getWorld().dropItem(loc, randomItem);
                displayedItem.setGravity(false);
                displayedItem.setPickupDelay(99999);
                player.playSound(player.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1.0f, 1.0f);

                durationTicks-=5;

                if (durationTicks <= 0) {
                    displayedItem.remove();
                    //play rarity win effect
                    switch(cosmetic.getRarity()) {
                        case COMMON:
                            CosmeticCrate.commonWin(loc);
                            break;
                        case UNCOMMON:
                            CosmeticCrate.uncommonWin(loc);
                            break;
                        case RARE:
                            CosmeticCrate.rareWin(loc);
                            break;
                        case EPIC:
                            CosmeticCrate.epicWin(loc);
                            break;
                        case LEGENDARY:
                            CosmeticCrate.legendaryWIn(loc);
                            break;
                    }

                    //give player item
                    Utils.giveItem(player, cosmetic.getUpdatedItem(false));

                    this.cancel();
                }
            }
        }.runTaskTimer(Core.plugin(), 0, 5);
    }

    @Override
    public void run() {

    }
}
