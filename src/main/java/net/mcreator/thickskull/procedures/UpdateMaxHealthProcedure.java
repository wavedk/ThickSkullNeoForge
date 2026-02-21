package net.mcreator.thickskull.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.thickskull.network.ThickskullneoforgeModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class UpdateMaxHealthProcedure {
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
		if (entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).max_health_tick_timer == 0) {
			if (entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
				_livingEntity0.getAttribute(Attributes.MAX_HEALTH).setBaseValue(entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).max_health);
			{
				ThickskullneoforgeModVariables.PlayerVariables _vars = entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES);
				_vars.max_health_tick_timer = entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).max_health_tick_timer + 1;
				_vars.markSyncDirty();
			}
		} else if (entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).max_health_tick_timer == 20) {
			{
				ThickskullneoforgeModVariables.PlayerVariables _vars = entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES);
				_vars.max_health_tick_timer = 0;
				_vars.markSyncDirty();
			}
		} else {
			{
				ThickskullneoforgeModVariables.PlayerVariables _vars = entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES);
				_vars.max_health_tick_timer = entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).max_health_tick_timer + 1;
				_vars.markSyncDirty();
			}
		}
	}
}