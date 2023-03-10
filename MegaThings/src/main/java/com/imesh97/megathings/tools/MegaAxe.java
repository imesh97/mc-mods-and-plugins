package com.imesh97.megathings.tools;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class MegaAxe extends AxeItem {
    public MegaAxe() {
        super(ItemToolTier.MEGA, 2, -3.1F, new Item.Properties().group(ItemGroup.TOOLS));
    }
}
