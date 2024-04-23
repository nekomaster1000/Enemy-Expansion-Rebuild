package net.mcreator.enemyexpansion.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.enemyexpansion.init.EnemyexpansionModMobEffects;
import net.mcreator.enemyexpansion.entity.VampireEntity;

public class VampireTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.isInWater()) {
			if (entity instanceof VampireEntity) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(EnemyexpansionModMobEffects.MORPHLOCKED.get());
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(EnemyexpansionModMobEffects.METAMORPHOSIS.get(), 10, 0, false, false));
			}
		}
	}
}
