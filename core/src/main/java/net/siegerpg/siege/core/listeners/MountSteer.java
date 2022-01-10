package net.siegerpg.siege.core.listeners;

import com.destroystokyo.paper.entity.Pathfinder;
import io.github.retrooper.packetevents.event.PacketListenerAbstract;
import io.github.retrooper.packetevents.event.impl.PacketPlayReceiveEvent;
import io.github.retrooper.packetevents.event.impl.PacketPlaySendEvent;
import io.github.retrooper.packetevents.event.impl.PostPacketPlaySendEvent;
import io.github.retrooper.packetevents.packettype.PacketType;
import io.github.retrooper.packetevents.packetwrappers.play.in.steervehicle.WrappedPacketInSteerVehicle;
import io.lumine.xikage.mythicmobs.volatilecode.v1_16_R3.ai.PathfinderHolder;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SpawnEggMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;

public class MountSteer extends PacketListenerAbstract implements Listener {

	HashMap<Player, Entity> cachedMounts = new HashMap<>();

	@EventHandler
	public void playerTeleport(PlayerTeleportEvent e) {
		Player player = e.getPlayer();
		Entity vehicle = player.getVehicle();
		if (vehicle == null) return;
		if (!cachedMounts.containsKey(player)) return;

		cachedMounts.remove(player);
		vehicle.remove();
		player.getWorld().spawnParticle(Particle.SPELL_MOB,player.getLocation(),10);
		player.playSound(player.getLocation(), Sound.BLOCK_LAVA_EXTINGUISH,1.0f,1.0f);
	}

	@EventHandler
	public void playerLeave(PlayerQuitEvent e) {
		Player player = e.getPlayer();
		if (!cachedMounts.containsKey(player)) return;

		Entity entity = cachedMounts.get(player);
		entity.remove();
		cachedMounts.remove(player);
	}
	@EventHandler
	public void useMobEgg(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		if (!e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
		ItemStack item = player.getInventory().getItemInMainHand();
		try {
			//prevent player from spawning mob
			e.setCancelled(true);

			//spawns the mob and makes player mount it
			String entityName = item.getType().toString()
			                        .replace("_spawn_egg","")
			                        .replace("_SPAWN_EGG","");

			EntityType type = EntityType.fromName(entityName);
			if (type==null) return;
			Entity entity = player.getWorld().spawnEntity(player.getLocation(), type);

			entity.setCustomName(Utils.tacc("&b"+player.getName()+"'s "+type.getName()));
			entity.setCustomNameVisible(true);
			entity.addPassenger(player);


			cachedMounts.put(player,entity);
			player.sendMessage(Utils.lore("<green>Successfully mounted your "+type.getName()));

		} catch (Exception ignored) {}
	}

	@EventHandler
	public void vehicleDismount(VehicleExitEvent e) {
		Entity vehicle = e.getVehicle();
		Entity player = vehicle.getPassenger();
		Bukkit.getLogger().info("1");
		if (!(player instanceof Player)) return;
		Bukkit.getLogger().info("2");

		if (!cachedMounts.containsKey(player)) return;
		Bukkit.getLogger().info("3");

		cachedMounts.remove(player);
		vehicle.remove();
		player.getWorld().spawnParticle(Particle.SPELL_MOB,player.getLocation(),10);
		((Player)player).playSound(player.getLocation(), Sound.BLOCK_LAVA_EXTINGUISH,1.0f,1.0f);
	}

	@EventHandler
	public void vehicleDamage(VehicleDamageEvent e) {
		Entity vehicle = e.getVehicle();
		Entity player = vehicle.getPassenger();
		if (!(player instanceof Player)) return;
		if (!cachedMounts.containsKey(player)) return;

		cachedMounts.remove(player);
		vehicle.remove();
		player.getWorld().spawnParticle(Particle.SPELL_MOB,player.getLocation(),10);
		((Player)player).playSound(player.getLocation(), Sound.BLOCK_LAVA_EXTINGUISH,1.0f,1.0f);
	}

	public void onPacketPlayReceive(PacketPlayReceiveEvent e) {

		if (e.getPacketId() != PacketType.Play.Client.STEER_VEHICLE) return;
		if (!(e.getPlayer().getVehicle() instanceof Mob)) return;
		if (e.getPlayer().getVehicle() == null) return;

		WrappedPacketInSteerVehicle vehiclePacket = new WrappedPacketInSteerVehicle(e.getNMSPacket());

		Player player = e.getPlayer();
		float forward = vehiclePacket.getForwardValue();
		boolean jump = vehiclePacket.isJump();
		boolean dismount = vehiclePacket.isDismount();

		Mob vehicle = (Mob) player.getVehicle();
		Location vehicleLocation = vehicle.getLocation().clone();

		if (dismount) {
			cachedMounts.remove(player);
			new BukkitRunnable() {
				@Override
				public void run() {
					vehicle.remove();
					player.getWorld().spawnParticle(Particle.SPELL_MOB,player.getLocation(),10);
					player.playSound(player.getLocation(), Sound.BLOCK_LAVA_EXTINGUISH,1.0f,1.0f);
				}
			}.runTask(Core.plugin());

		}
		if (jump) {
			vehicle.setJumping(true);
		}
		if (forward > 0) {

			double speed  = forward*2;
			Location targetLocation = vehicleLocation.add(player.getLocation().getDirection());

			new BukkitRunnable() {
				@Override
				public void run() {
					vehicle.getPathfinder().moveTo(targetLocation, speed);
				}
			}.runTask(Core.plugin());

		}

	}
}
