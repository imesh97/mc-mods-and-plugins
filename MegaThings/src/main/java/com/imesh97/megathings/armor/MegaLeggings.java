package com.imesh97.megathings.armor;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class MegaLeggings extends ArmorItem {
    public MegaLeggings() {
        super(ArmorMaterialTier.MEGA, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT));
    }
}