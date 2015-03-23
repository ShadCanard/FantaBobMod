package fr.shadcanard.fbm.armor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.shadcanard.fbm.FantaBobMod;
import fr.shadcanard.fbm.init.ModArmor;
import fr.shadcanard.fbm.references.Names;
import fr.shadcanard.fbm.references.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class FBMArmor extends ItemArmor {
    public FBMArmor(ArmorMaterial armorMaterial, int par1, int par2, boolean isBob) {
        super(armorMaterial, par1, par2);
        this.setCreativeTab(FantaBobMod.fbmCreativeTabs);
        if((par2 == 0) && isBob){
            this.setUnlocalizedName(Names.Items.HAIR_POTION);
        }else if((par2 == 0 && !isBob)){
            this.setUnlocalizedName(Names.Items.FANTA_GLASSES);
        }else{
            this.setUnlocalizedName(Names.Items.COBBLE_TIE);
        }
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        if(stack.getItem() == ModArmor.fantaGlasses || stack.getItem() == ModArmor.cobbleTie){
            return new ResourceLocation(Reference.MOD_ID,"textures/armor/fantabob_1.png").toString();
        }else if(stack.getItem() == ModArmor.hairPotion){
            return new ResourceLocation(Reference.MOD_ID,"textures/armor/fantabob2_1.png").toString();
        }else{
            return "error";
        }
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
