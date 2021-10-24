package com.nitroncat.cheesemod.item;

import com.nitroncat.cheesemod.CheeseMod;
import com.nitroncat.cheesemod.block.ModBlocks;
import com.nitroncat.cheesemod.block.ModFluids;
import com.nitroncat.cheesemod.entity.ModEntityTypes;
import com.nitroncat.cheesemod.util.Registration;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

public class ModItems
{
    public static final RegistryObject<Item> CHEESE_INGOT =
            Registration.ITEMS.register("cheese_ingot",
            () -> new Item(new Item.Properties().group(CheeseMod.COURSE_TAB)));

    public static final RegistryObject<Item> CHEESE_STRAW =
            Registration.ITEMS.register("cheese_straw",
                    () -> new Item(new Item.Properties().group(CheeseMod.COURSE_TAB).isImmuneToFire()
                            .food(new Food.Builder()
                            .hunger(5)
                            .saturation(1.5f)
                            .build())));

    public static final RegistryObject<Item> CHEESE =
            Registration.ITEMS.register("cheese",
                    () -> new Item(new Item.Properties().group(CheeseMod.COURSE_TAB)
                            .food(new Food.Builder()
                            .hunger(2)
                            .saturation(0.5f)
                            .build())));

    public static final RegistryObject<Item> THERMIC_POWDER_PART1 =
            Registration.ITEMS.register("thermic_powder_part1",
                    () -> new Item(new Item.Properties().group(CheeseMod.COURSE_TAB)));

    public static final RegistryObject<Item> THERMIC_POWDER_PART2 =
            Registration.ITEMS.register("thermic_powder_part2",
                    () -> new Item(new Item.Properties().group(CheeseMod.COURSE_TAB)));

    public static final RegistryObject<Item> THERMIC_POWDER_PART3 =
            Registration.ITEMS.register("thermic_powder_part3",
                    () -> new Item(new Item.Properties().group(CheeseMod.COURSE_TAB)));

    public static final RegistryObject<Item> THERMIC_POWDER_PART4 =
            Registration.ITEMS.register("thermic_powder_part4",
                    () -> new Item(new Item.Properties().group(CheeseMod.COURSE_TAB)));

    public static final RegistryObject<Item> THERMIC_POWDER =
            Registration.ITEMS.register("thermic_powder",
                    () -> new Item(new Item.Properties().group(CheeseMod.COURSE_TAB)));

    public static final RegistryObject<Item> SHEEP_IDENTIFIER =
            Registration.ITEMS.register("sheep_identifier",
                    SheepIdentifier::new);

    public static final RegistryObject<Item> CHEESE_CHAMBER =
            Registration.ITEMS.register("cheese_chamber",
                    () -> new Item(new Item.Properties()
                            .group(CheeseMod.COURSE_TAB)));

    public static final RegistryObject<Item> CHEESE_SWORD =
            Registration.ITEMS.register("cheese_sword",
                    () -> new SwordItem(ModItemTier.CHEESE, 3, -2.7f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .group(CheeseMod.COURSE_TAB)));

    public static final RegistryObject<Item> CHEESE_PICKAXE =
            Registration.ITEMS.register("cheese_pickaxe",
                    () -> new PickaxeItem(ModItemTier.CHEESE, 1 , -2.8f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .addToolType(ToolType.PICKAXE, 2)
                                    .group(CheeseMod.COURSE_TAB)));

    public static final RegistryObject<Item> CHEESE_AXE =
            Registration.ITEMS.register("cheese_axe",
                    () -> new AxeItem(ModItemTier.CHEESE, 5.5f, -3.05f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .addToolType(ToolType.AXE, 2)
                                    .group(CheeseMod.COURSE_TAB)));

    public static final RegistryObject<Item> CHEESE_SHOVEL =
            Registration.ITEMS.register("cheese_shovel",
                    () -> new ShovelItem(ModItemTier.CHEESE, 1.5f, -3f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .addToolType(ToolType.SHOVEL, 2)
                                    .group(CheeseMod.COURSE_TAB)));

    public static final RegistryObject<Item> CHEESE_HOE =
            Registration.ITEMS.register("cheese_hoe",
                    () -> new HoeItem(ModItemTier.CHEESE, -2, -1f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .addToolType(ToolType.HOE, 2)
                                    .group(CheeseMod.COURSE_TAB)));

    public static final RegistryObject<Item> CHEESE_HELMET =
            Registration.ITEMS.register("cheese_helmet",
                    () -> new ArmorItem(ModArmourMaterial.CHEESE, EquipmentSlotType.HEAD,
                            new Item.Properties().group(CheeseMod.COURSE_TAB)));

    public static final RegistryObject<Item> CHEESE_CHESTPLATE =
            Registration.ITEMS.register("cheese_chestplate",
                    () -> new ArmorItem(ModArmourMaterial.CHEESE, EquipmentSlotType.CHEST,
                            new Item.Properties().group(CheeseMod.COURSE_TAB)));

    public static final RegistryObject<Item> CHEESE_LEGGINGS =
            Registration.ITEMS.register("cheese_leggings",
                    () -> new ArmorItem(ModArmourMaterial.CHEESE, EquipmentSlotType.LEGS,
                            new Item.Properties().group(CheeseMod.COURSE_TAB)));

    public static final RegistryObject<Item> CHEESE_BOOTS =
            Registration.ITEMS.register("cheese_boots",
                    () -> new ArmorItem(ModArmourMaterial.CHEESE, EquipmentSlotType.FEET,
                            new Item.Properties().group(CheeseMod.COURSE_TAB)));

    public static final RegistryObject<Item> CHEESE_SEED =
            Registration.ITEMS.register("cheese_seed",
                    () -> new BlockItem(ModBlocks.CHEESE_CROP.get(), new Item.Properties()
                            .group(CheeseMod.COURSE_TAB)));

    public static final RegistryObject<Item> MOLTEN_BUCKET =
            Registration.ITEMS.register("molten_bucket",
                    () -> new BucketItem(ModFluids.MOLTEN_FLUID::get,
                            new Item.Properties().group(CheeseMod.COURSE_TAB).maxStackSize(1)));

    public static final RegistryObject<Item> RAT_SPAWN_EGG =
            Registration.ITEMS.register("rat_spawn_egg",
                    () -> new ModSpawnEggItems(ModEntityTypes.RAT, 0x808080, 0x000000,
                            new Item.Properties().group(CheeseMod.COURSE_TAB).maxStackSize(16).rarity(Rarity.RARE)));


    public static void register() { }

    public enum ModArmourMaterial implements IArmorMaterial
    {
        CHEESE(50, new int[] { 2, 6, 7, 2 }, 10,
                SoundEvents.BLOCK_HONEY_BLOCK_PLACE,
                Ingredient.fromStacks(new ItemStack(ModItems.CHEESE_INGOT.get())),
                CheeseMod.MOD_ID + ":cheese", 1.0f, 0.05f);

        private final int durability;
        private final int[] damadgeReductionArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final Ingredient repairMaterial;
        private final String name;
        private final float toughness;
        private final float knockbackResistance;

        ModArmourMaterial(int durability, int[] damadgeReductionArray, int enchantability,
                          SoundEvent soundEvent, Ingredient repairMaterial, String name,
                          float toughness, float knockbackResistance) {

            this.durability = durability;
            this.damadgeReductionArray = damadgeReductionArray;
            this.enchantability = enchantability;
            this.soundEvent = soundEvent;
            this.repairMaterial = repairMaterial;
            this.name = name;
            this.toughness = toughness;
            this.knockbackResistance = knockbackResistance;
        }

        @Override
        public int getDurability(EquipmentSlotType slotIn)
        {
            return durability;
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn)
        {
            return damadgeReductionArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantability()
        {
            return enchantability;
        }

        @Override
        public SoundEvent getSoundEvent()
        {
            return soundEvent;
        }

        @Override
        public Ingredient getRepairMaterial()
        {
            return repairMaterial;
        }

        @Override
        public String getName()
        {
            return name;
        }

        @Override
        public float getToughness()
        {
            return toughness;
        }

        @Override
        public float getKnockbackResistance()
        {
            return knockbackResistance;
        }
    }

    public enum ModItemTier implements IItemTier
    {
        CHEESE( 2, 905, 7f, 2.5f, 12,
                Ingredient.fromStacks(new ItemStack(ModItems.CHEESE_INGOT.get())));

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamadge;
        private final int enchantability;
        private final Ingredient repairMaterial;

        ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamadge, int enchantability, Ingredient repairMaterial) {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamadge = attackDamadge;
            this.enchantability = enchantability;
            this.repairMaterial = repairMaterial;
        }


        @Override
        public int getMaxUses() {
            return maxUses;
        }

        @Override
        public float getEfficiency() {
            return efficiency;
        }

        @Override
        public float getAttackDamage() {
            return attackDamadge;
        }

        @Override
        public int getHarvestLevel() {
            return harvestLevel;
        }

        @Override
        public int getEnchantability() {
            return enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return repairMaterial;
        }
    }
}
