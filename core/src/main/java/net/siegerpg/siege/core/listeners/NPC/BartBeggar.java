package net.siegerpg.siege.core.listeners.NPC;

import com.github.stefvanschie.inventoryframework.gui.type.*;
import com.github.stefvanschie.inventoryframework.pane.*;

public class BartBeggar {

    ChestGui gui = new ChestGui(5, "Bart's MineSweeper");

    /**
     * PSEUDOCODE
     *
     * First page: 5 rows
     * 20. START description Costs 500 gold, NO REFUNDS -> second page
     * 24. HELP description dig to your heart's content
     * and hope you don't dig up a hidden bomb.
     * If you close the gui, you keep all your rewards!
     *
     * Second page: 6 rows
     * Generate list of random values from 0 to 4
     * 0's are bombs
     * 1's are 100 coins
     * 2's are 100 exp
     * 3's are nothing
     * 4's are nothing
     *
     * Initialize goldReward and expReward var to store player rewards
     *
     * onGuiClick ->
     *
     *  if slot is a '0', then set all gui slots to
     *  red glass pane named "<bold>YOU LOST" after 2 seconds
     *  clear list
     *  close inventory
     *
     *  if slot is a '1', add 100 to the goldReward and
     *  set the slot to a gold coin named &e+100
     *  send entity_experience_orb sound
     *  if slot is a '2', add 100 to the expReward
     *  set the slot to an exp bottle named &d+100
     *  send block_stone_button_push sound
     *
     * onGuiClose ->
     *  check if list is empty -> return
     *  give player rewards from list
     *  make NPC send player message "&6Bart: &7Rematch?!"
     */

}
