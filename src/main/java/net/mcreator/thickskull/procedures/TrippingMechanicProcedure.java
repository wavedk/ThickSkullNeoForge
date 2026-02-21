package net.mcreator.thickskull.procedures;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.Minecraft;

import net.mcreator.thickskull.network.ThickskullneoforgeModVariables;
import net.mcreator.thickskull.network.PlayPlayerAnimationMessage;
import net.mcreator.thickskull.entity.TemperateCowCorpseEntity;
import net.mcreator.thickskull.configuration.MainConfigConfiguration;

import javax.annotation.Nullable;

@EventBusSubscriber
public class TrippingMechanicProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double distanceTravelled = 0;
		double motionY = 0;
		LocalPlayer player = Minecraft.getInstance().player;
		if (player == null)
			return;
		motionY = player.getDeltaMovement().y;
		motionY *= 20;
		motionY = Math.round(motionY);
		if (MainConfigConfiguration.TRIPPING_ENABLED.get() == true) {
			if (entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).sinceTripped > 0) {
				{
					ThickskullneoforgeModVariables.PlayerVariables _vars = entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES);
					_vars.sinceTripped = entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).sinceTripped - 1;
					_vars.markSyncDirty();
				}
				if (entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).sinceTripped == 0) {
					if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.SCALE))
						_livingEntity1.getAttribute(Attributes.SCALE).setBaseValue(1);
					{
						ThickskullneoforgeModVariables.PlayerVariables _vars = entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES);
						_vars.canMoveAfterTripped = true;
						_vars.markSyncDirty();
					}
				}
			} else {
				if (entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).tripping_timer == 0) {
					{
						ThickskullneoforgeModVariables.PlayerVariables _vars = entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES);
						_vars.tripping_timer = Mth.nextInt(RandomSource.create(), (int) (double) MainConfigConfiguration.TRIPPING_TIMER_MIN.get(), (int) (double) MainConfigConfiguration.TRIPPING_TIMER_MAX.get());
						_vars.markSyncDirty();
					}
				} else {
					if (entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).tripped_x != entity.getX() || entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).tripped_y != entity.getY()
							|| entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).tripped_z != entity.getZ()) {
						if (!(entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).tripping_timer == 1)) {
							{
								ThickskullneoforgeModVariables.PlayerVariables _vars = entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES);
								_vars.tripping_timer = entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).tripping_timer - 1;
								_vars.markSyncDirty();
							}
						}
						if (!world.isEmptyBlock(BlockPos.containing(x, y - 0.1, z)) && motionY == -2 && entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).tripping_timer == 1 && !(entity instanceof TemperateCowCorpseEntity)) {
							if (entity instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(Attributes.SCALE))
								_livingEntity10.getAttribute(Attributes.SCALE).setBaseValue(0.5);
							{
								ThickskullneoforgeModVariables.PlayerVariables _vars = entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES);
								_vars.tripping_timer = 0;
								_vars.canMoveAfterTripped = false;
								_vars.sinceTripped = 60;
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("You Tripped!"), true);
							if (entity instanceof Player) {
								if (entity.level().isClientSide()) {
									CompoundTag data = entity.getPersistentData();
									data.putString("PlayerCurrentAnimation", "thickskullneoforge:trip");
									data.putBoolean("OverrideCurrentAnimation", true);
									data.putBoolean("FirstPersonAnimation", true);
								} else {
									PacketDistributor.sendToPlayersInDimension((ServerLevel) entity.level(), new PlayPlayerAnimationMessage(entity.getId(), "thickskullneoforge:trip", true, true));
								}
							}
						}
					}
				}
			}
			if (entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).canMoveAfterTripped == true) {
				{
					ThickskullneoforgeModVariables.PlayerVariables _vars = entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES);
					_vars.tripped_x = entity.getX();
					_vars.tripped_y = entity.getY();
					_vars.tripped_z = entity.getZ();
					_vars.markSyncDirty();
				}
			}
		}
	}
}