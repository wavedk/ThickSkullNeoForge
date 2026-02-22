package net.mcreator.thickskull.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;

import net.mcreator.thickskull.procedures.OpenInventoryOnKeyReleasedProcedure;
import net.mcreator.thickskull.procedures.OpenInventoryOnKeyPressedProcedure;
import net.mcreator.thickskull.ThickskullneoforgeMod;

@EventBusSubscriber
public record OpenInventoryMessage(int eventType, int pressedms) implements CustomPacketPayload {
	public static final Type<OpenInventoryMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(ThickskullneoforgeMod.MODID, "key_open_inventory"));
	public static final StreamCodec<RegistryFriendlyByteBuf, OpenInventoryMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, OpenInventoryMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new OpenInventoryMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<OpenInventoryMessage> type() {
		return TYPE;
	}

	public static void handleData(final OpenInventoryMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				pressAction(context.player(), message.eventType, message.pressedms);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;
		if (type == 1) {

			OpenInventoryOnKeyReleasedProcedure.execute(world, x, y, z, entity);
		}
		if (type == 0) {

			OpenInventoryOnKeyPressedProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ThickskullneoforgeMod.addNetworkMessage(OpenInventoryMessage.TYPE, OpenInventoryMessage.STREAM_CODEC, OpenInventoryMessage::handleData);
	}
}