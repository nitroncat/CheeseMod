package com.nitroncat.cheesemod.item;

import com.nitroncat.cheesemod.CheeseMod;
import com.nitroncat.cheesemod.util.KeyboardUtil;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class SheepIdentifier extends Item
{
    public SheepIdentifier()
    {
        super(new Properties().group(CheeseMod.COURSE_TAB));


    }
    @Override
    public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip,
                               ITooltipFlag flag)
    {
        if(KeyboardUtil.isHoldingShift())
        {
            tooltip.add(new StringTextComponent("Identifies Sheep"));
        }
        else
        {
            tooltip.add(new StringTextComponent("Hold" + "\u00A7e" + " SHIFT" + "\u00a77" + " for more information"));
        }
        super.addInformation(stack, world, tooltip, flag);
    }
}
