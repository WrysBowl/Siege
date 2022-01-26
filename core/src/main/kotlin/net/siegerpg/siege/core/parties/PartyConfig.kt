package net.siegerpg.siege.core.parties

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.miscellaneous.ConfigurationBase
import org.bukkit.configuration.ConfigurationSection
import java.io.File
import java.util.*

/*
    parties:
        ID:
            members:
                - ...
                - ...
                - ...
            leader: ...

 */

class PartyConfig : ConfigurationBase(File(Core.plugin().dataFolder, "parties.yml")) {

	fun getParties() : ConfigurationSection {
		return configuration.getConfigurationSection("parties")
		       ?: configuration.createSection("parties")
	}

	fun getParty(id : UUID) : ConfigurationSection {
		return getParties().getConfigurationSection(id.toString())
		       ?: getParties().createSection(id.toString())
	}

	fun setParty(id : UUID, data : ConfigurationSection?) {
		getParties().set(id.toString(), data)
		save()
	}

	fun initializeAllFromConfig() {

//        CustomRecipe recipe = new CustomRecipe();
//        recipe.s1(new Pebble());
//        CustomRecipe.Companion.registerRecipe(recipe);


		// Deserialize all parties
		getParties()
				.getKeys(false)
				.forEach { key ->
					val party =
							Party.deserialize(
									UUID.fromString(key),
									getParty(UUID.fromString(key))
							                 )
					if (party.getMembers().size < 2) {
						party.delete()
					}
				}

	}
}