// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelCustomModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "custommodel"), "main");
	private final ModelPart root;
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart leg0;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;

	public ModelCustomModel(ModelPart root) {
		this.root = root.getChild("root");
		this.head = this.root.getChild("head");
		this.body = this.root.getChild("body");
		this.leg0 = this.root.getChild("leg0");
		this.leg1 = this.root.getChild("leg1");
		this.leg2 = this.root.getChild("leg2");
		this.leg3 = this.root.getChild("leg3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, -1.0F));

		PartDefinition head = root.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(1, 33)
						.addBox(-3.0F, 1.0F, -7.0F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(22, 0)
						.addBox(-5.0F, -5.0F, -5.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(22, 0)
						.addBox(4.0F, -5.0F, -5.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -5.0F, -8.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(),
				PartPose.offset(0.0F, -19.0F, 2.0F));

		PartDefinition body_r1 = body.addOrReplaceChild("body_r1",
				CubeListBuilder.create().texOffs(52, 0)
						.addBox(-2.0F, -17.0F, -7.0F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(18, 4)
						.addBox(-6.0F, -29.0F, -6.0F, 12.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 13.0F, 19.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition leg0 = root.addOrReplaceChild("leg0", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-4.0F, -4.0F, 7.0F, 0.0F, 0.3491F, 0.0F));

		PartDefinition leg0_r1 = leg0.addOrReplaceChild("leg0_r1",
				CubeListBuilder.create().texOffs(0, 16).addBox(-6.0F, -12.0F, 4.0F, 4.0F, 12.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-11.0F, 6.0F, -6.0F, 0.0F, 0.0F, 1.3963F));

		PartDefinition leg1 = root.addOrReplaceChild("leg1",
				CubeListBuilder.create().texOffs(0, 16).mirror()
						.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(4.0F, -4.0F, 7.0F, 0.3491F, 0.0F, -1.3963F));

		PartDefinition leg2 = root.addOrReplaceChild("leg2",
				CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0F, -4.0F, -6.0F, -0.3491F, 0.0F, 1.3963F));

		PartDefinition leg3 = root.addOrReplaceChild("leg3", CubeListBuilder.create(),
				PartPose.offsetAndRotation(2.0F, -2.0F, -5.0F, -0.3491F, 0.0F, -1.5708F));

		PartDefinition leg3_r1 = leg3.addOrReplaceChild("leg3_r1",
				CubeListBuilder.create().texOffs(0, 16).mirror()
						.addBox(2.0F, -12.0F, -8.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-4.0F, 12.0F, 7.0F, 0.0F, 0.0F, 0.1745F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}