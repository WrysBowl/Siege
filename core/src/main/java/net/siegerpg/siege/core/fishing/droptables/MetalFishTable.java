package net.siegerpg.siege.core.fishing.droptables;

import net.siegerpg.siege.core.fishing.catches.fish.*;
import net.siegerpg.siege.core.fishing.catches.loot.GoldenCarrot;
import net.siegerpg.siege.core.fishing.catches.loot.Sugar;
import net.siegerpg.siege.core.fishing.catches.loot.gems.*;
import net.siegerpg.siege.core.fishing.catches.loot.webstore.*;

import java.util.HashMap;

public class MetalFishTable extends FishDropTable {
	public MetalFishTable () {
		this.fishDropTable = new HashMap<>() {
			{
				put(new Catastrophe(), 60.0);
				put(new Codzilla(), 80.0);
				put(new MrsPuff(), 50.0);
				put(new StingWhip(), 40.0);

				put(new Bearacuda(), 40.0);
				put(new RedSnacker(), 70.0);

				put(new BigBlueTuna(), 80.0);
				put(new FlashyShark(), 20.0);

				//LOOT
				put(new Sugar(), 40.0);
				put(new GoldenCarrot(), 10.0);

				put(new CommonKey(), 2.0);
				put(new NormalKey(), 10.0);
				put(new UncommonKey(), 5.0);

				put(new FlawedHealth(), 5.0);
				put(new FlawedTough(), 5.0);
				put(new FlawedStrength(), 5.0);
				put(new FlawedLuck(), 5.0);
				put(new FlawedRegeneration(), 5.0);

				put(new SimpleHealth(), 2.0);
				put(new SimpleTough(), 2.0);
				put(new SimpleStrength(), 2.0);
				put(new SimpleLuck(), 2.0);
				put(new SimpleRegeneration(), 2.0);

				put(new GOLD20(), 2.0);
				put(new EXP20(), 2.0);
			}
		};
	}
}
