package com.imesh97.megathings.entities;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class EntityDogModel<T extends EntityDog> extends EntityModel<T> {

    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer body_r1;
    private final ModelRenderer legBackLeft;
    private final ModelRenderer legBackRight;
    private final ModelRenderer legFrontLeft;
    private final ModelRenderer legFrontRight;

    public EntityDogModel() {
        textureWidth = 64;
        textureHeight = 32;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 13.5F, -7.0F);
        head.setTextureOffset(0, 0).addBox(-3.0F, -5.0F, -2.0F, 6.0F, 6.0F, 4.0F, 0.0F, false);
        head.setTextureOffset(16, 14).addBox(1.0F, -7.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(16, 14).addBox(-3.0F, -7.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(0, 10).addBox(-1.5F, -2.02F, -5.0F, 3.0F, 3.0F, 4.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 14.0F, 1.5F);
        body.setTextureOffset(9, 18).addBox(-1.0F, -2.0F, 7.5F, 2.0F, 8.0F, 2.0F, 0.0F, false);

        body_r1 = new ModelRenderer(this);
        body_r1.setRotationPoint(0.0F, -1.0F, 0.5F);
        body.addChild(body_r1);
        setRotationAngle(body_r1, -1.5708F, 0.0F, 0.0F);
        body_r1.setTextureOffset(18, 14).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 14.0F, 6.0F, 0.0F, false);

        legBackLeft = new ModelRenderer(this);
        legBackLeft.setRotationPoint(1.5F, 16.0F, 7.0F);
        legBackLeft.setTextureOffset(0, 18).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

        legBackRight = new ModelRenderer(this);
        legBackRight.setRotationPoint(-1.5F, 16.0F, 7.0F);
        legBackRight.setTextureOffset(0, 18).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

        legFrontLeft = new ModelRenderer(this);
        legFrontLeft.setRotationPoint(1.5F, 16.0F, -4.0F);
        legFrontLeft.setTextureOffset(0, 18).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

        legFrontRight = new ModelRenderer(this);
        legFrontRight.setRotationPoint(-1.5F, 16.0F, -4.0F);
        legFrontRight.setTextureOffset(0, 18).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityT, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        this.head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
        this.body.rotateAngleX = ((float) Math.PI / 2F);
        this.legBackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.legBackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.legFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.legFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        legBackLeft.render(matrixStack, buffer, packedLight, packedOverlay);
        legBackRight.render(matrixStack, buffer, packedLight, packedOverlay);
        legFrontLeft.render(matrixStack, buffer, packedLight, packedOverlay);
        legFrontRight.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

}
