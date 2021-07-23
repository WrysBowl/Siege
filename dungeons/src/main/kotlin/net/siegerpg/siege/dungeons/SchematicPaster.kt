package net.siegerpg.siege.dungeons

import com.boydti.fawe.FaweAPI
import com.boydti.fawe.util.EditSessionBuilder
import com.sk89q.worldedit.WorldEdit
import com.sk89q.worldedit.bukkit.BukkitAdapter
import com.sk89q.worldedit.extent.clipboard.Clipboard
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat
import com.sk89q.worldedit.function.operation.Operations
import com.sk89q.worldedit.math.BlockVector3
import com.sk89q.worldedit.session.ClipboardHolder
import org.bukkit.Location
import java.io.IOException
import java.io.InputStream

object SchematicPaster {
//    /**
//     * Load a schematic from an {@link InputStream}
//     * @param resource {@link InputStream}
//     * @param clipboardFormat The format of the clipboard
//     * @return Returns a {@link Clipboard}
//     * @throws IOException Thrown when the resource can't be read.
//     */
//    public fun loadSchematic(resource: InputStream, clipboardFormat: ClipboardFormat): Clipboard {
//        val clipboardReader = clipboardFormat.getReader(resource);
//        return clipboardReader.read();
//    }

    /**
     * Paste the contents of a clipboard.
     * @param clipboard The clipboard containing the schematic
     * @param location The position to paste the schematic in
     * @param ignoreAirBlocks Whether or not air blocks are skipped while pasting
     * @throws IOException Thrown when the resource can't be read
     */
    public fun pasteSchematic(clipboard: Clipboard, location: Location, pasteAir: Boolean) {
        val weWorld = FaweAPI.getWorld(location.world.name)
        val editSession = EditSessionBuilder(weWorld).allowedRegionsEverywhere().limitUnlimited().build()
        editSession.use {
            val operation = ClipboardHolder(clipboard)
                .createPaste(it)
                .to(BukkitAdapter.asBlockVector(location))
                .ignoreAirBlocks(!pasteAir)
                .build();
            Operations.complete(operation);
            editSession.flushQueue()
        }
    }
}