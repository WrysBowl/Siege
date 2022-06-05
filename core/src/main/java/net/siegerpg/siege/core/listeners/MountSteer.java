package net.siegerpg.siege.core.listeners;

import de.tr7zw.nbtapi.NBTEntity;
import de.tr7zw.nbtapi.NBTList;
import io.github.retrooper.packetevents.event.PacketListenerAbstract;
import io.github.retrooper.packetevents.event.impl.PacketPlayReceiveEvent;
import io.github.retrooper.packetevents.packettype.PacketType;
import io.github.retrooper.packetevents.packetwrappers.play.in.steervehicle.WrappedPacketInSteerVehicle;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.types.misc.CustomMount;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.inventory.*;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

public class MountSteer extends PacketListenerAbstract implements Listener {

	public static HashMap<Player, Entity> cachedMounts = new HashMap<>();
	public static HashMap<Player, Long > currentCooldown = new HashMap<>();

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

		//if player is holding spawn egg when talking
		EntityType type = getSpawnEggType(item);
		if (type==null) return;

		//check if held spawn egg is a mount
		CustomItem customItem = CustomItemUtils.INSTANCE.getCustomItem(item);
		if (!(customItem instanceof CustomMount)) return;

		if (message.length() > 20) {
			player.sendMessage(Utils.lore("<red>That name is longer than 20 characters! Try 'Wrys' :)"));
			return;
		}

		if (message.contains("[item]")) return;

		CustomMount mount = ((CustomMount)customItem);
		mount.setName(message);
		mount.serialize();
		player.getInventory().setItemInMainHand(mount.getUpdatedItem(false));
		e.setCancelled(true);
	}

	public boolean isSpawnEgg(ItemStack item) {
		boolean containsSpawnEgg = false;

		if (item == null) return false;
		if (item.getType().toString().contains("_spawn_egg")) containsSpawnEgg = true;
		if (item.getType().toString().contains("_SPAWN_EGG")) containsSpawnEgg = true;

		return containsSpawnEgg;
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
		ItemStack item = e.getItem();

		if(!isSpawnEgg(item)) return;
		EntityType type = getSpawnEggType(item);
		if (type==null) return;
		//prevent player from spawning mob
		e.setCancelled(true);

		//if player is already on the mount
		if (cachedMounts.containsKey(player)) {
			Entity entity = cachedMounts.get(player);
			entity.remove();
			cachedMounts.remove(player);
			return;
		}

		//cooldown
		if (currentCooldown.containsKey(player)) {
			if ((System.currentTimeMillis() - currentCooldown.get(player)) >= 2500) {
				currentCooldown.put(player, System.currentTimeMillis());
			} else {
				player.sendMessage(Utils.lore("<red>Your mount is still on cooldown!"));
				return;
			}
		} else {
			currentCooldown.put(player, System.currentTimeMillis());
		}
		




		try {
			
			if (!e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;

			if (player.isSneaking()) {
				player.getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE,player.getLocation(),10);
				return;
			}

			String entityName = item.getItemMeta().getDisplayName();
			Entity entity = player.getWorld().spawnEntity(player.getLocation(), type);
			if (entity instanceof Ageable) ((Ageable)entity).setAdult();
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
		if (e instanceof EntityDamageByEntityEvent) {

			//prevent mount from damaging any entity
			if (((EntityDamageByEntityEvent) e).getDamager().equals(vehicle)) e.setCancelled(true);
		}
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

		Entity entity = player.getVehicle();
		if (entity == null) return;

		Mob vehicle = (Mob) player.getVehicle();
		Location vehicleLocation = vehicle.getLocation().clone();

		if (jump) {
			vehicle.setJumping(true);
		}
		if (forward > 0) {

			AttributeInstance attribute = vehicle.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
			double speed  = (attribute == null) ? forward*2 : 0.6/attribute.getBaseValue();
			if (speed < 1) speed = 1;
			Location targetLocation = vehicleLocation.add(player.getLocation().getDirection().multiply(vehicle.getWidth()*2));

			double finalSpeed = speed;

			new BukkitRunnable() {
				@Override
				public void run() {
					if (!vehicle.getPathfinder().hasPath() || vehicle instanceof Slime) {
						vehicle.setVelocity(player.getLocation().getDirection().setY(-1).multiply(0.5));
						NBTEntity nbt = new NBTEntity(entity);
						NBTList< Float > nbtList = nbt.getFloatList("Rotation");
						nbtList.set(0, (float)player.getLocation().getYaw());
					}
					vehicle.getPathfinder().moveTo(targetLocation, finalSpeed);
				}
			}.runTask(Core.plugin());

		}

	}
}
