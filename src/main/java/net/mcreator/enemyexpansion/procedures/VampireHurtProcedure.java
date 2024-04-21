package net.mcreator.enemyexpansion.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.enemyexpansion.init.EnemyexpansionModMobEffects;
import net.mcreator.enemyexpansion.init.EnemyexpansionModEntities;
import net.mcreator.enemyexpansion.entity.VampireEntity;
import net.mcreator.enemyexpansion.entity.VampflyerEntity;
import net.mcreator.enemyexpansion.entity.VampbiterEntity;
import net.mcreator.enemyexpansion.entity.GoblinFearEntity;
import net.mcreator.enemyexpansion.configuration.BetterConfigConfiguration;
import net.mcreator.enemyexpansion.EnemyexpansionMod;

public class VampireHurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof VampireEntity) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new GoblinFearEntity(EnemyexpansionModEntities.GOBLIN_FEAR.get(), _level);
				entityToSpawn.moveTo((x - 2), y, (z - 2), world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				_level.addFreshEntity(entityToSpawn);
			}
			VampireIgnitionProcedure.execute(world, x, y, z, entity);
			if (Math.random() < (double) BetterConfigConfiguration.VAMPIRETOFLYER.get() / 100) {
			} else if (Math.random() < (double) BetterConfigConfiguration.VAMPIRETOBITER.get() / 100) {
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(EnemyexpansionModMobEffects.DESPAWNER.get(), 2, 0, false, false));
			}
		} else if (entity instanceof VampflyerEntity) {
			VampireIgnitionProcedure.execute(world, x, y, z, entity);
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(EnemyexpansionModMobEffects.SWIFT_FLIGHT.get());
			entity.setDeltaMovement(new Vec3((Mth.nextDouble(RandomSource.create(), -1.5, 1.5)), (Mth.nextInt(RandomSource.create(), (int) (-0.1), (int) 0.1)), (Mth.nextDouble(RandomSource.create(), -1.5, 1.5))));
			EnemyexpansionMod.queueServerWork((int) Mth.nextDouble(RandomSource.create(), 15, 25), () -> {
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(EnemyexpansionModMobEffects.SWIFT_FLIGHT.get(), (int) Mth.nextDouble(RandomSource.create(), 40, 80), (int) Mth.nextDouble(RandomSource.create(), 0, 2), false, false));
			});
			if (Math.random() < (double) BetterConfigConfiguration.FLYERTOVAMPIRE.get() / 100) {
			} else if (Math.random() < (double) BetterConfigConfiguration.VAMPIRETOBITER.get() / 100) {
			}
		} else if (entity instanceof VampbiterEntity) {
			VampireIgnitionProcedure.execute(world, x, y, z, entity);
		}
	}
}
