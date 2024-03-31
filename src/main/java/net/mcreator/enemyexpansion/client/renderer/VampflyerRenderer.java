
package net.mcreator.enemyexpansion.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.enemyexpansion.entity.model.VampflyerModel;
import net.mcreator.enemyexpansion.entity.layer.VampflyerLayer;
import net.mcreator.enemyexpansion.entity.VampflyerEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class VampflyerRenderer extends GeoEntityRenderer<VampflyerEntity> {
	public VampflyerRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new VampflyerModel());
		this.shadowRadius = 0.5f;
		this.addLayer(new VampflyerLayer(this));
	}

	@Override
	public RenderType getRenderType(VampflyerEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}

	@Override
	protected float getDeathMaxRotation(VampflyerEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
