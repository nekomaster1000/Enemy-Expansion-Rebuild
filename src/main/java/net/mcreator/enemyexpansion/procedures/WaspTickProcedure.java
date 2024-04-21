package net.mcreator.enemyexpansion.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.enemyexpansion.init.EnemyexpansionModMobEffects;
import net.mcreator.enemyexpansion.entity.WaspEntity;

public class WaspTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(EnemyexpansionModMobEffects.SWIFT_FLIGHT.get())) {
			if (entity instanceof WaspEntity) {
				((WaspEntity) entity).setAnimation("sprint");
			}
		}
	}
}
