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
    private String raja;
    private String provinceName;
    private boolean IsPlayer;

    // Constructors
    public Provinces(int populationCount, String raja, String provinceName,
                     int money, boolean active, boolean IsPlayer){
        this.populationCount = populationCount;
        this.raja = raja;
        this.provinceName = provinceName;
        this.money = money;
        this.active = true;
        this.IsPlayer = false;
    }

    public int getPopulationCount() {
        return populationCount;
    }

    public boolean getAliveStatus(){
        return active;
    }

    public String getName(){ return this.provinceName; }

    public void changeStats(int attack){
        this.populationCount -= attack;
    }

}
