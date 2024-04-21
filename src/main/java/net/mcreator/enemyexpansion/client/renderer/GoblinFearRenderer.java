package net.mcreator.enemyexpansion.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.SlimeModel;

import net.mcreator.enemyexpansion.entity.GoblinFearEntity;

public class GoblinFearRenderer extends MobRenderer<GoblinFearEntity, SlimeModel<GoblinFearEntity>> {
	public GoblinFearRenderer(EntityRendererProvider.Context context) {
		super(context, new SlimeModel(context.bakeLayer(ModelLayers.SLIME)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(GoblinFearEntity entity) {
		return new ResourceLocation("enemyexpansion:textures/entities/nothing.png");
	}
}
