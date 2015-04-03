package fr.shadcanard.fbm.handler;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.shadcanard.fbm.init.ModArmor;
import fr.shadcanard.fbm.init.ModBlocks;
import fr.shadcanard.fbm.init.ModItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CraftingHandler {

    public static void init(){

        ItemStack pyroAxeEnchanted = new ItemStack(ModItems.pyroAxe);
        pyroAxeEnchanted.addEnchantment(Enchantment.fireAspect,2);

        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blockBouze, 16), new ItemStack(Blocks.dirt), new ItemStack(Items.water_bucket));
        GameRegistry.addShapedRecipe(pyroAxeEnchanted, "xxx","xyx","xxx",'x',new ItemStack(Items.flint_and_steel), 'y', new ItemStack(ModItems.bobAxe));
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.bambooSword, 1), "x", "x", "y", 'y', Items.stick, 'x', new ItemStack(Items.reeds));
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.bobAxe, 1), "xxx", "xyx", " y ", 'x', Items.diamond, 'y', Items.stick);
        GameRegistry.addRecipe(new ItemStack(ModArmor.cobbleTie,1), "y","x","x", 'y',Items.string, 'x',new ItemStack(Blocks.cobblestone));
        GameRegistry.addRecipe(new ItemStack(ModItems.toothBrush), "x  ","yyy",'x', new ItemStack(Blocks.obsidian), 'y',new ItemStack(Blocks.wool));
        GameRegistry.addRecipe(new ItemStack(ModItems.stampCollection),"xyy","xyy","xyy", 'x', Items.leather, 'y', Items.paper);
        GameRegistry.addRecipe(new ItemStack(ModArmor.hairPotion,1), " x ", "xyx"," x ",'x',new ItemStack(Blocks.glass),'y',ModItems.magabondChop);
        GameRegistry.addRecipe(new ItemStack(ModArmor.fantaGlasses, 1), "y y", "y y", "xyx",'x',new ItemStack(Blocks.glass_pane), 'y', Items.stick);
        GameRegistry.addRecipe(new ItemStack(ModItems.record_magabondMix)," x ","xyx"," x ",'y', ModItems.magabondChop, 'x', new ItemStack(Blocks.coal_block));
        GameRegistry.addRecipe(new ItemStack(ModItems.record_pyrobarbare,1)," x ","xyx", " x ", 'x', Blocks.coal_block, 'y', ModItems.bobAxe);
        GameRegistry.addRecipe(new ItemStack(ModItems.record_Avion,1)," x ","xyx", " x ", 'x', new ItemStack(Blocks.coal_block), 'y', new ItemStack(ModArmor.fantaGlasses));
        GameRegistry.addRecipe(new ItemStack(Items.saddle), "xxx","x x","y y", 'x', Items.leather, 'y', new ItemStack(Blocks.iron_block));
        GameRegistry.addRecipe(new ItemStack(Items.diamond_horse_armor), "  x","xxx","x x", 'x', new ItemStack(Blocks.diamond_block));
        GameRegistry.addRecipe(new ItemStack(Items.golden_horse_armor), "  x","xxx","x x", 'x', new ItemStack(Blocks.gold_block));
        GameRegistry.addRecipe(new ItemStack(Items.iron_horse_armor), "  x","xxx","x x", 'x', new ItemStack(Blocks.iron_block));
        GameRegistry.addRecipe(new ItemStack(Items.iron_horse_armor), "  x","xxx","x x", 'x', new ItemStack(Blocks.iron_block));
    }
}
