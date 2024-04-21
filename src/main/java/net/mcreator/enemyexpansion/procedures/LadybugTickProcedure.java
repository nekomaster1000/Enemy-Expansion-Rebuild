package net.mcreator.enemyexpansion.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.BlockPos;

import net.mcreator.enemyexpansion.entity.LadybugEntity;

public class LadybugTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == Blocks.AIR) {
			if (entity instanceof LadybugEntity) {
				((LadybugEntity) entity).setAnimation("fly");
			}
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 30, 0, false, false));
		}
	}
}
