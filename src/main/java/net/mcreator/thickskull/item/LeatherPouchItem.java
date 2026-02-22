package net.mcreator.thickskull.item;

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