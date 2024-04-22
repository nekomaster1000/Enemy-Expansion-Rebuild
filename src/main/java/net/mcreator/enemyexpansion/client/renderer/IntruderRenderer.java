
package net.mcreator.enemyexpansion.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.enemyexpansion.entity.model.IntruderModel;
import net.mcreator.enemyexpansion.entity.IntruderEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class IntruderRenderer extends GeoEntityRenderer<IntruderEntity> {
	public IntruderRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new IntruderModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(IntruderEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1.5f, 1.5f, 1.5f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
