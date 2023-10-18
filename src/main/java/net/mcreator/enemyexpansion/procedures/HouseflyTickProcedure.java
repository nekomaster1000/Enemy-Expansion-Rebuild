package net.mcreator.enemyexpansion.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.enemyexpansion.init.EnemyexpansionModMobEffects;

public class HouseflyTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.05) {
			if (!(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(EnemyexpansionModMobEffects.SWIFT_FLIGHT.get()) : false)) {
				entity.setDeltaMovement(new Vec3((Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (Mth.nextDouble(RandomSource.create(), -0.3, 0.25)), (Mth.nextDouble(RandomSource.create(), -0.5, 0.5))));
			}
		}
	}
}
