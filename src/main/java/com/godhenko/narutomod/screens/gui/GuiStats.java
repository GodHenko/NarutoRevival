package com.godhenko.narutomod.screens.gui;

import com.godhenko.narutomod.NarutoMod;
import com.godhenko.narutomod.data.capabilities.CapabilityData;
import com.godhenko.narutomod.data.capabilities.Data;
import com.godhenko.narutomod.data.capabilities.DataProvider;
import com.godhenko.narutomod.data.capabilities.IData;
import com.godhenko.narutomod.network.Networking;
import com.godhenko.narutomod.network.packets.PacketHealth;
import com.godhenko.narutomod.network.packets.serverpackets.*;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.renderer.RenderState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fml.client.gui.widget.ExtendedButton;

import java.awt.*;

public class GuiStats extends Screen {

    private static final ResourceLocation BG_TEXTURE = new ResourceLocation(NarutoMod.MOD_ID, "textures/gui/background.png");
    PlayerEntity player;
    ExtendedButton addStat;
    ExtendedButton addStat1;
    ExtendedButton addStat2;
    ExtendedButton addStat3;
    ExtendedButton addStat4;
    ExtendedButton addStat5;
    ExtendedButton addStat6;
    ExtendedButton addStat7;
    ExtendedButton addStat8;
    ExtendedButton addStat9;

    public GuiStats(PlayerEntity player) {
        super((ITextComponent) new TranslationTextComponent("narutomod.stats.gui"));
        this.player = player;
    }

    @Override
    protected void init() {
        int x = (width - 247) / 2;
        int y = (height - 166) / 2;

        addStat = addButton(new ExtendedButton(x - 11, y + 8, 11, 11, new TranslationTextComponent("gui.addStat"), button -> addStat(1)));

        addStat1 = addButton(new ExtendedButton(x - 11, y + 18, 11, 11, new TranslationTextComponent("gui.addStat"), button -> addStat(2)));

        addStat2 = addButton(new ExtendedButton(x - 11, y + 28, 11, 11, new TranslationTextComponent("gui.addStat"), button -> addStat(3)));

        addStat3 = addButton(new ExtendedButton(x - 11, y + 38, 11, 11, new TranslationTextComponent("gui.addStat"), button -> addStat(4)));

        addStat4 = addButton(new ExtendedButton(x - 11, y + 48, 11, 11, new TranslationTextComponent("gui.addStat"), button -> addStat(5)));

        addStat5 = addButton(new ExtendedButton(x - 11, y + 58, 11, 11, new TranslationTextComponent("gui.addStat"), button -> addStat(6)));

        addStat6 = addButton(new ExtendedButton(x - 11, y + 68, 11, 11, new TranslationTextComponent("gui.addStat"), button -> addStat(7)));

        addStat7 = addButton(new ExtendedButton(x - 11, y + 78, 11, 11, new TranslationTextComponent("gui.addStat"), button -> addStat(8)));

        addStat8 = addButton(new ExtendedButton(x - 11, y + 88, 11, 11, new TranslationTextComponent("gui.addStat"), button -> addStat(9)));

        addStat9 = addButton(new ExtendedButton(x - 11, y + 98, 11, 11, new TranslationTextComponent("gui.addStat"), button -> addStat(10)));
    }

    private void addStat(int type){
        player.getCapability(CapabilityData.ENTITY_DATA_CAPABILITY).ifPresent(data -> {
            switch(type){
                case 1:
                    if (data.getSkillpoints() > 0) {
                        data.setGenjutsu(data.getGenjutsu() + 1);
                        Networking.sendToServer(new PacketGenjutsuServer(data.getGenjutsu()));
                        data.setSkillpoints(data.getSkillpoints() - 1);
                        Networking.sendToServer(new PacketSkillpointsServer(data.getSkillpoints()));
                    }
                    else{
                        String message = String.format("You do not have enough Skillpoints to do that!", Color.red.getRGB());
                        ITextComponent msg = new StringTextComponent(message);
                        player.sendMessage(msg, player.getUniqueID());
                    }
                    break;
                case 2:
                    if (data.getSkillpoints() > 0) {
                        data.setMedical(data.getMedical() + 1);
                        Networking.sendToServer(new PacketMedicalServer(data.getMedical()));
                        data.setSkillpoints(data.getSkillpoints() - 1);
                        Networking.sendToServer(new PacketSkillpointsServer(data.getSkillpoints()));
                        data.setHealth(data.getHealth() + 1);
                        Networking.sendToServer(new PacketHealth(data.getHealth()));
                        Networking.sendToServer(new PacketSetHealthServer(1));
                    }
                    else{
                        String message = String.format("You do not have enough Skillpoints to do that!", Color.red.getRGB());
                        ITextComponent msg = new StringTextComponent(message);
                        player.sendMessage(msg, player.getUniqueID());
                    }
                    break;
                case 3:
                    if (data.getSkillpoints() > 0) {
                        data.setNinjutsu(data.getNinjutsu() + 1);
                        Networking.sendToServer(new PacketNinjutsuServer(data.getNinjutsu()));
                        data.setSkillpoints(data.getSkillpoints() - 1);
                        Networking.sendToServer(new PacketSkillpointsServer(data.getSkillpoints()));
                    }
                    else{
                        String message = String.format("You do not have enough Skillpoints to do that!", Color.red.getRGB());
                        ITextComponent msg = new StringTextComponent(message);
                        player.sendMessage(msg, player.getUniqueID());
                    }
                    break;
                case 4:
                    if (data.getSkillpoints() > 0) {
                        data.setTaijutsu(data.getTaijutsu() + 1);
                        Networking.sendToServer(new PacketTaijutsuServer(data.getTaijutsu()));
                        data.setSkillpoints(data.getSkillpoints() - 1);
                        Networking.sendToServer(new PacketSkillpointsServer(data.getSkillpoints()));
                    }
                    else{
                        String message = String.format("You do not have enough Skillpoints to do that!", Color.red.getRGB());
                        ITextComponent msg = new StringTextComponent(message);
                        player.sendMessage(msg, player.getUniqueID());
                    }
                    break;

                case 5:
                    if (data.getSkillpoints() > 0) {
                        data.setKenjutsu(data.getKenjutsu() + 1);
                        Networking.sendToServer(new PacketKenjutsuServer(data.getKenjutsu()));
                        data.setSkillpoints(data.getSkillpoints() - 1);
                        Networking.sendToServer(new PacketSkillpointsServer(data.getSkillpoints()));
                    }
                    else{
                        String message = String.format("You do not have enough Skillpoints to do that!", Color.red.getRGB());
                        ITextComponent msg = new StringTextComponent(message);
                        player.sendMessage(msg, player.getUniqueID());
                    }
                    break;
                case 6:
                    if (data.getSkillpoints() > 0) {
                        data.setSpeed(data.getSpeed() + 1);
                        Networking.sendToServer(new PacketSpeedServer(data.getSpeed()));
                        data.setSkillpoints(data.getSkillpoints() - 1);
                        Networking.sendToServer(new PacketSkillpointsServer(data.getSkillpoints()));
                    }
                    else{
                        String message = String.format("You do not have enough Skillpoints to do that!", Color.red.getRGB());
                        ITextComponent msg = new StringTextComponent(message);
                        player.sendMessage(msg, player.getUniqueID());
                    }
                    break;

                case 7:
                    if (data.getSkillpoints() > 0) {
                        data.setShurikenJutsu(data.getShurikenJutsu() + 1);
                        Networking.sendToServer(new PacketShurikenjutsuServer(data.getShurikenJutsu()));
                        data.setSkillpoints(data.getSkillpoints() - 1);
                        Networking.sendToServer(new PacketSkillpointsServer(data.getSkillpoints()));
                    }
                    else{
                        String message = String.format("You do not have enough Skillpoints to do that!", Color.red.getRGB());
                        ITextComponent msg = new StringTextComponent(message);
                        player.sendMessage(msg, player.getUniqueID());
                    }
                    break;

                case 8:
                    if (data.getSkillpoints() > 0) {
                        data.setSummoning(data.getSummoning() + 1);
                        Networking.sendToServer(new PacketSummoningServer(data.getSummoning()));
                        data.setSkillpoints(data.getSkillpoints() - 1);
                        Networking.sendToServer(new PacketSkillpointsServer(data.getSkillpoints()));
                    }
                    else{
                        String message = String.format("You do not have enough Skillpoints to do that!", Color.red.getRGB());
                        ITextComponent msg = new StringTextComponent(message);
                        player.sendMessage(msg, player.getUniqueID());
                    }
                    break;

                case 9:
                    if (data.getSkillpoints() > 0) {
                        data.setKinjutsu(data.getKinjutsu() + 1);
                        Networking.sendToServer(new PacketKinjutsuServer(data.getKinjutsu()));
                        data.setSkillpoints(data.getSkillpoints() - 1);
                        Networking.sendToServer(new PacketSkillpointsServer(data.getSkillpoints()));
                    }
                    else{
                        String message = String.format("You do not have enough Skillpoints to do that!", Color.red.getRGB());
                        ITextComponent msg = new StringTextComponent(message);
                        player.sendMessage(msg, player.getUniqueID());
                    }
                    break;

                case 10:
                    if (data.getSkillpoints() > 0) {
                        data.setSenjutsu(data.getSenjutsu() + 1);
                        Networking.sendToServer(new PacketSenjutsuServer(data.getSenjutsu()));
                        data.setSkillpoints(data.getSkillpoints() - 1);
                        Networking.sendToServer(new PacketSkillpointsServer(data.getSkillpoints()));
                    }
                    else{
                        String message = String.format("You do not have enough Skillpoints to do that!", Color.red.getRGB());
                        ITextComponent msg = new StringTextComponent(message);
                        player.sendMessage(msg, player.getUniqueID());
                    }
                    break;
            }
        });
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        int xSize = 247;
        int ySize = 166;
        int x = (width - 247) / 2;
        int y = (height - 166) / 2;
        int scale = 1;
        FontRenderer fr = minecraft.fontRenderer;
        GlStateManager.scalef(1F, 1F, 1F);
        this.getMinecraft().getTextureManager().bindTexture(BG_TEXTURE);
        blit(matrixStack, (Math.round((width / 2f) / scale) - Math.round(xSize / 2)), (Math.round(height / 2) / scale) - Math.round(ySize / 2) , 0, 22, xSize, ySize );
        player.getCapability(CapabilityData.ENTITY_DATA_CAPABILITY).ifPresent(data -> {
            fr.drawString(matrixStack, "Level: " + data.getLevel(), x + 192, y + 8, Color.RED.getRGB());
            fr.drawString(matrixStack, "Exp: " + data.getExp() + "/" + data.getLevel() * 5, x + 192, y + 18, Color.RED.getRGB());
            fr.drawString(matrixStack,"Ninjutsu: " + data.getNinjutsu(),x +8,y + 8, Color.RED.getRed());
            fr.drawString(matrixStack,"Taijutsu: " + data.getTaijutsu(),x +8,y + 18, Color.RED.getRed());
            fr.drawString(matrixStack,"Genjutsu: " + data.getGenjutsu(),x +8,y + 28, Color.RED.getRed());
            fr.drawString(matrixStack,"Kenjutsu: " + data.getKenjutsu(),x +8,y + 38, Color.RED.getRed());
            fr.drawString(matrixStack,"Shurikenjutsu: " + data.getShurikenJutsu(),x + 8,y + 48, Color.RED.getRed());
            fr.drawString(matrixStack,"Summoning: " + data.getSummoning(),x +8,y + 58, Color.RED.getRed());
            fr.drawString(matrixStack,"Kinjutsu: " + data.getKinjutsu(),x + 8,y + 68, Color.RED.getRed());
            fr.drawString(matrixStack,"Senjutsu: " + data.getSenjutsu(),x + 8,y + 78, Color.RED.getRed());
            fr.drawString(matrixStack,"Medical: " + data.getHealth(),x + 8,y + 88, Color.RED.getRed());
            fr.drawString(matrixStack,"Speed: " + data.getSpeed(),x + 8,y + 98, Color.RED.getRed());
            fr.drawString(matrixStack,"Intelligence: " + data.getIntelligence(),x + 8,y + 108, Color.RED.getRed());


        });
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }



    public boolean doesGuiPauseGame() {
        return false;
    }
}