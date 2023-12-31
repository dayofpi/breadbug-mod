package com.dayofpi.breadbug;

import com.dayofpi.breadbug.client.CrumbugRenderer;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(BreadbugMod.MOD_ID)
public class BreadbugMod {
    public static final String MOD_ID = "breadbug";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final RegistryObject<Item> RAW_BEADBUG = ITEMS.register("raw_breadbug", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .nutrition(5).saturationMod(0.8f).meat().build())));

    public static final RegistryObject<Item> COOKED_BREADBUG = ITEMS.register("cooked_breadbug", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .nutrition(6).saturationMod(0.9f).meat().build())));

    public static final RegistryObject<Item> MUSIC_DISC_THE_FOREST_NAVEL = ITEMS.register("music_disc_the_forest_navel", () -> new RecordItem(1, ModSounds.MUSIC_DISC_THE_FOREST_NAVEL, new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 2920));
    public static final RegistryObject<Item> MUSIC_DISC_GIANT_BREADBUG = ITEMS.register("music_disc_giant_breadbug", () -> new RecordItem(2, ModSounds.MUSIC_DISC_GIANT_BREADBUG, new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 2460));

    public static final RegistryObject<Item> CRUMBUG_SPAWN_EGG = ITEMS.register("crumbug_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.CRUMBUG, 0xe08c41, 0xffee9e, new Item.Properties()));

    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("breadbug", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.breadbug"))
            .icon(() -> RAW_BEADBUG.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(RAW_BEADBUG.get());
                output.accept(COOKED_BREADBUG.get());
                output.accept(MUSIC_DISC_THE_FOREST_NAVEL.get());
                output.accept(MUSIC_DISC_GIANT_BREADBUG.get());
                output.accept(CRUMBUG_SPAWN_EGG.get());
            }).build());

    public BreadbugMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        ModEntities.ENTITY_TYPES.register(modEventBus);
        ModSounds.SOUND_EVENTS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                EntityRenderers.register(ModEntities.CRUMBUG.get(), CrumbugRenderer::new);
            });
        }
    }
}
