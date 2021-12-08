package main.java.province_construction;
import java.util.ArrayList;
import java.util.Random;

/**
 * This file contains the implementation for the ProvinceBuilder Class.
 * Responsibility: This Class is responsible for building all the individual
 * components of a Province by overriding the components from ProvinceBuilderLayout .
 */

public class ProvinceBuilder implements ProvinceBuilderLayout {
    /**
     *
     * aiProvince: Province Object that represents the Ai Province
     * userProvince: Province Object that represents the User Province
     */
    private final Province AI_PROVINCE;
    private final Province USER_PROVINCE;
    private static final ArrayList<Integer> LIST_INDEX_VISITED = new ArrayList<>();

    /*
    Constructor
     */
    public ProvinceBuilder() {
        this.AI_PROVINCE = new Province();
        this.USER_PROVINCE = new Province();
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
        int randomInt = indexVisited();
        AI_PROVINCE.setAiProvinceName(listOfProvinces.get(randomInt));

    }

    /*
     * Keeps Track of the index visited within buildAiProvinceName to avoid
     * assigning the same name to two provinces
     */
    public int indexVisited(){
        int randomIndex = getIndex();
        while(LIST_INDEX_VISITED.contains(randomIndex)) {
            randomIndex = getIndex();
        }
        LIST_INDEX_VISITED.add(randomIndex);
        return randomIndex;
    }

    /*
     * Randomizes the index generation used the buildAiProvinceName.
     */
    private int getIndex() {
        Random rand = new Random();
        return rand.nextInt(4);
    }

    /**
     * Builds the name of the User Province
     * userProvinceName: Province name to be assigned to the User Province
     */
    @Override
    public void buildUserProvinceName(String userProvinceName) {
        USER_PROVINCE.setUserProvinceName(userProvinceName);
    }

    /*
     * Builds the gold for both Ai and User Province
     */
    @Override
    public void buildProvinceGold() {
        AI_PROVINCE.setProvinceGold(randomProvinceGold());
        USER_PROVINCE.setProvinceGold(randomProvinceGold());
    }

    /*
     * Builds the gold for both Ai and User Province
     */
    @Override
    public void buildProvinceCivilians() {
        AI_PROVINCE.setProvinceCivilians(randomProvinceCivilians());
        USER_PROVINCE.setProvinceCivilians(randomProvinceCivilians());
    }

    /*
     * Builds the Soldiers for both Ai and User Province
     */
    @Override
    public void buildProvinceSoldiers() {
        AI_PROVINCE.setProvinceSoldiers(randomProvinceSoldiers());
        USER_PROVINCE.setProvinceSoldiers(randomProvinceSoldiers());
    }

    /*
     * Builds the food for both Ai and User Province
     */
    @Override
    public void buildProvinceFood() {
        AI_PROVINCE.setProvinceFood(randomProvinceFood());
        USER_PROVINCE.setProvinceFood(randomProvinceFood());
    }

    /**
     * Returns the Ai Province Object
     */
    @Override
    public Province getAI_PROVINCE() {
        return this.AI_PROVINCE;
    }

    /**
     * Returns the User Province
     */
    @Override
    public Province getUSER_PROVINCE() {
        return this.USER_PROVINCE;
    }

    /**
     * Returns a randomized value for the province gold
     */
    public int randomProvinceGold(){
        return randomGenerator();
    }

    /**
     * Returns a randomized value for the provinces' civilians
     */
    public int randomProvinceCivilians(){
        return randomGenerator();
    }

    /**
     * Returns a randomized value for the provinces' soldiers
     */
    public int randomProvinceSoldiers(){
        return randomGenerator();
    }

    /**
     * Returns a randomized value for the provinces' food
     */
    public int randomProvinceFood(){
        return randomGenerator();
    }

    /**
     * Returns the random generated values for Food, Gold, Civilians and Soldiers
     * within the range of 100 to 600
     * returns randomized int, which represents the randomized values for
     * Food, Gold, Civilians and Soldiers
     */
    private int randomGenerator() {
        Random rand = new Random();
        return 100 + rand.nextInt(10) * 50;
    }

}
