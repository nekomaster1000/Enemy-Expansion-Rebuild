package net.mcreator.enemyexpansion.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.enemyexpansion.entity.EquestrianEntity;
import net.mcreator.enemyexpansion.EnemyexpansionMod;

public class EquestrianHurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof EquestrianEntity animatable)
			animatable.setTexture("equestrian_panicked");
		if (Math.random() < 0.2) {
			EquestrianReinforcementsProcedure.execute(world, x, y, z, entity, sourceentity);
		}
		if (entity instanceof EquestrianEntity) {
			((EquestrianEntity) entity).setAnimation("panicked");
		}
		if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 110, 0, false, false));
		EnemyexpansionMod.queueServerWork(111, () -> {
			if (!(entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(MobEffects.MOVEMENT_SLOWDOWN))) {
				if (entity instanceof EquestrianEntity animatable)
					animatable.setTexture("equestrian");
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.ANGRY_VILLAGER, (entity.getX()), (entity.getY()), (entity.getZ()), 5, 1, 1, 1, 0.6);
			}
		});
	}
}
