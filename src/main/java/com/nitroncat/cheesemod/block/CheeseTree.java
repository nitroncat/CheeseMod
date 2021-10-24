package com.nitroncat.cheesemod.block;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;


import javax.annotation.Nullable;
import java.util.Random;

public class CheeseTree extends Tree
{
    private static final int BASE_HEIGHT = 2;
    private static final int FIRST_RANDOM_HEIGHT = 0;
    private static final int SECOND_RANDOM_HEIGHT = 1;

    private static final int LEAVE_RADIUS = 3;
    private static final int LEAVE_OFFSET = 2;
    private static final int LEAVE_HEIGHT = 2;

    public static final BaseTreeFeatureConfig CHEESE_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(ModBlocks.CHEESE_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(ModBlocks.CHEESE_LEAVES.get().getDefaultState()),
            new BlobFoliagePlacer(FeatureSpread.create(LEAVE_RADIUS),
                    FeatureSpread.create(LEAVE_OFFSET), LEAVE_HEIGHT),
            new StraightTrunkPlacer(BASE_HEIGHT, FIRST_RANDOM_HEIGHT, SECOND_RANDOM_HEIGHT),
            new TwoLayerFeature(1, 0, 1)
    )).build();

    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean largeHive) {
        return Feature.TREE.withConfiguration(CHEESE_TREE_CONFIG);
    }
}
