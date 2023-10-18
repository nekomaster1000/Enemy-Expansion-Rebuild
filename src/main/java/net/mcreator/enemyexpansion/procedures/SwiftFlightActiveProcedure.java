package net.mcreator.enemyexpansion.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.enemyexpansion.init.EnemyexpansionModMobEffects;

public class SwiftFlightActiveProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setDeltaMovement(new Vec3(
				(((Math.sin(Math.toRadians(0 - entity.getYRot())) + 0)
						* (1 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnemyexpansionModMobEffects.SWIFT_FLIGHT.get()) ? _livEnt.getEffect(EnemyexpansionModMobEffects.SWIFT_FLIGHT.get()).getAmplifier() : 0))) / 5),
				((Math.sin(Math.toRadians(0 - entity.getXRot())) + 0)
						* (3 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnemyexpansionModMobEffects.SWIFT_FLIGHT.get()) ? _livEnt.getEffect(EnemyexpansionModMobEffects.SWIFT_FLIGHT.get()).getAmplifier() : 0))),
				(((Math.cos(Math.toRadians(0 - entity.getYRot())) + 0)
						* (1 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnemyexpansionModMobEffects.SWIFT_FLIGHT.get()) ? _livEnt.getEffect(EnemyexpansionModMobEffects.SWIFT_FLIGHT.get()).getAmplifier() : 0))) / 5)));
	}
}
