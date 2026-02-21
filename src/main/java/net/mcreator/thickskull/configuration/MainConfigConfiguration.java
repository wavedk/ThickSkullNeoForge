package net.mcreator.thickskull.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

public class MainConfigConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;

	public static final ModConfigSpec.ConfigValue<Boolean> FORCE_ONE_SLOT;
	public static final ModConfigSpec.ConfigValue<Boolean> FORCE_RIGHT_CLICK_PICKUP;
	public static final ModConfigSpec.ConfigValue<Boolean> TRIPPING_ENABLED;
	public static final ModConfigSpec.ConfigValue<Double> TRIPPING_TIMER_MIN;
	public static final ModConfigSpec.ConfigValue<Double> TRIPPING_TIMER_MAX;
	static {
		BUILDER.push("inventory");
		FORCE_ONE_SLOT = BUILDER.comment("Forces you to have one hotbar slot. This will look broken as the hotbar texture only includes one hotbar slot.").define("force_one_slot", true);
		FORCE_RIGHT_CLICK_PICKUP = BUILDER.comment("Forces you to right click each dropped item to pick it up.").define("force_right_click_pickup", true);
		BUILDER.pop();
		BUILDER.push("tripping");
		TRIPPING_ENABLED = BUILDER.comment("Enables or Disables the Tripping mechanic.").define("enabled", true);
		TRIPPING_TIMER_MIN = BUILDER.comment("Sets the minimum amount of time that has to pass between each time you trip.").define("timer.min", (double) 300);
		TRIPPING_TIMER_MAX = BUILDER.comment("Sets the maximum amount of time that has to pass between each time you trip.").define("timer.max", (double) 6000);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}