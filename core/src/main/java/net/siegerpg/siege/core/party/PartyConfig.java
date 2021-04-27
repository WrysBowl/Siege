package net.siegerpg.siege.core.party;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.utils.ConfigurationBase;

import java.io.File;

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
