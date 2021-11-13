package com.company.builder;

public interface ProvinceBuilderLayout {

    public void buildProvinceName();

    public void buildUserProvinceName(String name);

    public void buildProvinceGold();

    public void buildProvinceCivilians();

    public void buildProvinceSoldiers();

    public void buildProvinceFood();

    public Province getAiProvince();

    public Province getUserProvince();
}

