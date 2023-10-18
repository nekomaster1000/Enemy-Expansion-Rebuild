
package net.mcreator.enemyexpansion.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.enemyexpansion.entity.model.ScorpionModel;
import net.mcreator.enemyexpansion.entity.layer.ScorpionLayer;
import net.mcreator.enemyexpansion.entity.ScorpionEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class ScorpionRenderer extends GeoEntityRenderer<ScorpionEntity> {
	public ScorpionRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new ScorpionModel());
		this.shadowRadius = 0.5f;
		this.addLayer(new ScorpionLayer(this));
	}

	@Override
	public RenderType getRenderType(ScorpionEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
