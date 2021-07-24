package net.siegerpg.siege.dungeons.portals

import net.siegerpg.siege.core.utils.ConfigurationBase
import net.siegerpg.siege.dungeons.DungeonPlugin
import net.siegerpg.siege.dungeons.DungeonType
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Sound
import org.bukkit.entity.Player
import java.io.File

open class PortalConfig(plugin: DungeonPlugin) : ConfigurationBase((File(plugin.dataFolder, "portal.yml"))) {


    fun teleportToCorresponding(player: Player): Boolean {
        val coordinateSection = configuration.getConfigurationSection("coords") ?: configuration.createSection("coords")
        val linkingSection =
            configuration.getConfigurationSection("relations") ?: configuration.createSection("relations")
        val corresponding = coordinateSection.getLong(
            serializeLocation(player.location.block.location), -1
        )
        if (corresponding == -1L) {
            return false
        }
        val location = linkingSection.getConfigurationSection(
            corresponding.toString()
        ) ?: return false
        if (location.isSet("dungeon")) {
            val dungeonTypeName = location.getString("dungeon")
            val dungeonType = DungeonType.dungeonTypes.find { d -> dungeonTypeName == d.name } ?: return false
            for (dungeon in dungeonType.dungeons) {
                if (dungeon.listPlayers().contains(player)) {
                    dungeon.addPlayer(player)
                    /*getParties().forEach { party ->
                        if (party.leader == player)
                            party.members.forEach { member ->
                                if (member.isOnline)
                                    (member as Player).teleport(endLocation)
                            }
                        return true
                    }
                     */
                    return true
                }
            }
            val dungeon = dungeonType.nextAvailableDungeon()
            dungeon.addPlayer(player)
            /*
            Party.parties.forEach { party ->
                if (party.leader == player)
                    party.members.forEach { member ->
                        if (member.isOnline)
                            (member as Player).teleport(endLocation)
                    }
                return true
            }
            */
            return true
        } else {
            val actualLocation = Location(
                Bukkit.getWorld(location.getString("world")!!),
                location.getDouble("x"),
                location.getDouble("y"),
                location.getDouble("z")
            )
            player.teleport(actualLocation)
            player.playSound(player.location, Sound.ENTITY_WITHER_SPAWN,10.0f, 10.0f)
            return true
        }
    }

    private fun serializeLocation(loc: Location): String {
        return "${loc.x};${loc.y};${loc.z};${loc.world.name}"
    }

    fun addCoordinate(blockLoc: Location, endingLoc: Location) {
        val coordinateSection = configuration.getConfigurationSection("coords") ?: configuration.createSection("coords")
        val linkingSection =
            configuration.getConfigurationSection("relations") ?: configuration.createSection("relations")
        // Checks the existing locations to see if there's already a location like that
        for (key in linkingSection.getKeys(false)) {
            val location = linkingSection.getConfigurationSection(key) ?: linkingSection.createSection(key)
            if (location.isSet("dungeon")) continue
            val actualLocation = Location(
                Bukkit.getWorld(location.getString("world")!!),
                location.getDouble("x"),
                location.getDouble("y"),
                location.getDouble("z")
            )
            // If it found it then gg
            if (actualLocation == endingLoc) {
                coordinateSection.set(serializeLocation(blockLoc), null)
                coordinateSection.set(serializeLocation(blockLoc), key.toLong())
                return
            }
        }
        val index = linkingSection.getKeys(false).size + 1
        coordinateSection.set(serializeLocation(blockLoc), null)
        coordinateSection.set(serializeLocation(blockLoc), index)
        val locationSection = linkingSection.createSection(index.toString()).apply {
            set("world", endingLoc.world.name)
            set("x", endingLoc.x)
            set("y", endingLoc.y)
            set("z", endingLoc.z)

        }
        linkingSection.set(index.toString(), locationSection)
        save()
    }

    fun addCoordinate(blockLoc: Location, dungeonType: DungeonType) {
        val coordinateSection = configuration.getConfigurationSection("coords") ?: configuration.createSection("coords")
        val linkingSection =
            configuration.getConfigurationSection("relations") ?: configuration.createSection("relations")
        // Checks the existing locations to see if there's already a location like that
        for (key in linkingSection.getKeys(false)) {
            val location = linkingSection.getConfigurationSection(key) ?: linkingSection.createSection(key)
            if (!location.isSet("dungeon")) continue
            if (dungeonType.name == location.getString("dungeon")) {
                coordinateSection.set(serializeLocation(blockLoc), null)
                coordinateSection.set(serializeLocation(blockLoc), key.toLong())
                return
            }
        }
        val index = linkingSection.getKeys(false).size + 1
        coordinateSection.set(serializeLocation(blockLoc), null)
        coordinateSection.set(serializeLocation(blockLoc), index)
        val locationSection = linkingSection.createSection(index.toString()).apply {
            set("dungeon", dungeonType.name)
        }
        linkingSection.set(index.toString(), locationSection)
        save()
    }
}