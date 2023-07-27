package com.dayofpi.breadbug.client;

import com.dayofpi.breadbug.BreadbugMod;
import com.dayofpi.breadbug.CrumbugEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CrumbugRenderer extends MobRenderer<CrumbugEntity, CrumbugModel<CrumbugEntity>> {
    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(BreadbugMod.MOD_ID, "textures/entity/crumbug.png");

    public CrumbugRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CrumbugModel<>(pContext.bakeLayer(CrumbugModel.LAYER_LOCATION)), 0.4F);
    }

    @Override
    public ResourceLocation getTextureLocation(CrumbugEntity pEntity) {
        return TEXTURE_LOCATION;
    }
}
