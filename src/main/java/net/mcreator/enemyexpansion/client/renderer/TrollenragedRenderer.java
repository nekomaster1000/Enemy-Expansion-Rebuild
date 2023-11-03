
package net.mcreator.enemyexpansion.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.enemyexpansion.entity.model.TrollenragedModel;
import net.mcreator.enemyexpansion.entity.layer.TrollenragedLayer;
import net.mcreator.enemyexpansion.entity.TrollenragedEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class TrollenragedRenderer extends GeoEntityRenderer<TrollenragedEntity> {
	public TrollenragedRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new TrollenragedModel());
		this.shadowRadius = 0.5f;
		this.addLayer(new TrollenragedLayer(this));
	}

	@Override
	public RenderType getRenderType(TrollenragedEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
