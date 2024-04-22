package net.mcreator.enemyexpansion.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.enemyexpansion.procedures.ExplosiveLaunchStartedProcedure;
import net.mcreator.enemyexpansion.procedures.ExplosiveLaunchHappensProcedure;
import net.mcreator.enemyexpansion.procedures.ExplosiveLaunchCountdownProcedure;

public class ExplosiveLaunchMobEffect extends MobEffect {
	public ExplosiveLaunchMobEffect() {
		super(MobEffectCategory.NEUTRAL, -30435);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		ExplosiveLaunchStartedProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ());
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		ExplosiveLaunchCountdownProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ());
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		ExplosiveLaunchHappensProcedure.execute(entity.level, entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
