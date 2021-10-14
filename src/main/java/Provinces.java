/**
 * This file contains the implementation for the
 * Province Interface.
 **/

package main.java;

public class Provinces {
    /*
    * Instances Variables
    */
    private boolean active = true;
    private int populationCount;
    private int money;// TODO: For now keeping it only to money
    private String raja = "OOGA BOOGA";

    // Constructors
    public Provinces(int count, String kingName, int money){
        this.populationCount = count;
        this.raja = kingName;
        this.money = money;
    }

    public int getPopulationCount() {
        return populationCount;
    }

    public boolean getAliveStatus(){
        return active;
    }

}
