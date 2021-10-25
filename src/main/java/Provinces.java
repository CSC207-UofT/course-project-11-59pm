/**
 * This file contains the implementation for the
 * Provinces Class.
 * Responsibility: The Province is responsible for representing a
 * Provinces Object that contains the attribute within a Province.
 *
 **/

package main.java;

public class Provinces {
    /**
     * Instances Variables:
     * money: represents the total money that the province has.
     * civilians: represents the total number of civilians in a province.
     * solider: represents the total number of soldiers in a province.
     * food: represents the total number of food in a province.
     */
    private int gold;
    //TODO: Preset only for now. Until the implementation is done and running
    private int civilians = 100;
    private int soldiers = 100;
    private int food = 200;
    private final String provinceName;
    private final boolean IsPlayer = false;
    private final boolean active = true;

    /**
    * Constructor
    */
    public Provinces(String provinceName, int money, int civilians, int soldier, int food){
        this.provinceName = provinceName;
        this.gold = money;
        this.civilians = civilians;
        this.soldiers = soldier;
        this.food = food;

    //TODO: Delete the duplicate methods from the UserPlayer class.

    }
    /**
    * Get the total number of people in a province. The total population is the sum
     * of the civilians and soldiers in a province.
    */
    public int getTotalPopulation(){
        return this.civilians + this.soldiers;
    }

    /**
     * TODO: WRITE THE DOCUMENTATION!
     */
    public void changeStats(int death){
        this.soldiers -= death;
    }
    /**
     *  Getters and Setters for the Instance Variables
     */
    public int getCivilians() {
        return civilians;
    }

    public void setCivilians(int civilians) {
        this.civilians = civilians;
    }

    public int getSoldiers() {
        return soldiers;
    }

    public void setSoldiers(int soldiers) {
        this.soldiers = soldiers;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}

