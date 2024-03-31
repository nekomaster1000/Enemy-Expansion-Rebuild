
package net.mcreator.enemyexpansion.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.enemyexpansion.entity.model.DirewolfModel;
import net.mcreator.enemyexpansion.entity.DirewolfEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class DirewolfRenderer extends GeoEntityRenderer<DirewolfEntity> {
	public DirewolfRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new DirewolfModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(DirewolfEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1.5f, 1.5f, 1.5f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
