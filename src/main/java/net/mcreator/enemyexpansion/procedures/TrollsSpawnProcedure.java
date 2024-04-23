package net.mcreator.enemyexpansion.procedures;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.enemyexpansion.init.EnemyexpansionModMobEffects;
import net.mcreator.enemyexpansion.entity.TrollenragedEntity;
import net.mcreator.enemyexpansion.entity.TrollEntity;

public class TrollsSpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof TrollEntity) {
			((TrollEntity) entity).getAttribute(ForgeMod.SWIM_SPEED.get()).setBaseValue(5.5);
		} else if (entity instanceof TrollenragedEntity) {
			((TrollenragedEntity) entity).getAttribute(ForgeMod.SWIM_SPEED.get()).setBaseValue(7.5);
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(EnemyexpansionModMobEffects.METAMORPHOSIS.get(), 200, 0, false, false));
		}
	}
}
