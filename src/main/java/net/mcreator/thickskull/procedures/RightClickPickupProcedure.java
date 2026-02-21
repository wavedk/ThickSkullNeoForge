package net.mcreator.thickskull.procedures;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.client.network.ClientPacketDistributor;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;

import net.mcreator.thickskull.ThickskullneoforgeMod;

import javax.annotation.Nullable;

@EventBusSubscriber(Dist.CLIENT)
public class RightClickPickupProcedure {
	@SubscribeEvent
	public static void onRightClick(PlayerInteractEvent.RightClickEmpty event) {
		if (event.getHand() != InteractionHand.MAIN_HAND)
			return;
		ClientPacketDistributor.sendToServer(new RightClickPickupMessage());
		execute(event.getEntity());
	}

	@EventBusSubscriber
	public record RightClickPickupMessage() implements CustomPacketPayload {
		public static final Type<RightClickPickupMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(ThickskullneoforgeMod.MODID, "procedure_right_click_pickup"));
		public static final StreamCodec<RegistryFriendlyByteBuf, RightClickPickupMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, RightClickPickupMessage message) -> {
		}, (RegistryFriendlyByteBuf buffer) -> new RightClickPickupMessage());

		@Override
		public Type<RightClickPickupMessage> type() {
			return TYPE;
		}

		public static void handleData(final RightClickPickupMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.SERVERBOUND) {
				context.enqueueWork(() -> {
					if (!context.player().level().hasChunkAt(context.player().blockPosition()))
						return;
					execute(context.player());
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}

		@SubscribeEvent
		public static void registerMessage(FMLCommonSetupEvent event) {
			ThickskullneoforgeMod.addNetworkMessage(RightClickPickupMessage.TYPE, RightClickPickupMessage.STREAM_CODEC, RightClickPickupMessage::handleData);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		PickupMechanicProcedure.execute(entity);
	}
}