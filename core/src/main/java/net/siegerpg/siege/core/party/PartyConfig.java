package net.siegerpg.siege.core.party;

import lombok.Getter;
import net.siegerpg.siege.core.Core;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class PartyConfig {
    @Getter
    private static FileConfiguration configuration = null;
    @Getter
    private static File configFile;

    /**
     * Creates the parties config
     */
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void createConfig() {
        configFile = new File(Core.INSTANCE.getDataFolder().getAbsolutePath(), "parties.yml");
        configuration = YamlConfiguration.loadConfiguration(configFile);
        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Resets the party configuration, deleting ALL party data.
     * Beware as this can't be rolled back!
     */
    public static void reset() {
        configFile.delete();
        createConfig();
    }

    /**
     * Saves the party configuration to disk.
     */
    public static void save() {
        try {
            configuration.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
