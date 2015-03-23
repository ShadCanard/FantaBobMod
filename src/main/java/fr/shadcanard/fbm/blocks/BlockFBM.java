package fr.shadcanard.fbm.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.shadcanard.fbm.FantaBobMod;
import fr.shadcanard.fbm.references.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockFBM extends Block {
        public BlockFBM(Material material)
        {
            super(material);
            this.setCreativeTab(FantaBobMod.fbmCreativeTabs);
        }

        public BlockFBM()
        {
            this(Material.rock);
            this.setCreativeTab(FantaBobMod.fbmCreativeTabs);
        }

        @Override
        public String getUnlocalizedName()
        {
            return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
        }
        @Override
        @SideOnly(Side.CLIENT)
        public void registerBlockIcons(IIconRegister iconRegister)
        {
            blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
        }
        protected String getUnwrappedUnlocalizedName(String unlocalizedName)
        {
            return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
        }
    }