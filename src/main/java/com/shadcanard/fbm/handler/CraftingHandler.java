package com.shadcanard.fbm.handler;

import com.shadcanard.fbm.init.ModArmor;
import com.shadcanard.fbm.init.ModBlocks;
import com.shadcanard.fbm.init.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftingHandler {

    public static void init(){

        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blockBouze, 16), new ItemStack(Blocks.DIRT), new ItemStack(Items.WATER_BUCKET));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.mamelouCheese,8), new ItemStack(ModItems.mamelouBucket));
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.pyroAxe,1), "xxx","xyx","xxx",'x',new ItemStack(Items.FLINT_AND_STEEL), 'y', new ItemStack(ModItems.bobAxe));
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.bambooSword, 1), "x", "x", "y", 'y', Items.STICK, 'x', new ItemStack(Items.REEDS));
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.bobAxe, 1), "xxx", "xyx", " y ", 'x', Items.DIAMOND, 'y', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(ModArmor.cobbleTie,1), " y "," x "," x ", 'y',Items.STRING, 'x',new ItemStack(Blocks.COBBLESTONE));
        GameRegistry.addRecipe(new ItemStack(ModItems.toothBrush), "x  ","yyy",'x', new ItemStack(Blocks.WOOL), 'y',new ItemStack(Blocks.OBSIDIAN));
        GameRegistry.addRecipe(new ItemStack(ModItems.stampCollection),"xyy","xyy","xyy", 'x', Items.LEATHER, 'y', Items.PAPER);
        GameRegistry.addRecipe(new ItemStack(ModArmor.hairPotion,1), " x ", "xyx"," x ",'x',new ItemStack(Blocks.GLASS),'y',ModItems.magabondChop);
        GameRegistry.addRecipe(new ItemStack(ModArmor.fantaGlasses, 1), "y y", "y y", "xyx",'x',new ItemStack(Blocks.GLASS_PANE), 'y', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(ModItems.record_magabondMix)," x ","xyx"," x ",'y', ModItems.magabondChop, 'x', new ItemStack(Blocks.COAL_BLOCK));
        GameRegistry.addRecipe(new ItemStack(ModItems.record_pyrobarbare,1)," x ","xyx", " x ", 'x', Blocks.COAL_BLOCK, 'y', ModItems.bobAxe);
        GameRegistry.addRecipe(new ItemStack(ModItems.record_Avion,1)," x ","xyx", " x ", 'x', new ItemStack(Blocks.COAL_BLOCK), 'y', new ItemStack(ModArmor.fantaGlasses));
        GameRegistry.addRecipe(new ItemStack(Items.SADDLE), "xxx","x x","y y", 'x', Items.LEATHER, 'y', new ItemStack(Blocks.IRON_BLOCK));
        GameRegistry.addRecipe(new ItemStack(Items.DIAMOND), "  x","xxx","x x", 'x', new ItemStack(Blocks.DIAMOND_BLOCK));
        GameRegistry.addRecipe(new ItemStack(Items.GOLDEN_HORSE_ARMOR), "  x","xxx","x x", 'x', new ItemStack(Blocks.GOLD_BLOCK));
        GameRegistry.addRecipe(new ItemStack(Items.IRON_HORSE_ARMOR), "  x","xxx","x x", 'x', new ItemStack(Blocks.IRON_BLOCK));
        GameRegistry.addRecipe(new ItemStack(ModItems.clementine), "  x"," y ","z  ",'x',new ItemStack(ModItems.clementine_top), 'y', new ItemStack(ModItems.clementine_head), 'z', new ItemStack(ModItems.clementine_body));
        GameRegistry.addRecipe(new ItemStack(ModItems.clementine_head), " xy", "xyx", "yx ", 'y', new ItemStack(ModItems.clementine_string), 'x', new ItemStack(Blocks.PLANKS));
        GameRegistry.addRecipe(new ItemStack(ModItems.clementine_string), "xxx",'x',new ItemStack(Items.IRON_INGOT));
        GameRegistry.addRecipe(new ItemStack(ModItems.clementine_top), "xyx","xyx","xyx",'x',new ItemStack(Items.GOLD_NUGGET), 'y', new ItemStack(Blocks.PLANKS));
        GameRegistry.addRecipe(new ItemStack(ModItems.clementine_body), " xy","xyx"," x ",'x',new ItemStack(Blocks.PLANKS), 'y', new ItemStack(Items.STICK));
        GameRegistry.addRecipe(new ItemStack(Items.SPAWN_EGG,1,3), "xxx","xyx","xxx",'x', Item.getItemFromBlock(Blocks.GOLD_BLOCK),'y',Items.EGG);
        GameRegistry.addRecipe(new ItemStack(Items.SPAWN_EGG,1,4), "xxx","xyx","xxx",'x', Item.getItemFromBlock(Blocks.WOOL),'y',Items.EGG);
        GameRegistry.addRecipe(new ItemStack(Items.SPAWN_EGG,1,6), "xxx","xyx","xxx",'x', Item.getItemFromBlock(Blocks.DIRT),'y',Items.EGG);
        GameRegistry.addRecipe(new ItemStack(ModItems.itemArgent,8), "xxx","xyx","xxx",'x', Items.GOLD_INGOT, 'y', Items.PAPER);
    }
}
