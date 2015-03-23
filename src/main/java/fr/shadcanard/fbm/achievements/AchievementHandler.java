package fr.shadcanard.fbm.achievements;

import fr.shadcanard.fbm.init.ModBlocks;
import fr.shadcanard.fbm.init.ModItems;
import fr.shadcanard.fbm.references.Names;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;

public class AchievementHandler {
    public static Achievement installModAch;
    public static Achievement craftMagabondRecAch;
    public static Achievement getFantaGlassesAch;
    public static Achievement killBobAch;
    public static Achievement killFantaAch;
    public static Achievement killJeanKevinAch;
    public static Achievement floodAch;
    public static Achievement killBotlennonAch;
    public static Achievement getBouseAch;
    public static Achievement brushTeethAch;
    public static Achievement getHairPotionAch;
    public static Achievement getStampCollectionAch;
    public static Achievement getMagabondChopAch;
    public static Achievement getCobbleTieAch;
    public static Achievement getBambooSwordAch;

    public void init(){

        installModAch = new Achievement("achievement." + Names.Achievements.INSTALL_MOD, Names.Achievements.INSTALL_MOD,-2,0,Items.paper,null).initIndependentStat().registerStat();
        killBobAch = new Achievement("achievement." + Names.Achievements.KILL_BOB, Names.Achievements.KILL_BOB, -4,0, Item.getItemFromBlock(Blocks.cobblestone),AchievementList.openInventory).initIndependentStat().registerStat();
        killFantaAch = new Achievement("achievement." + Names.Achievements.KILL_FANTA, Names.Achievements.KILL_FANTA, -6, 0, Items.wooden_sword,AchievementList.openInventory).initIndependentStat().registerStat();
        floodAch = new Achievement("achievement." + Names.Achievements.FLOOD, Names.Achievements.FLOOD, -8,0, Items.lava_bucket, AchievementList.openInventory).initIndependentStat().registerStat();
        killJeanKevinAch = new Achievement("achievement." + Names.Achievements.KILL_JEANKEVIN, Names.Achievements.KILL_JEANKEVIN, -10, 0, Items.arrow, AchievementList.openInventory).initIndependentStat().registerStat();
        killBotlennonAch = new Achievement("achievement." + Names.Achievements.KILL_BOT, Names.Achievements.KILL_BOT, -12, 0, Items.iron_ingot, AchievementList.openInventory).initIndependentStat().registerStat();
        getBouseAch = new Achievement("achievement." + Names.Achievements.GET_BOUSE, Names.Achievements.GET_BOUSE, -14, 0, ModBlocks.blockBouze, AchievementList.openInventory).initIndependentStat().registerStat();
        brushTeethAch = new Achievement("achievement." + Names.Achievements.BRUSH_TEETH, Names.Achievements.BRUSH_TEETH, -14, 2, ModItems.toothBrush, AchievementList.openInventory).initIndependentStat().registerStat();
        getHairPotionAch = new Achievement("achievement." + Names.Achievements.GET_HAIR_POTION, Names.Achievements.GET_HAIR_POTION, -12, 2, ModItems.hairPotion, AchievementList.openInventory).initIndependentStat().registerStat();
        getStampCollectionAch = new Achievement("achievement." + Names.Achievements.GET_STAMP_COLLECTION, Names.Achievements.GET_STAMP_COLLECTION, -10,2,ModItems.stampCollection,AchievementList.openInventory).initIndependentStat().registerStat();
        getCobbleTieAch = new Achievement("achievement." + Names.Achievements.GET_COBBLE_TIE, Names.Achievements.GET_COBBLE_TIE, -8, 2, ModItems.cobbleTie, AchievementList.openInventory).initIndependentStat().registerStat();
        getBambooSwordAch = new Achievement("achievement." + Names.Achievements.GET_BAMBOO_SWORD,Names.Achievements.GET_BAMBOO_SWORD,-6,2,ModItems.bambooSword,AchievementList.openInventory).initIndependentStat().registerStat();
        getMagabondChopAch = new Achievement("achievement." + Names.Achievements.GET_MAGABOND_CHOP, Names.Achievements.GET_MAGABOND_CHOP, -8, -2, ModItems.magabondChop, killJeanKevinAch).initIndependentStat().registerStat();
        craftMagabondRecAch = new Achievement("achievement."+Names.Achievements.CRAFT_MAGABOND_REC,Names.Achievements.CRAFT_MAGABOND_REC,-10,-2, ModItems.magabondRecord, killJeanKevinAch).initIndependentStat().registerStat();
        getFantaGlassesAch = new Achievement("achievement." + Names.Achievements.GET_FANTA_GLASSES, Names.Achievements.GET_FANTA_GLASSES, -6, -2, ModItems.fantaGlasses, killFantaAch).initIndependentStat().registerStat();

    }
}
