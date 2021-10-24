package com.nitroncat.cheesemod.block;

import com.nitroncat.cheesemod.CheeseMod;
import com.nitroncat.cheesemod.item.ModItems;
import com.nitroncat.cheesemod.util.Registration;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final RegistryObject<Block> CHEESE_ORE = register("cheese_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(3f, 10f).sound(SoundType.STONE)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE)));


    public static final RegistryObject<Block> GLOOMSTONE = register("gloomstone",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(10f, 20f).sound(SoundType.STONE)
                    .harvestLevel(4).harvestTool(ToolType.PICKAXE)));


    public static final RegistryObject<Block> CHEESE_CROP =
            Registration.BLOCKS.register("cheese_crop",
                    () -> new CheeseCrop(AbstractBlock.Properties.from(Blocks.BEETROOTS)));


    public static final RegistryObject<Block> CHEESE_BLOCK = register("cheese_block",
            () -> new Block(AbstractBlock.Properties.create(Material.CLAY)
                    .hardnessAndResistance(3f, 10f).sound(SoundType.HONEY)));


    public static final RegistryObject<Block> FONDUE =
            register("fondue", () -> new Fondue(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(4f).harvestTool(ToolType.PICKAXE).sound(SoundType.WOOD)));


    public static final RegistryObject<Block> CHEESE_PLANK = register("cheese_planks",
            () -> new Block(AbstractBlock.Properties.from(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> CHEESE_LOG = register("cheese_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.OAK_WOOD)));

    public static final RegistryObject<Block> CHEESE_LEAVES = register("cheese_leaves",
            () -> new Block(AbstractBlock.Properties.from(Blocks.OAK_LEAVES)));


    public static final RegistryObject<Block> CHEESE_SAPLING = register("cheese_sapling",
            () -> new CheeseSapling(
                    () -> new CheeseTree(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING)
            ));

    public static void register() {
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().group(CheeseMod.COURSE_TAB)));
        return toReturn;
    }
}


