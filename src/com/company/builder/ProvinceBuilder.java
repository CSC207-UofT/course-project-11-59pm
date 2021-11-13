package com.company.builder;

//TODO: Add Documentation

import java.util.ArrayList;
import java.util.Random;

public class ProvinceBuilder implements ProvinceBuilderLayout {
    private Province p;
    private Province u;

    public ProvinceBuilder() {
        this.p = new Province();
        this.u = new Province();
//        reset();
    }

//    private void reset() {
//        p.setProvinceFood(0);
//        p.setAiProvinceName(null);
//        p.setProvinceSoldiers(0);
//        p.setProvinceGold(0);
//        p.setProvinceCivilians(0);
//    }


    @Override
    public void buildProvinceName() {
        ArrayList<String> listOfProvinces = new ArrayList<String>();
        listOfProvinces.add("a");
        listOfProvinces.add("b");
        listOfProvinces.add("c");
        listOfProvinces.add("d");

        Random rand = new Random();
        int index = rand.nextInt(listOfProvinces.size());
        String randomName = listOfProvinces.get(index); // 2

        listOfProvinces.remove(index);
        p.setAiProvinceName(randomName);
    }

    @Override
    public void buildUserProvinceName(String name) {
        u.setUserProvinceName(name);
    }

    @Override
    public void buildProvinceGold() {
        p.setProvinceGold(randomProvinceGold());
        u.setProvinceGold(randomProvinceGold());
    }

    @Override
    public void buildProvinceCivilians() {
        p.setProvinceCivilians(randomProvinceCivilians());
        u.setProvinceCivilians(randomProvinceCivilians());
    }

    @Override
    public void buildProvinceSoldiers() {
        p.setProvinceSoldiers(randomProvinceSoldiers());
        u.setProvinceSoldiers(randomProvinceSoldiers());
    }

    @Override
    public void buildProvinceFood() {
        p.setProvinceFood(randomProvinceFood());
        u.setProvinceFood(randomProvinceFood());
    }


    @Override
    public Province getAiProvince() {
        return this.p;
    }

    @Override
    public Province getUserProvince() {
        return this.u;
    }


    public int randomProvinceGold(){
        return extracted();
    }

    public int randomProvinceCivilians(){
        return extracted();
    }

    public int randomProvinceSoldiers(){
        return extracted();
    }

    public int randomProvinceFood(){
        return extracted();
    }

    private int extracted() {
        Random rand = new Random();
        int goldValue = 100 + rand.nextInt(10) * 50;
        return goldValue;
    }

}
