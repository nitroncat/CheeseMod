package com.nitroncat.cheesemod;

import com.nitroncat.cheesemod.block.ModBlocks;
import com.nitroncat.cheesemod.block.ModFluids;
import com.nitroncat.cheesemod.container.ModContainers;
import com.nitroncat.cheesemod.entity.ModEntityTypes;
import com.nitroncat.cheesemod.entity.RatEntity;
import com.nitroncat.cheesemod.events.ModEvents;
import com.nitroncat.cheesemod.item.ModItems;
import com.nitroncat.cheesemod.setup.ClientProxy;
import com.nitroncat.cheesemod.setup.Iproxy;
import com.nitroncat.cheesemod.setup.ServerProxy;
import com.nitroncat.cheesemod.sounds.ModSoundEvents;
import com.nitroncat.cheesemod.tileentity.ModTileEntities;
import com.nitroncat.cheesemod.util.Config;
import com.nitroncat.cheesemod.util.Registration;
import net.minecraft.block.Block;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(CheeseMod.MOD_ID)
public class CheeseMod
{
    public static final String MOD_ID = "cheesemod";

    public static final ItemGroup COURSE_TAB = new ItemGroup("courseTab")
    {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.CHEESE_INGOT.get());
        }
    };

    public static Iproxy proxy;

    private static final Logger LOGGER = LogManager.getLogger();

    public CheeseMod()
    {
        proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        registerModAdditions();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        registerConfigs();

        proxy.init();

        DeferredWorkQueue.runLater(() ->
                GlobalEntityTypeAttributes.put(ModEntityTypes.RAT.get(), RatEntity.setCustomAttributes().create()));

        loadConfigs();
    }

    private void registerConfigs()
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG);
    }

    private void loadConfigs()
    {
        Config.loadConfigFile(Config.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve("cheesemod-client.toml").toString());
        Config.loadConfigFile(Config.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("cheesemod-server.toml").toString());
    }


    private void registerModAdditions()
    {
        Registration.init();

        ModItems.register();
        ModBlocks.register();
        ModFluids.register();
        ModEntityTypes.register();
        ModSoundEvents.register();
        ModTileEntities.register();
        ModContainers.register();


        MinecraftForge.EVENT_BUS.register(new ModEvents());
    }


    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}
