package com.imesh97.megathings.entities;

import com.imesh97.megathings.MegaThings;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class EntityDogRender extends MobRenderer<EntityDog, EntityDogModel<EntityDog>> {
    public EntityDogRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new EntityDogModel<>(), 0.7F);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityDog entity) {
        return new ResourceLocation(MegaThings.MOD_ID, "textures/entity/dog.png");
    }
}
