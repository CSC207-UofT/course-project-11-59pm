package com.company.builder;


import java.util.ArrayList;

public class ProvinceAssembler {
    private ProvinceBuilder provinceBuilder;

    public ProvinceAssembler(ProvinceBuilder provinceBuilder) {
        this.provinceBuilder = provinceBuilder;
//        reset();
    }

    public ProvinceAssembler() {
    }

//    public void reset() {
//        provinceBuilder.getAiProvince().setAiProvinceName(null);
//        provinceBuilder.getAiProvince().setProvinceSoldiers(0);
//        provinceBuilder.getAiProvince().setProvinceCivilians(0);
//        provinceBuilder.getAiProvince().setProvinceSoldiers(0);
//        provinceBuilder.getAiProvince().setProvinceFood(0);
//
//    }

    public Province getAiProvince(){
        return this.provinceBuilder.getAiProvince();
    }

    public Province getUserProvince(){
        return this.provinceBuilder.getUserProvince();
    }

    public void makeAiProvince(){
        this.provinceBuilder.buildProvinceName();
        this.provinceBuilder.buildProvinceGold();
        this.provinceBuilder.buildProvinceCivilians();
        this.provinceBuilder.buildProvinceSoldiers();
        this.provinceBuilder.buildProvinceFood();
    }

    public void makeUserProvince(String name){
        this.provinceBuilder.buildUserProvinceName(name);
        this.provinceBuilder.buildProvinceGold();
        this.provinceBuilder.buildProvinceCivilians();
        this.provinceBuilder.buildProvinceSoldiers();
        this.provinceBuilder.buildProvinceFood();
    }

    public ArrayList<Province> create(){
        ProvinceBuilder provinceBuilder = new ProvinceBuilder();
        ProvinceBuilder provinceBuilder2 = new ProvinceBuilder();
        ProvinceBuilder provinceBuilder3 = new ProvinceBuilder();
        ProvinceBuilder provinceBuilder4 = new ProvinceBuilder();

        ProvinceAssembler provinceAssembler  =  new ProvinceAssembler(provinceBuilder);
        ProvinceAssembler provinceAssembler2  =  new ProvinceAssembler(provinceBuilder2);
        ProvinceAssembler provinceAssembler3  =  new ProvinceAssembler(provinceBuilder3);
        ProvinceAssembler provinceAssembler4  =  new ProvinceAssembler(provinceBuilder4);

        provinceAssembler.makeAiProvince();
        provinceAssembler2.makeAiProvince();
        provinceAssembler3.makeAiProvince();
        provinceAssembler4.makeAiProvince();

        Province p1 = provinceAssembler.getAiProvince();
        Province p2 = provinceAssembler2.getAiProvince();
        Province p3 = provinceAssembler3.getAiProvince();
        Province p4 = provinceAssembler4.getAiProvince();

        ArrayList<Province> listAiProvinces = new ArrayList<Province>();
        listAiProvinces.add(p1);
        listAiProvinces.add(p2);
        listAiProvinces.add(p3);
        listAiProvinces.add(p4);

        return listAiProvinces;
    }
}

