package net.mcreator.enemyexpansion.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.enemyexpansion.entity.HouseflyEntity;

public class HouseflyModel extends AnimatedGeoModel<HouseflyEntity> {
	@Override
	public ResourceLocation getAnimationResource(HouseflyEntity entity) {
		return new ResourceLocation("enemyexpansion", "animations/fly.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HouseflyEntity entity) {
		return new ResourceLocation("enemyexpansion", "geo/fly.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HouseflyEntity entity) {
		return new ResourceLocation("enemyexpansion", "textures/entities/" + entity.getTexture() + ".png");
	}

}
