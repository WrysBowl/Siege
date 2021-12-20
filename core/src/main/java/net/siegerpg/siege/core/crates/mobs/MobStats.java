package net.siegerpg.siege.core.crates.mobs;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.mobs.hillyWoods.bosses.*;
import net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile.*;
import net.siegerpg.siege.core.drops.mobs.hillyWoods.neutral.GiantHornet;
import net.siegerpg.siege.core.drops.mobs.hillyWoods.neutral.WildFox;
import net.siegerpg.siege.core.drops.mobs.hillyWoods.passive.*;

public enum MobStats {

	Blubber(7, new Blubber()), DeathBull(13, new DeathBull()),
	Mercenary(28, new Mercenary()), Molter(14, new Molter()),
	Ogre(22, new Ogre()), Orc(16, new Orc()), RockSpirit(16, new RockSpirit()),
	Werewolf(28, new Werewolf()), AngryBull(15, new AngryBull()),
	Bandit(24, new Bandit()), BanditArcher(28, new BanditArcher()),
	Blob(5, new Blob()), BloodSucker(17, new BloodSucker()),
	Bully(8, new Bully()), FlamingGoo(6, new FlamingGoo()),
	ForestSpider(18, new ForestSpider()), Goblin(8, new Goblin()),
	GoldenGoblin(8, new GoldenGoblin()), Goo(2, new Goo()),
	InfectedDigger(11, new InfectedDigger()), RockRat(2, new RockRat()),
	ScorchingBlob(12, new ScorchingBlob()), ScrapRat(8, new ScrapRat()),
	Sea_Warrior(15, new Sea_Warrior()), Skeletal_Archer(25, new Skeletal_Archer()),
	Skeletal_Warrior(23, new Skeletal_Warrior()), Thief(24, new Thief()),
	ZombifiedDigger(12, new ZombifiedDigger()), GiantHornet(4, new GiantHornet()),
	WildFox(8, new WildFox()), FeatheredMeat(1, new FeatheredMeat()),
	MooMoo(5, new MooMoo()), Pigeon(1, new Pigeon()), Porky(3, new Porky()),
	Sushi(1, new Sushi()), Wooly(4, new Wooly());

	private final int level;
	private final MobDropTable dropTable;

	MobStats(int level, MobDropTable dropTable) {
		this.level = level;
		this.dropTable = dropTable;

	}
	public int getLevel() {
		return this.level;
	}
	public MobDropTable getDropTable() {
		try {
			//create a copy of the class
			return this.dropTable.getClass().getDeclaredConstructor().newInstance();

		} catch (Exception x) {
			return this.dropTable;
		}
	}

}
