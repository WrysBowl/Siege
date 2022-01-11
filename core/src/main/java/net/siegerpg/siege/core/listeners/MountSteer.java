package net.siegerpg.siege.core.listeners;

import com.destroystokyo.paper.entity.Pathfinder;
import io.github.retrooper.packetevents.event.PacketListenerAbstract;
import io.github.retrooper.packetevents.event.impl.PacketPlayReceiveEvent;
import io.github.retrooper.packetevents.event.impl.PacketPlaySendEvent;
import io.github.retrooper.packetevents.event.impl.PostPacketPlaySendEvent;
import io.github.retrooper.packetevents.packettype.PacketType;
import io.github.retrooper.packetevents.packetwrappers.play.in.steervehicle.WrappedPacketInSteerVehicle;
import io.lumine.xikage.mythicmobs.volatilecode.v1_16_R3.ai.PathfinderHolder;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.types.misc.CustomMount;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.*;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SpawnEggMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.HashMap;

public class MountSteer extends PacketListenerAbstract implements Listener {

	HashMap<Player, Entity> cachedMounts = new HashMap<>();

	@EventHandler
	public void playerTeleport(PlayerTeleportEvent e) {
		Player player = e.getPlayer();
		if (!cachedMounts.containsKey(player)) return;

		Entity entity = cachedMounts.get(player);
		entity.remove();
		cachedMounts.remove(player);
		player.getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE,player.getLocation(),10);
		player.playSound(player.getLocation(), Sound.BLOCK_LAVA_EXTINGUISH,1.0f,1.0f);
	}

	@EventHandler
	public void playerLeave(PlayerQuitEvent e) {
		Player player = e.getPlayer();
		if (!cachedMounts.containsKey(player)) return;

		Entity entity = cachedMounts.get(player);
		entity.remove();
		cachedMounts.remove(player);
		player.getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE,player.getLocation(),10);
		player.playSound(player.getLocation(), Sound.BLOCK_LAVA_EXTINGUISH,1.0f,1.0f);
	}

	@EventHandler
	public void mountEntity(PlayerInteractEntityEvent e) {
		Player player = e.getPlayer();
		if (!cachedMounts.containsKey(player)) return;
		Entity clickedEntity = e.getRightClicked();
		Entity entity = cachedMounts.get(player);
		if (clickedEntity != entity) return;
		entity.addPassenger(player);
	}

	@EventHandler
	public void preventOpenHorseInventory(InventoryOpenEvent e) {
		Inventory inventory = e.getInventory();
		if (inventory instanceof AbstractHorseInventory) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void preventMountTarget(EntityTargetEvent e) {
		Entity vehicleTarget = e.getTarget();
		Entity vehicle = e.getEntity();
		if (vehicleTarget == null) return;
		if (!cachedMounts.containsValue(vehicle)) return;

		//prevent target if vehicle is targeting another entity
		e.setCancelled(true);
	}

	@EventHandler
	public void setMountName(AsyncPlayerChatEvent e) {
		Player player = e.getPlayer();
		ItemStack item = player.getInventory().getItemInMainHand();

		String message = e.getMessage();
		if (message.length() > 20) return;

		//if player is holding spawn egg when talking
		EntityType type = getSpawnEggType(item);
		if (type==null) return;

		//check if held spawn egg is a mount
		CustomItem customItem = CustomItemUtils.INSTANCE.getCustomItem(item);
		if (!(customItem instanceof CustomMount)) return;

		CustomMount mount = ((CustomMount)customItem);
		mount.setName(message);
		mount.serialize();
		player.getInventory().setItemInMainHand(mount.getUpdatedItem(false));
		e.setCancelled(true);
	}

	@Nullable
	public EntityType getSpawnEggType(ItemStack item) {
		String entityName = item.getType().toString()
		                        .replace("_spawn_egg","")
		                        .replace("_SPAWN_EGG","");

		return EntityType.fromName(entityName);
	}

	@EventHandler
	public void useMobEgg(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		ItemStack item = player.getInventory().getItemInMainHand();
		if (cachedMounts.containsKey(player)) {
			Entity entity = cachedMounts.get(player);
			entity.remove();
			cachedMounts.remove(player);
			return;
		}
		try {
			//spawns the mob and makes player mount it
			EntityType type = getSpawnEggType(item);
			if (type==null) return;

			//prevent player from spawning mob
			e.setCancelled(true);
			if (!e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
			if (player.isSneaking()) {
				player.getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE,player.getLocation(),10);
				return;
			}

			String entityName = item.getItemMeta().getDisplayName();
			Entity entity = player.getWorld().spawnEntity(player.getLocation(), type);
			if (entity instanceof Tameable) {
				((Tameable) entity).setOwner(player);
				((Tameable) entity).setTamed(true);
			}
			if (entity instanceof AbstractHorse) {
				((AbstractHorse) entity).getInventory().setSaddle(new ItemStack(Material.SADDLE));
			}

			entity.setCustomName(Utils.tacc(entityName));
			entity.setCustomNameVisible(true);
			entity.addPassenger(player);

			cachedMounts.put(player,entity);
			player.sendMessage(Utils.lore("<green>Successfully mounted your "+entityName));
			player.getWorld().spawnParticle(Particle.SPELL_MOB,player.getLocation(),10);

		} catch (Exception ignored) {}
	}

	@EventHandler
	public void vehicleDismount(VehicleExitEvent e) {
		Entity vehicle = e.getVehicle();
		if (!cachedMounts.containsValue(vehicle)) return;

		cachedMounts.values().removeIf(vehicle::equals);
		vehicle.remove();
		vehicle.getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE,vehicle.getLocation(),10);
	}

	@EventHandler
	public void vehicleDamage(VehicleDamageEvent e) {
		Entity vehicle = e.getVehicle();
		if (!cachedMounts.containsValue(vehicle)) return;

		cachedMounts.values().removeIf(vehicle::equals);
		vehicle.remove();
		vehicle.getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE,vehicle.getLocation(),10);
	}
	@EventHandler
	public void vehicleDamage(EntityDamageEvent e) {
		Entity vehicle = e.getEntity();
		if (!cachedMounts.containsValue(vehicle)) return;

		cachedMounts.values().removeIf(vehicle::equals);
		vehicle.remove();
		vehicle.getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE,vehicle.getLocation(),10);
	}

	public void onPacketPlayReceive(PacketPlayReceiveEvent e) {

		if (e.getPacketId() != PacketType.Play.Client.STEER_VEHICLE) return;
		if (!(e.getPlayer().getVehicle() instanceof Mob)) return;
		if (e.getPlayer().getVehicle() == null) return;

		WrappedPacketInSteerVehicle vehiclePacket = new WrappedPacketInSteerVehicle(e.getNMSPacket());

		Player player = e.getPlayer();
		float forward = vehiclePacket.getForwardValue();
		boolean jump = vehiclePacket.isJump();

		Mob vehicle = (Mob) player.getVehicle();
		Location vehicleLocation = vehicle.getLocation().clone();

		if (jump) {
			vehicle.setJumping(true);
		}
		if (forward > 0) {

			AttributeInstance attribute = vehicle.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
			double speed  = (attribute == null) ? forward*2 : 0.6/attribute.getBaseValue();
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
