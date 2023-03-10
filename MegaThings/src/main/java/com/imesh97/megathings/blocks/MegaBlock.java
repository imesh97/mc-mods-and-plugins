package com.imesh97.megathings.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class MegaBlock extends Block {
    public MegaBlock() {
        super(Block.Properties.create(Material.IRON)
        .hardnessAndResistance(10.0f, -1.0f)
        .harvestLevel(3)
        .harvestTool(ToolType.PICKAXE)
        .sound(SoundType.METAL));
    }
}
