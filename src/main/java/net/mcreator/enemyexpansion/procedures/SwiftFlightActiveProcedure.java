package net.mcreator.enemyexpansion.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.enemyexpansion.init.EnemyexpansionModMobEffects;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class SwiftFlightActiveProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double division = 0;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (entity.getY() > entityiterator.getY()) {
					division = -0.2;
				} else if (entity.getY() < entityiterator.getY()) {
					division = 0.2;
				}
				if (entityiterator instanceof LivingEntity) {
					entity.setDeltaMovement(new Vec3(
							(((Math.sin(Math.toRadians(0 - entity.getYRot())) + 0)
									* (1 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnemyexpansionModMobEffects.SWIFT_FLIGHT.get()) ? _livEnt.getEffect(EnemyexpansionModMobEffects.SWIFT_FLIGHT.get()).getAmplifier() : 0))) / 5),
							division, (((Math.cos(Math.toRadians(0 - entity.getYRot())) + 0)
									* (1 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnemyexpansionModMobEffects.SWIFT_FLIGHT.get()) ? _livEnt.getEffect(EnemyexpansionModMobEffects.SWIFT_FLIGHT.get()).getAmplifier() : 0))) / 5)));
				}
			}
		}
	}
}
