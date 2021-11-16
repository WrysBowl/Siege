package net.siegerpg.siege.core.crates;

import net.kyori.adventure.text.Component;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.items.types.subtypes.CustomCosmetic;
import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.miscellaneous.particleEffects.Helix;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Set;

public class Animation implements Runnable{
    public void openCrate(Location location, Set<CustomCosmetic> cosmetics, CustomCosmetic cosmetic, Player player) {
        new Helix().createHelix(location, Particle.FALLING_OBSIDIAN_TEAR, 3.0, 0.0, 4.0);
        new Helix().createHelix(location, Particle.FALLING_OBSIDIAN_TEAR, 2.0, 0.0, 4.0);

        new BukkitRunnable() {

            final int ticker = 5;
            final int duration = 100;
            int durationTicks = duration;
            final ArrayList<CustomCosmetic> cosmeticArray = new ArrayList<>(cosmetics);
            Item displayedItem;
            final Location loc =new Location(
                    location.getWorld(),
                    location.getX(),
                    location.getY()+1.5,
                    location.getZ());

            public void run() {

                //exponentially increase delay
                int randomNumber = (int)(Math.random()*cosmeticArray.size());
                ItemStack randomItem = cosmeticArray.get(randomNumber).getUpdatedItem(false);
                if (displayedItem != null) displayedItem.remove();
                displayedItem = loc.getWorld().dropItem(loc, randomItem);
                displayedItem.setGravity(false);
                displayedItem.setPickupDelay(99999);
                displayedItem.setVelocity(new Vector());
                player.playSound(player.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1.0f, 1.0f);
                loc.setY(loc.getY()+0.1);

                durationTicks-=5;

                if (durationTicks <= 0) {
                    displayedItem.remove();
                    displayedItem = location.getWorld().dropItem(loc, cosmetic.getUpdatedItem(false));
                    displayedItem.setGravity(false);
                    displayedItem.setPickupDelay(99999);
                    player.playSound(location, Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1.0f, 1.0f);

                    Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), () -> {
                        Vector vector = Utils.getDifferentialVector(loc, player.getLocation().subtract(0, 4, 0));
                        vector.normalize();
                        displayedItem.setVelocity(vector);

                        player.playSound(location, Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 1.0f, 1.0f);
                        location.getWorld().spawnParticle(Particle.REVERSE_PORTAL.builder().count(75).particle(), loc, 50);


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
                        Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), () -> {
                            displayedItem.remove();
                            ItemStack rewardItem = cosmetic.getUpdatedItem(false);
                            Component miniMessage = Utils.lore("<green>"+player.getName()+"<gray> opened a crate and got a <bold><yellow>" + rewardItem.getItemMeta().getDisplayName()).hoverEvent(rewardItem);
                            Bukkit.getServer().sendMessage(miniMessage);

                            Utils.giveItem(player, cosmetic.getUpdatedItem(false));
                            CrateOpen.currentlyUsedChests.clear();

                        },20);
                    },20);

                    this.cancel();
                }
            }
        }.runTaskTimer(Core.plugin(), 0, 5);
    }

    @Override
    public void run() {

    }
}
