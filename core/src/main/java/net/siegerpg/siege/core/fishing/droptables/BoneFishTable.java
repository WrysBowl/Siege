package net.siegerpg.siege.core.fishing.droptables;

import net.siegerpg.siege.core.fishing.catches.fish.*;
import net.siegerpg.siege.core.fishing.catches.loot.Sugar;
import net.siegerpg.siege.core.fishing.catches.loot.SusStew;
import net.siegerpg.siege.core.fishing.catches.loot.gems.*;
import net.siegerpg.siege.core.fishing.catches.loot.webstore.CommonKey;
import net.siegerpg.siege.core.fishing.catches.loot.webstore.NormalKey;
import net.siegerpg.siege.core.fishing.catches.loot.webstore.UncommonKey;

import java.util.HashMap;

public class BoneFishTable extends FishDropTable {

	public BoneFishTable () {

		this.fishDropTable = new HashMap<>() {
			{
				put(new Catastrophe(), 60.0);
				put(new Codzilla(), 100.0);
				put(new MrsPuff(), 50.0);
				put(new StingWhip(), 40.0);

				put(new Bearacuda(), 40.0);
				put(new RedSnacker(), 80.0);

				put(new BigBlueTuna(), 80.0);
				put(new FlashyShark(), 10.0);

				//LOOT
				put(new SusStew(), 5.0);
				put(new Sugar(), 30.0);

				put(new CommonKey(), 10.0);
				put(new NormalKey(), 5.0);
				put(new UncommonKey(), 2.0);

				put(new CrackedHealth(), 2.0);
				put(new CrackedTough(), 2.0);
				put(new CrackedStrength(), 2.0);
				put(new CrackedLuck(), 2.0);
				put(new CrackedRegeneration(), 2.0);

				put(new FlawedHealth(), 5.0);
				put(new FlawedTough(), 5.0);
				put(new FlawedStrength(), 5.0);
				put(new FlawedLuck(), 5.0);
				put(new FlawedRegeneration(), 5.0);
			}
		};
	}

}
