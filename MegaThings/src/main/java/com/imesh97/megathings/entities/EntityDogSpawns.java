package com.imesh97.megathings.entities;

import com.imesh97.megathings.MegaThings;
import com.imesh97.megathings.items.EntityDogSpawnEgg;
import com.imesh97.megathings.util.RegistryHandler;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = MegaThings.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityDogSpawns {

    @SubscribeEvent
    public static void spawnEntityDog(FMLLoadCompleteEvent event){
        for(Biome biome : ForgeRegistries.BIOMES){
            if(biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND && biome.getCategory() != Biome.Category.OCEAN){
                biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(RegistryHandler.DOG.get(), 8, 2, 4));
            }
        }
    }

    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
        EntityDogSpawnEgg.initDogSpawnEggs();
    }
}
