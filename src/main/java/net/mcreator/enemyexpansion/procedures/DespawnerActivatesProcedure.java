package net.mcreator.enemyexpansion.procedures;

import net.minecraft.world.entity.Entity;

public class DespawnerActivatesProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!entity.level.isClientSide())
			entity.discard();
	}
}
