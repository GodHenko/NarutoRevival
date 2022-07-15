package com.godhenko.narutomod.data.capabilities;


import net.minecraft.entity.player.PlayerEntity;

public interface IData<T> {

    //Sync Data//
    void syncData(PlayerEntity player);

    //Chakra//
    void consumeChakra(int points);

    void fillChakra(int points);

    void setChakra(int amount);

    int getChakra();

    //Ninjutsu//
    void setNinjutsu(int health);
    int getNinjutsu();

    //Taijutsu//
    void setTaijutsu(int points);
    int getTaijutsu();


    //Genjutsu//
    void setGenjutsu(int points);
    int getGenjutsu();


    //Kenjutsu//
    void setKenjutsu(int points);
    int getKenjutsu();


    //ShurikenJutsu//
    void setShurikenJutsu(int points);
    int getShurikenJutsu();

    //Summoning//
    void setSummoning(int points);
    int getSummoning();

    //Kinjutsu//
    void setKinjutsu(int points);
    int getKinjutsu();

    //Senjutsu//
    void setSenjutsu(int points);
    int getSenjutsu();

    //Health//
    void setHealth(int points);
    int getHealth();

    //Medical//
    void setMedical(int points);
    int getMedical();

    //Speed//
    void setSpeed(int points);
    int getSpeed();
    void setMaxSpeed(int amount);
    int getMaxSpeed();

    //Intelligence//
    void setIntelligence(int points);
    int getIntelligence();


    //Level//
    void setLevel(int level);
    int getLevel();


    //Exp//
    void setExp(int exp);
    void addExp(int exp);
    void removeExp(int exp);
    int getExp();

    //Skillpoints//
    void setSkillpoints(int sp);
    int getSkillpoints();

    void setPlayerHealth(PlayerEntity player, float amount);
}