package com.nitroncat.cheesemod.block;

import com.nitroncat.cheesemod.container.FondueContainer;
import com.nitroncat.cheesemod.item.ModItems;
import com.nitroncat.cheesemod.tileentity.FondueTile;
import com.nitroncat.cheesemod.tileentity.ModTileEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.stream.Stream;

public class Fondue extends Block
{
    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(1, 0, 1, 14.999999999999993, 0.6000000000000001, 15),
            Block.makeCuboidShape(3, 4.200000000000001, 3, 13, 5.200000000000001, 13),
            Block.makeCuboidShape(11, 0.007839666004601398, 4.044761702647305, 12, 5.007839666004601, 5.044761702647305),
            Block.makeCuboidShape(4, 0.02209557697713116, 11.054946004355475, 5, 4.772095576977129, 12.054946004355475),
            Block.makeCuboidShape(11, 0.12209829038938214, 10.954932363110906, 12, 4.8720982903893795, 11.954932363110906),
            Block.makeCuboidShape(4, 0.07278310805559585, 4.148337059856991, 5, 5.072783108055594, 5.148337059856991),
            Block.makeCuboidShape(13, 5.199999999999999, 3.0038, 14, 10.2, 13.0038),
            Block.makeCuboidShape(6, 0, 9, 7, 1, 10),
            Block.makeCuboidShape(6, 0, 6, 7, 1, 7),
            Block.makeCuboidShape(9, 0, 9, 10, 1, 10),
            Block.makeCuboidShape(9, 0, 6, 10, 1, 7),
            Block.makeCuboidShape(9.000000000000002, 0, 7.000000000000002, 10.000000000000002, 1.2, 9.000000000000002),
            Block.makeCuboidShape(6.000000000000002, 0, 7.000000000000002, 7.000000000000002, 1.2, 9.000000000000002),
            Block.makeCuboidShape(7, 0, 9, 9, 1.2, 10),
            Block.makeCuboidShape(7, 0, 6, 9, 1.2, 7),
            Block.makeCuboidShape(7, 0, 7, 9, 1.2, 9),
            Block.makeCuboidShape(3, 5.199999999999999, 13, 13, 10.2, 14),
            Block.makeCuboidShape(3, 5.199999999999999, 2, 13, 10.2, 3),
            Block.makeCuboidShape(2, 5.199999999999999, 3, 3, 10.2, 13),
            Block.makeCuboidShape(0, 9.2, 6, 2, 10.2, 7),
            Block.makeCuboidShape(0, 9.2, 7, 1, 10.2, 9),
            Block.makeCuboidShape(13.966666666666667, 9.2, 9, 15.966666666666667, 10.2, 10),
            Block.makeCuboidShape(14.966666666666667, 9.2, 7, 15.966666666666667, 10.2, 9),
            Block.makeCuboidShape(13.966666666666667, 9.2, 6, 15.966666666666667, 10.2, 7),
            Block.makeCuboidShape(0, 9.2, 9, 2, 10.2, 10)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(0.992000000000008, 0, 1.0165421703976563, 14.992, 0.6000000000000001, 15.016542170397656),
            Block.makeCuboidShape(2.992000000000001, 4.200000000000001, 3.0165421703976563, 12.992, 5.200000000000001, 13.016542170397656),
            Block.makeCuboidShape(3.992000000000001, 0.007839666004601398, 10.971780467750351, 4.992000000000001, 5.007839666004601, 11.971780467750351),
            Block.makeCuboidShape(10.992, 0.02209557697713116, 3.961596166042181, 11.992, 4.772095576977129, 4.961596166042181),
            Block.makeCuboidShape(3.992000000000001, 0.12209829038938214, 4.06160980728675, 4.992000000000001, 4.8720982903893795, 5.06160980728675),
            Block.makeCuboidShape(10.992, 0.07278310805559585, 10.868205110540666, 11.992, 5.072783108055594, 11.868205110540666),
            Block.makeCuboidShape(1.9920000000000009, 5.199999999999999, 3.0127421703976562, 2.992000000000001, 10.2, 13.012742170397656),
            Block.makeCuboidShape(8.992, 0, 6.016542170397656, 9.992, 1, 7.016542170397656),
            Block.makeCuboidShape(8.992, 0, 9.016542170397656, 9.992, 1, 10.016542170397656),
            Block.makeCuboidShape(5.992000000000001, 0, 6.016542170397656, 6.992000000000001, 1, 7.016542170397656),
            Block.makeCuboidShape(5.992000000000001, 0, 9.016542170397656, 6.992000000000001, 1, 10.016542170397656),
            Block.makeCuboidShape(5.991999999999999, 0, 7.0165421703976545, 6.991999999999999, 1.2, 9.016542170397654),
            Block.makeCuboidShape(8.991999999999999, 0, 7.0165421703976545, 9.991999999999999, 1.2, 9.016542170397654),
            Block.makeCuboidShape(6.992000000000001, 0, 6.016542170397656, 8.992, 1.2, 7.016542170397656),
            Block.makeCuboidShape(6.992000000000001, 0, 9.016542170397656, 8.992, 1.2, 10.016542170397656),
            Block.makeCuboidShape(6.992000000000001, 0, 7.016542170397656, 8.992, 1.2, 9.016542170397656),
            Block.makeCuboidShape(2.992000000000001, 5.199999999999999, 2.0165421703976563, 12.992, 10.2, 3.0165421703976563),
            Block.makeCuboidShape(2.992000000000001, 5.199999999999999, 13.016542170397656, 12.992, 10.2, 14.016542170397656),
            Block.makeCuboidShape(12.992, 5.199999999999999, 3.0165421703976563, 13.992, 10.2, 13.016542170397656),
            Block.makeCuboidShape(13.992, 9.2, 9.016542170397656, 15.992, 10.2, 10.016542170397656),
            Block.makeCuboidShape(14.992, 9.2, 7.016542170397656, 15.992, 10.2, 9.016542170397656),
            Block.makeCuboidShape(0.025333333333334096, 9.2, 6.016542170397656, 2.025333333333334, 10.2, 7.016542170397656),
            Block.makeCuboidShape(0.025333333333334096, 9.2, 7.016542170397656, 1.025333333333334, 10.2, 9.016542170397656),
            Block.makeCuboidShape(0.025333333333334096, 9.2, 9.016542170397656, 2.025333333333334, 10.2, 10.016542170397656),
            Block.makeCuboidShape(13.992, 9.2, 6.016542170397656, 15.992, 10.2, 7.016542170397656)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(1.0042710851988286, 0, 1.0122710851988277, 15.004271085198829, 0.6000000000000001, 15.01227108519882),
            Block.makeCuboidShape(3.0042710851988286, 4.200000000000001, 3.0122710851988277, 13.004271085198829, 5.200000000000001, 13.012271085198828),
            Block.makeCuboidShape(10.959509382551524, 0.007839666004601398, 11.012271085198828, 11.959509382551524, 5.007839666004601, 12.012271085198828),
            Block.makeCuboidShape(3.9493250808433533, 0.02209557697713116, 4.012271085198828, 4.949325080843353, 4.772095576977129, 5.012271085198828),
            Block.makeCuboidShape(4.0493387220879224, 0.12209829038938214, 11.012271085198828, 5.0493387220879224, 4.8720982903893795, 12.012271085198828),
            Block.makeCuboidShape(10.855934025341838, 0.07278310805559585, 4.012271085198828, 11.855934025341838, 5.072783108055594, 5.012271085198828),
            Block.makeCuboidShape(3.0004710851988285, 5.199999999999999, 13.012271085198828, 13.000471085198829, 10.2, 14.012271085198828),
            Block.makeCuboidShape(6.004271085198829, 0, 6.012271085198828, 7.004271085198829, 1, 7.012271085198828),
            Block.makeCuboidShape(9.004271085198829, 0, 6.012271085198828, 10.004271085198829, 1, 7.012271085198828),
            Block.makeCuboidShape(6.004271085198829, 0, 9.012271085198828, 7.004271085198829, 1, 10.012271085198828),
            Block.makeCuboidShape(9.004271085198829, 0, 9.012271085198828, 10.004271085198829, 1, 10.012271085198828),
            Block.makeCuboidShape(7.004271085198827, 0, 9.01227108519883, 9.004271085198827, 1.2, 10.01227108519883),
            Block.makeCuboidShape(7.004271085198827, 0, 6.0122710851988295, 9.004271085198827, 1.2, 7.0122710851988295),
            Block.makeCuboidShape(6.004271085198829, 0, 7.012271085198828, 7.004271085198829, 1.2, 9.012271085198828),
            Block.makeCuboidShape(9.004271085198829, 0, 7.012271085198828, 10.004271085198829, 1.2, 9.012271085198828),
            Block.makeCuboidShape(7.004271085198829, 0, 7.012271085198828, 9.004271085198829, 1.2, 9.012271085198828),
            Block.makeCuboidShape(2.0042710851988286, 5.199999999999999, 3.0122710851988277, 3.0042710851988286, 10.2, 13.012271085198828),
            Block.makeCuboidShape(13.004271085198829, 5.199999999999999, 3.0122710851988277, 14.004271085198829, 10.2, 13.012271085198828),
            Block.makeCuboidShape(3.0042710851988286, 5.199999999999999, 2.0122710851988277, 13.004271085198829, 10.2, 3.0122710851988277),
            Block.makeCuboidShape(9.004271085198829, 9.2, 0.012271085198827691, 10.004271085198829, 10.2, 2.0122710851988277),
            Block.makeCuboidShape(7.004271085198829, 9.2, 0.012271085198827691, 9.004271085198829, 10.2, 1.0122710851988277),
            Block.makeCuboidShape(6.004271085198829, 9.2, 13.978937751865494, 7.004271085198829, 10.2, 15.978937751865494),
            Block.makeCuboidShape(7.004271085198829, 9.2, 14.978937751865494, 9.004271085198829, 10.2, 15.978937751865494),
            Block.makeCuboidShape(9.004271085198829, 9.2, 13.978937751865494, 10.004271085198829, 10.2, 15.978937751865494),
            Block.makeCuboidShape(6.004271085198829, 9.2, 0.012271085198827691, 7.004271085198829, 10.2, 2.0122710851988277)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(0.9877289148011723, 0, 1.0042710851988357, 14.987728914801172, 0.6000000000000001, 15.004271085198829),
            Block.makeCuboidShape(2.9877289148011723, 4.200000000000001, 3.0042710851988286, 12.987728914801172, 5.200000000000001, 13.004271085198829),
            Block.makeCuboidShape(4.032490617448477, 0.007839666004601398, 4.004271085198829, 5.032490617448477, 5.007839666004601, 5.004271085198829),
            Block.makeCuboidShape(11.042674919156648, 0.02209557697713116, 11.004271085198829, 12.042674919156648, 4.772095576977129, 12.004271085198829),
            Block.makeCuboidShape(10.942661277912078, 0.12209829038938214, 4.004271085198829, 11.942661277912078, 4.8720982903893795, 5.004271085198829),
            Block.makeCuboidShape(4.1360659746581625, 0.07278310805559585, 11.004271085198829, 5.1360659746581625, 5.072783108055594, 12.004271085198829),
            Block.makeCuboidShape(2.9915289148011723, 5.199999999999999, 2.0042710851988286, 12.991528914801172, 10.2, 3.0042710851988286),
            Block.makeCuboidShape(8.987728914801172, 0, 9.004271085198829, 9.987728914801172, 1, 10.004271085198829),
            Block.makeCuboidShape(5.987728914801172, 0, 9.004271085198829, 6.987728914801172, 1, 10.004271085198829),
            Block.makeCuboidShape(8.987728914801172, 0, 6.004271085198829, 9.987728914801172, 1, 7.004271085198829),
            Block.makeCuboidShape(5.987728914801172, 0, 6.004271085198829, 6.987728914801172, 1, 7.004271085198829),
            Block.makeCuboidShape(6.987728914801174, 0, 6.004271085198827, 8.987728914801174, 1.2, 7.004271085198827),
            Block.makeCuboidShape(6.987728914801174, 0, 9.004271085198827, 8.987728914801174, 1.2, 10.004271085198827),
            Block.makeCuboidShape(8.987728914801172, 0, 7.004271085198829, 9.987728914801172, 1.2, 9.004271085198829),
            Block.makeCuboidShape(5.987728914801172, 0, 7.004271085198829, 6.987728914801172, 1.2, 9.004271085198829),
            Block.makeCuboidShape(6.987728914801172, 0, 7.004271085198829, 8.987728914801172, 1.2, 9.004271085198829),
            Block.makeCuboidShape(12.987728914801172, 5.199999999999999, 3.0042710851988286, 13.987728914801172, 10.2, 13.004271085198829),
            Block.makeCuboidShape(1.9877289148011723, 5.199999999999999, 3.0042710851988286, 2.9877289148011723, 10.2, 13.004271085198829),
            Block.makeCuboidShape(2.9877289148011723, 5.199999999999999, 13.004271085198829, 12.987728914801172, 10.2, 14.004271085198829),
            Block.makeCuboidShape(5.987728914801172, 9.2, 14.004271085198829, 6.987728914801172, 10.2, 16.00427108519883),
            Block.makeCuboidShape(6.987728914801172, 9.2, 15.004271085198829, 8.987728914801172, 10.2, 16.00427108519883),
            Block.makeCuboidShape(8.987728914801172, 9.2, 0.03760441853216179, 9.987728914801172, 10.2, 2.037604418532162),
            Block.makeCuboidShape(6.987728914801172, 9.2, 0.03760441853216179, 8.987728914801172, 10.2, 1.0376044185321618),
            Block.makeCuboidShape(5.987728914801172, 9.2, 0.03760441853216179, 6.987728914801172, 10.2, 2.037604418532162),
            Block.makeCuboidShape(8.987728914801172, 9.2, 14.004271085198829, 9.987728914801172, 10.2, 16.00427108519883)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    public Fondue(Properties properties)
    {
        super(properties);
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        switch (state.get(FACING))
        {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @SuppressWarnings("deprecation")
@Override
public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit)
{
    if (!worldIn.isRemote())
    {
        TileEntity tileEntity = worldIn.getTileEntity(pos);
        if (tileEntity instanceof FondueTile) {
            INamedContainerProvider containerProvider = new INamedContainerProvider() {
                @Override
                public ITextComponent getDisplayName() {
                    return new TranslationTextComponent("screen.cheesemod.fondue");
                }

                @Override
                public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                    return new FondueContainer(i, worldIn, pos, playerInventory, playerEntity);
                }
            };
            NetworkHooks.openGui((ServerPlayerEntity) player, containerProvider, tileEntity.getPos());
        }else{
            throw new IllegalStateException("Our Container provider is missing!");
        }
    }

    return ActionResultType.SUCCESS;
}

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world)
    {
        return ModTileEntities.FONDUE_TILE_ENTITY.get().create();
    }

    @Override
    public boolean hasTileEntity(BlockState state)
    {
        return true;
    }




    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState rotate(BlockState state, Rotation rot)
    {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn)
    {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(FACING);
    }
}
