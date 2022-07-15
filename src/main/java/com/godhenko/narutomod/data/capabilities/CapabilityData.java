package com.godhenko.narutomod.data.capabilities;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.tags.Tag;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;


import javax.annotation.Nullable;

public class CapabilityData {
    @CapabilityInject(IData.class)
    public static Capability<IData> ENTITY_DATA_CAPABILITY = null;
    public static void register() {
        CapabilityManager.INSTANCE.register(IData.class, new Storage(), Data::new);
    }
    public static class Storage implements Capability.IStorage<IData>{

        @Nullable
        @Override
        public INBT writeNBT(Capability<IData> capability, IData instance, Direction side) {
            CompoundNBT tag = new CompoundNBT();
            tag.putInt("Chakra", instance.getChakra());
            tag.putInt("Ninjutsu", instance.getNinjutsu());
            tag.putInt("Taijutsu", instance.getTaijutsu());
            tag.putInt("Genjutsu",instance.getGenjutsu());
            tag.putInt("Kenjutsu", instance.getKenjutsu());
            tag.putInt("ShurikenJutsu", instance.getShurikenJutsu());
            tag.putInt("Summoning", instance.getSummoning());
            tag.putInt("KinJutsu", instance.getKinjutsu());
            tag.putInt("Senjutsu", instance.getSenjutsu());
            tag.putInt("Health", instance.getHealth());
            tag.putInt("Speed", instance.getSpeed());
            tag.putInt("MaxSpeed", instance.getMaxSpeed());
            tag.putInt("Intelligence", instance.getIntelligence());
            tag.putInt("Level", instance.getLevel());
            tag.putInt("Exp", instance.getExp());
            tag.putInt("SkillPoints",instance.getSkillpoints());
            tag.putInt("Medical",instance.getMedical());
            return tag;
        }

        @Override
        public void readNBT(Capability<IData> capability, IData instance, Direction side, INBT nbt) {
            CompoundNBT tag = new CompoundNBT();
            instance.setChakra(tag.getInt("Chakra"));
            instance.setNinjutsu(tag.getInt("Ninjutsu"));
            instance.setTaijutsu(tag.getInt("Taijutsu"));
            instance.setGenjutsu(tag.getInt("Genjutsu"));
            instance.setKenjutsu(tag.getInt("Kenjutsu"));
            instance.setShurikenJutsu(tag.getInt("Shurikenjutsu"));
            instance.setSummoning(tag.getInt("Summoning"));
            instance.setKinjutsu(tag.getInt("Kinjutsu"));
            instance.setSenjutsu(tag.getInt("Senjutsu"));
            instance.setHealth(tag.getInt("Health"));
            instance.setSpeed(tag.getInt("Speed"));
            instance.setMaxSpeed(tag.getInt("MaxSpeed"));
            instance.setIntelligence(tag.getInt("Intelligence"));
            instance.setLevel(tag.getInt("Level"));
            instance.setExp(tag.getInt("Exp"));
            instance.setSkillpoints(tag.getInt("Skillpoints"));
            instance.setMedical(tag.getInt("Medical"));

        }
    }


}
