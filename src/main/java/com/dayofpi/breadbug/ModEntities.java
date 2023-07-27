package com.dayofpi.breadbug;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, BreadbugMod.MOD_ID);

    public static final RegistryObject<EntityType<CrumbugEntity>> CRUMBUG = registerEntity("crumbug", EntityType.Builder.of(CrumbugEntity::new, MobCategory.CREATURE).sized(0.6f, 0.4f));

    private static <T extends Entity> RegistryObject<EntityType<T>> registerEntity(String name, EntityType.Builder<T> builder) {
        return ENTITY_TYPES.register(name, () -> builder.build(new ResourceLocation(BreadbugMod.MOD_ID, name).toString()));
    }
}
