package net.siegerpg.siege.core.miscellaneous;

import org.apache.commons.lang.WordUtils;
import org.bukkit.entity.EntityType;

public enum MobHeadType {

	BLAZE (EntityType.BLAZE),
	CAVE_SPIDER (EntityType.CAVE_SPIDER),
	CHICKEN (EntityType.CHICKEN),
	COW (EntityType.COW),
	CREEPER (EntityType.CREEPER),
	ENDERMAN (EntityType.ENDERMAN),
	GHAST (EntityType.GHAST),
	GOLEM (EntityType.IRON_GOLEM),
	LAVA_SLIME (EntityType.MAGMA_CUBE),
	MUSHROOM_COW (EntityType.MUSHROOM_COW),
	OCELOT (EntityType.OCELOT),
	PIG (EntityType.PIG),
	PIG_ZOMBIE (EntityType.ZOMBIFIED_PIGLIN),
	SHEEP (EntityType.SHEEP),
	SKELETON (EntityType.SKELETON),
	SLIME (EntityType.SLIME),
	SPIDER (EntityType.SPIDER),
	SQUID (EntityType.SQUID),
	VILLAGER (EntityType.VILLAGER),
	W_SKELETON (EntityType.WITHER_SKELETON),
	ZOMBIE (EntityType.ZOMBIE);


	EntityType type;

	MobHeadType(EntityType type) {
		this.type = type;
	}

	public EntityType getType() {
		return type;
	}

	public String getMHFName() {
		return "MHF_" + WordUtils.capitalizeFully(name().replace("_", ""));
	}

	public String getTitle() {
		return WordUtils.capitalizeFully(name().replace("_", " ")) + " Head";
	}

}
