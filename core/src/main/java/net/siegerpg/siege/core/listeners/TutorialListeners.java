package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.types.misc.CustomMaterial;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;

import java.util.List;

public class TutorialListeners implements Listener {

    private final World SiegeHub = Core.plugin().getServer().getWorld("SiegeHub");

    @EventHandler
    public void breakRewardableBlocks(BlockBreakEvent e) {
        if (!e.getBlock().getWorld().equals(SiegeHub)) return;
        List<Material> rewardableBlocks = BlockBreakListener.rewardableBlocks;
        if (rewardableBlocks.contains(e.getBlock().getType())) {
            e.getPlayer().sendActionBar(Utils.lore("<gold><bold>!!!<reset><gray> Landscape can be broken for gold and experience"));
        }
    }
    @EventHandler
    public void pickUpMaterials(EntityPickupItemEvent e) {
        if (!e.getEntity().getWorld().equals(SiegeHub)) return;
        if (CustomItemUtils.INSTANCE.getCustomItem(e.getItem().getItemStack()) instanceof CustomMaterial) {
            e.getEntity().sendActionBar(Utils.lore("<gold><bold>!!!<reset><gray> Materials can be used to craft items from Symone"));
        }
    }
    @EventHandler
    public void killMob(EntityDeathEvent e) {
        if (!e.getEntity().getWorld().equals(SiegeHub)) return;
        Player player = e.getEntity().getKiller();
        if (player == null) return;
        player.sendActionBar(Utils.lore("<gold><bold>!!!<reset><gray> Mobs drop gold, experience, and materials"));
    }
}
