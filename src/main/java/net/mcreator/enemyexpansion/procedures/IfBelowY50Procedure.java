package net.mcreator.enemyexpansion.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.enemyexpansion.configuration.BetterConfigConfiguration;

public class IfBelowY50Procedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (world.getMaxLocalRawBrightness(new BlockPos(x, y, z)) <= 1) {
			if (y <= (double) BetterConfigConfiguration.CAVEMOBSPAWNDEPTH.get()) {
				return true;
			}
			return false;
		}
		return false;
	}
}
