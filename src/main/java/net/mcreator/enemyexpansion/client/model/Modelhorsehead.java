package net.mcreator.enemyexpansion.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.6.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelhorsehead<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("enemyexpansion", "modelhorsehead"), "main");
	public final ModelPart all;

	public Modelhorsehead(ModelPart root) {
		this.all = root.getChild("all");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition all = partdefinition.addOrReplaceChild("all", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition reignsleft_r1 = all.addOrReplaceChild("reignsleft_r1",
				CubeListBuilder.create().texOffs(46, 24).mirror().addBox(0.0F, 0.1F, -8.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.1F)).mirror(false).texOffs(46, 24).addBox(7.0F, 0.1F, -8.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.1F)),
				PartPose.offsetAndRotation(-4.0F, -4.0F, -1.0F, 0.0436F, 0.0F, 0.0F));
		PartDefinition horsehead = all.addOrReplaceChild("horsehead",
				CubeListBuilder.create().texOffs(0, 8).addBox(-4.5F, -8.0F, -7.0F, 9.0F, 8.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(41, 17).addBox(-1.49F, -8.0F, 4.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.01F)).texOffs(0, 28)
						.addBox(-3.0F, -7.0F, -13.4F, 6.0F, 7.0F, 7.0F, new CubeDeformation(0.01F)).texOffs(26, 28).addBox(-3.0F, -7.0F, -13.4F, 6.0F, 7.0F, 7.0F, new CubeDeformation(0.11F)),
				PartPose.offsetAndRotation(0.0F, -5.75F, 1.0F, 0.5236F, 0.0F, 0.0F));
		PartDefinition earleft = horsehead.addOrReplaceChild("earleft", CubeListBuilder.create().texOffs(0, 12).mirror().addBox(-1.5F, -4.0F, 0.0F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(3.0F, -8.0F, 2.0F, 0.0F, 0.0F, 0.1745F));
		PartDefinition earright = horsehead.addOrReplaceChild("earright", CubeListBuilder.create().texOffs(0, 12).addBox(-1.5F, -4.0F, 0.0F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, -8.0F, 2.0F, 0.0F, 0.0F, -0.1745F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		all.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
