package net.siegerpg.siege.dungeons.portals


import net.siegerpg.siege.core.utils.FloodSelection
import net.siegerpg.siege.dungeons.DungeonPlugin
import net.siegerpg.siege.dungeons.DungeonType
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player

class PortalCommand : CommandExecutor, TabCompleter {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("Only players can execute this command!")
            return false
        }
        if (!sender.isOp) {
            sender.sendMessage("Only ops can execute this command!")
            return true
        }
        if (args.getOrNull(0)?.startsWith("dungeon") == true) {
            val dungeonTypeName = args.getOrNull(1)
            val dungeonType = DungeonType.dungeonTypes.find { d -> d.name == dungeonTypeName }
            if (dungeonType == null) {
                sender.sendMessage("That dungeon type doesn't exist :(")
                return true
            }
            val data = Material.NETHER_PORTAL.createBlockData()
            sender.sendMessage("Adding new locations to all portal blocks nearby...")
            var done = 0
            FloodSelection.floodSelect(sender.getTargetBlock(null, 100).location, data).forEach { loc ->
                DungeonPlugin.plugin().portalConfig.addCoordinate(loc, dungeonType)
                done++
            }
            sender.sendMessage("Done! $done blocks configured!")
            return true
        } else if (args.size >= 4) {
            val targetBlock = sender.getTargetBlock(null, 100)
            val location = Location(
                Bukkit.getWorld(args[3]),
                args[0].toDouble(),
                args[1].toDouble(),
                args[2].toDouble()
            )
            val data = Material.NETHER_PORTAL.createBlockData()
            sender.sendMessage("Adding new locations to all portal blocks nearby...")
            var done = 0
            FloodSelection.floodSelect(targetBlock.location, data).forEach { loc ->
                DungeonPlugin.plugin().portalConfig.addCoordinate(loc, location)
                done++
            }
            sender.sendMessage("Done! $done blocks configured!")
            return true
        }
        return false
    }

    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        alias: String,
        args: Array<out String>
    ): MutableList<String> {
        if (args.getOrNull(1) == null)
            return mutableListOf("dungeon", "x")
        else if (args.getOrNull(2) == null) {
            if (args.getOrNull(0) == "dungeon") return DungeonType.dungeonTypes.map { t -> t.name }.toMutableList()
            return mutableListOf("y")
        } else if (args.getOrNull(3) == null)
            return mutableListOf("z")
        else if (args.getOrNull(4) == null)
            return Bukkit.getWorlds().map { world ->
                world.name
            }.toMutableList()
        return mutableListOf()
    }
}


