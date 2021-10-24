package com.nitroncat.cheesemod.entity.render;

import com.nitroncat.cheesemod.CheeseMod;
import com.nitroncat.cheesemod.entity.RatEntity;
import com.nitroncat.cheesemod.entity.model.RatModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RatRenderer extends MobRenderer<RatEntity, RatModel<RatEntity>>
{

    public RatRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new RatModel<>(), 0.9f);
    }

    @Override
    public ResourceLocation getEntityTexture(RatEntity entity) {
        return new ResourceLocation(CheeseMod.MOD_ID, "textures/entities/rat_texture.png");
    }
}
