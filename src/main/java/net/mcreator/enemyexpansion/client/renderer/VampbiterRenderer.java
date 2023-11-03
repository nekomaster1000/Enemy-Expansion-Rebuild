
package net.mcreator.enemyexpansion.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.enemyexpansion.entity.model.VampbiterModel;
import net.mcreator.enemyexpansion.entity.layer.VampbiterLayer;
import net.mcreator.enemyexpansion.entity.VampbiterEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class VampbiterRenderer extends GeoEntityRenderer<VampbiterEntity> {
	public VampbiterRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new VampbiterModel());
		this.shadowRadius = 0.5f;
		this.addLayer(new VampbiterLayer(this));
	}

	@Override
	public RenderType getRenderType(VampbiterEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
