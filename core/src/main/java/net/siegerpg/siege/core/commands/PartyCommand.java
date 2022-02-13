/*package net.siegerpg.siege.core.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.party.Party;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

@CommandAlias("p|party")
public class PartyCommand extends BaseCommand {

    @Default
    @Subcommand("help")
    public void onHelp(Player player) {
        Utils.sendMessage(player, (Utils.parse("<dark_aqua>Party Help" +
                "<aqua>/p help\n" +
                "<aqua>/p list\n" +
                "<aqua>/p invite <player>\n" +
                "<aqua>/p accept <player>\n" +
                "<aqua>/p kick <player>\n" +
                "<aqua>/p promote <player>\n" +
                "<aqua>/p leave\n")));
        if (player.hasPermission("siege.party.admin")) {
            Utils.sendMessage(player, (Utils.parse("<red>/p forceleader [player]\n" +
                    "<red>/p forcejoin <player>")));
        }
    }

    @Subcommand("list")
    public void onList(Player player) {
        Party party = Core.partyManager.getParty(player.getUniqueId());
        if (party == null) {
            Utils.sendMessage(player, (Utils.parse("<red>You are not in a party!")));
            return;
        }
        Utils.sendMessage(player, (Utils.parse("<gray>All players in the party:\n" +
                "<dark_gray>- <aqua>\" + party.getLeader().getName() + \" <gray><i>(Leader)")));
        for (OfflinePlayer member : party.getMembers()) if (party.getLeader() != member) player.sendMessage("<gray>- <aqua>" + member.getName());
    }

    @Subcommand("invite")
    @CommandCompletion("@openToInvite")
    public void onInvite(Player player, OnlinePlayer target) {
    }

}

TODO: actually do this crap later
*/