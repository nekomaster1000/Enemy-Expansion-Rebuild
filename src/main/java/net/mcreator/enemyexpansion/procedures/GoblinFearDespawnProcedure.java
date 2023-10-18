package net.mcreator.enemyexpansion.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.enemyexpansion.EnemyexpansionMod;

public class GoblinFearDespawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		EnemyexpansionMod.queueServerWork(20, () -> {
			if (!entity.level.isClientSide())
				entity.discard();
		});
	}
}
