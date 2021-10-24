package com.nitroncat.cheesemod.tileentity;

import com.nitroncat.cheesemod.block.ModBlocks;
import com.nitroncat.cheesemod.util.Registration;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;

public class ModTileEntities
{
    public static final RegistryObject<TileEntityType<FondueTile>> FONDUE_TILE_ENTITY
            = Registration.TILE_ENTITY_TYPES.register("fondue_tile_entity", () -> TileEntityType.Builder.create(
            () -> new FondueTile(), ModBlocks.FONDUE.get()).build(null));

    public static void register() { }

}
