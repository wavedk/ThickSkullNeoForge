package net.mcreator.thickskull.client.model;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelleather_pouch extends EntityModel<LivingEntityRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("thickskullneoforge", "modelleather_pouch"), "main");
	public final ModelPart everything;
	public final ModelPart body;
	public final ModelPart straps;
	public final ModelPart lid;
	public final ModelPart lidhook;

	public Modelleather_pouch(ModelPart root) {
		super(root);
		this.everything = root.getChild("everything");
		this.body = this.everything.getChild("body");
		this.straps = this.everything.getChild("straps");
		this.lid = this.everything.getChild("lid");
		this.lidhook = this.lid.getChild("lidhook");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition body = everything.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -10.0F, -7.0F, 10.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 0.0F, 2.0F));
		PartDefinition straps = everything.addOrReplaceChild("straps",
				CubeListBuilder.create().texOffs(18, 22).addBox(-4.0F, -1.225F, 0.25F, 2.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(0, 22).addBox(2.0F, -1.225F, 0.25F, 2.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -8.775F, 0.75F));
		PartDefinition lid = everything.addOrReplaceChild("lid", CubeListBuilder.create(), PartPose.offset(0.0F, -9.975F, 0.95F));
		PartDefinition cube_r1 = lid.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 16).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -0.125F, -0.95F, -0.1047F, 0.0F, 0.0F));
		PartDefinition lidhook = lid.addOrReplaceChild("lidhook", CubeListBuilder.create(), PartPose.offset(0.0F, -0.6F, -5.9F));
		PartDefinition cube_r2 = lidhook.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(32, 0).addBox(-1.0F, -2.0F, 1.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.8F, -1.3F, -0.1309F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public void setupAnim(LivingEntityRenderState state) {
		float limbSwing = state.walkAnimationPos;
		float limbSwingAmount = state.walkAnimationSpeed;
		float ageInTicks = state.ageInTicks;
		float netHeadYaw = state.yRot;
		float headPitch = state.xRot;

	}
}