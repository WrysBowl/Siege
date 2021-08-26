package net.siegerpg.siege.core.listeners.NPC;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.items.statgems.StatGem;
import net.siegerpg.siege.core.items.types.misc.StatGemType;
import net.siegerpg.siege.core.items.types.subtypes.CustomEquipment;
import net.siegerpg.siege.core.utils.Scoreboard;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.VaultHook;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Objects;

public class GemRemover implements Listener {

    ArrayList<Integer> clickable = new ArrayList<Integer>(){
        {
            add(12);
            add(14);
            add(31);
        }
    };

    int cost = 0;
    int chance = 0;
    ItemStack item = null;

    @EventHandler
    public void onRightClickOnEntity(PlayerInteractEvent e) {
        if (e.getClickedBlock() != null && e.getClickedBlock().getType().equals(Material.CHIPPED_ANVIL)) {
            Player player = e.getPlayer();
            ItemStack item = player.getInventory().getItemInMainHand();
            CustomItem customItem = CustomItemUtils.INSTANCE.getCustomItem(item);
            if (customItem != null && ((CustomEquipment) customItem).hasGem()) {
                Inventory shop = getMenu(e.getPlayer());
                player.openInventory(shop);
            }
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void guiClick(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player)) {return;}
        if (e.getWhoClicked().getMetadata("GemRemover").size() > 0 &&
                Objects.equals(e.getWhoClicked().getMetadata("GemRemover").get(0).value(), e.getInventory())) {
            clickMenu(e);
            e.setCancelled(true);
        }
    }

    /**
     * GUI consists of gold increase/decrease buttons, and indicator for how much gold and how that amount
     * impacts the percent of keeping the gem
     *
     * Checks if the item that the player clicked on is a gem
     * Display the gem in the GUI
     */

    private void clickMenu(InventoryClickEvent e) {
        if (!clickable.contains(e.getSlot())) return; //if clicked slot is not contained in the array list
        Player player = (Player) e.getWhoClicked();
        int slot = e.getSlot();

        //if clicked slot is the decrease gold button
        if(slot == 12) {
            if (this.cost < 100) return;
            this.cost -= 100;
            player.openInventory(getMenu(player));
            player.updateInventory();

        }

        //if clicked slot is the increase gold button
        if (slot == 14) {
            double bal = VaultHook.econ.getBalance(player);
            if (bal < 100) {
                player.sendMessage(Utils.tacc("&cYou do not have enough money to increase the chance!"));
                return;
            } else {
                this.cost += 100;
                player.openInventory(getMenu(player));
                player.updateInventory();
            }
        }

        //if player wants to accept the trade
        if (slot == 31) {
            VaultHook.econ.withdrawPlayer(player, this.cost);
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
            Scoreboard.updateScoreboard(player);
            if (Utils.randTest((double) this.chance)) {
                CustomItem customItem = CustomItemUtils.INSTANCE.getCustomItem(this.item);
                if (customItem == null) return;
                if (!(customItem instanceof CustomEquipment)) return;
                if (!((CustomEquipment) customItem).hasGem()) return;
                //How to get the stat gem from the item? Check in the stat gem listener class
                //StatGem(itemOnCursor.statType, itemOnCursor.statAmount
                StatGem gem = new StatGem(((CustomEquipment) customItem).getStatGem().getType(), ((CustomEquipment) customItem).getStatGem().getAmount());
                ((CustomEquipment)customItem).removeStatGem();
                customItem.updateMeta(false);
                player.getInventory().addItem();
                player.sendMessage(Utils.tacc("&aSuccessfully removed gem!"));

            } else {
                player.sendMessage(Utils.tacc("&cThe gem broke upon trying to remove it!"));
                player.getInventory().removeItem(this.item);
            }
            player.closeInventory();
        }
    }

    private int calcChance() {
        if (this.item == null) return 0;
        CustomItem customItem = CustomItemUtils.INSTANCE.getCustomItem(this.item);
        if (customItem == null) return 0;
        if(customItem.getLevelRequirement() == null) return 0;
        int levelReq = customItem.getLevelRequirement();
        return (int)(100*(this.cost/(levelReq*100)));
    }


    private Inventory getMenu(Player player) {
        Inventory gui = Bukkit.createInventory(null, 45, "Gem Remover");

        //Fill in the GUI
        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        for (int i = 0; i < gui.getSize(); i++) {
            gui.setItem(i, filler);
        }
        ItemStack item = player.getInventory().getItemInMainHand();
        CustomItem customItem = CustomItemUtils.INSTANCE.getCustomItem(item);
        if (customItem != null && ((CustomEquipment) customItem).hasGem()) {

            //Store the item stack to be removed (if)
            this.item = item;
            this.chance=calcChance();

            //Initialize gold increase item
            ItemStack goldIncrease = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
            ItemMeta goldIncreaseMeta = goldIncrease.getItemMeta();
            goldIncreaseMeta.displayName(Utils.lore("<green>Add 100"));
            goldIncrease.setItemMeta(goldIncreaseMeta);

            //Initialize gold decrease item
            ItemStack goldDecrease = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            ItemMeta goldDecreaseMeta = goldDecrease.getItemMeta();
            goldDecreaseMeta.displayName(Utils.lore("<red>Remove 100"));
            goldDecrease.setItemMeta(goldDecreaseMeta);

            //String.format("%,d", cost)
            //Initialize gold display item
            ItemStack goldDisplay = new ItemStack(Material.SUNFLOWER);
            ItemMeta goldDisplayMeta = goldDisplay.getItemMeta();
            goldDisplayMeta.displayName(Utils.lore("<yellow>Cost: " + this.cost));
            final int finalChance = this.chance;
            goldDisplayMeta.lore(new ArrayList<>() {
                {
                    add(Utils.lore("<light_blue>Chance of Recovery: " + finalChance));
                    add(Utils.lore("<gold><bold>CLICK TO GET <reset><yellow>(maybe)"));

                }
            });
            goldDisplay.setItemMeta(goldDisplayMeta);

            gui.setItem(12, goldDecrease);
            gui.setItem(13, goldDisplay);
            gui.setItem(14, goldIncrease);
            gui.setItem(31, item);

        }


        player.setMetadata("GemRemover", new FixedMetadataValue(Core.plugin(), gui));
        return gui;
    }
}