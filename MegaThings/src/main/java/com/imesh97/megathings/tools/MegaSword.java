package com.imesh97.megathings.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;

public class MegaSword extends SwordItem {
    public MegaSword() {
        super(ItemToolTier.MEGA, 3, -2.4F, new Item.Properties().group(ItemGroup.COMBAT));
    }
}
