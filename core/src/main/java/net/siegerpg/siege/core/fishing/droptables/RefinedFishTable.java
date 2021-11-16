package net.siegerpg.siege.core.fishing.droptables;

import net.siegerpg.siege.core.fishing.catches.fish.*;
import net.siegerpg.siege.core.fishing.catches.loot.GoldenCarrot;
import net.siegerpg.siege.core.fishing.catches.loot.Sugar;
import net.siegerpg.siege.core.fishing.catches.loot.gems.*;
import net.siegerpg.siege.core.fishing.catches.loot.webstore.*;

import java.util.HashMap;

public class RefinedFishTable extends FishDropTable {
	public RefinedFishTable () {
		this.fishDropTable = new HashMap<>() {
			{
				put(new Catastrophe(), 40.0);
				put(new Codzilla(), 60.0);
				put(new StingWhip(), 40.0);

				put(new Bearacuda(), 40.0);
				put(new RedSnacker(), 60.0);

				put(new BigBlueTuna(), 80.0);
				put(new FlashyShark(), 40.0);

				//LOOT
				put(new Sugar(), 50.0);
				put(new GoldenCarrot(), 30.0);

				put(new NormalKey(), 5.0);
				put(new UncommonKey(), 10.0);

				put(new PolishedHealth(), 2.0);
				put(new PolishedLuck(), 2.0);
				put(new PolishedRegeneration(), 2.0);
				put(new PolishedTough(), 2.0);
				put(new PolishedStrength(), 2.0);

				put(new SimpleHealth(), 5.0);
				put(new SimpleTough(), 5.0);
				put(new SimpleStrength(), 5.0);
				put(new SimpleLuck(), 5.0);
				put(new SimpleRegeneration(), 5.0);

				put(new GOLD20(), 2.0);
				put(new EXP20(), 2.0);
				put(new GOLD50(), 5.0);
				put(new EXP50(), 5.0);
			}
		};
	}
}
