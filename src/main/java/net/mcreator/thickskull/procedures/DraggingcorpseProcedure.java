package net.mcreator.thickskull.procedures;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.Minecraft;

import net.mcreator.thickskull.network.PlayPlayerAnimationMessage;
import net.mcreator.thickskull.entity.TemperateCowCorpseEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class DraggingcorpseProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		double playerSpeed = 0;
		LocalPlayer player = Minecraft.getInstance().player;
		if (player == null)
			return;
		double motionX = player.getDeltaMovement().x;
		double motionZ = player.getDeltaMovement().z;
		double horizontalSpeed = Math.sqrt(motionX * motionX + motionZ * motionZ);
		horizontalSpeed *= 20;
		playerSpeed = horizontalSpeed;
		if ((entity.getVehicle()) instanceof TemperateCowCorpseEntity) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("" + playerSpeed)), false);
			if (playerSpeed > 0) {
				if (entity instanceof Player ? entity.getPersistentData().getStringOr("PlayerCurrentAnimation", "").equals("thickskullneoforge:dragstill") : false) {
					if (entity instanceof Player) {
						if (entity.level().isClientSide()) {
							CompoundTag data = entity.getPersistentData();
							data.remove("PlayerCurrentAnimation");
							data.remove("PlayerAnimationProgress");
							data.putBoolean("ResetPlayerAnimation", true);
							data.putBoolean("FirstPersonAnimation", false);
						} else {
							PacketDistributor.sendToPlayersInDimension((ServerLevel) entity.level(), new PlayPlayerAnimationMessage(entity.getId(), "", false, false));
						}
					}
				}
				if (entity instanceof Player) {
					if (entity.level().isClientSide()) {
						CompoundTag data = entity.getPersistentData();
						data.putString("PlayerCurrentAnimation", "thickskullneoforge:dragwalk");
						data.putBoolean("OverrideCurrentAnimation", false);
						data.putBoolean("FirstPersonAnimation", true);
					} else {
						PacketDistributor.sendToPlayersInDimension((ServerLevel) entity.level(), new PlayPlayerAnimationMessage(entity.getId(), "thickskullneoforge:dragwalk", false, true));
					}
				}
			} else {
				if (entity instanceof Player ? entity.getPersistentData().getStringOr("PlayerCurrentAnimation", "").equals("thickskullneoforge:dragwalk") : false) {
					if (entity instanceof Player) {
						if (entity.level().isClientSide()) {
							CompoundTag data = entity.getPersistentData();
							data.remove("PlayerCurrentAnimation");
							data.remove("PlayerAnimationProgress");
							data.putBoolean("ResetPlayerAnimation", true);
							data.putBoolean("FirstPersonAnimation", false);
						} else {
							PacketDistributor.sendToPlayersInDimension((ServerLevel) entity.level(), new PlayPlayerAnimationMessage(entity.getId(), "", false, false));
						}
					}
				}
				if (entity instanceof Player) {
					if (entity.level().isClientSide()) {
						CompoundTag data = entity.getPersistentData();
						data.putString("PlayerCurrentAnimation", "thickskullneoforge:dragstill");
						data.putBoolean("OverrideCurrentAnimation", false);
						data.putBoolean("FirstPersonAnimation", true);
					} else {
						PacketDistributor.sendToPlayersInDimension((ServerLevel) entity.level(), new PlayPlayerAnimationMessage(entity.getId(), "thickskullneoforge:dragstill", false, true));
					}
				}
			}
		} else {
			if ((entity instanceof Player ? entity.getPersistentData().getStringOr("PlayerCurrentAnimation", "").equals("thickskullneoforge:dragwalk") : false)
					|| (entity instanceof Player ? entity.getPersistentData().getStringOr("PlayerCurrentAnimation", "").equals("thickskullneoforge:dragstill") : false)) {
				if (entity instanceof Player) {
					if (entity.level().isClientSide()) {
						CompoundTag data = entity.getPersistentData();
						data.remove("PlayerCurrentAnimation");
						data.remove("PlayerAnimationProgress");
						data.putBoolean("ResetPlayerAnimation", true);
						data.putBoolean("FirstPersonAnimation", false);
					} else {
						PacketDistributor.sendToPlayersInDimension((ServerLevel) entity.level(), new PlayPlayerAnimationMessage(entity.getId(), "", false, false));
					}
				}
			}
		}
	}
}