package com.imesh97.megathings.util;

import com.imesh97.megathings.MegaThings;
import com.imesh97.megathings.armor.MegaBoots;
import com.imesh97.megathings.armor.MegaChestplate;
import com.imesh97.megathings.armor.MegaHelmet;
import com.imesh97.megathings.armor.MegaLeggings;
import com.imesh97.megathings.blocks.MegaBlock;
import com.imesh97.megathings.entities.EntityDog;
import com.imesh97.megathings.items.EntityDogSpawnEgg;
import com.imesh97.megathings.items.MegaBlockItem;
import com.imesh97.megathings.items.MegaParticle;
import com.imesh97.megathings.tools.*;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MegaThings.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MegaThings.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MegaThings.MOD_ID);

    public static final RegistryObject<Item> MEGA_PARTICLE = ITEMS.register("mega_particle", MegaParticle::new);
    public static final RegistryObject<Block> MEGA_BLOCK = BLOCKS.register("mega_block", MegaBlock::new);
    public static final RegistryObject<Item> MEGA_BLOCK_ITEM = ITEMS.register("mega_block", () -> new MegaBlockItem(MEGA_BLOCK.get()));

    public static final RegistryObject<EntityDogSpawnEgg> DOG_SPAWN_EGG = ITEMS.register("dog_spawn_egg", () -> new EntityDogSpawnEgg(RegistryHandler.DOG, 0xEC7E09, 0x834C11, new Item.Properties().group(ItemGroup.MISC)));

    public static final RegistryObject<Item> MEGA_SWORD = ITEMS.register("mega_sword", MegaSword::new);
    public static final RegistryObject<Item> MEGA_PICKAXE = ITEMS.register("mega_pickaxe", MegaPickaxe::new);
    public static final RegistryObject<Item> MEGA_AXE = ITEMS.register("mega_axe", MegaAxe::new);
    public static final RegistryObject<Item> MEGA_HOE = ITEMS.register("mega_hoe", MegaHoe::new);
    public static final RegistryObject<Item> MEGA_SHOVEL = ITEMS.register("mega_shovel", MegaShovel::new);

    public static final RegistryObject<ArmorItem> MEGA_HELMET = ITEMS.register("mega_helmet", MegaHelmet::new);
    public static final RegistryObject<ArmorItem> MEGA_CHESTPLATE = ITEMS.register("mega_chestplate", MegaChestplate::new);
    public static final RegistryObject<ArmorItem> MEGA_LEGGINGS = ITEMS.register("mega_leggings", MegaLeggings::new);
    public static final RegistryObject<ArmorItem> MEGA_BOOTS = ITEMS.register("mega_boots", MegaBoots::new);

    public static final RegistryObject<EntityType<EntityDog>> DOG = ENTITIES.register("dog",
            () -> EntityType.Builder.create(EntityDog::new, EntityClassification.CREATURE)
            .size(1.0f, 1.0f)
            .build(new ResourceLocation(MegaThings.MOD_ID, "dog").toString())
    );

    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
