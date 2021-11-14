package com.company.ProvinceConstruction;

import java.util.ArrayList;

/**
 * This file contains the implementation for the
 * Province Class.
 * Responsibility: The Province is responsible for representing a
 * Province Object that contains the attribute within a Province.
 *
 **/

public class Province implements ProvinceLayout {
    /**
     * Instances Variables:
     * userProvinceName: represents the name of the User Province
     * aiProvinceName: represents the name of the Ai Provinces.
     * provinceGold: represents the total money that the province has.
     * provinceCivilians: represents the total number of civilians in a province.
     * provinceSolider: represents the total number of soldiers in a province.
     * provinceFood: represents the total number of food in a province.
     */

    private String userProvinceName;
    private String aiProvinceName;
    private int provinceGold;
    private int provinceCivilians;
    private int provinceSoldiers;
    private int provinceFood;
    private ArrayList<Province> provincesCaptured;



    /**
     * Constructor
     */
    public Province() {
    }

    /**
     * Sets the name for the User Province
     * @param provinceName: Name of the User Province
     */
    @Override
    public void setUserProvinceName(String provinceName) {
        this.userProvinceName = provinceName;
    }

    /**
     * Sets the name for the Ai province
     * @param provinceName: Name of the Ai province
     */
    @Override
    public void setAiProvinceName(String provinceName) {
        this.aiProvinceName = provinceName;
    }

    /**
     * Sets the Total Gold for the province
     * @param provinceGold: Total gold for the province
     */
    @Override
    public void setProvinceGold(int provinceGold) {
        this.provinceGold = provinceGold;
    }

    /**
     * Sets the total number of civilians for the province
     * @param provinceCivilians: Total number of civilians in the province
     */
    @Override
    public void setProvinceCivilians(int provinceCivilians) {
        this.provinceCivilians = provinceCivilians;
    }

    /**
     * Sets the total number of soldiers for the province
     * @param provinceSoldiers: Total number of soldiers in the province
     */
    @Override
    public void setProvinceSoldiers(int provinceSoldiers) {
        this.provinceSoldiers = provinceSoldiers;
    }

    /**
     * Sets the total number of food units for the province
     * @param provinceFood: Total number of food units for the province.
     */
    @Override
    public void setProvinceFood(int provinceFood) {
        this.provinceFood = provinceGold;
    }

    /**
     * Gets the name for the User province
     * @return name of the User province
     */
    public String getUserProvinceName() {
        return userProvinceName;
    }

    /**
     * Gets the name for the Ai province
     * @return name of the Ai province
     */
    public String getAiProvinceName() {
        return aiProvinceName;
    }

    /**
     * Gets the Gold for the Province
     * @return Total Gold for the province.
     */
    public int getProvinceGold() {
        return provinceGold;
    }

    /**
     * Gets the totals number of Civilians in the province
     * @return number of civilians in the province
     */
    public int getProvinceCivilians() {
        return provinceCivilians;
    }

    /**
     * Gets the total number of Soldiers in the province
     * @return number of Soldiers in the province
     */
    public int getProvinceSoldiers() {
        return provinceSoldiers;
    }

    /**
     * Gets the total number of food units in the province
     * @return number of food units in the province
     */
    public int getProvinceFood() {
        return provinceFood;
    }

    public ArrayList<Province> getProvincesCaptured() {
        return provincesCaptured;
    }

    public void setProvincesCaptured(ArrayList<Province> provincesCaptured) {
        this.provincesCaptured = provincesCaptured;
    }
}
