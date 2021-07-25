package net.siegerpg.siege.core.listeners.NPC;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public class fishingnpcTBD implements Listener {

    private Player person; // Interacting player
    private ChestGui menu;

    public void onRightClickEntity(PlayerInteractEntityEvent e) {
        if (e.getRightClicked().getName().contains("fishingnpcTBD") && e.getRightClicked().getName().contains("6")) {
            person = e.getPlayer();
            menu = initMenu();
            menu.show(person);

        }
    }

    private ChestGui initMenu() {
        ChestGui menu = new ChestGui(3, "FisherNPC");

        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);

        OutlinePane background = new OutlinePane(0, 0, 9, 3);
        background.addItem(new GuiItem(filler, event -> event.setCancelled(true)));
        background.setRepeat(true);
        menu.addPane(background);

        OutlinePane sellPane = new OutlinePane(3, 1, 3, 2);
        menu.addPane(sellPane);

        return menu;
    }

    private void buyFish() {
        
    }
}
