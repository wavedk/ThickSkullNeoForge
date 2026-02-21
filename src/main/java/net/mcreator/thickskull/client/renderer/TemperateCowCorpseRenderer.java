package net.mcreator.thickskull.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.animation.KeyframeAnimation;

import net.mcreator.thickskull.entity.TemperateCowCorpseEntity;
import net.mcreator.thickskull.client.model.animations.deadtemperatecowAnimation;
import net.mcreator.thickskull.client.model.Modeldeadtemperatecow;

public class TemperateCowCorpseRenderer extends MobRenderer<TemperateCowCorpseEntity, LivingEntityRenderState, Modeldeadtemperatecow> {
	private TemperateCowCorpseEntity entity = null;

	public TemperateCowCorpseRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(Modeldeadtemperatecow.LAYER_LOCATION)), 0.4f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(TemperateCowCorpseEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
		if (this.model instanceof AnimatedModel) {
			((AnimatedModel) this.model).setEntity(entity);
		}
	}

	@Override
	public ResourceLocation getTextureLocation(LivingEntityRenderState state) {
		if (entity != null)
			return ResourceLocation.parse("thickskullneoforge:textures/entities/" + entity.getTexture() + ".png");
		return ResourceLocation.parse("thickskullneoforge:textures/entities/deadtemperatecow.png");
	}

	private static final class AnimatedModel extends Modeldeadtemperatecow {
		private TemperateCowCorpseEntity entity = null;
		private final KeyframeAnimation keyframeAnimation0;
		private final KeyframeAnimation keyframeAnimation1;

		public AnimatedModel(ModelPart root) {
			super(root);
			this.keyframeAnimation0 = deadtemperatecowAnimation.drag.bake(root);
			this.keyframeAnimation1 = deadtemperatecowAnimation.die.bake(root);
		}

		public void setEntity(TemperateCowCorpseEntity entity) {
			this.entity = entity;
		}

		@Override
		public void setupAnim(LivingEntityRenderState state) {
			this.root().getAllParts().forEach(ModelPart::resetPose);
			this.keyframeAnimation0.apply(entity.animationState0, state.ageInTicks, 1f);
			this.keyframeAnimation1.apply(entity.animationState1, state.ageInTicks, 1f);
			super.setupAnim(state);
		}
	}
}