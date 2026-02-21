package net.mcreator.thickskull.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.thickskull.network.ThickskullneoforgeModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class AwdProcedure {
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
		if ((getEntityGameType(entity) == GameType.SURVIVAL || getEntityGameType(entity) == GameType.ADVENTURE) && ("" + Minecraft.getInstance().screen).contains("net.minecraft.client.gui.screens.inventory")) {
			if (entity instanceof Player _player)
				_player.closeContainer();
		}
		if (entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).inventoryCloseTickTimer > 0) {
			{
				ThickskullneoforgeModVariables.PlayerVariables _vars = entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES);
				_vars.inventoryCloseTickTimer = Math.round(entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).inventoryCloseTickTimer - 1);
				_vars.markSyncDirty();
			}
		}
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}