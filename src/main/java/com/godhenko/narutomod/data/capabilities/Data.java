package com.godhenko.narutomod.data.capabilities;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;

import java.util.Objects;

public class Data implements IData {

    private int chakra = 20;

    private int ninjutsu = 0;
    private int taijutsu = 0;
    private int genjutsu = 0;
    private int kenjutsu = 0;
    private int shurikenjutsu = 0;
    private int kinjutsu = 0;
    private int summoning = 0;
    private int senjutsu = 0;
    private int health = 20;
    private int speed = 0;



    private int medical = 0;
    private int maxSpeed = 20;
    private int intelligance = 0;
    private int level = 1;
    private int exp = 0;
    private int skillpoints = 0;

    @Override
    public void consumeChakra(int points)
    {
        this.chakra -= points;
        if (this.chakra < 0) this.chakra = 0;
    }

    @Override
    public void fillChakra(int points)
    {
        this.chakra += points;
    }

    @Override
    public void setChakra(int amount)
    {
        this.chakra = amount;
    }
    @Override
    public int getChakra() {
        return this.chakra;
    }

    @Override
    public void setNinjutsu(int points)
    {
        this.ninjutsu = points;
    }

    @Override
    public int getNinjutsu() {
        return this.ninjutsu;
    }

    @Override
    public void setTaijutsu(int points)
    {
        this.taijutsu = points;
    }

    @Override
    public int getTaijutsu()
    {
        return this.taijutsu;
    }

    @Override
    public void setGenjutsu(int points)
    {
        this.genjutsu = points;
    }

    @Override
    public int getGenjutsu()
    {
        return this.genjutsu;
    }

    @Override
    public void setKenjutsu(int points)
    {
        this.kenjutsu = points;
    }

    @Override
    public int getKenjutsu()
    {
        return this.kenjutsu;
    }

    @Override
    public void setShurikenJutsu(int points)
    {
        this.shurikenjutsu = points;
    }

    @Override
    public int getShurikenJutsu()
    {
        return this.shurikenjutsu;
    }

    @Override
    public void setSummoning(int points)
    {
        this.summoning = points;
    }

    @Override
    public int getSummoning()
    {
        return this.summoning;
    }

    @Override
    public void setKinjutsu(int points)
    {
        this.kinjutsu = points;
    }

    @Override
    public int getKinjutsu()
    {
        return this.kinjutsu;
    }

    @Override
    public void setSenjutsu(int points)
    {
        this.senjutsu = points;
    }

    @Override
    public int getSenjutsu()
    {
        return this.senjutsu;
    }
    @Override
    public void setMedical(int points) {
        this.medical = points;
    }
    @Override
    public int getMedical() {
        return this.medical;
    }


    @Override
    public void setHealth(int health)
    {
        this.health = health;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void setSpeed(int points)
    {
        this.speed = points;
    }

    @Override
    public int getSpeed() {
        return this.speed;
    }

    public void setMaxSpeed(int amount) {
        maxSpeed = (amount > 0 ? amount : 0);
    }

    @Override
    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    @Override
    public void setIntelligence(int points)
    {
        this.intelligance = points;
    }

    @Override
    public int getIntelligence()
    {
        return this.intelligance;
    }

    @Override
    public void setLevel(int level)
    {
        this.level = level;
    }

    @Override
    public int getLevel()
    {
        return this.level;
    }

    @Override
    public void setExp(int exp)
    {
        this.exp = exp;
    }

    @Override
    public void addExp(int exp)
    {
        this.exp = this.exp + exp;
    }

    @Override
    public void removeExp(int exp)
    {
        this.exp = this.exp - exp;
    }

    @Override
    public int getExp()
    {
        return this.exp;
    }

    @Override
    public void setSkillpoints(int sp)
    {
        this.skillpoints = sp;
    }

    @Override
    public int getSkillpoints()
    {
        return this.skillpoints;
    }

    public void syncData(PlayerEntity player){
    }

    public void setPlayerHealth(PlayerEntity player, float amount) {
        Objects.requireNonNull(player.getAttribute(Attributes.MAX_HEALTH)).applyPersistentModifier(new AttributeModifier("MaxHealth", amount, AttributeModifier.Operation.ADDITION));
    }
}
