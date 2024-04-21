package net.mcreator.enemyexpansion.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity;

public class IfNightOrUntamedProcedure {
	public static boolean execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return false;
		if (!(world instanceof Level _lvl0 && _lvl0.isDay()) && !(entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false)) {
			return true;
		}
		return false;
	}
}
