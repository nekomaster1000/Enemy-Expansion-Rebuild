
package net.mcreator.enemyexpansion.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.enemyexpansion.entity.model.FlutterflyModel;
import net.mcreator.enemyexpansion.entity.FlutterflyEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class FlutterflyRenderer extends GeoEntityRenderer<FlutterflyEntity> {
	public FlutterflyRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new FlutterflyModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(FlutterflyEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
