package com.imesh97.megathings.armor;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class MegaBoots extends ArmorItem {
    public MegaBoots() {
        super(ArmorMaterialTier.MEGA, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT));
    }
}