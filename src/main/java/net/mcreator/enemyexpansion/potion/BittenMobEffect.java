
package net.mcreator.enemyexpansion.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.enemyexpansion.procedures.BittenConversionProcedure;
import net.mcreator.enemyexpansion.procedures.BittenActiveProcedure;

public class BittenMobEffect extends MobEffect {
	public BittenMobEffect() {
		super(MobEffectCategory.HARMFUL, -12241793);
	}

	@Override
	public String getDescriptionId() {
		return "effect.enemyexpansion.bitten";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		BittenActiveProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		BittenConversionProcedure.execute(entity.level, entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
