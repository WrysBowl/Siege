package net.siegerpg.siege.core.listeners;

import io.lumine.xikage.mythicmobs.MythicMobs;
import net.siegerpg.siege.core.drops.MobDrops;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.utils.Levels;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Date;

public class DeathListener implements Listener {
    @EventHandler
    public void mobDeath(EntityDeathEvent e) {

        if (!(MythicMobs.inst().getAPIHelper().isMythicMob(e.getEntity()))) { return; }

        String mm = MythicMobs.inst().getAPIHelper().getMythicMobInstance(e.getEntity()).getType().getInternalName();
        MobDrops mobDrop = new MobDrops();
        mobDrop.setMobTable(mm);

        e.setDroppedExp(0);
        e.getDrops().clear();

        if (!mobDrop.isMob_exists()) {return;}

        Player player = e.getEntity().getKiller();
        Double luck = 0.0;
        ItemStack goldCoins = Utils.getGoldCoin();
        goldCoins.setAmount(mobDrop.getGold(true));
        if (player != null) {luck = CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.LUCK);}
        if (mobDrop.getExp(true) > 0 && player != null) { Levels.addExp(player, mobDrop.getExp(true)); } //Give exp reward

        if (goldCoins.getAmount() > 0) { e.getDrops().add(goldCoins); } //Give gold reward
        
        for (ItemStack drop : mobDrop.getRewards(luck)) { //Loop through all drops
            e.getDrops().add(drop);
        }

        for (int i = 0; i<e.getDrops().size(); i++) {
            e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), e.getDrops().get(i));
        }
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {

        Entity victim = event.getEntity();
        EntityDamageEvent.DamageCause damage = null;
        String Victim = "", Killer = "", Cause = "";
        boolean byPlayer = false;
        boolean flipIt = false;

        if (victim.getLastDamageCause() != null) {
            damage = victim.getLastDamageCause().getCause();
        } else {
            return;
        }

        if (victim instanceof Player) {
            Victim = ((Player) victim).getDisplayName();
        } else {
            Victim = victim.getType().getName().toLowerCase().replace("_", " ");
        }

        // Determine the cause of the death
        // ############################################################################
        if (damage.equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK)) {
            // The killer was another entity.
            // Determine the entity
            Entity killer = event.getEntity().getKiller();

            if (killer instanceof Player) {

                byPlayer = true;
                Killer = " from ".concat(event.getEntity().getKiller()
                        .getDisplayName());

                ItemStack item = event.getEntity().getKiller().getItemInHand();

                String theCause = item.getType().toString().toLowerCase();

                if (theCause.equals("air")) {
                    Cause = " attacking with their awesome fist";
                } else {

                    if (theCause.matches("[aeiou].*?")) {
                        Cause = " attacking them with an ".concat(theCause
                                .replace("_", " "));
                    } else {
                        Cause = " attacking them with a ".concat(theCause
                                .replace("_", " "));
                    }
                }

            } else {

                if (victim.getLastDamageCause() instanceof EntityDamageByEntityEvent) {

                    EntityDamageByEntityEvent eEvent = (EntityDamageByEntityEvent) victim
                            .getLastDamageCause();
                    String entityName = eEvent.getDamager().getType().getName()
                            .toLowerCase();

                    if (entityName.matches("[aeiou].*?")) {
                        Killer = " by an ".concat(entityName);
                    } else {
                        Killer = " by a ".concat(entityName);
                    }

                    if (eEvent.getDamager() instanceof Wolf) {
                        Wolf wolf = (Wolf) eEvent.getDamager();
                        if (wolf.getOwner() != null) {
                            Player ply = (Player) wolf.getOwner();
                            Killer = Killer.concat(" owned by ").concat(
                                    ply.getDisplayName());
                        }
                    }

                    Cause = " by being attacked";
                    flipIt = true;

                } else {
                    // unknown
                    Cause = " unknown";
                }
            }
        } else if (damage.equals(EntityDamageEvent.DamageCause.BLOCK_EXPLOSION)) {
            Cause = " from an explosion";
        } else if (damage.equals(EntityDamageEvent.DamageCause.CONTACT)) {
            Cause = " from kissing a cactus";
        } else if (damage.equals(EntityDamageEvent.DamageCause.CUSTOM)) {
            Cause = " from something custom";
        } else if (damage.equals(EntityDamageEvent.DamageCause.DROWNING)
                || damage.equals(EntityDamageEvent.DamageCause.SUFFOCATION)) {
            Cause = " from not taking a breath";
        } else if (damage.equals(EntityDamageEvent.DamageCause.ENTITY_EXPLOSION)) {
            Cause = " by playing with a creeper";
        } else if (damage.equals(EntityDamageEvent.DamageCause.FALL)) {
            Cause = " by bungee jumping without a cord";
        } else if (damage.equals(EntityDamageEvent.DamageCause.FALLING_BLOCK)) {
            Cause = " by being smooshed";
        } else if (damage.equals(EntityDamageEvent.DamageCause.FIRE)
                || damage.equals(EntityDamageEvent.DamageCause.FIRE_TICK)) {
            Cause = " after jumping into a campfire";
        } else if (damage.equals(EntityDamageEvent.DamageCause.LAVA)) {
            Cause = " from swimming in lava";
        } else if (damage.equals(EntityDamageEvent.DamageCause.LIGHTNING)) {
            Cause = " by flying a kite in an electrical storm";
        } else if (damage.equals(EntityDamageEvent.DamageCause.MAGIC)) {
            Cause = " by playing with magic";
        } else if (damage.equals(EntityDamageEvent.DamageCause.MELTING)) {
            Cause = " from thawing.";
        } else if (damage.equals(EntityDamageEvent.DamageCause.POISON)) {
            Cause = " by drinking poison";
        } else if (damage.equals(EntityDamageEvent.DamageCause.PROJECTILE)) {
            Cause = " from being shot";
        } else if (damage.equals(EntityDamageEvent.DamageCause.STARVATION)) {
            Cause = " because they didn't go grocery shopping";
        } else if (damage.equals(EntityDamageEvent.DamageCause.SUICIDE)) {
            Cause = " by taking the easy way out";
        } else if (damage.equals(EntityDamageEvent.DamageCause.VOID)) {
            Cause = " by falling into the abyss";
        } else if (damage.equals(EntityDamageEvent.DamageCause.WITHER)) {
            Cause = " because they danced with the wither";
        }

        String toSend = Victim.concat(" died").concat(Killer).concat(Cause)
                .concat(".");

        if (flipIt) {
            toSend = Victim.concat(" died").concat(Cause).concat(Killer)
                    .concat(".");
        }

        if (!lastMessage.equals(toSend) || byPlayer) {

            long time = (new Date().getTime() - lastTime.getTime()) / 1000;

            if (time > 15 || byPlayer) {
                lastMessage = toSend;
                lastTime = new Date();
                sendToAll(ChatColor.WHITE + toSend);
            }
        }
    }
}
