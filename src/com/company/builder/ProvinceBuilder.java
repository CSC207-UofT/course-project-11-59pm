package com.company.builder;

//TODO: Add Documentation

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
        listOfProvinces.add("Province1");
        listOfProvinces.add("Province2");
        listOfProvinces.add("Province3");
        listOfProvinces.add("Province4");

        ArrayList<Integer> listIndexVisited = indexVisited();

        if (listIndexVisited.contains(getIndex())){
            int value = getIndex();
            p.setAiProvinceName(listOfProvinces.get(value));
        }
        p.setAiProvinceName(listOfProvinces.get(getIndex()));



//        ArrayList<Integer> listIndexVisited = indexVisited();
//        int value1 = getIndex();
//
//        if (listIndexVisited.contains(value1)){
//            value1 = getIndex();
//            p.setAiProvinceName(listOfProvinces.get(value1));
//        }
//        p.setAiProvinceName(listOfProvinces.get(getIndex()));
//
//

    }

//    private void removeIndex(ArrayList<String> listOfProvinces, ArrayList<Integer> listIndexVisited) {
//        for(int i: listIndexVisited){
//            listOfProvinces.remove(i);
//        }
//    }

    public ArrayList<Integer> indexVisited(){
        ArrayList<Integer> listOfIndexVisited = new ArrayList<Integer>();
        int index = getIndex();
        listOfIndexVisited.add(index);
        return listOfIndexVisited;
    }

    private int getIndex() {
        Random rand = new Random();
        int index = rand.nextInt(3);
        return index;
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
