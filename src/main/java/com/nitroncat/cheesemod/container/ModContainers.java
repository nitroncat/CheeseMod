package com.nitroncat.cheesemod.container;

import com.nitroncat.cheesemod.util.Registration;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;

public class ModContainers
{
    public static final RegistryObject<ContainerType<FondueContainer>> FONDUE_CONTAINER
            = Registration.CONTAINERS.register("fondue_container",
            () -> IForgeContainerType.create((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                World world = inv.player.getEntityWorld();
                return new FondueContainer(windowId, world, pos, inv, inv.player);
            }));

    public static void register() { }

}

