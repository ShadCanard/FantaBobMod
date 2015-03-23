package fr.shadcanard.fbm.achievements;

import fr.shadcanard.fbm.init.ModBlocks;
import fr.shadcanard.fbm.init.ModItems;
import fr.shadcanard.fbm.references.Names;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;

import java.util.ArrayList;
import java.util.List;

public class AchievementHandler {

    public List achievementList = new ArrayList();

    public static Achievement installModAch = new Achievement("achievement." + Names.Achievements.INSTALL_MOD, Names.Achievements.INSTALL_MOD,-2,0,Items.paper,null).initIndependentStat().registerStat();
    public static Achievement killBobAch = new Achievement("achievement." + Names.Achievements.KILL_BOB, Names.Achievements.KILL_BOB, -4,0, Item.getItemFromBlock(Blocks.cobblestone),AchievementList.openInventory).initIndependentStat().registerStat();
    public static Achievement killFantaAch = new Achievement("achievement." + Names.Achievements.KILL_FANTA, Names.Achievements.KILL_FANTA, -6, 0, Items.wooden_sword,AchievementList.openInventory).registerStat();
    public static Achievement floodAch = new Achievement("achievement." + Names.Achievements.FLOOD, Names.Achievements.FLOOD, -8,0, Items.lava_bucket, AchievementList.openInventory).registerStat();
    public static Achievement killJeanKevinAch = new Achievement("achievement." + Names.Achievements.KILL_JEANKEVIN, Names.Achievements.KILL_JEANKEVIN, -10, 0, Items.arrow, AchievementList.openInventory).registerStat();
    public static Achievement killBotlennonAch = new Achievement("achievement." + Names.Achievements.KILL_BOT, Names.Achievements.KILL_BOT, -12, 0, Items.iron_ingot, AchievementList.openInventory).registerStat();
    public static Achievement getBouseAch = new Achievement("achievement." + Names.Achievements.GET_BOUSE, Names.Achievements.GET_BOUSE, -14, 0, ModBlocks.blockBouze, AchievementList.openInventory).registerStat();
    public static Achievement brushTeethAch = new Achievement("achievement." + Names.Achievements.BRUSH_TEETH, Names.Achievements.BRUSH_TEETH, -14, 2, ModItems.toothBrush, AchievementList.openInventory).registerStat();
    public static Achievement getHairPotionAch = new Achievement("achievement." + Names.Achievements.GET_HAIR_POTION, Names.Achievements.GET_HAIR_POTION, -12, 2, ModItems.hairPotion, AchievementList.openInventory).registerStat();
    public static Achievement getStampCollectionAch = new Achievement("achievement." + Names.Achievements.GET_STAMP_COLLECTION, Names.Achievements.GET_STAMP_COLLECTION, -10,2,ModItems.stampCollection,AchievementList.openInventory).registerStat();
    public static Achievement getCobbleTieAch = new Achievement("achievement." + Names.Achievements.GET_COBBLE_TIE, Names.Achievements.GET_COBBLE_TIE, -8, 2, ModItems.cobbleTie, AchievementList.openInventory).registerStat();
    public static Achievement getBambooSwordAch = new Achievement("achievement." + Names.Achievements.GET_BAMBOO_SWORD,Names.Achievements.GET_BAMBOO_SWORD,-6,2,ModItems.bambooSword,AchievementList.openInventory).registerStat();
    public static Achievement getMagabondChopAch = new Achievement("achievement." + Names.Achievements.GET_MAGABOND_CHOP, Names.Achievements.GET_MAGABOND_CHOP, -8, -2, ModItems.magabondChop, killJeanKevinAch).registerStat();
    public static Achievement craftMagabondRecAch = new Achievement("achievement."+Names.Achievements.CRAFT_MAGABOND_REC,Names.Achievements.CRAFT_MAGABOND_REC,-10,-2, ModItems.magabondRecord, killJeanKevinAch).registerStat();
    public static Achievement getFantaGlassesAch = new Achievement("achievement." + Names.Achievements.GET_FANTA_GLASSES, Names.Achievements.GET_FANTA_GLASSES, -6, -2, ModItems.fantaGlasses, killFantaAch).registerStat();

    public void init(){

    }
}
