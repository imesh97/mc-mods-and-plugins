package com.imesh97.megathings.armor;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class MegaChestplate extends ArmorItem {
    public MegaChestplate() {
        super(ArmorMaterialTier.MEGA, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT));
    }
}