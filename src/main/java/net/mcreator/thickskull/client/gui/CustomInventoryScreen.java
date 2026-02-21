package net.mcreator.thickskull.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.thickskull.world.inventory.CustomInventoryMenu;
import net.mcreator.thickskull.procedures.ReturnPlayerModelForInventoryProcedure;
import net.mcreator.thickskull.init.ThickskullneoforgeModScreens;

public class CustomInventoryScreen extends AbstractContainerScreen<CustomInventoryMenu> implements ThickskullneoforgeModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;

	public CustomInventoryScreen(CustomInventoryMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("thickskullneoforge:textures/screens/custom_inventory.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (ReturnPlayerModelForInventoryProcedure.execute(entity) instanceof LivingEntity livingEntity) {
			InventoryScreen.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + -867, this.topPos + -928, this.leftPos + 1133, this.topPos + 1072, 30, -livingEntity.getBbHeight() / (2.0f * livingEntity.getScale()),
					0f + (float) Math.atan((this.leftPos + 133 - mouseX) / 40.0), (float) Math.atan((this.topPos + 23 - mouseY) / 40.0), livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("thickskullneoforge:textures/screens/inventorycharacterbackground.png"), this.leftPos + 107, this.topPos + 6, 0, 0, 51, 72, 51, 72);
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.thickskullneoforge.custom_inventory.label_your_inventory"), 6, 6, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}