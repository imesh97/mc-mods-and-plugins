package com.imesh97.megathings.items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class MegaBlockItem extends BlockItem {
    public MegaBlockItem(Block blockIn) {
        super(blockIn, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
    }
}
