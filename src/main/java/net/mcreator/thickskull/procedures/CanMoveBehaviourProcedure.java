package net.mcreator.thickskull.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.thickskull.network.ThickskullneoforgeModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CanMoveBehaviourProcedure {
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
		if (entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).canMoveAfterTripped == false) {
			if (entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).tripped_x != entity.getX() || entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).tripped_y != entity.getY()
					|| entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).tripped_z != entity.getZ()) {
				{
					Entity _ent = entity;
					_ent.teleportTo(entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).tripped_x, entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).tripped_y,
							entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).tripped_z);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).tripped_x, entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).tripped_y,
								entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).tripped_z, _ent.getYRot(), _ent.getXRot());
				}
			}
		}
	}
}