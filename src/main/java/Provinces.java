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
     * active: represents the status of the Province: alive or conquered.
     * money: represents the total money that the province has.
     * raja: represents the kings of the province.
     * provinceName: represents the Name of the province.
     * IsPlayer: represents whether the Province is owned by the Player.
    */
    private boolean active;
    private int populationCount;
    private int money;// TODO: For now keeping it only to money
    private String raja;
    private String provinceName;
    private boolean IsPlayer;

    /**
     * A new LoginController for the use case defined by the LoginInputBoundary
     */
    public Provinces(int populationCount, String raja, String provinceName,
                     int money, boolean active, boolean IsPlayer){
        this.populationCount = populationCount;
        this.raja = raja;
        this.provinceName = provinceName;
        this.money = money;
        this.active = true;
        this.IsPlayer = false;
    }

    /** Getter for the populationCount */
    public int getPopulationCount() {
        return populationCount;
    }
    /** Getter for the populationCount */
    public boolean getAliveStatus(){
        return active;
    }

    /** Getter for the getProvinceName=*/
    public String getName(){ return this.provinceName; }

    /**
     * change the stats for the given province after a Battle
     * @param attack //TODO: WHAT DOES ATTACK REPRESENTS?????
     * */
    public void changeStats(int attack){
        this.populationCount -= attack;
    }

}
