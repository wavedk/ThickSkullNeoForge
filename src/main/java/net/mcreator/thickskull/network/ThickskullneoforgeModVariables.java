package net.mcreator.thickskull.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.ValueIOSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.TagValueInput;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.ProblemReporter;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;

import net.mcreator.thickskull.ThickskullneoforgeMod;

import java.util.function.Supplier;

@EventBusSubscriber
public class ThickskullneoforgeModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, ThickskullneoforgeMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		ThickskullneoforgeMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@SubscribeEvent
	public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			for (Entity entityiterator : player.level().players())
				if (entityiterator != player && entityiterator instanceof ServerPlayer playeriterator)
					PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(playeriterator.getData(PLAYER_VARIABLES), playeriterator.getId()));
			PacketDistributor.sendToPlayersInDimension(player.level(), new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES), player.getId()));
		}
	}

	@SubscribeEvent
	public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			for (Entity entityiterator : player.level().players())
				if (entityiterator != player && entityiterator instanceof ServerPlayer playeriterator)
					PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(playeriterator.getData(PLAYER_VARIABLES), playeriterator.getId()));
			PacketDistributor.sendToPlayersInDimension(player.level(), new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES), player.getId()));
		}
	}

	@SubscribeEvent
	public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			for (Entity entityiterator : player.level().players())
				if (entityiterator != player && entityiterator instanceof ServerPlayer playeriterator)
					PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(playeriterator.getData(PLAYER_VARIABLES), playeriterator.getId()));
			PacketDistributor.sendToPlayersInDimension(player.level(), new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES), player.getId()));
		}
	}

	@SubscribeEvent
	public static void onPlayerTickUpdateSyncPlayerVariables(PlayerTickEvent.Post event) {
		if (event.getEntity() instanceof ServerPlayer player && player.getData(PLAYER_VARIABLES)._syncDirty) {
			PacketDistributor.sendToPlayersInDimension(player.level(), new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES), player.getId()));
			player.getData(PLAYER_VARIABLES)._syncDirty = false;
		}
	}

	@SubscribeEvent
	public static void clonePlayer(PlayerEvent.Clone event) {
		PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
		PlayerVariables clone = new PlayerVariables();
		clone.max_health = original.max_health;
		clone.max_health_tick_timer = original.max_health_tick_timer;
		clone.tripping_timer = original.tripping_timer;
		clone.sinceTripped = original.sinceTripped;
		clone.tripped_z = original.tripped_z;
		clone.tripped_y = original.tripped_y;
		clone.tripped_x = original.tripped_x;
		clone.customInventorySlot9 = original.customInventorySlot9;
		clone.hotbarItem = original.hotbarItem;
		clone.inventoryCloseTickTimer = original.inventoryCloseTickTimer;
		clone.customInventorySlot2 = original.customInventorySlot2;
		clone.customInventorySlot1 = original.customInventorySlot1;
		clone.customInventorySlot4 = original.customInventorySlot4;
		clone.customInventorySlot3 = original.customInventorySlot3;
		clone.customInventorySlot6 = original.customInventorySlot6;
		clone.customInventorySlot5 = original.customInventorySlot5;
		clone.customInventorySlot8 = original.customInventorySlot8;
		clone.customInventorySlot7 = original.customInventorySlot7;
		clone.pressInventoryTimer = original.pressInventoryTimer;
		clone.justOpenedInventory = original.justOpenedInventory;
		clone.justClosedInventory = original.justClosedInventory;
		if (!event.isWasDeath()) {
			clone.canMoveAfterTripped = original.canMoveAfterTripped;
		}
		event.getEntity().setData(PLAYER_VARIABLES, clone);
	}

	public static class PlayerVariables implements ValueIOSerializable {
		boolean _syncDirty = false;
		public double max_health = 6.0;
		public double max_health_tick_timer = 1.0;
		public double tripping_timer = 0;
		public double sinceTripped = 0;
		public double tripped_z = 0;
		public double tripped_y = 0;
		public double tripped_x = 0;
		public boolean canMoveAfterTripped = true;
		public ItemStack customInventorySlot9 = ItemStack.EMPTY;
		public ItemStack hotbarItem = ItemStack.EMPTY;
		public double inventoryCloseTickTimer = 0;
		public ItemStack customInventorySlot2 = ItemStack.EMPTY;
		public ItemStack customInventorySlot1 = ItemStack.EMPTY;
		public ItemStack customInventorySlot4 = ItemStack.EMPTY;
		public ItemStack customInventorySlot3 = ItemStack.EMPTY;
		public ItemStack customInventorySlot6 = ItemStack.EMPTY;
		public ItemStack customInventorySlot5 = ItemStack.EMPTY;
		public ItemStack customInventorySlot8 = ItemStack.EMPTY;
		public ItemStack customInventorySlot7 = ItemStack.EMPTY;
		public double pressInventoryTimer = 0;
		public boolean justOpenedInventory = false;
		public boolean justClosedInventory = false;

		@Override
		public void serialize(ValueOutput output) {
			output.putDouble("max_health", max_health);
			output.putDouble("max_health_tick_timer", max_health_tick_timer);
			output.putDouble("tripping_timer", tripping_timer);
			output.putDouble("sinceTripped", sinceTripped);
			output.putDouble("tripped_z", tripped_z);
			output.putDouble("tripped_y", tripped_y);
			output.putDouble("tripped_x", tripped_x);
			output.putBoolean("canMoveAfterTripped", canMoveAfterTripped);
			output.store("customInventorySlot9", ItemStack.OPTIONAL_CODEC, customInventorySlot9);
			output.store("hotbarItem", ItemStack.OPTIONAL_CODEC, hotbarItem);
			output.putDouble("inventoryCloseTickTimer", inventoryCloseTickTimer);
			output.store("customInventorySlot2", ItemStack.OPTIONAL_CODEC, customInventorySlot2);
			output.store("customInventorySlot1", ItemStack.OPTIONAL_CODEC, customInventorySlot1);
			output.store("customInventorySlot4", ItemStack.OPTIONAL_CODEC, customInventorySlot4);
			output.store("customInventorySlot3", ItemStack.OPTIONAL_CODEC, customInventorySlot3);
			output.store("customInventorySlot6", ItemStack.OPTIONAL_CODEC, customInventorySlot6);
			output.store("customInventorySlot5", ItemStack.OPTIONAL_CODEC, customInventorySlot5);
			output.store("customInventorySlot8", ItemStack.OPTIONAL_CODEC, customInventorySlot8);
			output.store("customInventorySlot7", ItemStack.OPTIONAL_CODEC, customInventorySlot7);
			output.putDouble("pressInventoryTimer", pressInventoryTimer);
			output.putBoolean("justOpenedInventory", justOpenedInventory);
			output.putBoolean("justClosedInventory", justClosedInventory);
		}

		@Override
		public void deserialize(ValueInput input) {
			max_health = input.getDoubleOr("max_health", 0);
			max_health_tick_timer = input.getDoubleOr("max_health_tick_timer", 0);
			tripping_timer = input.getDoubleOr("tripping_timer", 0);
			sinceTripped = input.getDoubleOr("sinceTripped", 0);
			tripped_z = input.getDoubleOr("tripped_z", 0);
			tripped_y = input.getDoubleOr("tripped_y", 0);
			tripped_x = input.getDoubleOr("tripped_x", 0);
			canMoveAfterTripped = input.getBooleanOr("canMoveAfterTripped", false);
			customInventorySlot9 = input.read("customInventorySlot9", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
			hotbarItem = input.read("hotbarItem", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
			inventoryCloseTickTimer = input.getDoubleOr("inventoryCloseTickTimer", 0);
			customInventorySlot2 = input.read("customInventorySlot2", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
			customInventorySlot1 = input.read("customInventorySlot1", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
			customInventorySlot4 = input.read("customInventorySlot4", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
			customInventorySlot3 = input.read("customInventorySlot3", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
			customInventorySlot6 = input.read("customInventorySlot6", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
			customInventorySlot5 = input.read("customInventorySlot5", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
			customInventorySlot8 = input.read("customInventorySlot8", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
			customInventorySlot7 = input.read("customInventorySlot7", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
			pressInventoryTimer = input.getDoubleOr("pressInventoryTimer", 0);
			justOpenedInventory = input.getBooleanOr("justOpenedInventory", false);
			justClosedInventory = input.getBooleanOr("justClosedInventory", false);
		}

		public void markSyncDirty() {
			_syncDirty = true;
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data, int player) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(ThickskullneoforgeMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> {
			TagValueOutput output = TagValueOutput.createWithoutContext(ProblemReporter.DISCARDING);
			message.data.serialize(output);
			buffer.writeInt(message.player());
			buffer.writeNbt(output.buildResult());
		}, (RegistryFriendlyByteBuf buffer) -> {
			PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables(), buffer.readInt());
			message.data.deserialize(TagValueInput.create(ProblemReporter.DISCARDING, buffer.registryAccess(), buffer.readNbt()));
			return message;
		});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> {
					Entity player = context.player().level().getEntity(message.player);
					if (player == null)
						return;
					TagValueOutput output = TagValueOutput.createWithContext(ProblemReporter.DISCARDING, context.player().registryAccess());
					message.data.serialize(output);
					player.getData(PLAYER_VARIABLES).deserialize(TagValueInput.create(ProblemReporter.DISCARDING, context.player().registryAccess(), output.buildResult()));
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}