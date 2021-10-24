package com.nitroncat.cheesemod.entity;

import com.nitroncat.cheesemod.CheeseMod;
import com.nitroncat.cheesemod.block.ModFluids;
import com.nitroncat.cheesemod.util.Registration;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

public class ModEntityTypes
{
    public static final RegistryObject<EntityType<RatEntity>> RAT = Registration.ENTITIES.register("rat",
            () -> EntityType.Builder.create(RatEntity::new, EntityClassification.CREATURE)
                    .size(0.6f, 0.4f)
                    .func_233607_a_(ModFluids.MOLTEN_BLOCK.get())
                    .build(new ResourceLocation(CheeseMod.MOD_ID + "rat").toString()));

    public static void register() { }
}