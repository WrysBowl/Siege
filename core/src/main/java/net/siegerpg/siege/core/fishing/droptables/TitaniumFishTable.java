package net.siegerpg.siege.core.fishing.droptables;

import net.siegerpg.siege.core.fishing.catches.fish.*;
import net.siegerpg.siege.core.fishing.catches.loot.GoldenCarrot;
import net.siegerpg.siege.core.fishing.catches.loot.Sugar;
import net.siegerpg.siege.core.fishing.catches.loot.gems.*;
import net.siegerpg.siege.core.fishing.catches.loot.webstore.*;

import java.util.HashMap;

public class TitaniumFishTable extends FishDropTable {

	public TitaniumFishTable() {

		this.fishDropTable = new HashMap<>() {
			{
				put(new Catastrophe(), 60.0);
				put(new Codzilla(), 80.0);
				put(new StingWhip(), 100.0);

				put(new Bearacuda(), 100.0);
				put(new RedSnacker(), 150.0);

				put(new BigBlueTuna(), 100.0);
				put(new FlashyShark(), 50.0);

				//LOOT
				put(new Sugar(), 70.0);
				put(new GoldenCarrot(), 50.0);

				put(new NormalKey(), 5.0);
				put(new UncommonKey(), 10.0);

				put(new PolishedHealth(), 5.0);
				put(new PolishedLuck(), 5.0);
				put(new PolishedRegeneration(), 5.0);
				put(new PolishedTough(), 5.0);
				put(new PolishedStrength(), 5.0);

				put(new SimpleHealth(), 2.0);
				put(new SimpleTough(), 2.0);
				put(new SimpleStrength(), 2.0);
				put(new SimpleLuck(), 2.0);
				put(new SimpleRegeneration(), 2.0);

				put(new GOLD20(), 2.0);
				put(new EXP20(), 2.0);
				put(new GOLD50(), 5.0);
				put(new EXP50(), 5.0);
			}
		};
	}

}
