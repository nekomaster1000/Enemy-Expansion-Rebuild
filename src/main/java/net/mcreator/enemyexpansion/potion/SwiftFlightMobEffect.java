
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
	public String getDescriptionId() {
		return "effect.enemyexpansion.swift_flight";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		SwiftFlightActiveProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
