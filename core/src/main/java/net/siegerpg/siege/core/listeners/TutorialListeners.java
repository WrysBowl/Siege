package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.types.misc.CustomMaterial;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.List;

public class TutorialListeners implements Listener {

    private final World SiegeHub = Core.plugin().getServer().getWorld("SiegeHub");

    @EventHandler
    public void breakRewardableBlocks(final BlockBreakEvent e) {
        if (!e.getBlock().getWorld().equals(this.SiegeHub)) return;
        final List<Material> rewardableBlocks = BlockBreakListener.rewardableBlocks;
        if (rewardableBlocks.contains(e.getBlock().getType())) {
            e.getPlayer().sendActionBar(Utils.lore("<gold><bold>!!!<reset><gray> Landscape can be broken for gold and experience"));
        }
    }
    @EventHandler
    public void pickUpMaterials(final EntityPickupItemEvent e) {
        if (!e.getEntity().getWorld().equals(this.SiegeHub)) return;
        if (CustomItemUtils.INSTANCE.getCustomItem(e.getItem().getItemStack()) instanceof CustomMaterial) {
            e.getEntity().sendActionBar(Utils.lore("<gold><bold>!!!<reset><gray> Materials can be used to craft items from Symone"));
        }
    }
    @EventHandler
    public void killMob(final EntityDeathEvent e) {
        if (!e.getEntity().getWorld().equals(this.SiegeHub)) return;
        final Player player = e.getEntity().getKiller();
        if (player == null) return;
        player.sendActionBar(Utils.lore("<gold><bold>!!!<reset><gray> Mobs drop gold, experience, and materials"));
    }
}
