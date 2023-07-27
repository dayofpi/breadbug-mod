package com.dayofpi.breadbug;

import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, BreadbugMod.MOD_ID);

    public static final RegistryObject<SoundEvent> MUSIC_DISC_THE_FOREST_NAVEL = registerSoundEvent("music_disc.the_forest_navel");
    public static final RegistryObject<SoundEvent> MUSIC_DISC_GIANT_BREADBUG = registerSoundEvent("music_disc.giant_breadbug");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = new ResourceLocation(BreadbugMod.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }
}
