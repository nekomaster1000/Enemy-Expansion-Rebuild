package net.mcreator.enemyexpansion.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.enemyexpansion.init.EnemyexpansionModMobEffects;
import net.mcreator.enemyexpansion.entity.VampflyerEntity;
import net.mcreator.enemyexpansion.EnemyexpansionMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class VampflyerHurtProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity(), event.getSource().getDirectEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		execute(null, world, entity, immediatesourceentity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		if (entity instanceof VampflyerEntity) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(EnemyexpansionModMobEffects.SWIFT_FLIGHT.get());
			entity.setDeltaMovement(new Vec3((Mth.nextDouble(RandomSource.create(), -1.5, 1.5)), (Mth.nextInt(RandomSource.create(), (int) (-0.1), (int) 0.1)), (Mth.nextDouble(RandomSource.create(), -1.5, 1.5))));
			if (entity instanceof VampflyerEntity) {
				((VampflyerEntity) entity).setAnimation("swiftflight");
			}
			EnemyexpansionMod.queueServerWork((int) Mth.nextDouble(RandomSource.create(), 15, 25), () -> {
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(EnemyexpansionModMobEffects.SWIFT_FLIGHT.get(), (int) Mth.nextDouble(RandomSource.create(), 40, 80), (int) Mth.nextDouble(RandomSource.create(), 0, 2), false, false));
			});
		} else if (sourceentity instanceof VampflyerEntity) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 11) {
				if (entity instanceof VampflyerEntity) {
					((VampflyerEntity) entity).setAnimation("spawn");
				}
			}
			if (sourceentity instanceof LivingEntity _entity)
				_entity.removeEffect(EnemyexpansionModMobEffects.SWIFT_FLIGHT.get());
			sourceentity.setDeltaMovement(new Vec3((Mth.nextDouble(RandomSource.create(), -1.5, 1.5)), (Mth.nextInt(RandomSource.create(), (int) (-0.1), (int) 0.1)), (Mth.nextDouble(RandomSource.create(), -1.5, 1.5))));
		}
		if (immediatesourceentity instanceof ThrownTrident) {
		}
	}
}
