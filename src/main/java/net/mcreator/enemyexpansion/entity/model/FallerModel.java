package net.mcreator.enemyexpansion.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.enemyexpansion.entity.FallerEntity;

public class FallerModel extends AnimatedGeoModel<FallerEntity> {
	@Override
	public ResourceLocation getAnimationResource(FallerEntity entity) {
		return new ResourceLocation("enemyexpansion", "animations/faller.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FallerEntity entity) {
		return new ResourceLocation("enemyexpansion", "geo/faller.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FallerEntity entity) {
		return new ResourceLocation("enemyexpansion", "textures/entities/" + entity.getTexture() + ".png");
	}

}
