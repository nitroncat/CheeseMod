package com.nitroncat.cheesemod.block;

import com.nitroncat.cheesemod.CheeseMod;
import com.nitroncat.cheesemod.item.ModItems;
import com.nitroncat.cheesemod.util.Registration;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;

public class ModFluids
{
    public static final ResourceLocation MOLTEN_STILL_RL = new ResourceLocation(CheeseMod.MOD_ID,
            "block/molten_still");
    public static final ResourceLocation MOLTEN_FLOWING_RL = new ResourceLocation(CheeseMod.MOD_ID,
            "block/molten_flowing");

    public static final ResourceLocation MOLTEN_OVERLAY_RL = new ResourceLocation(CheeseMod.MOD_ID,
            "block/molten_overlay");

    public static final RegistryObject<FlowingFluid> MOLTEN_FLUID
            = Registration.FLUIDS.register("molten_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.MOLTEN_PROPERTIES));

    public static final RegistryObject<FlowingFluid> MOLTEN_FLOWING
            = Registration.FLUIDS.register("molten_flowing",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.MOLTEN_PROPERTIES));

    public static final ForgeFlowingFluid.Properties MOLTEN_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> MOLTEN_FLUID.get(), () -> MOLTEN_FLOWING.get(), FluidAttributes.builder(MOLTEN_STILL_RL, MOLTEN_FLOWING_RL)
            .density(3000).temperature(1300).luminosity(15).rarity(Rarity.EPIC).sound(SoundEvents.BLOCK_LAVA_AMBIENT).overlay(MOLTEN_OVERLAY_RL)
            .viscosity(6000)).slopeFindDistance(3).levelDecreasePerBlock(3)
            .block(() -> ModFluids.MOLTEN_BLOCK.get()).bucket(() -> ModItems.MOLTEN_BUCKET.get());

    public static final RegistryObject<FlowingFluidBlock> MOLTEN_BLOCK = Registration.BLOCKS.register("molten_cheese",
            () -> new FlowingFluidBlock(() -> ModFluids.MOLTEN_FLUID.get(), AbstractBlock.Properties.create(Material.LAVA)
                    .doesNotBlockMovement().hardnessAndResistance(100.0f).noDrops()));

    public static void register() { }

}
