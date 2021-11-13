package com.company.builder;


public class ProvinceAssembler {
    private ProvinceBuilder provinceBuilder;

    public ProvinceAssembler(ProvinceBuilder provinceBuilder) {
        this.provinceBuilder = provinceBuilder;
//        reset();
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

    public void makeProvince(){
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

    }

