package net.mcreator.enemyexpansion.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.enemyexpansion.entity.IntruderEntity;

public class IntruderModel extends AnimatedGeoModel<IntruderEntity> {
	@Override
	public ResourceLocation getAnimationResource(IntruderEntity entity) {
		return new ResourceLocation("enemyexpansion", "animations/intruder.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(IntruderEntity entity) {
		return new ResourceLocation("enemyexpansion", "geo/intruder.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(IntruderEntity entity) {
		return new ResourceLocation("enemyexpansion", "textures/entities/" + entity.getTexture() + ".png");
	}

}
