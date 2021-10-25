package net.siegerpg.siege.core.crates;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.items.types.misc.Cosmetic;
import net.siegerpg.siege.core.items.types.subtypes.CustomCosmetic;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.particleEffects.Helix;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Animation implements Runnable{
    public void openCrate(final Location location, final Set<CustomCosmetic> cosmetics, final CustomCosmetic cosmetic, final Player player) {
        new Helix().createHelix(location, Particle.FALLING_OBSIDIAN_TEAR, 3.0, 0.0, 4.0);
        new Helix().createHelix(location, Particle.FALLING_OBSIDIAN_TEAR, 2.0, 0.0, 4.0);

        new BukkitRunnable() {

            final int ticker = 5;
            final int duration = 100;
            int durationTicks = this.duration;
            final ArrayList<CustomCosmetic> cosmeticArray = new ArrayList<>(cosmetics);
            Item displayedItem;
            final Location loc =new Location(
                    location.getWorld(),
                    location.getX()+0.5,
                    location.getY()+1.5,
                    location.getZ()+0.5);

            public void run() {

                //exponentially increase delay
                final int randomNumber = (int)(Math.random()* this.cosmeticArray.size());
                final ItemStack randomItem = this.cosmeticArray.get(randomNumber).getUpdatedItem(false);
                if (this.displayedItem != null) this.displayedItem.remove();
                this.displayedItem = this.loc.getWorld().dropItem(this.loc, randomItem);
                this.displayedItem.setGravity(false);
                this.displayedItem.setPickupDelay(99999);
                this.displayedItem.setVelocity(new Vector());
                player.playSound(player.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1.0f, 1.0f);
                this.loc.setY(this.loc.getY()+0.1);

                this.durationTicks -=5;

                if (this.durationTicks <= 0) {
                    this.displayedItem.remove();
                    this.displayedItem = location.getWorld().dropItem(this.loc, cosmetic.getUpdatedItem(false));
                    this.displayedItem.setGravity(false);
                    this.displayedItem.setPickupDelay(99999);
                    player.playSound(location, Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1.0f, 1.0f);

                    Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), () -> {
                        final Vector vector = Utils.getDifferentialVector(this.loc, player.getLocation().subtract(0, 4, 0));
                        vector.normalize();
                        this.displayedItem.setVelocity(vector);

                        player.playSound(location, Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 1.0f, 1.0f);
                        location.getWorld().spawnParticle(Particle.REVERSE_PORTAL.builder().count(75).particle(), this.loc, 50);


                        //play rarity win effect
                        switch(cosmetic.getRarity()) {
                            case COMMON:
                                CosmeticCrate.commonWin(this.loc);
                                break;
                            case UNCOMMON:
                                CosmeticCrate.uncommonWin(this.loc);
                                break;
                            case RARE:
                                CosmeticCrate.rareWin(this.loc);
                                break;
                            case EPIC:
                                CosmeticCrate.epicWin(this.loc);
                                break;
                            case LEGENDARY:
                                CosmeticCrate.legendaryWIn(this.loc);
                                break;
                        }

                        //give player item
                        Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), () -> {
                            this.displayedItem.remove();
                            Utils.giveItem(player, cosmetic.getUpdatedItem(false));
                            CrateOpen.currentlyUsedChests.remove(location);

                        },20);
                    },20);

                    cancel();
                }
            }
        }.runTaskTimer(Core.plugin(), 0, 5);
    }

    @Override
    public void run() {

    }
}
