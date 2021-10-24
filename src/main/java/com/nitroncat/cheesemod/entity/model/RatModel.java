package com.nitroncat.cheesemod.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.nitroncat.cheesemod.entity.RatEntity;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class RatModel<T extends RatEntity> extends AgeableModel<T>
{
    private final ModelRenderer head;
    private final ModelRenderer tail;
    private final ModelRenderer body;
    private final ModelRenderer front_right;
    private final ModelRenderer front_left;
    private final ModelRenderer back_right;
    private final ModelRenderer back_left;
    private final ModelRenderer bb_main;

    public RatModel()
    {
        textureWidth = 32;
        textureHeight = 32;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 21.0F, -4.0F);
        head.setTextureOffset(15, 19).addBox(1.3789F, -2.542F, -1.307F, 2.0F, 2.0F, 0.0F, 0.0F, false);
        head.setTextureOffset(0, 20).addBox(-3.7178F, -2.542F, -0.8126F, 2.0F, 2.0F, 0.0F, 0.0F, false);
        head.setTextureOffset(0, 13).addBox(-1.9522F, -1.1925F, -2.7768F, 4.0F, 3.0F, 3.0F, 0.0F, false);

        tail = new ModelRenderer(this);
        tail.setRotationPoint(0.0F, 21.6F, 3.6F);
        tail.setTextureOffset(15, 13).addBox(-0.624F, -0.586F, -0.16F, 1.0F, 1.0F, 4.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 21.3F, 0.0F);
        body.setTextureOffset(0, 0).addBox(-2.56F, -2.1783F, -4.128F, 5.0F, 4.0F, 8.0F, 0.0F, false);

        front_right = new ModelRenderer(this);
        front_right.setRotationPoint(-1.5F, 23.1F, -3.1F);
        front_right.setTextureOffset(19, 3).addBox(-0.4931F, -0.1F, -0.4638F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        front_left = new ModelRenderer(this);
        front_left.setRotationPoint(1.5F, 23.1F, -3.1F);
        front_left.setTextureOffset(19, 0).addBox(-0.4522F, -0.1F, -0.4638F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        back_right = new ModelRenderer(this);
        back_right.setRotationPoint(-1.5F, 23.0F, 3.1F);
        back_right.setTextureOffset(12, 13).addBox(-0.4931F, 0.0F, -0.4581F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        back_left = new ModelRenderer(this);
        back_left.setRotationPoint(1.5F, 23.2F, 3.2F);
        back_left.setTextureOffset(0, 3).addBox(-0.4522F, -0.0595F, -0.5328F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        bb_main = new ModelRenderer(this);
        bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
        bb_main.setTextureOffset(0, 0).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
    {
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.back_right.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.back_left.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.front_right.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.front_left.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    @Override
    protected Iterable<ModelRenderer> getHeadParts() {
        return ImmutableList.of(this.bb_main);
    }

    @Override
    protected Iterable<ModelRenderer> getBodyParts() {
        return ImmutableList.of(this.body, this.back_left, this.back_right, this.front_left, this.front_right, this.head, this.tail);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}