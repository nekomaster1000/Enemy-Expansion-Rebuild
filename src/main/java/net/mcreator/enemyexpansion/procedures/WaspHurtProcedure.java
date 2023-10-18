package net.mcreator.enemyexpansion.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.enemyexpansion.init.EnemyexpansionModMobEffects;
import net.mcreator.enemyexpansion.entity.WaspEntity;
import net.mcreator.enemyexpansion.EnemyexpansionMod;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class WaspHurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(EnemyexpansionModMobEffects.SWIFT_FLIGHT.get());
		entity.setDeltaMovement(new Vec3((Mth.nextDouble(RandomSource.create(), -1.5, 1.5)), 0, (Mth.nextDouble(RandomSource.create(), -1.5, 1.5))));
		if (!entity.isOnFire()) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
						.collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof WaspEntity) {
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(EnemyexpansionModMobEffects.SWIFT_FLIGHT.get());
						entityiterator.setDeltaMovement(new Vec3((Mth.nextDouble(RandomSource.create(), -1.5, 1.5)), 0, (Mth.nextDouble(RandomSource.create(), -1.5, 1.5))));
						EnemyexpansionMod.queueServerWork((int) Mth.nextDouble(RandomSource.create(), 15, 25), () -> {
							if (entityiterator instanceof LivingEntity _entity)
								_entity.addEffect(new MobEffectInstance(EnemyexpansionModMobEffects.SWIFT_FLIGHT.get(), (int) Mth.nextDouble(RandomSource.create(), 40, 80), (int) Mth.nextDouble(RandomSource.create(), 0, 2), (false), (false)));
							if (entityiterator instanceof WaspEntity animatable)
								animatable.setTexture("wasp_hostile");
						});
					}
				}
			}
		}
	}
}
