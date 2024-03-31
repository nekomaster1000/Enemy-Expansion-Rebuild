package net.mcreator.enemyexpansion.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.enemyexpansion.entity.VampireEntity;

public class VampireLandsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.HEALTH_BOOST) : false) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeAllEffects();
			if (entity instanceof VampireEntity) {
				((VampireEntity) entity).setAnimation("land");
			}
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 12, 4));
		}
	}
}
