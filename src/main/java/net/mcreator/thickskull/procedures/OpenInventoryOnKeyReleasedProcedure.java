package net.mcreator.thickskull.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.thickskull.world.inventory.CustomInventoryMenu;
import net.mcreator.thickskull.network.ThickskullneoforgeModVariables;

import io.netty.buffer.Unpooled;

public class OpenInventoryOnKeyReleasedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean isGUIOpen = false;
		if ((entity instanceof Player _plr0 && _plr0.containerMenu instanceof CustomInventoryMenu) == true) {
			if (entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).inventoryCloseTickTimer < 1) {
				if (entity instanceof Player _player)
					_player.closeContainer();
			}
		} else {
			if (("" + Minecraft.getInstance().screen).equals("null")) {
				{
					ThickskullneoforgeModVariables.PlayerVariables _vars = entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES);
					_vars.inventoryCloseTickTimer = 4;
					_vars.markSyncDirty();
				}
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					_ent.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("CustomInventory");
						}

						@Override
						public boolean shouldTriggerClientSideContainerClosingOnOpen() {
							return false;
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new CustomInventoryMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		}
	}
}