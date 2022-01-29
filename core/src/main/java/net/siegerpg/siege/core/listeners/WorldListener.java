package net.siegerpg.siege.core.listeners;

import io.github.retrooper.packetevents.event.PacketListenerAbstract;
import io.github.retrooper.packetevents.event.impl.PacketPlaySendEvent;
import io.github.retrooper.packetevents.packettype.PacketType;
import io.github.retrooper.packetevents.packetwrappers.play.out.worldparticles.WrappedPacketOutWorldParticles;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.items.types.misc.CustomFood;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Campfire;
import org.bukkit.block.data.type.Door;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class WorldListener extends PacketListenerAbstract implements Listener, Runnable {

	@EventHandler
	public void onTrample(PlayerInteractEvent event) {

		if (!event
				.getAction()
				.equals(Action.PHYSICAL)) return;
		if (event.getClickedBlock() == null || !event
				.getClickedBlock()
				.getType()
				.equals(Material.FARMLAND))
			return;
		event.setCancelled(true);
	}

	@EventHandler
	public void onPlace(BlockPlaceEvent event) {

		if (event
				.getPlayer()
				.getGameMode()
				.equals(GameMode.CREATIVE)) return;
		event.setCancelled(true);
	}

	@EventHandler
	public void openDeniedBlocks(PlayerInteractEvent e) {

		if (e.getClickedBlock() == null) return;
		if (e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) return;
		if (!e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;

		BlockData block = e.getClickedBlock().getBlockData();
		Material type = e.getClickedBlock().getType();


		if (block instanceof Door) return;
		else if (type.equals(Material.ENDER_CHEST)) return;
		else if (type.equals(Material.CAMPFIRE)) {
			if(((Campfire)block).isLit()) return;
		}
		if (!type.isInteractable()) return;
		e.setCancelled(true);
	}

	@EventHandler
	public void campfireCook(BlockCookEvent e) {
		if (e.isCancelled()) return;
		ItemStack item = e.getResult();
		HashMap<Material, CustomFood> foods = new HashMap<>(){
			{
				put(Material.COOKED_BEEF, new CookedBeef());
				put(Material.COOKED_CHICKEN, new CookedChicken());
				put(Material.COOKED_PORKCHOP, new CookedPork());

			}
		};
		CustomFood cookedFood = foods.get(item.getType());
		if (cookedFood == null) {
			if (Utils.randTest(15.0)) {
				e.setResult(new BeetrootCurry().getUpdatedItem(false));
			} else if (Utils.randTest(10.0)) {
				e.setResult(new HoneyOatBread().getUpdatedItem(false));
			} else if (Utils.randTest(15.0)) {
				e.setResult(new CaramelApple().getUpdatedItem(false));
			} else {
				e.setResult(new CharredFood().getUpdatedItem(false));
			}
		} else {
			e.setResult(cookedFood.getUpdatedItem(false));
		}
	}

	@EventHandler
	public void onRodThrow(final ProjectileLaunchEvent e) {

		final double v = 2.0; //velocity of the rod
		if (e.getEntityType().equals(EntityType.FISHING_HOOK)) {
			e.getEntity().setVelocity(e.getEntity().getVelocity().multiply(v));
		}
	}

	@EventHandler
	public void onEntityEnter(EntityEnterBlockEvent e) {

		if (e.getEntity() instanceof Bee) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void denySpawning(ItemSpawnEvent e) {

		Material type = e
				.getEntity()
				.getItemStack()
				.getType();
		if (type == Material.ARROW) {
			e.setCancelled(true);
		} else if (type == Material.EGG) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void preventClick(PlayerInteractEvent e) {

		if (e.getAction()
				    .equals(Action.LEFT_CLICK_AIR) || e
				    .getAction()
				    .equals(Action.LEFT_CLICK_BLOCK) ||
		    e.getAction()
				    .equals(Action.RIGHT_CLICK_AIR) || e
				    .getAction()
				    .equals(Action.RIGHT_CLICK_BLOCK)) {
			if (e.getClickedBlock() == null) {
				return;
			}
			if (e.getClickedBlock() instanceof ItemFrame ||
			    e.getClickedBlock() instanceof ArmorStand) {
				if (e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
					return;
				}
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void preventClick(PlayerInteractEntityEvent e) {

		Entity entity = e.getRightClicked();
		Player player = e.getPlayer();
		if (entity instanceof ItemFrame) {
			if (player.getGameMode().equals(GameMode.CREATIVE)) {
				return;
			}
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void preventClick(PlayerInteractAtEntityEvent e) {

		Entity entity = e.getRightClicked();
		Player player = e.getPlayer();
		if (entity instanceof ItemFrame) {
			if (player.getGameMode().equals(GameMode.CREATIVE)) {
				return;
			}
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void preventDamage(EntityDamageEvent e) {

		if (e instanceof EntityDamageByEntityEvent) {
			if (((EntityDamageByEntityEvent) e).getDamager() instanceof Player) {
				Player player = (Player) ((EntityDamageByEntityEvent) e).getDamager();
				if (player
						.getGameMode()
						.equals(GameMode.CREATIVE)) {
					return;
				}
			}
		}
		if (e.getEntity() instanceof ItemFrame) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void spawnProt(EntityDamageByEntityEvent e) {

		if (e.getDamager() instanceof Player) {
			Player player = (Player) e.getDamager();
			if (player
					.getGameMode()
					.equals(GameMode.CREATIVE)) {
				return;
			}
		}
		if (e
				    .getEntity()
				    .getLocation()
				    .distance(e
						              .getEntity()
						              .getWorld()
						              .getSpawnLocation()) < 3) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void preventTame(EntityTameEvent e) {

		Player player = (Player) e.getOwner();
		if (!player
				.getGameMode()
				.equals(GameMode.CREATIVE)) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void preventBreed(EntityBreedEvent e) {

		Player player = (Player) e.getBreeder();
		if (player != null) {
			if (player
					.getGameMode()
					.equals(GameMode.CREATIVE)) {
				return;
			}
		}
		e.setCancelled(true);
	}

	@EventHandler
	public void preventExplosion(BlockExplodeEvent e) {

		e.setCancelled(true);
	}

	@EventHandler
	public void preventExplosion2(EntityExplodeEvent e) {

		e.setCancelled(true);
	}

	@EventHandler
	public void denySlimeSplit(SlimeSplitEvent e) {

		e.setCancelled(true);
	}

	@EventHandler
	public void denyLeavesDecay(LeavesDecayEvent e) {

		e.setCancelled(true);
	}

	@EventHandler
	public void denyBurn(BlockBurnEvent e) {

		e.setCancelled(true);
	}

	@EventHandler
	public void denyCraft(CraftItemEvent e) {

		e.setCancelled(true);
	}

	@EventHandler
	public void denyBlockExp(BlockExpEvent e) {

		e.setExpToDrop(0);
	}

	@EventHandler
	public void denyBlockFade(BlockFadeEvent e) {

		e.setCancelled(true);
	}

	@Override
	public void run() {

	}

	public void onPacketPlaySend(PacketPlaySendEvent e) {
		if (e.getPacketId() != PacketType.Play.Server.WORLD_PARTICLES) return;
		WrappedPacketOutWorldParticles packet = new WrappedPacketOutWorldParticles(e.getNMSPacket());
		byte[] data = new byte[]{0};
		packet.writeByteArray(0, data);
	}

}