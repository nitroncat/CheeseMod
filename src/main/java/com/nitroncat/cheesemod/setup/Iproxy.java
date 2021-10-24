package com.nitroncat.cheesemod.setup;

import net.minecraft.world.World;

public interface Iproxy
{
    void init();

    World getClientWorld();
}
