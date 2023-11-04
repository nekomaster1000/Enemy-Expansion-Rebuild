package net.mcreator.enemyexpansion.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class IfCantSeeSkyProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!world.canSeeSkyFromBelowWater(new BlockPos(x, y, z))) {
			return true;
		}
		return false;
	}
}
