package com.company.builder;

public class Province implements ProvinceLayout {

    private String userProvinceName;
    private String aiProvinceName;
    private int provinceGold;
    private int provinceCivilians;
    private int provinceSoldiers;
    private int provinceFood;

    public Province() {
//        reset();
    }

//    private void reset() {
//        this.userProvinceName = null;
//        this.aiProvinceName = null;
//        this.provinceGold = 0;
//        this.provinceCivilians = 0;
//        this.provinceSoldiers = 0;
//        this.provinceFood = 0;
//    }

    @Override
    public void setUserProvinceName(String provinceName) {
        this.userProvinceName = provinceName;
    }

    @Override
    public void setAiProvinceName(String provinceName) {
        this.aiProvinceName = provinceName;
    }

    @Override
    public void setProvinceGold(int provinceGold) {
        this.provinceGold = provinceGold;
    }

    @Override
    public void setProvinceCivilians(int provinceCivilians) {
        this.provinceCivilians = provinceCivilians;
    }

    @Override
    public void setProvinceSoldiers(int provinceSoldiers) {
        this.provinceSoldiers = provinceSoldiers;
    }

    @Override
    public void setProvinceFood(int provinceFood) {
        this.provinceFood = provinceGold;
    }

    public String getUserProvinceName() {
        return userProvinceName;
    }

    public String getAiProvinceName() {
        return aiProvinceName;
    }

    public int getProvinceGold() {
        return provinceGold;
    }

    public int getProvinceCivilians() {
        return provinceCivilians;
    }

    public int getProvinceSoldiers() {
        return provinceSoldiers;
    }

    public int getProvinceFood() {
        return provinceFood;
    }
}
