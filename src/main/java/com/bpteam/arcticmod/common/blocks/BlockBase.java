package com.bpteam.arcticmod.common.blocks;

import com.bpteam.arcticmod.ArcticMod;
import com.bpteam.arcticmod.init.ModBlocks;
import com.bpteam.arcticmod.init.ModItems;
import com.bpteam.arcticmod.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {
    public BlockBase(String name, Material material) {
        super(material);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(ArcticMod.blocks);
        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        ArcticMod.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

}
