package com.imesh97.megathings.armor;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class MegaHelmet extends ArmorItem {
    public MegaHelmet() {
        super(ArmorMaterialTier.MEGA, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT));
    }
}
