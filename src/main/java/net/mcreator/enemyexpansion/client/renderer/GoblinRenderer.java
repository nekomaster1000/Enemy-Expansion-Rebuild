
package net.mcreator.enemyexpansion.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.enemyexpansion.entity.model.GoblinModel;
import net.mcreator.enemyexpansion.entity.layer.GoblinLayer;
import net.mcreator.enemyexpansion.entity.GoblinEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class GoblinRenderer extends GeoEntityRenderer<GoblinEntity> {
	public GoblinRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new GoblinModel());
		this.shadowRadius = 0.5f;
		this.addLayer(new GoblinLayer(this));
	}

	@Override
	public RenderType getRenderType(GoblinEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
