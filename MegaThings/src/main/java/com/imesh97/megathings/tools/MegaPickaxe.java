package com.imesh97.megathings.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;

public class MegaPickaxe extends PickaxeItem {
    public MegaPickaxe() {
        super(ItemToolTier.MEGA, 1, -2.8F, new Item.Properties().group(ItemGroup.TOOLS));
    }
}
