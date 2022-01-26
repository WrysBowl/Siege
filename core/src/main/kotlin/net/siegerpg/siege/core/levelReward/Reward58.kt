package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.misc.food.GoldenCarrot
import net.siegerpg.siege.core.items.implemented.misc.food.Sugar
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.RareKey
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
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward58(
		override val level : Short = 59,
		override val gold : Int = 3000,
		override val items : List<ItemStack> = listOf(
				RareKey().getUpdatedItem(false).asQuantity(3),
				MobKey(0).getUpdatedItem(false).asQuantity(10)
		                                             )
              ) : LevelReward