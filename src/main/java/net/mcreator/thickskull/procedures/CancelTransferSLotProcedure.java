package net.mcreator.thickskull.procedures;

import net.minecraft.client.gui.screens.Screen;

public class CancelTransferSLotProcedure {
	public static boolean execute() {
		if (Screen.hasShiftDown()) {
			return true;
		}
		return false;
	}
}