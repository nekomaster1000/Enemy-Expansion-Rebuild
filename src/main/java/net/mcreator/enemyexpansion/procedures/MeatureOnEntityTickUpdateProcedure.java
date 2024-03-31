package net.mcreator.enemyexpansion.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity;

public class MeatureOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.01) {
			if (world instanceof Level _lvl && _lvl.isDay()) {
				if (!(entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false)) {
					if (!entity.level.isClientSide())
						entity.discard();
				}
			}
		}
	}
}
