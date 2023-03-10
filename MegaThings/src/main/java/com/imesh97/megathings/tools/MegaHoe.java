package com.imesh97.megathings.tools;

import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class MegaHoe extends HoeItem {
    public MegaHoe() {
        super(ItemToolTier.MEGA, -3, -1.0F, new Item.Properties().group(ItemGroup.TOOLS));
    }
}
