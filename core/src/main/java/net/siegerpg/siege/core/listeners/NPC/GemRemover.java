package net.siegerpg.siege.core.listeners.NPC;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.*;
import net.siegerpg.siege.core.items.statgems.StatGem;
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

import java.util.ArrayList;
import java.util.Objects;

public class GemRemover implements Listener {

    ArrayList<Integer> clickable = new ArrayList<Integer>(){
        {
            this.add(12);
            this.add(14);
            this.add(31);
        }
    };

    int cost;
    double chance;
    ItemStack item;

    @EventHandler
    public void onRightClickOnEntity(final PlayerInteractEvent e) {
        if (e.getClickedBlock() != null && e.getClickedBlock().getType().equals(Material.CHIPPED_ANVIL)) {
            final Player player = e.getPlayer();
            final ItemStack item = player.getInventory().getItemInMainHand();
            final CustomItem customItem = CustomItemUtils.INSTANCE.getCustomItem(item);
            if (customItem instanceof CustomEquipment) {
                if (((CustomEquipment) customItem).hasGem()) {
                    final Inventory shop = new GemRemover().getMenu(e.getPlayer());
                    player.openInventory(shop);
                }
            }
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void guiClick(final InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player)) {return;}
        if (e.getWhoClicked().getMetadata("GemRemover").size() > 0 &&
                Objects.equals(e.getWhoClicked().getMetadata("GemRemover").get(0).value(), e.getInventory())) {
            this.clickMenu(e);
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

    private void clickMenu(final InventoryClickEvent e) {
        if (!this.clickable.contains(e.getSlot())) return; //if clicked slot is not contained in the array list
        final Player player = (Player) e.getWhoClicked();
        final int slot = e.getSlot();

        //if clicked slot is the decrease gold button
        if(slot == 12) {
            if (cost < 100) return;
            cost -= 100;
            player.openInventory(this.getMenu(player));
            player.updateInventory();

        }

        //if clicked slot is the increase gold button
        if (slot == 14) {
            final double bal = VaultHook.econ.getBalance(player);
            if (bal < 100) {
                player.sendMessage(Utils.tacc("&cYou do not have enough money to increase the chance!"));
                return;
            } else {
                cost += 100;
                player.openInventory(this.getMenu(player));
                player.updateInventory();
            }
        }

        //if player wants to accept the trade
        if (slot == 31) {
            if (item == null || item.getType().isAir()) return;
            final CustomItem customItem = CustomItemUtils.INSTANCE.getCustomItem(item);
            if (customItem == null) return;
            if (!(customItem instanceof CustomEquipment)) return;
            if (!((CustomEquipment) customItem).hasGem()) return;
            if (Utils.randTest(chance)) {
                //How to get the stat gem from the item? Check in the stat gem listener class
                //StatGem(itemOnCursor.statType, itemOnCursor.statAmount
                final StatGem gem = new StatGem(((CustomEquipment) customItem).getStatGem().getType(), ((CustomEquipment) customItem).getStatGem().getAmount());
                ItemStack item = new ItemStack(Material.AIR);
                switch(gem.getType()) {
                    case HEALTH:
                        if (gem.getAmount() == 8.0) {
                            item = new RawHealthGem(0).getUpdatedItem(false);
                        } else if (gem.getAmount() == 10.0) {
                            item = new CrackedHealthGem(0).getUpdatedItem(false);
                        } else if (gem.getAmount() == 12.0) {
                            item = new FlawedHealthGem(0).getUpdatedItem(false);
                        } else if (gem.getAmount() == 15.0) {
                            item = new SimpleHealthGem(0).getUpdatedItem(false);
                        } else if (gem.getAmount() == 18.0) {
                            item = new PolishedHealthGem(0).getUpdatedItem(false);
                        } else if (gem.getAmount() == 22.0) {
                            item = new PristineHealthGem(0).getUpdatedItem(false);
                        }
                        break;
                    case STRENGTH:
                        if (gem.getAmount() == 4.0) {
                            item = new RawStrengthGem(0).getUpdatedItem(false);
                        } else if (gem.getAmount() == 6.0) {
                            item = new CrackedStrengthGem(0).getUpdatedItem(false);
                        } else if (gem.getAmount() == 8.0) {
                            item = new FlawedStrengthGem(0).getUpdatedItem(false);
                        } else if (gem.getAmount() == 11.0) {
                            item = new SimpleStrengthGem(0).getUpdatedItem(false);
                        } else if (gem.getAmount() == 14.0) {
                            item = new PolishedStrengthGem(0).getUpdatedItem(false);
                        } else if (gem.getAmount() == 18.0) {
                            item = new PristineStrengthGem(0).getUpdatedItem(false);
                        }
                        break;
                    case LUCK:
                        if (gem.getAmount() == 4.0) {
                            item = new RawLuckGem(0).getUpdatedItem(false);
                        } else if (gem.getAmount() == 6.0) {
                            item = new CrackedLuckGem(0).getUpdatedItem(false);
                        } else if (gem.getAmount() == 8.0) {
                            item = new FlawedLuckGem(0).getUpdatedItem(false);
                        } else if (gem.getAmount() == 11.0) {
                            item = new SimpleLuckGem(0).getUpdatedItem(false);
                        } else if (gem.getAmount() == 14.0) {
                            item = new PolishedLuckGem(0).getUpdatedItem(false);
                        } else if (gem.getAmount() == 18.0) {
                            item = new PristineLuckGem(0).getUpdatedItem(false);
                        }
                        break;
                    case TOUGHNESS:
                        if (gem.getAmount() == 10.0) {
                            item = new RawToughGem(0).getUpdatedItem(false);
                        } else if (gem.getAmount() == 15.0) {
                            item = new CrackedToughGem(0).getUpdatedItem(false);
                        } else if (gem.getAmount() == 20.0) {
                            item = new FlawedToughGem(0).getUpdatedItem(false);
                        } else if (gem.getAmount() == 30.0) {
                            item = new SimpleToughGem(0).getUpdatedItem(false);
                        } else if (gem.getAmount() == 40.0) {
                            item = new PolishedToughGem(0).getUpdatedItem(false);
                        } else if (gem.getAmount() == 50.0) {
                            item = new PristineToughGem(0).getUpdatedItem(false);
                        }
                        break;
                    case REGENERATION:
                        if (gem.getAmount() == 4.0) {
                            item = new RawRegenerationGem(0).getUpdatedItem(false);
                        } else if (gem.getAmount() == 6.0) {
                            item = new CrackedRegenerationGem(0).getUpdatedItem(false);
                        } else if (gem.getAmount() == 8.0) {
                            item = new FlawedRegenerationGem(0).getUpdatedItem(false);
                        } else if (gem.getAmount() == 11.0) {
                            item = new SimpleRegenerationGem(0).getUpdatedItem(false);
                        } else if (gem.getAmount() == 14.0) {
                            item = new PolishedRegenerationGem(0).getUpdatedItem(false);
                        } else if (gem.getAmount() == 18.0) {
                            item = new PristineRegenerationGem(0).getUpdatedItem(false);
                        }
                }

                player.getInventory().addItem(item);
                player.sendMessage(Utils.tacc("&aSuccessfully removed gem!"));
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);

            } else {
                player.sendMessage(Utils.tacc("&cThe gem broke upon trying to remove it!"));
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_BREAK, 1.0f, 1.0f);
            }
            player.closeInventory();
            VaultHook.econ.withdrawPlayer(player, cost); //takes the cost they put in from the player
            Scoreboard.updateScoreboard(player);
            final CustomEquipment equipmentItem = (CustomEquipment) customItem;
            equipmentItem.removeStatGem(); //removes stat gem
            equipmentItem.updateMeta(false);
            player.getInventory().addItem(equipmentItem.getItem());
            player.getInventory().remove(item);
            cost=0;
            item=null;
        }
    }

    private double calcChance() {
        if (item == null) return 0;
        final CustomItem customItem = CustomItemUtils.INSTANCE.getCustomItem(item);
        if (customItem == null) return 0;
        if(customItem.getLevelRequirement() == null) return 0;
        final int levelReq = customItem.getLevelRequirement();
        final double calculatedChance = Utils.round(30.0 + (cost/((double)(levelReq*5))), 2);
        if (calculatedChance > 100) return 100;
        else return calculatedChance;
    }


    private Inventory getMenu(final Player player) {
        final Inventory gui = Bukkit.createInventory(null, 45, "Gem Remover");

        //Fill in the GUI
        final ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        for (int i = 0; i < gui.getSize(); i++) {
            gui.setItem(i, filler);
        }
        final ItemStack item = player.getInventory().getItemInMainHand();
        final CustomItem customItem = CustomItemUtils.INSTANCE.getCustomItem(item);
        if (customItem instanceof CustomEquipment) {
            if (((CustomEquipment) customItem).hasGem()) {
                //Store the item stack to be removed (if)
                this.item = item;
                chance= this.calcChance();

                //Initialize gold increase item
                final ItemStack goldIncrease = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
                final ItemMeta goldIncreaseMeta = goldIncrease.getItemMeta();
                goldIncreaseMeta.displayName(Utils.lore("<green>Add 100"));
                goldIncrease.setItemMeta(goldIncreaseMeta);

                //Initialize gold decrease item
                final ItemStack goldDecrease = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                final ItemMeta goldDecreaseMeta = goldDecrease.getItemMeta();
                goldDecreaseMeta.displayName(Utils.lore("<red>Remove 100"));
                goldDecrease.setItemMeta(goldDecreaseMeta);

                //String.format("%,d", cost)
                //Initialize gold display item
                final ItemStack goldDisplay = new ItemStack(Material.SUNFLOWER);
                final ItemMeta goldDisplayMeta = goldDisplay.getItemMeta();
                goldDisplayMeta.displayName(Utils.lore("<yellow>Cost: " + cost));
                double finalChance = chance;
                goldDisplayMeta.lore(new ArrayList<>() {
                    {
                        this.add(Utils.lore("<aqua>Chance of Recovery: " + finalChance));
                        this.add(Utils.lore("<gold><bold>CLICK TO GET <reset><yellow>(maybe)"));

                    }
                });
                goldDisplay.setItemMeta(goldDisplayMeta);

                gui.setItem(12, goldDecrease);
                gui.setItem(13, goldDisplay);
                gui.setItem(14, goldIncrease);
                gui.setItem(31, item);
            }
        }


        player.setMetadata("GemRemover", new FixedMetadataValue(Core.plugin(), gui));
        return gui;
    }
}