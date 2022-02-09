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
import net.siegerpg.siege.core.items.implemented.misc.tools.GlowingTitaniumAxe
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.Nightshade
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.PixieDagger
import net.siegerpg.siege.core.items.implemented.weapons.ranged.LuminousBow
import net.siegerpg.siege.core.items.implemented.weapons.ranged.TwilightStorm
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward66(
		override val level : Short = 67,
		override val gold : Int = 5000,
		override val items : List<ItemStack> = listOf(
			Sugar().getUpdatedItem(false).asQuantity(64)
		                                             )
              ) : LevelReward