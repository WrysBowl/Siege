package net.siegerpg.siege.core.utils

import org.bukkit.Location
import org.bukkit.block.data.BlockData

object FloodSelection {
    private val cornerlessPositions = listOf(
        Triple(.0, 1.0, .0),
        Triple(.0, -1.0, .0),
        Triple(.0, .0, 1.0),
        Triple(.0, .0, -1.0),
        Triple(1.0, .0, .0),
        Triple(-1.0, .0, .0)
    )

    fun floodSelect(
        loc: Location,
        dat: BlockData? = null,
        corners: Boolean = false,
        alreadySelected: HashSet<Location> = HashSet()
    ): HashSet<Location> {
        val b = loc.block
        val data = dat ?: b.blockData
        if (!b.blockData.matches(data) || alreadySelected.contains(b.location)) {
            return HashSet()
        }
        alreadySelected.add(b.location)
        if (corners)
            for (i in -1..1)
                for (i2 in -1..1)
                    for (i3 in -1..1) {
                        val newLoc = Location(loc.world, loc.x + i, loc.y + i2, loc.z + i3)
                        alreadySelected.addAll(
                            floodSelect(newLoc, data, corners, alreadySelected)
                        )                    }
        else {

            for ((i, i2, i3) in cornerlessPositions) {
                val newLoc = Location(loc.world, loc.x + i, loc.y + i2, loc.z + i3)
                alreadySelected.addAll(
                    floodSelect(newLoc, data, corners, alreadySelected)
                )
            }
        }
        return alreadySelected
    }


}