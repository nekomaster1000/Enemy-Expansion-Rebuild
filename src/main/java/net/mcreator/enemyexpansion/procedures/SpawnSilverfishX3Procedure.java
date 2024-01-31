package net.mcreator.enemyexpansion.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.enemyexpansion.EnemyexpansionMod;

public class SpawnSilverfishX3Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		for (int index0 = 0; index0 < (int) (9); index0++) {
			EnemyexpansionMod.queueServerWork((int) Mth.nextDouble(RandomSource.create(), 5, 60), () -> {
				if (world instanceof ServerLevel _serverLevelForEntitySpawn) {
					Entity _entityForSpawning = new Silverfish(EntityType.SILVERFISH, _serverLevelForEntitySpawn);
					_entityForSpawning.moveTo((entity.getX()), (entity.getY()), (entity.getZ()), world.getRandom().nextFloat() * 360F, 0);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.POOF, (entity.getX()), (entity.getY()), (entity.getZ()), 1, 0.5, 0.5, 0.5, 0.3);
					EnemyexpansionMod.queueServerWork((int) Mth.nextDouble(RandomSource.create(), 200, 400), () -> {
						_entityForSpawning.hurt((new DamageSource("even_more_magic")), 20);
					});
					if (_entityForSpawning instanceof Mob _mobForSpawning)
						_mobForSpawning.finalizeSpawn(_serverLevelForEntitySpawn, world.getCurrentDifficultyAt(_entityForSpawning.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(_entityForSpawning);
				}
			});
		}
	}
}