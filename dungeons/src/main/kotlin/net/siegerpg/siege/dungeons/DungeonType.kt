package net.siegerpg.siege.dungeons

import com.sk89q.worldedit.extent.clipboard.Clipboard
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats
import org.bukkit.*
import org.bukkit.configuration.ConfigurationSection
import org.bukkit.entity.Entity
import org.bukkit.generator.ChunkGenerator
import java.io.File
import java.util.*
import java.util.function.Consumer

//
// The yaml syntax for the dungeons
//
// NAME: # The dungeon type's name
//  spawn:
//      x: 1
//      y: 2
//      z: 3
//  schemPath: schematics/bad.schem
//  level: 5
//  distance: 500
//  boss:
//      x: 1
//      y: 2
//      z: 3
//      name: mythicmobs name
//  dungeons: # List of dungeons of that type
//      1:
//          # Dungeon stuff (see Dungeon.java)
//

class DungeonType {

    var name: String
    var index: Int
    var dungeonLevel: Int
    var relSpawnLoc: Location
    var relBossLoc: Location
    var boss: String
    lateinit var schematic: Clipboard
    var dungeonDistance: Short
    var dungeons = mutableListOf<Dungeon>()
    var bossInst: Entity? = null

    companion object {
        var dungeonTypes = mutableListOf<DungeonType>()
        var world = Bukkit.getWorld("dungeons")
        fun deserialize(section: ConfigurationSection, name: String): DungeonType {
            var spawnOffset = section.getConfigurationSection("spawn") ?: section.createSection("spawn")
            var bossOffset = section.getConfigurationSection("boss") ?: section.createSection("boss")
            val relSpawnLoc =
                Location(world, spawnOffset.getDouble("x"), spawnOffset.getDouble("y"), spawnOffset.getDouble("z"))
            val relBossLoc =
                Location(world, bossOffset.getDouble("x"), bossOffset.getDouble("y"), bossOffset.getDouble("z"))
            val bossName = bossOffset.getString("name")!!
            return DungeonType(
                name,
                File(DungeonPlugin.plugin().dataFolder, section.getString("schemPath")!!),
                section.getInt("level"),
                section.getInt("distance").toShort(),
                relSpawnLoc, relBossLoc,
                bossName
            )
        }

        /**
         * Removes ALL the dungeons in the world.
         */
        fun removeAll() {
            for (dungeonType in dungeonTypes) {
                dungeonType.clear()
            }
        }
    }

    /**
     * Creates a new dungeon type
     *
     * @param name         The dungeon type's name
     * @param schematicFile The file of the schematic
     * @param dungeonLevel The level of the dungeon
     * @param dungeonDistance     The distance between each dungeon of the same type
     * @param relSpawnLoc  The relative player spawn location, relative to the dungeon schematic copy position and the location of the spawn point.
     * @param relBossLoc The relative boss spawn location, relative to the dungeon schematic copy position and the location of the spawn point.
     * @param bossName The boss' name
     * @param plugin The siege dungeons plugin's instance
     */
    constructor(
        name: String,
        schematicFile: File,
        dungeonLevel: Int,
        dungeonDistance: Short,
        relSpawnLoc: Location,
        relBossLoc: Location,
        bossName: String,
    ) {
        this.name = name
        try {
            val format = ClipboardFormats.findByFile(schematicFile)!!
            val reader = format.getReader(schematicFile.inputStream())
            this.schematic = reader.read()
        } catch (exc: Exception) {
            DungeonPlugin.plugin().logger.severe(exc.message)
        }
        this.dungeonLevel = dungeonLevel
        this.dungeonDistance = dungeonDistance
        this.relBossLoc = relBossLoc
        this.boss = bossName
        this.relSpawnLoc = relSpawnLoc
        this.index = dungeonTypes.size
        dungeonTypes.add(this)
        if (world == null) {
            val creator =
                WorldCreator(name) // If the dungeons world is nonexistent it creates it and makes each new chunk generated empty
            creator.generateStructures(false).type(WorldType.FLAT).environment(World.Environment.NORMAL)
            creator.generator(object : ChunkGenerator() {
                override fun generateChunkData(
                    world: World,
                    random: Random,
                    x: Int,
                    z: Int,
                    biome: BiomeGrid
                ): ChunkData {
                    return createChunkData(world) // This should set all blocks to air
                }

                override fun isParallelCapable(): Boolean {
                    return true
                } // Whether or not the generator can run parallel
            })
            world = creator.createWorld() // Creates the world
        }
        val dungeonCfg = DungeonPlugin.plugin().dungeonConfig.getDungeons(this)
        dungeonCfg.getKeys(false).forEach(Consumer { key: String? ->
            if (dungeonCfg.isConfigurationSection(
                    key!!
                )
            ) {
                val section =
                    dungeonCfg.getConfigurationSection(key) ?: dungeonCfg.createSection(key)
                val k = Integer.valueOf(key)
                dungeons.add(k, Dungeon.deserialize(section, k, this))
            }
        })
    }

    /**
     * Removes all dungeons of the type
     */
    fun clear() {
        for (dungeon in dungeons) {
            dungeon.delete()
        }
    }

    /**
     * Finds the next avaliable dungeon and returns it
     *
     * @return Dungeon The next available dungeon
     */
    fun nextAvailableDungeon(): Dungeon {
        var available: Dungeon? = null
        val dungeonLength = dungeons.map { d -> d.index }.maxOrNull() ?: 0
        for (dungeon in dungeons) {
            if (dungeon.listPlayers().size < 1) {
                dungeon.reset()
                available = dungeon
            }
        }
        if (available == null) {
            available = Dungeon(this, dungeonLength + 1)
            available.reset()
        }
        println(available)
        return available
    }
}