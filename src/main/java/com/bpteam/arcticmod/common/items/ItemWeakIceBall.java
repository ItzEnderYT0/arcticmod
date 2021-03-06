package com.bpteam.arcticmod.common.items;

import com.bpteam.arcticmod.ArcticMod;
import com.bpteam.arcticmod.common.entities.EntityWeakIceBall;
import com.bpteam.arcticmod.init.ModItems;
import com.bpteam.arcticmod.util.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemWeakIceBall extends Item implements IHasModel {

    public ItemWeakIceBall(String name) {
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(ArcticMod.items);

        ModItems.ITEMS.add(this);
    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (!worldIn.isRemote) {
            EntityWeakIceBall ice = new EntityWeakIceBall(worldIn, playerIn);
            ice.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
            worldIn.spawnEntity(ice);
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public void registerModels() {
        ArcticMod.proxy.registerItemRenderer(this, 0, "inventory");
    }
}


