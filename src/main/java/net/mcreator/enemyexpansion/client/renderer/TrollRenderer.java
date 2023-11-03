
package net.mcreator.enemyexpansion.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.enemyexpansion.entity.model.TrollModel;
import net.mcreator.enemyexpansion.entity.layer.TrollLayer;
import net.mcreator.enemyexpansion.entity.TrollEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class TrollRenderer extends GeoEntityRenderer<TrollEntity> {
	public TrollRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new TrollModel());
		this.shadowRadius = 0.5f;
		this.addLayer(new TrollLayer(this));
	}

	@Override
	public RenderType getRenderType(TrollEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
