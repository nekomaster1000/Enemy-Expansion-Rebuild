package net.mcreator.enemyexpansion.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.enemyexpansion.init.EnemyexpansionModMobEffects;

public class GoblinFearTimerProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(EnemyexpansionModMobEffects.DESPAWNER.get(), 20, 0, (false), (false)));
	}
}
