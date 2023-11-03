
package net.mcreator.enemyexpansion.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.enemyexpansion.entity.model.VampireModel;
import net.mcreator.enemyexpansion.entity.layer.VampireLayer;
import net.mcreator.enemyexpansion.entity.VampireEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class VampireRenderer extends GeoEntityRenderer<VampireEntity> {
	public VampireRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new VampireModel());
		this.shadowRadius = 0.5f;
		this.addLayer(new VampireLayer(this));
	}

	@Override
	public RenderType getRenderType(VampireEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
