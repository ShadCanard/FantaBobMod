package com.shadcanard.fbm.armor;

import com.shadcanard.fbm.FantaBobMod;
import com.shadcanard.fbm.items.IItemModelProvider;
import com.shadcanard.fbm.utils.LogHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

/**
 * Created by Shad on 09/02/2016.
 */
public class ArmorFBM extends ItemArmor implements IItemModelProvider {
    protected String name;
    public ArmorFBM(String name, ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType) {
        super(material, renderIndex, armorType);
        this.name = name;
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        setCreativeTab(FantaBobMod.fbmCreativeTabs);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
        return super.onItemRightClick(worldIn, playerIn, hand);
    }

    @Override
    public void registerItemModel(Item item) {
        FantaBobMod.proxy.registerItemRenderer(this, 0, name);
    }
}
