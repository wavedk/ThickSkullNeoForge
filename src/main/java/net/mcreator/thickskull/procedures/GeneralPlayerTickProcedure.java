package net.mcreator.thickskull.procedures;

import org.checkerframework.checker.units.qual.t;
import org.checkerframework.checker.units.qual.km;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.thickskull.world.inventory.CustomInventoryMenu;
import net.mcreator.thickskull.network.ThickskullneoforgeModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class GeneralPlayerTickProcedure {
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
		boolean keyPressed = false;
		String keybind = "";
		keybind = "thickskullneoforge.open_inventory";
		boolean pressed = false;
		if (pressed == false) {
			try {
				Class<?> mc;
				try {
					mc = Class.forName("net.minecraft.client.Minecraft");
				} catch (ClassNotFoundException e) {
					mc = Class.forName("net.minecraft.client.MinecraftClient");
				}
				Object inst = mc.getMethod("getInstance").invoke(null);
				Object opts;
				try {
					opts = mc.getField("options").get(inst);
				} catch (Throwable t) {
					opts = mc.getMethod("options").invoke(inst);
				}
				Object arr = null;
				for (String f : new String[]{"keyMappings", "allKeys", "keysAll"})
					try {
						arr = opts.getClass().getField(f).get(opts);
						break;
					} catch (Throwable ignored) {
					}
				if (arr != null)
					for (int i = 0, n = java.lang.reflect.Array.getLength(arr); i < n; i++) {
						Object km = java.lang.reflect.Array.get(arr, i);
						if (km == null)
							continue;
						String name = null;
						try {
							name = (String) km.getClass().getMethod("getName").invoke(km);
						} catch (Throwable t) {
							try {
								name = (String) km.getClass().getMethod("getTranslationKey").invoke(km);
							} catch (Throwable ignored) {
							}
						}
						if (name != null && (name.equals(keybind) || name.equals("key." + keybind))) {
							try {
								pressed = (boolean) km.getClass().getMethod("isDown").invoke(km);
							} catch (Throwable t) {
								pressed = (boolean) km.getClass().getMethod("isPressed").invoke(km);
							}
							break;
						}
					}
			} catch (Throwable ignored) {
			}
		}
		keyPressed = pressed;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal((entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).inventoryCloseTickTimer + "/" + entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).pressInventoryTimer)), false);
		if (keyPressed) {
			if (!entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).justClosedInventory) {
				if (8 > entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).pressInventoryTimer) {
					{
						ThickskullneoforgeModVariables.PlayerVariables _vars = entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES);
						_vars.pressInventoryTimer = entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).pressInventoryTimer + 1;
						_vars.markSyncDirty();
					}
				} else {
					if (!(entity instanceof Player _plr1 && _plr1.containerMenu instanceof CustomInventoryMenu)) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("0"), false);
						OpenInventoryOnKeyReleasedProcedure.execute(world, x, y, z, entity);
					}
				}
			}
		} else {
			{
				ThickskullneoforgeModVariables.PlayerVariables _vars = entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES);
				_vars.pressInventoryTimer = 0;
				_vars.markSyncDirty();
			}
		}
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