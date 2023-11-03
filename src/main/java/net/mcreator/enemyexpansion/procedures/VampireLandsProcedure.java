package net.mcreator.enemyexpansion.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

import net.mcreator.enemyexpansion.entity.VampireEntity;

public class VampireLandsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.HEALTH_BOOST) : false) {
			if (entity instanceof VampireEntity) {
				((VampireEntity) entity).setAnimation("land");
			}
		}
	}
}
