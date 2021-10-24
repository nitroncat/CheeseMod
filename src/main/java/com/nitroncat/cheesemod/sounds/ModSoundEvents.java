package com.nitroncat.cheesemod.sounds;

import com.nitroncat.cheesemod.CheeseMod;
import com.nitroncat.cheesemod.util.Registration;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;

public class ModSoundEvents
{
    public static final RegistryObject<SoundEvent> RAT_AMBIENT =
            Registration.SOUND_EVENTS.register("rat_ambient",
                    () -> new SoundEvent(new ResourceLocation(CheeseMod.MOD_ID,
                            "rat_ambient")));

    public static final RegistryObject<SoundEvent> RAT_DEATH =
            Registration.SOUND_EVENTS.register("rat_death",
                    () -> new SoundEvent(new ResourceLocation(CheeseMod.MOD_ID,
                            "rat_death")));

    public static final RegistryObject<SoundEvent> RAT_HURT =
            Registration.SOUND_EVENTS.register("rat_hurt",
                    () -> new SoundEvent(new ResourceLocation(CheeseMod.MOD_ID,
                            "rat_hurt")));

    public static void register() { }
}
