package net.mcreator.enemyexpansion.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.enemyexpansion.entity.DirewolfEntity;

public class DirewolfModel extends AnimatedGeoModel<DirewolfEntity> {
	@Override
	public ResourceLocation getAnimationResource(DirewolfEntity entity) {
		return new ResourceLocation("enemyexpansion", "animations/direwolf.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DirewolfEntity entity) {
		return new ResourceLocation("enemyexpansion", "geo/direwolf.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DirewolfEntity entity) {
		return new ResourceLocation("enemyexpansion", "textures/entities/" + entity.getTexture() + ".png");
	}

}
