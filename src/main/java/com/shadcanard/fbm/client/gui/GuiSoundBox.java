package com.shadcanard.fbm.client.gui;

import com.shadcanard.fbm.references.Reference;
import com.shadcanard.fbm.utils.SoundHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

import java.io.IOException;

/**
 * Created by ShadCanard on 26/05/2015.
 */
public class GuiSoundBox extends GuiScreen {

    int guiWidth = 248;
    int guiHeight = 166;
    Minecraft mc = Minecraft.getMinecraft();
    GuiButton charaSelectButton, trollButton, greetButton;
    int guiX, guiY;
    EntityPlayer player;
    World world;
    int buttonSizeX = 60;
    int soundButtonX = 75;
    int soundButtonY = 20;
    int buttonSizeY = 20;
    boolean isFantaSelected = true;

    public GuiSoundBox(EntityPlayer player, World world){
        this.player = player;
        this.world = world;
    }

    public void drawScreen(int x, int y, float ticks) {
        guiX = (this.width - guiWidth) / 2;
        guiY = (this.height - guiHeight) / 2;
        GL11.glColor4f(1, 1, 1, 1);
        drawDefaultBackground();
        mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/soundbox.png"));
        drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight);
        super.drawScreen(x, y, ticks);

    }

    @Override
    public void initGui() {
        guiX = (this.width - guiWidth) / 2;
        guiY = (this.height - guiHeight) / 2;

        buttonList.clear();

        //Voice Selection Button
        buttonList.add(charaSelectButton = new GuiButton(0, (this.width - buttonSizeX) / 2, guiY + 5, buttonSizeX, buttonSizeY, "Fanta"));


        //Action Button
        buttonList.add(trollButton = new GuiButton(1, guiX + 10, guiY + 50, soundButtonX, soundButtonY, "Salut"));
        buttonList.add(greetButton = new GuiButton(2, (width - soundButtonX) /2, guiY + 50, soundButtonX, soundButtonY, "Rire"));
        buttonList.add(greetButton = new GuiButton(3,guiX + guiWidth - buttonSizeX - 20, guiY + 50, soundButtonX, soundButtonY, "Bravo !"));
        buttonList.add(trollButton = new GuiButton(4, guiX + 10, guiY + 80, soundButtonX, soundButtonY, "Pas d'couilles!"));
        buttonList.add(greetButton = new GuiButton(5, (width - soundButtonX) /2, guiY + 80, soundButtonX, soundButtonY, "Attaque !"));
        buttonList.add(greetButton = new GuiButton(6,guiX + guiWidth - buttonSizeX - 20, guiY + 80, soundButtonX, soundButtonY, "Retraite !"));
        buttonList.add(trollButton = new GuiButton(7, guiX + 10, guiY + 110, soundButtonX, soundButtonY, "Au revoir !"));
        buttonList.add(greetButton = new GuiButton(8,(width - soundButtonX) /2, guiY + 110, soundButtonX, soundButtonY, "Blague"));
        buttonList.add(greetButton = new GuiButton(9,guiX + guiWidth - buttonSizeX - 20, guiY + 110, soundButtonX, soundButtonY, "Suivre !"));


        super.initGui();
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if(isFantaSelected){
            switch(button.id) {
                case 0:
                    button.displayString = "Bob";
                    isFantaSelected = !isFantaSelected;
                    break;

                default:
                    player.playSound(new SoundEvent(new ResourceLocation("fbm:soundbox.fanta." + SoundHelper.getButtonAction(isFantaSelected,button.id))),1,1);
                    break;
            }
        }else{
            switch(button.id){
                case 0:
                    button.displayString = "Fanta";
                    isFantaSelected = !isFantaSelected;
                    break;

                default:
                    player.playSound(new SoundEvent(new ResourceLocation(("fbm:sound.soundboxbob." + button.id))),1,1);
                    break;
            }
        }
        super.actionPerformed(button);
    }

    @Override
    public void drawBackground(int p_146278_1_) {
        super.drawBackground(p_146278_1_);
    }

}
