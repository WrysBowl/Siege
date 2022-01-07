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
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class MountSteer extends PacketListenerAbstract implements Listener {

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
