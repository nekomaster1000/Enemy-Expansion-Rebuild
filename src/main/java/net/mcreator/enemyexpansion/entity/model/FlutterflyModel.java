package net.mcreator.enemyexpansion.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.enemyexpansion.entity.FlutterflyEntity;

public class FlutterflyModel extends AnimatedGeoModel<FlutterflyEntity> {
	@Override
	public ResourceLocation getAnimationResource(FlutterflyEntity entity) {
		return new ResourceLocation("enemyexpansion", "animations/flutterfly.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FlutterflyEntity entity) {
		return new ResourceLocation("enemyexpansion", "geo/flutterfly.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FlutterflyEntity entity) {
		return new ResourceLocation("enemyexpansion", "textures/entities/" + entity.getTexture() + ".png");
	}

}
