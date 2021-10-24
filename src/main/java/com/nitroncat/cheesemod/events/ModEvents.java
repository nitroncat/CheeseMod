package com.nitroncat.cheesemod.events;

import com.nitroncat.cheesemod.block.ModBlocks;
import com.nitroncat.cheesemod.item.ModItems;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.LogManager;

import java.util.Collection;

public class ModEvents {
    @SubscribeEvent
    public void onCheeseSheep(AttackEntityEvent event) {
        if (event.getPlayer().getHeldItemMainhand().getItem() == ModItems.SHEEP_IDENTIFIER.get()) {
            if (event.getTarget().isAlive()) {
                LivingEntity target = (LivingEntity) event.getTarget();
                if (target instanceof SheepEntity) {
                    PlayerEntity player = event.getPlayer();

                    target.addPotionEffect(new EffectInstance(new EffectInstance(Effects.GLOWING, 600)));

                    if (!player.world.isRemote()) {
                        String msg = TextFormatting.YELLOW + "Sheep is now glowing!";
                        player.sendMessage(new StringTextComponent(msg), player.getUniqueID());

                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void onCheeseSheepDrops(LivingDropsEvent event) {
        LivingEntity entity = event.getEntityLiving();
        if (entity instanceof SheepEntity) {
            World world = entity.getEntityWorld();
            Collection<ItemEntity> drops = event.getDrops();

            LogManager.getLogger().debug(entity.getActivePotionEffects());

            if (entity.isPotionActive(Effects.GLOWING)) {
                drops.add(new ItemEntity(world, entity.getPosX(), entity.getPosY(), entity.getPosZ(),
                        new ItemStack(ModItems.CHEESE_INGOT.get())));

            }

        }
    }


    @SubscribeEvent
    public void onMobHit(AttackEntityEvent event) {
        if (event.getPlayer().getHeldItemMainhand().getItem() == ModItems.CHEESE_SWORD.get()) {
            if (event.getTarget().isAlive()) {
                LivingEntity target = (LivingEntity) event.getTarget();
                if (target instanceof CreatureEntity) {
                    PlayerEntity player = event.getPlayer();

                    target.addPotionEffect(new EffectInstance(new EffectInstance(Effects.INVISIBILITY, 600)));

                    if (!player.world.isRemote()) {
                        String msg = TextFormatting.YELLOW + "Mob is now invisible for 30 seconds. Try and catch it for a prize!";
                        player.sendMessage(new StringTextComponent(msg), player.getUniqueID());

                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void onPlayerReward(LivingDropsEvent event) {
        LivingEntity entity = event.getEntityLiving();
        if (entity instanceof CreatureEntity) {
            World world = entity.getEntityWorld();
            Collection<ItemEntity> drops = event.getDrops();

            LogManager.getLogger().debug(entity.getActivePotionEffects());

            if (entity.isPotionActive(Effects.INVISIBILITY)) {
                drops.add(new ItemEntity(world, entity.getPosX(), entity.getPosY(), entity.getPosZ(),
                        new ItemStack(ModItems.CHEESE_SEED.get())));
            }

        }
    }
}

