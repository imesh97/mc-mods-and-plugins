package com.imesh97.megathings.tools;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;

public class MegaShovel extends ShovelItem {
    public MegaShovel() {
        super(ItemToolTier.MEGA, 0, -3.0F, new Item.Properties().group(ItemGroup.TOOLS));
    }
}
