package net.mcreator.thickskull.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.client.multiplayer.ClientLevel;

import net.mcreator.thickskull.procedures.LeatherPouchPropertyValueProviderProcedure;

import javax.annotation.Nullable;

import com.mojang.serialization.MapCodec;

public class LeatherPouchItem extends Item {
	public LeatherPouchItem(Item.Properties properties) {
		super(properties.rarity(Rarity.UNCOMMON).stacksTo(1));
	}

	public record OpenProperty() implements RangeSelectItemModelProperty {
		public static final MapCodec<OpenProperty> MAP_CODEC = MapCodec.unit(new OpenProperty());

		@Override
		public float get(ItemStack itemStackToRender, @Nullable ClientLevel clientWorld, @Nullable LivingEntity entity, int seed) {
			return (float) LeatherPouchPropertyValueProviderProcedure.execute();
		}

		@Override
		public MapCodec<OpenProperty> type() {
			return MAP_CODEC;
		}
	}
}