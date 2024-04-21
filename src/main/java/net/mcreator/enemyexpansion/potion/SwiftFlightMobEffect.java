package net.mcreator.enemyexpansion.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.enemyexpansion.procedures.SwiftFlightActiveProcedure;

public class SwiftFlightMobEffect extends MobEffect {
	public SwiftFlightMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -3342337);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		SwiftFlightActiveProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
