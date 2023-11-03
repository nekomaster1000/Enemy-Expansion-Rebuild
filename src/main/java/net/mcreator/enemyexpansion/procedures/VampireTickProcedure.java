package net.mcreator.enemyexpansion.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.enemyexpansion.init.EnemyexpansionModEntities;
import net.mcreator.enemyexpansion.entity.VampireEntity;
import net.mcreator.enemyexpansion.entity.VampflyerEntity;
import net.mcreator.enemyexpansion.EnemyexpansionMod;

public class VampireTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.isInWater()) {
			EnemyexpansionMod.queueServerWork(1, () -> {
				if (entity.isAlive()) {
					if (world instanceof ServerLevel _serverLevelForEntitySpawn) {
						Entity _entityForSpawning = new VampflyerEntity(EnemyexpansionModEntities.VAMPFLYER.get(), _serverLevelForEntitySpawn);
						_entityForSpawning.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
						if (!entity.level.isClientSide())
							entity.discard();
						_entityForSpawning.setDeltaMovement(new Vec3((Mth.nextDouble(RandomSource.create(), -2, 2)), 0.5, (Mth.nextDouble(RandomSource.create(), -2, 2))));
						EnemyexpansionMod.queueServerWork(200, () -> {
							if (_entityForSpawning.isAlive()) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = new VampireEntity(EnemyexpansionModEntities.VAMPIRE.get(), _level);
									entityToSpawn.moveTo((_entityForSpawning.getX()), (_entityForSpawning.getY()), (_entityForSpawning.getZ()), 0, 0);
									entityToSpawn.setYBodyRot(0);
									entityToSpawn.setYHeadRot(0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob _mobToSpawn)
										_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
									world.addFreshEntity(entityToSpawn);
								}
								if (!_entityForSpawning.level.isClientSide())
									_entityForSpawning.discard();
							}
						});
						if (_entityForSpawning instanceof Mob _mobForSpawning)
							_mobForSpawning.finalizeSpawn(_serverLevelForEntitySpawn, world.getCurrentDifficultyAt(_entityForSpawning.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						world.addFreshEntity(_entityForSpawning);
					}
				}
			});
		}
	}
}
