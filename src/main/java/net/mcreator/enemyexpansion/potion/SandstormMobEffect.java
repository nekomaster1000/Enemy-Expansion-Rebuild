
package net.mcreator.enemyexpansion.potion;

import net.minecraftforge.client.extensions.common.IClientMobEffectExtensions;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;

import net.mcreator.enemyexpansion.procedures.SandstormActiveProcedure;

import com.mojang.blaze3d.vertex.PoseStack;

public class SandstormMobEffect extends MobEffect {
	public SandstormMobEffect() {
		super(MobEffectCategory.NEUTRAL, -13312);
	}

	@Override
	public String getDescriptionId() {
		return "effect.enemyexpansion.sandstorm";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		SandstormActiveProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ());
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public void initializeClient(java.util.function.Consumer<IClientMobEffectExtensions> consumer) {
		consumer.accept(new IClientMobEffectExtensions() {
			@Override
			public boolean isVisibleInInventory(MobEffectInstance effect) {
				return false;
			}

			@Override
			public boolean renderInventoryText(MobEffectInstance instance, EffectRenderingInventoryScreen<?> screen, PoseStack poseStack, int x, int y, int blitOffset) {
				return false;
			}

			@Override
			public boolean isVisibleInGui(MobEffectInstance effect) {
				return false;
			}
		});
	}
}
