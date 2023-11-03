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

// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelsilverhat<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("enemyexpansion", "modelsilverhat"), "main");
	public final ModelPart head;

	public Modelsilverhat(ModelPart root) {
		this.head = root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.1F, -4.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.1F, 0.5F));
		PartDefinition silverhead = head.addOrReplaceChild("silverhead",
				CubeListBuilder.create().texOffs(0, 32).addBox(-6.0F, -6.0F, -4.5F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)).texOffs(0, 32).addBox(-6.0F, -6.0F, -4.5F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)),
				PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
		PartDefinition neck = silverhead.addOrReplaceChild("neck",
				CubeListBuilder.create().texOffs(0, 48).addBox(-5.0F, -3.0F, -4.2F, 10.0F, 6.0F, 4.0F, new CubeDeformation(0.5F)).texOffs(0, 15).addBox(-6.0F, -5.0F, 1.8F, 12.0F, 6.0F, 1.0F, new CubeDeformation(2.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, -4.0F, 0.3927F, 0.0F, 0.0F));
		PartDefinition head2 = neck.addOrReplaceChild("head2",
				CubeListBuilder.create().texOffs(0, 25).addBox(-6.0F, -4.0F, 1.5F, 12.0F, 5.0F, 1.0F, new CubeDeformation(1.0F)).texOffs(1, 59).addBox(-3.0F, -1.0F, -1.5F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.5F)),
				PartPose.offsetAndRotation(0.0F, 1.0F, -5.0F, 0.3927F, 0.0F, 0.0F));
		PartDefinition bodyback = silverhead.addOrReplaceChild("bodyback",
				CubeListBuilder.create().texOffs(32, 52).addBox(-5.0F, 0.5F, 0.5F, 10.0F, 6.0F, 6.0F, new CubeDeformation(0.5F)).texOffs(0, 15).addBox(-6.0F, -1.5F, 2.5F, 12.0F, 6.0F, 1.0F, new CubeDeformation(2.0F)),
				PartPose.offsetAndRotation(0.0F, -4.5F, 4.0F, -0.3927F, 0.0F, 0.0F));
		PartDefinition bodyback2 = bodyback.addOrReplaceChild("bodyback2",
				CubeListBuilder.create().texOffs(40, 44).addBox(-4.0F, 0.5F, 0.5F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.5F)).texOffs(0, 25).addBox(-6.0F, -1.5F, 1.5F, 12.0F, 5.0F, 1.0F, new CubeDeformation(1.0F)),
				PartPose.offsetAndRotation(0.0F, 2.0F, 7.0F, -0.3927F, 0.0F, 0.0F));
		PartDefinition bodyback3 = bodyback2.addOrReplaceChild("bodyback3",
				CubeListBuilder.create().texOffs(44, 38).addBox(-3.0F, 0.5F, 0.5F, 6.0F, 2.0F, 4.0F, new CubeDeformation(0.5F)).texOffs(0, 25).addBox(-6.0F, -2.5F, 0.5F, 12.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 2.0F, 5.0F, -0.3927F, 0.0F, 0.0F));
		PartDefinition bodytail = bodyback3.addOrReplaceChild("bodytail", CubeListBuilder.create().texOffs(52, 32).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.5F)),
				PartPose.offsetAndRotation(0.0F, 1.5F, 5.0F, -0.3927F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
