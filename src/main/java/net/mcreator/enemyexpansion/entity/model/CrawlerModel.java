package net.mcreator.enemyexpansion.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.enemyexpansion.entity.CrawlerEntity;

public class CrawlerModel extends AnimatedGeoModel<CrawlerEntity> {
	@Override
	public ResourceLocation getAnimationResource(CrawlerEntity entity) {
		return new ResourceLocation("enemyexpansion", "animations/crawler.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrawlerEntity entity) {
		return new ResourceLocation("enemyexpansion", "geo/crawler.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrawlerEntity entity) {
		return new ResourceLocation("enemyexpansion", "textures/entities/" + entity.getTexture() + ".png");
	}

}
