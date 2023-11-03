package net.mcreator.enemyexpansion.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.enemyexpansion.init.EnemyexpansionModMobEffects;

public class BittenActiveProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof Level _lvl && _lvl.isDay()) {
			if (world.canSeeSkyFromBelowWater(new BlockPos(x, y, z))) {
				if (world.getMaxLocalRawBrightness(new BlockPos(x, y, z)) > 12) {
					if (!entity.isInWaterRainOrBubble()) {
						entity.setSecondsOnFire(
								(int) (5 * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnemyexpansionModMobEffects.BITTEN.get()) ? _livEnt.getEffect(EnemyexpansionModMobEffects.BITTEN.get()).getAmplifier() : 0) + 1)));
					}
				}
			}
		}
	}
}
