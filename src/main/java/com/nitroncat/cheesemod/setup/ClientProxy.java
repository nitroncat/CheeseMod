package com.nitroncat.cheesemod.setup;

import com.nitroncat.cheesemod.CheeseMod;
import com.nitroncat.cheesemod.block.ModBlocks;
import com.nitroncat.cheesemod.container.ModContainers;
import com.nitroncat.cheesemod.entity.ModEntityTypes;
import com.nitroncat.cheesemod.entity.render.RatRenderer;
import com.nitroncat.cheesemod.item.ModSpawnEggItems;
import com.nitroncat.cheesemod.screens.FondueScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CheeseMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientProxy implements Iproxy
{
    @Override
    public void init()
    {
        RenderTypeLookup.setRenderLayer(ModBlocks.CHEESE_CROP.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.CHEESE_SAPLING.get(), RenderType.getCutout());

        ScreenManager.registerFactory(ModContainers.FONDUE_CONTAINER.get(), FondueScreen::new);

        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.RAT.get(), RatRenderer::new);

        ModSpawnEggItems.initSpawnEgs();
    }

    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }
}
