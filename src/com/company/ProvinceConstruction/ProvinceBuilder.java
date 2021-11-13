package com.company.ProvinceConstruction;
import java.util.ArrayList;
import java.util.Random;

/**
 * This file contains the implementation for the
 * Province Builder Class.
 * Responsibility: This Class is responsible for building all the
 * individual components of a Province by overriding the components from ProvinceBuilderLayout .
 */

public class ProvinceBuilder implements ProvinceBuilderLayout {
    /**
     * Instances Variables:
     * aiProvince: Province Object that represents the Ai Province
     * userProvince: Province Object that represents the User Province
     */
    private final Province aiProvince;
    private final Province userProvince;

    /*
    Constructor
     */
    public ProvinceBuilder() {
        this.aiProvince = new Province();
        this.userProvince = new Province();
    }


    /*
     * Builds the AiProvinceName, by picking a random province name
     * from a list of province names. Then sets the Ai Provinces' name to
     * that.
     */
    @Override
    public void buildAiProvinceName() {
        ArrayList<String> listOfProvinces = new ArrayList<>();
        listOfProvinces.add("Province1");
        listOfProvinces.add("Province2");
        listOfProvinces.add("Province3");
        listOfProvinces.add("Province4");

        ArrayList<Integer> listIndexVisited = indexVisited();

        if (listIndexVisited.contains(getIndex())){
            int value = getIndex();
            aiProvince.setAiProvinceName(listOfProvinces.get(value));
        }
        aiProvince.setAiProvinceName(listOfProvinces.get(getIndex()));
    }

    /*
     * Keeps Track of the index visited within buildAiProvinceName to avoid
     * assigning the same name to two provinces
     */
    public ArrayList<Integer> indexVisited(){
        ArrayList<Integer> listOfIndexVisited = new ArrayList<>();
        int index = getIndex();
        listOfIndexVisited.add(index);
        return listOfIndexVisited;
    }

    /*
     * Randomizes the index generation used the buildAiProvinceName.
     */
    private int getIndex() {
        Random rand = new Random();
        return rand.nextInt(3);
    }

    /**
     * Builds the name of the User Province
     * @param userProvinceName: Province name to be assigned to the User Province
     */
    @Override
    public void buildUserProvinceName(String userProvinceName) {
        userProvince.setUserProvinceName(userProvinceName);
    }

    /*
     * Builds the gold for both Ai and User Province
     */
    @Override
    public void buildProvinceGold() {
        aiProvince.setProvinceGold(randomProvinceGold());
        userProvince.setProvinceGold(randomProvinceGold());
    }

    /*
     * Builds the gold for both Ai and User Province
     */
    @Override
    public void buildProvinceCivilians() {
        aiProvince.setProvinceCivilians(randomProvinceCivilians());
        userProvince.setProvinceCivilians(randomProvinceCivilians());
    }

    /*
     * Builds the Soldiers for both Ai and User Province
     */
    @Override
    public void buildProvinceSoldiers() {
        aiProvince.setProvinceSoldiers(randomProvinceSoldiers());
        userProvince.setProvinceSoldiers(randomProvinceSoldiers());
    }

    /*
     * Builds the food for both Ai and User Province
     */
    @Override
    public void buildProvinceFood() {
        aiProvince.setProvinceFood(randomProvinceFood());
        userProvince.setProvinceFood(randomProvinceFood());
    }

    /**
     * Returns the Ai Province
     * @return: Ai Province Object
     */
    @Override
    public Province getAiProvince() {
        return this.aiProvince;
    }

    /**
     * Returns the User Province
     * @return: User Province Object
     */
    @Override
    public Province getUserProvince() {
        return this.userProvince;
    }

    /**
     * @return: Returns a randomized value for the province gold
     */
    public int randomProvinceGold(){
        return randomGenerator();
    }

    /**
     * @return: Returns a randomized value for the provinces' civilians
     */
    public int randomProvinceCivilians(){
        return randomGenerator();
    }

    /**
     * @return: Returns a randomized value for the provinces' soldiers
     */
    public int randomProvinceSoldiers(){
        return randomGenerator();
    }

    /**
     * @return: Returns a randomized value for the provinces' food
     */
    public int randomProvinceFood(){
        return randomGenerator();
    }

    /**
     * Returns the random generated values for Food, Gold, Civilians and Soldiers
     * within the range of 100 to 600
     * @return: randomized int, which represents the randomized values for
     * Food, Gold, Civilians and Soldiers
     */
    private int randomGenerator() {
        Random rand = new Random();
        return 100 + rand.nextInt(10) * 50;
    }

}