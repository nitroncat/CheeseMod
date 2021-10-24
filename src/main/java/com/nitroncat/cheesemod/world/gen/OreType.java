package com.nitroncat.cheesemod.world.gen;

import com.nitroncat.cheesemod.block.ModBlocks;
import net.minecraft.block.Block;

public enum OreType
{
    CHEESE(ModBlocks.CHEESE_ORE.get(), 7, 5, 25),
    GLOOM(ModBlocks.GLOOMSTONE.get(), 5, 5, 20);

    private final Block block;
    private final int maxVeinSize;
    private final int minHeight;
    private final int maxHeight;

    OreType(Block block, int maxVeinSize, int minHeight, int maxHeight)
    {
        this.block = block;
        this.maxVeinSize = maxVeinSize;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }


    public Block getBlock() {
        return block;
    }

    public int getMaxVeinSize() {
        return maxVeinSize;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public static OreType get(Block block)
    {
        for (OreType ore : values())
        {
            if (block == ore.block)
            {
                return ore;
            }
        }
        return null;
    }
}
