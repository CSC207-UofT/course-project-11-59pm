/**
 * This file contains the implementation for the
 * Province Interface.
 **/

package main.java;

public class Provinces {
    /*
    * Instances Variables
    */
    private boolean active;
    private int populationCount;
    private int money;// TODO: For now keeping it only to money
    private String raja = "OOGA BOOGA";
    private String name = "CANADA";

    // Constructors
    public Provinces(int populationCount, String raja, int money, boolean active){
        this.populationCount = populationCount;
        this.raja = raja;
        this.money = money;
        this.active = true;
    }

    public int getPopulationCount() {
        return populationCount;
    }

    public boolean getAliveStatus(){
        return active;
    }

    public String getName(){ return this.name; }

    public void changeStats(int attack){
        this.populationCount -= attack;
    }

}
