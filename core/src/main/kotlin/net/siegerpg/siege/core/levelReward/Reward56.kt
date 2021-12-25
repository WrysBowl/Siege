package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.misc.food.GoldenCarrot
import net.siegerpg.siege.core.items.implemented.misc.food.Sugar
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Crystal
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.RefinedMetal
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.CorruptCrystal
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.PolishedLuckGem
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.PristineToughGem
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.Nightshade
import net.siegerpg.siege.core.items.implemented.weapons.ranged.LuminousBow
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.core.webstore.categories.boosters.EXPBooster_50
import net.siegerpg.siege.core.webstore.categories.boosters.GOLDBooster_50
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward56(
		override val level : Short = 57,
		override val gold : Int = 2000,
		override val items : List<ItemStack> = listOf(
				EXPBooster_50().boosterItem,
				GOLDBooster_50().boosterItem
		                                             )
              ) : LevelReward