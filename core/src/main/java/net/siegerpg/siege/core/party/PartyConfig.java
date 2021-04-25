package net.siegerpg.siege.core.party;

import lombok.Getter;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.utils.ConfigurationBase;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class PartyConfig extends ConfigurationBase {

    public PartyConfig(){
        super(new File(Core.plugin().getDataFolder(), "parties.yml"));
        try {
            createConfig();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
