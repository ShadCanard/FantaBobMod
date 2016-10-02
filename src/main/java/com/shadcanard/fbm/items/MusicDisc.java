package com.shadcanard.fbm.items;


import com.shadcanard.fbm.FantaBobMod;
import com.shadcanard.fbm.references.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.translation.I18n;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MusicDisc extends ItemRecord implements IItemModelProvider
{
    private static final Map records = new HashMap();


    public final String recordName;


    public MusicDisc(String recordName)
    {
        super(recordName, new SoundEvent(new ResourceLocation("fbm:records." + recordName)));

        this.recordName = recordName;
        this.maxStackSize = 1;
        setCreativeTab(FantaBobMod.fbmCreativeTabs);
        setRegistryName(recordName);
        records.put(recordName, this);
    }


    @Override
    public String toString() {
        return Reference.MOD_ID + ":" + this.recordName;
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        par3List.add(this.getRecordNameLocal());
    }


    @Override
    //TODO: getRecordTitle()
    public String getRecordNameLocal()
    {
        return I18n.translateToLocal(this.getUnlocalizedName() + ".desc");
    }


    @Override
    public EnumRarity getRarity(ItemStack itemStack)
    {
        return EnumRarity.RARE;
    }


    public static MusicDisc getRecord(String par0Str)
    {
        return (MusicDisc)records.get(par0Str);
    }


    @Override
    public ResourceLocation getRecordResource(String name)
    {
        return new ResourceLocation(Reference.MOD_ID, name);
    }

    @Override
    public void registerItemModel(Item item) {
        FantaBobMod.proxy.registerItemRenderer(this, 0, recordName);
    }
}