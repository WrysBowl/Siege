package net.siegerpg.siege.core.parties

import co.aikar.commands.BaseCommand
import co.aikar.commands.CommandCompletions
import co.aikar.commands.annotation.*
import net.siegerpg.siege.core.Core
import org.bukkit.entity.Player

@CommandAlias("party|p")
class PartyCommand : BaseCommand() {

    init {
        Core.plugin().commandManager.commandCompletions.registerCompletion(
            "partymembers",
            CommandCompletions.CommandCompletionHandler { player ->
                val party = Party.getPlayerParty(player.player) ?: return@CommandCompletionHandler listOf<String>()
                return@CommandCompletionHandler party.getMembers().map { p -> p.name }
            })
    }

    @Subcommand("create|c")
    @CommandAlias("new")
    fun createParty(player: Player) {

    }

    @Subcommand("join|j")
    @CommandAlias("accept")
    @Syntax("[inviter]")
    @CommandCompletion("@players")
    fun joinParty(player: Player, @Optional inviter: Player) {

    }

    @Subcommand("leave")
    @CommandAlias("disband")
    fun leaveParty(player: Player) {

    }

    @Subcommand("kick")
    @CommandAlias("remove")
    @Syntax("<player>")
    @CommandCompletion("partymembers")
    fun kickFromParty(player: Player) {

    }

    @Subcommand("promote")
    @Syntax("<player>")
    @CommandCompletion("partymembers")
    fun promoteToPartyLeader(player: Player) {

    }

    @Subcommand("chat|c")
    @Syntax("<message>")
    fun promoteToPartyLeader(player: Player, message: String) {

    }

    @HelpCommand
    fun helpWithParty(player: Player) {
        
    }

}
