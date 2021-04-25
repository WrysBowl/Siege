package net.siegerpg.siege.core.party;

import lombok.Getter;
import net.siegerpg.siege.core.Core;
import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;
import java.util.UUID;

public class PartyManager {
    @Getter
    private final HashMap<UUID, Party> parties = new HashMap<>();

    public Party getParty(UUID playerUUID) {
        for (Party party : getParties().values()) if (party.isMember(playerUUID)) return party;
        return null;
    }

    public PartyManager() {
        ConfigurationSection parties = Core.plugin().partyConfig.getConfiguration().getConfigurationSection("party");
        if (parties != null) for (String party : parties.getKeys(false)) {
            Party newParty = new Party(UUID.fromString(party));
            getParties().put(newParty.getLeader().getUniqueId(), newParty);
        }
    }

    public void saveAll() {
        for (Party party : getParties().values()) party.save(true);
    }
}
