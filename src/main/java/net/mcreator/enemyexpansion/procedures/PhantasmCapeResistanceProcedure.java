package net.mcreator.enemyexpansion.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.BlockPos;

public class PhantasmCapeResistanceProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getMaxLocalRawBrightness(new BlockPos(x, y + 1, z)) == 0) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 110, 2, (false), (false)));
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 110, 2, (false), (false)));
		} else if (world.getMaxLocalRawBrightness(new BlockPos(x, y + 1, z)) < 4) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 110, 1, (false), (false)));
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 110, 1, (false), (false)));
		} else if (world.getMaxLocalRawBrightness(new BlockPos(x, y + 1, z)) < 8) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 110, 0, (false), (false)));
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 110, 0, (false), (false)));
		}
	}
}
