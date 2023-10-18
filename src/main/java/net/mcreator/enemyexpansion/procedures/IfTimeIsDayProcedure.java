package net.mcreator.enemyexpansion.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;

public class IfTimeIsDayProcedure {
	public static boolean execute(LevelAccessor world) {
		if (world instanceof Level _lvl && _lvl.isDay()) {
			return true;
		}
		return false;
	}
}
